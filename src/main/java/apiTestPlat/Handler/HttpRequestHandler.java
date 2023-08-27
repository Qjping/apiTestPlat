package apiTestPlat.Handler;

import apiTestPlat.dataobject.vo1.CaseDetailVO;
import apiTestPlat.dataobject.vo1.CaseQueryVO;
import apiTestPlat.dataobject.vo1.CaseResultVO;
import apiTestPlat.dataobject.vo1.UserDefineParamVO;
import apiTestPlat.util.BusinessException;
import apiTestPlat.util.JsonUtil;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
@Slf4j
@Scope("request")
public class HttpRequestHandler extends RequestHandler {

    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private Map<String, String> userDefineParamMap = new HashMap();




    private CaseResultVO caseResultVO = new CaseResultVO();
    private CaseDetailVO caseDetailVO;

    public void excute(CaseDetailVO caseDetailVO){
        doHttpRequest(caseDetailVO);
    }

    public void doHttpRequest(CaseDetailVO caseDetailVO) {

        Request.Builder builder = new Request.Builder();
        Request request = null;
        String header = replaceParameters(caseDetailVO.getHeader());
        String url = replaceParameters(caseDetailVO.getUrl());
        String data = replaceParameters(caseDetailVO.getData());
        if (StringUtils.isNullOrEmpty(header)) {
            request = builder.url(caseDetailVO.getUrl()).get().build();
        }


        if(StringUtils.isNullOrEmpty(header)){
            header="accept: */*";
        }
        JSONObject headers=new JSONObject(header);


        headers.keySet().forEach(keys -> {
                    builder.header(keys, headers.getString(keys));
                }
        );
        if (!headers.has("Content-Type")) {
            request = builder.url(caseDetailVO.getUrl()).get().build();
        }
        RequestBody body=null;
        if(!StringUtils.isNullOrEmpty(data)){
            body = RequestBody.create(JSON,data);
        }
        switch (caseDetailVO.getMethod()) {
            case "POST": request = builder.url(url).post(body).build();break;
            case "PUT": request = builder.url(url).put(body).build();break;
            case "DELETE": request = builder.url(url).delete(body).build();break;
            default:request = builder.url(url).build();break;
        }
        try {
            //发送请求
            Response response = client.newCall(request).execute();
            String responseResult = response.body().string();
            log.info(responseResult.toString());
            url = response.request().url().toString();
            log.info(response.request().url().toString());
            CaseResultVO caseResultVO = new CaseResultVO();

            caseResultVO.setUrl(url);
            caseResultVO.setResponseResult(responseResult);
            caseResultVO.setCaseGroupId(caseDetailVO.getGroupId());
            caseResultVO.setCaseId(caseDetailVO.getId());
            caseResultVO.setMethod(caseDetailVO.getMethod());
            caseResultVO.setPath(caseDetailVO.getPath());
            caseResultVO.setHeader(response.request().headers().toString());
            caseResultVO.setHttpStatusCode(response.code());
            if ( response.request().body() !=null) {
                caseResultVO.setData(response.request().body().toString());
            }
            this.caseResultVO = caseResultVO;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public String replaceParameters(String string) {
        if (StringUtils.isNullOrEmpty(string)) {
            return string;
        }
        String str = "\\$\\{.*?}";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(string);
        while (m.find()) {
            //去全局变量map里查
            String newStr = m.group().replace("${", "").replace("}", "");
            log.info(userDefineParamMap.toString());
            if(userDefineParamMap.containsKey(newStr)){
                string = string.replace(m.group(), userDefineParamMap.get(newStr));
            }else {
                log.error("全局变量未有此变量："+string);
            }

        }
        return string.replaceAll("\r|\n", "");
    }







}

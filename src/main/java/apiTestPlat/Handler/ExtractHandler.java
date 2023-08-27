package apiTestPlat.Handler;

import apiTestPlat.dataobject.vo1.UserDefineParamVO;
import apiTestPlat.util.BusinessException;
import com.mysql.cj.util.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtractHandler extends AbstractHandler{
    @Override
    public void excute() {
        doExtraction();
    }
    public void doExtraction() throws BusinessException {
        String result =caseResultVO.getResponseResult();
        if(StringUtils.isNullOrEmpty( result)
                ||StringUtils.isNullOrEmpty(caseDetailVO.getExtract())
                ||caseResultVO.getHttpStatusCode()!=200
        ) {

            //todo 处理返回结果为空
            return this;
        }
        ;
        List<UserDefineParamVO> userDefineParamVOS = new ArrayList<>();
        UserDefineParamVO userDefineParamVO = new UserDefineParamVO();
        String extract = caseDetailVO.getExtract();
        //获得存储变量名及变量的path
        log.error(extract.toString());
        JSONObject extrats = new JSONObject(extract);
        try {
            extrats.toMap().forEach((paramName,paramValue)->{
                // 从返回结果中获取变量值fasjson
                if((JSONPath.read(result, (String) paramValue)!=null)){
                    String variableValue = JSONPath.extract(result,(String) paramValue).toString();
                    userDefineParamVO.setCaseGroupId(caseDetailVO.getGroupId());
                    userDefineParamVO.setParamName(paramName);
                    userDefineParamVO.setParamValue(variableValue);
                    userDefineParamVOS.add(userDefineParamVO);
                    userDefineParamMap.put(paramName, variableValue);
                }else {
                    log.error("提取路径不存在:"+caseDetailVO.getExtract()+"返回结果："+result);
                    //todo 处理jsonpath不存在
                }
            });
        }catch (Exception e){
            log.error("提取路径不存在:"+caseDetailVO.getExtract()+"返回结果："+result);
            log.error(e.getMessage());
        }


    }
}

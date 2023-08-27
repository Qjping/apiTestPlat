package apiTestPlat.Handler;

import apiTestPlat.dataobject.vo1.CaseDetailVO;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class AssertHandler extends AbstractHandler {

    @Override
    public void excute(CaseDetailVO caseDetailVO) {
        doAssert(caseDetailVO;
    }
    //断言处理
    public void doAssert(CaseDetailVO caseDetailVO)  {
//        JSONObject expecteds= jsonUtil.toEntity(caseDetailVO.getAssertions(),JSONObject.class);
        String resultResponce = caseResultVO.getResponseResult();

        if(caseResultVO.getHttpStatusCode()!=200
                || StringUtils.isNullOrEmpty( resultResponce)
                ||StringUtils.isNullOrEmpty(caseDetailVO.getAssertions())) {
            //todo 处理返回结果为空
            return;
        }
        JSONObject expecteds=new JSONObject((caseDetailVO.getAssertions()));
        log.info("断言规则:"+expecteds.toString());
        expecteds.keys().forEachRemaining(actualVaule->{
            expecteds.getString(actualVaule);
            if(JSONPath.extract(resultResponce,expecteds.getString(actualVaule))!=null) {
                String expectedValue = JSONPath.extract(resultResponce, expecteds.getString(actualVaule)).toString();
                String regex = "\\$\\{(.*?)\\}";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(expectedValue);
                if (m.find()) {
                    actualVaule = actualVaule.replace("${", "").replace("}", "");
                    if (!userDefineParamMap.get(actualVaule).equals(expectedValue)) {
                        log.info("assert匹配失败用例id:" + caseDetailVO.toString() + ",期望的值：" + expectedValue);
                    }
                    //               Assert.doAssert(CaseConfig.globalParam.get(expected), expecteds);
                } else {
                    if (!actualVaule.equals(expectedValue)) {
                        log.info("assert匹配失败用例id:" + caseDetailVO.toString() + ",期望的值：" + expectedValue);
                    }
                    //                Assert.doAssert(expecteds.getString(path), CaseConfig.globalParam.get(expected));
                }
            }else {
                log.error("断言值未找到:"+caseDetailVO.toString());
            }
        });
        return;
    }

}

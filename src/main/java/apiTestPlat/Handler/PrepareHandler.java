package apiTestPlat.Handler;

import apiTestPlat.dataobject.vo1.CaseDetailVO;
import apiTestPlat.dataobject.vo1.CaseQueryVO;
import apiTestPlat.dataobject.vo1.UserDefineParamVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrepareHandler extends AbstractHandler{
    List<UserDefineParamVO> userDefineParams;
    @Override
    public void excute(CaseDetailVO caseDetailVO) {
        initUserDefineParamMap(caseDetailVO);
    }

    public void initUserDefineParamMap(CaseDetailVO caseDetailVO){
        //查询自定义变量
        List<UserDefineParamVO> userDefineParams = userDefineParamRepository.seach(caseQueryVO);
        userDefineParamMap = userDefineParams.stream().collect(
                Collectors.toMap(UserDefineParamVO::getParamName, UserDefineParamVO::getParamValue, (key1, key2) -> key2)
        );
        return;
    }
}

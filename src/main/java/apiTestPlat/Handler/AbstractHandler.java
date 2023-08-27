package apiTestPlat.Handler;

import apiTestPlat.dataobject.vo1.CaseDetailVO;
import org.springframework.stereotype.Service;

@Service
public  abstract class AbstractHandler {

    public abstract void excute(CaseDetailVO caseDetailVO);

}

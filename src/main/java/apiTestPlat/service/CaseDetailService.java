package apiTestPlat.service;

import apiTestPlat.Handler.*;
import apiTestPlat.dataobject.vo1.CaseDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaseDetailService {


    public static Map<Integer,List<AbstractHandler>> abstractHandlersMap = new HashMap<>();

    @Autowired
    AssertHandler assertHandler;
    @Autowired
    RequestHandler requestHandler;

    @Autowired
    ExtractHandler extractHandler;

    @Autowired
    PrepareHandler prepareHandler;


    public void excute(CaseDetailVO caseDetailVO){
        abstractHandlersMap.get(1).forEach(abstractHandler1 -> {
            assertHandler.excute(caseDetailVO);
        });
    }


    public  void setHandler(){
        List<AbstractHandler> abstractHandler = new ArrayList<>();
        //api自动化
        abstractHandler.add(prepareHandler);
        abstractHandler.add(requestHandler);
        abstractHandler.add(extractHandler);
        abstractHandler.add(assertHandler);
        abstractHandlersMap.put(1,abstractHandler);

    }
}

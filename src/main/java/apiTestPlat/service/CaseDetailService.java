package apiTestPlat.service;

import apiTestPlat.Handler.*;
import apiTestPlat.dataobject.vo1.CaseDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseDetailService {


    public static List<AbstractHandler> abstractHandler = new ArrayList<>();

    @Autowired
    AssertHandler assertHandler;
    @Autowired
    RequestHandler requestHandler;

    @Autowired
    ExtractHandler extractHandler;

    @Autowired
    PrepareHandler prepareHandler;


    public void excute(CaseDetailVO caseDetailVO){
        abstractHandler.forEach(abstractHandler1 -> {
            assertHandler.excute();
        });
    }


    public  void setHandler(){
        abstractHandler.add(prepareHandler);
        abstractHandler.add(requestHandler);
        abstractHandler.add(extractHandler);
        abstractHandler.add(assertHandler);

    }
}

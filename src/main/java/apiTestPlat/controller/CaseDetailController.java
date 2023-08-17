package apiTestPlat.controller;

import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/case")
public class CaseDetailController {

//    private final CaseDetailService caseDetailService;
//
//    private final TransactionTemplate transactionTemplate;
//
//    public CaseDetailController(CaseDetailService caseDetailService, TransactionTemplate transactionTemplate) {
//        this.caseDetailService = caseDetailService;
//        this.transactionTemplate = transactionTemplate;
//    }
//
//
//    @GetMapping("search")
//    public ApiResultIDO<PageResultIDO<CaseDetailIDO>> searchList(CaseQueryIDO caseQueryIDO){
//        return null;
//    }
//    @GetMapping("detail")
//    public ApiResultIDO<CaseDetailIDO> searchDetail( @RequestParam(value = "id", required = false) Integer id){
//        return null;
//    }
//
//    @PostMapping("add")
//    public ApiResultIDO<Void> add(@RequestBody List<CaseDetailAddIDO> caseDetailAddIDO){
//
//        return ApiResultIDO.success();
//    }

//    @GetMapping("execute")
//    public ApiResultIDO<CaseReportIDO> execute(CaseQueryIDO caseQueryIDO){
//
//        return ApiResultIDO.success(caseDetailService.execute(caseQueryIDO));
//    }




}


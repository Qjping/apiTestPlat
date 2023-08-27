//package apiTestPlat;
//
//import lombok.extern.slf4j.Slf4j;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@Service
//
//@Slf4j
//public class LogAdvice {
//    private final static Logger logger = LoggerFactory.getLogger(LogAdvice.class);
//    private final int maxlength = 2480;
//
//    @Pointcut("@with(docow.annotation.ClassLogger)")
//    public void classLog(){
//
//    }
//    @Pointcut("@with(docow.annotation.MethodLoggerLog)")
//    public void methodLog(){
//
//    }
//
//    @Around(value = "classLog()||methodLog()")
//    public Object doAround(ProceedingJoinPoint point) throws Throwable {
//        final long beginTime = System.currentTimeMillis();
//        Object[] objs = point.getArgs();
//        if(null != objs&& objs.length>0&& objs[0] instanceof HttpServletRequest){
//            HttpServletRequest req = (HttpServletRequest) objs[0];
//            //后期加上userid
//            objs[0] = "HttpServletRequest";
//        }
//        if(null!=objs && objs.length>0){
//            for(int i=0;i<=objs.length;i++){
//                if(objs[i] instanceof HttpServletResponse){
//                    objs[i] = "HttpServletResponse";
//                }
//            }
//        }
//
//        String args = JSON.toJSONString(objs);
//        if(null != args && args.length()>this.maxlength){
//            args = args.substring(0,this.maxlength);
//        }
//        Object returnObj =null;
//
//        try {
//            returnObj =point.proceed();
//        } catch (final Throwable e) {
//            logger.warn("[apiTestPlat.LogAdvice.doAround] throwable=",e);
//            throw e;
//        }finally {
//            String returnStr = JSON.toJSONString(returnObj);
//            if(null!=returnStr&&returnStr.length()>this.maxlength){
//                returnStr = returnStr.substring(0,this.maxlength);
//            }
//            long timeUsed = System.currentTimeMillis() - beginTime;
//            logger.info("apiTestPlat.LogAdvice|{}|method:{}|cost:{}ms|args:{}|return{}",
//                    (timeUsed>3000?"timeOut":""), point.toLongString(),timeUsed,args,returnStr
//                    );
//        }
//        return returnObj;
//
//    }
//
//}

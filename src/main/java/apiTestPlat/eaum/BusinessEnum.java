package apiTestPlat.eaum;

public enum BusinessEnum  {
    ApiTest(1,"api自动话"),
    UiAutoTest(2,"UI自动化");

    private  Integer code;
    private  String message;

    BusinessEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}

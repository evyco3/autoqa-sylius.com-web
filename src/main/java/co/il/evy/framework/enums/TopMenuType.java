package co.il.evy.framework.enums;



public enum TopMenuType {
    REGISTER("Register"),

    LOGOUT("Logout"),
    LOGIN("Login"),
    MYACCOUNT("My account");


    private final String pageName;


    TopMenuType(String pageName) {
        this.pageName = pageName;
    }
    public String getPageName() {
        return pageName;
    }

}
package co.il.evy.framework.enums;

public enum SectionType {
    TSHIRT("T-Shirts"),
    JEANS("Jeans"),
    DRESSES("Dresses"),
    MEN("Men"),
    WOMEN("Women"),
    CAPS("Caps"),
    SIMPLE("Simple"),
    WITH_POMPONS("With pompons");


    private final String pageName;


    SectionType(String pageName) {
        this.pageName = pageName;
    }

    public String getPageName() {
        return pageName;
    }
}

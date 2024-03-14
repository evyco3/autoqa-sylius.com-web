package co.il.evy.framework.pages.fronend;


import co.il.evy.framework.pages.BasePage;
import co.il.evy.framework.pages.fronend.account.TopMenu;
import co.il.evy.framework.pages.fronend.product.CategoriesMenu;
import lombok.Getter;

@Getter
public final class HomePage extends BasePage {
   private final TopMenu topMenu;

    private final CategoriesMenu categoriesMenu;


    public HomePage() {
        super();
        this.topMenu = new TopMenu();
        this.categoriesMenu =new CategoriesMenu();
    }




}

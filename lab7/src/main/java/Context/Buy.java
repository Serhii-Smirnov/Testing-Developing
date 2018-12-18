package Context;

import PageObject.CheckOutPage;
import PageObject.ProductPage;

public class Buy {
    public static CheckOutPage Subm_buying_product(ProductPage page){

        return page.Submit_buying();
    }
}
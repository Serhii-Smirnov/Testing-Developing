package Context;

import Data.WrongDataExeption;
import Data.Data;
import PageObject.CheckOutPage;
import PageObject.LastPage;

import static Context.Init.field_init;

public class Order {
    public static LastPage init_cart(CheckOutPage page, Data data)throws WrongDataExeption {
        return field_init(page,data);
    }
}
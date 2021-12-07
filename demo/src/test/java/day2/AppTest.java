package day2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{

    @Test
    public void testAdd() {
     Cart test_cardadd = new Cart();
     test_cardadd.cartAdd("apple, banana, apple");
     assertTrue(test_cardadd.numItems() == 1);
    }

    @Test
    public void testDelete() {
        Cart test_cardadd = new Cart();
        test_cardadd.cartAdd("apple, banana, apple");
        test_cardadd.cartDelete(1);
        assertTrue(test_cardadd.numItems() == 0); 
    }
}

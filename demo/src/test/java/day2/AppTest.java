package day2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAdd() {
     Cart test_cardadd = new Cart();
     test_cardadd.cartAdd("apple, banana, apple");
     assertTrue(test_cardadd.numItems() == 2);
    }

    @Test
    public void testDelete() {
        Cart test_cardadd = new Cart();
        test_cardadd.cartAdd("apple, banana, apple");
        test_cardadd.cartDelete(1);
        assertTrue(test_cardadd.numItems() == 1); 
    }
}

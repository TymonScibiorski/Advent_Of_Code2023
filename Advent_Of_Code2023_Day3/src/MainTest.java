import org.junit.Assert;
import org.junit.Test;

public class MainTest {

//    @Test
//    void TestMain() {
//    }

    @Test
    public void TestingIsASymbol(){
        Assert.assertFalse(Main.IsASymbol("1"));
        Assert.assertFalse(Main.IsASymbol("2"));
        Assert.assertFalse(Main.IsASymbol("3"));
        Assert.assertFalse(Main.IsASymbol("4"));
        Assert.assertFalse(Main.IsASymbol("5"));
        Assert.assertFalse(Main.IsASymbol("6"));
        Assert.assertFalse(Main.IsASymbol("7"));
        Assert.assertFalse(Main.IsASymbol("8"));
        Assert.assertFalse(Main.IsASymbol("9"));
        Assert.assertFalse(Main.IsASymbol("0"));
        Assert.assertFalse(Main.IsASymbol("."));
        Assert.assertFalse(Main.IsASymbol("^"));
        Assert.assertFalse(Main.IsASymbol("!"));
        Assert.assertFalse(Main.IsASymbol("("));
        Assert.assertFalse(Main.IsASymbol(")"));

        Assert.assertTrue(Main.IsASymbol("@"));
        Assert.assertTrue(Main.IsASymbol("#"));
        Assert.assertTrue(Main.IsASymbol("$"));
        Assert.assertTrue(Main.IsASymbol("%"));
        Assert.assertTrue(Main.IsASymbol("&"));
        Assert.assertTrue(Main.IsASymbol("*"));
        Assert.assertTrue(Main.IsASymbol("-"));
        Assert.assertTrue(Main.IsASymbol("+"));
        Assert.assertTrue(Main.IsASymbol("="));
    }

    @Test
    public void TestingIsANumber(){
        Assert.assertTrue(Main.IsANumber("0"));
        Assert.assertTrue(Main.IsANumber("1"));
        Assert.assertTrue(Main.IsANumber("2"));
        Assert.assertTrue(Main.IsANumber("3"));
        Assert.assertTrue(Main.IsANumber("4"));
        Assert.assertTrue(Main.IsANumber("5"));
        Assert.assertTrue(Main.IsANumber("6"));
        Assert.assertTrue(Main.IsANumber("7"));
        Assert.assertTrue(Main.IsANumber("8"));
        Assert.assertTrue(Main.IsANumber("9"));
        Assert.assertTrue(Main.IsANumber("10"));
        Assert.assertTrue(Main.IsANumber("999"));

        Assert.assertFalse(Main.IsANumber("asdf"));
        Assert.assertFalse(Main.IsANumber("--"));
        Assert.assertFalse(Main.IsANumber("="));
        Assert.assertFalse(Main.IsANumber("a"));
        Assert.assertFalse(Main.IsANumber("99-99"));
        Assert.assertFalse(Main.IsANumber("99-98"));
        Assert.assertFalse(Main.IsANumber("dsfasdfas 45546456 sadfasdfadsfgas"));
        Assert.assertFalse(Main.IsANumber("[]"));
    }
}

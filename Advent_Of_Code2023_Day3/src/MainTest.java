import org.junit.Assert;
import org.junit.Test;

class MainTest {

//    @Test
//    void TestMain() {
//    }

    @Test
    void TestingIsASymbol(){
        Assert.assertFalse(Main.IsASymbol("9"));
        Assert.assertFalse(Main.IsASymbol("."));
        Assert.assertTrue(Main.IsASymbol("@"));
    }

}

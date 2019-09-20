import com.liyang.commons.Factory;
import org.junit.Test;

/*
 *@author:李洋
 *@date:2019/7/28 17:14
 */
public class TestSomeThing {
    @Test
    public void TestConnection(){
        System.out.println(Factory.getSession());
    }
}

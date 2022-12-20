import com.teldrasill.pojo.Goods;
import com.teldrasill.service.CartService;
import com.teldrasill.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class MyTest
{
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//            CartService cartServiceImpl = (CartService) context.getBean("CartServiceImpl");
//            List<Map<String, Object>> maps = cartServiceImpl.selectCart(1);
//            for(Map<String, Object> map : maps)
//            {
//                for(Map.Entry<String, Object> entry : map.entrySet())
//                {
//                    System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
//                }
//            }
//            GoodsService goodsServiceImpl = (GoodsService) context.getBean("GoodsServiceImpl");
//            for(Goods goods : goodsServiceImpl.queryAllGoods())
//            {
//                System.out.println(goods);
//            }
//        }
    }


}

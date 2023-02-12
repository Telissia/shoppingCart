import com.teldrasill.pojo.Buser;
import com.teldrasill.pojo.Goods;
import com.teldrasill.service.CartService;
import com.teldrasill.service.GoodsService;
import com.teldrasill.service.UserService;
import com.teldrasill.util.MyUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest
{
    @Test
    public void test()
    {
        //获取Spring下全部的配置文件
        //拿到所有的Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //将注册的Bean拿出来
//            CartService cartServiceImpl = (CartService) context.getBean("CartServiceImpl");
//            List<Map<String, Object>> maps = cartServiceImpl.selectCart(1);
//            for(Map<String, Object> map : maps)
//            {
//                for(Map.Entry<String, Object> entry : map.entrySet())
//                {
//                    System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
//                }
//            }
        GoodsService goodsServiceImpl = (GoodsService) context.getBean("goodsServiceImpl");
        assertNotNull(goodsServiceImpl.queryAllGoods());
//          Goods goods = new Goods();
//          goods.setId(23);
//          goods.setGname("222");
//          goods.setGoodstype_id(1);
//          goods.setGpicture("111");
//          goods.setGoprice(123);
//          goods.setGrprice(432);
//          assertEquals(1,goodsServiceImpl.addGoods(goods));
//          assertEquals(1,goodsServiceImpl.deleteAGoods(24));
//        Goods goods = new Goods();
//        goods.setId(24);
//        goods.setGname("333");
//        goods.setGoodstype_id(1);
//        goods.setGpicture("111");
//        goods.setGoprice(123);
//        goods.setGrprice(432);
//        assertEquals(1,goodsServiceImpl.updateGoodsById(goods));
        CartService cartServiceImpl = (CartService) context.getBean("cartServiceImpl");
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("uid", 1);
//        map.put("gid",1);
//        map.put("shoppingnum", 293);
//        assertNotNull(cartServiceImpl.putCart(map));
        assertNotNull(cartServiceImpl.selectCart(1));
        UserService userServiceImpl = (UserService) context.getBean("userService");
//        Buser buser = new Buser();
//        buser.setId(2);
//        buser.setBemail("2237890@swansea.ac.uk");
//        buser.setBpwd("123324325346");
//        assertEquals(1,userServiceImpl.register(buser));
        Buser buser = new Buser();
        buser.setBemail("2237890@swansea.ac.uk");
        buser.setBpwd("123324325346");
        assertNotNull(userServiceImpl.login(buser));

        String s = MyUtil.getStringID();
        assertEquals("202302011436118",s);
        System.out.println(s);

    }


}

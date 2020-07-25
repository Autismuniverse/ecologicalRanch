//package redis;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisTest {
//
//    @Autowired
//    private JedisPool jedisPool;
//
////    private SaveRssiServiceImpl saveRssiService = new SaveRssiServiceImpl();
//
////    @Test
////    public void test() {
////        saveRssiService.getAll();
////    }
//
//    @Test
//    public void JedisPoolTest() {
//
//        try (Jedis jedis = jedisPool.getResource()) {
//            System.out.println("连接成功");
//            System.out.println(jedis.get("*"));
//        } catch (Exception e) {
//            System.out.println("连接异常" + e.getMessage());
//        }
//    }
//}

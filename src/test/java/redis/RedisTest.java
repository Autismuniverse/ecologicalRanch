//package redis;
//
//import com.ecologicalRanch.project.entity.Livestock;
//import com.ecologicalRanch.project.service.LivestockService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.test.context.junit4.SpringRunner;
//import redis.clients.jedis.JedisPool;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisTest {
//
//    @Autowired
//    private JedisPool jedisPool;
//    @Autowired
//    private LivestockService livestockService;
//
////    private SaveRssiServiceImpl saveRssiService = new SaveRssiServiceImpl();
//
////    @Test
////    public void test() {
////        saveRssiService.getAll();
////    }
//    @Test
//    @Async
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void pedometer(){
//        List<Livestock> livestockList =livestockService.selectLivestockListNoPageHelper(new Livestock());
//        System.out.println(livestockList);
//    //        stepService.insertStep();
//    //        System.out.println("记录每只鸡的步数到步数表");
//    }
//
////    @Test
////    public void JedisPoolTest() {
////
////        try (Jedis jedis = jedisPool.getResource()) {
////            System.out.println("连接成功");
////            System.out.println(jedis.get("*"));
////        } catch (Exception e) {
////            System.out.println("连接异常" + e.getMessage());
////        }
////    }
//}

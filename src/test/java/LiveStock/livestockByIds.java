//package LiveStock;
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
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class livestockByIds {
//
//    @Autowired
//    private LivestockService livestockService;
//
//    @Test
//    @Async
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void pedometer(){
//        System.out.println("执行定时器");
//        List<Livestock> livestockList =livestockService.selectLivestockListNoPageHelper(new Livestock());
//        System.out.println(livestockList);
//        //        stepService.insertStep();
//        //        System.out.println("记录每只鸡的步数到步数表");
//    }
//
//
//
//
//}

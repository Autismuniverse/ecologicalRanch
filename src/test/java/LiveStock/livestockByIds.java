package LiveStock;

import com.ecologicalRanch.project.service.FieldService;
import com.ecologicalRanch.project.service.LivestockService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class livestockByIds {

    @Resource
    LivestockService livestockService;
    @Resource
    FieldService fieldService;

    @Test
    public void ls(){

        Long a = (long)202001351;
//        Livestock livestock = new Livestock();
//        System.out.println(a);
//        livestockService.selectLivestockById(a);
//        System.out.println(a);
//
//        System.out.println(fieldService.selectFieldById());

    }

//    @Test
//    public void test(){
//        System.out.println("nihao ");
//    }
}

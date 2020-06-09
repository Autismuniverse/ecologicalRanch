package LiveStock;

import com.ecologicalRanch.project.service.Impl.LivestockServiceImpl;
import org.junit.jupiter.api.Test;

public class livestockByIds {
    private LivestockServiceImpl livestockService = new LivestockServiceImpl();

    @Test
    public void ls(){
        livestockService.selectLivestockListByIds("202001282,202001283");
    }
}

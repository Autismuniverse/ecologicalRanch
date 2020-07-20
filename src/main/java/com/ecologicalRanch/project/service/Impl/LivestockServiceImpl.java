package com.ecologicalRanch.project.service.Impl;


import com.ecologicalRanch.common.utils.Days;
import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Discount;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.entity.Price;
import com.ecologicalRanch.project.mapper.DiscountMapper;
import com.ecologicalRanch.project.mapper.LivestockMapper;
import com.ecologicalRanch.project.mapper.PriceMapper;
import com.ecologicalRanch.project.service.LivestockService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author u-fun
 * @date '2019-12-31 15:23:10'
 */
@Service
public class LivestockServiceImpl implements LivestockService {

    @Autowired
    private LivestockMapper livestockMapper;
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private DiscountMapper discountMapper;

    /**
     * 通过Id查询 Livestock
     */
    @Override
    public Livestock selectLivestockById(Long livestockId) {
        return livestockMapper.selectLivestockById(livestockId);
    }

    /**
     * 查询Livestock列表
     */

    @Override
    public List<Livestock> selectLivestockList(Livestock livestock, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> livestockMapper.selectLivestockList(livestock));
    }

    /**
     * 查询Livestock列表
     */

    @Override
    public List<Livestock> selectLivestockListNoPageHelper(Livestock livestock) {
        return livestockMapper.selectLivestockList(livestock);
    }

    /**
     * 通过Ids查询Livestock列表
     */

    @Override
    public List<Livestock> selectLivestockListByIds(String livestockIds) {
        return livestockMapper.selectLivestockListByIds(Convert.toStrArray(livestockIds));
    }

    /**
     * 新增Livestock
     */
    @Override
    public int insertLivestock(Livestock livestock) {
        return livestockMapper.insertLivestock(livestock);
    }

    /**
     * 通过id删除Livestock
     */
    @Override
    public int deleteLivestockById(Long livestockId) {
        return livestockMapper.deleteLivestockById(livestockId);
    }

    /**
     * 通过id批量删除Livestock
     */
    @Override
    public int deleteLivestockByIds(String livestockIds) {
        return livestockMapper.deleteLivestockByIds(Convert.toStrArray(livestockIds));
    }

    /**
     * 修改Livestock信息
     */
    @Override
    public int updateLivestock(Livestock livestock) {
        return livestockMapper.updateLivestock(livestock);
    }

    /**
     * 模糊查询 Livestock
     */
    @Override
    public List<Livestock> fuzzyLivestockList(Livestock livestock, int pageNum, int pageSize) {

        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> livestockMapper.fuzzyLivestockList(livestock));

    }

    /**
     * 查询Livestock步數列表
     */

    @Override
    public List<Livestock> selectStep(Livestock livestock, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> livestockMapper.selectStep(livestock));
    }

    /**
     * 查询Livestock品种列表
     */

    @Override
    public List<Livestock> selectOutTime(Livestock livestock) {
        return livestockMapper.selectOutTime(livestock);
    }

    /**
     * 修改Livestock信息
     */
    @Override
    public int updateLivestockStep(Livestock livestock) {
        livestockMapper.selectLivestockList(livestock).forEach(s -> livestock.setStepNum(s.getStepNum() + livestock.getStepNum()));
        return livestockMapper.updateLivestock(livestock);
    }


    /**
     * 查询价格
     *
     * @param livestockIds
     * @return
     */

    @Override
    public  Map<String,Double> selectLivestockPrice(String livestockIds) {
        List<Price> priceList = priceMapper.selectPriceList(new Price());

        StringBuffer stringBuffer = new StringBuffer();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Map<String,Double> map = new HashMap<>();

        for (Livestock s : selectLivestockListByIds(livestockIds)) {
            for (Price p : priceList) {
                if (s.getFieldId().equals(p.getFieldId()) && s.getType().equals(p.getType())) {
//
                    Discount discount = discountMapper.selectDiscountByFieldId(p.getFieldId());
                    double nowDis = 0;

                    System.out.println("获取的折扣id："+discount.getPredeterminedDiscountId());

                    switch (Days.differentDays(df.format(day), df.format(s.getOutTime()))/30){
                        case 0: nowDis = discount.getFirstMonth(); break;
                        case 1: nowDis = discount.getSecondMonth(); break;
                        case 2: nowDis = discount.getThirdMonth(); break;
                        case 3: nowDis = discount.getFourthMonth(); break;
                        case 4: nowDis = discount.getFifthMonth(); break;
                        case 5: nowDis = discount.getSixthMonth(); break;
                        case 6: nowDis = discount.getSeventhMonth(); break;
                        case 7: nowDis = discount.getEighthMonth(); break;
                        case 8: nowDis = discount.getNinthMonth(); break;
                        case 9: nowDis = discount.getTenthMonth(); break;
                        case 10: nowDis = discount.getEleventhMonth(); break;
                        case 11: nowDis = discount.getTwelfthMonth(); break;
                        default: nowDis = 1;break;
                    }

                    stringBuffer.append(s.getLivestockId().toString()).append(":")
                            .append(p.getOriginalPrice() * nowDis).append(",");
                    map.put(s.getLivestockId().toString(),p.getOriginalPrice() * nowDis);

                    System.out.println(stringBuffer);



                }

            }
        }

//        return Convert.toStrArray(stringBuffer.toString());
        return map;
    }


    /**
     * 根据养殖场id查询Livestock步数排名列表
     *
     * @param fieldId
     * @return
     */
    @Override
    public List<Livestock> selectLivestockListRank(Long fieldId) {
        return livestockMapper.selectLivestockListRank(fieldId);
    }
}

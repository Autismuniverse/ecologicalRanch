package com.ecologicalRanch.project.service.Impl;


import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.entity.Price;
import com.ecologicalRanch.project.mapper.LivestockMapper;
import com.ecologicalRanch.project.mapper.PriceMapper;
import com.ecologicalRanch.project.service.LivestockService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-31 15:23:10'
 */
@Service
public class LivestockServiceImpl implements LivestockService {

    @Autowired
    private LivestockMapper livestockMapper;
    @Autowired
    private PriceMapper priceMapper;

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
        livestockMapper.selectLivestockList(livestock).forEach(s->livestock.setStepNum(s.getStepNum()+livestock.getStepNum()));
        return livestockMapper.updateLivestock(livestock);
    }


    /**
     * 查询价格
     * @param livestockIds
     * @return
     */
    @Override
    public String selectLivestockPrice(String livestockIds) {
        List<Price> priceList = priceMapper.selectPriceList(new Price());
        StringBuffer stringBuffer = new StringBuffer();

        for (Livestock s : selectLivestockListByIds(livestockIds)) {
//            stringBuffer.append(s.getLivestockId() + ":");
            for (Price p : priceList)
                if (s.getFieldId().equals(p.getFieldId()) && s.getType().equals(p.getType()))
                    stringBuffer.append(p.getOriginalPrice() + ",");
            }
            return stringBuffer.toString();
        }

    /**
     * 根据养殖场id查询Livestock步数排名列表
     * @param fieldId
     * @return
     */
    @Override
    public List<Livestock> selectLivestockListRank(Long fieldId){
        return livestockMapper.selectLivestockListRank(fieldId);
    }
}

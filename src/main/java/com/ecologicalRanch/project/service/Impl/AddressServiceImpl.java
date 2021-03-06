package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Address;
import com.ecologicalRanch.project.mapper.AddressMapper;
import com.ecologicalRanch.project.service.AddressService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 16:49:45'
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 通过Id查询 Address
     */
    @Override
    public Address selectAddressById(Long addressId) {
        return addressMapper.selectAddressById(addressId);
    }

    /**
     * 查询Address列表
     */

    @Override
    public List<Address> selectAddressList(Address address,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->addressMapper.selectAddressList(address));
    }

    /**
     * 新增Address
     */
    @Override
    public int insertAddress(Address address) {
        return addressMapper.insertAddress(address);
    }

    /**
     * 通过id删除Address
     */
    @Override
    public int deleteAddressById(Long addressId) {
        return addressMapper.deleteAddressById(addressId);
    }

    /**
     * 通过id批量删除Address
     */
    @Override
    public int deleteAddressByIds(String addressIds){
        return addressMapper.deleteAddressByIds(Convert.toStrArray(addressIds));
    }

    /**
     * 修改Address信息
     */
    @Override
    public int updateAddress(Address address) {
        if (address.isAddressStatus()==true)addressMapper.updateDefaultAddress(address);
        return addressMapper.updateAddress(address);
    }

    /**
     * 通过userId查询默认Address
     */
    @Override
    public Address selectDefaultAddressByUserId(Address address) {
        return addressMapper.selectDefaultAddressByUserId(address);
    }

    /**
     * 通过userId查询默认Address else
     */
    @Override
    public Address selectDefaultAddressByUserIdElse(Address address) {
        return addressMapper.selectDefaultAddressByUserIdElse(address);
    }

    /**
     * user更改默认地址 Address
     */
    @Override
    public int updateDefaultAddress(Address address){
        addressMapper.updateDefaultAddress(address);
        return addressMapper.updateAddress(address);
    }

}


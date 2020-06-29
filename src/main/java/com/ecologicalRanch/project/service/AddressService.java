package com.ecologicalRanch.project.service;


import com.ecologicalRanch.project.entity.Address;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 16:49:45'
 */
public interface AddressService {

    /**
     * 查询Address列表
     */
    List<Address> selectAddressList(Address address, int pageNum, int pageSize);

    /**
     * 通过Id查询 Address
     */
    Address selectAddressById(Long addressId);

    /**
     * 新增Address
     */
    int insertAddress(Address address);

    /**
     * 通过id删除Address
     */
    int deleteAddressById(Long addressId);

    /**
     * 通过id批量删除Address
     */
    int deleteAddressByIds(String addressIds);

    /**
     * 修改Address信息
     */
    int updateAddress(Address address);

    /**
     * 通过userId查询默认Address
     */
    Address selectDefaultAddressByUserId(Address address);

    /**
     * 通过userId查询默认Address else
     */
    Address selectDefaultAddressByUserIdElse(Address address);

    /**
     * 用户更改默认地址
     * @param address
     * @return
     */
    int updateDefaultAddress(Address address);
}


package com.ecologicalRanch.project.mapper;


import com.ecologicalRanch.project.entity.Address;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 16:49:45'
 */
public interface AddressMapper {

    /**
     * 查询Address列表
     * @param address 查询对象
     * @return 查询列表
     */
    List<Address> selectAddressList(Address address);

    /**
     * 通过Id查询 Address
     * @param addressId 查询Id
     * @return 查询对象
     */
    Address selectAddressById(Long addressId);

    /**
     * 新增Address
     * @param address 新增对象
     * @return 插入行数
     */
    int insertAddress(Address address);

    /**
     * 修改Address信息
     * @param  address 用户对象
     * @return 更新行数
     */
    int updateAddress(Address address);

    /**
     * 通过id删除Address
     * @param addressId 删除id
     * @return 删除行数
     */
    int deleteAddressById(Long addressId);

    /**
     * 通过id批量删除Address
     * @param addressIds 删除ids
     * @return 删除行数
     */
    int deleteAddressByIds(String[] addressIds);

    /**
     * 通过userId查询默认 Address
     * @param address 里面的查询Id
     * @return 查询对象
     */
    Address selectDefaultAddressByUserId(Address address);

    /**
     * 通过userId查询默认 Address
     * @param address 里面的查询Id
     * @return 查询对象
     */
    Address selectDefaultAddressByUserIdElse(Address address);
}


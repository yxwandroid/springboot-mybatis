package com.wilson.nfc.mapper;

import com.wilson.nfc.model.Shipping;

public interface ShippingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_shipping
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_shipping
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insert(Shipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_shipping
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insertSelective(Shipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_shipping
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    Shipping selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_shipping
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKeySelective(Shipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_shipping
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKey(Shipping record);
}
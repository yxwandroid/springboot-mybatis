package com.wilson.nfc.mapper;

import com.wilson.nfc.model.Order;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_order
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_order
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_order
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_order
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_order
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_order
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKey(Order record);
}
package com.wilson.nfc.mapper;

import com.wilson.nfc.model.Cart;

public interface CartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_cart
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_cart
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insert(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_cart
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insertSelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_cart
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    Cart selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_cart
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_cart
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKey(Cart record);
}
package com.wilson.nfc.mapper;

import com.wilson.nfc.model.PayInfo;

public interface PayInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_pay_info
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_pay_info
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insert(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_pay_info
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insertSelective(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_pay_info
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_pay_info
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKeySelective(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_pay_info
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKey(PayInfo record);
}
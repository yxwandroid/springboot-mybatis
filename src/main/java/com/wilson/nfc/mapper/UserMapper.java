package com.wilson.nfc.mapper;

import com.wilson.nfc.model.Product;
import com.wilson.nfc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_user
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_user
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_user
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_user
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_user
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nfc_user
     *
     * @mbggenerated Thu Jun 21 21:30:20 CST 2018
     */
    int updateByPrimaryKey(User record);


    /**
     * 检查用户名
     * @param userName
     * @return
     */
    int checkUserName(String userName);

    /**
     * 检查密码
     * @param password
     * @return
     */
    int checkPassword(String password);


    /**
     * 查询所以用户
     * @return
     */
    List<User> selectList();


    /**
     * 登录查询
     * @param username
     * @param password
     * @return
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);




}
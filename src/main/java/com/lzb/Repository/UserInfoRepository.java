package com.lzb.Repository;


import com.lzb.model.userInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface  UserInfoRepository extends JpaRepository<userInfo,Integer> {

    List<userInfo> findByUserNameContaining(String userName);//模糊查询关键字，like不很给力，用Containing

    userInfo findById(int id);

    userInfo findByUserName(String userName);

    userInfo findByEmail(String email);

    userInfo findByPhone(int phone);

    @Transactional
    @Modifying
    @Query(value = "update user_info set user_name = ?1 where id = ?2" , nativeQuery = true)//nativeQuery清除缓存数据。自动清除实体里保存的数据。
    int updateUserNameById(String userName, int id);



}

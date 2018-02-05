package com.meiya.model.meiyamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2017/12/8 下午5:26
 */
@Entity(name = "meiya_customer")
public class Customer {

    @Id
    String phone;  // 手机号

    String o2o; // 来源:online or offline

    String gift_type;  // 用户领取券类别（A B C）

    Integer joined;  // 是否已领取   1：领取  0：未领取

    Timestamp joined_time; // 领取时间


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getO2o() {
        return o2o;
    }

    public void setO2o(String o2o) {
        this.o2o = o2o;
    }

    public String getGift_type() {
        return gift_type;
    }

    public void setGift_type(String gift_type) {
        this.gift_type = gift_type;
    }

    public Integer getJoined() {
        return joined;
    }

    public Timestamp getJoined_time() {
        return joined_time;
    }

    public void setJoined_time(Timestamp joined_time) {
        this.joined_time = joined_time;
    }

    public void setJoined(Integer joined) {
        this.joined = joined;
    }
}

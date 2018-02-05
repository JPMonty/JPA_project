package com.meiya.controller;

import com.meiya.model.meiyamodel.ResultMessage;
import com.meiya.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shuyun on 2017/7/10.
 */
@Controller
public class MeiyaController {

    public static final Logger logger = LoggerFactory.getLogger(MeiyaController.class);


    @Autowired
    private CustomerRepository customerRepository;



    /**
     *
     * 查询是否存在该手机号用户
     *
     * @return
     */
    @RequestMapping(value = "/getMember", method = {RequestMethod.GET})
    @ResponseBody
    public ResultMessage getMember(@RequestParam("phone") String phone, @RequestParam(value = "giftType") String giftType) throws Exception {


        return null;
    }

}

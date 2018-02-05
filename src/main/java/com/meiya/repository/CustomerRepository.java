package com.meiya.repository;

import com.meiya.model.meiyamodel.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2017/12/8 下午5:53
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Query(nativeQuery = true, value = "select o.* from meiya_customer o where o.phone = ?1 for update")
    Customer findOneForUpdate(String phone);

}

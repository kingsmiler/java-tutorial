package com.xman.jwf.service;


import com.xman.jwf.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * 服务层
 */
public class CustomerService {

    /**
     * 获取客户列表。
     *
     * @param keyword
     * @return
     */
    public List<Customer> getList(String keyword) {
        return null;
    }

    /**
     * 获取客户。
     *
     * @param id
     * @return
     */
    public Customer query(long id) {
        return null;
    }


    public boolean create(Map<String, Object> fieldMap) {
        return true;
    }

    public boolean update(long id, Map<String, Object> fieldMap) {
        return true;
    }

    public boolean delete(long id) {
        return true;
    }


}

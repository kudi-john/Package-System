package com.passbook.merchants.dao;

import com.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantsDao extends JpaRepository<Merchants,Integer> {
    /**
    //@return {@link Merchants}
     **/


    Merchants findById(Integer id);

    Merchants findByName(String name);

}

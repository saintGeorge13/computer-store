package com.cy.store.service;


import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;

import java.io.DataInput;
import java.util.List;

public interface IDistrictService {
    //根据父区域代号查询信息
    List<District> getByParent(String parent);

    //根据code查询name
    String getNameByCode(String code);
}

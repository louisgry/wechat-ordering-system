package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Louis
 * @Date: Create in 2019/11/4 19:57
 * @Description:
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 根据类目type列表查询类目
     * @param categoryTypeList 类目type列表
     * @return 类目列表
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

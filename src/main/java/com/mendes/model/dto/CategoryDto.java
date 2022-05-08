package com.mendes.model.dto;

import java.io.Serializable;

/**
 * @author mendesmustafa on 08-05-2022
 */

public class CategoryDto implements Serializable {

    private Long id;
    private String name;
    private String subCategoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}

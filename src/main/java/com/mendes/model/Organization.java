package com.mendes.model;

import java.io.Serializable;

/**
 * Created by mendesmustafa on 11.03.2021.
 */

public class Organization implements Serializable {

    private String type;
    private String data;

    public Organization() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}

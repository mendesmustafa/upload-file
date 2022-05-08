package com.mendes.model.dto;

import java.io.Serializable;

/**
 * @author mendesmustafa on 08-05-2022
 */

public class LocationDto implements Serializable {

    private Long id;
    private String city;
    private String district;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}

package com.javasampleapproach.jpamysqlangular4.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Sasi Kesani
 */

@Entity
@IdClass(ConfigurationCompositePK.class)
@Table(name="AIE_CONFIGURATION")
public class ConfigurationDTO implements Serializable{


    @Id
    @Column(name = "AC_KEY", nullable = false, length = 30)
    private String ac_key = "";

    @Column(name = "AC_ALT_VALUE", nullable = false, length = 500)
    private String ac_value = "";

    public String getAc_key() {
        return ac_key;
    }

    public String getAc_value() {
        return ac_value;
    }

    public void setAc_value(String ac_value) {
        this.ac_value = ac_value;
    }

    public void setAc_key(String ac_key) {
        this.ac_key = ac_key;
    }




}

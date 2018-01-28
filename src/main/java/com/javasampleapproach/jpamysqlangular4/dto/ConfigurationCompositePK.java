package com.javasampleapproach.jpamysqlangular4.dto;

import java.io.Serializable;

/**
 * @author Sasi Kesani
 */
public class ConfigurationCompositePK implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ac_key = "";

    public ConfigurationCompositePK() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConfigurationCompositePK)) return false;

        ConfigurationCompositePK that = ( ConfigurationCompositePK ) o;

        return ac_key != null ? ac_key.equals ( that.ac_key ) : that.ac_key == null;
    }

    @Override
    public int hashCode() {
        return ac_key != null ? ac_key.hashCode ( ) : 0;
    }

    public String getAc_key() {
        return ac_key;
    }

    public void setAc_key(String ac_key) {
        this.ac_key = ac_key;
    }

}
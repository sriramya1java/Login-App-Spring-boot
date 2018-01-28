package com.javasampleapproach.jpamysqlangular4.model;
import java.io.Serializable;

public class ConfigurationCompositePK implements Serializable {

    private static final long serialVersionUID = 1L;

    private String configKey = "";

    public ConfigurationCompositePK() {

    }

    @Override
    public int hashCode() {
        return configKey.hashCode();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConfigurationCompositePK)) return false;

        ConfigurationCompositePK that = ( ConfigurationCompositePK ) o;

        return configKey != null ? configKey.equals ( that.configKey ) : that.configKey == null;
    }

}

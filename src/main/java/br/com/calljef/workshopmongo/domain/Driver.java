package br.com.calljef.workshopmongo.domain;

import java.io.Serializable;
import java.util.Objects;

public class Driver implements Serializable {
    private  static  final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String cnh;

    public Driver() {
    }

    public Driver(String id, String name, String cnh) {
        this.id = id;
        this.name = name;
        this.cnh = cnh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

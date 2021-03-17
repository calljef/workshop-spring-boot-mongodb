package br.com.calljef.workshopmongo.dto;

import br.com.calljef.workshopmongo.domain.Driver;

import java.io.Serializable;

public class DriverDTO implements Serializable {
    private  static  final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String cnh;

    public DriverDTO() {
    }

    public DriverDTO(Driver obj) {
        id = obj.getId();
        name = obj.getName();
        cnh = obj.getCnh();
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
}

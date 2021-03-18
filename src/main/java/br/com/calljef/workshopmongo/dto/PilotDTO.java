package br.com.calljef.workshopmongo.dto;

import br.com.calljef.workshopmongo.domain.Driver;

import java.io.Serializable;

public class PilotDTO implements Serializable {
    private  static  final long serialVersionUID = 1L;

    private String id;
    private String cnh;

    public PilotDTO() {
    }

    public PilotDTO(Driver obj) {
        id = obj.getId();
        cnh = obj.getCnh();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}

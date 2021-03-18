package br.com.calljef.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "driver")
public class Driver implements Serializable {
    private  static  final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String cnh;

    @DBRef(lazy = true)
    private List<Fine> fines = new ArrayList<>();

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

    public List<Fine> getFines() {
        return fines;
    }

    public void setDrivres(List<Fine> fines) {
        this.fines = fines;
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

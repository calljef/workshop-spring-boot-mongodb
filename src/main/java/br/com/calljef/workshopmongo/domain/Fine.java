package br.com.calljef.workshopmongo.domain;

import br.com.calljef.workshopmongo.dto.PilotDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "fine")
public class Fine implements Serializable {
    private  static  final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String location;
    private String body;
    private PilotDTO pilot;

    public Fine() {
    }

    public Fine(String id, Date date, String location, String body, PilotDTO pilot) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.body = body;
        this.pilot = pilot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public PilotDTO getpilot() {
        return pilot;
    }

    public void setpilot(PilotDTO pilot) {
        this.pilot = pilot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fine fine = (Fine) o;
        return Objects.equals(id, fine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

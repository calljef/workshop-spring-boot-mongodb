package br.com.calljef.workshopmongo.dto;

import br.com.calljef.workshopmongo.domain.Driver;

import java.io.Serializable;

public class VehicleDTO implements Serializable {
    private  static  final long serialVersionUID = 1L;

    private  String model;
    private String plate;
    private PilotDTO pilot;

    public VehicleDTO() {
    }

    public VehicleDTO(String model, String plate, PilotDTO pilot) {
        this.model = model;
        this.plate = plate;
        this.pilot = pilot;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public PilotDTO getPilot() {
        return pilot;
    }

    public void setPilot(PilotDTO pilot) {
        this.pilot = pilot;
    }
}

package com.carcavaz.chochilyapp.models;

import java.util.Date;

public class PersonalHistoryModel {

    private String PersonalHistoryModelId;
    private String PropietarioId;
    private String Accion;
    private Date Hora;

    public PersonalHistoryModel(String personalHistoryModelId, String propietarioId, String accion, Date hora) {
        PersonalHistoryModelId = personalHistoryModelId;
        PropietarioId = propietarioId;
        Accion = accion;
        Hora = hora;
    }

    public String getPersonalHistoryModelId() {
        return PersonalHistoryModelId;
    }

    public void setPersonalHistoryModelId(String personalHistoryModelId) {
        PersonalHistoryModelId = personalHistoryModelId;
    }

    public String getPropietarioId() {
        return PropietarioId;
    }

    public void setPropietarioId(String propietarioId) {
        PropietarioId = propietarioId;
    }

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String accion) {
        Accion = accion;
    }

    public Date getHora() {
        return Hora;
    }

    public void setHora(Date hora) {
        Hora = hora;
    }
}

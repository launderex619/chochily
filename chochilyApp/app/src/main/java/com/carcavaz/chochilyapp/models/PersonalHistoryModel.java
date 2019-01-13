package com.carcavaz.chochilyapp.models;


public class PersonalHistoryModel {

    private String PersonalHistoryModelId;
    private String PropietarioId;
    private String Accion;
    private Long Hora;

    public PersonalHistoryModel(String personalHistoryModelId, String propietarioId, String accion, Long hora) {
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

    public Long getHora() {
        return Hora;
    }

    public void setHora(Long hora) {
        Hora = hora;
    }
}

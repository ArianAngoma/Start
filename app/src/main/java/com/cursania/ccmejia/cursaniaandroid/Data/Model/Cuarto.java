package com.cursania.ccmejia.cursaniaandroid.Data.Model;

public  class Cuarto {

    private String updated_at;
    private String created_at;
    private String nroBanios;
    private String nroCuartos;
    private String contactoArrendador;
    private String tamano;
    private String precioMensual;
    private String servicios;
    private String nombreArrendador;
    private String idArrendador;
    private String imagen_lugar;
    private String descripcion_lugar;
    private String nombre_lugar;
    private String latitud;
    private String longitud;
    private int id;

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getNroBanios() {
        return nroBanios;
    }

    public void setNroBanios(String nroBanios) {
        this.nroBanios = nroBanios;
    }

    public String getNroCuartos() {
        return nroCuartos;
    }

    public void setNroCuartos(String nroCuartos) {
        this.nroCuartos = nroCuartos;
    }

    public String getContactoArrendador() {
        return contactoArrendador;
    }

    public void setContactoArrendador(String contactoArrendador) {
        this.contactoArrendador = contactoArrendador;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getPrecioMensual() {
        return precioMensual;
    }

    public void setPrecioMensual(String precioMensual) {
        this.precioMensual = precioMensual;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getNombreArrendador() {
        return nombreArrendador;
    }

    public void setNombreArrendador(String nombreArrendador) {
        this.nombreArrendador = nombreArrendador;
    }

    public String getIdArrendador() {
        return idArrendador;
    }

    public void setIdArrendador(String idArrendador) {
        this.idArrendador = idArrendador;
    }

    public String getImagen_lugar() {
        return imagen_lugar;
    }

    public void setImagen_lugar(String imagen_lugar) {
        this.imagen_lugar = imagen_lugar;
    }

    public String getDescripcion_lugar() {
        return descripcion_lugar;
    }

    public void setDescripcion_lugar(String descripcion_lugar) {
        this.descripcion_lugar = descripcion_lugar;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public void setNombre_lugar(String nombre_lugar) {
        this.nombre_lugar = nombre_lugar;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cuarto{" +
                "updated_at='" + updated_at + '\'' +
                ", created_at='" + created_at + '\'' +
                ", nroBanios='" + nroBanios + '\'' +
                ", nroCuartos='" + nroCuartos + '\'' +
                ", contactoArrendador='" + contactoArrendador + '\'' +
                ", tamano='" + tamano + '\'' +
                ", precioMensual='" + precioMensual + '\'' +
                ", servicios='" + servicios + '\'' +
                ", nombreArrendador='" + nombreArrendador + '\'' +
                ", idArrendador='" + idArrendador + '\'' +
                ", imagen_lugar='" + imagen_lugar + '\'' +
                ", descripcion_lugar='" + descripcion_lugar + '\'' +
                ", nombre_lugar='" + nombre_lugar + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", id=" + id +
                '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ActividadesImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ActividadModel;

/**
 *
 * @author EDGARD
 */
@Named(value = "actividadesC")
@SessionScoped
public class ActividadesC implements Serializable {
    
    private ActividadModel actividadModel;
    private List<ActividadModel> lstActividades;
    private ActividadesImpl dao;
    public ActividadesC() {
        
        actividadModel = new ActividadModel();
        dao = new ActividadesImpl();
    }
    public void registrar() throws Exception {
        try {
            dao.guardar(actividadModel);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Registrado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en registrar ClienteC/registrar: " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(actividadModel);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado", "Registrado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en modificar ClienteC/modificar: " + e.getMessage());
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(actividadModel);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminado", "Eliminado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en eliminar PacienteC/modificar: " + e.getMessage());
        }
    }

    public void listar() throws Exception {
        try {
            lstActividades = dao.listarVista();
        } catch (Exception e) {
            System.out.println("Error en listar ClienteC/modificar: " + e.getMessage());
        }
    }

    public ActividadesImpl getDao() {
        return dao;
    }

    public void setDao(ActividadesImpl dao) {
        this.dao = dao;
    }

    public ActividadModel getActividadModel() {
        return actividadModel;
    }

    public void setActividadModel(ActividadModel actividadModel) {
        this.actividadModel = actividadModel;
    }

    public List<ActividadModel> getLstActividades() {
        return lstActividades;
    }

    public void setLstActividades(List<ActividadModel> lstActividades) {
        this.lstActividades = lstActividades;
    }
    
}

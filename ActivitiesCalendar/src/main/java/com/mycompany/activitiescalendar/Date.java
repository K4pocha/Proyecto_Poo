/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activitiescalendar;

import java.util.*;

/**
 *
 * @author k4po
 */
public class Date {

    private String date;
    private ArrayList<Activity> list;
    private int number;

    //CONSTRUCTOR   
    public Date(String activityDate) {
        this.date = activityDate;
        list = new ArrayList();
    }

    public Date() {
        this.list = new ArrayList();
    }

    public Date(String date, ArrayList<Activity> list, int number) {
        this.date = date;
        this.list = list;
        this.number = number;
    }

    //GETTER AND SETTER
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Activity> getList() {
        return list;
    }

    public void setList(ArrayList<Activity> list) {
        this.list = list;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //METODS
    public void addActivity(Activity activity) {
        this.list.add(activity);
        number++;
    }

    public void printDate(String dateSelected) {

        String data;
        int size = this.list.size();

        System.out.println("--------------------------------");
        System.out.println("Fecha consultada: " + dateSelected);
        System.out.println("--------------------------------");

        for (int i = 0; i < size; i++) {
            Activity activity = this.list.get(i);

            /*data = activity.getName();
            System.out.println("Nombre: " + data);
            
            data = activity.getDescription();
            System.out.println("Descripcion: " + data);
            
            data = activity.getCategory();
            System.out.println("Categoria: " + data);
            
            data = activity.getState();
            System.out.println("Estado: " + data);*/
            System.out.println(activity.datos());
            System.out.println("------------------------");
        }
    }

    //evento buscar
    public String buscarEvento(String nombre) {
        for (Activity activity : list) {
            if (activity.getName().equalsIgnoreCase(nombre)) {
                return activity.toString();
            }
        }
        return null;
    }

    public void eliminarActivity(String nombre) {
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (activity.getName().equalsIgnoreCase(nombre)) {
                list.remove(i);
                System.out.println("Evento: " + nombre + " eliminado del calendario exitosamente");
                return;
            }
        }
        System.out.println("No existe evento en esta fecha con el nombre ingresado.");
    }

}

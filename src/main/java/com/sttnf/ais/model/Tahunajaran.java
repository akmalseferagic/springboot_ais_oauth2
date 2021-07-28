/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author techinasia888
 */
@Entity
public class Tahunajaran {
    
    @Id
    private int tahun_ajaran;
    
    @Column
    private String semester;
    
    public Tahunajaran() {	} //constructor 
    
    public Tahunajaran(int tahun_ajaran, String semester) {
        this.semester = semester; 
    }

    public int getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(int tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}

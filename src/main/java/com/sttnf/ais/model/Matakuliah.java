/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author techinasia888
 */
@Entity
public class Matakuliah {
    
        @Id
	private String kode_mk;
    
        @Column
	private String nama_mk;
        @Column
	private int sks_mk;
        @Column
	private int smt_mk;
        
        public Matakuliah() {	}

        public Matakuliah(String kode_mk, String nama_mk, int sks_mk, int smt_mk) {
		this.kode_mk = kode_mk;
		this.nama_mk = nama_mk;
                this.sks_mk = sks_mk;
                this.smt_mk = smt_mk;
	}        


    public String getKode_mk() {
        return kode_mk;
    }

    public void setKode_mk(String kode_mk) {
        this.kode_mk = kode_mk;
    }

    public String getNama_mk() {
        return nama_mk;
    }

    public void setNama_mk(String nama_mk) {
        this.nama_mk = nama_mk;
    }

    public int getSks_mk() {
        return sks_mk;
    }

    public void setSks_mk(int sks_mk) {
        this.sks_mk = sks_mk;
    }

    public int getSmt_mk() {
        return smt_mk;
    }

    public void setSmt_mk(int smt_mk) {
        this.smt_mk = smt_mk;
    }

    
    
}

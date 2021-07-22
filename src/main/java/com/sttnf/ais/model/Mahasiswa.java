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

/**
 *
 * @author techinasia888
 */
@Entity
public class Mahasiswa {
    
    @Id
    
    private String nim_mhs;
    
        @Column
        private String prodi_mhs;
        @Column
	private String nama_mhs;
  
        
        public Mahasiswa() {	} //constructor 

        public Mahasiswa(String nim_mahasiswa, String prodi_mhs, String nama_mhs) {
		this.prodi_mhs = prodi_mhs;
                this.nama_mhs = nama_mhs;

	}

    public String getNim_mhs() {
        return nim_mhs;
    }

    public String getProdi_mhs() {
        return prodi_mhs;
    }

    public void setProdi_mhs(String prodi_mhs) {
        this.prodi_mhs = prodi_mhs;
    }

    public String getNama_mhs() {
        return nama_mhs;
    }

    public void setNama_mhs(String nama_mhs) {
        this.nama_mhs = nama_mhs;
    }

   
   
}

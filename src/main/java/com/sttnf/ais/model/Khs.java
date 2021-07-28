/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Khs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "khs_id_khs_seq")
    
    private int id_khs;
    
    @Column
    private String nim_mhs;
    
    @Column
    private String kode_mk;
    
    @Column
    private int tahun_ajaran;
    
    @Column
    private Float nilai;
    
    @Column
    @JsonIgnore
    private Float jumlahnilai;
    
    
    public Khs ( ){ }
    
    public Khs (String nim_mhs, String kode_mk, int tahun_ajaran, Float nilai, Float jumlahnilai){
        this.nim_mhs = nim_mhs;
        this.kode_mk = kode_mk;
        this.tahun_ajaran = tahun_ajaran;
        this.nilai = nilai;
        this.jumlahnilai = jumlahnilai;
        
    }

    public int getId_khs() {
        return id_khs;
    }

    public void setId_khs(int id_khs) {
        this.id_khs = id_khs;
    }

    public String getNim_mhs() {
        return nim_mhs;
    }

    public void setNim_mhs(String nim_mhs) {
        this.nim_mhs = nim_mhs;
    }

    public String getKode_mk() {
        return kode_mk;
    }

    public void setKode_mk(String kode_mk) {
        this.kode_mk = kode_mk;
    }

    public int getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(int tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public Float getNilai() {
        return nilai;
    }

    public void setNilai(Float nilai) {
        this.nilai = nilai;
    }

    public Float getJumlahnilai() {
        return jumlahnilai;
    }

    public void setJumlahnilai(Float jumlahnilai) {
        this.jumlahnilai = jumlahnilai;
    }
  
 
}

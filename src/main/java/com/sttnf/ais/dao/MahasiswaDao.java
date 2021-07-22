/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao;

import com.sttnf.ais.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author techinasia888
 */
public interface MahasiswaDao {
        //get
        Mahasiswa getById (int id) throws Exception;
        List<Mahasiswa> getList() throws Exception;
        List<Mahasiswa> getByNim (String nim_mhs) throws Exception;
        //save
	Mahasiswa save (Mahasiswa mahasiswa) throws Exception;
        //delete
	void delete (Mahasiswa mahasiswa) throws Exception;
	void deleteByNim (String nim_mhs) throws Exception;
	
        
    
}

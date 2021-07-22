/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao;

import com.sttnf.ais.model.Khs;
import com.sttnf.ais.model.Matakuliah;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author techinasia888
 */
public interface KhsDao {
    
        //Get
        Khs getById (int id) throws Exception;
        Integer getSks (String kode_mk)throws Exception;
        List<Khs> getList() throws Exception;
        Float getTotaljumnilai (String nim_mhs, int thajaran) throws Exception;
        Integer getTotalSks (String nim_mhs, int thajaran) throws Exception;
        Integer getTotalSksMhs (String nim_mhs) throws Exception;
        List<Khs> findKhs (String nim_mhs, int thajaran) throws Exception;
       
        
        //Save
	Khs save (Khs khs) throws Exception;
        
        //Delete
	void delete (Khs khs) throws Exception;
        void deleteByNimMatkul (String nim_mhs, String kode_mk) throws Exception;
        

        
}

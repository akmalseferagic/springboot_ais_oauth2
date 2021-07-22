/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao;

import com.sttnf.ais.model.Matakuliah;
import java.util.List;

/**
 *
 * @author techinasia888
 */
public interface MatakuliahDao {
    
    Matakuliah getById(int id) throws Exception;
    List <Matakuliah> getByKodeMk(String kode_mk) throws Exception;
    List<Matakuliah> getList() throws Exception;
    
    Matakuliah save(Matakuliah matakuliah) throws Exception;
    void delete(Matakuliah matakuliah) throws Exception;
    void deleteByKodeMk(String kode_mk);
    
}

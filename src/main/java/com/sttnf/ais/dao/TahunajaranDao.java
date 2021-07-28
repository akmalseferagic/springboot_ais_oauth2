/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao;

import com.sttnf.ais.model.Mahasiswa;
import com.sttnf.ais.model.Tahunajaran;
import java.util.List;

/**
 *
 * @author techinasia888
 */
public interface TahunajaranDao {
    
    Tahunajaran save (Tahunajaran tahunajaran) throws Exception;
    void delete (Tahunajaran tahunajaran) throws Exception;
    List<Tahunajaran> getList() throws Exception;
    void deleteByTahunajaran(int tahun_ajaran);
    List<Tahunajaran>getByTahunajaran(int tahun_ajaran);
}

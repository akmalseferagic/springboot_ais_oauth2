/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao.repository;

import com.sttnf.ais.model.Mahasiswa;
import com.sttnf.ais.model.Matakuliah;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author techinasia888
 */
public interface MatakuliahRepository extends PagingAndSortingRepository<Matakuliah, String> {
    
    
    @Query("select m.kode_mk, m.nama_mk, m.sks_mk, m.smt_mk from Matakuliah m where m.kode_mk = :kode_mk")
    public List<Matakuliah> getByKodeMk(String kode_mk);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "delete from Matakuliah m where m.kode_mk = :kode_mk")
    public void deleteByKodeMk(String kode_mk);
}

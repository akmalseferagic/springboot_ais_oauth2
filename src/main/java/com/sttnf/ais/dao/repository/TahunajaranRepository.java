/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao.repository;

import com.sttnf.ais.model.Tahunajaran;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author techinasia888
 */
public interface TahunajaranRepository extends PagingAndSortingRepository<Tahunajaran, Integer> {
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "delete from Tahunajaran t where t.tahun_ajaran = :tahun_ajaran")
    public void deleteByTahunajaran(int tahun_ajaran);
    
    @Query("select t.tahun_ajaran, t.semester from Tahunajaran t where t.tahun_ajaran = :tahun_ajaran")
    public List<Tahunajaran> getByTahunajaran(int tahun_ajaran);
    
}

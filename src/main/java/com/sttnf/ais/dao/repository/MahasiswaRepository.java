/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao.repository;

import com.sttnf.ais.model.Mahasiswa;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author techinasia888
 */
public interface MahasiswaRepository extends PagingAndSortingRepository<Mahasiswa, String> {
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "delete from Mahasiswa m where m.nim_mhs = :nim_mhs")
    public void deleteByNim(String nim_mhs);
    
    @Query("select m.nim_mhs, m.nama_mhs, m.prodi_mhs from Mahasiswa m where m.nim_mhs = :nim_mhs")
    public List<Mahasiswa> getByNim(String nim_mhs);
    
}

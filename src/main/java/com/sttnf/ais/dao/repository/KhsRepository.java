/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao.repository;

import com.sttnf.ais.model.Khs;
import com.sttnf.ais.model.Matakuliah;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author techinasia888
 */
public interface KhsRepository extends PagingAndSortingRepository<Khs, Integer> {

    //dipakai
    @Query("select k.id_khs, k.thajaran, m.nama_mk, m.sks_mk, k.nilai, k.jumlahnilai from Matakuliah m, Khs k where k.kode_mk = m.kode_mk and k.thajaran = :thajaran and nim_mhs = :nim_mhs order by nim_mhs, thajaran")
    public List<Khs> findKhs(@Param("nim_mhs") String nim_mhs, @Param("thajaran") int thajaran);
    
      //dipakai
    @Query(nativeQuery = true, value = "select sum(k.jumlahnilai) from Khs k where k.nim_mhs = :nim_mhs and k.thajaran = :thajaran")
   public Float getTotaljumnilai (@Param("nim_mhs") String nim_mhs, @Param("thajaran") int thajaran);
    
   //dipakai
    @Query(nativeQuery = true, value = "select sum(m.sks_mk) from Matakuliah m inner join Khs k on k.kode_mk = m.kode_mk where k.nim_mhs = :nim_mhs and k.thajaran = :thajaran")
   public Integer getTotalSks (@Param("nim_mhs") String nim_mhs, @Param("thajaran") int thajaran);
  
    //dipakai
    @Query("select m.sks_mk from Matakuliah m where m.kode_mk = :kode_mk")
    public Integer getSks(@Param("kode_mk") String kode_mk);
    
    //dipakai
    @Query(nativeQuery = true, value = "select sum(m.sks_mk) from Matakuliah m inner join Khs k on k.kode_mk = m.kode_mk where k.nim_mhs = :nim_mhs")
    public Integer getTotalSksMhs (@Param("nim_mhs") String nim_mhs);
    
    //delete matkul mahasiswa
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "delete from Khs k where k.nim_mhs = :nim_mhs and k.kode_mk = :kode_mk")
    public void deleteByNimMatkul(String nim_mhs, String kode_mk);
    
   
}

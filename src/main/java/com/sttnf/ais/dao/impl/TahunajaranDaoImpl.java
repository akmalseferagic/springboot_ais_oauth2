/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.dao.impl;

import com.sttnf.ais.dao.TahunajaranDao;
import com.sttnf.ais.dao.repository.TahunajaranRepository;
import com.sttnf.ais.model.Mahasiswa;
import com.sttnf.ais.model.Tahunajaran;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author techinasia888
 */
public class TahunajaranDaoImpl extends BaseImpl implements TahunajaranDao {

    @Autowired
	private TahunajaranRepository repository;

    @Override
    public Tahunajaran save(Tahunajaran tahunajaran) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
        return repository.save(tahunajaran);
    }

    @Override
    public List<Tahunajaran> getList() throws Exception {
        CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Tahunajaran> query = critB.createQuery(Tahunajaran.class);
		Root<Tahunajaran> root = query.from(Tahunajaran.class);
		
		TypedQuery<Tahunajaran> q = em.createQuery(query);
		return q.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByTahunajaran(int tahun_ajaran) {
        repository.deleteByTahunajaran(tahun_ajaran);//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Tahunajaran> getByTahunajaran(int tahun_ajaran) {
        repository.getByTahunajaran(tahun_ajaran); //To change body of generated methods, choose Tools | Templates.   
        return repository.getByTahunajaran(tahun_ajaran); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public void delete(Tahunajaran tahunajaran) throws Exception {
        repository.delete(tahunajaran);
         //To change body of generated methods, choose Tools | Templates.
    }

   
    
}

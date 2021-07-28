/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.controller;

import static com.sttnf.ais.controller.ControllerMahasiswa.ROLE_ADMIN;
import static com.sttnf.ais.controller.ControllerTahunajaran.ROLE_ADMIN;
import com.sttnf.ais.dao.TahunajaranDao;
import com.sttnf.ais.model.Mahasiswa;
import com.sttnf.ais.model.Tahunajaran;
import com.sttnf.ais.service.AuthenticationFacadeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author techinasia888
 */
@RestController
@RequestMapping("/Tahunajaran")
public class ControllerTahunajaran {
    
    private static final Logger log = LoggerFactory.getLogger(ControllerMahasiswa.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
    @Autowired
    private AuthenticationFacadeService authenticationFacadeService;
    
    @Autowired
	private TahunajaranDao tahunajaranDao;
    
    @Secured({ROLE_ADMIN})
        @GetMapping("/get")
	public List viewTahunAjaran(@RequestParam(value="tahun_ajaran", defaultValue="") int tahun_ajaran) throws Exception {
		
        List<Tahunajaran> list = tahunajaranDao.getByTahunajaran(tahun_ajaran);
        return list;
	
	}
    
    @Secured({ROLE_ADMIN})
        @PostMapping("/post")
	public Tahunajaran postTahunajaran(@RequestBody Tahunajaran tahun_ajaran) throws Exception{
		Tahunajaran data = tahunajaranDao.save(tahun_ajaran);
		return data;
	}    
        
    @Secured({ROLE_ADMIN})
	@DeleteMapping("/delete")
	public String Tahunajaran(@RequestParam(value="tahun_ajaran", defaultValue="") int tahun_ajaran) throws Exception{
		tahunajaranDao.deleteByTahunajaran(tahun_ajaran);
        return "Data telah dihapus!.";
	}  
        
    @Secured({ROLE_ADMIN})
	@PutMapping("/put")
	public Tahunajaran update(@RequestBody Tahunajaran tahun_ajaran) throws Exception {
		Tahunajaran update = tahunajaranDao.save(tahun_ajaran);
		return update;
	}    
        
    @Secured({ROLE_ADMIN, ROLE_USER})
	@GetMapping("/getall")
	public List<Tahunajaran> getlist() throws Exception{
		List<Tahunajaran> list = tahunajaranDao.getList();
		return list;
	}    
}

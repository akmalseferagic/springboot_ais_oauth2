/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.controller;

import static com.sttnf.ais.controller.UserController.ROLE_ADMIN;
import static com.sttnf.ais.controller.UserController.ROLE_USER;
import com.sttnf.ais.dao.MahasiswaDao;
import com.sttnf.ais.model.Mahasiswa;
import com.sttnf.ais.model.Matakuliah;
import com.sttnf.ais.service.AuthenticationFacadeService;
import java.util.List;
import java.lang.String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/Mahasiswa")
public class ControllerMahasiswa {
    
    private static final Logger log = LoggerFactory.getLogger(ControllerMahasiswa.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private AuthenticationFacadeService authenticationFacadeService;
    
    @Autowired
	private MahasiswaDao mahasiswaDao;
    
    @Secured({ROLE_ADMIN})
    @GetMapping("/get")
	public List viewMahasiswa(@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs) throws Exception {
		
            List<Mahasiswa> list = mahasiswaDao.getByNim(nim_mhs);
        return list;
	
	}
     
    @Secured({ROLE_ADMIN})    
    @PostMapping("/post")
        public Mahasiswa postMahasiswa(@RequestBody Mahasiswa mahasiswa) throws Exception{
            Mahasiswa data = mahasiswaDao.save(mahasiswa);
                return data;
	}
    
    @Secured({ROLE_ADMIN})    
    @DeleteMapping("/delete")
	public String Mahasiswa (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs) throws Exception{
		mahasiswaDao.deleteByNim(nim_mhs);
                return "data telah dihapus!.";
	}
    
    @Secured({ROLE_ADMIN})
    @PutMapping("/put")
	public Mahasiswa update(@RequestBody Mahasiswa mahasiswa) throws Exception {
		Mahasiswa update = mahasiswaDao.save(mahasiswa);
		return update;
	}
    
    @Secured({ROLE_ADMIN})    
    @GetMapping("/getall")
	public List<Mahasiswa> getlist() throws Exception{
		List<Mahasiswa> list = mahasiswaDao.getList();
		return list;
	}
}

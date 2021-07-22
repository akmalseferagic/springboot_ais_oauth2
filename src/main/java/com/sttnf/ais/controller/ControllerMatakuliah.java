/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.controller;


import static com.sttnf.ais.controller.UserController.ROLE_ADMIN;
import static com.sttnf.ais.controller.UserController.ROLE_USER;
import com.sttnf.ais.dao.MatakuliahDao;
import com.sttnf.ais.model.Matakuliah;
import com.sttnf.ais.service.AuthenticationFacadeService;
import java.util.List;
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
@RequestMapping("/Matakuliah")
public class ControllerMatakuliah {
    
    private static final Logger log = LoggerFactory.getLogger(ControllerMatakuliah.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private AuthenticationFacadeService authenticationFacadeService;
    
    @Autowired
	private MatakuliahDao matakuliahDao;
    
        @Secured({ROLE_ADMIN})
    	@GetMapping("/get")
	public List<Matakuliah> viewMatakuliah(@RequestParam(value="kode_mk", defaultValue="") String kode_mk) throws Exception {
		
			List<Matakuliah> list = matakuliahDao.getByKodeMk(kode_mk);
				return list;
	}
	
        @Secured({ROLE_ADMIN})
	@PostMapping("/post")
	public Matakuliah postMatakuliah(@RequestBody Matakuliah matakuliah) throws Exception{
		Matakuliah data = matakuliahDao.save(matakuliah);
		return data;
	}
	
        @Secured({ROLE_ADMIN})
	@DeleteMapping("/delete")
	public String Matakuliah(@RequestParam(value="kode_mk", defaultValue="") String kode_mk) throws Exception{
		matakuliahDao.deleteByKodeMk(kode_mk);
        return "Data telah dihapus!.";
	}
	
        @Secured({ROLE_ADMIN})
	@PutMapping("/put")
	public Matakuliah update(@RequestBody Matakuliah matakuliah) throws Exception {
		Matakuliah update = matakuliahDao.save(matakuliah);
		return update;
	}
	
        @Secured({ROLE_ADMIN, ROLE_USER})
	@GetMapping("/getall")
	public List<Matakuliah> getlist() throws Exception{
		List<Matakuliah> list = matakuliahDao.getList();
		return list;
	}
    
    
}

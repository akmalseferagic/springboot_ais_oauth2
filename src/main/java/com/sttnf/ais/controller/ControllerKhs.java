/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sttnf.ais.controller;

import static com.sttnf.ais.controller.UserController.ROLE_ADMIN;
import static com.sttnf.ais.controller.UserController.ROLE_USER;
import com.sttnf.ais.dao.KhsDao;
import com.sttnf.ais.dao.repository.KhsRepository;
import com.sttnf.ais.model.Khs;
import com.sttnf.ais.service.AuthenticationFacadeService;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.aspectj.weaver.Iterators.array;
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
@RequestMapping("/Khs")
public class ControllerKhs {
    
    private static final Logger log = LoggerFactory.getLogger(ControllerKhs.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private AuthenticationFacadeService authenticationFacadeService;
       
    @Autowired
	private KhsDao khsDao;
    
    @Autowired
    private KhsRepository repository;
    
    @Secured({ROLE_ADMIN})
    @GetMapping("/get")
	public String viewKhs(@RequestParam(value="id", defaultValue="") String id) {
		try {
			Khs khs = khsDao.getById(Integer.valueOf(id));
			if(khs == null) {
				return "data tidak ditmukan";
			}else {
				return "hello"+ khs.getId_khs();
			}
		}catch(NumberFormatException e) {
			return "salah format input";
		}catch(Exception e) {
			return String.format("terjadi kesalahan : %s", e.getMessage());
		}
	}
    
    @Secured({ROLE_ADMIN})    
    @GetMapping("/getall")
    public List<Khs> getlist() throws Exception{
		List<Khs> list = khsDao.getList();
		return list;
	}    
        
    @Secured({ROLE_ADMIN, ROLE_USER})    
   //panggil khs  saja
   @GetMapping("/find")
    public List<Khs> findDetailKhs (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs, @RequestParam(value="tahun_ajaran", defaultValue="") int tahun_ajaran ) throws Exception{
		List<Khs> list = khsDao.findKhs(nim_mhs, tahun_ajaran);
            return list;
	} 

    @Secured({ROLE_ADMIN})    
    @PostMapping("/post")
        public Khs postKhs(@RequestBody Khs khs) throws Exception{
            
            //deklarasi matakuliah
            String kd_mk = khs.getKode_mk();
          
            //untuk dapat sksXnilai
            Integer jumSks = khsDao.getSks(kd_mk);
            Float nilai = khs.getNilai();
            Float jumlahnilai = jumSks*nilai;
            khs.setJumlahnilai(jumlahnilai);
            
            Khs data = khsDao.save(khs);
                return data;
	}
        
    @Secured({ROLE_ADMIN})    
    @DeleteMapping("/delete")
	public String Khs (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs, @RequestParam(value="kode_mk", defaultValue="") String kode_mk ) throws Exception{
                khsDao.deleteByNimMatkul(nim_mhs, kode_mk);
        return "Data sudah terhapus!";
                
        }
    
    @Secured({ROLE_ADMIN})     
    @PutMapping("/put")
	public Khs update(@RequestBody Khs khs) throws Exception {
            
            
            String kd_mk = khs.getKode_mk();
          
            //untuk dapat sksXnilai
            Integer jumSks = khsDao.getSks(kd_mk);
            Float nilai = khs.getNilai();
            Float jumlahnilai = jumSks*nilai;
            khs.setJumlahnilai(jumlahnilai);
            //return
		Khs update = khsDao.save(khs);
		return update;
	}
        
    @Secured({ROLE_ADMIN, ROLE_USER})    
     //pangill khs keseluruhan   
    @GetMapping("/khsdetail")
     public List khs_detail (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs, @RequestParam(value="tahun_ajaran", defaultValue="") int tahun_ajaran, Principal principal) throws Exception {
     // test if userId is current principal or principal is an ADMIN
         
     List<Khs> list = khsDao.findKhs(nim_mhs, tahun_ajaran);
     Float totalbobotnilai = khsDao.getTotaljumnilai(nim_mhs, tahun_ajaran);
     Integer totalsks = khsDao.getTotalSks(nim_mhs, tahun_ajaran);
     Integer totalsksall = khsDao.getTotalSksMhs(nim_mhs);
     Float ips_mhs = totalbobotnilai/totalsks;
        return Arrays.asList(list,"'Bobot X nilai' : " +totalbobotnilai, "'Total SKS' : " + totalsks, "Total SKS yang telah ditempuh = " +totalsksall, "Indeks Per Semester = " +ips_mhs);

    }
   
     @Secured({ROLE_ADMIN, ROLE_USER})
     //Total SKS semester current
     @GetMapping("/totalsks")
     public String total_Sks (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs, @RequestParam(value="tahun_ajaran", defaultValue="") int tahun_ajaran ) throws Exception {
         Integer totalsks = khsDao.getTotalSks(nim_mhs, tahun_ajaran);
        return "Total Sks = " +totalsks;
     }
     
     @Secured({ROLE_ADMIN, ROLE_USER})
     //Total SKS keseluruhan
     @GetMapping("/totalsksall")
     public String total_Sksall (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs) throws Exception {
         Integer totalsksall = khsDao.getTotalSksMhs(nim_mhs);
        return "Total SKS yang telah ditempuh = " +totalsksall;
     }

     @Secured({ROLE_ADMIN, ROLE_USER})
     //Bobot X Sks
      @GetMapping("/bobotxsks")
     public String bobotXsks (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs, @RequestParam(value="tahun_ajaran", defaultValue="") int tahun_ajaran ) throws Exception {
         Float totalbobotnilai = khsDao.getTotaljumnilai(nim_mhs, tahun_ajaran);
        return "Bobot X SKS = " +totalbobotnilai;
     }
     
     @Secured({ROLE_ADMIN, ROLE_USER})
     //IPS mahasiswa
     @GetMapping("/ips")
     public String ips (@RequestParam(value="nim_mhs", defaultValue="") String nim_mhs, @RequestParam(value="tahun_ajaran", defaultValue="") int tahun_ajaran ) throws Exception {
         
         Integer totalsks = khsDao.getTotalSks(nim_mhs, tahun_ajaran);
         Float totalbobotnilai = khsDao.getTotaljumnilai(nim_mhs, tahun_ajaran);
         Float ips_mhs = totalbobotnilai /totalsks;
         
        return "Indeks Per Semester = " +ips_mhs;
     }
     
}
       

package main;


import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import CustomDao.MenuSchemaCustomDao.TableConfigurationMenuCustomDaoSvc;
import CustomDao.MenuSchemaCustomDao.TableUserCustomDaoSvc;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import DataTransferObjectLib.PegawaiSchemaDto.TableJobDto;
import service.GenerateAutoId.GenAutoSvc;
import service.PegawaiSchemaService.TableJobSvc;
import dao.MenuSchemaDao.TableConfigurationMenuDao;
import dao.MenuSchemaDao.TableUserDao;
import dao.PegawaiSchemaDao.TableJobDao;
import dao.PegawaiSchemaDao.TablePengenalDao;
import dao.PegawaiSchemaDao.TableRoleDao;
import entity.MenuSchema.TableConfigurationMenu;
import entity.MenuSchema.TableUser;
import entity.PegawaiSchema.TableJob;
import entity.PegawaiSchema.TableRole;

public class tes {
	
	@Autowired
	private static TableConfigurationMenuCustomDaoSvc tableConfigurationMenuCustomDaoSvc;
	
	@PersistenceContext
	private static EntityManager em;

	public static void main(String[] args) {

		
//		
	ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
	
	GenAutoSvc genAutoSvc = ctx.getBean(GenAutoSvc.class);
	
	String user = genAutoSvc.generateAutoIdForCurrentTable("TABLE_MENU", "MENU" ,3);
	
	System.out.println("Id : " + user);
	
//
//	TableUserDao tb = ctx.getBean(TableUserDao.class);
		
	}
	
	public static List<TableConfigurationMenu>  desa(String query){
		List<TableConfigurationMenu> l = em.createNativeQuery(query).getResultList();
		return l;
	}
	
	public static String dayOfTheWeek(Date tanggal){
        String hari = "";
		Calendar c = Calendar.getInstance();
		c.setTime(tanggal);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		Map<Integer, String> mapHari = new HashMap<>();
		
		mapHari.put(new Integer(2), "Senin");
		mapHari.put(new Integer(3), "Selasa");
		mapHari.put(new Integer(4), "Rabu");
		mapHari.put(new Integer(5), "Kamis");
		mapHari.put(new Integer(6), "Jumat");
		mapHari.put(new Integer(7), "Sabtu");
		mapHari.put(new Integer(1), "Minggu");
		
		return mapHari.get(new Integer(dayOfWeek));
	}
	
	public static Map<String,Object> convert(Date tanggal){
		Map<String,Object> map = new HashMap<>();
		
		String dateString = tanggal.toString();
		
		String[] date = dateString.split(" ");
		
		String[] convertTampilanTanggal = date[0].trim().split("-");
		String tampilanTanggalBaru = convertTampilanTanggal[2]+"/"+
		                             convertTampilanTanggal[1]+"/"+convertTampilanTanggal[0];
				
		map.put("contoh", dateString);
		map.put("tanggal", tampilanTanggalBaru);
		map.put("jam", date[1]);
		
		return map;
	}

}

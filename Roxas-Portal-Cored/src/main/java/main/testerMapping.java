package main;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.util.List;

import dto.PegawaiSchemaDto.TableJobDto;
import entity.PegawaiSchema.TableJob;

public class testerMapping {

	public static void main(String[] args) {
		
		
		TableJob job = new TableJob();
		TableJobDto jobDto = new TableJobDto();
		job.setGaji(new BigDecimal(1100000.0));
		job.setJid("1123");
		jobDto = (TableJobDto) mapper(jobDto, job);
		System.out.println("gaji : " + jobDto.getGaji() + " jid :"
				+ jobDto.getJid() + " job desk : " + jobDto.getJobDesk());
	}

	public static Object mapper(Object dto, Object entity) {
		Class entityClass = entity.getClass();
		Class dtoClass = dto.getClass();

		Method[] entityMethods = entityClass.getMethods();
		Method[] dtoMethods = dtoClass.getMethods();

		for (Method methodDto : dtoMethods) {
			if (methodDto.getName().substring(0, 3).equalsIgnoreCase("set")) {
				for (Method method : entityMethods) {
					if (method.getName().substring(0, 3)
							.equalsIgnoreCase("get")) {
						if (methodDto
								.getName()
								.substring(3)
								.equalsIgnoreCase(method.getName().substring(3))) {
							try {
								method.invoke(entity);
								methodDto.invoke(dto, method.invoke(entity));
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		return dto;
	}

}

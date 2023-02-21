package excelsheet.upload.service;


import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import excelsheet.upload.dto.Result;
import excelsheet.upload.model.Patient;

public interface PatientService {
	
	public List<Patient> findAll();
	
	public Patient save(Patient patient);
	
	public Result saveExcel(MultipartFile multFile);

//	public void deleteById(int id);
	
	
	
}


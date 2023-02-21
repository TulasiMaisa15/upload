package excelsheet.upload.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import excelsheet.upload.model.Patient;

public interface PatientDAO extends JpaRepository<Patient, Integer> {

	Patient findByEmail(String email);

//	public void deleteById(int id);

}


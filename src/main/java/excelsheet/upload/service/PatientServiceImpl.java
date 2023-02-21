package excelsheet.upload.service;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import excelsheet.upload.dao.PatientDAO;
import excelsheet.upload.dto.Result;
import excelsheet.upload.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;

	@Override
	public List<Patient> findAll() {
		return patientDAO.findAll();
	}

	@Override
	public Patient save(Patient patient) {

		Patient patient2 = patientDAO.findByEmail(patient.getEmail());//duplicate email

		if (patient2 == null) {
			return patientDAO.save(patient);
		} else {
			return null;
		}

	}

	@Override
	public Result saveExcel(MultipartFile multFile) {
		Result result = new Result();

		try {
			if (ExcelHelper.excelSheet(multFile)) {

				if (ExcelHelper.headerSheet(multFile.getInputStream())) {

					List<Patient> details = ExcelHelper.convertList(multFile.getInputStream());

//					patientDAO.saveAll(details);
//					not allow duplicates
					details.forEach(detail -> {

						Patient patient = patientDAO.findByEmail(detail.getEmail());

						if (patient == null) {
							patientDAO.save(detail);
						} else {
							detail.setId(patient.getId());
							patientDAO.save(detail);
						}

					});

					result = new Result();
					result.setStatusCode(HttpStatus.OK.value());
					result.setSuccessMessage("Data added succesfully.");

				} else {
					result.setStatusCode(HttpStatus.BAD_REQUEST.value());
					result.setErrorMessage("Headers Mismatched");
				}

			} else {
				result.setStatusCode(HttpStatus.BAD_REQUEST.value());
				result.setErrorMessage("Please upload Excel file only.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}


	

//	public void deleteById(int id) {
//		patientDAO.deleteById(id);
//	}

}



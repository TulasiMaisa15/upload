package excelsheet.upload.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import excelsheet.upload.dto.Result;
import excelsheet.upload.model.Patient;
import excelsheet.upload.service.PatientService;


@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> getAll() {
		List<Patient> patientList = null;
		patientList = patientService.findAll();
		return ResponseEntity.ok(patientList);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Patient> save(@RequestBody Patient patient) {
		Patient patient1 = patientService.save(patient);
		return ResponseEntity.ok(patient1);

	}

	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	public ResponseEntity<Result> upload(@RequestParam("file") MultipartFile multfile) {
		Result result = patientService.saveExcel(multfile);
		return ResponseEntity.ok(result);
	}

//	@DeleteMapping(value = "/delete/{id}")
//	public void deleteById(int id) {
//		Patient patient = new Patient();
//		try {
//			patientService.deleteById(id);
//			patient.put("message", "Deleted successfully");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}




package com.zakaria.patientmanagement.controllers;

import com.zakaria.patientmanagement.models.Patient;
import com.zakaria.patientmanagement.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping()
    public ResponseEntity<Patient> save(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.add(patient), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Patient> edit( @RequestBody Patient patient, @PathVariable Long id){
        return new ResponseEntity<>(patientService.edit(id, patient), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Long id){
        return new ResponseEntity<>(patientService.get(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Patient>> getAll () {
        return  ResponseEntity.ok(patientService.all());
    }
}

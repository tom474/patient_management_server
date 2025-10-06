package com.tom474.patientservice.services;

import com.tom474.patientservice.dtos.PatientRequestDTO;
import com.tom474.patientservice.dtos.PatientResponseDTO;
import com.tom474.patientservice.mappers.PatientMapper;
import com.tom474.patientservice.models.Patient;
import com.tom474.patientservice.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }
}

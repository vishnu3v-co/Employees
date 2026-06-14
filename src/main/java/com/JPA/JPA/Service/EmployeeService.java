package com.JPA.JPA.Service;

import com.JPA.JPA.DTO.EmployeeDTO;
import com.JPA.JPA.Entities.EmployeeEntity;
import com.JPA.JPA.Repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    public EmployeeDTO getEmployeeById(long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAll(){
        List<EmployeeEntity> employeeEntity =  employeeRepository.findAll();
        return employeeEntity.stream()
                .map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO save(EmployeeDTO employeeEntity){
        EmployeeEntity employeeEntity1 = modelMapper.map(employeeEntity, EmployeeEntity.class);
        EmployeeEntity employeeEntity2 = employeeRepository.save(employeeEntity1);
        return modelMapper.map(employeeEntity2, EmployeeDTO.class);
    }
}

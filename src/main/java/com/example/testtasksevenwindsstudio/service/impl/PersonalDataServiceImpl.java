package com.example.testtasksevenwindsstudio.service.impl;

import com.example.testtasksevenwindsstudio.dao.PersonalDataRepository;
import com.example.testtasksevenwindsstudio.dto.AddPersonalDataRequestDto;
import com.example.testtasksevenwindsstudio.entity.PersonalData;
import com.example.testtasksevenwindsstudio.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    @Autowired
    PersonalDataRepository personalDataRepository;

    @Override
    public List<PersonalData> getAllPersonalData() {
        return personalDataRepository.findAll();
    }

    @Override
    public PersonalData getPersonalDataById(int id) {
        PersonalData personalData = null;
        Optional<PersonalData> optionalPersonalData = personalDataRepository.findById(id);
        if (optionalPersonalData.isPresent()) {
            personalData = optionalPersonalData.get();
        }
        return personalData;
    }

    @Override
    public void savePersonalData(AddPersonalDataRequestDto personalDataDto) {

        PersonalData personalData = new PersonalData();

        personalData.setEmail(personalDataDto.getEmail());
        personalData.setFirstName(personalDataDto.getFirstName());
        personalData.setLastName(personalDataDto.getLastName());
        personalData.setPatronymic(personalDataDto.getPatronymic());
        personalData.setPhoneNumber(personalDataDto.getPhoneNumber());

        personalDataRepository.save(personalData);
    }
}

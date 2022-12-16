package com.example.testtasksevenwindsstudio.service;

import com.example.testtasksevenwindsstudio.dto.AddPersonalDataRequestDto;
import com.example.testtasksevenwindsstudio.entity.PersonalData;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonalDataService {

    List<PersonalData> getAllPersonalData();

    PersonalData getPersonalDataById(int id);

    void savePersonalData(AddPersonalDataRequestDto personalDataDto);
}

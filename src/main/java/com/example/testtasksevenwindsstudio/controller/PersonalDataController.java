package com.example.testtasksevenwindsstudio.controller;

import com.example.testtasksevenwindsstudio.dto.AddPersonalDataRequestDto;
import com.example.testtasksevenwindsstudio.entity.PersonalData;
import com.example.testtasksevenwindsstudio.service.PersonalDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
@Api
public class PersonalDataController {
    @Autowired
    PersonalDataService personalDataService;

    @GetMapping
    @ApiOperation("Получение всех записей")
    public List<PersonalData> getAllPersonalData() {
        List<PersonalData> personalDataList = personalDataService.getAllPersonalData();
        return personalDataList;
    }

    @GetMapping("/{id}")
    @ApiOperation("Получение записи по id")
    public PersonalData getPersonalDataById(@PathVariable int id) {
        PersonalData personalData = personalDataService.getPersonalDataById(id);
        return personalData;
    }

    @PostMapping
    @ApiOperation("Сохранение записи в базу данных")
    public void addPersonalData(@RequestBody AddPersonalDataRequestDto personalDataDto) {
        personalDataService.savePersonalData(personalDataDto);
    }
}

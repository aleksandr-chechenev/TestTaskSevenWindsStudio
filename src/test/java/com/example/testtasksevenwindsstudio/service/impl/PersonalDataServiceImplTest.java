package com.example.testtasksevenwindsstudio.service.impl;

import com.example.testtasksevenwindsstudio.dao.PersonalDataRepository;
import com.example.testtasksevenwindsstudio.dto.AddPersonalDataRequestDto;
import com.example.testtasksevenwindsstudio.entity.PersonalData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonalDataServiceImplTest {
    private final PersonalDataRepository personalDataRepository = mock(PersonalDataRepository.class);

    @Test
    void getPersonalDataById() {
        PersonalData personalData = new PersonalData();
        Integer id = 1;
        personalData.setId(id);
        when(personalDataRepository.findById(id)).thenReturn(Optional.of(personalData));

        PersonalData personalDataActual = null;
        Optional<PersonalData> optional = personalDataRepository.findById(id);
        if (optional.isPresent()) {
            personalDataActual = optional.get();
        }

        assertNotNull(personalDataActual);
        assertEquals(id, personalDataActual.getId());
        assertEquals(PersonalData.class, personalDataActual.getClass());
    }

    @Test
    void savePersonalDataTest() {
        AddPersonalDataRequestDto personalDataDto = getPersonalDataDto();

        PersonalData personalData = new PersonalData();

        personalData.setEmail(personalDataDto.getEmail());
        personalData.setFirstName(personalDataDto.getFirstName());
        personalData.setLastName(personalDataDto.getLastName());
        personalData.setPatronymic(personalDataDto.getPatronymic());
        personalData.setPhoneNumber(personalDataDto.getPhoneNumber());

        personalDataRepository.save(personalData);

        assertEquals(personalDataDto.getEmail(), personalData.getEmail());
        assertEquals(personalDataDto.getFirstName(), personalData.getFirstName());
        assertEquals(personalDataDto.getLastName(), personalData.getLastName());
        assertEquals(personalDataDto.getPatronymic(), personalData.getPatronymic());
        assertEquals(personalDataDto.getPhoneNumber(), personalData.getPhoneNumber());
        verify(personalDataRepository, Mockito.times(1)).save(personalData);
        verifyNoMoreInteractions(personalDataRepository);

    }

    private AddPersonalDataRequestDto getPersonalDataDto() {
        AddPersonalDataRequestDto personalDataDto = new AddPersonalDataRequestDto();

        personalDataDto.setEmail("some_email");
        personalDataDto.setFirstName("some_name");
        personalDataDto.setLastName("some_last_name");
        personalDataDto.setPatronymic("some_patronymic");
        personalDataDto.setPhoneNumber(11111111111L);

        return personalDataDto;
    }
}
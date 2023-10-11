package com.example.homework3october;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PartsUnitTest {

    @MockBean
    private PartsRepository partsRepository;

    @Autowired
    private PartsService partsService;

    @Test
    void shouldRetrievePartsFromRepository(){
        PartsRepository partsRepository1 = new PartsRepository();
        assertThat(partsRepository1.getPart().size()).isEqualTo(2);
    }

    @Test
    void shouldIncreaseArraySizeWhenAddingNewPart(){
        PartsRepository partsRepository1 = new PartsRepository();
        partsRepository1.addPart(new Part("StefanILove"));
        assertThat(partsRepository1.getPart().size()).isEqualTo(3);
    }

    @Test
    void shouldFetchPartsThroughService(){
        ArrayList<Part> partsList = new ArrayList<>(List.of(new Part("pogo")));
        when(partsService.getParts()).thenReturn(partsList);
        assertThat(partsService.getParts().size()).isEqualTo(1);
        assertThat(partsService.getParts().get(0).name()).isEqualTo("pogo");
    }

    @Test
    void shouldDeletePartsThroughService() {
        // Given
        Part partToBeDeleted = new Part("Stefan");
        Part partToBeDeleted1 = new Part("Henrik");
        // When
        partsService.deletePart(partToBeDeleted);
        partsService.deletePart(partToBeDeleted1);
        // Then
        assertThat(partsRepository.getPart()).doesNotContain(partToBeDeleted);
        assertThat(partsRepository.getPart()).doesNotContain(partToBeDeleted1);
    }

}

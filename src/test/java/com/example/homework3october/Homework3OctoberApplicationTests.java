package com.example.homework3october;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Homework3OctoberApplicationTests {

    @MockBean
    PartsRepository partsRepository;

    @Autowired
    PartsService partsService;

    @Test
    void shouldReceivePartsFromRepository(){
        PartsRepository partsRepository1 = new PartsRepository();
        assertThat(partsRepository1.getPart().size()).isEqualTo(2);
    }

    @Test
    void shouldAddPartsToRepository(){
        PartsRepository partsRepository1 = new PartsRepository();
        partsRepository1.addPart(new Part("test"));
        assertThat(partsRepository1.getPart().size()).isEqualTo(3);
    }


}

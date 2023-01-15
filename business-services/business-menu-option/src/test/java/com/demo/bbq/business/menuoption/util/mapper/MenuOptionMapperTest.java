package com.demo.bbq.business.menuoption.util.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import com.demo.bbq.support.util.JsonFileReader;
import com.google.gson.Gson;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MenuOptionMapperTest {

    private MenuOptionMapper mapper = Mappers.getMapper(MenuOptionMapper.class);

    private MenuOption menuOption;

    private MenuOptionResponse menuOptionResponse;

    private MenuOptionRequest menuOptionRequest;

    /**
     * Método que pre carga la data necesaria para ejecutar las pruebas unitarias.
     */
    @BeforeEach
    public void setup() throws IOException {

        menuOption = JsonFileReader
                .getAnElement("data/model/menuoption/entity/MenuOption.json", MenuOption.class);

        menuOptionResponse = JsonFileReader
            .getAnElement("data/model/menuoption/dto/response/MenuOptionResponse.json", MenuOptionResponse.class);

        menuOptionRequest= JsonFileReader
            .getAnElement("data/model/menuoption/dto/request/MenuOptionRequest.json", MenuOptionRequest.class);
    }

    @Test
    public void fromEntityToResponse() {
        String expected = new Gson().toJson(menuOptionResponse);
        String actual = new Gson().toJson(mapper.fromEntityToResponse(menuOption));

        assertEquals(expected, actual);
    }

    @Test
    public void fromRequestToEntity() {
        MenuOption currentMenuOption = menuOption;
        menuOption.setId(null);

        String expected = new Gson().toJson(currentMenuOption);
        String actual = new Gson().toJson(mapper.fromRequestToEntity(menuOptionRequest));

        assertEquals(expected, actual);
    }

}
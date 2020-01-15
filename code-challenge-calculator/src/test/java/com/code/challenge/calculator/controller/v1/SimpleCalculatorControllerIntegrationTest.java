package com.code.challenge.calculator.controller.v1;

import com.code.challenge.calculator.dto.request.SimpleOperation;
import com.code.challenge.calculator.dto.request.SimpleOperationCommandDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SimpleCalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addOperationTest() throws Exception {
        this.mockMvc.perform(get("/v1/simpleCalculator/7/add/8")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("15")));
    }

    @Test
    public void subtractOperationTest() throws Exception {
        this.mockMvc.perform(get("/v1/simpleCalculator/17/sub/8")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("9")));
    }

    @Test
    public void multipleOperationTest() throws Exception {
        this.mockMvc.perform(get("/v1/simpleCalculator/10/mul/20")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("200")));
    }

    @Test
    public void divideOperationTest() throws Exception {
        this.mockMvc.perform(get("/v1/simpleCalculator/16/div/8")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("2")));
    }

    @Test
    public void divideToZeroTest() throws Exception {
        this.mockMvc.perform(get("/v1/simpleCalculator/16/div/0"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().string(containsString("zero")));
        ;
    }

    @Test
    public void addWithInputDtoTest() throws Exception {
        SimpleOperationCommandDTO dto = new SimpleOperationCommandDTO();
        dto.setFirstOperator(10d);
        dto.setSecondOperator(15d);
        dto.setOperation(SimpleOperation.ADD);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/simpleCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("25")));
    }

    @Test
    public void subtractWithInputDtoTest() throws Exception {
        SimpleOperationCommandDTO dto = new SimpleOperationCommandDTO();
        dto.setFirstOperator(25d);
        dto.setSecondOperator(15d);
        dto.setOperation(SimpleOperation.SUB);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/simpleCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("10")));
    }

    @Test
    public void multipleWithInputDtoTest() throws Exception {
        SimpleOperationCommandDTO dto = new SimpleOperationCommandDTO();
        dto.setFirstOperator(5d);
        dto.setSecondOperator(5d);
        dto.setOperation(SimpleOperation.MUL);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/simpleCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("25")));
    }

    @Test
    public void divideWithInputDtoTest() throws Exception {
        SimpleOperationCommandDTO dto = new SimpleOperationCommandDTO();
        dto.setFirstOperator(25d);
        dto.setSecondOperator(5d);
        dto.setOperation(SimpleOperation.DIV);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/simpleCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("5")));
    }

    @Test
    public void divideToZeroWithInputDtoTest() throws Exception {
        SimpleOperationCommandDTO dto = new SimpleOperationCommandDTO();
        dto.setFirstOperator(10d);
        dto.setSecondOperator(0d);
        dto.setOperation(SimpleOperation.DIV);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/simpleCalculator/generic").
                contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(content().string(containsString("zero")));
    }
}
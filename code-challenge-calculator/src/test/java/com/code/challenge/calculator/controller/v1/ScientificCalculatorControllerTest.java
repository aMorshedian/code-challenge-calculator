package com.code.challenge.calculator.controller.v1;

import com.code.challenge.calculator.dto.request.ScientificOperation;
import com.code.challenge.calculator.dto.request.ScientificOperationCommandDTO;
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
public class ScientificCalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void factorialTest() throws Exception {
        this.mockMvc.perform(get("/v1/scientificCalculator/factorial/3")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("6")));
    }

    @Test
    public void factorialInvalidInputTest() throws Exception {
        this.mockMvc.perform(get("/v1/scientificCalculator/factorial/-1"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void factorialBigInputTest() throws Exception {
        this.mockMvc.perform(get("/v1/scientificCalculator/factorial/111"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void squareTest() throws Exception {
        this.mockMvc.perform(get("/v1/scientificCalculator/square/9")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("3")));
    }

    @Test
    public void squareInvalidInputTest() throws Exception {
        this.mockMvc.perform(get("/v1/scientificCalculator/square/-1"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void isPrimeTest() throws Exception {
        this.mockMvc.perform(get("/v1/scientificCalculator/is-prime/7")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    public void isPrimeInvalidInputTest() throws Exception {
        this.mockMvc.perform(get("/v1/scientificCalculator/is-prime/1.55"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void factorialWithInputDtoTest() throws Exception {
        ScientificOperationCommandDTO dto = new ScientificOperationCommandDTO();
        dto.setOperator(3d);
        dto.setOperation(ScientificOperation.FAC);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/scientificCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("6")));
    }

    @Test
    public void factorialInvalidInpuntWithInputDtoTest() throws Exception {
        ScientificOperationCommandDTO dto = new ScientificOperationCommandDTO();
        dto.setOperator(-3d);
        dto.setOperation(ScientificOperation.FAC);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/scientificCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void squareWithInputDtoTest() throws Exception {
        ScientificOperationCommandDTO dto = new ScientificOperationCommandDTO();
        dto.setOperator(81d);
        dto.setOperation(ScientificOperation.SQR);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/scientificCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("9")));
    }

    @Test
    public void squareInvalidInputWithInputDtoTest() throws Exception {
        ScientificOperationCommandDTO dto = new ScientificOperationCommandDTO();
        dto.setOperator(-1d);
        dto.setOperation(ScientificOperation.SQR);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/scientificCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void isPrimeWithInputDtoTest() throws Exception {
        ScientificOperationCommandDTO dto = new ScientificOperationCommandDTO();
        dto.setOperator(17d);
        dto.setOperation(ScientificOperation.PRM);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/scientificCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    public void isPrimeInvalidInputWithInputDtoTest() throws Exception {
        ScientificOperationCommandDTO dto = new ScientificOperationCommandDTO();
        dto.setOperator(1.25);
        dto.setOperation(ScientificOperation.PRM);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        this.mockMvc.perform(put("/v1/scientificCalculator/generic")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }
}

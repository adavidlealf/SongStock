package com.poli.songstock.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poli.songstock.controller.AprobacionController;
import com.poli.songstock.domain.AprobacionDTO;
import com.poli.songstock.service.AprobacionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

@WebMvcTest(AprobacionController.class)
public class AprobacionRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AprobacionService controller;

    @Autowired
    private ObjectMapper objectMapper;

    private AprobacionDTO aprobacion;

    @BeforeEach
    public void setup() {
        aprobacion = new AprobacionDTO();
        aprobacion.setId(1L);
        aprobacion.setDescripcion("prueba");
        aprobacion.setEstado("Aprobado");
    }

    @Test
    public void testSaveAprobacion() throws Exception {
        AprobacionDTO savedAprobacion = new AprobacionDTO();
        savedAprobacion.setId(8000L);
        savedAprobacion.setDescripcion("prueba");
        savedAprobacion.setEstado("Aprobado");

        Mockito.when(controller.save(Mockito.any(AprobacionDTO.class))).thenReturn(savedAprobacion);

        mockMvc.perform(post("/aprobacion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aprobacion)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/aprobacion/8000"))
                .andExpect(jsonPath("$.id").value(8000L))
                .andExpect(jsonPath("$.descripcion").value("prueba"))
                .andExpect(jsonPath("$.estado").value("Aprobado"));
    }

    @Test
    public void testFindAllAprobacion() throws Exception {
        AprobacionDTO aprobacion2 = new AprobacionDTO();
        aprobacion2.setId(2L);
        aprobacion2.setDescripcion("prueba2");
        aprobacion2.setEstado("Pendiente");

        Mockito.when(controller.findAll()).thenReturn(Arrays.asList(aprobacion, aprobacion2));

        mockMvc.perform(get("/aprobacion")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].descripcion").value("prueba"))
                .andExpect(jsonPath("$[0].estado").value("Aprobado"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].descripcion").value("prueba2"))
                .andExpect(jsonPath("$[1].estado").value("Pendiente"));
    }

    @Test
    public void testFindById() throws Exception {
        Mockito.when(controller.findById(1L)).thenReturn(Optional.of(aprobacion));

        mockMvc.perform(get("/aprobacion/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.descripcion").value("prueba"))
                .andExpect(jsonPath("$.estado").value("Aprobado"));
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        Mockito.when(controller.findById(777777L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/aprobacion/777777")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}

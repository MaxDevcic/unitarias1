package com.pruebas1.unitarias1.service;

import com.pruebas1.unitarias1.model.Mascota;
import com.pruebas1.unitarias1.repository.MascotaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/*import java.util.Optional;*/
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class MascotaServiceTest {

    @Mock /*Maqueta de algo, réplica del asunto*/
    private MascotaRepository mascotaRepository;

    @InjectMocks /*Instancia */
    private MascotaService mascotaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    /* Test para guardar mascota en la capa servicio */
    @Test
    void testGuardarMascota() {
        Mascota mascota = new Mascota(null, "Rex", "Perro", 5);
        Mascota mascotaGuardada = new Mascota(1L, "Rex", "Perro", 5);
        when(mascotaRepository.save(mascota)).thenReturn(mascotaGuardada);

        Mascota resultado = mascotaService.guardarMascota(mascota);
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getNombre()).isEqualTo("Rex");
        assertThat(resultado.getTipo()).isEqualTo("Perro");
        assertThat(resultado.getEdad()).isEqualTo(5);
        verify(mascotaRepository).save(mascota);
    }

     @Test
    void testListarMascotas() {
        Mascota m1 = new Mascota(1L, "Rex", "Perro", 5);
        Mascota m2 = new Mascota(2L, "Michi", "Gato", 2);
        when(mascotaRepository.findAll()).thenReturn(Arrays.asList(m1, m2));

        List<Mascota> resultado = mascotaService.listarMascotas();
        assertThat(resultado).hasSize(2).contains(m1, m2);
        verify(mascotaRepository).findAll();
    }

    @Test
    void testObtenerMascotaPorId() {
        Mascota mascotaencontrada = new Mascota(1L, "Rex", "Perro", 5);
        when(mascotaRepository.findById(1L)).thenReturn(Optional.of(mascotaencontrada));

        Optional<Mascota> resultado = mascotaService.obtenerMascotaPorId(1L);
        //assertThat(resultado.get().getId()).isEqualTo(1L);
        assertThat(resultado).isPresent().contains(mascotaencontrada);
        verify(mascotaRepository).findById(1L);
    }

    
     @Test
     void testActualizarMascota() {
        Mascota mascotaAntigua = new Mascota(1L, "Rex", "Perro", 5);
        Mascota mascotaNueva = new Mascota(1L, "Rex", "Perro", 6);
        when(mascotaRepository);
     }
     
}

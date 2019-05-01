package br.com.touchapps.pontoeletronico.service;

import br.com.touchapps.pontoeletronico.entities.Funcionario;
import br.com.touchapps.pontoeletronico.repositories.FuncionarioRepository;
import br.com.touchapps.pontoeletronico.services.FuncionarioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
        BDDMockito.given(this.funcionarioRepository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(new Funcionario()));
        BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
        BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
    }

    @Test
    public void testPersistirFuncionario() {
        Funcionario funcionario = this.funcionarioService.salvar(new Funcionario());

        assertNotNull(funcionario);
    }

    @Test
    public void testBuscarFuncionarioPorId() {
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorId(1L);

        assertTrue(funcionario.isPresent());
    }

    @Test
    public void testBuscarFuncionarioPorEmail() {
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail("email@email.com");

        assertTrue(funcionario.isPresent());
    }

    @Test
    public void testBuscarFuncionarioPorCpf() {
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCPF("24291173474");

        assertTrue(funcionario.isPresent());
    }

}
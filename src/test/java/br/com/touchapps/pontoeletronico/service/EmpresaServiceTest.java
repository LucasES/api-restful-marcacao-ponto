package br.com.touchapps.pontoeletronico.service;

import br.com.touchapps.pontoeletronico.entities.Empresa;
import br.com.touchapps.pontoeletronico.repositories.EmpresaRepository;
import br.com.touchapps.pontoeletronico.services.EmpresaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

    @MockBean
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    private static final String CNPJ =  "51463645000100";

    @Before
    public void setUp() {
        BDDMockito.given(this.empresaRepository.findByCnpj(anyString())).willReturn(new Empresa());
        BDDMockito.given(this.empresaRepository.save(any(Empresa.class))).willReturn(new Empresa());
    }

    @Test
    public void testBuscarPorCNPJ() {
        Optional<Empresa> empresa = this.empresaService.buscarPorCNPJ(CNPJ);

        assertTrue(empresa.isPresent());
    }

    @Test
    public void testPersistirEmpresa() {
        Empresa empresaPersistida = this.empresaService.salvar(new Empresa());

        assertNotNull(empresaPersistida);
    }
}

package br.com.touchapps.pontoeletronico.utils;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class UtilTest {

    @Test
    public void deveRetornarTrueAoTestarValorNulo() {
        assertTrue(Util.isNullOrEmpty(null));
    }

    @Test
    public void testaValorPreenchido(){
        String str = "Test";

        assertFalse(Util.isNullOrEmpty(str));
    }
}

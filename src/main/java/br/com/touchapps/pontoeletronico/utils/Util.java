package br.com.touchapps.pontoeletronico.utils;

/**
 * Util responsável em centralizar métodos estáticos para melhorar a legibilidade do código.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
public class Util {

    /**
     * Este método tem como objetivo verificar se uma determinar string é nula ou vázio.
     *
     * @param str
     *
     * @return true se a string for nula ou vázia.
     */
    public static final boolean isNullOrEmpty(String str) {

        return str == null || str.trim().isEmpty();
    }
}

package br.com.touchapps.pontoeletronico.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável em centralizar os dados de resposta da camada de controller.
 *
 * @param <T>
 * @author Lucas Araújo
 * @version 1.0
 */
public class Response<T> {

    private T data;
    private List<String> errors;

    public Response() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}
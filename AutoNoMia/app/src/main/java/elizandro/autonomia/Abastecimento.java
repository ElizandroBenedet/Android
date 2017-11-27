package elizandro.autonomia;

import java.util.ArrayList;

/**
 * Created by elizandro on 22/11/17.
 */

public class Abastecimento {
    private String posto;
    private Double litros;
    private  String data;
    private Double quilometragem;


    public Abastecimento(Double quilometragem, Double litros, String data, String posto ){
        this.posto = posto;
        this.data = data;
        this.quilometragem = quilometragem;
        this.litros = litros;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public Double getLitros() {
        return litros;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }
}

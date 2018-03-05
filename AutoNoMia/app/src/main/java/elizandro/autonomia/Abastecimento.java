package elizandro.autonomia;

import io.realm.RealmObject;

/**
 * Created by elizandro on 22/11/17.
 */

public class Abastecimento extends RealmObject{


    private Posto posto;
    private Double litros;
    private String data;
    private Double quilometragem;
    private String combustivel;
    private Double preco;
    private int ID;

    public Abastecimento(){}
    public Abastecimento(Double quilometragem, Double litros, String data, String Combustivel, Posto posto, int ID){
        this.combustivel = Combustivel;
        this.data = data;
        this.quilometragem = quilometragem;
        this.litros = litros;
        this.posto = posto;
        this.setID(ID);
        if(combustivel.equals("Gasolina")){
            this.preco = litros * posto.getPrecoGasolina();
        }else if(combustivel.equals("Alcool")){
            this.preco =litros * posto.getPrecoAlcool();
        }
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

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

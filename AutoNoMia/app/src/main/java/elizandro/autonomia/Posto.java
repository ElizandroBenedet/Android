package elizandro.autonomia;

import io.realm.RealmObject;

/**
 * Created by elizandro on 29/11/17.
 */

public class Posto extends RealmObject{

    private int ID;
    private String bandeira;
    private String nome;
    private Double precoGasolina;
    private Double precoAlcool;

    public Posto(){}
    public Posto(String bandeira, String nome, Double precoGasosa, Double precoAlcool, int ID){
        this.bandeira = bandeira;
        this.nome = nome;
        this.precoAlcool = precoAlcool;
        this.precoGasolina = precoGasosa;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasosina(Double precoGasosina) {
        this.precoGasolina = precoGasosina;
    }

    public Double getPrecoAlcool() {
        return precoAlcool;
    }

    public void setPrecoAlcool(Double precoAlcool) {
        this.precoAlcool = precoAlcool;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

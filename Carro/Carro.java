package Carro;

import java.io.Serializable;

public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public int id;
    public String modelo;
    public String marca;
    public int ano;
    public String cor;
    public Double preco;
    public Double custo;
    public Double lucro;

    public Carro(String modelo, String marca, int ano, String cor, Double preco, Double custo) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.custo = custo;
        this.lucro = this.getLucro();
    }

    public Carro(){
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(String ano) throws Exception {
        try {
            if(ano.length() != 4){
                throw new Exception("Ano inválido");
            }
            this.ano = Integer.parseInt(ano);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.ano = 0; // default value
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getLucro() {
        if(this.lucro == null){
            this.setLucro();
        }
        return lucro;
    }

    public void setLucro() {
        this.lucro = this.preco - this.custo;
    }

    @Override
    public String toString() {
        return "Carro " + this.id + ": modelo: " + modelo + ", marca: " + marca + ", ano: " + ano + ", cor: " + cor + ", preco: " + preco
                + ", custo: " + custo + ", lucro: " + lucro;
    }
}

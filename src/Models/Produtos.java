package Models;

import java.io.Serializable;

public class Produtos implements Serializable {
    
    private String nomeProduto;
    private String idProduto;
    private int quantProduto;
    private String tipoProduto;
    private double precoProduto;
    
    public Produtos(){
    }

    public Produtos(String nomeProduto, String idProduto, int quantProduto, String tipoProduto, double precoProduto) {
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.quantProduto = quantProduto;
        this.tipoProduto = tipoProduto;
        this.precoProduto = precoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Produtos{" + "nomeProduto=" + nomeProduto + ", idProduto=" + idProduto + ", quantProduto=" + quantProduto + ", tipoProduto=" + tipoProduto + ", precoProduto=" + precoProduto + "\n"+'}';
    }
}

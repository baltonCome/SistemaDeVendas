package Models;

import java.io.Serializable;

public class Vendas implements Serializable{
    
    private String nomeCliente;
    private String nomeProduto;
    private String iDProduto;
    private int nrProdutos;
    private String tipoProduto;
    private double precoProduto;
    private double valorGasto;
    private String vendedor;
    
    public Vendas(){      
    }

    public Vendas(String nomeCliente, String nomeProduto, String iDProduto, int nrProdutos, String tipoProduto, double precoProduto, double valorGasto, String vendedor) {
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.iDProduto = iDProduto;
        this.nrProdutos = nrProdutos;
        this.tipoProduto = tipoProduto;
        this.precoProduto = precoProduto;
        this.valorGasto = valorGasto;
        this.vendedor = vendedor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getiDProduto() {
        return iDProduto;
    }

    public void setiDProduto(String iDProduto) {
        this.iDProduto = iDProduto;
    }

    public int getNrProdutos() {
        return nrProdutos;
    }

    public void setNrProdutos(int nrProdutos) {
        this.nrProdutos = nrProdutos;
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

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    @Override
    public String toString() {
        return "Vendas{" + "nomeCliente=" + nomeCliente + ", nomeProduto=" + nomeProduto + ","
                + " iDProduto=" + iDProduto + ", nrProdutos=" + nrProdutos + ", tipoProduto=" + tipoProduto + 
                ", precoProduto=" + precoProduto + ", valorGasto=" + valorGasto +", vendedor="+ vendedor + '}';
    }
    
}

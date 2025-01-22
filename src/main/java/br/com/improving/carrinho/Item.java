package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto       Produto associado ao item.
     * @param valorUnitario Valor unitário do produto.
     * @param quantidade    Quantidade do produto.
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
        if (produto == null || valorUnitario == null || valorUnitario.compareTo(BigDecimal.ZERO) <= 0 || quantidade <= 0) {
            throw new IllegalArgumentException("Produto, valor unitário e quantidade devem ser válidos.");
        }
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Retorna a quantidade do item.
     *
     * @return int
     */
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setValorUnitario(BigDecimal valorUnitario) {
        if (valorUnitario == null || valorUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor unitário deve ser válido.");
        }
        this.valorUnitario = valorUnitario;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantidade == item.quantidade &&
                Objects.equals(produto, item.produto) &&
                Objects.equals(valorUnitario, item.valorUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, valorUnitario, quantidade);
    }

    @Override
    public String toString() {
        return "Item{" +
                "produto=" + produto +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                '}';
    }
}

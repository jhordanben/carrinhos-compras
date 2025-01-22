package br.com.improving.carrinho;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;
    private String nomeProduto;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(String nomeProduto, Long codigo, String descricao) {
        if (nomeProduto == null || nomeProduto.isEmpty() || descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Nome e descrição não podem ser vazios.");
        }
        this.nomeProduto = nomeProduto;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o código do produto.
     *
     * @return Long
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
        return descricao;
    }
}

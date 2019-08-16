package rp;

import rp.Submissao;

class SubmissaoApresentacao extends Submissao {

    protected String resumo, abs;
    protected int duracao;

    /**
     * Metodo Construtor de Submissão Apresentação
     *
     * @param codigo
     * @param situacao
     * @param titulo
     * @param autor
     * @param nautor
     */
    public SubmissaoApresentacao(int codigo, int situacao, String titulo, String[] autor, int nautor) {
        super(codigo, situacao, titulo, autor, nautor);
        this.resumo = "";
        this.abs = "";
        this.duracao = 0;
    }

    /**
     * Metodo para mudar Resumo
     *
     * @param resumo
     */
    @Override
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * Metodo para mudar Abstract
     *
     * @param abs
     */
    @Override
    public void setAbs(String abs) {
        this.abs = abs;
    }

    /**
     * Metodo para mudar Duração
     *
     * @param duracao
     */
    @Override
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Metodo para pegar Resumo
     *
     * @return Resumo
     */
    @Override
    public String getResumo() {
        return this.resumo;
    }

    /**
     * Metodo para pegar Abstract
     *
     * @return Abstract
     */
    @Override
    public String getAbs() {
        return this.abs;
    }

    /**
     * Metodo para pegar Duração
     *
     * @return Duração
     */
    @Override
    public int getDuracao() {
        return this.duracao;
    }

    /**
     * Metodo que trasforma todos os atributos em string
     *
     * @return uma string com tods os atributos
     */
    @Override
    public String toString() {
        return super.toString() + "Resumo: " + this.resumo + "\nAbstract: " + this.abs + "\nDuração: " + this.duracao + "\n";
    }

}

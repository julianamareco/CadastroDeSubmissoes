package rp;

import rp.Enum;

class Monografia extends SubmissaoCientifica {

    private int tipo, ano, npag;
    private String orien, curso, resumo, abs;

    /**
     * Metodo Construtor de Monografia
     *
     * @param codigo
     * @param situacao
     * @param titulo
     * @param autor
     * @param nautor
     */
    public Monografia(int codigo, int situacao, String titulo, String[] autor, int nautor) {
        super(codigo, situacao, titulo, autor, nautor);
        this.tipo = 0;
        this.ano = 0;
        this.npag = 0;
        this.orien = "";
        this.curso = "";
        this.resumo = "";
        this.abs = "";
    }

    /**
     * Metodo para mudar Tipo
     *
     * @param tipo
     */
    @Override
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para mudar Ano
     *
     * @param ano
     */
    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Metodo para mudar Número de Paginas
     *
     * @param npag
     */
    @Override
    public void setNpag(int npag) {
        this.npag = npag;
    }

    /**
     * Metodo para mudar Orientador
     *
     * @param orien
     */
    @Override
    public void setOrien(String orien) {
        this.orien = orien;
    }

    /**
     * Metodo para mudar Curso
     *
     * @param curso
     */
    @Override
    public void setCurso(String curso) {
        this.curso = curso;
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
     * Metodo para pegar Tipo
     *
     * @return Tipo
     */
    @Override
    public int getTipo() {
        return this.tipo;
    }

    /**
     * Metodo para pegar Ano
     *
     * @return Ano
     */
    @Override
    public int getAno() {
        return this.ano;
    }

    /**
     * Metodo para pegar Número de Paginas
     *
     * @return Número de Paginas
     */
    @Override
    public int getNpag() {
        return this.npag;
    }

    /**
     * Metodo para pegar Orientador
     *
     * @return Orientador
     */
    @Override
    public String getOrien() {
        return this.orien;
    }

    /**
     * Metodo para pegar Curso
     *
     * @return Curso
     */
    @Override
    public String getCurso() {
        return this.curso;
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
     * Metodo que trasforma todos os atributos em string
     *
     * @return uma string com tods os atributos
     */
    @Override
    public String toString() {
        String tip = "";
        switch (this.tipo) {
            case 0:
                tip = Enum.Tipo.G.getTip();
                break;
            case 1:
                tip = Enum.Tipo.E.getTip();
                break;
            case 2:
                tip = Enum.Tipo.M.getTip();
                break;
            case 3:
                tip = Enum.Tipo.D.getTip();
                break;
        }

        return super.toString() + "Resumo: " + this.resumo + "\nAbstract: " + this.abs + "\nCurso: " + this.curso + "\nOrientador: " + this.orien + "\nNúmero de Paginas: " + this.npag + "\nAno: " + this.ano + "\nTipo: " + tip + "\n\n";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

/**
 *
 * @author Juliana Mareco
 */
class Minicurso extends SubmissaoApresentacao {

    private String recursos, metodologia;
    /**
     * Metodo Construtor de Minicurso
     * @param codigo
     * @param situacao
     * @param titulo
     * @param autor
     * @param nautor 
     */
    public Minicurso(int codigo, int situacao, String titulo, String[] autor, int nautor) {
        super(codigo, situacao, titulo, autor, nautor);
        this.recursos = "";
        this.metodologia = "";
    }
    /**
     * Metodo para mudar Recursos
     *
     * @param recursos
     */
    @Override
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }
    /**
     * Metodo para mudar Metodologia
     * @param metodologia 
     */
    @Override
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }
    /**
     * Metodo para pegar Recursos
     * @return Recursos
     */
    @Override
    public String getRecursos() {
        return this.recursos;
    }
    /**
     * Metodo para pegar Metodologia
     * @return Metodologia
     */
    @Override
    public String getMetodologia() {
        return this.metodologia;
    }
  /**
    * Metodo que trasforma todos os atributos em string
    * @return uma string com tods os atributos
    */
    @Override
    public String toString() {
        return super.toString() + "Recursos: " + this.recursos + "\n" + "Metodologia: " + this.metodologia + "\n";
    }

}

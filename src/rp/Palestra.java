package rp;

/**
 *
 * @author Filipe
 */
class Palestra extends SubmissaoApresentacao {

    private String curriculo;

    /**
     * Metodo Construtor de Palestra
     *
     * @param codigo
     * @param situacao
     * @param titulo
     * @param autor
     * @param nautor
     */
    public Palestra(int codigo, int situacao, String titulo, String[] autor, int nautor) {
        super(codigo, situacao, titulo, autor, nautor);
        this.curriculo = "";
    }

    /**
     * Metodo para mudar Curriculo
     *
     * @param recursos
     */
    @Override
    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    /**
     * Metodo para capturar Curriculo
     *
     * @param recursos
     */
    @Override
    public String getCurriculo() {
        return curriculo;
    }

    /**
     * Metodo que trasforma todos os atributos em string
     *
     * @return uma string com tods os atributos
     */
    @Override
    public String toString() {
        return super.toString() + "Curriculo: " + this.curriculo + "\n";
    }

}

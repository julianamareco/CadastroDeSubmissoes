package rp;

import rp.Submissao;

class SubmissaoCientifica extends Submissao {

    protected String[] instituicao, palavraChave;
    protected int ninstituicao, npalavraChave;

    /**
     * Metodo construtor de Submissao cientifica
     *
     * @param codigo
     * @param situacao
     * @param titulo
     * @param autor
     * @param nautor
     */
    public SubmissaoCientifica(int codigo, int situacao, String titulo, String[] autor, int nautor) {
        super(codigo, situacao, titulo, autor, nautor);
        //this.instituicao = "";
        //this.palavraChave = "";
    }

    /**
     * Metodo para mudar as Intituições
     *
     * @param instituicao
     * @param ninstituicao
     * @return um boolean com o resultado da operação
     */
    @Override
    public boolean setInstituicao(String[] instituicao, int ninstituicao) {
        if (instituicao.length <= ninstituicao) {
            this.instituicao = instituicao;
            return true;
        }
        return false;
    }

    /**
     * Metodo para mudar as Palavras Chave
     *
     * @param palavraChave
     * @param npalavraChave
     * @return um boolean com o resultado da operação
     */
    @Override
    public boolean setPalavraChave(String[] palavraChave, int npalavraChave) {
        if (palavraChave.length <= npalavraChave) {
            this.palavraChave = palavraChave;
            return true;
        }
        return false;
    }

    /**
     * Metodo para pegar Instituição
     *
     * @return Instituição
     */
    @Override
    public String[] getInstituicao() {
        return this.instituicao;
    }

    /**
     * Metodo para pegar Palavras Chave
     *
     * @return Palavras Chave
     */
    @Override
    public String[] getPalavraChave() {
        return this.palavraChave;
    }

    /**
     * Metodo que trasforma todos os atributos em string
     *
     * @return uma string com tods os atributos
     */
    @Override
    public String toString() {
        String instituicoes = "";
        for (int i = 0; i < instituicao.length; i++) {
            instituicoes += instituicao[i] + ", ";
        }

        String palavraChaves = "";
        for (int i = 0; i < palavraChave.length; i++) {
            palavraChaves += palavraChave[i] + ", ";
        }
        return super.toString() + "Instituição(ões): " + instituicoes + "\nPalavras chave: " + palavraChaves + "\n";
    }

}

package rp;

abstract class Submissao {

    protected int codigo, situacao, nautor;
    protected String titulo;
    protected String[] autor;

    /**
     * Metodo Construtor de Submissao
     *
     * @param codigo
     * @param situacao
     * @param titulo
     * @param autor
     * @param nautor
     */
    public Submissao(int codigo, int situacao, String titulo, String[] autor, int nautor) {
        this.codigo = codigo;
        this.situacao = situacao;
        this.titulo = titulo;
        this.autor = autor;
        this.nautor = nautor;
    }

    /**
     * Metodo para mudar
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo para mudar Situação
     *
     * @param situacao
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    /**
     * Metodo para mudar Titulo
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo para mudar o Autor
     *
     * @param autor
     * @param nautor
     * @return boolean para o que aconteceu
     */
    public boolean setAutor(String[] autor, int nautor) {
        if (autor.length <= nautor) {
            this.autor = autor;
            return true;
        }
        return false;
    }

    /**
     * Metodo para pegar Codigo
     *
     * @return Codigo
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Metodo para pegar Situação
     *
     * @return Situação
     */
    public int getSituacao() {
        return this.situacao;
    }

    /**
     * Metodo para pegar Autor
     *
     * @return Autor
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Metodo para pegar Autor
     *
     * @return Autor
     */
    public String[] getAutor() {
        return this.autor;
    }

    /**
     * Metodo para pegar Número de Autor
     *
     * @return Número de Autor
     */
    public int getnAutor() {
        return this.nautor;
    }

    /**
     * Metodo que trasforma todos os atributos em string
     *
     * @return uma string com tods os atributos
     */
    @Override
    public String toString() {
        String sit = "";
        
        switch (this.situacao) {
            case 0:
                sit = Enum.Situacao.SA.getSitua();
                break;
            case 1:
                sit = Enum.Situacao.A.getSitua();
                break;
            case 2:
                sit = Enum.Situacao.R.getSitua();
                break;
        }
        String autores = "";
        for (int i = 0; i < autor.length; i++) {
            autores += autor[i] + ", ";
        }

        return "\nCódigo: " + this.codigo + "\nSituação: " + sit + "\nTítulo: " + this.titulo + "\nAutor(es): " + autores + "\n";
    }

    /**
     * Metodo para mudar Resumo
     *
     * @param resumo
     */
    public void setResumo(String resumo) {
    }

    /**
     * Metodo para mudar Abstract
     *
     * @param abs
     */
    public void setAbs(String abs) {
    }

    /**
     * Metodo para pegar Resumo
     *
     * @return Resumo
     */
    public String getResumo() {
        return "";
    }

    /**
     * Metodo para pegar Abstract
     *
     * @return Abstract
     */
    public String getAbs() {
        return "";
    }

    /**
     * Metodo para mudar as Intituições
     *
     * @param instituicao
     * @param ninstituicao
     * @return um boolean com o resultado da operação
     */
    public boolean setInstituicao(String[] instituicao, int ninstituicao) {
        return true;
    }

    /**
     * Metodo para mudar as Palavras Chave
     *
     * @param palavraChave
     * @param npalavraChave
     * @return um boolean com o resultado da operação
     */
    public boolean setPalavraChave(String[] palavraChave, int npalavraChave) {
        return true;
    }

    /**
     * Metodo para pegar Instituição
     *
     * @return Instituição
     */
    public String[] getInstituicao() {
        String[] a = new String[0];
        return a;
    }

    /**
     * Metodo para pegar Palavras Chave
     *
     * @return Palavras Chave
     */
    public String[] getPalavraChave() {
        String[] a = new String[0];
        return a;
    }

    /**
     * Metodo para mudar Tipo
     *
     * @param tipo
     */
    public void setTipo(int tipo) {

    }

    /**
     * Metodo para mudar Orientador
     *
     * @param orien
     */
    public void setOrien(String orien) {

    }

    /**
     * Metodo para mudar Curso
     *
     * @param curso
     */
    public void setCurso(String curso) {

    }

    /**
     * Metodo para mudar Ano
     *
     * @param ano
     */
    public void setAno(int ano) {

    }

    /**
     * Metodo para mudar Número de Paginas
     *
     * @param npag
     */
    public void setNpag(int npag) {

    }

    /**
     * Metodo para pegar Tipo
     *
     * @return Tipo
     */
    public int getTipo() {

        return 0;
    }

    /**
     * Metodo para pegar Orientador
     *
     * @return Orientador
     */
    public String getOrien() {

        return "";
    }

    /**
     * Metodo para pegar Curso
     *
     * @return Curso
     */
    public String getCurso() {

        return "";
    }

    /**
     * Metodo para pegar Ano
     *
     * @return Ano
     */
    public int getAno() {

        return 0;
    }

    /**
     * Metodo para pegar Número de Paginas
     *
     * @return Número de Paginas
     */
    public int getNpag() {

        return 0;
    }

    /**
     * Metodo para mudar Metodologia
     *
     * @param metodologia
     */
    public void setMetodologia(String metodologia) {

    }

    /**
     * Metodo para mudar Recursos
     *
     * @param recursos
     */
    public void setRecursos(String recursos) {
    }

    /**
     * Metodo para pegar Metodologia
     *
     * @return Metodologia
     */
    public String getMetodologia() {
        return "";
    }

    /**
     * Metodo para pegar Recursos
     *
     * @return Recursos
     */
    public String getRecursos() {
        return "";
    }

    /**
     * Metodo para mudar Duração
     *
     * @param duracao
     */
    public void setDuracao(int duracao) {

    }

    /**
     * Metodo para pegar Duração
     *
     * @return Duração
     */
    public int getDuracao() {
        return 0;
    }

    /**
     * Metodo para mudar Curriculo
     *
     * @return Curriculo
     */
    public void setCurriculo(String curriculo) {

    }

    /**
     * Metodo para pegar Curriculo
     *
     * @return Curriculo
     */
    public String getCurriculo() {

        return "";

    }

}

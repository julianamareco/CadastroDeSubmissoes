package rp;

class Artigo extends SubmissaoCientifica {

   private String resumo, abs;

   /**
    *Metodo Construtor de Artigo
    * @param codigo
    * @param situacao
    * @param titulo
    * @param autor
    * @param nautor
    */
   public Artigo(int codigo, int situacao, String titulo, String[] autor, int nautor) {
      super(codigo, situacao, titulo, autor, nautor);
      this.resumo = "";
      this.abs = "";
   }

   /**
    *Metodo para mudar Resumo
    * @param resumo
    */
   @Override
   public void setResumo(String resumo) {
      this.resumo = resumo;
   }
   /**
    * Metodo para mudar Abstract
    * @param abs 
    */
   @Override
   public void setAbs(String abs) {
      this.abs = abs;
   }
   /**
    * Metodo para pegar Resumo
    * @return Resumo
    */
   @Override
   public String getResumo() {
      return this.resumo;
   }
   /**
    * Metodo para pegar Abstract
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
      return super.toString() + "Resumo: " + this.resumo + "\nAbstract: " + this.abs + "\n";
   }
  
}

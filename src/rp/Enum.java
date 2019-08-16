/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;


public class Enum {

        
    
    /**
     * Enumerate do atributo situação.
     */
    public enum Situacao {
        A("Aprovado"), R("Reprovado"), SA("Sob Avaliação");

        private String situa;
        
        
        
        Situacao(String situa) {
            this.situa = situa;
        }

        /**
         * @return the situa
         */
        public String getSitua() {
            return situa;
        }
        

        
    }

    /**
     * Enumerate do atributo tipo.
     */
    public enum Tipo {
        G("Graduação"), E("Especialização"), M("Mestrado"), D("Doutorado");
        private String tip;

        Tipo(String tip) {
            this.tip = tip;
        }

        /**
         * @return the tip
         */
        public String getTip() {
            return tip;
        }

    }

}

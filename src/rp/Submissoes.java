package rp;

import java.util.ArrayList;
import java.util.List;

class Submissoes {
    //static private int situacao, sit;

    static private List<Submissao> submissoes = new ArrayList<>();

    /**
     * Metodo para inserir uma submissao na lista
     *
     * @param sub
     */
    public static void insere(Submissao sub) {
        submissoes.add(sub);
    }

    /**
     * Metodo para saber o tamanho da Lista
     *
     * @return tamanho
     */
    public static int tamanho() {
        return submissoes.size();
    }

    /**
     * Metogo para gerar o codigo de cada submissao
     *
     * @return codigo
     */
    public static int getLastCode() {
        int codigo;
        if (submissoes.size() < 1) {
            codigo = 0;
        } else {
            codigo = submissoes.get(submissoes.size() - 1).getCodigo() + 1;
        }
        return codigo;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do titulo
     *
     * @param titulo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaTituloMono(String titulo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Monografia.class)) {
                if (sub.getTitulo().contains(titulo)) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do autor
     *
     * @param autor
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaAutorMono(String autor) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Monografia.class)) {
                for (int i = 0; i < sub.getAutor().length; i++) {
                    if (sub.getAutor()[i].contains(autor)) {
                        achados.add(sub);
                    }
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do codigo
     *
     * @param codigo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaCodigoMono(int codigo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Monografia.class)) {
                if (sub.getCodigo() == codigo) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para excluir submissoes na lista atraves do titulo
     *
     * @param titulo
     * @return menssagem com o titulo da submissao excluida
     */
    public static String excluirPorTituloMono(String titulo) {
        String msg = "";
        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Monografia.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {
                    msg = submissoes.remove(i).getTitulo();
                }
            }
        }
        return msg;
    }

    /**
     * Metodo para editar submissoes na lista atraves do titulo e uma submissao
     * alterada
     *
     * @param titulo
     * @param mono
     */
    public static void editarPorTituloMono(String titulo, Submissao mono) {

        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Monografia.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {

                    if (!mono.getTitulo().equals("")) {
                        submissoes.get(i).setTitulo(mono.getTitulo());
                    }
                    if (mono.getSituacao() == 0 || mono.getSituacao() == 1 || mono.getSituacao() == 2) {
                        submissoes.get(i).setSituacao(mono.getSituacao());
                    }
                    if (!mono.getAutor()[0].equals("")) {
                        submissoes.get(i).setAutor(mono.getAutor(), 1);
                    }
                    if (!mono.getInstituicao()[0].equals("")) {
                        submissoes.get(i).setInstituicao(mono.getInstituicao(), 1);
                    }
                    if (!mono.getPalavraChave()[0].equals("")) {
                        submissoes.get(i).setPalavraChave(mono.getPalavraChave(), 4);
                    }
                    if (!mono.getResumo().equals("")) {
                        submissoes.get(i).setResumo(mono.getResumo());
                    }
                    if (mono.getTipo() == 0 || mono.getTipo() == 1 || mono.getTipo() == 2 || mono.getTipo() == 3) {
                        submissoes.get(i).setTipo(mono.getTipo());
                    }
                    if (!mono.getOrien().equals("")) {
                        submissoes.get(i).setOrien(mono.getOrien());
                    }
                    if (!mono.getCurso().equals("")) {
                        submissoes.get(i).setCurso(mono.getCurso());
                    }
                    if (mono.getAno() > 0) {
                        submissoes.get(i).setAno(mono.getAno());
                    }
                    if (mono.getNpag() > 0) {
                        submissoes.get(i).setNpag(mono.getNpag());
                    }

                }
            }
        }

    }

    /**
     * Metodo para consultar submissoes na lista atraves do titulo
     *
     * @param titulo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaTituloMinicurso(String titulo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Minicurso.class)) {
                if (sub.getTitulo().contains(titulo)) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do autor
     *
     * @param autor
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaAutorMinicurso(String autor) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Minicurso.class)) {
                for (int i = 0; i < sub.getAutor().length; i++) {
                    if (sub.getAutor()[i].contains(autor)) {
                        achados.add(sub);
                    }
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do codigo
     *
     * @param codigo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaCodigoMinicurso(int codigo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Minicurso.class)) {
                if (sub.getCodigo() == codigo) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para excluir submissoes na lista atraves do titulo
     *
     * @param titulo
     * @return menssagem com o titulo da submissao excluida
     */
    public static String excluirPorTituloMinicurso(String titulo) {
        String msg = "";
        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Minicurso.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {
                    msg = submissoes.remove(i).getTitulo();
                }
            }
        }
        return msg;
    }

    /**
     * Metodo para editar submissoes na lista atraves do titulo e uma submissao
     * alterada
     *
     * @param titulo
     * @param mini
     */
    public static void editarPorTituloMinicurso(String titulo, Submissao mini) {

        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Minicurso.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {

                    if (!mini.getTitulo().equals("")) {
                        submissoes.get(i).setTitulo(mini.getTitulo());
                    }
                    if (mini.getSituacao() == 0 || mini.getSituacao() == 1 || mini.getSituacao() == 2) {
                        submissoes.get(i).setSituacao(mini.getSituacao());
                    }
                    if (!mini.getAutor()[0].equals("")) {
                        submissoes.get(i).setAutor(mini.getAutor(), 3);
                    }
                    if (!mini.getMetodologia().equals("")) {
                        submissoes.get(i).setMetodologia(mini.getMetodologia());
                    }
                    if (!mini.getRecursos().equals("")) {
                        submissoes.get(i).setRecursos(mini.getRecursos());
                    }
                    if (mini.getDuracao() >= 0) {
                        submissoes.get(i).setDuracao(mini.getDuracao());
                    }
                    if (!mini.getResumo().equals("")) {
                        submissoes.get(i).setResumo(mini.getResumo());
                    }
                    if (!mini.getAbs().equals("")) {
                        submissoes.get(i).setAbs(mini.getAbs());
                    }

                }
            }

        }
    }

    /**
     * Metodo para consultar submissoes na lista atraves do titulo
     *
     * @param titulo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaTituloArtigo(String titulo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Artigo.class)) {
                if (sub.getTitulo().contains(titulo)) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do autor
     *
     * @param autor
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaAutorArtigo(String autor) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Artigo.class)) {
                for (int i = 0; i < sub.getAutor().length; i++) {
                    if (sub.getAutor()[i].contains(autor)) {
                        achados.add(sub);
                    }
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do codigo
     *
     * @param codigo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaCodigoArtigo(int codigo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Artigo.class)) {
                if (sub.getCodigo() == codigo) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Método que exclui um artigo recebendo um título por parâmetro
     * @param titulo
     * @return
     */
    public static String excluirPorTituloArtigo(String titulo) {
        String msg = "";
        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Artigo.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {
                    msg = submissoes.remove(i).getTitulo();
                }
            }
        }
        return msg;
    }

    /**
     * Metodo para editar submissoes na lista atraves do titulo e uma submissao
     * alterada
     *
     * @param titulo
     * @param art
     */
    public static void editarPorTituloArtigo(String titulo, Submissao art) {

        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Artigo.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {

                    if (!art.getTitulo().equals("")) {
                        submissoes.get(i).setTitulo(art.getTitulo());
                    }
                    if (art.getSituacao() == 0 || art.getSituacao() == 1 || art.getSituacao() == 2) {
                        submissoes.get(i).setSituacao(art.getSituacao());
                    }
                    if (!art.getAutor()[0].equals("")) {
                        submissoes.get(i).setAutor(art.getAutor(), 8);
                    }
                    if (!art.getInstituicao()[0].equals("")) {
                        submissoes.get(i).setInstituicao(art.getInstituicao(), 8);
                    }
                    if (!art.getPalavraChave()[0].equals("")) {
                        submissoes.get(i).setPalavraChave(art.getPalavraChave(), 4);
                    }
                    if (!art.getResumo().equals("")) {
                        submissoes.get(i).setResumo(art.getResumo());
                    }
                    if (!art.getAbs().equals("")) {
                        submissoes.get(i).setAbs(art.getAbs());
                    }

                }
            }
        }

    }

    /**
     * Metodo para consultar submissoes na lista atraves do titulo
     *
     * @param titulo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaTituloPalestra(String titulo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Palestra.class)) {
                if (sub.getTitulo().contains(titulo)) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do autor
     *
     * @param autor
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaAutorPalestra(String autor) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Palestra.class)) {
                for (int i = 0; i < sub.getAutor().length; i++) {
                    if (sub.getAutor()[i].contains(autor)) {
                        achados.add(sub);
                    }
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para consultar submissoes na lista atraves do codigo
     *
     * @param codigo
     * @return lista de submissoes encontradas
     */
    public static List<Submissao> consultaCodigoPalestra(int codigo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Palestra.class)) {
                if (sub.getCodigo() == codigo) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }

    /**
     * Metodo para excluir submissoes na lista atraves do titulo
     *
     * @param titulo
     * @return menssagem com o titulo da submissao excluida
     */
    public static String excluirPorTituloPalestra(String titulo) {
        String msg = "";
        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Palestra.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {
                    msg = submissoes.remove(i).getTitulo();
                }
            }
        }
        return msg;
    }

    /**
     * Metodo para editar submissoes na lista atraves do titulo e uma submissao
     * alterada
     *
     * @param titulo
     * @param pale
     */
    public static void editarPorTituloPalestra(String titulo, Submissao pale) {

        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Palestra.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {

                    if (!pale.getTitulo().equals("")) {
                        submissoes.get(i).setTitulo(pale.getTitulo());
                    }
                    if (pale.getSituacao() == 0 || pale.getSituacao() == 1 || pale.getSituacao() == 2) {
                        submissoes.get(i).setSituacao(pale.getSituacao());
                    }
                    if (!pale.getAutor()[0].equals("")) {
                        submissoes.get(i).setAutor(pale.getAutor(), 3);
                    }
                    if (!pale.getMetodologia().equals("")) {
                        submissoes.get(i).setMetodologia(pale.getMetodologia());
                    }
                    if (!pale.getRecursos().equals("")) {
                        submissoes.get(i).setRecursos(pale.getRecursos());
                    }
                    if (pale.getDuracao() >= 0) {
                        submissoes.get(i).setDuracao(pale.getDuracao());
                    }
                    if (!pale.getResumo().equals("")) {
                        submissoes.get(i).setResumo(pale.getResumo());
                    }
                    if (!pale.getAbs().equals("")) {
                        submissoes.get(i).setAbs(pale.getAbs());
                    }

                }
            }

        }
    }
      /**
     * Método que consulta um resumo pelo seu respectivo título
     * @param titulo
     * @return
     */
      public static List<Submissao> consultaTituloResumo(String titulo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Resumo.class)) {
                if (sub.getTitulo().contains(titulo)) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }
      /**
     * Método que consulta um resumo pelo seu respectivo autor ou autores
     * @param titulo
     * @return
     */
      public static List<Submissao> consultaAutorResumo(String autor) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Resumo.class)) {
                for (int i = 0; i < sub.getAutor().length; i++) {
                    if (sub.getAutor()[i].contains(autor)) {
                        achados.add(sub);
                    }
                }
            }
        }
        return achados;
    }
      /**
     * Método que consulta um resumo pelo seu respectivo código
     * @param titulo
     * @return
     */
          public static List<Submissao> consultaCodigoResumo(int codigo) {
        List<Submissao> achados = new ArrayList<>();
        for (Submissao sub : submissoes) {
            if (sub.getClass().equals(rp.Resumo.class)) {
                if (sub.getCodigo() == codigo) {
                    achados.add(sub);
                }
            }
        }
        return achados;
    }
          /**
     * Método que exclui um resumo recebendo um título por parâmetro
     * @param titulo
     * @return
     */
             public static String excluirPorTituloResumo(String titulo) {
        String msg = "";
        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Resumo.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {
                    msg = submissoes.remove(i).getTitulo();
                }
            }
        }
        return msg;
    }
             /**
     * Metodo para editar submissoes na lista atraves do titulo e uma submissao
     * alterada
     *
     * @param titulo
     * @param art
     */
    public static void editarPorTituloResumo(String titulo, Submissao res) {

        for (int i = 0; i < submissoes.size(); i++) {
            if (submissoes.get(i).getClass().equals(rp.Resumo.class)) {
                if (submissoes.get(i).getTitulo().equals(titulo)) {

                    if (!res.getTitulo().equals("")) {
                        submissoes.get(i).setTitulo(res.getTitulo());
                    }
                    if (res.getSituacao() == 0 || res.getSituacao() == 1 || res.getSituacao() == 2) {
                        submissoes.get(i).setSituacao(res.getSituacao());
                    }
                    if (!res.getAutor()[0].equals("")) {
                        submissoes.get(i).setAutor(res.getAutor(), 8);
                    }
                    if (!res.getInstituicao()[0].equals("")) {
                        submissoes.get(i).setInstituicao(res.getInstituicao(), 8);
                    }
                    if (!res.getPalavraChave()[0].equals("")) {
                        submissoes.get(i).setPalavraChave(res.getPalavraChave(), 4);
                    }
                   

                }
            }
        }

    }
}

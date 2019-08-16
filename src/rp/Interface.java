package rp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Interface {

    /**
     * Metodo que mostra menu principal, para cada opção um menu diferente é
     * chamado.
     */
    public static void menuPrincipal() {
        int opcao;
        boolean sair = false;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nMenu Principal\n1. Artigos\n2. Minicurso\n3. Monografia\n4. Palestra\n5. Resumo\n0. Sair\nDigite sua opção: ");
            if (entrada.hasNextInt()) {
                opcao = entrada.nextInt();
                entrada.nextLine();
                switch (opcao) {
                    case 1:
                        Interface.subMenuArtigo();
                        break;
                    case 2:
                        Interface.subMenuMini();
                        break;
                    case 3:
                        Interface.subMenuMono();
                        break;
                    case 4:
                        Interface.subMenuPale();
                        break;
                    case 5:
                        Interface.subMenuResumo();
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("\nOpção inválida!\n");
                }
            } else {
                System.out.println("Entrada Inválida!");
                entrada.nextLine();
            }
        } while (!sair);
    }

    /**
     * Metodo de menu de Monografias, onde é apresentado ao usuário possíveis
     * operações para administrar Monografias.
     *
     */
    public static void subMenuMono() {
        int opcao;
        boolean sair = false, ok = false;
        List<Submissao> achados = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nMenu\n1. Consultar\n2. Cadastrar\n3. Editar\n4. Excluir\n0. Voltar\nDigite sua opção: ");
            if (entrada.hasNextInt()) {
                opcao = entrada.nextInt();
                entrada.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.print("\n1. Consultar por código\n2. Consultar por título\n3. Consultar por autor\nDigite sua opção: ");
                        if(entrada.hasNextInt()){
                        opcao = entrada.nextInt();
                        entrada.nextLine();
                        switch (opcao) {
                            case 1:
                                do{
                                System.out.print("\nDigite o código da monografia: ");
                                if(entrada.hasNextInt()){
                                achados = Submissoes.consultaCodigoMono(entrada.nextInt());
                                entrada.nextLine();
                                if (achados.size() > 0) {
                                    for (int i = 0; i < achados.size(); i++) {
                                        System.out.print(achados.get(i).toString() + "\n");
                                    }
                                } else {
                                    System.out.print("\nNenhuma monografia achada com o código digitado!\n");
                                }
                                
                                break;
                                }else{
                                    System.out.print("Entrada Inválida!");
                                    entrada.nextLine();
                                }
                                }while(!ok);
                            case 2:
                                System.out.print("Digite o título da monografia: ");
                                achados = Submissoes.consultaTituloMono(entrada.nextLine());
                                if (achados.size() > 0) {
                                    for (int i = 0; i < achados.size(); i++) {
                                        System.out.print(achados.get(i).toString() + "\n");
                                    }
                                } else {
                                    System.out.print("\nNenhuma monografia achada com o título digitado!\n");
                                }
                                break;
                            case 3:
                                System.out.print("Digite o autor da monografia: ");
                                achados = Submissoes.consultaAutorMono(entrada.nextLine());
                                if (achados.size() > 0) {
                                    for (int i = 0; i < achados.size(); i++) {
                                        System.out.print(achados.get(i).toString() + "\n");
                                    }
                                } else {
                                    System.out.print("\nNenhuma monografia achada com o autor digitado!\n");
                                }
                                break;
                            default:
                                System.out.print("\nOpção inválida\n");
                        }
                        }else{
                            System.out.print("Entrada Inválida!");
                            entrada.nextLine();
                        }
                        break;
                    case 2:
                        Submissao mono = Interface.criaMono(-1);
                        Submissoes.insere(mono);
                        System.out.println("\nA monografia \"" + mono.getTitulo() + "\" foi cadastrada com sucesso\nCodigo: " + mono.getCodigo() + "\n");
                        break;
                    case 3:

                        if (Submissoes.tamanho() > 0) {
                            System.out.print("Digite o título da monografia que deseja editar: ");
                            String tituloeditar = entrada.nextLine();
                            achados = Submissoes.consultaTituloMono(tituloeditar);
                            if (achados.size() > 0) {
                                System.out.print(achados.get(0).toString());
                                Submissao nvMono = Interface.criaMono(achados.get(0).getCodigo());
                                Submissoes.editarPorTituloMono(achados.get(0).getTitulo(), nvMono);

                            } else {
                                System.out.print("\nNenhuma monografia com esse título foi encontrada.\n");
                            }
                        } else {
                            System.out.print("\nNenhuma monografia cadastrada.\n");
                        }

                        break;
                    case 4:
                        System.out.println("\nDigite o título da monografia que deseja excluir: ");
                        String msg = Submissoes.excluirPorTituloMono(entrada.nextLine());
                        if (msg.equals("")) {
                            System.out.print("\nNenhuma monografia encontrada com esse título.\n");
                        } else {
                            System.out.print("\nA monografia \"" + msg + "\" foi deletado com sucesso.\n");
                        }
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("\nOpção inválida!\n");
                }
            } else {
                System.out.print("Entrada Inválida!");
                entrada.nextLine();
            }
        } while (!sair);
    }

    /**
     * Metodo que cria uma Monografia.
     *
     * @param cod
     * @return uma monografia
     */
    public static Submissao criaMono(int cod) {
        Scanner entrada = new Scanner(System.in);
        boolean ok;
        int codigo;
        int situacao = 0;
        String titulo;
        String[] autor;
        int nautor;
        int tipo;

        if (cod == -1) {
            codigo = Submissoes.getLastCode();
        } else {
            codigo = cod;
        }
        System.out.print("Titulo: ");
        titulo = entrada.nextLine();
        ok = false;
        do {
            System.out.print("Situação:\n");
            System.out.print("0. Sob Avaliação\n   1. Aprovado\n   2. Reprovado\n ");
            if (entrada.hasNextInt()) {
                situacao = entrada.nextInt();
                entrada.nextLine();
                if (situacao < 0 || situacao > 2) {
                    System.out.print("\nNúmero invalido\n");
                } else {
                    ok = true;
                }
            } else {
                System.out.print("\nEntrada ivalida\n");
                entrada.nextLine();
            }
        } while (!ok);

        System.out.print("Autor: ");
        autor = entrada.nextLine().split(",");
        nautor = 1;

        Submissao mono = new Monografia(codigo, situacao, titulo, autor, nautor);
        ok = false;
        do {
            System.out.print("Instituição: ");
            String[] inst = entrada.nextLine().split(",");
            if (mono.setInstituicao(inst, 1)) {
                ok = true;
            } else {
                System.out.println("\nApenas 1 instituições!\n");
            }
        } while (!ok);
        ok = false;
        do {
            System.out.print("Palavras chave: ");
            String[] pchave = entrada.nextLine().split(",");
            if (mono.setPalavraChave(pchave, 4)) {
                ok = true;
            } else {
                System.out.println("\nApenas 4 palavras chave!\n");
            }
        } while (!ok);

        System.out.print("Resumo: ");
        mono.setResumo(entrada.nextLine());

        System.out.print("Abstract: ");
        mono.setAbs(entrada.nextLine());
        ok = false;
        do {
            System.out.print("Tipo:\n");
            System.out.print("   0. Graduação\n   1. Especialização\n   2. Mestrado\n   3. Doutorado\n");
            if (entrada.hasNextInt()) {
                tipo = entrada.nextInt();
                entrada.nextLine();
                if (tipo < 0 || tipo > 3) {
                    System.out.print("\nNúmero invalido\n");

                } else {
                    mono.setTipo(tipo);
                    ok = true;
                }
            } else {
                System.out.print("\nEntrada invalida\n");
                entrada.nextLine();
            }
        } while (!ok);

        System.out.print("Orientador: ");
        mono.setOrien(entrada.nextLine());

        System.out.print("Curso: ");
        mono.setCurso(entrada.nextLine());

        ok = false;
        do {
            System.out.print("Ano: ");
            if (entrada.hasNextInt()) {
                mono.setAno(entrada.nextInt());
                entrada.nextLine();
                ok = true;
            } else {
                System.out.print("Entrada invalida\n");
                entrada.nextLine();
            }
        } while (!ok);

        ok = false;
        do {
            System.out.print("Paginas: ");

            if (entrada.hasNextInt()) {
                mono.setNpag(entrada.nextInt());
                entrada.nextLine();
                ok = true;
            } else {
                System.out.print("Entrada invalida\n");
                entrada.nextLine();
            }
        } while (!ok);

        return mono;
    }

    /**
     * Metodo de menu de Mini cursos, onde é apresentado ao usuário possíveis
     * operações para administrar Mini cursos.
     *
     */
    public static void subMenuMini() {
        boolean ok = false;
        boolean sair = false;
        int opcao;
        List<Submissao> achados = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nMenu \n1. Consultar\n3. Cadastrar\n3. Editar\n4. Excluir\n0. Voltar\nDigite sua opção: ");
            if (entrada.hasNextInt()) {
                opcao = entrada.nextInt();
                entrada.nextLine();
                switch (opcao) {
                    case 1:
                        do {
                            System.out.print("\n1. Consultar por código\n2. Consultar por título\n3. Consultar por autor\nDigite sua opção: ");
                            if (entrada.hasNextInt()) {
                                opcao = entrada.nextInt();
                                entrada.nextLine();
                                switch (opcao) {
                                    case 1:
                                        ok = false;
                                        do {
                                            System.out.print("Digite o código do minicurso: ");
                                            if (entrada.hasNextInt()) {
                                                achados = Submissoes.consultaCodigoMinicurso(entrada.nextInt());
                                                entrada.nextLine();
                                                ok = true;
                                                if (achados.size() > 0) {
                                                    for (int i = 0; i < achados.size(); i++) {
                                                        System.out.print(achados.get(i).toString() + "\n");
                                                    }
                                                } else {
                                                    System.out.print("Nenhum minicurso achado com o código digitado!");
                                                }

                                            } else {
                                                System.out.println("Entrada Inválida!");
                                                entrada.nextLine();
                                            }
                                        } while (!ok);
                                        break;
                                    case 2:
                                        System.out.print("Digite o título do minicurso: ");
                                        achados = Submissoes.consultaTituloMinicurso(entrada.nextLine());
                                        if (achados.size() > 0) {
                                            for (int i = 0; i < achados.size(); i++) {
                                                System.out.print(achados.get(i).toString() + "\n");
                                            }
                                        } else {
                                            System.out.print("Nenhum minicurso achado com o título digitado!");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Digite o autor do minicurso: ");
                                        achados = Submissoes.consultaAutorMinicurso(entrada.nextLine());
                                        if (achados.size() > 0) {
                                            for (int i = 0; i < achados.size(); i++) {
                                                System.out.print(achados.get(i).toString() + "\n");
                                            }
                                        } else {
                                            System.out.print("Nenhum minicurso achado com o autor digitado!");
                                        }
                                        break;
                                    default:
                                        System.out.print("Opção inválida");
                                }
                            } else {
                                System.out.println("Entrada Inválida!");
                                entrada.nextLine();
                            }
                        } while (!ok);
                        break;
                    case 2:
                        Submissao mini = Interface.criaMinicurso(-1);
                        Submissoes.insere(mini);
                        System.out.println("O minicurso \"" + mini.getTitulo() + "\" foi cadastrado com sucesso\nCodigo: " + mini.getCodigo());
                        break;
                    case 3:
                        if (Submissoes.tamanho() > 0) {
                            System.out.print("Digite o título do minicurso que deseja editar: ");
                            String tituloeditar = entrada.nextLine();
                            achados = Submissoes.consultaTituloMinicurso(tituloeditar);
                            if (achados.size() > 0) {
                                System.out.print(achados.get(0).toString());
                                Submissao nvMini = Interface.criaMinicurso(achados.get(0).getCodigo());
                                Submissoes.editarPorTituloMinicurso(achados.get(0).getTitulo(), nvMini);
                            } else {
                                System.out.print("Nenhum minicurso com esse título foi encontrado.");
                            }
                        } else {
                            System.out.print("Nenhum minicurso cadastrado.");
                        }
                        break;
                    case 4:
                        System.out.println("Digite o título do minicurso que deseja excluir: ");
                        String msg = Submissoes.excluirPorTituloMinicurso(entrada.nextLine());
                        if (msg.equals("")) {
                            System.out.print("Nenhum minicurso encontrado com esse título.");
                        } else {
                            System.out.print("O minicurso \"" + msg + "\" foi deletado com sucesso.");
                        }
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } else {
                System.out.println("Entrada Inválida!");
                entrada.nextLine();
            }
        } while (!sair);
    }

    /**
     * Metodo para criar Minicurso
     *
     * @param cod
     * @return Minicurso
     */
    public static Submissao criaMinicurso(int cod) {

        boolean ok = false;
        int codigo;
        int situacao = 0;
        String titulo;
        String[] autor;

        Scanner entrada = new Scanner(System.in);
        if (cod == -1) {
            codigo = Submissoes.getLastCode();
        } else {
            codigo = cod;
        }
        System.out.print("Titulo: ");
        titulo = entrada.nextLine();
        do {
            System.out.print("0. Sob Avaliação\n1. Aprovado\n2. Reprovado\nInforme a situação: ");
            if (entrada.hasNextInt()) {
                situacao = entrada.nextInt();
                entrada.nextLine();
                if (situacao == 0 || situacao == 1 || situacao == 2) {
                    ok = true;
                } else {
                    System.out.println("Situação Inválida!\n");
                }
            } else {
                System.out.println("Entrada Inválida\n");
                entrada.nextLine();
            }
        } while (!ok);
        System.out.print("Autor(es): ");
        autor = entrada.nextLine().split(",");
        Submissao mini = new Minicurso(codigo, situacao, titulo, autor, 3);
        System.out.print("Resumo: ");
        mini.setResumo(entrada.nextLine());
        System.out.print("Abstract: ");
        mini.setAbs(entrada.nextLine());
        ok = false;
        do {
            System.out.print("Duração em minutos (Ex: 90) : ");
            if (entrada.hasNextInt()) {
                mini.setDuracao(entrada.nextInt());
                entrada.nextLine();
                ok = true;
            } else {
                System.out.println("Entrada Inválida!");
                entrada.nextLine();
            }
        } while (!ok);

        System.out.print("Recursos: ");
        mini.setRecursos(entrada.nextLine());
        System.out.print("Metodologia: ");
        mini.setMetodologia(entrada.nextLine());
        return mini;
    }

    /**
     * Metodo de menu de Artigos, onde é apresentado ao usuário possíveis
     * operações para administrar Artigos.
     *
     */
    public static void subMenuArtigo() {
        boolean sair = false, ok = false ;
        int opcao;
        List<Submissao> achados = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nMenu \n1. Consultar\n2. Cadastrar\n3. Editar\n4. Excluir\n0. Voltar\nDigite sua opção: ");
            if(entrada.hasNextInt()){
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    
                    System.out.print("\n1. Consultar por código\n2. Consultar por título\n3. Consultar por autor\nDigite sua opção: ");
                    if(entrada.hasNextInt()){
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    switch (opcao) {
                        
                        case 1:
                             do{
                                System.out.print("\nDigite o código do artigo: ");
                                if(entrada.hasNextInt()){
                                achados = Submissoes.consultaCodigoArtigo(entrada.nextInt());
                                entrada.nextLine();
                                if (achados.size() > 0) {
                                    for (int i = 0; i < achados.size(); i++) {
                                        System.out.print(achados.get(i).toString() + "\n");
                                    }
                                } else {
                                    System.out.print("\nNenhuma artigo achado com o código digitado!\n");
                                }
                                
                                break;
                                }else{
                                    System.out.print("Entrada Inválida!");
                                    entrada.nextLine();
                                }
                                }while(!ok);
                        case 2:
                            System.out.print("Digite o título do artigo: ");
                            achados = Submissoes.consultaTituloArtigo(entrada.nextLine());
                            if (achados.size() > 0) {
                                for (int i = 0; i < achados.size(); i++) {
                                    System.out.print(achados.get(i).toString() + "\n");
                                }
                            } else {
                                System.out.print("Nenhum artigo achado com o título digitado!");
                            }
                            break;
                        case 3:
                            System.out.print("Digite o autor do artigo: ");
                            achados = Submissoes.consultaAutorArtigo(entrada.nextLine());
                            if (achados.size() > 0) {
                                for (int i = 0; i < achados.size(); i++) {
                                    System.out.print(achados.get(i).toString() + "\n");
                                }
                            } else {
                                System.out.print("Nenhum artigo achado com o autor digitado!");
                            }
                            break;
                        default:
                            System.out.print("Opção inválida");
                    }
                    break;
                    
                    }else{
                        System.out.print("Entrada Inválida!");
                        entrada.nextLine();
                    }
                case 2:
                    Submissao art = Interface.criaArtigo(-1);
                    Submissoes.insere(art);
                    System.out.println("O artigo \"" + art.getTitulo() + "\" foi cadastrado com sucesso\nCodigo: " + art.getCodigo());
                    break;
                case 3:
                    if (Submissoes.tamanho() > 0) {
                        System.out.print("Digite o título do artigo que deseja editar: ");
                        String tituloeditar = entrada.nextLine();
                        achados = Submissoes.consultaTituloArtigo(tituloeditar);
                        if (achados.size() > 0) {
                            System.out.print(achados.get(0).toString());
                            Submissao nvArt = Interface.criaArtigo(achados.get(0).getCodigo());
                            Submissoes.editarPorTituloArtigo(achados.get(0).getTitulo(), nvArt);
                        } else {
                            System.out.print("Nenhum artigo com esse título foi encontrado.");
                        }
                    } else {
                        System.out.print("Nenhum artigo cadastrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o título do artigo que deseja excluir: ");
                    String msg = Submissoes.excluirPorTituloArtigo(entrada.nextLine());
                    if (msg.equals("")) {
                        System.out.print("Nenhum artigo encontrado com esse título.");
                    } else {
                        System.out.print("O artigo \"" + msg + "\" foi deletado com sucesso.");
                    }
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            }else{
                System.out.print("Entrada Inválida!");
                entrada.nextLine();
            }    
        } while (!sair);
    }

    /**
     * Metodo para criar um Artigo
     *
     * @param cod
     * @return um Artigo
     */
    public static Submissao criaArtigo(int cod) {

        boolean ok = false;
        int codigo;
        int situacao = 0;
        String titulo;
        String[] autor;

        Scanner entrada = new Scanner(System.in);
        if (cod == -1) {
            codigo = Submissoes.getLastCode();
        } else {
            codigo = cod;
        }
        System.out.print("Titulo: ");
        titulo = entrada.nextLine();
        do {
            System.out.println("Situação: \n0. Sob Avaliação\n1. Aprovado\n2. Reprovado\nInforme a situação: ");
            if (entrada.hasNextInt()) {
                situacao = entrada.nextInt();
                entrada.nextLine();
                if (situacao == 0 || situacao == 1 || situacao == 2) {
                    ok = true;
                } else {
                    System.out.println("Situação Inválida!\n");
                }
            } else {
                System.out.println("Entrada Inválida\n");
                entrada.nextLine();
            }
        } while (!ok);
        entrada.nextLine();
        System.out.print("Autor(es): ");
        autor = entrada.nextLine().split(",");
        Submissao art = new Artigo(codigo, situacao, titulo, autor, 8);
        ok = false;
        do {
            System.out.print("Instituição(oes): ");
            String[] inst = entrada.nextLine().split(",");
            if (art.setInstituicao(inst, 8)) {
                ok = true;
            } else {
                System.out.println("Apenas 8 instituições!");
            }
        } while (!ok);
        ok = false;
        do {
            System.out.print("Palavras chave: ");
            String[] pchave = entrada.nextLine().split(",");
            if (art.setPalavraChave(pchave, 4)) {
                ok = true;
            } else {
                System.out.println("Apenas 4 palavras chave!");
            }
        } while (!ok);
        System.out.print("Resumo: ");
        art.setResumo(entrada.nextLine());
        System.out.print("Abstract: ");
        art.setAbs(entrada.nextLine());
        return art;
    }

    /**
     * Metodo de menu de Palestras, onde é apresentado ao usuário possíveis
     * operações para administrar palestras.
     *
     */
    public static void subMenuPale() {
        boolean ok = false;
        boolean sair = false;
        int opcao;
        List<Submissao> achados = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nMenu \n1. Consultar\n2. Cadastrar\n3. Editar\n4. Excluir\n0. Voltar\nDigite sua opção: ");
            if (entrada.hasNextInt()) {
                opcao = entrada.nextInt();
                entrada.nextLine();
                switch (opcao) {
                    case 1:
                        do {
                            System.out.print("\n1. Consultar por código\n2. Consultar por título\n3. Consultar por autor\nDigite sua opção: ");
                            if (entrada.hasNextInt()) {
                                opcao = entrada.nextInt();
                                entrada.nextLine();
                                switch (opcao) {
                                    case 1:
                                        ok = false;
                                        do {
                                            System.out.print("Digite o código da palestra: ");
                                            if (entrada.hasNextInt()) {
                                                achados = Submissoes.consultaCodigoPalestra(entrada.nextInt());
                                                entrada.nextLine();
                                                ok = true;
                                                if (achados.size() > 0) {
                                                    for (int i = 0; i < achados.size(); i++) {
                                                        System.out.print(achados.get(i).toString() + "\n");
                                                    }
                                                } else {
                                                    System.out.print("Nenhuma palestra encontrada com o código digitado!");
                                                }

                                            } else {
                                                System.out.println("Entrada Inválida!");
                                                entrada.nextLine();
                                            }
                                        } while (!ok);
                                        break;
                                    case 2:
                                        System.out.print("Digite o título da palestra: ");
                                        achados = Submissoes.consultaTituloPalestra(entrada.nextLine());
                                        if (achados.size() > 0) {
                                            for (int i = 0; i < achados.size(); i++) {
                                                System.out.print(achados.get(i).toString() + "\n");
                                            }
                                        } else {
                                            System.out.print("Nenhuma palestra encontrada com o título digitado!");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Digite o autor da palestra: ");
                                        achados = Submissoes.consultaAutorPalestra(entrada.nextLine());
                                        if (achados.size() > 0) {
                                            for (int i = 0; i < achados.size(); i++) {
                                                System.out.print(achados.get(i).toString() + "\n");
                                            }
                                        } else {
                                            System.out.print("Nenhuma palestra encontrada com o autor digitado!");
                                        }
                                        break;
                                    default:
                                        System.out.print("Opção inválida");
                                }
                            } else {
                                System.out.println("Entrada Inválida!");
                                entrada.nextLine();
                            }
                        } while (!ok);
                        break;
                    case 2:
                        Submissao pale = Interface.criaPalestra(-1);
                        Submissoes.insere(pale);
                        System.out.println("A palestra \"" + pale.getTitulo() + "\" foi cadastrada com sucesso! \nCodigo: " + pale.getCodigo());
                        break;
                    case 3:
                        if (Submissoes.tamanho() > 0) {
                            System.out.print("Digite o título da palestra que deseja editar: ");
                            String tituloeditar = entrada.nextLine();
                            achados = Submissoes.consultaTituloPalestra(tituloeditar);
                            if (achados.size() > 0) {
                                System.out.print(achados.get(0).toString());
                                Submissao nvPale = Interface.criaPalestra(achados.get(0).getCodigo());
                                Submissoes.editarPorTituloPalestra(achados.get(0).getTitulo(), nvPale);
                            } else {
                                System.out.print("Nenhuma palestra com esse título foi encontrada.");
                            }
                        } else {
                            System.out.print("Nenhuma palestra cadastrada.");
                        }
                        break;
                    case 4:
                        System.out.println("Digite o título da palestra que deseja excluir: ");
                        String msg = Submissoes.excluirPorTituloPalestra(entrada.nextLine());
                        if (msg.equals("")) {
                            System.out.print("Nenhuma palestra encontrada com esse título.");
                        } else {
                            System.out.print("A palestra \"" + msg + "\" foi deletada com sucesso.");
                        }
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } else {
                System.out.println("Entrada Inválida!");
                entrada.nextLine();
            }
        } while (!sair);
    }

    /**
     * Metodo para criar Palestra
     *
     * @param cod
     * @return Palestra
     */
    public static Submissao criaPalestra(int cod) {

        boolean ok = false;
        int codigo;
        int situacao = 0;
        String titulo;
        String[] autor;

        Scanner entrada = new Scanner(System.in);
        if (cod == -1) {
            codigo = Submissoes.getLastCode();
        } else {
            codigo = cod;
        }
        System.out.print("Titulo: ");
        titulo = entrada.nextLine();
        do {
            System.out.print("0. Sob Avaliação\n1. Aprovado\n2. Reprovado\nInforme a situação: ");
            if (entrada.hasNextInt()) {
                situacao = entrada.nextInt();
                entrada.nextLine();
                if (situacao == 0 || situacao == 1 || situacao == 2) {
                    ok = true;
                } else {
                    System.out.println("Situação Inválida!\n");
                }
            } else {
                System.out.println("Entrada Inválida\n");
                entrada.nextLine();
            }
        } while (!ok);
        System.out.print("Autor: ");
        autor = entrada.nextLine().split(",");
        Submissao pale = new Palestra(codigo, situacao, titulo, autor, 1);
        System.out.print("Resumo: ");
        pale.setResumo(entrada.nextLine());
        System.out.print("Abstract: ");
        pale.setAbs(entrada.nextLine());
        ok = false;
        do {
            System.out.print("Duração em minutos (Ex: 90) : ");
            if (entrada.hasNextInt()) {
                pale.setDuracao(entrada.nextInt());
                entrada.nextLine();
                ok = true;
            } else {
                System.out.println("Entrada Inválida!");
                entrada.nextLine();
            }
        } while (!ok);

        System.out.print("Currículo: ");
        pale.setCurriculo(entrada.nextLine());
        return pale;
    }

    /**
     * Metodo de menu de Resumos, onde é apresentado ao usuário possíveis
     * operações para administrar Resumos.
     *
     */
    public static void subMenuResumo() {
        boolean sair = false, ok = false;
        int opcao;
        List<Submissao> achados = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nMenu \n1 - Consultar\n2 - Cadastrar\n3 - Editar\n4 - Excluir\n0 - Voltar\nDigite sua opção: ");
            if(entrada.hasNextInt()){
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("\n1 - Consultar por código\n2 - Consultar por título\n3 - Consultar por autor\nDigite sua opção: ");
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    switch (opcao) {
                        case 1:
                            do{
                            System.out.print("Digite o código do artigo: ");
                            if(entrada.hasNextInt()){
                            achados = Submissoes.consultaCodigoResumo(entrada.nextInt());
                            entrada.nextLine();
                            ok = true;
                            if (achados.size() > 0) {
                                for (int i = 0; i < achados.size(); i++) {
                                    System.out.print(achados.get(i).toString() + "\n");
                                }
                            } else {
                                System.out.print("Nenhum resumo encontrado com o código digitado!");
                            }
                            }else{
                                System.out.print("Entrada Inválida!");
                                entrada.nextLine();
                            }
                            }while(!ok);
                            break;
                        case 2:
                            System.out.print("Digite o título do resumo: ");
                            achados = Submissoes.consultaTituloResumo(entrada.nextLine());
                            if (achados.size() > 0) {
                                for (int i = 0; i < achados.size(); i++) {
                                    System.out.print(achados.get(i).toString() + "\n");
                                }
                            } else {
                                System.out.print("Nenhum resumo encontrado com este título!");
                            }
                            break;
                        case 3:
                            System.out.print("Digite o(s) autor(es) do resumo: ");
                            achados = Submissoes.consultaAutorResumo(entrada.nextLine());
                            if (achados.size() > 0) {
                                for (int i = 0; i < achados.size(); i++) {
                                    System.out.print(achados.get(i).toString() + "\n");
                                }
                            } else {
                                System.out.print("Nenhum resumo encontrado com este autor!");
                            }
                            break;
                        default:
                            System.out.print("Opção inválida");
                    }
                    break;
                case 2:
                    Submissao res = Interface.criaResumo(-1);
                    Submissoes.insere(res);
                    System.out.println("O resumo \"" + res.getTitulo() + "\" foi cadastrado com sucesso\nCodigo: " + res.getCodigo());
                    break;
                case 3:
                    if (Submissoes.tamanho() > 0) {
                        System.out.print("Digite o título do resumo que deseja editar: ");
                        String tituloeditar = entrada.nextLine();
                        achados = Submissoes.consultaTituloResumo(tituloeditar);
                        if (achados.size() > 0) {
                            System.out.print(achados.get(0).toString());
                            Submissao nvRes = Interface.criaResumo(achados.get(0).getCodigo());
                            Submissoes.editarPorTituloResumo(achados.get(0).getTitulo(), nvRes);
                        } else {
                            System.out.print("Nenhum resumo com esse título foi encontrado.");
                        }
                    } else {
                        System.out.print("Nenhum resumo cadastrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o título do resumo que deseja excluir: ");
                    String msg = Submissoes.excluirPorTituloResumo(entrada.nextLine());
                    if (msg.equals("")) {
                        System.out.print("Nenhum resumo encontrado com este título.");
                    } else {
                        System.out.print("O resumo \"" + msg + "\" foi deletado com sucesso.");
                    }
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            }else{
                System.out.print("Entrada Invalida!");
            }
        } while (!sair);
    }

    /**
     * Metodo para criar um Resumo
     *
     * @param cod
     * @return um Artigo
     */
    public static Submissao criaResumo(int cod) {

        boolean ok = false;
        int codigo;
        int situacao = 0;
        String titulo;
        String[] autor;

        Scanner entrada = new Scanner(System.in);
        if (cod == -1) {
            codigo = Submissoes.getLastCode();
        } else {
            codigo = cod;
        }
        System.out.println("Titulo: ");
        titulo = entrada.nextLine();

        do {
            System.out.println("Situação: \n0. Sob Avaliação\n1. Aprovado\n2. Reprovado\nInforme a situação: ");
            if (entrada.hasNextInt()) {
                situacao = entrada.nextInt();
                entrada.nextLine();
                if (situacao == 0 || situacao == 1 || situacao == 2) {
                    ok = true;
                } else {
                    System.out.println("Situação Inválida!\n");
                }
            } else {
                System.out.println("Entrada Inválida\n");
                entrada.nextLine();
            }
        } while (!ok);

        System.out.print("Autor(es): ");
        autor = entrada.nextLine().split(",");
        Submissao res = new Resumo(codigo, situacao, titulo, autor, 8);
        ok = false;
        do {
            System.out.print("Instituição(oes): ");
            String[] inst = entrada.nextLine().split(",");
            if (res.setInstituicao(inst, 8)) {
                ok = true;
            } else {
                System.out.println("Apenas 8 instituições!");
            }
        } while (!ok);
        ok = false;
        do {
            System.out.print("Palavras chave: ");
            String[] pchave = entrada.nextLine().split(",");
            if (res.setPalavraChave(pchave, 4)) {
                ok = true;
            } else {
                System.out.println("Apenas 4 palavras chave!");
            }
        } while (!ok);

        return res;
    }
}

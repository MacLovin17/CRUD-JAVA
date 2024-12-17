import java.util.ArrayList;
import java.util.Scanner;

public class cadastro {

    public static void clearTerminal() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        aluno Aluno = new aluno();
        curso Curso = new curso();
        Scanner sc = new Scanner(System.in);
        int opc =0;
        int cont =0, cont_curso =0;;
        char cond = 'y';
        int cod_curso =0, cod_aluno = 0;

        do{
            System.out.println("Selecione o menu : ");
            System.out.println("(1) Cadastro de Aluno: ");
            System.out.println("(2) Cadastro de Curso: ");
            System.out.println("(3) Atualizar: ");
            System.out.println("(4) Pesquisar: ");
            System.out.println("(5) Deletar: ");
            System.out.println("(6) Sair: ");
            opc = sc.nextInt();
            sc.nextLine();

            

            switch (opc) {
                case 1:
                    System.out.println("Cadastro de Aluno: ");
                    System.out.println("Nome do Aluno: ");
                    String N_aluno = sc.nextLine();
                    Aluno.nome.add(N_aluno);

                    System.out.println("Data de Nascimento: (DD/MM/AAAA)" );
                    String D_nasc = sc.nextLine();
                    Aluno.data_nasc.add(D_nasc);

                    System.out.println("CPF :");
                    String cpf = sc.nextLine();
                    Aluno.cpf.add(cpf);

                    
                    System.out.println("Código do curso matrículado :");
                    cod_curso = sc.nextInt();
                    do{
                        if(cod_curso < 0 || cod_curso >= Curso.codigo.size()){
                            System.err.println("Curso não encontrado.\n Por favor, verifique o código do curso.");
                            cod_curso = sc.nextInt();
                        }
                        if(cod_curso >=0 && cod_curso <=Curso.codigo.size()){
                            System.out.println("O curso é : " + Curso.curso.get(cod_curso) + " ? (Y/N)");
                            cond = sc.next().charAt(0);
                        }
                    }while(cod_curso < 0 && cond == 'n'|| cod_curso >= Curso.codigo.size() && cond == 'n');

                    Aluno.curso.add(Curso.curso.get(cod_curso));
                    sc.nextLine();
                    
                    Aluno.matricula.add(++cont);
                    
                    clearTerminal();
                    
                    break;

                case 2:   
                    System.out.println("Cadastro de Curso: ");
                    System.out.println("Nome do Curso: ");
                    String N_curso = sc.nextLine();
                    Curso.curso.add(N_curso);

                    System.out.println("Nome da Classe: ");
                    String N_classe= sc.nextLine();
                    Curso.classe.add(N_classe);

                    System.out.println("Quantos períodos o curso possui: ");
                    int periodo= sc.nextInt();
                    Curso.Semestre.add(periodo);

                    sc.nextLine();

                    Curso.codigo.add(++cont_curso);

                    clearTerminal();

                    break;
                case 3:
                    System.out.println("Atualização de Cadastro: ");
                    System.out.println("Atualizar aluno ou curso? (C/A)");
                    cond = sc.next().charAt(0);

                    if(cond == 'c' || cond == 'C'){
                        System.out.println("Informe o código do curso a ser atualizado: ");
                        cod_curso = sc.nextInt();
                        while(cod_curso <0 || cod_curso >= Curso.codigo.size()){
                            System.err.println("Curso não encontrado.\n Por favor, verifique o código do curso.");
                            cod_curso = sc.nextInt();
                            sc.nextLine();
                        }
                        sc.nextLine();

                        System.out.println("Novo Nome do Curso: ");
                        String N_curso1 = sc.nextLine();
                        Curso.curso.set(cod_curso, N_curso1);

                        System.out.println("Novo Nome da Classe: ");
                        String N_classe1 = sc.nextLine();
                        Curso.classe.set(cod_curso, N_classe1);

                        System.out.println("Quantos períodos o curso possui: ");
                        int periodo1 = sc.nextInt();
                        Curso.Semestre.set(cod_curso, periodo1);
                        
                        sc.nextLine();
                        clearTerminal();

                    }
                    if(cond == 'a' || cond == 'A'){
                        System.out.println("Informe o código do aluno a ser atualizado: ");
                        cod_aluno = sc.nextInt();
                        sc.nextLine();
                        while(cod_aluno <0 || cod_aluno >= Aluno.matricula.size()){
                            System.err.println("Aluno não encontrado.\n Por favor, verifique a matrícula correta do aluno.");
                            cod_aluno = sc.nextInt();
                            sc.nextLine();
                        }

                        System.out.println("Novo Nome do Aluno: ");
                        String N_aluno1 = sc.nextLine();
                        Aluno.nome.set(cod_aluno, N_aluno1);

                        System.out.println("Nova Data de Nascimento: (DD/MM/AAAA)" );
                        String D_nasc1 = sc.nextLine();
                        Aluno.data_nasc.set(cod_aluno, D_nasc1);

                        System.out.println("Novo CPF :");
                        String cpf1 = sc.nextLine();
                        Aluno.cpf.set(cod_aluno, cpf1);

                        
                        System.out.println("Código do curso matrículado :");
                        cod_curso = sc.nextInt();
                        do{
                            if(cod_curso < 0 || cod_curso >= Curso.codigo.size()){
                                System.err.println("Curso não encontrado.\n Por favor, verifique o código do curso.");
                                cod_curso = sc.nextInt();
                            }
                            if(cod_curso >=0 && cod_curso <=Curso.codigo.size()){
                                System.out.println("O curso é : " + Curso.curso.get(cod_curso) + " ? (Y/N)");
                                cond = sc.next().charAt(0);
                            }
                        }while(cod_curso < 0 && cond == 'n'|| cod_curso >= Curso.codigo.size() && cond == 'n');

                        Aluno.curso.set(cod_aluno, Curso.curso.get(cod_curso));
                        sc.nextLine();
                    }

                    clearTerminal();

                    break;
                case 4:

                System.out.println("=== Lista de Alunos Cadastrados ===");

                    for (int indice = 0; indice < Aluno.nome.size(); indice++) {
                        System.out.println("Matrícula: " + Aluno.matricula.get(indice));
                        System.out.println("Nome: " + Aluno.nome.get(indice));
                        System.out.println("Data de Nascimento: " + Aluno.data_nasc.get(indice));
                        System.out.println("CPF: " + Aluno.cpf.get(indice));
                        System.out.println("Curso: " + Aluno.curso.get(indice));
                        System.out.println("---------------------------");
                    }
                    
                    break;
                default:
                    break;
            }
        }while(opc != 6);

    







        sc.close();
    }
}

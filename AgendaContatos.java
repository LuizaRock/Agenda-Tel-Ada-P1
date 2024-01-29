import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaContatos {
    private ArrayList<Contato> contatos;


    public AgendaContatos() {
        contatos = new ArrayList<>();
    }

    public void dadosAgenda(Contato contato) {
        contatos.add(contato);
        salvarContatosEmArquivo("dados", "contatos.txt");
    }


    public void editarContato(int id, Contato novoContato) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getId() == id) {
                contatos.set(i, novoContato);
                salvarContatosEmArquivo("dados", "contatos.txt");
                break;
            }
        }
    }

    public void removerContato(int id) {
        contatos.removeIf(contato -> contato.getId() == id);
        salvarContatosEmArquivo("dados", "contatos.txt");
    }

    public void exibirContatos() {
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }


    public void salvarContatosEmArquivo(String diretorio, String nomeArquivo) {
        criarDiretorioSeNaoExistir(diretorio);

        String caminhoCompleto = diretorio + "/" + nomeArquivo;

        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoCompleto))) {
            for (Contato contato : contatos) {
                writer.println(contato.getId() + "," + contato.getNome() + "," + contato.getSobrenome() + "," + contato.getTelefone());
            }
            System.out.println("Contatos salvos com sucesso no arquivo: " + caminhoCompleto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarContatosDeArquivo(String nomeArquivo) {
        // Implementação do método para carregar contatos do arquivo, se necessário
    }

    // Criar diretório se não existir
    private void criarDiretorioSeNaoExistir(String diretorio) {
        File dir = new File(diretorio);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Diretório criado: " + diretorio);
            } else {
                System.out.println("Falha ao criar o diretório: " + diretorio);
            }
        }
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();
        Scanner scanner = new Scanner(System.in);

        // Menu
        int opcao;
        do {
            System.out.println("\n1 - Adicionar Contato");
            System.out.println("2 - Editar Contato");
            System.out.println("3 - Remover Contato");
            System.out.println("4 - Exibir Contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("ID do contato: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sobrenome do contato: ");
                    String sobrenome = scanner.nextLine();
                    System.out.print("Número de telefone: ");
                    String numeroTelefone = scanner.nextLine();
                    Contato novoContato = new Contato(id, nome, sobrenome, new Telefone(numeroTelefone));
                    agenda.dadosAgenda(novoContato);
                    break;
                case 2:
                    System.out.print("ID do contato a ser editado: ");
                    int idEditar = scanner.nextInt();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.next();
                    System.out.print("Novo sobrenome: ");
                    String novoSobrenome = scanner.next();
                    System.out.print("Novo número de telefone: ");
                    String novoNumeroTelefone = scanner.next();
                    Contato contatoEditado = new Contato(idEditar, novoNome, novoSobrenome, new Telefone(novoNumeroTelefone));
                    agenda.editarContato(idEditar, contatoEditado);
                    break;
                case 3:
                    System.out.print("ID do contato a ser removido: ");
                    int idRemover = scanner.nextInt();
                    agenda.removerContato(idRemover);
                    break;
                case 4:
                    agenda.exibirContatos();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}

// Arquivo Contato.java
public class Contato {
    private int id;
    private String nome;
    private String sobrenome;
    private Telefone telefone;

    // Construtor
    public Contato(int id, String nome, String sobrenome, Telefone telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + " " + sobrenome + ", Telefone: " + telefone;
    }
}

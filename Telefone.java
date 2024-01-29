// Arquivo Telefone.java
public class Telefone {
    private String numero;

    // Construtor
    public Telefone(String numero) {
        this.numero = numero;
    }

    // Getter e Setter
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero;
    }
}

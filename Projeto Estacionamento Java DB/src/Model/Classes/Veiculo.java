package Model.Classes;

/**
 *
 * @author Gesley Oliveira Rosa
 */
public class Veiculo {
    private Integer id;
    private String nome;
    private String placa;
    private String tipo;

    public Veiculo() {
    }
    
    public Veiculo(String nome, String placa, String tipo) {
        this.nome = nome;
        this.placa = placa;
        this.tipo = tipo;
    }
    
    public Veiculo(Integer id, String nome, String placa, String tipo) {
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", placa=" + placa + ", tipo=" + tipo;
    }
        
}

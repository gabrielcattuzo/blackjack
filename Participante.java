public class Participante {
    private String nome;
    private int soma;
    private int quantidadeAs;
    
    public Participante(String nome) {
        this.nome = nome;
        this.soma = 0;
        this.quantidadeAs = 0;
    } 

    public boolean verificarLimite() {
        if (getSoma() > 21) {
            return false;
        } else {
            return true;
        }
    }

    public void adicionarCarta(int numero) {
        if (numero == 1) {
            this.quantidadeAs++;
            numero += 10;
        }
        this.soma += numero;
        
        while (this.quantidadeAs > 0 && getSoma() > 21) {
            this.soma -= 10;
            this.quantidadeAs--;
        }
    }

    public int getSoma() { 
        return this.soma; 
    }

    public String getNome() { 
        return this.nome; 
    }

    public void reiniciarSoma() { 
        this.soma = 0; 
        this.quantidadeAs = 0; 
    }
}
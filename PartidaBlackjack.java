import java.util.Scanner;

public class PartidaBlackjack {
    
    public static boolean lerRespostaSimNao(Scanner entrada) {
        while (true) {
            String resposta = entrada.next().trim().toLowerCase();
            if (resposta.equals("s") || resposta.equals("sim")) {
                return true;
            } else if (resposta.equals("n") || resposta.equals("nao") || resposta.equals("não")) {
                return false;
            } else {
                System.out.print("Resposta invalida! Digite (s/n ou sim/nao): ");
            }
        }
    }

    public static String gerarNomeAleatorio() {
        String[] nomes = {"Joao", "Maria", "Pedro", "Ana", "Carlos", "Mariana", "Paulo", "Julia", "Lucas", "Beatriz"};
        int indice = (int)(Math.random() * nomes.length);
        return nomes[indice];
    }

    public static void main(String[] args) {
        boolean continuarJogo = true;
        boolean comprarCarta = true;
        Participante[] jogadores;
        Scanner entrada = new Scanner(System.in);
    
        System.out.println("\n=== BLACKJACK ===");
        System.out.println("Iniciando nova partida...");
        
        jogadores = new Participante[]{ 
            new Participante("Voce"), 
            new Participante(gerarNomeAleatorio()) 
        };
        
        BaralhoCartas baralho = new BaralhoCartas();
        baralho.embaralhar();

        System.out.printf("\nJogador 1: %s\nJogador 2: %s", jogadores[0].getNome(), jogadores[1].getNome());

        while (continuarJogo && baralho.getCartaAtual() < 48) {
            System.out.println("\n\n--- NOVA RODADA ---");
            
            for (Participante j : jogadores) {
                j.reiniciarSoma();
            }

            System.out.println("\nCartas do adversario:");
            for (int i = 0; i < 2; i++) {
                jogadores[1].adicionarCarta(baralho.distribuirCarta());
            }
            System.out.printf("\nPontuacao do adversario: %d\n", jogadores[1].getSoma());

            System.out.println("\nSuas cartas:");
            for (int i = 0; i < 2; i++) {
                jogadores[0].adicionarCarta(baralho.distribuirCarta());
            }
            System.out.printf("\nSua pontuacao: %d", jogadores[0].getSoma());
            
            do {
                System.out.printf("\n\nDeseja comprar mais uma carta? (s/n): ");
                comprarCarta = lerRespostaSimNao(entrada);
                if (comprarCarta) {
                    jogadores[0].adicionarCarta(baralho.distribuirCarta());
                    System.out.printf("\nSua pontuacao atual: %d", jogadores[0].getSoma());
                }
            } while (comprarCarta && jogadores[0].getSoma() < 21);
            
            if (!jogadores[0].verificarLimite()) {
                System.out.printf("\n%s, voce ultrapassou 21 pontos! ", jogadores[0].getNome());
            }

            while (jogadores[1].getSoma() <= jogadores[0].getSoma() && jogadores[1].getSoma() <= 19 && jogadores[1].verificarLimite()) {
                System.out.println("\n\nAdversario comprando carta...");
                jogadores[1].adicionarCarta(baralho.distribuirCarta());
                System.out.printf("\nPontuacao do adversario: %d", jogadores[1].getSoma());
            }

            if (!jogadores[1].verificarLimite()) {
                System.out.printf("\n%s ultrapassou 21 pontos! ", jogadores[1].getNome());
            }

            System.out.println("\n\n--- RESULTADO ---");
            if (!jogadores[0].verificarLimite()) {
                System.out.printf("%s venceu!!\n", jogadores[1].getNome());
            } else if (!jogadores[1].verificarLimite()) {
                System.out.printf("%s venceu!!\n", jogadores[0].getNome());
            } else if (jogadores[0].getSoma() > jogadores[1].getSoma()) {
                System.out.printf("%s venceu!!\n", jogadores[0].getNome());
            } else if (jogadores[0].getSoma() < jogadores[1].getSoma()) {
                System.out.printf("%s venceu!!\n", jogadores[1].getNome());
            } else {
                System.out.println("Empate!!");
            }

            System.out.printf("\nPontuacao final - %s: %d | %s: %d", 
                jogadores[0].getNome(), jogadores[0].getSoma(), 
                jogadores[1].getNome(), jogadores[1].getSoma());
            
            System.out.printf("\n\nDeseja jogar outra rodada? (s/n): ");
            continuarJogo = lerRespostaSimNao(entrada);
        }
        
        System.out.println("\n=== FIM DO JOGO ===");
        entrada.close();
    } 
}
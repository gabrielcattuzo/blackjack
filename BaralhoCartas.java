import java.security.SecureRandom;

public class BaralhoCartas {
   private Carta[] baralho;
   private int cartaAtual;
   private static final int TOTAL_CARTAS = 52;
   private static final SecureRandom aleatorio = new SecureRandom();

   public BaralhoCartas() {
      String[] valores = {"As", "Dois", "Tres", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
      String[] naipes = {"Copas", "Ouros", "Paus", "Espadas"};
      baralho = new Carta[TOTAL_CARTAS];
      cartaAtual = 0;
      
      for (int contador = 0; contador < baralho.length; contador++) {
         int posicao = contador % 13;
         int pontuacao = (posicao >= 10) ? 10 : (posicao + 1);
         baralho[contador] = new Carta(valores[contador % 13], naipes[contador / 13], pontuacao);
      }
   } 

   public void embaralhar() {
      cartaAtual = 0; 
      for (int primeira = 0; primeira < baralho.length; primeira++) {
         int segunda = aleatorio.nextInt(TOTAL_CARTAS);
         Carta temporaria = baralho[primeira];        
         baralho[primeira] = baralho[segunda];   
         baralho[segunda] = temporaria;            
      } 
   } 

   public int distribuirCarta() {
      if (cartaAtual < baralho.length) {
         System.out.printf("\n  %-19s", baralho[cartaAtual]);
         Carta c = baralho[cartaAtual++];
         return c.getValor();
      } else {
         return 0;
      }
   }

   public int getCartaAtual() { 
      return this.cartaAtual; 
   }
}
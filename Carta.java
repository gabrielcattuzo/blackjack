public class Carta {
   private final String valorCarta;
   private final String naipe;
   private final int valor;

   public Carta(String valorCarta, String naipe, int valor) {
      this.valorCarta = valorCarta;
      this.naipe = naipe; 
      this.valor = valor;
   } 

   public String toString() { 
      return this.valorCarta + " de " + this.naipe; 
   }

   public int getValor() { 
      return this.valor; 
   } 
}
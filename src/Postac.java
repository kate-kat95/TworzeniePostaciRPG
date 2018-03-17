import java.util.Random;

public class Postac {
	
	 String imie;
	 int SumaWspolczynnikowGlownych;
     int Rany = 0;
     int[] WspolczynnikiGlowne= new int[8];
     int[] WspolczynnikiPomocnicze = new int[5];
     int[] Umietnosci = new int[22];
     int[] AkcjeRuch = new int[4];
     int[] AkcjeZwarcie = new int[2];
     int[] AkcjeRapierAtak = new int[7];
     int[] AkcjeRapierObrona = new int[4];
     int[] AkcjeMieczAtak = new int [4];
     int[] AkcjeMieczObrona = new int[3];
     
     public Postac() 
     {
    	 Random generator= new Random();
    	 this.imie = "piotr";
    	 for(int i=0;i<this.WspolczynnikiGlowne.length;i++) {
    		 WspolczynnikiGlowne[i] = generator.nextInt(14)+6;
    	 }	
     }
}

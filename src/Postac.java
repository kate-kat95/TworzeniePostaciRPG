import java.util.Random;

public class Postac {
	
	 String imie;
	 int SumaWspolczynnikowGlownych;
     int Rany = 0;
     int[] WspolczynnikiGlowne= new int[8];
     int[] WspolczynnikiPomocnicze = new int[5];
     int[] Umiejetnosci = new int[22];
     int[] AkcjeRuch = new int[4];
     int[] AkcjeZwarcie = new int[2];
     int[] AkcjeRapierAtak = new int[7];
     int[] AkcjeRapierObrona = new int[4];
     int[] AkcjeMieczAtak = new int [4];
     int[] AkcjeMieczObrona = new int[3];
     
     public Postac() 
     {
    	 // for testing purpose
    	 for(int i=0;i<this.WspolczynnikiPomocnicze.length;i++)
    		 this.WspolczynnikiPomocnicze[i]=0;
    	 for(int i=0;i<this.Umiejetnosci.length;i++)
    		 this.Umiejetnosci[i]=0;
    	 for(int i=0;i<this.AkcjeRuch.length;i++)
    		 this.AkcjeRuch[i]=0;
    	 for(int i =0;i<this.AkcjeZwarcie.length;i++)
    		 this.AkcjeZwarcie[i]=0;
    	 for(int i =0;i<this.AkcjeRapierAtak.length;i++)
    		 this.AkcjeRapierAtak[i]=0;
    	 for(int i =0;i<this.AkcjeRapierObrona.length;i++)
    		 this.AkcjeRapierObrona[i]=0;
    	 for(int i =0;i<this.AkcjeMieczAtak.length;i++)
    		 this.AkcjeMieczAtak[i]=0;
    	 for(int i =0;i<this.AkcjeMieczObrona.length;i++)
    		 this.AkcjeMieczObrona[i]=0;
    	// for testing purpose
    	 
    	 Random generator= new Random();
    	 this.imie = "piotr";
    	 for(int i=0;i<this.WspolczynnikiGlowne.length;i++) {
    		 this.WspolczynnikiGlowne[i] = generator.nextInt(14)+6;
    		 SumaWspolczynnikowGlownych += WspolczynnikiGlowne[i];
    	 }
    	 
    	//auxiliary coefficients
    	 WspolczynnikiPomocnicze[0]=(WspolczynnikiGlowne[1]+WspolczynnikiGlowne[3]+WspolczynnikiGlowne[5])/3;
    	 WspolczynnikiPomocnicze[1]=(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[4]+WspolczynnikiGlowne[7])/3;
    	 WspolczynnikiPomocnicze[2]=20;
    	 WspolczynnikiPomocnicze[3]=(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[1]+WspolczynnikiGlowne[2])/3;
    	 WspolczynnikiPomocnicze[4]=(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[3]+WspolczynnikiGlowne[5])/3;
    	 
    	 //auxiliary coefficients without faith
    	 int SumaUmiejetnosci=8;
    	 for(int i = 0;i<22;i++) {
    		 if(i<4) Umiejetnosci[i]=2;
    		 else {
    			 Umiejetnosci[i]=1;
    			 SumaUmiejetnosci++;
    		 }
    	 }

    	 while(SumaUmiejetnosci<=(int)(SumaWspolczynnikowGlownych/2)) {
    		 int los = generator.nextInt(22);
    		 Umiejetnosci[los]++;
    		 SumaUmiejetnosci++;
    	 }
    	 
    	 //determination of combat actions
    	 AkcjeRuch[0] = WspolczynnikiPomocnicze[3] - 10;
         AkcjeRuch[1] = WspolczynnikiPomocnicze[3] - 9;
         AkcjeRuch[2] = WspolczynnikiPomocnicze[3] - 12;
         AkcjeRuch[3] = (int)(WspolczynnikiPomocnicze[3]/3)+4;

         for(int i=0;i<Umiejetnosci[1];i++) {
        	 int los = generator.nextInt(4);
        	 AkcjeRuch[los]++;
         }
         
        //movements 
         AkcjeRapierAtak[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
         AkcjeRapierAtak[1] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
         AkcjeRapierAtak[2] = WspolczynnikiPomocnicze[3] -15;
         AkcjeRapierAtak[3] = (int)(WspolczynnikiPomocnicze[3] / 2) - 7;
         AkcjeRapierAtak[4] = WspolczynnikiPomocnicze[3] -12;
         AkcjeRapierAtak[2] = WspolczynnikiPomocnicze[3] -8;
         AkcjeRapierAtak[5] = (int)(WspolczynnikiPomocnicze[3] / 3) - 1;

         AkcjeRapierObrona[0] = (int)(WspolczynnikiPomocnicze[3]/2)-2;
         AkcjeRapierObrona[1] = (int)(WspolczynnikiPomocnicze[3]/2)-2;
         AkcjeRapierObrona[2] = (int)(WspolczynnikiPomocnicze[3]/2)-5;
         AkcjeRapierObrona[3] = WspolczynnikiPomocnicze[3]-18;

         for(int i=0;i<Umiejetnosci[2]*3;i++) {
        	 int los= generator.nextInt(10);
        	 	if(los<6) AkcjeRapierAtak[los]++;
        	 	else {
        	 		los=los-6;
        	 		AkcjeRapierObrona[los]++;
        	 	}
         }
       //rapier
         AkcjeMieczAtak[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 7;
         AkcjeMieczAtak[1] = WspolczynnikiPomocnicze[3] - 17;
         AkcjeMieczAtak[2] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
         AkcjeMieczAtak[3] = (int)(WspolczynnikiPomocnicze[3] / 3) - 3;

         AkcjeMieczObrona[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 4;
         AkcjeMieczObrona[1] = (int)(WspolczynnikiPomocnicze[3] / 2) - 4;
         AkcjeMieczObrona[2] = WspolczynnikiPomocnicze[3] - 20;

         for(int i=0;i<Umiejetnosci[3]/2;i++) {
        	 int los = generator.nextInt(7);
        	 if(los<7) AkcjeMieczAtak[los]++;
        	 else {
        		 los=los-4;
        		 AkcjeMieczObrona[los]++;
        	 }
         }
       //sword  
         AkcjeZwarcie[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
         AkcjeZwarcie[1] = (int)(WspolczynnikiPomocnicze[3] / 2) - 3;

         for(int i=0;i<Umiejetnosci[0];i++) {
        	 int los = generator.nextInt(2);
        	 AkcjeZwarcie[los]++;
         }
     }
}

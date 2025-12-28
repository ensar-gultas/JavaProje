
package otelrezervasyonsistemi;

import java.util.Scanner;


public class OtelOtomasyon {
    
    static String [] isimler = new String[100];
    static String [] soyAdlar = new String[100];
    static long [] tcNumaralari = new long[100];
    static long [] telNumaralari = new long[100];
    static int [] dogumYillari = new int[100];
    static int [] odaNumaralari = new int[100]; //Girilen değerin oda numarasına rezervasyon yapar.
    static boolean [] odaKontrol = new boolean[100]; //Odanın dolu olup olmadığını kontrol eder.
    
    static Scanner input = new Scanner(System.in);  
    static int kayitSayisi = 0;
    
    
    static void rezervasyonOlustur(){
        
        System.out.println("Rezervasyon yapabileceğiniz boş odalar şunlarıdır: ");
        for (int i = 0; i < odaNumaralari.length; i++) {
            if(odaKontrol[i] == false){
                System.out.print("[" + (i+1) + "] ");
            }
            else{
                System.out.print("[X]" + " ");
            }
            if((i+1) % 10 == 0){
                System.out.println();
            }
        }
        System.out.print("\nRezervasyon yapmak istediğiniz oda numarasını giriniz: ");
        int secilenOda = input.nextInt();
        input.nextLine();
        
        if(secilenOda < 1 || secilenOda > 100){
            System.out.println("Otelde sadece 1-100 aralığında odalar mevcuttur.");
            return;
        }
        if(odaKontrol[secilenOda -1] == true){
            System.out.println("Bu oda dolu!");
            return;
        }    
        System.out.print("İsminizi giriniz: ");
        isimler[kayitSayisi] = input.nextLine();
        
        System.out.print("Soyadınızı giriniz: ");
        soyAdlar[kayitSayisi] = input.nextLine();
        
        System.out.print("TC kimlik numaranızı giriniz: ");
        tcNumaralari[kayitSayisi] = input.nextLong();
        
        System.out.print("Telefon numaranızı giriniz: ");
        telNumaralari[kayitSayisi] = input.nextLong();
        
        System.out.print("Doğum yılınızı giriniz: ");
        dogumYillari[kayitSayisi] = input.nextInt();
        
        odaNumaralari[kayitSayisi] = secilenOda;
        odaKontrol[secilenOda -1] = true;
        kayitSayisi++;
        
        System.out.println("\nRezervasyon oluşturuldu!");
        System.out.println("--------------------");
    }
    
    static void rezervasyonIptal(){
        
        System.out.print("İptal etmek istediğiniz odanın numarasını giriniz: ");
        int iptalOda = input.nextInt();
        
        if(odaKontrol[iptalOda -1] == false){
            System.out.println("Oda boş durumda.İptal edilecek rezervasyon bulunamadı.");
        }
        else{
            for (int i = 0; i < kayitSayisi; i++) {
                
                if(odaNumaralari[i] == iptalOda){
                    odaNumaralari[i] = 0;
                    isimler[i] = "Silindi";
                    soyAdlar[i] = "Silindi";
                    tcNumaralari[i] = 0;
                    telNumaralari[i] = 0;
                    dogumYillari[i] = 0;
                    break;
                }
            }
            odaKontrol[iptalOda - 1] = false;
            System.out.println("\nRezervasyon iptal edildi!");
            System.out.println("--------------------");
        }
    }
    
    static void rezervasyonGuncelle(){
        
        System.out.print("Güncellemek istediğiniz odanın numarasını giriniz: ");
        int guncelOda = input.nextInt();
        input.nextLine();
        
        if(odaKontrol[guncelOda -1] == false){
            System.out.println("Oda boş durumda.Güncellenecek rezervasyon bulunamadı.");
        }
        else{
            for (int i = 0; i < kayitSayisi; i++) {
                
                if(odaNumaralari[i] == guncelOda){
                    System.out.print("Yeni isminizi giriniz: ");
                    isimler[i] = input.nextLine();
                    
                    System.out.print("Yeni soyadınızı giriniz: ");
                    soyAdlar[i] = input.nextLine();
        
                    System.out.print("Yeni TC kimlik numaranızı giriniz: ");
                    tcNumaralari[i] = input.nextLong();

                    System.out.print("Yeni telefon numaranızı giriniz: ");
                    telNumaralari[i] = input.nextLong();

                    System.out.print("Yeni doğum yılınızı giriniz: ");
                    dogumYillari[i] = input.nextInt();
                    
                    break;
                }
            }
            System.out.println("\nRezervasyon güncellendi.");
            System.out.println("--------------------");
        }
    }
    
    static void rezervasyonAra(int odaNumarasi){
        
        if(odaNumarasi < 1 || odaNumarasi > 100){
            System.out.println("Otelde sadece 1-100 aralığında odalar mevcuttur.");
            return;
        }
        
        if(odaKontrol[odaNumarasi -1] == false){
            System.out.println("Girilen oda numarası boş.Dolu olan bir oda numarası giriniz.");
            return;
        }
        
        for (int i = 0; i < kayitSayisi; i++) {
            
            if(odaNumaralari[i] == odaNumarasi){
                System.out.println("İsmi: " + isimler[i]);
                System.out.println("Soyadı: " + soyAdlar[i]);
                System.out.println("TC numarası: " + tcNumaralari[i]);
                System.out.println("Telefon numarası: " + telNumaralari[i]);
                System.out.println("Doğum yılı: " + dogumYillari[i]);
                break;
            }
        }
        System.out.println("\nRezervasyon arama tamamlandı.");
        System.out.println("--------------------");
    }
    
    static void rezervasyonAra(long tcNumarasi){
        
        boolean bulunduMu = false;
        
        for (int i = 0; i < kayitSayisi; i++) {
            
            if(tcNumaralari[i] == tcNumarasi){
                System.out.println("İsmi: " + isimler[i]);
                System.out.println("Soyadı: " + soyAdlar[i]);
                System.out.println("Oda numarası: " + odaNumaralari[i]);
                System.out.println("Telefon numarası: " + telNumaralari[i]);
                System.out.println("Doğum yılı: " + dogumYillari[i]);
                bulunduMu = true;
                break;
            }
        }
        if(bulunduMu){
            System.out.println("\nRezervasyon arama tamamlandı.");
        }
        else{
            System.out.println("\nGirdiğiniz TC numarasına ait sistemde kayıtlı bir rezervasyon bulunamadı.");
        }
        System.out.println("--------------------");
    }
    
    static void rezervasyonListele(){
        
        for (int i = 0; i < kayitSayisi; i++) {
            
            if(odaNumaralari[i] != 0){
                System.out.println("\n" + odaNumaralari[i] + ". oda sahibinin ismi: " + isimler[i]);
                System.out.println(odaNumaralari[i] + ". oda sahibinin soyadı: " + soyAdlar[i]);
                System.out.println(odaNumaralari[i] + ". oda sahibinin TC numarası: " + tcNumaralari[i]);
                System.out.println(odaNumaralari[i] + ". oda sahibinin telefon numarası: " + telNumaralari[i]);
                System.out.println(odaNumaralari[i] + ". oda sahibinin doğum yılı: " + dogumYillari[i]);
            }
        }
        System.out.println("\nTüm rezervasyonlar listelendi.");
        System.out.println("--------------------");
    }   
    
    public static void main(String[] args) {
        
        int girilen = 0;
        
        while(girilen != 6){
        
        System.out.println("\nOTEL REZERVASYON SİSTEMİ");
        
        System.out.println("1- Rezervasyon Oluştur");
        System.out.println("2- Rezervasyon İptal");
        System.out.println("3- Rezervasyon Güncelle");
        System.out.println("4- Rezervasyon Ara");
        System.out.println("5- Rezervasyonları Listele");
        System.out.println("6- Çıkış yap");
        System.out.print("\nYapmak istediğiniz işlemin numarasını giriniz: ");
        
        girilen = input.nextInt();
        input.nextLine(); 
        
            switch(girilen){
                
                case 1 : 
                    rezervasyonOlustur();
                    break;
                case 2 :
                    rezervasyonIptal();
                    break;
                case 3 :
                    rezervasyonGuncelle();
                    break;
                case 4 :
                    System.out.println("\n1- Oda numarası ile ara");
                    System.out.println("2- TC numarası ile ara");
                    System.out.print("Rezervasyonu aramak istediğiniz yöntemi giriniz: ");
                    
                    int yontem = input.nextInt();
                    
                    if(yontem == 1){
                        System.out.print("Oda numarasını giriniz: ");
                        int odaNumarasi = input.nextInt();
                        rezervasyonAra(odaNumarasi);
                    }
                    else if(yontem == 2){
                        System.out.print("TC numarasını giriniz: ");
                        long tcNumarasi = input.nextLong();
                        rezervasyonAra(tcNumarasi);
                    }
                    else{
                        System.out.println("Yöntem 1 veya 2 olmalıdır.  ");
                    }
                    break;
                case 5 :
                    rezervasyonListele();
                    break;
                case 6 :
                    System.out.println("Otel rezervasyon sisteminden çıkış yapılıyor.İyi günler dileriz!");
                    break;
                default:
                    System.out.println("Girilen işlem değeri 1-6 arasında olmalıdır!");
            }
        }
    }
    
}

import java.util.Scanner;

public class kahve_makinesi {
    private boolean sut;
    private boolean seker;
    private int sekerMiktari;
    private kahve kahve;
    private KahveBoyutu kahveBoyutu;

    //private ArrayList<KahveMakinesi> siparisOzeti = new ArrayList<>();

    // medium yazınca MEDIUM algılamıyor
    Scanner readInt = new Scanner(System.in);
    Scanner readStr = new Scanner(System.in);

    public void kahveTuruSec() {
        for (kahve kahve1 : kahve.values()) {
            System.out.println(kahve1);
        }

        System.out.print("Kahvenizinin Türünü Seçebilir Misiniz : ");
        String kahve1 = readStr.nextLine().trim().toUpperCase();  // türk kahvesi

        try {
            this.kahve = kahve.valueOf(kahve1); // String i enum a çeviriyoruz
            if (this.kahve == kahve.BuzluKahve || this.kahve == kahve.Frappuccino) {
                System.out.println("Sıcak bir yaz gününde serinlemenin " +
                        "en iyi yolu… Mükemmel karar!");
            } else {
                System.out.println("Tam zamanında yetiştin");
            }

            String boyut = kahveBoyutu();

            System.out.println(boyut + " " + kahve1 + " hazırlanıyor..");

            Thread.sleep(1000);

            System.out.println(kahve1+" Süt Eklemek İster Misiniz(E/H)");
            String sutCevap=readStr.nextLine();

            if (sutCevap.equalsIgnoreCase("evet")){
                System.out.println(kahve1+" süt ekleniyor lütfen bekleyiniz");
                Thread.sleep(1000);
            }else{
                System.out.println(kahve1+" sütsüz hazırlanıyor");
            }

            int sugar =sekerMiktari();

            if (sugar > 0 && !(sutCevap.equalsIgnoreCase("evet")) ){
                System.out.println(boyut+" "+kahve1+" sütsüz"+
                        " "+ sugar+" küp şekele hazırlanıyor.." );
            } else if (!(sutCevap.equalsIgnoreCase("evet")) && sugar==0) {
                System.out.println(boyut+" "+kahve1+" sütsüz ve şekersiz hazırlanıyor..");
            } else if ((sutCevap.equalsIgnoreCase("evet") && sugar > 0)) {
                System.out.println(boyut+" "+kahve1+" süt ve "+
                        sugar+" "+" küp şekerle hazırlanıyor");
            } else {
                System.out.println(boyut+" "+kahve1+
                        " sütle hazırlanıyor,şeker ilave edilmeyecek");
            }


        } catch (IllegalArgumentException illegal) {
            System.out.println("Geçersiz seçim. Lütfen geçerli bir seçim yapınız!");
            kahveTuruSec(); // eğer catch içine girerse kahveSec(); methoduna
            // giderek döngü gibi davranıp kahveSec(); methoduna
            // yeniden girer
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String kahveBoyutu() {
        for (KahveBoyutu boyut : KahveBoyutu.values()) {
            System.out.println(boyut);
        }

        System.out.print("Kahve Boyutunu Seçebilir Misiniz : ");
        String boyut = readStr.nextLine().trim().toUpperCase();

        try {
            this.kahveBoyutu = KahveBoyutu.valueOf(boyut);

        } catch (IllegalArgumentException exception) {
            System.out.println("Geçersiz seçim. Lütfen geçerli bir seçim yapınız!");
            kahveBoyutu();
        }

        return boyut;
    }

    public int sekerMiktari(){

        System.out.print(this.kahve + " şeker ister misiniz?(E/H) : ");
        String sekerCevap=readStr.nextLine();


        if (sekerCevap.equalsIgnoreCase("Evet")){
            System.out.print("Kaç Şeker İsterseniz : ");
            int sekerSayisi=readInt.nextInt();
            return sekerSayisi;

        }else {
            System.out.println("Kahveniz Şekersiz Hazırlanıyor");

        }


        return 0;
    }



//    public KahveMakinesi(boolean sut, boolean seker, int sekerMiktari,
//                         Kahve kahve, KahveBoyutu kahveBoyutu) {
//        setSut(sut);
//        setSeker(seker);
//        setSekerMiktari(sekerMiktari);
//        setKahve(kahve);
//        setKahveBoyutu(kahveBoyutu);
//    }

    public boolean isSut() {
        return sut;
    }

    public void setSut(boolean sut) {
        this.sut = sut;
    }

    public boolean isSeker() {
        return seker;
    }

    public void setSeker(boolean seker) {
        this.seker = seker;
    }

    public int getSekerMiktari() {
        return sekerMiktari;
    }

    public void setSekerMiktari(int sekerMiktari) {
        this.sekerMiktari = sekerMiktari;
    }

    public kahve getKahve() {
        return kahve;
    }

    public void setKahve(kahve kahve) {
        this.kahve = kahve;
    }

    public KahveBoyutu getKahveBoyutu() {
        return kahveBoyutu;
    }

    public void setKahveBoyutu(KahveBoyutu kahveBoyutu) {
        this.kahveBoyutu = kahveBoyutu;
    }
}
















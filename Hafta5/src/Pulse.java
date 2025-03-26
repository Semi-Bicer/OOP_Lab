public class Pulse {
    private String ad;
    private String soyad;
    private int dogumYili;

    public Pulse(String ad, String soyad, int dogumYili) {
        this.ad = ad;
        this.soyad = soyad;
        this.dogumYili = dogumYili;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getDogumYili() {
        return dogumYili;
    }

    public void setDogumYili(int dogumYili) {
        this.dogumYili = dogumYili;
    }


    public int yasHesapla() {
        //return 2025 - this.dogumYili;

        return java.time.LocalDate.now().getYear() - dogumYili ;

    }

    public int maxNabiz() {
        return 220 - yasHesapla();
    }

    public int minIdealNabiz() {
        return (int) (maxNabiz() * 0.5);
    }

    public int maxIdealNabiz() {
        return (int) (maxNabiz() * 0.85);
    }

    public String toString() {
        return ad + " " + soyad + "\n" + "Yaş : " + yasHesapla() + "\n Max Nabız : " + maxNabiz()
                + "\n İdeal Nabız Aralığı : " + minIdealNabiz() + "-" + maxIdealNabiz();
    }
}

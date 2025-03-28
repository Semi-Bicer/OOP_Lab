import java.util.Scanner;

public class Lecture {
    private String lectureName;
    private double _midterm;
    private double _final;
    private double _average;

    public Lecture(String lectureName) {
        this.lectureName = lectureName;
        this._midterm = 0.0;
        this._final = 0.0;
        this._average = 0.0;
    }

    // kullanıcıdan not girişi alma
    public void inputGrades() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n" + lectureName + " dersi: ");
        
        // vize notu girişi
        do {
            System.out.print("Vize notunu giriniz (0-100): ");
            if (scanner.hasNextDouble()) {
                this._midterm = scanner.nextDouble();
                if (this._midterm >= 0 && this._midterm <= 100) {
                    break;
                }
            }
            System.out.println("Hata: Lütfen 0-100 arasında geçerli bir sayı giriniz!");
            scanner.nextLine(); 
        } while (true);

        // final notu girişi
        do {
            System.out.print("Final notunu giriniz (0-100): ");
            if (scanner.hasNextDouble()) {
                this._final = scanner.nextDouble();
                if (this._final >= 0 && this._final <= 100) {
                    break;
                }
            }
            System.out.println("Hata: Lütfen 0-100 arasında geçerli bir sayı giriniz!");
            scanner.nextLine(); // Buffer'ı temizle
        } while (true);

        calculateAverage();
    }

    // ortalama hesaplama
    private void calculateAverage() {
        this._average = (this._midterm * 0.4) + (this._final * 0.6);
    }

    // 60'dan küçük ortalama kontrolü
    public boolean belowSixtyAverage(){
        return this._average < 60;
    }

    public boolean hasAboveAverage(Student student){
        return this._average > student.getOverallAverage();
    }

    // getter
    public String getLectureName() {
        return lectureName;
    }

    public double getMidtermGrade() {
        return _midterm;
    }

    public double getFinalGrade() {
        return _final;
    }

    public double getAverage() {
        return _average;
    }

    @Override
    public String toString() {
        return String.format("Ders Adı: %s\tVize Notu: %.0f\tFinal Notu: %.0f\tOrtalama: %.1f",
                lectureName, _midterm, _final, _average);
    }
}

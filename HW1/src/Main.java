import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Öğrenci sayısı?");
        int n = sc.nextInt(); // kullanıcıdan öğrenci sayısnı alacak

        int[] ID = new int[n];
        String[] name = new String[n];
        double[] midterm = new double[n];
        double[] _final = new double[n];
        double[] mean = new double[n];

        takeInfo(sc,n,ID, name, midterm, _final, mean); // Öğrenci bilgilerini alacak

        int menuChoice = -1;
        do{
            menuChoice = -1;
            System.out.println("1. Öğrenci bilgilerini görüntüle.");
            System.out.println("2. Sınav sonuç oratalmasını hesapla.");
            System.out.println("3. 60'dan düşük sınav sonuçlarını görüntüle.");
            System.out.println("4. Ortalamanın üstünde not alan öğrencileri görüntüle.");
            System.out.println("5. 60'dan düşük sınav sonuçlarını sayısı görüntüle.");
            System.out.println("6. En yüksek sınav sonucunu göster.");
            System.out.println("7. En düşük sınav sonucunu göster.");
            System.out.println("8. Sınav sonuçlarına göre küçükten büyüğe sırala.");
            System.out.println("0. Çıkış");
            menuChoice = sc.nextInt();

            switch(menuChoice){
                case 1: showInfo(n, ID, name, midterm, _final, mean); break;
                case 2: calculateAverage(n,midterm,_final, mean); break;
                case 3: belowSixty(n,ID,name,midterm,_final); break;
                case 4: aboveAverage(n, ID, midterm,_final,mean); break;
                case 5: numberOfBelowSixty(n,midterm,_final); break;
                case 6: highestGrade(n,midterm,_final); break;
                case 7: lowestGrade(n, midterm,_final); break;
                case 8:
                    System.out.println("1. Vize sonucuna göre sırala.");
                    System.out.println("2. Final sonucuna göre sırala.");
                    System.out.println("3. Oratalamaya göre sırala.");
                    menuChoice = sc.nextInt();
                    labeledGrades(n, ID, name, midterm, _final, mean, menuChoice);
                    break;
                case 0: System.out.println("Çıkış yapılıyor"); break;
                default:
                    System.out.println("Geçersiz seçim");

            }
        }while(menuChoice != 0);
    }

    // Öğrenci bilgilerini alacak metod
    public static void takeInfo(Scanner sc,int n,int[] studentNo, String[] name, double[] midterm, double[] _final, double[] mean){
        for(int i = 0 ; i < n; i++){
            System.out.println(i+1 +". Öğrenci ismini girin."); // öğrenci ismini alacak
            sc.nextLine();
            name[i] = sc.nextLine();
            System.out.println(i+1 +". Öğrenci numarasını girin."); // öğrenci numarasını alacak
            studentNo[i] = sc.nextInt();
            System.out.println(i+1 +". Vize noturnu giriniz."); // Vize notunu alacak
            midterm[i] = sc.nextDouble();
            System.out.println(i+1 + ". Final notunu giriniz."); // final notunu alacak
            _final[i] = sc.nextDouble();
            mean[i] = 0.4 * midterm[i] + 0.6 * _final[i];
        }
    }

    // Öğrenci bilgilerini ekrana yazdıracak metod
    public static void showInfo(int N, int[] studentNo, String[] name, double[] midterm, double[] _final, double[] mean){
        for (int i =0; i< N; i++){
            System.out.println(studentNo[i]);
            System.out.println(name[i]);
            System.out.println(midterm[i]);
            System.out.println(_final[i]);
            System.out.println(mean[i]);
        }
    }

    // Sınıf ortalamalarını hesaplayacak metod
    public static void calculateAverage(int N,double[] midterm,double[] _final, double[] mean){
        double sum_mid = 0,sum_final = 0, sum_mean = 0;
        for(double grade : midterm)
            sum_mid += grade;
        for(double grade : _final)
            sum_final += grade;
        for(double grade : mean)
            sum_mean += grade;
        System.out.println("Vize sınıf ortalması: "+ sum_mid/N);
        System.out.println("Final sınıf ortalması: "+ sum_final/N);
        System.out.println("Genel sınıf ortalması: "+ sum_mean/N);
    }

    // 60'dan düşük notları ekrana yazdıracak metod
    public static void belowSixty(int N, int[] StudentNo, String[] name, double[] midterm, double[] _final){
        for(int i = 0 ; i < N; i++){
            if (midterm[i] < 60)
                System.out.println("Vize-> " +"Öğrenci numarası: " +StudentNo[i]+" Öğrenci ismi: " + name[i]);
            if (_final[i] < 60)
                System.out.println("Final-> " +"Öğrenci numarası: " +StudentNo[i] + " Öğrenci ismi: " + name[i]);
        }
    }

    // Ortalamanın üstündeki öğrencileri ekrana yazdıracak metod
    public static void aboveAverage(int N, int[] StudentNo, double[] midterm, double[] _final, double[] mean){
        double average=0;
        for (double grade : mean)
            average += grade; // ortalamaların toplamını buluyoruz
        average /= N; // asıl sınıf ortalamasını burada sınıf mevcuduna bölerek buluyoruz
        for (int i = 0; i < N; i++){
            if (mean[i] < average)
                System.out.println("Öğrenci Numarası: " + StudentNo[i] + " " +  "Vize: " + midterm[i] + " " + "Final: " + _final[i] );
        }
    }

    // 60'dan düşük notların sayısını ekrana yazdıracak metod
    public static void numberOfBelowSixty(int N ,double[] midterm, double[] _final){
        int count = 0;
        for(int i = 0 ; i < N; i++){
            if (midterm[i] < 60)
                count++;
            if (_final[i] < 60)
                count++;
        }
        System.out.println(count);
    }

    // En yüksek notu bulacak ve ekrana yazdıracak metod
    public static void highestGrade(int N ,double[] midterm, double[] _final){
        double max_mid = 0, max_final = 0;
        for (int i = 0; i < N; i++){
            if (max_mid < midterm[i])
                max_mid = midterm[i];
        }
        for (int i = 0; i < N; i++) {
            if (max_final < _final[i])
                max_final = _final[i];
        }
        double highest= (max_mid > max_final) ? max_mid : max_final;
        System.out.println(highest);
    }

    // En düşük notu bulacak ve ekrana yazdıracak metod
    public static void lowestGrade(int N ,double[] midterm, double[] _final){
        double min_mid = 100, min_final = 100;
        for (int i = 0; i < N; i++){
            if (min_mid > midterm[i])
                min_mid = midterm[i];
        }
        for (int i = 0; i < N; i++) {
            if (min_final > _final[i])
                min_final = _final[i];
        }
        double highest= (min_mid < min_final) ? min_mid : min_final;
        System.out.println(highest);
    }

    // Spesifik sınav sonucuna göre sıralayacak ve ekrana yazdıracak metod
    public static void labeledGrades(int N ,int[] StudentNo ,String[] name ,double[] midterm, double[] _final, double[] mean, int key){
        double[] midtermLabeled = copyArray(midterm);
        double[] finalLabeled = copyArray(_final);
        double[] meanLabeled = copyArray(mean);
        String[] nameLabeled = copyArray(name);
        int[] studentNoLabeled = copyArray(StudentNo);

        double dtemp = 0;
        String stemp = "";
        int itemp = 0;

        switch(key){// Alınan key parametresi neye göre sıralanacağını belirlyecek
            case 1: // Vize sonuçlarına göre sıralama
                for (int i = 0; i < N-1; i++){
                    for (int j = i+1; j < N; j++){
                        if (midtermLabeled[i] > midtermLabeled[j]){
                            dtemp = midtermLabeled[i];
                            midtermLabeled[i] = midtermLabeled[j];
                            midtermLabeled[j] = dtemp;
                            stemp = nameLabeled[i];
                            nameLabeled[i] = nameLabeled[j];
                            nameLabeled[j] = stemp;
                            itemp = studentNoLabeled[i];
                            studentNoLabeled[i] = studentNoLabeled[j];
                            studentNoLabeled[j] = itemp;
                        }
                    }
                }
                for (int i = 0; i < N; i++){
                    System.out.println("Öğrenci Numarası: " + studentNoLabeled[i]);
                    System.out.println("İsmi: " + nameLabeled[i]);
                    System.out.println("Vize Notu: " + midtermLabeled[i]);
                    System.out.println("---------------------------------------------------------------------------");
                }
                break;
            case 2: // Final sonuçlarına göre sıralama
                for (int i = 0; i < N-1; i++){
                    for (int j = i+1; j < N; j++){
                        if (finalLabeled[i] > finalLabeled[j]){
                            dtemp = finalLabeled[i];
                            finalLabeled[i] = finalLabeled[j];
                            finalLabeled[j] = dtemp;
                            stemp = nameLabeled[i];
                            nameLabeled[i] = nameLabeled[j];
                            nameLabeled[j] = stemp;
                            itemp = studentNoLabeled[i];
                            studentNoLabeled[i] = studentNoLabeled[j];
                            studentNoLabeled[j] = itemp;
                        }
                    }
                }
                for (int i = 0; i < N; i++){
                    System.out.println("Öğrenci Numarası: " + studentNoLabeled[i]);
                    System.out.println("İsmi: " + nameLabeled[i]);
                    System.out.println("Final Notu: " + finalLabeled[i]);
                    System.out.println("---------------------------------------------------------------------------");
                }
                break;
            case 3: // Oratalamya göre sıralama
                for (int i = 0; i < N-1; i++){
                    for (int j = i+1; j < N; j++){
                        if (meanLabeled[i] > meanLabeled[j]){
                            dtemp = meanLabeled[i];
                            meanLabeled[i] = meanLabeled[j];
                            meanLabeled[j] = dtemp;
                            stemp = nameLabeled[i];
                            nameLabeled[i] = nameLabeled[j];
                            nameLabeled[j] = stemp;
                            itemp = studentNoLabeled[i];
                            studentNoLabeled[i] = studentNoLabeled[j];
                            studentNoLabeled[j] = itemp;
                        }
                    }
                }

                for (int i = 0; i < N; i++){
                    System.out.println("Öğrenci Numarası: " + studentNoLabeled[i]);
                    System.out.println("İsmi: " + nameLabeled[i]);
                    System.out.println("Ders Ortalaması: " + meanLabeled[i]);
                    System.out.println("---------------------------------------------------------------------------");
                }
                break;
            default:
        }
    }

    // Yukardaki fonksionda kullanmak için dizi kopyalama metodları
    public static double[] copyArray(double[] array){
        double[] newArray = new double[array.length];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        return newArray;
    }
    public static int[] copyArray(int[] array){
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        return newArray;
    }
    public static String[] copyArray(String[] array){
        String[] newArray = new String[array.length];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        return newArray;
    }

}
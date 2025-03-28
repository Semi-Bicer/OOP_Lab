import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);

        mainLoop: while (true) {
            System.out.println("1. Öğrenci ekle");
            System.out.println("2. Son Öğrenci bilgilerini düzenle");
            System.out.println("3. Tüm öğrencileri görüntüle");
            System.out.println("4. Öğrenci sil");
            System.out.println("5. Ders başı 60'dan düşük ortalamaya sahip öğrencileri görüntüle");
            System.out.println("6. Ders başı ortalamanın üstünde olan öğrencileri görüntüle");
            System.out.println("7. 60'dan düşük sınav sonuçlarını sayısı görüntüle");
            System.out.println("8. En yüksek sınav sonucunu göster");
            System.out.println("9. Öğrenci ortlamalarına göre küçükten büyüğe sırala");

            System.out.println("0. Çıkış");
            
            int menuChoice = sc.nextInt();
            
            switch (menuChoice) {
                case 1:
                    System.out.print("Öğrenci adını giriniz: ");
                    sc.nextLine(); // Buffer'ı temizle
                    String studentName = sc.nextLine();
                    System.out.print("Öğrenci numarasını giriniz: ");
                    String studentId = sc.nextLine();
                    StudentFactory.createStudent(studentName, studentId);
                    
                    while (true) {
                        System.out.println("Ders eklemek istiyor musunuz?(Y/N)");
                        String response = sc.nextLine();
                        if (response.equalsIgnoreCase("Y")) {
                            System.out.print("Ders adını giriniz: ");
                            String lectureName = sc.nextLine();
                            StudentFactory.getLastCreatedStudent().addLecture(lectureName);
                        }
                        else 
                            break;
                    }
                    break;
                
                case 2:
                    secondMainLoop : while (true) {
                        System.out.println("1. Ismi değiştirmek için (i)");
                        System.out.println("2. Dersleri düzenlemek için (d)");
                        System.out.println("3. Çıkış yapmak için (ç)");
                        switch (sc.nextLine()) {
                            case "i":
                                System.out.println("Öğrenci adını giriniz: ");
                                String newName = sc.nextLine();
                                StudentFactory.getLastCreatedStudent().setName(newName);
                                break;
                            case "d":
                                thirdMainLoop : while (true) {
                                    System.out.println("1. Ders eklemek için (e)");
                                    System.out.println("2. Ders silmek için (s)");
                                    System.out.println("3. Geri dönmek için (g)");
                                    System.out.println("4. Ana menüye dönmek için (q)");
                                    
                                    switch (sc.nextLine()) {
                                        case "e":
                                            System.out.println("Ders adını giriniz: ");
                                            String lectureName = sc.nextLine();
                                            StudentFactory.getLastCreatedStudent().addLecture(lectureName);
                                            break;
                                        case "s":
                                            System.out.println("Silinecek ders adını giriniz: ");
                                            String lectureNameToRemove = sc.nextLine();
                                            StudentFactory.getLastCreatedStudent().removeLecture(lectureNameToRemove);
                                            break;
                                        case "g": break thirdMainLoop; // switch'ten çıkış yapmak için
                                        case "q": break secondMainLoop; // while'den çıkış yapmak için
                                        default: System.out.println("Geçersiz seçim");
                                    }
                                    
                                    // if (sc.nextLine().equals("g"))
                                    //     break;
                                }
                        
                            case "ç": break secondMainLoop;
                            default: System.out.println("Geçersiz seçim");
                        }

                        // if (sc.nextLine().equals("ç"))
                        //     break;
                    }
                    
                case 3: StudentFactory.displayAllStudents(); break;
                
                case 4:
                    System.out.println("Silinecek öğrenci numarasını giriniz: ");
                    String studentIdToRemove = sc.nextLine();
                    StudentFactory.removeStudent(studentIdToRemove);
                    break;
                
                case 5:
                    StudentFactory.belowSixtyAverage();
                    break;

                case 6:
                    StudentFactory.aboveAverage();
                    break;
                
                case 7:
                    StudentFactory.belowSixtyAverageCount();
                    break;
                
                case 8:
                    StudentFactory.highestGrade();
                    break;

                case 9:
                    StudentFactory.sortByAverage();
                    break;

                case 0: 
                    System.out.println("Çıkış yapılıyor...");
                    break mainLoop;  // labeled break gerçekten çok işe yarıyor. teşekkürler hocam :)
                default: 
                    System.out.println("Geçersiz seçim");
            }
        }
    }
} 
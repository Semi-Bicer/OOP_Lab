import java.util.ArrayList;

public class StudentFactory {
    private static ArrayList<Student> students = new ArrayList<>();
    
    public static Student createStudent(String name, String id) {
        Student newStudent = new Student(name, id);
        students.add(newStudent);
        return newStudent;
    }

    public static void removeStudent(String id){
        students.removeIf(student -> student.getId().equals(id));
    }
    
    public static Student getLastCreatedStudent() {
        if (students.isEmpty()) {
            return null;
        }
        return students.get(students.size() - 1); // son eklenen öğrenciyi döndürür
    }


    public static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Henüz öğrenci eklenmemiş!");
            return;
        }
        
        System.out.println("\n=== TÜM ÖĞRENCİLER ===");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("\n" + (i+1) + ". Öğrenci:");
            System.out.println("İsim: " + student.getName());
            System.out.println("Ders Sayısı: " + student.getLectures().size());
            System.out.println("Genel Oratalama: " + student.getOverallAverage());
            
            // Öğrencinin derslerini listele
            if (!student.getLectures().isEmpty()) {
                System.out.println("Dersler:");
                for (Lecture lecture : student.getLectures()) {
                    System.out.println(lecture.toString());
                }
            }
        }
        System.out.println("\n=====================");
    }

    public static void belowSixtyAverage(){
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            for (Lecture lecture : student.getLectures()){
                if (lecture.belowSixtyAverage()){
                    System.out.println("Öğrenci Numarası: " + student.getId() + " Öğrenci İsmi: " + student.getName());
                }
            }
        }
    }

    public static void aboveAverage(){
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            for (Lecture lecture : student.getLectures()){
                if (lecture.hasAboveAverage(student)){
                    System.out.println("Öğrenci Numarası: " + student.getId() + " Öğrenci İsmi: " + student.getName());
                }
            }
        }
    }

    public static void belowSixtyAverageCount(){
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            for (Lecture lecture : student.getLectures()){
                if (lecture.getMidtermGrade() < 60)
                    count++;
                if (lecture.getFinalGrade() < 60)
                    count++;
            }
        }
        System.out.println("60'dan düşük ortalamaya sahip derslerin sayısı: " + count);
    }

    public static void highestGrade(){
        double highestGrade = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            for (Lecture lecture : student.getLectures()){
                if (lecture.getMidtermGrade() > highestGrade)
                    highestGrade = lecture.getMidtermGrade();
                if (lecture.getFinalGrade() > highestGrade)
                    highestGrade = lecture.getFinalGrade();
            }
        }
        System.out.println("En yüksek not: " + highestGrade);
    }

    public static void sortByAverage() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() -i -1; j++) {
                if (students.get(j).getOverallAverage() > students.get(j + 1).getOverallAverage()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }

        displayAllStudents();
    }
}
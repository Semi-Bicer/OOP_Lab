import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Lecture> lectures;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.lectures = new ArrayList<>();
        this.id = id;
    }

    // Getter ve Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }
    public int getLectureCount() {
        return lectures.size();
    }

    public String getId(){
        return id;
    }

    // Ders ekleme ve silme metodları
    public void addLecture(String lectureName) {
        Lecture lecture = new Lecture(lectureName);
        lecture.inputGrades();
        lectures.add(lecture);
    }


    public void removeLecture(String lectureName) {
        lectures.removeIf(Lecture -> Lecture.getLectureName().equals(lectureName));
    }

    public double getOverallAverage(){
        double overallAverage = 0.0;
        for (Lecture lecture : lectures) {
            overallAverage += lecture.getAverage();
        }
        return overallAverage / lectures.size();
    }

    

    

    @Override
    public String toString() {
        return "Öğrenci Adı: " + name + "\nDers Sayısı: " + getLectureCount();
    }
}


public class Rectangle {
    int longEdge;
    int shortEdge;

    public Rectangle(int sEdge, int lEdge){
        setShortEdge(sEdge);
        setLongEdge(lEdge);
    }

    public Rectangle(){
        longEdge = 1;
        shortEdge = 1;
    }

    public int getShortEdge(){
        return this.shortEdge;
    }
    public void setShortEdge(int shortEdge){
        if (shortEdge > 0)
            this.shortEdge = shortEdge;
        else
            System.out.println("Kısa kenar pozitif bir değer olmalıdır.");
    }

    public int getLongEdge(){
        return longEdge;
    }
    public void setLongEdge(int longEdge){
        if (longEdge > 0)
            this.longEdge = longEdge;
        else
            System.out.println("Uzun kenar pozitif bir değer olmalıdır.");
    }

    public int circumference(){
        return (shortEdge + longEdge) * 2;
    }

    public int area(){
        return shortEdge * longEdge;
    }

    public void info(){
        System.out.println("Dikdörtgenin kısa kenarı : " + getShortEdge());
        System.out.println("Dikdörtgenin uzun kenarı : " + getLongEdge());
        System.out.println("Dikdörtgenin çevresi : " + circumference());
        System.out.println("Dikdörtgenin alanı : " + area());
    }
}

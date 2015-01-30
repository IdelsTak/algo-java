package t08_OOD.CallCenter;
public class Call implements java.io.Serializable {
// ------------------------------ FIELDS ------------------------------
    private int duration;
    private int number;

// --------------------------- CONSTRUCTORS ---------------------------
    public Call(int number, int duration) {
        this.number = number;
        this.duration = duration;
    }

// --------------------- GETTER / SETTER METHODS ---------------------
    public int getDuration() {
        return duration;
    }

    public int getNumber() {
        return number;
    }
}

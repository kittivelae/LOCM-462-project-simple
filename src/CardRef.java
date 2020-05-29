import java.io.BufferedReader;
import java.io.FileReader;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

public class CardRef {



    // acknowledgment: class from this SO answer:
    // https://stackoverflow.com/questions/10234487/storing-number-pairs-in-java
    final int iid;
    final int uid;

    boolean smmnSickness = true;

    CardRef(int iid, int uid) {
        this.iid=iid;
        this.uid=uid;
    }

    public int getIid() {
        return iid;
    }

    public int getUid() {
        return uid;
    }

    public void removeSmmnSickness() {
        this.smmnSickness = false;
    }

    public boolean isSmmnSickness() {
        return smmnSickness;
    }
}

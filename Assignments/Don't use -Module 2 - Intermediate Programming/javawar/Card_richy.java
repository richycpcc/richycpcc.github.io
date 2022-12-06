import java.util.Arrays;
import java.util.List;
public class Card {
    private String faceValue;
    private String suitValue;

    //constructor to create new instance of card object
    public Card (String faceValue, String suitValue)
    {
        setFaceValue (faceValue);
        setSuitValue (suitValue);
    }

    // getters and setters methods for Strings
    public String getFaceValue() {
        return faceValue;
    }

    /**
     * This method returns a list of face names that are valid for Card objects
     * @param
     */
    public static List<String> getValidFaceValue()
    {
        return Arrays.asList ("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
    }
    public void setFaceValue(String faceValue)
    {
        List <String> validFaceValue = getValidFaceValue();
        faceValue = faceValue.toLowerCase();
        if (validFaceValue.contains(faceValue))
        {
            this.faceValue = faceValue;
        }
        else
        {
            throw new IllegalArgumentException("Valid face names are " + validFaceValue);
        }
    }

    public String getSuitValue() {
        return suitValue;
    }

    public static List<String> getValidSuitValue()
    {
        return Arrays.asList("hearts,diamonds,spades,clubs");
    }

    public void setSuitValue(String suitValue) {
        List<String> validSuitValue = getValidSuitValue();
        suitValue = suitValue.toLowerCase();
        if (validSuitValue.contains(suitValue))
        {
            this.suitValue = suitValue;
        }
        else
        {
            throw new IllegalArgumentException("Valid suit values are " + validSuitValue);
        }
    }

    public String toString()
    {
        return String.format("%s of %s", faceValue, suitValue);
    }
}

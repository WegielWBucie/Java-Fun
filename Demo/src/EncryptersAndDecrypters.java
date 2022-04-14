import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncryptersAndDecrypters
{
    public static String transpositionEncrypter(String text, List<Integer> key)
    {
        StringBuilder result = new StringBuilder();
        try{
            List<Character>temp = new ArrayList<>();
            //int spaceCounter = 0;
            for(int i=0; i<text.length(); i++)
            {
                temp.add(text.charAt(i));
            }
            int size = Math.max(key.size(), text.length());
            for(int i=0; i<size; i++)
            {
                Collections.swap(temp, (((i)%key.size()))%text.length(), ((key.get((i)%key.size()))%text.length()));
            }
            for(int i=0; i<text.length(); i++)
                result.append(temp.get(i));
        }
        catch (Exception exception){
            System.err.println(exception.getLocalizedMessage());
        }
        return result.toString();
    }
    public static String affineEncrypter(String text, int[] key)
    {
        StringBuilder result = new StringBuilder();
        try{
            //int spaceCounter = 0;
            for(int i=0; i<text.length(); i++)
            {
                int ascii;
                if(text.charAt(i) <= 122 && text.charAt(i) >= 97)
                {
                    ascii = 97;
                    result.append((char) (ascii + (text.charAt(i) - ascii + (text.charAt(i) - ascii) * key[0] + key[1]) % 26));
                }
                else if(text.charAt(i) <= 90 && text.charAt(i) >= 65)
                {
                    ascii = 65;
                    result.append((char) (ascii + (text.charAt(i) - ascii + (text.charAt(i) - ascii) * key[0] + key[1]) % 26));
                }
                else {
                    //spaceCounter++;
                    result.append(text.charAt(i));
                }
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
        return result.toString();
    }
    public static String VigenereEncrypter(String text, String key)
    {
        StringBuilder result = new StringBuilder();
        try{
            int spaceCounter = 0;
            for(int i=0; i<text.length(); i++)
            {
                int ascii, keyAscii;
                char c = key.charAt(i % key.length());
                boolean included= c <= 122 && c >= 97;
                if(text.charAt(i) <= 122 && text.charAt(i) >= 97)
                {
                    ascii = 97;
                    if(included)
                        keyAscii = 97;
                    else
                        keyAscii = 65;
                    result.append((char) (ascii + (text.charAt(i) - ascii + key.charAt((i - spaceCounter) % key.length()) - keyAscii + 1) % 26));
                }
                else if(text.charAt(i) <= 90 && text.charAt(i) >= 65)
                {
                    ascii = 65;
                    if(included)
                        keyAscii = 97;
                    else
                        keyAscii = 65;
                    result.append((char) (ascii + (text.charAt(i) - ascii + key.charAt((i - spaceCounter) % key.length()) - keyAscii + 1) % 26));
                }
                else
                {
                    spaceCounter++;
                    result.append(text.charAt(i));
                }
            }
        } catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
        return result.toString();
    }
    public static String transpositionDecrypter(String text, List<Integer>key)
    {
        StringBuilder result = new StringBuilder();
        try{
            List<Character>temp = new ArrayList<>();
            //int spaceCounter = 0, spaceAtAll = 0;
            for(int i=0; i<text.length(); i++)
            {
                temp.add(text.charAt(i));
            }
            int size = Math.max(key.size(), text.length());
            for(int i=size-1; i>=0; i--)
            {
                Collections.swap(temp, (((i)%key.size()))%text.length(), ((key.get((i)%key.size()))%text.length()));
            }
            for(int i=0; i<text.length(); i++)
                result.append(temp.get(i));
        }
        catch (Exception exception){
            System.err.println(exception.getLocalizedMessage());
        }
        return result.toString();
    }
    public static String affineDecrypter(String text, int[] key)
    {
        StringBuilder result = new StringBuilder();
        try{
            //int spaceCounter = 0;
            for(int i=0; i<text.length(); i++)
            {
                int ascii;
                if(text.charAt(i) <= 122 && text.charAt(i) >= 97)
                {
                    ascii = 97;

                    result.append((char) (ascii + (text.charAt(i) - ascii + (text.charAt(i) - ascii) * key[0] + key[1]) % 26));
                }
                else if(text.charAt(i) <= 90 && text.charAt(i) >= 65)
                {
                    ascii = 65;
                    result.append((char) (ascii + (text.charAt(i) - ascii + (text.charAt(i) - ascii) * key[0] + key[1]) % 26));
                }
                else
                {
                    //spaceCounter++;
                    result.append(text.charAt(i));
                }
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
        return result.toString();
    }
    public static String VigenereDecrypter(String text, String key)
    {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        try{
            int spaceCounter = 0;
            for(int i=0; i<text.length(); i++)
            {
                int ascii, keyAscii;
                if(text.charAt(i) <= 122 && text.charAt(i) >= 97)
                {
                    ascii = 97; //keyAscii = 97;
                    int number = (text.charAt(i) - key.charAt((i - spaceCounter) % key.length()) - 1) % 26;
                    if(text.charAt(i) > key.charAt((i - spaceCounter)%key.length()))
                        result.append((char)
                                (ascii + number));
                    else result.append((char)
                            (ascii + 26 + number));
                }
                else if(text.charAt(i) <= 90 && text.charAt(i) >= 65)
                {
                    ascii = 65; keyAscii = 97;
                    int number = key.charAt((i - spaceCounter) % key.length()) - keyAscii;
                    int number2 = (text.charAt(i) - ascii - (number) - 1) % 26;
                    if(text.charAt(i) - ascii > number)
                    {
                        result.append((char)
                                (ascii + number2));
                    }
                    else result.append((char)
                            (ascii + 26 + number2));
                }
                else
                {
                    spaceCounter++;
                    result.append(text.charAt(i));
                }
            }
        } catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
        return result.toString();
    }
}

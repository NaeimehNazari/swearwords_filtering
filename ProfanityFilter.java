
import java.util.Scanner;

public class ProfanityFilter 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] swearWordsArr = sc.nextLine().split(" ");

        while (sc.hasNextLine())
        {
            String currentLine = sc.nextLine();
            String[] words = currentLine.split(" ");

            for (int i = 0; i < words.length; i++)
            {
                words[i] = filterWords(words[i], swearWordsArr);
            }

            System.out.println(String.join(" ", words));
        }

        sc.close();
    }

    public static String filterWords(String words, String[] swearWordsArr)
    {
        String punctuation = "";

        if (words.endsWith(",") ||
            words.endsWith(".") ||
            words.endsWith("!") ||
            words.endsWith("?"))
        {
            punctuation = words.substring(words.length() - 1);
            words = words.substring(0, words.length() - 1);
        }

        for (String swearWord : swearWordsArr)
        {
            if (words.equalsIgnoreCase(swearWord))
            {
                String replacement = "";

                for (int i = 0; i < words.length(); i++)
                {
                    replacement += "*&#$%".charAt(i % 5);
                }

                return replacement + punctuation;
            }
        }

        return words + punctuation;
    }
}


package com.example.kotlinpracticeudemy.problems;

public class PremutationStringCheck {
    public static void main(String[] args) {
        System.out.println(bothStringsPremutationStrings("abc","cbd"));
    }

    public static boolean bothStringsPremutationStrings(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        char[] charArr=s1.toCharArray();
        for(int i=0;i<charArr.length;i++)
        {
            for(int j=i+1;j<charArr.length;j++)
            {
                char temp=charArr[i];
                charArr[i]=charArr[j];
                charArr[j]=temp;

                System.out.println("s1="+convertCharArrayToString(charArr)+"s2="+s2);
                if(convertCharArrayToString(charArr).equals(s2))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static String convertCharArrayToString(char[] charArray) {
        // Check if the array is null
        if (charArray == null) {
            return null;
        }

        // Create a StringBuilder object
        StringBuilder stringBuilder = new StringBuilder();

        // Append each character in the array to the StringBuilder
        for (char c : charArray) {
            stringBuilder.append(c);
        }

        // Return the string representation of the StringBuilder
        return stringBuilder.toString();
    }
}

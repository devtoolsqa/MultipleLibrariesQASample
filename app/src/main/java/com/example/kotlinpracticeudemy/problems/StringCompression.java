package com.example.kotlinpracticeudemy.problems;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println("Result:"+getCompressedString("aabbccccccaaachhhfhfjijkjahhassssssss"));
    }

    public static String getCompressedString(String s1)
    {
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=0;i<s1.length()-1;i++)
        {
            if(s1.charAt(i)==s1.charAt(i+1))
            {
                count++;
            }
            else {
                sb.append(s1.charAt(i)+""+count);
                count=1;
            }
            if(i==s1.length()-2)
            {
                sb.append(s1.charAt(s1.length()-1)+""+count);
                count=1;
            }
        }
        if(sb.toString().length()>s1.length())
        {
            return s1;
        }
        return sb.toString();
    }
}

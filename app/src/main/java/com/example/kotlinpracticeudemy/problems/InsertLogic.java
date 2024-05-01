package com.example.kotlinpracticeudemy.problems;

public class InsertLogic {
    String s1;

    public static void main(String[] args) {
        System.out.println("Result:"+getResult("pale","palee"));
    }

    public static boolean getResult(String s1,String s2)
    {

        int count=0;
        if(s1.length()==s2.length())
        {
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)!=s2.charAt(i))
                {
                    count++;
                }
                if(count==2 )
                {
                    return false;
                }
            }

        }
        else if(s1.length()<s2.length())
        {
            if((s2.length()-s1.length())>1)
            {
                return false;
            }
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)!=s2.charAt(i) && s1.charAt(i)!=s2.charAt(i+1))
                {
                    count++;
                }
                if(count==1 )
                {
                    return false;
                }
            }
        }
        else
        {
            if((s1.length()-s2.length())>1)
            {

                return false;
            }
            for(int i=0;i<s2.length();i++)
            {

                if(s1.charAt(i)!=s2.charAt(i) &&  s1.charAt(i+1)!=s2.charAt(i))
                {
                    count++;
                }
                if(count==2)
                {
                    return false;
                }
            }
        }
        return true;
    }
}

package com.example.kotlinpracticeudemy.problems;

public class UniqueStringCheck {
    public static void main(String[] args) {

        String[] arr={"sandeep","sharanya","hskdlein"};
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]+" is unique:"+isHavingUniqueElements(arr[i]));
        }

    }

    public static boolean isHavingUniqueElements(String name)
    {
        char[] nameArr=name.toCharArray();
        int count=0;
        for(int i=0;i<nameArr.length;i++)
        {
            for(int j=i;j<nameArr.length;j++)
            {
                if(nameArr[i]==nameArr[j])
                {
                    count++;
                }
                if(count==2)
                {
                    return false;
                }
            }
            count=0;
        }

        return true;
    }
}

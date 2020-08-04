package com.practice.ds.amazon.stringQuestions;

public class StrEqlByRotation {
    //also when left rotated by k , indexes decrease by k, so new index will be ((i-k)+l)%l
    //when right rotated by k, indexes increase by k ,so new indexes will ne (i+k)%l
    private boolean isRotatedString(String s1,String s2,int k)
    {
        String leftRotatedStr="";
        String rightRotatedStr="";
        int n = s2.length();
        leftRotatedStr =leftRotatedStr+s2.substring(n-k)+s2.substring(0,n-k);
        rightRotatedStr=rightRotatedStr+s2.substring(k)+s2.substring(0,k);
        if(leftRotatedStr.equals(s1) || rightRotatedStr.equals(s1))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        StrEqlByRotation strOps = new StrEqlByRotation();
        System.out.println(strOps.isRotatedString("amazon","onamaz",2));
        System.out.println(strOps.isRotatedString("amazon","azonam",2));
    }
}

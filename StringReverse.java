package com.company;

public class StringReverse {
        public static String reverse(String str) {
            String nstr="";
            char ch;
            for (int i=0; i<str.length(); i++)
            {
                ch= str.charAt(i);
               nstr= ch+nstr;
            }
         return nstr;
        }
    }

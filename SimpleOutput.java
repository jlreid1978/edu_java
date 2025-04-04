// A simple program that prints text on the terminal

import java.text.DecimalFormat;

public class SimpleOutput {
    public static void main(String []args){
        String funnyStr = "south, long island";
        funnyStr.replace("!"," ");
        funnyStr.replace("the beach","");
        funnyStr.replace(", long", "");
        funnyStr.replace("wal","roc");
        funnyStr.toUpperCase();
        System.out.println(funnyStr);
    }
}
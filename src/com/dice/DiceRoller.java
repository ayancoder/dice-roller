package com.dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DiceRoller {
    final static List<String> validDiceSides = new ArrayList<>(Arrays.asList("4", "6", "8", "10", "12", "20"));

    public static void main(String[] args) {
        
        ValidateExpression validate = new ValidateExpression();
        //String str = "4D6 - 3D4 + 4D6";
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        
        List<String> strings = evaluateExpression.getTrimedStrings(args);
        if(strings.size()==1) {
           if(strings.get(0).length()>=7 && (strings.get(0).contains("+")||strings.get(0).contains("+"))) {
               strings = evaluateExpression.getSplitedString(strings.get(0));
           }
        }
        if (validate.isValidateExpression(strings, validDiceSides)) {
            int finalValue = evaluateExpression.calcuate(strings);
            System.out.println(finalValue);
        }else {
            System.out.println("invalid expression");
        }

    }

   
}

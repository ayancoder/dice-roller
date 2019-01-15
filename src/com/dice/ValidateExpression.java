package com.dice;

import java.util.List;

public class ValidateExpression {

    public boolean isValidateExpression(List<String> strings , List<String> validDiceSides) {
        boolean isValid=false;
        if(!isNullExpression(strings) && isThereSpace(strings) && isAllSidesAreValid(strings,validDiceSides) &&
                isNumberOfMoveValid(strings)) {
            isValid=true;
        }
        return isValid;
    }
   private boolean isNullExpression(List<String> strings) {
       boolean isValid = true;
       if(strings!=null && !strings.isEmpty()) {
           isValid=false;
       }
       return isValid;
   }

    private boolean isAllSidesAreValid(List<String> exprs, List<String> validDiceSides) {
        boolean isValid = true;
        for (int i = 0; i < exprs.size(); i = i + 2) {
            String diceSideValue = exprs.get(i).substring(2);
            isValid =validDiceSides.contains(diceSideValue);
            if(isValid==false)
                break;
        }
        return isValid;
    }
    private boolean isNumberOfMoveValid(List<String> exprs) {
        boolean isValid = true;
        for (int i = 0; i < exprs.size(); i = i + 2) {
            int numberOfRoll = Character.getNumericValue(exprs.get(i).charAt(0));
            if(numberOfRoll<=0) {
                isValid=false;
            }
        }
        return isValid;
    }
    private boolean isThereSpace(List<String> exprs) {
        boolean isValid = true;
        for (int i = 0; i < exprs.size(); i = i + 2) {
             if(exprs.get(i).length()<3 ) {
                  isValid = false;
            }
        }
        return isValid;
    }
}

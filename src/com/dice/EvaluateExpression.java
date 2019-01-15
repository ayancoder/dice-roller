package com.dice;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class EvaluateExpression {

    public int calcuate(List<String> tokenizedExpression) {

        int result = 0;
        int index = 0;

        while (index < tokenizedExpression.size()) {
            String diceExpr = tokenizedExpression.get(index);
            String operator;
            if (index == 0) {
                operator = "+";
            } else {
                operator = tokenizedExpression.get(index - 1);
            }
            int diceValue = evaluateRolledDice(diceExpr);
            result = evaluateExpression(result, diceValue, operator);
            index = index + 2;
        }
        return result;
    }

    public List<String> getSplitedString(String expr) {
        LinkedList<String> exprElements = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(expr, "+-", true);
        while (st.hasMoreTokens())
            exprElements.add(st.nextToken().trim());
        return exprElements;
    }
    public List<String> getTrimedStrings(String[] args) {
        LinkedList<String> exprElements = new LinkedList<>();

        for (int i = 0; i < args.length; i++) {
            exprElements.add(args[i].trim());
        }
        return exprElements;
    }

    public int evaluateRolledDice(String expr) {

        int numberOfRoll = Character.getNumericValue(expr.charAt(0));
        int numberOfSides = Character.getNumericValue(expr.charAt(2));
        Dice dice = new Dice(numberOfSides);
        dice.roll();
        int rolledValue = dice.getValue();
        return numberOfRoll * rolledValue;
    }

    public int evaluateExpression(int first, int second, String operator) {

        int result = 0;
        if ("+".equals(operator)) {
            result = first + second;
        } else if ("-".equals(operator)) {
            result = first - second;
        }
        return result;
    }
}

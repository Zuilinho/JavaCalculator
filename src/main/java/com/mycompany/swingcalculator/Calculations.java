/**
 *
 * @author Luiz Henrique Baldão Filho
 */
package com.mycompany.swingcalculator;

import java.util.ArrayList;
import java.util.List;


public class Calculations 
{
    public static void main(String args[])
    {
        
        Calculations c = new Calculations();
        System.out.println(">>>"+c.calculator("5/5"));
    }
    
    public String calculator (String expression)
    {
        String result;
        List<Double> numberList = new ArrayList<Double>();
        List<Character> operatorsList = new ArrayList<Character>();
        
        numberList = getNumbers(expression);
        operatorsList = getOperators(expression);
        
        result = calculateValue(numberList, operatorsList);
        
        return result;
    }
    
    public String calculateValue(List<Double> numberList, List<Character> operatorsList)
    {
        String result = "";
        double total = 0.0;
        int j = 0;
        for (int i = 0; i < numberList.size()-1; i++)
        {
            if (total == 0.0)
            {
                double number1 = numberList.get(i).doubleValue();
                double number2 = numberList.get(i + 1).doubleValue();
                char operator = operatorsList.get(i).charValue();
                total = executeOperation(number1, operator, number2);
            }
            
            else if (total > 0.0)
            {
                double number2 = numberList.get(i).doubleValue();
                char operator = operatorsList.get(j).charValue();
                total = executeOperation(total, operator, number2);
                j++;
            }
        }
        
        result = ""+total;
        return result;
    }
    
    
    private double executeOperation(double number1, char operator, double number2)
    {
        double result = 0.0;
        
        if (operator == '+')
        {
            result = number1 + number2;
        }
        else if (operator == '-') 
        {
            result = number1 - number2;
        }
        else if (operator == '*') 
        {
            result = number1 * number2;
        }
        else if (operator == '/') 
        {
            result = number1 / number2;
        }
        return result;
    }
    
    private List<Double> getNumbers(String expression)
    {
        List<Double> numberList = new ArrayList<Double>();
        
        String numberInString = "";
        for (int i =0; i < expression.length(); i++)
        {
            if (isOperator(expression.charAt(i))) 
            {
                Double number = Double.valueOf(numberInString);
                numberList.add(number);
                numberInString = "";
            }
            else 
            {
                numberInString = numberInString.concat("" + expression.charAt(i));
            }
        }
        
        if (!numberInString.isEmpty())
        {
            Double number  = Double.valueOf(numberInString);
            numberList.add(number);
        }
        return numberList;
    }
    
    private List<Character> getOperators(String expression)
    {
        List<Character> operatorsList = new ArrayList<Character>();
        
        for (int i = 0; i < expression.length(); i++)
        {
            if (isOperator(expression.charAt(i)))
            {
                operatorsList.add(new Character(expression.charAt(i)));
            }
        }
        
        return operatorsList;
    }
    
    private boolean isOperator(char caracter)
    {
        boolean isOperator = false;
        if (caracter == '-' || caracter == '+' || caracter == '*' || caracter == '/')
        {
            isOperator = true;
        }
        return isOperator;
    }
}

 




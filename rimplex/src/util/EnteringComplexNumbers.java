package util;

import math.ComplexNumber;
import math.Operation;

/**
 * Utility class for parsing complex numbers.
 * 
 * @author Jackson Brantley
 *
 */
public final class EnteringComplexNumbers
{

  /**
   * Constructor, set to private as there is no need to create an instance of this class.
   */
  private EnteringComplexNumbers()
  {

  }

  /**
   * Given a string, convert the string into a complex number. If the string is missing either the
   * real number or the imaginary number, return a complex number with the missing number as 0.0.
   * 
   * @param input
   *          the string to convert to a complex number
   * @return the complex number
   * @throws NullPointerException
   *           if input is null
   * @throws IllegalArgumentException
   *           if input is empty
   * @throws NumberFormatException
   *           if input is not a valid complex number
   */
  public static ComplexNumber parseComplexNumber(final String input)
  {
    final String plus = "+";
    final String minus = "-";
    final String i = "i";

    if (input == null)
      throw new NullPointerException();
    if (input.isEmpty())
      throw new IllegalArgumentException();

    double real = 0.0;
    double imaginary = 0.0;
    String operator = "";
    int index = 0;

    if (input.contains(plus))
    {
      operator = plus;
      index = input.indexOf(operator);
    }
    else if (input.contains(minus))
    {
      if (input.indexOf(minus) == 0)
      {

        if (input.indexOf(minus, input.indexOf(minus) + 1) == -1)
          operator = "";
        else
        {
          operator = minus;
          index = input.indexOf(minus, input.indexOf(minus) + 1);
        }
      }
      else if (input.indexOf(minus) != 0)
      {
        operator = minus;
        index = input.indexOf(operator);
      }
    }

    if (operator.isEmpty())
    {
      try
      {
        if (input.contains(i))
          imaginary = Double.parseDouble(input.substring(0, input.indexOf(i)));
        else
          real = Double.parseDouble(input);
      }
      catch (NumberFormatException e)
      {
        throw e;
      }
    }
    else
    {
      try
      {
        real = Double.parseDouble(input.substring(0, index));
        imaginary = Double.parseDouble(input.substring(index + 1, input.indexOf(i)));
        if (operator.equals(minus))
          imaginary *= -1;
      }
      catch (NumberFormatException e)
      {
        throw e;
      }
    }

    return new ComplexNumber(real, imaginary);
  }

  /**
   * Given a string, check to see if the string is a complex number.
   * 
   * @param input
   *          the string to check
   * @return true if a complex number, false otherwise
   */
  public static boolean isComplexNumber(final String input)
  {
    try
    {
      parseComplexNumber(input);
      return true;
    }
    catch (IllegalStateException e)
    {
      return false;
    }
  }

  /**
   * Given an equation, return the ComplexNumber that is the evaluation of the equation.
   * 
   * @param input
   *          the equation as a string
   * @return a ComplexNumber, or null if it is not a proper equation
   */
  public static ComplexNumber parseEquation(final String input)
  {
    final String sqrt = "sqrt";

    String number = "()0123456789-.i";
    String operations = "+-*x/^";
    boolean negitive = false;
    char operation = 0;
    ComplexNumber a = null;
    ComplexNumber b = null;
    ComplexNumber result = null;
    int opId = -1;

    int i = 0;
    if (input.contains("im"))
    {
      i = input.indexOf('m');
    }
    while (i < input.length())
    {

      char token = input.charAt(i);
      if (token == '(')
      {
        if (i != 0 && i - 1 != opId && input.charAt(i - 1) == '-')
        {
          negitive = true;
        }
        if (a == null)

        {
          a = parseComplexNumber(input.substring(i + 1, input.indexOf(')')));
          if (negitive)
          {
            a.negate();
            negitive = false;
          }

          i = input.indexOf(')');
        }
        else
        {
          b = parseComplexNumber(input.substring(i + 1, input.lastIndexOf(')')));
          if (negitive)
          {
            b.negate();
          }
          i = input.lastIndexOf(')');
          break;
        }
      }
      else if (a != null && operation == 0 && operations.indexOf(token) != -1)
      {
        operation = token;
        opId = i;
      }
      else if (number.indexOf(token) != -1)
      {
        int j = i;

        while (number.indexOf(token) != -1 && j < input.length() - 1)
        {
          j++;
          token = input.charAt(j);

        }

        if (!input.substring(i, j).contains("("))
        {

          if (a == null)
          {
            a = parseComplexNumber(input.substring(i, j));
            i = j - 1;
          }
          else
          {
            b = parseComplexNumber(input.substring(i));
            i = j;
            break;
          }
        }
      }
      i++;
    }

    if (i + 1 < input.length())
    {
      throw new NumberFormatException();
    }

    int opCount = 0;
    if (input.contains("con"))
    {
      result = a.conjugate();
      opCount++;
    }
    if (input.contains(sqrt))
    {
      result = Operation.squareRoot(a);
      opCount++;
    }
    if (input.contains("log"))
    {
      result = Operation.log(a);
      opCount++;
    }
    if (input.contains("r") && !input.contains(sqrt))
    {
      result = a.realPart();
      opCount++;
    }
    if (input.contains("m"))
    {
      result = a.imaginaryPart();
      opCount++;
    }
    if (input.contains("pol"))
    {
      result = a.polarForm();
      opCount++;
    }

    if (opCount > 1 || (result != null && b != null))
    {
      throw new NumberFormatException();
    }

    switch (operation)
    {
      case '+':
        result = Operation.add(a, b);
        break;
      case '*':
        result = Operation.multiply(a, b);
        break;
      case 'x':
        result = Operation.multiply(a, b);
        break;
      case '/':
        result = Operation.divide(a, b);
        break;
      case '-':
        result = Operation.subtract(a, b);
        break;
      case '^':
        result = Operation.exponential(a, (int) b.getReal());
        break;
      default:
        break;
    }

    return result;

  }

}

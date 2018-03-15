package DemoApplication

import scala.collection.mutable.Stack



object EvaluationExpression {
  def EvaluteExpression(Expression: String):Int ={
    // Stack for numbers: 'values'

    var values = Stack[Int]()
    // Stack for Operators: 'ops'
    var ops = Stack[Char]()

      var i = 0

      while(i < Expression.length()) {
        if (Expression(i) >= '0' && Expression(i) <= '9') {
          val builder = StringBuilder.newBuilder
          while (i < Expression.length() && Expression(i) >= '0' && Expression(i) <= '9') {
            builder.append(Expression(i))
            i += 1
          }
          values.push(builder.toInt)
        }
        else if (Expression(i) == '(')
          ops.push(Expression(i))
        else if(Expression(i) == ')')
        {
          //TODO: do something later
        }
        else if(Expression(i) == '+'||Expression(i) == '-'||Expression(i) == '*'||Expression(i) == '/')
        {
          while(ops.isEmpty == false &&  hasPrecedence(Expression(i), ops.top))
              values.push(applyOp(ops.pop(), values.pop(), values.pop()))
              
          // Push current token to 'ops'.
                ops.push(Expression(i));
        }
        i+=1
      }
      while (!ops.isEmpty)
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
        
    // Top of 'values' contains result, return it
        return values.pop()
  }
  def  hasPrecedence(op1 : Char,op2 : Char):Boolean={
    if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
  }
  def applyOp(op: Char,b:Int,a:Int):Int = {
    op match
        {
        case '+'=>
            return a + b;
        case '-'=>
            return a - b;
        case '*'=>
            return a * b;
        case '/'=>
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
  }
  def main(args: Array[String])
  {
    //PrintMultiplicationTable()
    print(EvaluteExpression("10+2"))
    
  }
}
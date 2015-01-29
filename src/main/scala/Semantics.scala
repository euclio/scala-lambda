package com.acrussell.lambda

import scala.annotation.tailrec

object Semantics {
//  @tailrec
  def prettyPrint(exp: Expression): String = exp match {
    case Identifier(i) => i
    case Abstraction(i, e) => "λ" + prettyPrint(i) + "." + prettyPrint(e)
    case Application(e1, e2) => prettyPrint(e1) + " " + prettyPrint(e2)
    case Parentheses(e) => "(" + prettyPrint(e) + ")"
  }
}

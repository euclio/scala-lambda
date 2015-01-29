package com.acrussell.lambda

sealed abstract class Expression

case class Identifier(identifier: String) extends Expression
case class Abstraction(identifier: Identifier, expression: Expression) extends Expression
case class Application(e1: Expression, e2: Expression) extends Expression
case class Parentheses(e: Expression) extends Expression

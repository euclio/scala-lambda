package com.acrussell.lambda

import org.scalatest.FlatSpec

class ParserSpec extends FlatSpec {
  behavior of "A lambda calculus parser"

  it should "parse an identifier" in {
    LambdaParser("y") === Identifier("y")
  }

  it should "parse an application" in {
    LambdaParser("x y") === Application(Identifier("x"), Identifier("y"))
  }

  it should "parse an abstraction" in {
    LambdaParser("\\x.x") === Abstraction(Identifier("x"), Identifier("x"))
  }

  it should "allow the lambda character in abstractions" in {
    LambdaParser("λx.x") === Abstraction(Identifier("x"), Identifier("x"))
  }
}

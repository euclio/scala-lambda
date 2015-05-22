package com.acrussell.lambda

import org.scalatest.FlatSpec

class ParserSpec extends FlatSpec {
  behavior of "A lambda calculus parser"

  it should "parse an identifier" in {
    assert(LambdaParser("y").get === Identifier("y"))
  }

  it should "parse an application" in {
    assert(LambdaParser("x y").get ===
      Application(Identifier("x"), Identifier("y")))
  }

  it should "parse an abstraction" in {
    assert(LambdaParser("\\x.x").get ===
      Abstraction(Identifier("x"), Identifier("x")))
  }

  it should "allow the lambda character in abstractions" in {
    assert(LambdaParser("λx.x").get ===
      Abstraction(Identifier("x"), Identifier("x")))
  }

  it should "parse a complicated expression" in {
    assert(LambdaParser("(λ f.f(f y))((λ x.x)(λ x.x))").get ===
      Application(
        Abstraction(Identifier("f"),
          Application(Identifier("f"),
            Application(Identifier("f"), Identifier("y")))),
        Application(
          Abstraction(Identifier("x"), Identifier("x")),
          Abstraction(Identifier("x"), Identifier("x")))))
  }
}

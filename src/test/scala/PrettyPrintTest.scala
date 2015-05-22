package com.acrussell.lambda

import org.scalatest.FlatSpec

import com.acrussell.lambda.Semantics._

class PrettyPrintSpec extends FlatSpec {
  behavior of "A lambda calculus pretty printer"

  it should "remove unneeded parentheses" in {
    assert(prettyPrint(LambdaParser("((((uv)x)y)z)").get) === "u v x y z")
  }

  it should "keep needed parenthesis" in {
    assert(prettyPrint(LambdaParser("(((xy)z)(yx))").get) === "x y z (y x)")
  }
}

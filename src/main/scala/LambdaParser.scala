package com.acrussell.lambda

import scala.util.parsing.combinator._

/*
 * Parses expressions in the lambda calculus.
 */
object LambdaParser extends RegexParsers with PackratParsers {

  lazy val identifier: PackratParser[Identifier] = {
    """[a-zA-Z]""".r ^^ { Identifier(_) }
  }

  lazy val abstraction: PackratParser[Abstraction] = {
    """\\|λ""".r ~> identifier ~ "." ~ expression ^^ { case i ~ _ ~ e => Abstraction(i, e) }
  }

  lazy val application: PackratParser[Application] = {
    expression ~ expression ^^ { case e1 ~ e2 => Application(e1, e2) }
  }

  lazy val expression: PackratParser[Expression] = {
    abstraction | application | identifier | "(" ~> expression <~ ")" ^^ { identity }
  }

  def apply(input: String) = parseAll(expression, input)
}

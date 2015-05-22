package com.acrussell.lambda

object Semantics {

  def prettyPrint(exp: Expression): String = {
    def wrapParens(str: String) = {
      s"($str)"
    }

    def prettyPrintHelper(exp: Expression, isRightmost: Boolean): String = {
      exp match {
        case Identifier(i) => i
        case Abstraction(i, e) => {
          val abstractionStr = "λ" + prettyPrintHelper(i, false) +
                               "." + prettyPrintHelper(e, true)
          if (!isRightmost) wrapParens(abstractionStr) else abstractionStr
        }
        case Application(e1, e2) => {
          val e2str = prettyPrintHelper(e2, isRightmost)
          prettyPrintHelper(e1, false) + " " +
            (e2 match {
              case Application(_, _) => wrapParens(e2str)
              case _ => e2str
            })
        }
      }
    }

    prettyPrintHelper(exp, true)
  }
}

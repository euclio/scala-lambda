package com.acrussell.lambda

import jline.console._

import com.acrussell.lambda.Semantics._

object Main {
  def main(args: Array[String]) {
    val consoleReader = new ConsoleReader()
    while (true) {
      val input = consoleReader.readLine("sci> ")
      if (input.isEmpty) return

      LambdaParser(input) match {
        case LambdaParser.Success(matched, _) => {
          println(prettyPrint(matched))
        }
        case LambdaParser.Failure(msg, _) => println("FAILURE: " + msg)
        case LambdaParser.Error(msg, _) => println("ERROR: " + msg)
      }
    }
  }
}

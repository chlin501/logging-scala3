package examples

import logging._

object App {

  def runWithPrintln(): Unit = {
    val log = Logging[String]
    log.info("hi!")
  }

  def runWithSlf4jLogger(): Unit = {
    import org.slf4j._
    given slf4jLogger: Logger = LoggerFactory.getLogger(classOf[App])
    val log = Logging[String]
    log.info("hi!")
  }

  def main(args: Array[String]): Unit = {
    runWithPrintln()
    runWithSlf4jLogger()
  }
}


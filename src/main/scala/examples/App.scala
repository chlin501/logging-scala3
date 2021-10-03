package examples

import logging._

@main def execute(): Unit =
  import Logging.given
  //given instance: Logging[String] = Logging.logger
  val log = Logging()
  log.info("hi!")


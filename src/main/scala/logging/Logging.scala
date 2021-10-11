package logging

import org.slf4j.{LoggerFactory, Logger => Slf4jLogger}

trait Logging[T]:
  def info(f: => T): T
  def debug(f: => T): T
  def warn(f: => T): T
  def error(f: => T): T

trait LowPriority {

  given consoLogger: Logging[String] = new Logging[String] {

    def info(f: => String): String = { println(f); f }

    def debug(f: => String): String = { println(f); f }

    def warn(f: => String): String = { println(f); f }

    def error(f: => String): String = { println(f); f }

  }

}

object Logging extends LowPriority {

  def apply[T](using ev: Logging[T]): ev.type = ev

  given slf4jLogger (using log: Slf4jLogger): Logging[String] = new Logging[String] {

    def info(f: => String): String = { log.info(f); f }

    def debug(f: => String): String = { log.debug(f); f }

    def warn(f: => String): String = { log.debug(f); f }

    def error(f: => String): String = { log.debug(f); f }

  }

}

package logging

trait Logging[T]:
  def info(f: => T): T
  def debug(f: => T): T
  def warn(f: => T): T
  def error(f: => T): T

object Logging {

  def apply[T: Logging](): Logging[T] = summon[Logging[T]]

  given consoLogger: Logging[String] = new Logging[String] {

    def info(f: => String): String = { println(f); f }
  
    def debug(f: => String): String = { println(f); f }

    def warn(f: => String): String = { println(f); f }

    def error(f: => String): String = { println(f); f }

  }

}

package scaladyno.playground

import scala.reflect.macros.Context
import scala.language.experimental.macros

package object macroz {
  implicit def convert[T](a: Any): T = macro convertImpl[T]
  def convertImpl[T: c.WeakTypeTag](c: Context)(a: c.Expr[Any]) : c.Expr[T] = {
    println("type tag: "+ implicitly[c.WeakTypeTag[T]])
    c.universe.reify[T](???.asInstanceOf[T])
  }
}

package scaladyno.playground

import scala.reflect.macros.whitebox._
import scala.language.implicitConversions
import scala.language.experimental.macros

class SomethingWithBar { def bar: Int = 2 }

class Foo[TFoo]
object Foo {
  implicit def materializeFoo[TMaterializeFoo]: Foo[TMaterializeFoo] = macro impl[TMaterializeFoo]

  def impl[TFooImpl: c.WeakTypeTag](c: Context) = {
    import c.universe._
    println(showRaw(c.weakTypeOf[TFooImpl], printIds = true, printKinds = true))
    println(c.weakTypeOf[TFooImpl].typeSymbol.getClass)
    println(showRaw(c.weakTypeOf[TFooImpl].typeSymbol.typeSignature))
    q"new scaladyno.playground.Foo[scaladyno.playground.SomethingWithBar]"
  }
}

package object macroz {
  implicit def convert[TConvert: Foo](x: Any): TConvert = macro impl[TConvert]

  def impl[TMacrosImpl: c.WeakTypeTag](c: Context)(x: c.Tree)(ev: c.Tree) = {
    import c.universe._
    println("xxxxxx: " + ev.tpe.asInstanceOf[TypeRef])
    q"new ${ev.tpe.asInstanceOf[TypeRef].args.head}"
  }
}


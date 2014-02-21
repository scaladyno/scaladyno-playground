package scaladyno.playground.scratchpad

import scaladyno.playground.macroz._

object Scratchpad {
  class C { def foo() = () }

  val c = new C
  /*
                new ImplicitSearch {
                tree         Scratchpad.this.c
                pt           scala.this.Function1[Scratchpad.this.c.type,?{<method> def bar: ?}]
                  isView       true
                  context0     Context(scaladyno.playground.scratchpad.Scratchpad.<local Scratchpad>@Apply unit=Scratchpad.scala scope=1817701535 errors=false, reportErrors=false, throwErrors=false)
                  undetparams
                }
                typedImplicit0 {
                info.name  convert
                ptChecked  true
                pt         scala.this.Function1[Scratchpad.this.c.type,?{<method> def bar: ?}]
                  orig       info {
                  undetParams
                  info.pre     <root>.this.scaladyno.playground.macroz.type
                  }
                }
                typedImplicit1 convert, pt=scala.this.Function1[Scratchpad.this.c.type,?{<method> def bar: ?}], from implicit convert:[T](<param> a: scala.this.Any)T
                    typing convert: pt = ?: undetparams=, implicitsEnabled=false, enrichmentEnabled=false, mode=EXPRmode BYVALmode POLYmode FUNmode, silent=true, context.owner=value <local Scratchpad>
                        typing scaladyno.playground.macroz.`package`: pt = ?: undetparams=, implicitsEnabled=false, enrichmentEnabled=false, mode=EXPRmode POLYmode QUALmode, silent=true, context.owner=value <local Scratchpad>
                        typed scaladyno.playground.macroz.`package`: <root>.this.scaladyno.playground.macroz.type with underlying macroz.this.package.type
                        adapted scaladyno.playground.macroz.`package`: macroz.this.package.type to ?,
                    typed scaladyno.playground.macroz.`package`.convert: [T](<param> a: scala.this.Any)T
                    adapted scaladyno.playground.macroz.`package`.convert: [T](<param> a: scala.this.Any)T to ?, undetparams=type T
                typed implicit scaladyno.playground.macroz.`package`.convert[scala.this.Nothing](<argument>):scala.this.Nothing, pt=scala.this.Function1[Scratchpad.this.c.type,?{<method> def bar: ?}]
                adapted implicit macro method convert:(<param> a: scala.this.Any)scala.this.Nothing to scala.this.Function1[Scratchpad.this.c.type,?{<method> def bar: ?}]
Implicit search yielded: SearchResult(scaladyno.playground.macroz.`package`.convert[scala.this.Nothing], )
                    typing scaladyno.playground.macroz.`package`.convert[scala.this.Nothing](Scratchpad.this.c): pt = ?: undetparams=, implicitsEnabled=true, enrichmentEnabled=true, mode=EXPRmode POLYmode QUALmode, silent=true, context.owner=value <local Scratchpad>

  * Problem:
  *   inferred conversion: scaladyno.playground.macroz.`package`.convert[Nothing]
  *   desired conversion: scaladyno.playground.macroz.`package`.convert[?{<method> def bar: ?}]
  */
  c.bar()
}

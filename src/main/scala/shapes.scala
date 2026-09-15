package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */

/** 
  Self Note:
  This is an object class.
  Shape is defined as an enum which basicall means that `Shape` can only be one of the following cases.
  It can also be compared.
*/
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  // TODO add missing cases (see test fixtures)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(halfWidth: Int, halfHeight: Int)
  // case Group(shapes: Shape*)z


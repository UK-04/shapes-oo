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

  // case Location
  case Location(x: Int, y: Int, shape: Shape)
  // case Ellipse
  case Ellipse(halfWidth: Int, halfHeight: Int)
  // case Group(shapes: Shape*)
  case Group(shapes: Shape*)


def size(s: Shape): Int = s match
  case Shape.Rectangle(width, height) =>
    width * height
  case Shape.Location(_, _, shape) =>
    size(shape)
  case Shape.Ellipse(halfWidth, halfHeight) =>
    4 * halfWidth * halfHeight
  case Shape.Group(shapes @ _*) =>
    shapes.map(size).sum

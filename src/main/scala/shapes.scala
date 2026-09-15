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


def height(s: Shape): Int = s match
  case Shape.Rectangle(_, height) =>
    height
  case Shape.Location(_, _, shape) =>
    height(shape)
  case Shape.Ellipse(_, halfHeight) =>
    2 * halfHeight
  case Shape.Group(shapes @ _*) =>
    if shapes.isEmpty then 0 else shapes.map(height).max


def scale(s: Shape, factor: Int): Shape = s match
  case Shape.Rectangle(width, height) =>
    Shape.Rectangle(width * factor, height * factor)
  case Shape.Location(x, y, shape) =>
    Shape.Location(x * factor, y * factor, scale(shape, factor))
  case Shape.Ellipse(halfWidth, halfHeight) =>
    Shape.Ellipse(halfWidth * factor, halfHeight * factor)
  case Shape.Group(shapes @ _*) =>
    Shape.Group(shapes.map(scale(_, factor)): _*)
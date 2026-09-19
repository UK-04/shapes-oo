package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) | Ellipse(hw, hh) | Group(Shape*) */

/**
  Self Note:
  This is an object class.
  Shape is defined as an enum which basically means that `Shape` can only be one of the following cases.
  It can also be compared.
*/
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  // case Location
  case Location(x: Int, y: Int, shape: Shape)
  // case Ellipse
  case Ellipse(halfWidth: Int, halfHeight: Int)
  // case Group(shapes: Shape*)
  case Group(shapes: Shape*)

  /** Constructor validation.
    * This statement is part of the enum's template body, so it runs every time
    * any case instance is constructed. Leaf dimensions must be nonnegative;
    * Location coordinates are unconstrained and an empty Group is allowed.
  */
  this match
    case Shape.Rectangle(w, h) =>
      require(w >= 0, s"Rectangle width must be nonnegative but was $w")
      require(h >= 0, s"Rectangle height must be nonnegative but was $h")
    case Shape.Ellipse(hw, hh) =>
      require(hw >= 0, s"Ellipse halfWidth must be nonnegative but was $hw")
      require(hh >= 0, s"Ellipse halfHeight must be nonnegative but was $hh")
    case _ => ()

end Shape


/** Number of leaf (basic) shapes in the tree. */
def size(s: Shape): Int = s match
  case Shape.Rectangle(_, _) =>
    1
  case Shape.Ellipse(_, _) =>
    1
  case Shape.Location(_, _, shape) =>
    size(shape)
  case Shape.Group(shapes @ _*) =>
    shapes.map(size).sum


/** Height of the tree, counting nodes: a leaf has height 1,
  * and Location and Group each add one level.
  */
def height(s: Shape): Int = s match
  case Shape.Rectangle(_, _) =>
    1
  case Shape.Ellipse(_, _) =>
    1
  case Shape.Location(_, _, shape) =>
    1 + height(shape)
  case Shape.Group(shapes @ _*) =>
    1 + (if shapes.isEmpty then 0 else shapes.map(height).max)


def scale(s: Shape, factor: Int): Shape = s match
  case Shape.Rectangle(width, height) =>
    Shape.Rectangle(width * factor, height * factor)
  case Shape.Location(x, y, shape) =>
    Shape.Location(x * factor, y * factor, scale(shape, factor))
  case Shape.Ellipse(halfWidth, halfHeight) =>
    Shape.Ellipse(halfWidth * factor, halfHeight * factor)
  case Shape.Group(shapes @ _*) =>
    Shape.Group(shapes.map(scale(_, factor))*)

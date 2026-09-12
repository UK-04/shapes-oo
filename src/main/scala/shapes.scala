package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */

/** SELF NOTE:
 *  This is basically just saying the `Shape` can only be one of the following cases
 *  and can be compared
 */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  // TODO add missing cases (see test fixtures)

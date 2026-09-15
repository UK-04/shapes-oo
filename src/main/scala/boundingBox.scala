package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import com.typesafe.scalalogging.Logger
import Shape.*

object boundingBox:
  private val logger = Logger("boundingBox")

  private def widthOf(s: Shape): Int = s match
    case Rectangle(w, _) => w
    case Ellipse(hx, _) => 2 * hx
    case Location(_, _, shape) => widthOf(shape)
    case Group(shapes @ _*) => if shapes.isEmpty then 0 else shapes.map(widthOf).max

  private def heightOf(s: Shape): Int = s match
    case Rectangle(_, h) => h
    case Ellipse(_, hy) => 2 * hy
    case Location(_, _, shape) => heightOf(shape)
    case Group(shapes @ _*) => if shapes.isEmpty then 0 else shapes.map(heightOf).max

  def apply(s: Shape): Location = s match
    // get the bounding box of the rectangle
    // then shift it to the origin (0, 0)
    case Rectangle(w,h) =>
      logger.debug(s"Computing bounding box for Rectangle($w, $h)")
      Location(0, 0, Rectangle(w, h))

    // first get the bounding box of the shape
    // then shift it by the location's x and y coordinates
    // COPILOT CHANGES: fixed the Location pattern syntax and kept the intended offset logic.
    case Location(x, y, shape) =>
      logger.debug(s"Computing bounding box for Location($x, $y, $shape)")
      // COPILOT CHANGES: corrected the unchecked pattern binding syntax here.
      val Location(u, v, Rectangle(w, h)) = (boundingBox(shape): @unchecked)
      Location(x + u, y + v, Rectangle(w, h))

    // ellipse case will require calculating the half width and half height to determine the bounding box
    // take the Location of the bounding box of the ellipse and give it the negative of half-width and half-height as the x and y coordinates
    // then give the rectangle with width and height as double the half-width and half-height of the ellipse to undo the half-width and half-height of the ellipse to get the bounding box of the ellipse.
    case Ellipse(hx, hy) =>
      logger.debug(s"Computing bounding box for Ellipse($hx, $hy)")
      Location(-hx, -hy, Rectangle(2 * hx, 2 * hy))

    case Group(shapes @ _*) =>
      logger.debug(s"Computing bounding box for Group with ${shapes.length} shapes")
      val boundingBoxes: List[Location] = shapes.map(boundingBox(_)).toList
      if boundingBoxes.isEmpty then
        Location(0, 0, Rectangle(0, 0))
      else
        val minX = boundingBoxes.map(_.x).min
        val minY = boundingBoxes.map(_.y).min
        val maxX = boundingBoxes.map(bb => bb.x + widthOf(bb.shape)).max
        val maxY = boundingBoxes.map(bb => bb.y + heightOf(bb.shape)).max
        val result: Location = Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
        logger.debug(s"Group bounding box result: $result")
        result

end boundingBox


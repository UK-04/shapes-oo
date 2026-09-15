package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    // get the bounding box of the rectangle
    // then shift it to the origin (0, 0)
    case Rectangle(w,h) =>
      Location(0, 0, Rectangle(w, h))

    // first get the bounding box of the shape
    // then shift it by the location's x and y coordinates
    // COPILOT CHANGES: fixed the Location pattern syntax and kept the intended offset logic.

    case Location(x, y, shape) =>
      // COPILOT CHANGES: corrected the unchecked pattern binding syntax here.
      val Location(u, v, Rectangle(w, h)) = (boundingBox(shape): @unchecked)
      Location(x + u, y + v, Rectangle(w, h))

    // ellipse case will require calculating the half width and half height to determine the bounding box 
    // take the Location of the bounding box of the ellipse and give it the negative of half-width and half-height as the x and y coordinates 
    // then give the rectangle with width and height as double the half-width and half-height of the ellipse to undo the half-width and half-height of the ellipse to get the bounding box of the ellipse.
    case Ellipse(hx, hy) =>
      Location(-hx, -hy, Rectangle(2 * hx, 2 * hy))


end boundingBox


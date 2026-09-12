package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w,h) =>
      Location(0, 0, Rectangle(w, h))

    case Location(x, y, shape) =>
      val Location(u, v, Rectangle(w, h)) = boundingBox(shape) : @unchecked
      Location(x + u, y + v, Rectangle(w, h))

end boundingBox


package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w,h) =>
      Location(0, 0, Rectangle(w, h))

end boundingBox

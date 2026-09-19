package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

/** scale multiplies leaf dimensions and Location coordinates, recursively. */
class TestScale:

  @Test
  def testScaleSimpleRectangle(): Unit =
    assertEquals(Rectangle(160, 240), scale(simpleRectangle, 2))

  @Test
  def testScaleSimpleEllipse(): Unit =
    assertEquals(Ellipse(100, 60), scale(simpleEllipse, 2))

  @Test
  def testScaleSimpleLocation(): Unit =
    assertEquals(
      Location(140, 60, Rectangle(160, 240)),
      scale(simpleLocation, 2)
    )

  @Test
  def testScaleBasicGroup(): Unit =
    assertEquals(
      Group(Ellipse(100, 60), Rectangle(40, 80)),
      scale(basicGroup, 2)
    )

  @Test
  def testScaleSimpleGroup(): Unit =
    assertEquals(
      Group(
        Location(400, 200, Ellipse(100, 60)),
        Location(800, 600, Rectangle(200, 100))
      ),
      scale(simpleGroup, 2)
    )

  @Test
  def testScaleComplexGroup(): Unit =
    assertEquals(
      Location(100, 200,
        Group(
          Ellipse(40, 80),
          Location(300, 100,
            Group(
              Rectangle(100, 60),
              Rectangle(600, 120),
              Location(200, 400,
                Ellipse(100, 60)
              )
            )),
          Rectangle(200, 400)
        )),
      scale(complexGroup, 2)
    )

  @Test
  def testScaleByOneIsIdentity(): Unit =
    assertEquals(complexGroup, scale(complexGroup, 1))

end TestScale

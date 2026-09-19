package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

class TestBoundingBox:

  def testBoundingBox(s: Shape, x: Int, y: Int, width: Int, height: Int): Unit =
    val Location(u, v, Rectangle(w, h)) = boundingBox(s) : @unchecked
    assertEquals(x, u)
    assertEquals(y, v)
    assertEquals(width, w)
    assertEquals(height, h)

  @Test
  def testSimpleRectangle(): Unit =
    testBoundingBox(simpleRectangle, 0, 0, 80, 120)

  @Test
  def testSimpleLocation(): Unit =
    testBoundingBox(simpleLocation, 70, 30, 80, 120)

  // TODO reenable these commented-out tests after adding the missing case classes
  // (following the pattern of the other tests above)

  @Test
  def testSimpleEllipse(): Unit =
    testBoundingBox(simpleEllipse, -50, -30, 100, 60)

  @Test
  def testBasicGroup(): Unit =
    testBoundingBox(basicGroup, -50, -30, 100, 70)

  @Test
  def testSimpleGroup(): Unit =
    testBoundingBox(simpleGroup, 150, 70, 350, 280)
   
  @Test
  def testComplexGroup(): Unit =
    testBoundingBox(complexGroup, 30, 60, 470, 320)


  // // tests for size function
  // @Test
  // def testSizeSimpleRectangle(): Unit =
  //   assertEquals(9600, size(simpleRectangle))
  
  // @Test
  // def testSizeSimpleEllipse(): Unit =
  //   assertEquals(6000, size(simpleEllipse))


  // // tests for height function
  // @Test
  // def testHeightSimpleRectangle(): Unit =
  //   assertEquals(120, height(simpleRectangle))

  // @Test
  // def testHeightSimpleEllipse(): Unit =
  //   assertEquals(60, height(simpleEllipse))

  // // tests for scale function
  // @Test
  // def testScaleSimpleRectangle(): Unit =
  //   assertEquals(Shape.Rectangle(160, 240), scale(simpleRectangle, 2))

  // @Test
  // def testScaleSimpleEllipse(): Unit =
  //   assertEquals(Shape.Ellipse(100, 60), scale(simpleEllipse, 2))

end TestBoundingBox

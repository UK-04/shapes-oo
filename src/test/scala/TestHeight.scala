package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

/** height is the height of the shape tree, counted in nodes:
  * a leaf has height 1, and Location and Group each add one level.
  */
class TestHeight:

  @Test
  def testHeightSimpleRectangle(): Unit =
    assertEquals(1, height(simpleRectangle))

  @Test
  def testHeightSimpleEllipse(): Unit =
    assertEquals(1, height(simpleEllipse))

  @Test
  def testHeightSimpleLocation(): Unit =
    assertEquals(2, height(simpleLocation))

  @Test
  def testHeightBasicGroup(): Unit =
    assertEquals(2, height(basicGroup))

  @Test
  def testHeightSimpleGroup(): Unit =
    assertEquals(3, height(simpleGroup))

  @Test
  def testHeightComplexGroup(): Unit =
    assertEquals(6, height(complexGroup))

  @Test
  def testHeightEmptyGroup(): Unit =
    assertEquals(1, height(Group()))

end TestHeight

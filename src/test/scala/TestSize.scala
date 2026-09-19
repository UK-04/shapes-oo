package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*
import Shape.*

/** size counts the leaf (basic) shapes in the tree. */
class TestSize:

  @Test
  def testSizeSimpleRectangle(): Unit =
    assertEquals(1, size(simpleRectangle))

  @Test
  def testSizeSimpleEllipse(): Unit =
    assertEquals(1, size(simpleEllipse))

  @Test
  def testSizeSimpleLocation(): Unit =
    assertEquals(1, size(simpleLocation))

  @Test
  def testSizeBasicGroup(): Unit =
    assertEquals(2, size(basicGroup))

  @Test
  def testSizeSimpleGroup(): Unit =
    assertEquals(2, size(simpleGroup))

  @Test
  def testSizeComplexGroup(): Unit =
    assertEquals(5, size(complexGroup))

  @Test
  def testSizeEmptyGroup(): Unit =
    assertEquals(0, size(Group()))

end TestSize

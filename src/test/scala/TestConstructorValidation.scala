package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows

import Shape.*

/** Leaf dimensions must be nonnegative; the constructor rejects anything else. */
class TestConstructorValidation:

  private def assertInvalid(block: => Shape): Unit =
    val _ = assertThrows(
      classOf[IllegalArgumentException],
      () => { val _ = block }
    )

  @Test
  def testNegativeRectangleWidth(): Unit =
    assertInvalid(Rectangle(-1, 120))

  @Test
  def testNegativeRectangleHeight(): Unit =
    assertInvalid(Rectangle(80, -120))

  @Test
  def testNegativeEllipseHalfWidth(): Unit =
    assertInvalid(Ellipse(-50, 30))

  @Test
  def testNegativeEllipseHalfHeight(): Unit =
    assertInvalid(Ellipse(50, -30))

  @Test
  def testNestedInvalidShapeIsRejected(): Unit =
    assertInvalid(Location(70, 30, Rectangle(-80, 120)))

  @Test
  def testInvalidGroupMemberIsRejected(): Unit =
    assertInvalid(Group(Rectangle(20, 40), Ellipse(50, -30)))

end TestConstructorValidation

/**
 * 
 */
package com.multicom.domus.dataset.sensors;

import fr.liglab.multicom.domus.dataset.sensors.Identifier;
import fr.liglab.multicom.domus.dataset.sensors.SensorsList;
import junit.framework.TestCase;

/**
 * @author gallissot
 *
 */
public class IdentifierTest extends TestCase {

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.sensors.Identifier} constructors.
   */
  public final void testConstructor() {
    Identifier foo = Identifier.fromFilename("fffe9da3a50a01-temperature.csv");
    Identifier foo1 = new Identifier(0xfffe9da3a50a01L, "temperature");
    assertEquals(foo, foo1);
    Identifier foo2 = new Identifier(0xfffe9da3a50aL, (byte) 0x01, "temperature");
    assertEquals(foo, foo2);
    assertEquals(foo2, foo1);
  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.sensors.Identifier#equals(java.lang.Object)}.
   */
  public final void testEqualsObject() {
    assertTrue(SensorsList.CAM1_ZONE1.equals(SensorsList.CAM1_ZONE1));
    assertFalse(SensorsList.CAM1_ZONE1.equals(SensorsList.CAM1_ZONE2));
  }
  
  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.sensors.Identifier#hashCode()}.
   */
  public final void testHashCode() {
    Identifier foo = Identifier.fromFilename("fffe9da3a50a01-temperature.csv");
    Identifier foo1 = new Identifier(0xfffe9da3a50a01L, "temperature");
    Identifier foo2 = new Identifier(0xfffe9da3a50aL, (byte) 0x01, "temperature");
    assertTrue(foo.hashCode() == foo1.hashCode());
    assertTrue(foo.hashCode() == foo2.hashCode());
  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.sensors.Identifier#fromFilename(java.lang.String)}.
   */
  public final void testFromFilename() {
    assertNull(Identifier.fromFilename("foo.jar"));
    Identifier foo = Identifier.fromFilename("fffe9da3a50a01-temperature.csv");
    assertNotNull(foo);
    Identifier bar = new Identifier(0xfffe9da3a50a01L, "temperature");
    assertTrue(bar.equals(foo));
    assertEquals(bar, foo);
  }

}

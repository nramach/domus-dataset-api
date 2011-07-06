/**
 * 
 */
package com.multicom.domus.dataset;

import java.io.File;
import java.util.Date;

import fr.liglab.multicom.domus.dataset.DataSet;
import fr.liglab.multicom.domus.dataset.sensors.Identifier;

import junit.framework.TestCase;

/**
 * @author gallissot
 * 
 */
public class DataSetTest extends TestCase {

  private static Identifier S1 = new Identifier(0xfffe1ec74cb801L, "status");
  private static Identifier S2 = new Identifier(0xfffe3ce1bcaa01L, "value");
  private static Identifier S3 = new Identifier(0xfffe3dbb8eb801L, "status");
  private static Identifier S4 = new Identifier(0xfffe3ec6c93901L, "value");
  private static Identifier S5 = new Identifier(0xfffe4caa5a4701L, "status");
  private static Identifier S6 = new Identifier(0xfffe5b8669eb01L, "value");
  private static Identifier S7 = new Identifier(0xfffe7aa3a7ce01L, "value");
  private static Identifier S8 = new Identifier(0xfffe7fada15e01L, "value");

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#DataSet(java.io.File)}.
   */
  public final void testDataSet() {
    try {
      new DataSet(new File("src/test/resources/0"));
      fail("Exception should have been raised");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    DataSet set = new DataSet(new File("src/test/resources/1"));
    assertNotNull(set);
    assertNotNull(set.getBeginning());
    assertNotNull(set.getEnd());
    assertNotNull(set.getEvents());
    assertNotNull(set.getSensors());
  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#getBeginning()}.
   */
  public final void testGetBeginning() {
    DataSet set = new DataSet(new File("src/test/resources/1"));
    assertEquals(new Date(10), set.getBeginning());
  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#getEnd()}.
   */
  public final void testGetEnd() {
    DataSet set = new DataSet(new File("src/test/resources/1"));
    assertEquals(new Date(1400000000000L), set.getEnd());
  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#getSensors()}.
   */
  public final void testGetSensors() {
    DataSet set = new DataSet(new File("src/test/resources/1"));
    assertEquals(8, set.getSensors().size());
    Identifier[] s = new Identifier[] { S1, S2, S3, S4, S5, S6, S7, S8 };
    for (int i = 0; i < s.length; i++) {
      assertTrue(set.getSensors().containsKey(s[i]));
      assertNotNull(set.getSensors().get(s[i]));
    }
  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#getEvents()}.
   */
  public final void testGetEvents() {

  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#getEvents(java.util.List)}.
   */
  public final void testGetEventsListOfIdentifier() {

  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#loadFromDir(java.io.File)}.
   */
  public final void testLoadFromDir() {

  }

  /**
   * Test method for {@link fr.liglab.multicom.domus.dataset.DataSet#listDataSets(java.io.File)}.
   */
  public final void testListDataSets() {

  }

}

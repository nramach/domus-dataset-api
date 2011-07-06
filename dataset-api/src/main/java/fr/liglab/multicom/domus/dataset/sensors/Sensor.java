/**
 * Copyright or © or Copr. Mathieu Gallissot
 * 
 * Mathieu.Gallissot@imag.fr
 * 
 * This software is a computer program whose purpose is to parse files which
 * are part of the Multicom Domus dataset.
 * 
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software.  You can  use, 
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info". 
 * 
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability. 
 * 
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or 
 * data to be ensured and,  more generally, to use and operate it in the 
 * same conditions as regards security. 
 * 
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 * 
 */
package fr.liglab.multicom.domus.dataset.sensors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.csvreader.CsvReader;

import fr.liglab.multicom.domus.dataset.Event;

/**
 * Top class for all sensors. Contains key methods to parse values and dates from files 
 * and common methods to all sensors.
 * @author <a href="mailto:Mathieu.Gallissot@imag.fr">Mathieu Gallissot</a>
 */
public abstract class Sensor {

  protected TreeMap<Date, Object> values = new TreeMap<Date, Object>();
  
  private Identifier id;
  
  public Sensor(Identifier id) {
    this.id = id;
  }
    
  /**
   * @return the {@link Identifier} of this sensor
   */
  public Identifier getId() {
    return this.id;
  }

  /**
   * @return the first date for which a value has been recorded for this sensor
   */
  public Date getFirstDate() {
    return (Date) this.values.firstKey();
  }
  
  /**
   * @return the last date for which a value has been recorded for this sensor
   */
  public Date getLastDate() {
    return (Date) this.values.lastKey();
  }
  
  /**
   * @param date
   * @return the first known value after the given date, or <code>null</code> if no records exists after the given date.
   */
  public Object getValueAfter(Date date) {
    return this.values.get(this.values.ceilingKey(date));
  }
  
  /**
   * @param date
   * @return the first known value before the given date, or <code>null</code> if no records exists before the given date.
   */
  public Object getValueBefore(Date date) {
    return this.values.get(this.values.floorKey(date));
  }
  
  protected abstract void addRecord(Date date, String value);
  
  public Map<Date, Event> getEvents() {
    TreeMap<Date, Event> ret = new TreeMap<Date, Event>();
    for(Iterator<Date> i = this.values.keySet().iterator(); i.hasNext(); ) {
      Date d = i.next();
      Event e = new Event(this.id, this.values.get(d), d);
      ret.put(d, e);
    }
    return ret;
  }
  
  public static final Sensor parse(File file) {
    Identifier id = Identifier.fromFilename(file.getName());

    Sensor s = SensorsList.getSensor(id);
    
    try {
      CsvReader reader = new CsvReader(new FileReader(file));
      reader.setDelimiter(';');
      while(reader.readRecord()) {
        s.addRecord(new Date(Long.parseLong(reader.get(0))), reader.get(1));
      }
      reader.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return s;
  }
  
  
}

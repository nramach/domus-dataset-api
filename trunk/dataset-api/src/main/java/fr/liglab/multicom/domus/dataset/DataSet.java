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
package fr.liglab.multicom.domus.dataset;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import fr.liglab.multicom.domus.dataset.sensors.Identifier;
import fr.liglab.multicom.domus.dataset.sensors.Sensor;

/**
  * 
 * 
 * @author <a href="mailto:Mathieu.Gallissot@imag.fr">Mathieu Gallissot</a>
 *
 */
public class DataSet {
  
  private HashMap<Identifier, Sensor> sensors = new HashMap<Identifier, Sensor>();
  
  public DataSet(File dataSetPath) throws IllegalArgumentException  {
    if(dataSetPath == null) {
      throw new IllegalArgumentException("dataset path is null");
    }
    if(dataSetPath.exists() && dataSetPath.isDirectory()) {
      File[] sensorsFiles = dataSetPath.listFiles();
      for(int i = 0; i < sensorsFiles.length; i++) {
        Sensor s = Sensor.parse(sensorsFiles[i]);
        this.sensors.put(s.getId(), s);
      }
    } else {
      throw new IllegalArgumentException("dataset path is not a directiry or doesn't exists");
    }
  }
  
  public Date getBeginning() {
    Date date = new Date();
    for(Iterator<Sensor> i = this.sensors.values().iterator(); i.hasNext(); ) {
      Sensor s = i.next();
      if(s.getFirstDate().before(date)) {
        date = s.getFirstDate();
      }
    }
    return date;
  }
  
  public Date getEnd() {
    Date date = new Date(0);
    for(Iterator<Sensor> i = this.sensors.values().iterator(); i.hasNext(); ) {
      Sensor s = i.next();
      if(s.getLastDate().after(date)) {
        date = s.getLastDate();
      }
    }
    return date;
  }
  
  public Map<Identifier, Sensor> getSensors() {
    return this.sensors;
  }
  
  public Map<Date, Event> getEvents() {
    Map<Date, Event> ret = new TreeMap<Date, Event>();
    for(Iterator<Sensor> i = this.sensors.values().iterator(); i.hasNext(); ) {
      Sensor s = i.next();
      ret.putAll(s.getEvents());
    }
    return ret;
  }
  
  /**
   * @param inputList
   * @return
   */
  public Map<Date, Event> getEvents(List<Identifier> inputList) {
    Map<Date, Event> ret = new TreeMap<Date, Event>();
    for(Iterator<Identifier> i = inputList.iterator(); i.hasNext(); ) {
      Identifier id = i.next();
      Sensor s = this.sensors.get(id);
      if(s != null) {
        ret.putAll(s.getEvents());
      } else {
        if(this.sensors.containsKey(id)) {
          System.out.println("sensor found but seems capricious");
        } else {
          System.out.println("sensor not found -> " + id.toString());
        }
      }
    }
    return ret;
  }

  public static DataSet loadFromDir(File dataSetPath) {
    return new DataSet(dataSetPath);    
  }
  
  public static DataSet[] listDataSets(File directory) {
    List<DataSet> ret = new LinkedList<DataSet>();
    File[] dirs = directory.listFiles();
    for(int i=0; i<dirs.length; i++) {
      if(dirs[i].isDirectory()) {
        try {
          ret.add(DataSet.loadFromDir(dirs[i]));
        } catch (Throwable t) {
          System.out.println("Couldn't load dataset from directory " + dirs[i].getName());
        }
      } else {
        // not a folder
      }
    }
    return ret.toArray(new DataSet[]{});
    
  }
}

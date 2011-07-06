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
package fr.liglab.multicom.domus.dataset.sensors.counting;

import java.util.Date;

import fr.liglab.multicom.domus.dataset.sensors.Identifier;
import fr.liglab.multicom.domus.dataset.sensors.Sensor;

/**
 * @author <a href="mailto:Mathieu.Gallissot@imag.fr">Mathieu Gallissot</a>
 *
 */
public class Counter extends Sensor {
  
  public static final int TYPE_UNKWOWN                        = 0;
  public static final int TYPE_ELECTRICITY                    = 1;
  public static final int TYPE_CO2                            = 2;
  public static final int TYPE_RELATIVE_HUMIDITY              = 3;
  public static final int TYPE_TEMPERATURE                    = 4;
  public static final int TYPE_WATER                          = 5;
  public static final int TYPE_ELECTRICITY_INSTANT_POWER      = 6;
  public static final int TYPE_ELECTRICITY_INSTANT_VOLTAGE    = 7;
  
  private static final String[] UNITS = new String[] {"unkwnown","kWh", "ppm", "%", "°C", "l", "kW", "V"};
  
  private int type = 0;
  
  public Counter(int type, Identifier id) {
    super(id);
    this.type = type;
  }

  public Number getCountingValue(Date date) {
    return ((Number)this.getValueBefore(date));
  }
  
  public String getUnit() {
    try {
    return UNITS[this.type];
    } catch (ArrayIndexOutOfBoundsException e) {
      return UNITS[0];
    }
  }

  /* (non-Javadoc)
   * @see com.multicom.domus.dataset.sensors.Sensor#addRecord(java.util.Date, java.lang.String)
   */
  protected void addRecord(Date date, String value) {
    //TODO : verify type ?
    this.values.put(date, new Float(value));
    
  }

}

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

import java.util.Arrays;

import fr.liglab.multicom.domus.dataset.sensors.blinds.Blind;
import fr.liglab.multicom.domus.dataset.sensors.blinds.Shutter;
import fr.liglab.multicom.domus.dataset.sensors.counting.Counter;
import fr.liglab.multicom.domus.dataset.sensors.detection.OpeningDetector;
import fr.liglab.multicom.domus.dataset.sensors.detection.PresenceDetector;
import fr.liglab.multicom.domus.dataset.sensors.lighting.BinaryPowerdDevice;
import fr.liglab.multicom.domus.dataset.sensors.lighting.DimmedLight;
import fr.liglab.multicom.domus.dataset.sensors.lighting.LuminositySensor;


/**
 * @author <a href="mailto:Mathieu.Gallissot@imag.fr">Mathieu Gallissot</a>
 * 
 */
public class SensorsList {

  // Lighting
  public static final Identifier L1 = new Identifier(0xFFFE2B37EAB9L, (byte) 01, "status");
  public static final Identifier L2 = new Identifier(0xFFFECBB299A8L, (byte) 01, "status");
  public static final Identifier L3 = new Identifier(0xFFFEB88797BCL, (byte) 01, "status");
  public static final Identifier PCV1 = new Identifier(0xFFFEB6A85DBBL, (byte) 01, "status");
  public static final Identifier PCV2 = new Identifier(0xFFFEFB6453C9L, (byte) 01, "status");

  public static final Identifier SP5SP6 = new Identifier(0xFFFEA4ACFDCCL, (byte) 01, "status");
  public static final Identifier SP7SP8 = new Identifier(0xFFFEF9EF7D48L, (byte) 01, "status");
  public static final Identifier SP1SP2 = new Identifier(0xFFFEDC6CAA6AL, (byte) 01, "status");
  public static final Identifier SP3SP4 = new Identifier(0xFFFE8CC9BAD0L, (byte) 01, "status");
  
  public static final Identifier[] LIGHTING = new Identifier[] {L1, L2, L3, PCV1, PCV2, SP1SP2, SP3SP4, SP5SP6, SP7SP8};

  // Shutters, blinds and curtains
  public static final Identifier ST1 = new Identifier(0xFFFEA8BCF469L, (byte) 01, "status");;
  public static final Identifier CU1 = new Identifier(0xFFFE3B6E8D53L, (byte) 01, "status");
  public static final Identifier ST2 = new Identifier(0xFFFEAEDCCB67L, (byte) 01, "status");
  public static final Identifier ST3 = new Identifier(0xFFFE8BB9CA7CL, (byte) 01, "status");

  public static final Identifier VR1 = new Identifier(0xFFFE63C3A7B2L, (byte) 01, "status");
  public static final Identifier VR2 = new Identifier(0xFFFE61DC66BAL, (byte) 01, "status");
  public static final Identifier VR3 = new Identifier(0xFFFEC7396CB7L, (byte) 01, "status");
  public static final Identifier VR4 = new Identifier(0xFFFEC659B23DL, (byte) 01, "status");
  public static final Identifier VR5 = new Identifier(0xFFFEABB51ACAL, (byte) 01, "status");
  public static final Identifier VR6 = new Identifier(0xFFFED50B88C7L, (byte) 01, "status");
  
  public static final Identifier[] SHUTTERS = new Identifier[] {CU1, VR1, VR2, VR3, VR4, VR5, VR6};
  public static final Identifier[] BLINDS = new Identifier[] {ST1, ST2, ST3};

  // leds
  private static final String RES_RGB = "";
  
  public static final Identifier RGB_01 = new Identifier(0xFFFE9BCA9F35L, RES_RGB);
  public static final Identifier RGB_02 = new Identifier(0xFFFEC74B3569L, RES_RGB );
  public static final Identifier RGB_03 = new Identifier(0xFFFEACD9A33AL, RES_RGB);
  public static final Identifier RGB_04 = new Identifier(0xFFFE89BC9AC6L, RES_RGB);
  public static final Identifier RGB_05 = new Identifier(0xFFFEAB7B7789L, RES_RGB);
  public static final Identifier RGB_06 = new Identifier(0xFFFE6B19CAC9L, RES_RGB);
  public static final Identifier RGB_07 = new Identifier(0xFFFEAEBA8E63L, RES_RGB);
  public static final Identifier RGB_08 = new Identifier(0xFFFE3A67D3AEL, RES_RGB);
  public static final Identifier RGB_09 = new Identifier(0xFFFE99ADB766L, RES_RGB);
  public static final Identifier RGB_10 = new Identifier(0xFFFE1BDBACA9L, RES_RGB);
  public static final Identifier RGB_11 = new Identifier(0xFFFE99B7AAA5L, RES_RGB);
  public static final Identifier RGB_12 = new Identifier(0xFFFE3E9AA48CL, RES_RGB);
  public static final Identifier RGB_13 = new Identifier(0xFFFE71ABCAA8L, RES_RGB);
  public static final Identifier RGB_14 = new Identifier(0xFFFEB6A3F733L, RES_RGB);
  public static final Identifier RGB_15 = new Identifier(0xFFFE81A935AEL, RES_RGB);
  public static final Identifier RGB_16 = new Identifier(0xFFFE36AAEB3BL, RES_RGB);
  public static final Identifier RGB_17 = new Identifier(0xFFFE8ABBAF66L, RES_RGB);
  public static final Identifier RGB_18 = new Identifier(0xFFFE4A5973B6L, RES_RGB);
  public static final Identifier RGB_19 = new Identifier(0xFFFE630D5969L, RES_RGB);
  public static final Identifier RGB_20 = new Identifier(0xFFFECA72567DL, RES_RGB);
  public static final Identifier RGB_21 = new Identifier(0xFFFE88CD5944L, RES_RGB);
  public static final Identifier RGB_22 = new Identifier(0xFFFEBB5D967FL, RES_RGB);
  public static final Identifier RGB_23 = new Identifier(0xFFFEEED7339CL, RES_RGB);
  public static final Identifier RGB_24 = new Identifier(0xFFFEADCAC66BL, RES_RGB);
  public static final Identifier RGB_25 = new Identifier(0xFFFEDA4B7B9DL, RES_RGB);
  public static final Identifier RGB_26 = new Identifier(0xFFFEACDCBABAL, RES_RGB);
  
  public static final Identifier[] RGB_LIGHTING = new Identifier[] {RGB_01, RGB_02, RGB_03, RGB_04, RGB_05, RGB_06,
                                                                    RGB_07, RGB_08, RGB_09, RGB_10, RGB_11, RGB_12,
                                                                    RGB_13, RGB_14, RGB_15, RGB_16, RGB_17, RGB_18,
                                                                    RGB_19, RGB_20, RGB_21, RGB_22, RGB_23, RGB_24,
                                                                    RGB_25, RGB_26};

  public static final Identifier MOVMENT_DESKTOP = new Identifier(0xFFFE9992F78DL, (byte) 0x01, "status");
  public static final Identifier MOVMENT_KITCHEN = new Identifier(0xFFFECC84D66BL, (byte) 0x01, "status");

  // Bureau
  public static final Identifier CAM1_ZONE1 = new Identifier(0xFFFE4687B776L, (byte) 0x01, "status");
  public static final Identifier CAM1_ZONE2 = new Identifier(0xFFFEB398AE96L, (byte) 0x01, "status");
  public static final Identifier CAM1_ZONE3 = new Identifier(0xFFFECB72B685L, (byte) 0x01, "status");

  public static final Identifier CAM2_ZONE1 = new Identifier(0xFFFE9BB67F96L, (byte) 0x01, "status");
  public static final Identifier CAM2_ZONE2 = new Identifier(0xFFFED3DDC9E7L, (byte) 0x01, "status");
  public static final Identifier CAM2_ZONE3 = new Identifier(0xFFFEB9B1CE83L, (byte) 0x01, "status");

  // Chambre
  public static final Identifier CAM3_ZONE1 = new Identifier(0xFFFE29CAA5B1L, (byte) 0x01, "status");
  public static final Identifier CAM3_ZONE2 = new Identifier(0xFFFEA8BCDA9CL, (byte) 0x01, "status");
  public static final Identifier CAM3_ZONE3 = new Identifier(0xFFFED3B59E29L, (byte) 0x01, "status");

  public static final Identifier CAM4_ZONE1 = new Identifier(0xFFFEAF836BDAL, (byte) 0x01, "status");
  public static final Identifier CAM4_ZONE2 = new Identifier(0xFFFEDABB4B3BL, (byte) 0x01, "status");
  public static final Identifier CAM4_ZONE3 = new Identifier(0xFFFE77A13D5AL, (byte) 0x01, "status");
  public static final Identifier CAM4_ZONE4 = new Identifier(0xFFFEB7F8A5AAL, (byte) 0x01, "status");

  // Cuisine
  public static final Identifier CAM5_ZONE1 = new Identifier(0xFFFEBD28B98BL, (byte) 0x01, "status");
  public static final Identifier CAM5_ZONE2 = new Identifier(0xFFFEDCA8BAAAL, (byte) 0x01, "status");

  public static final Identifier CAM6_ZONE1 = new Identifier(0xFFFEA557AA8BL, (byte) 0x01, "status");
  public static final Identifier CAM6_ZONE2 = new Identifier(0xFFFEECA8B7D9L, (byte) 0x01, "status");
  public static final Identifier CAM6_ZONE3 = new Identifier(0xFFFE29AADC8CL, (byte) 0x01, "status");
  
  public static final Identifier[] PRESENCE_DETECTION = new Identifier[] {CAM1_ZONE1, CAM1_ZONE2, CAM1_ZONE3,
                                                                          CAM2_ZONE1, CAM2_ZONE2, CAM2_ZONE3,
                                                                          CAM3_ZONE1, CAM3_ZONE2, CAM3_ZONE3,
                                                                          CAM4_ZONE1, CAM4_ZONE2, CAM4_ZONE3, CAM4_ZONE4,
                                                                          CAM5_ZONE1, CAM5_ZONE2,
                                                                          CAM6_ZONE1, CAM6_ZONE2, CAM6_ZONE3,
                                                                          MOVMENT_DESKTOP, MOVMENT_KITCHEN};

  // Opening detectors
  public static final Identifier OP09 = new Identifier(0xFFFE7AAB3AA5L, (byte) 0x01, "status");
  public static final Identifier OP10 = new Identifier(0xFFFE8658CAAAL, (byte) 0x01, "status");
  public static final Identifier OP03 = new Identifier(0xFFFECAAA7D8FL, (byte) 0x01, "status");
  public static final Identifier OP07 = new Identifier(0xFFFEB595A7B1L, (byte) 0x01, "status");
  public static final Identifier OP08 = new Identifier(0xFFFECABA26B6L, (byte) 0x01, "status");
  public static final Identifier OP02 = new Identifier(0xFFFE8D5B3199L, (byte) 0x01, "status");
  public static final Identifier OP04 = new Identifier(0xFFFE79B6B39CL, (byte) 0x01, "status");
  public static final Identifier OP11 = new Identifier(0xFFFE17BAB4BAL, (byte) 0x01, "status");
  public static final Identifier OP12 = new Identifier(0xFFFEAA5ACE9DL, (byte) 0x01, "status");
  public static final Identifier OP13 = new Identifier(0xFFFEB8A8DA6AL, (byte) 0x01, "status");
  public static final Identifier OP06 = new Identifier(0xFFFE9C5EBCD8L, (byte) 0x01, "status");
  public static final Identifier OP15 = new Identifier(0xFFFE919B82B3L, (byte) 0x01, "status");
  public static final Identifier OP14 = new Identifier(0xFFFE9B5B62C8L, (byte) 0x01, "status");
  public static final Identifier OP01 = new Identifier(0xFFFE793BF9A3L, (byte) 0x01, "status");
  public static final Identifier OP05 = new Identifier(0xFFFE1EC74CB8L, (byte) 0x01, "status");
  
  public static final Identifier[] OPENING_DETECTION = new Identifier[] {OP01, OP02, OP03, OP04, OP05, OP06, OP07,
                                                                         OP08, OP09, OP10, OP11, OP12, OP13, OP14,
                                                                         OP15};

  private static final String RES_ANN = "value";
  

  public static final Identifier COUNTER_ELEC = new Identifier(0xFFFED998E65AL, (byte) 01, RES_ANN);
  public static final Identifier COUNTER_ELEC_INSTANT_POWER = new Identifier(0xFFFE755B9A41L, (byte) 01, RES_ANN);
  public static final Identifier COUNTER_ELEC_INSTANT_VOLTAGE = new Identifier(0xFFFE7AA3A7CEL, (byte) 01, RES_ANN);
  
  public static final Identifier COUNTER_COLD_WATER = new Identifier(0xFFFE3E7AA49BL, (byte) 01, RES_ANN);
  public static final Identifier COUNTER_HOT_WATER = new Identifier(0xFFFE395A4D9CL, (byte) 01, RES_ANN);
  
  public static final Identifier[] COUNTERS_ELEC = new Identifier[] {COUNTER_ELEC, COUNTER_ELEC_INSTANT_POWER, COUNTER_ELEC_INSTANT_VOLTAGE};
  public static final Identifier[] COUNTERS_WATER = new Identifier[] {COUNTER_COLD_WATER, COUNTER_HOT_WATER};
  public static final Identifier[] COUNTERS = new Identifier[] {COUNTER_ELEC, COUNTER_ELEC_INSTANT_POWER, COUNTER_ELEC_INSTANT_VOLTAGE,COUNTER_COLD_WATER,COUNTER_HOT_WATER};

  public static final Identifier TEMP_CHAMBRE = new Identifier(0xFFFEB8A8CCBBL, (byte) 01, RES_ANN); // temp chambre
  public static final Identifier HUMIDITE = new Identifier(0xFFFE3CE1BCAAL, (byte) 01, RES_ANN); // hmid
  public static final Identifier LUMINO_BUREAU = new Identifier(0xFFFE659CDFB3L, (byte) 01, RES_ANN); // lumino bureau
  public static final Identifier LUMINO_CUISINE = new Identifier(0xFFFE48CA9395L, (byte) 01, RES_ANN); // lumino cuisine
  public static final Identifier TEMP_BUREAU = new Identifier(0xFFFE9DA3A50AL, (byte) 01, "temperature"); // temp piaule
  public static final Identifier CO2 = new Identifier(0xFFFE97678AADL, (byte) 01, RES_ANN);
  
  public static final Identifier[] AIR = new Identifier[] {TEMP_CHAMBRE, HUMIDITE, LUMINO_BUREAU, LUMINO_CUISINE, TEMP_BUREAU, CO2};

  public static final Identifier EXT_TEMP = new Identifier(0xFFFEA94554AAL, (byte) 01, RES_ANN); // temp
  public static final Identifier EXT_PRESSURE = new Identifier(0xFFFEAA37796BL, (byte) 01, RES_ANN); // pressure
  public static final Identifier EXT_HMID = new Identifier(0xFFFE3EC6C939L, (byte) 01, RES_ANN); // hmid
  public static final Identifier EXT_ICON = new Identifier(0xFFFE967CAB98L, (byte) 01, RES_ANN); // icon
  public static final Identifier EXT_UV = new Identifier(0xFFFE8B34ABACL, (byte) 01, RES_ANN); // uv
  public static final Identifier EXT_WIND = new Identifier(0xFFFE9A4A5BABL, (byte) 01, RES_ANN); // wind
  public static final Identifier EXT_WINDDIR = new Identifier(0xFFFEC7BCDDE9L, (byte) 01, RES_ANN); // winddir
  
  public static final Identifier[] WEATHER_DATA = new Identifier[] {EXT_HMID, EXT_ICON, EXT_PRESSURE, EXT_TEMP, EXT_UV, EXT_WIND, EXT_WINDDIR};

  public static final Identifier PC_3_VALUE = new Identifier(0xFFFE67DAA0C3L, (byte) 01, "status");
  public static final Identifier PC_4_VALUE = new Identifier(0xFFFEAA3DE849L, (byte) 01, "status");
  public static final Identifier PC_5_VALUE = new Identifier(0xFFFE8EA1E6DDL, (byte) 01, "status");
  public static final Identifier PC_6_VALUE = new Identifier(0xFFFED3E7ECEBL, (byte) 01, "status");
  public static final Identifier PC_7_VALUE = new Identifier(0xFFFEDA97BB69L, (byte) 01, "status");
  public static final Identifier PC_8_VALUE = new Identifier(0xFFFEB853BA76L, (byte) 01, "status");
  public static final Identifier PC_9_VALUE = new Identifier(0xFFFEAB498E8AL, (byte) 01, "status");
  public static final Identifier PC_10_VALUE = new Identifier(0xFFFEAA6A458EL, (byte) 01, "status");
  public static final Identifier PC_11_VALUE = new Identifier(0xFFFEBB9B539BL, (byte) 01, "status");
  public static final Identifier PC_12_VALUE = new Identifier(0xFFFE98D7DAA8L, (byte) 01, "status");
  
  public static final Identifier[] PLUGS = new Identifier[] {PC_3_VALUE, PC_4_VALUE, PC_5_VALUE, PC_6_VALUE, PC_7_VALUE,
                                                             PC_8_VALUE, PC_9_VALUE, PC_10_VALUE, PC_11_VALUE, PC_12_VALUE};
  
  public static final Identifier DOOR_LOCK = new Identifier(0xFFFECDEBA79FL, (byte) 01, "status");
  public static final Identifier VENTILATION = new Identifier(0xFFFE45277DABL, (byte) 01, "status");
  public static final Identifier EXTERNAL_LIGHTING = new Identifier(0xFFFE29CCBAB7L, (byte) 01, "status");

  /**
   * 
   * @param id
   * @return a  {@link Sensor} instance associated to the type of the given identifier
   * @see Identifier
   */
  public static Sensor getSensor(Identifier id) {
    if(Arrays.asList(LIGHTING).contains(id)) {
      return new DimmedLight(id);
    } else if (Arrays.asList(SHUTTERS).contains(id)) {
      return new Shutter(id);
    } else if (Arrays.asList(PLUGS).contains(id)) {
      return new BinaryPowerdDevice(id);
    } else if (Arrays.asList(PRESENCE_DETECTION).contains(id)) {
      return new PresenceDetector(id);
    } else if (Arrays.asList(OPENING_DETECTION).contains(id)) {
      return new OpeningDetector(id);
    } else if (Arrays.asList(BLINDS).contains(id)) {
      return new Blind(id);
    } else if(id.equals(COUNTER_COLD_WATER) || id.equals(COUNTER_HOT_WATER)) {
      return new Counter(Counter.TYPE_WATER, id);
    } else if (id.equals(COUNTER_ELEC)) {
      return new Counter(Counter.TYPE_ELECTRICITY,id);
    } else if (id.equals(COUNTER_ELEC_INSTANT_POWER)) {
      return new Counter(Counter.TYPE_ELECTRICITY_INSTANT_POWER, id);
    } else if (id.equals(COUNTER_ELEC_INSTANT_VOLTAGE)) {
      return new Counter(Counter.TYPE_ELECTRICITY_INSTANT_VOLTAGE, id);
    } else if (id.equals(CO2)) {
      return new Counter(Counter.TYPE_CO2, id);
    } else if (id.equals(TEMP_BUREAU) || id.equals(TEMP_CHAMBRE) || id.equals(EXT_TEMP)) {
      return new Counter(Counter.TYPE_TEMPERATURE, id);
    } else if (id.equals(HUMIDITE) || id.equals(EXT_HMID)) {
      return new Counter(Counter.TYPE_RELATIVE_HUMIDITY, id);
    } else if (id.equals(LUMINO_BUREAU) || id.equals(LUMINO_CUISINE)) {
      return new LuminositySensor(id);
    }
    
    return new UnknownSensor(id);
  }
}

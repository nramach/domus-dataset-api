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

/**
 * @author <a href="mailto:Mathieu.Gallissot@imag.fr">Mathieu Gallissot</a>
 * 
 */
public class Identifier {

  private long id;
  private String resource;

  public Identifier(long l, byte b, String string) {
    this.id = (l << 8) + b;
    this.resource = string;
  }

  public Identifier(long l, String string) {
    this.id = l;
    this.resource = string;
  }

  public boolean equals(Object obj) {
    if (obj instanceof Identifier) {
      return this.toString().equals(obj.toString());
    }
    return super.equals(obj);
  }
  
  @Override
  public String toString() {
    return Long.toHexString(this.id) + "/" + this.resource;
  }
  
  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }

  public static Identifier fromFilename(String name) {
    try {
      return new Identifier(Long.parseLong(name.split("\\-")[0], 16), name.split("\\-")[1].split("\\.")[0]);
    } catch (Throwable t) {
      return null;
    }
  }
 

}

//package com.example.funciona.io.response;
//
//public class Geonames {
//
//
// public String adminCode1 = "";
// public String lng = "";
// public String distance = "";
// public int geonameId = 0;
// public String toponymName = "";
// public String countryId = "";
// public String fcl = "";
// public int population = 0;
// public String countryCode = "";
// public String name = "";
// public String fclName = "";
// public Object adminCodes1 = new Object();
// public String countryName = "";
// public String fcodeName = "";
//public String adminName1 = "";
//public String lat = "";
//public String fcode = "";
//
//public String getAdminCode1(){
//  return adminCode1;
// }
//
// public String getLng(){ return lng; }
// public String getDistance(){ return distance; }
//
//public int getGeonameId(){ return geonameId;}
// public String getToponymName(){
//  return toponymName;
// }
// public String getCountryId(){ return countryId;}
// public String getFcl(){
//  return fcl;
// }
//
// public int getPopulation(){ return population;}
// public String getCountryCode(){return countryCode;}
// public String getName(){
//  return name;
// }
// public String getFclName(){
//  return fclName;
// }
// public Object getAdminCodes1(){
//  return adminCodes1;
// }
// public String getCountryName(){
//   return countryName;
// }
// public String getFcodeName(){return fcodeName;}
//
// public String getAdminName1(){
//  return adminName1;
// }
// public String getLat(){ return lat; }
// public  String getFcode(){return fcode;}
//
//
//
//
//
//
//
//
//
//
//}
package com.example.funciona.io.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geonames {

 @SerializedName("geonames")
 @Expose
  private List<Geoname> geonames = null;

 public List<Geoname> getGeonames() {
  return geonames;
 }

 public void setGeonames(List<Geoname> geonames) {
  this.geonames = geonames;
 }

}
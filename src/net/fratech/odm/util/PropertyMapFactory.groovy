package net.fratech.odm.util

import net.fratech.odm.PropertyMap
import net.fratech.odm.PropertyMapImpl

class PropertyMapFactory {

  String IDENTITY = "id";
  String VERSION = "version";
  String TRANSIENT = "transients";
  String CONSTRAINTS = "constraints";
  String EVANESCENT = "evanescent";
  String RELATES_TO_MANY = "relatesToMany";
  String META_CLASS = "metaClass";
  String CLASS = "class";
  String MAPPING_STRATEGY = "mapWith";
  String MAPPED_BY = "mappedBy";
  String BELONGS_TO = "belongsTo";
  String HAS_MANY = "hasMany";
  String FETCH_MODE = "fetchMode";
  String DATE_CREATED = "dateCreated";
  String MAPPING = "mapping";
  String LAST_UPDATED = "lastUpdated";
  
  static List<PropertyMap> findPersistentProperties(Object obj){
    []
  }
}
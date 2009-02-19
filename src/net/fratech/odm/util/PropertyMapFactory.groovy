package net.fratech.odm.util

import net.fratech.odm.PropertyMap
import net.fratech.odm.DataMap
import net.fratech.odm.PropertyMapImpl
import net.fratech.odm.exceptions.MappingException
import java.lang.reflect.Field

class PropertyMapFactory {

//   static final String IDENTITY = "id";
//   static final String VERSION = "version";
//   static final String TRANSIENT = "transients";
//   static final String CONSTRAINTS = "constraints";
//   static final String EVANESCENT = "evanescent";
//   static final String RELATES_TO_MANY = "relatesToMany";
  static final String META_CLASS = "metaClass";
  static final String CLASS = "class";
//   static final String MAPPING_STRATEGY = "mapWith";
//   static final String MAPPED_BY = "mappedBy";
//   static final String BELONGS_TO = "belongsTo";
//   static final String HAS_MANY = "hasMany";
//   static final String FETCH_MODE = "fetchMode";
//   static final String DATE_CREATED = "dateCreated";
//   static final String MAPPING = "mapping";
//   static final String LAST_UPDATED = "lastUpdated";
  
  static List<PropertyMap> findPersistentProperties(Object obj, DataMap dm) {
    def propertyMaps = []
    def props = obj?.properties

    props.each { prop ->
      if(isPersistentProperty(prop)) {
        Field field = obj.class.getDeclaredField(prop.key)
        def pm = new PropertyMapImpl(field.name.toLowerCase(),
          field.name,
          field.type,
          dm)
        propertyMaps << pm
      }
    }

    if(!propertyMaps)
      throw new MappingException(dm.tableName, dm.domainClass, "Property list is empty. Can't create a mapping.")

    return propertyMaps
  }

  static Boolean isPersistentProperty(prop){
    switch(prop.key){
      case META_CLASS: return false;
      case CLASS: return false;
    }
    return true
  }
}
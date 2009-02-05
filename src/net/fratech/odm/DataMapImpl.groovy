package net.fratech.odm

import net.fratech.odm.util.PropertyMapFactory
import net.fratech.odm.exceptions.MappingException

class DataMapImpl implements DataMap {

  String tableName
  Class domainClass
  List<PropertyMap> propertyMapList

  void loadDataMap(Object obj) {
    loadDataMap(obj, PropertyMapFactory.findPersistentProperties(obj))
  }

  void loadDataMap(Object obj, List<PropertyMap> propertyMapList){
    if(!obj)
      throw new MappingException(null, null, "Can't create a mapping from a null Object.")
      
    if(!propertyMapList)
      throw new MappingException(tableName, domainClass, "Property list is empty. Can't create a mapping.")

    this.tableName = obj.class.simpleName.toLowerCase()
    this.domainClass = obj.class
    this.propertyMapList = propertyMapList.findAll { it instanceof PropertyMap }
  }

}
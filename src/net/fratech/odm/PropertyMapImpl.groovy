package net.fratech.odm

class PropertyMapImpl implements PropertyMap {

  String columnName
  String propertyName
  Class type
  DataMap dataMap

  public PropertyMapImpl(String columnName, String propertyName, Class type, DataMap dm){
      this.columnName = columnName
      this.propertyName = propertyName
      this.type = type
      this.dataMap = dm
  }

  public boolean equals(Object other){
    if(!other){
      return false
    }
    if(other.columnName == this.columnName &&
      other.propertyName == this.propertyName &&
      other.type == this.type &&
      other.dataMap == this.dataMap)
      return true
  }

}
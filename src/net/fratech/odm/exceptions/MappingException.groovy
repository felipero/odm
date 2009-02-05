package net.fratech.odm.exceptions

class MappingException extends ODMException {

  String tableName
  Class domainClass

  MappingException(String tableName, Class domainClass, String explanation){
    super("An exception ocurred in a dinamic mapping for class '${domainClass?.name}' and table '${tableName}' ".toString(), explanation)
    this.tableName = tableName
    this.domainClass = domainClass
  }
  
}
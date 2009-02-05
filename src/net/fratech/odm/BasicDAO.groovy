package net.fratech.odm

import groovy.sql.Sql

class BasicDAO {
  
  def sql = Sql.newInstance("jdbc:mysql://localhost:3306/easyd_dev", "easyd", "easyd", "com.mysql.jdbc.Driver")
  
  def insert(obj) {
    if(obj){
      def columns = columns(obj)
      def values = values(obj, columns)
      def table = sql.dataSet(obj.class.simpleName)
      table.add(values)
  
      println columns
      println values
    }
  }
  
  def values(obj, columns){
    def values = []
    columns.each{ column ->
      def value
      if(!column.name.endsWith("_id")){
        value = obj[column.name]
        values << [ (column.name) : value]
      }
    }
    return values
  }
  
  def columns(obj) {
    String tableName = obj.class.simpleName
    def rs =  sql.connection.metaData.getColumns("easyd_dev", null, "generic", null)
    def columns = []
    while(rs.next()) {
/*      println rs.getObject("TABLE_CAT")
      println rs.getObject("TABLE_SCHEM")
      println rs.getObject("TABLE_NAME") 
      println rs.getObject("COLUMN_NAME")*/
      println rs.getObject("DATA_TYPE")
      println rs.getObject("TYPE_NAME") /*
      println rs.getObject("COLUMN_SIZE") */
      columns << ["name" :(rs.getString("COLUMN_NAME")), "type" : (rs.getString("TYPE_NAME").replaceAll("unsigned", ""))]
    }
    return columns
  }
  
}
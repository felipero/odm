import net.fratech.easyd.*
import groovy.sql.Sql

def sql = Sql.newInstance("jdbc:mysql://localhost:3306/easyd_dev", "easyd", "easyd", "com.mysql.jdbc.Driver")

def rs = sql.connection.metaData.getTypeInfo()

 while(rs.next()) {
/*      println rs.getObject("TABLE_CAT")
      println rs.getObject("TABLE_SCHEM")
      println rs.getObject("TABLE_NAME")
      println rs.getObject("COLUMN_NAME")*/
      println rs.getObject("DATA_TYPE")
      println rs.getObject("TYPE_NAME")
}
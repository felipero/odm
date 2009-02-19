class Foo {
  String bar
  int foo

  boolean equals(other){
    println "equals"
    if(!other)
      return false
    return true
  }
}

def obj = new Foo()

def fields = obj?.class?.getDeclaredFields()

fields.each { field ->
//  println field.name
//  println field.type
}

def props = obj?.properties

props.each {
  //println it.key
}

//println obj.class.getDeclaredField("foo").type
//println obj.class.getDeclaredField("bar").type.name

 println null == new Foo()
 println new Foo() == null
 println null == null
 println new Foo() == new Foo()


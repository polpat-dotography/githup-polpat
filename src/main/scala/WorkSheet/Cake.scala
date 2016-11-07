import User._
case class User(name:String)
object User {
  implicit def strToUser(inpStr:String) = User(inpStr)
}

trait UserDbComponent {
  def userDb : UserDb

  trait UserDb {
    def findAll: List[User]
  }
}

trait UUIDServiceComponent {
  def uuidService: UUIDService

  trait UUIDService {
    def getUUID:String
  }
}

trait ProductionUUIDServiceComponent extends UUIDServiceComponent {
  def uuidService = new ProductionUUIDService()

  class ProductionUUIDService extends UUIDService {
    def getUUID:String = "productionUUID"
  }
}

trait MockedUUIDServiceComponent extends UUIDServiceComponent {
  def uuidService = new MockedUUIDService()

  class MockedUUIDService extends UUIDService {
    def getUUID = "mockedUUID"
  }
}

case class SessionFactory(name:String)

trait ORMUserDb extends UserDbComponent {
  val sf = SessionFactory("ichitan")
  def userDb = new ORMUserDb(sf) //we need to actually instantiate the session factory here

  class ORMUserDb(val sf: SessionFactory) extends UserDb {
    def findAll: List[User] = List("YOK", "TUA", "PAE")
  }
}

trait MockedUserDb extends UserDbComponent {
  val sf = SessionFactory("oishi")
  def userDb = new MysqlUserDb()

  class MysqlUserDb() extends UserDb {
    def findAll: List[User] = List("yok", "tua", "pae")
  }
}

trait PersonServiceComponent {
  def userService: PersonService

  trait PersonService {
    def findAll: List[User]
  }
}

trait DefaultUserServiceComponent extends PersonServiceComponent {
  this: UserDbComponent =>

  def userService = new DefaultUserService

  class DefaultUserService extends PersonService {
    def findAll = userDb.findAll
  }
}

trait MockedUserServiceComponent extends PersonServiceComponent with UserDbComponent{

  def userService = new MockedUserService

  class MockedUserService extends PersonService {
    def findAll = userDb.findAll.map( (u) => User(u.name + "!!!") )
  }
}

object Application extends App {
  val userServiceComponent = new DefaultUserServiceComponent with ORMUserDb with MockedUUIDServiceComponent {
    def doSomething() = {
      println( "do something" )
      println( this.userService.findAll )
      println( this.uuidService.getUUID )
      println( this.userDb.findAll )
    }
  }
  userServiceComponent.doSomething()
  println( "Done" )
}
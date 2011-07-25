package code.model

import net.liftweb._
import mongodb._
import util.Props
import com.mongodb.{Mongo, ServerAddress}

object MongoConfig {
  def init: Unit = {
    val srvr = new ServerAddress("127.0.0.1", 27017)

    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "foo")
  }
}

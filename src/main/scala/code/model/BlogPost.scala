package code.model

import com.foursquare.rogue.Rogue._

import com.mongodb.{BasicDBObjectBuilder, DBObject}
import java.util.regex.Pattern
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field._
import net.liftweb.record._
import org.bson.types._

class BlogPost extends MongoRecord[BlogPost] with MongoId[BlogPost] {
  def meta = BlogPost
  object title extends StringField(this, 255)
  object body extends StringField(this, 5000)
}

object BlogPost extends BlogPost with MongoMetaRecord[BlogPost]


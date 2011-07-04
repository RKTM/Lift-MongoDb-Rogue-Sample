package code
package snippet

import scala.xml.{ NodeSeq, Text }
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._

import net.liftweb.http.S
import code.model._

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> date.map(_.toString)

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */

  def create = {
    val blogPost = BlogPost.createRecord

    blogPost.title("aaa")
    blogPost.body("this is body.\nthis is body")

    blogPost.save

    "*" #> "saved."
  }

  def list = {
    val blogPosts = BlogPost.findAll // where (_.title = "aaa") fetch
    "*" #> <table>
	    {blogPosts.flatMap(p => <tr><td>{p.title}</td><td>{p.body.toString().slice(0,200)}</td></tr>)}
	     </table>
  }
}

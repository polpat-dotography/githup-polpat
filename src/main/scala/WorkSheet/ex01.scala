package WorkSheet

import net.liftweb.json.JsonAST.{JField, JValue}
import net.liftweb.json._

/**
  * Created by polpat on 31/10/2559.
  */
class ex01 {
  //printlnB("valu : " + valu)
  //    countryJson.\("name")
  //    for(i <- countryJson.children.indices) {
  //      if(countryJson(i).\\("iso3").extract[String] == code) {
  //        result = ("iso3" -> code) ~
  //          ("name" -> countryJson(i).\\("name").extract[String]) ~
  //          ("phone_code" -> countryJson(i).\\("phone_code").extract[String])
  //      }
  //    }
  //    printlnM("RESULT : " + result)



  //x.transform{case JField(x, v) if x == "country" => JField("country", getCountryValue(v.extract[String]))}



  //val filterStringEnumWithOther = filterStringEnum( x => x.toLowerCase.capitalize )
  //val filterStringEnumRestricted = filterStringEnum( x => x.toUpperCase )
  //val filterStringEnumRestricted = (enumSeq: Seq[String], defaultVal: String) => filterStringEnum( _ => defaultVal )(enumSeq)



  //  def jsonFieldUpdater(json: JValue, list: List[Map[String, JValue]]): JValue =
  //    list.foldLeft(json) { case (json, kvs) =>
  //      kvs.foldLeft(json) { case (json, (key, value)) =>
  //        json.replace(key.split("/").toList, value)
  //      }
  //    }
  //  case class Updater(key: String, value: JValue) {
  //    def path: List[String] = key.split("/").toList
  //  }
  //
  //  def jsonFieldUpdater2(json: JValue, list: List[Updater]): JValue =
  //    list.foldLeft(json) { case (json, u) =>
  //      json.replace(u.path, u.value)
  //    }















//  package lm.api
//
//  import net.liftweb.mapper._
//
//  import com.dotography.library.api._
//
//  import lm.model.ContactAddress
//
//  //special use case for quicksearch
//  class AddressOrCountryTitle(fieldAddress: String) extends QPBuilder[String, ContactAddress] {
//    private def colName(field: MappedField[_,_]) = MapperRules.quoteColumnName.vend(field._dbColumnNameLC)
//    private def tbName(meta: MetaMapper[_]) = MapperRules.quoteTableName.vend(meta._dbTableNameLC)
//    private val addrIdFieldName = colName(ContactAddress.id)
//
//    private val addressQueryField = fieldAddress match {
//      case "address_2" => ContactAddress.address_2
//      case "address_3" => ContactAddress.address_3
//      case "city" => ContactAddress.city
//      case "state" => ContactAddress.state
//      case _ => ContactAddress.address_1
//    }
//
//    private val addrValFieldName = colName(addressQueryField)
//    private val addrCountryFieldName = colName(ContactAddress.country)
//
//    private def wrapPercent(v: String) = (v.length > 0) match {
//      case false => v
//      case true => s"%$v%"
//    }
//
//    private def wrapOrs(conds:Seq[String]) = conds.mkString("("," OR ", ")")
//    private def sqlCond(fname: String)(s: String) = s.isEmpty match {
//      case true => s"LOWER($fname) = ?"
//      case false => s"LOWER($fname) LIKE ?"
//    }
//    private def addrSQLCond(s: String) = sqlCond(addrValFieldName)(s)
//
//    private def addrConds(vs: Seq[String]) = wrapOrs(vs.map(addrSQLCond _))
//
//    private def combineConds(vs: Seq[String]) = wrapOrs(Seq(addrConds(vs)))
//    private def values(vs: Seq[String]) = {
//      val transformed = vs.map(wrapPercent)
//      transformed ++ transformed
//    }
//
//    private def rawSQL(vs:Seq[String]):QueryParam[ContactAddress] = BySql[ContactAddress](combineConds(vs),IHaveValidatedThisSQL("nope", "2016-03-18"), values(vs) :_*)
//    def build(vs: Seq[String]) : Seq[QueryParam[ContactAddress]] = vs.isEmpty match {
//      case true => Seq()
//      case false => Seq(rawSQL(vs))
//    }
//  }

}

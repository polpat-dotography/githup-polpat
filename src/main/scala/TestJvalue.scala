/**
  * Created by OS on 29-Oct-16.
  */

import Utility.FancyLog._
import net.liftweb.json._
import net.liftweb.json.JsonAST.JValue
import net.liftweb.json.JsonDSL._

object TestJvalue extends App {

  printlnG("TEST-JVALUE")

  val result = """{"result":{"map":{"entry":[{"key":{"@xsi.type":"xs:string","$":"ContentA"},"value":"fsdf"},{"key":{"@xsi.type":"xs:string","$":"ContentB"},"value":"dfdf"}]}}}"""
  val resultJson = parse(result)

  printlnB("Result json : " + resultJson.hashCode)





  val result2 = """{
                      "id": "6804",
                      "signatories": [
                      {
                        "id": "12125",
                        "fields": [
                        {
                          "type": "standard",
                          "name": "fstname",
                          "value": "John"
                        },
                        {
                          "type": "standard",
                          "name": "sndname",
                          "value": "Doe"
                        },
                        {
                          "type": "standard",
                          "name": "email",
                          "value": "john.doe@somwhere.com"
                        },
                        {
                          "type": "standard",
                          "name": "sigco",
                          "value": "Company"
                        }
                        ]
                      }
                      ]
                    }"""
  val resultJson2 = parse(result2)
  val tmp2 = resultJson2.transform{case JField(x, v) if x == "value" && v == JString("Company")=> JField("value1",JString("Company1"))}
  printlnC("tmp2 : " + tmp2)
}

package com.sensegraph.ws.example;

import javax.json.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

/**
 * Created by dperini on 05/08/17.
 */
public class JsonTest {


  public static void main(String[] args) {

    JsonReader reader = Json.createReader(new StringReader("{\"pippo\": \"pluto\"}"));

    JsonObject myObject = reader.readObject();

    reader.close();

    JsonObjectBuilder builder = Json.createObjectBuilder();
    for(Map.Entry<String, JsonValue> entry:  myObject.entrySet()) {
      builder.add(entry.getKey(), entry.getValue());
    }
    builder.add("pape", "rino");


    System.out.println(builder.build());

//    System.out.println("Name   : " + personObject.getString("name"));
//    System.out.println("Age    : " + personObject.getInt("age"));
//    System.out.println("Married: " + personObject.getBoolean("isMarried"));
//
//    JsonObject addressObject = personObject.getJsonObject("address");
//    System.out.println("Address: ");
//    System.out.println(addressObject.getString("street"));
//    System.out.println(addressObject.getString("zipCode"));
//
//    System.out.println("Phone  : ");
//    JsonArray phoneNumbersArray = personObject.getJsonArray("phoneNumbers");
//
//    for (JsonValue jsonValue : phoneNumbersArray) {
//      System.out.println(jsonValue.toString());
//    }
  }
}
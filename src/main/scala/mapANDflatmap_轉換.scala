import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark6 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simple App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val data = sc.textFile("hadoop.cmd")
//    map出來是char要記得tostring
    val x = data.flatMap(_.toLowerCase()).take(5) // Array(@, e, c, h, o)
    val y = data.map(_.toLowerCase()).take(5) /* Array(@echo off, @rem licensed to the apache software foundation (asf) under one
    or more, @rem contributor license agreements.  see the notice file distributed with, @rem this work for
      additional information regarding copyright ownership., @rem the asf licenses this file to you under th
      e apache license, version 2.0)*/
    data.flatMap(_.toLowerCase()).take(5).foreach(word=>print(word.toString +':'))
    data.map(_.toLowerCase()).take(5).foreach(sentence=>print(sentence +':'))
  }
}

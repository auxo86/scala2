import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark4 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simple App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val data = sc.textFile("hadoop.cmd")
    val mapresult = data.map(line=>line.split("\\s+"))
    println("result=%s".format(data.map(s=>s.length).collect().mkString("<", ",", ">")))
    println("first in mapresult=%S".format(mapresult.first().mkString("[", ",", "]")))
    println("mapresult=%S".format(mapresult.collect().mkString("[", ",", "]")))
    val result2 = mapresult.collect()
    result2.foreach{x=>x.foreach{println}}
//    <-是指派運算元
    result2.foreach{x=>{for (p<-x) print(p+"/")
      println()}}
    val result3 = data.map(_.toUpperCase).take(5)
    result3.foreach{println}

    sc.stop()
  }
}

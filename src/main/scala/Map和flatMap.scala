import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark5 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simple App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val data = sc.textFile("hadoop.cmd")
    val map = data.map(line=>line.split("\\s+"))
    val flatmap = data.flatMap(line=>line.split("\\s+"))
    flatmap.take(5).foreach(println)
    map.take(5).foreach(x=>println(x.mkString("[",",","]")))

  }
}


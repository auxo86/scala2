import org.apache.spark.{SparkConf, SparkContext}

object ＨelloSpark3 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("simple app").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("README.md").cache()
    val numAs = textFile.filter(line=>line.contains("a")).count()
    val numBs = textFile.filter(line=>line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
}

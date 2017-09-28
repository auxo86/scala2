import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simp App")
        .setMaster("local[*]")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("README.md")
    val result = textFile.count()
    println("lines in readme.md=%d".format(result))
  }
}

import org.apache.spark.{SparkConf, SparkContext}

object ＨelloScala8 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simple App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val data = sc.textFile("hadoop.cmd")
        val max = data.map(line=>line.split("\\s+").size).reduce((a,b)=>if(a>b) a else b)
        print("max data = " + max)
        val wordCounts = data.flatMap(line=>line.split("\\s+"))
          .map(word=>(word, 1)).reduceByKey((a,b)=>a+b).sortByKey(false,1)
        wordCounts.foreach(println)
        val wordCounts2 = data.flatMap(line=>line.split("\\s+"))
          .map(word=>(word,1)).reduceByKey((a,b) => a + b).map(item => item.swap)
          .sortByKey(false,1).map(item=>item.swap)
        wordCounts2.foreach(println)
  }
}
import org.apache.spark.{SparkConf, SparkContext}

object RDD運算 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simple App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    var rdd1 = sc.makeRDD(1 to 20)
    rdd1.collect().foreach(x=>print(x+" "))
    print("sum = " + rdd1.reduce(_ + _))
    print("sum2 = " + rdd1.reduce((x, y)=>{
      x + y
    }))

//    map reduce並不會有順序，都是隨機抓兩來做
    var rdd2 = sc.makeRDD(Array(("A", 1), ("B", 2), ("C", 3), ("D", 4), ("E", 5)))
    print(rdd2.reduce((x, y)=>{
      (x._1 + y._1, x._2 + y._2)
    }))
  }
}

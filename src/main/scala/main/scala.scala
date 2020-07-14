package main
import main.solutions.mazeSolver.{Point, Runner}

object scala {
  def main(args: Array[String]): Unit = {
    val maze = Array(
      Array(0,0,0,0,0),
      Array(0,1,0,1,1),
      Array(1,1,0,1,0),
      Array(1,0,0,0,1)
    )
    println(Runner.hasPath(maze, Point(0,0), Point(3,3)))
  }



}

package main.solutions.mazeSolver
import scala.collection.mutable.HashSet

object Runner {
  def hasPath(maze: Array[Array[Int]], start: Point, end: Point): Boolean = {
    MazeSolver.hasPathBFS(maze, start, end, HashSet[Point]())
  }

}

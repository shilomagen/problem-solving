package main.solutions.MazeSolver

import scala.collection.mutable.HashSet

object Helpers {
  private def filterInBoundNeighbors(maze: Array[Array[Int]], point: Point): Boolean = {
    try {
      maze(point.x)(point.y)
      true
    } catch {
      case _: ArrayIndexOutOfBoundsException => false
    }
  }
  private def validNeighbors(maze: Array[Array[Int]], point: Point): Boolean = maze(point.x)(point.y) == 0
  private def notVisited(visited: HashSet[Point], point: Point): Boolean = !visited(point)

  def getValidNeighbors(maze: Array[Array[Int]], point: Point, visited: HashSet[Point]): Array[Point] = {
    val x = point.x
    val y = point.y
    Array[Point](Point(x+1, y), Point(x-1, y), Point(x, y-1), Point(x, y+1))
      .filter(filterInBoundNeighbors(maze, _))
      .filter(validNeighbors(maze, _))
      .filter(notVisited(visited, _))
  }
}

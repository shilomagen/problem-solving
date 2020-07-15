package main.solutions.MazeSolver

import scala.collection.mutable.{HashSet, Queue}

object Solver {
  def hasPathBFS(maze: Array[Array[Int]], start: Point, end: Point): Boolean = {
    hasPathBFSHelper(maze, start, end, HashSet[Point]())
  }
  private def hasPathBFSHelper(maze: Array[Array[Int]], start: Point, end: Point, visited: HashSet[Point]): Boolean = {
    val queue = Queue[Point]()
    queue.enqueue(start)
    while (queue.nonEmpty) {
      val point = queue.dequeue
      visited.add(point)
      if (point == end)
        return true
      else
        Helpers.getValidNeighbors(maze, point, visited).foreach(queue.enqueue)
    }
    false
  }
  def hasPathDFS(maze: Array[Array[Int]], start: Point, end: Point): Boolean = {
    hasPathDFSHelper(maze, start, end, HashSet[Point]())
  }

  private def hasPathDFSHelper(maze: Array[Array[Int]], start: Point, end: Point, visited: HashSet[Point]): Boolean = {
    if (start == end)
      return true
    visited.add(start)
    Helpers.getValidNeighbors(maze, start, visited).exists(hasPathDFSHelper(maze, _, end, visited))
  }

}

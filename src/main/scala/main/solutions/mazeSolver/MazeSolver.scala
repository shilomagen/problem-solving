package main.solutions.mazeSolver

import scala.collection.mutable.{Queue,HashSet}

object MazeHelpers {
  def getNeighbors(maze: Array[Array[Int]], point: Point): Array[Point] = {
    val x = point.x;
    val y = point.y;
    Array[Point](Point(x+1, y), Point(x-1, y), Point(x, y-1), Point(x, y+1)).filter(p => {
      try {
        maze(p.x)(p.y)
        true
      } catch {
        case _: ArrayIndexOutOfBoundsException => false
      }
    })
  }
}
object MazeSolver {
  def hasPathBFS(maze: Array[Array[Int]], start: Point, end: Point, visited: HashSet[Point]): Boolean = {
    val queue = Queue[Point]()
    queue.enqueue(start)
    while (queue.nonEmpty) {
      val point = queue.dequeue
      visited.add(point)
      if (point == end)
        return true
      else {
        val neighbors = MazeHelpers.getNeighbors(maze, point)
          .filter(p => maze(p.x)(p.y) == 0)
          .filter(p => !visited(p))
        neighbors.foreach(p => queue.enqueue(p))
      }
    }
    false;
  }

}

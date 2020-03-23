import java.awt.{EventQueue,Graphics,Graphics2D,Dimension,Color}
import javax.swing.{JFrame,JPanel,WindowConstants}

// classe astratta che rappresenta elementi grafici 2D
sealed abstract class Shape

// cerchio di raggio r centrato in (x,y) di colore c
case class Circle(x:Double, y:Double, r:Double) extends Shape

// segmento di linea da (x1,y1) a (x2,y2) di colore c
case class Line(x1:Double, y1:Double, x2:Double, y2:Double) extends Shape

object Frame2D {
  def display(l:List[Shape], width:Int, height:Int) {
    EventQueue.invokeLater(new Runnable() {
      override def run() {
        val ex = new Frame2D(l,width,height)
        ex.setVisible(true)
      }
    })
  }
}

class Frame2D(l:List[Shape], width:Int, height:Int) extends JFrame {
  class Surface2D extends JPanel {

    def doDrawCircle(c:Circle, g2d:Graphics2D) {
      val wc = (2*width*c.r).toInt
      val hc = (2*height*c.r).toInt
      val xc = (width*(c.x-c.r)).toInt
      val yc = (height-height*(c.y-c.r)).toInt - hc
      g2d.drawOval(xc, yc, wc, hc)
    }

    def doDrawLine(l:Line, g2d:Graphics2D) {
      val x1 = (width*l.x1).toInt
      val y1 = height-(height*l.y1).toInt
      val x2 = (width*l.x2).toInt
      val y2 = height-(height*l.y2).toInt
      g2d.drawLine(x1, y1, x2, y2)
    }

    def doDrawing(g:Graphics) {
      g match {
        case g2d:Graphics2D =>
          l foreach (_ match {
            case c:Circle => doDrawCircle(c, g2d)
            case l:Line   => doDrawLine(l, g2d)
          })
      }
    }

    override def paintComponent(g:Graphics) {
      super.paintComponent(g);
      doDrawing(g);
    }
  }

  val panel = new Surface2D()
  panel.setPreferredSize(new Dimension(width, height))
  add(panel);
  setTitle("Shapes");
  setResizable(false)
  pack();
  setLocationRelativeTo(null);
  //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

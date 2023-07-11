package maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class NewClass extends JFrame {
  
	private int[][] maze= {{1,1,1,1,1,1,1,1,1,1},
			               {1,0,0,0,0,0,1,0,0,1},
			               {1,0,0,0,0,0,0,0,0,1},
			               {1,0,0,0,0,1,0,0,0,1},
			               {1,0,0,0,0,0,0,1,0,1},
			               {1,1,0,0,0,0,0,1,0,1},
			               {1,0,0,0,0,1,0,0,0,1},
			               {1,0,0,1,0,0,0,0,0,1},
			               {1,0,0,0,0,1,0,0,9,1},
			               {1,1,1,1,1,1,1,1,1,1}};
	
	public List<Integer> path=new ArrayList<Integer>();
	
	NewClass(){
		setTitle("Maze Solver");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DfsSearch.search(maze, 1, 1, path);
		System.out.println(path );
	}
	
	@Override
	public void paint(Graphics g) {
	   g.translate(50, 50);	
		
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
				Color color;
				
				switch(maze[i][j]) {
				case 1:color=Color.BLACK;
				       break;
				case 9:color=Color.RED;
				       break;
				default:color=Color.WHITE;
				        break;
				}
				g.setColor(color);
				g.fillRect(30*j, 30*i, 30, 30);
				g.setColor(Color.RED);
				g.drawRect(30*j, 30*i, 30, 30);
			}
		}
		
		for(int i=0;i<path.size();i+=2) {
			int x=path.get(i);
			int y=path.get(i+1);
			
			g.setColor(Color.GREEN);
			g.fillRect(30*x, y=30*y, 30, 30);
		}
	}
	
	public static void main(String[] args) {
		NewClass obj =new NewClass();
		obj.setVisible(true);
	}
}

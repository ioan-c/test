import javax.swing.JFrame;

public class MazeLauncher {
	
	JFrame frame;
	private Board board;

	public static void main(String[] args){
		new MazeLauncher().start();
	}

	private void start() {
		frame = new JFrame();
		frame.setTitle("Mazeolicious");
		board = new Board(this);
		frame.add(board);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);getClass();
		frame.setSize(board.getBoardWidth()+15, board.getBoardHeight()+37);
	}

	public void restart(){
		frame.remove(board);
		board = new Board(this);
		frame.add(board);
		frame.revalidate();
		board.requestFocusInWindow();
	}
}

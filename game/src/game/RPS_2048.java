package game;
import java.awt.*;													//继承JFrame类需要该包；
import java.awt.event.*;											//设置panel需要该包；
import javax.swing.*;												//涉及触发事件都需要该包；
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.Scanner;

public class RPS_2048 {	
	public static void main(String[] args) {
// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("选择你想玩的游戏:");
		System.out.println("1:2048,2:剪刀石头布");
		int a=input.nextInt();
		if(a==1)
		{
			SwingUtilities.invokeLater(() -> {
				JFrame f= new JFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("2048");
				f.setResizable(true);
				f.add(new Game2048(), BorderLayout.CENTER);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			});
		}
		else if(a==2)
		{
			RPS rps =new RPS();//初始化窗体对象；
			rps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭按钮；
			rps.setVisible(true);//使窗体可见；
			JFrame frame1=new JFrame();//设置提示窗口
			frame1.setSize(500,200);
			frame1.setLocation(500, 150);
			//按钮
			JButton button=new JButton("剪刀石头布规则：剪刀胜布，石头胜剪刀，布胜石头！");
			//在窗体上添加按钮
			frame1.add(button);
			//显示窗体
			frame1.setVisible(true);
			JFrame frame2=new JFrame();//设置提示窗口
			frame2.setSize(500,200);
			frame2.setLocation(500, 350);
			//按钮
			JButton button1=new JButton("The rules:Scissors beat Paper,Rock beats Scissors,Paper beats Rock!");
			//在窗体上添加按钮
			frame2.add(button1);
			//显示窗体
			frame2.setVisible(true);
		}
		else
		{
			System.out.println("输入不正确，请重新输入！");
		}
	}
}

class RPS extends JFrame implements ActionListener{		
	//定义一个窗口类，该类实现ActionListener接口；
JButton scissors,rock,paper,back;	//把JButton组件定义放到类里面，方便其他函数调用；
JPanel panel1,panel2,panel3;				//把JPanel组件定义放到类里面，方便其他函数调用；
JLabel label;						//把JLabel组件定义放到类里面，方便其他函数调用；

public RPS() {	//RPS=Rock-Paper-Scissors
	//初始化界面（窗口）
setTitle("Rock-Paper-Scissors");					//设置窗体标题；
setLocation(250,250);								//设置窗体左上顶点坐标；
setSize(1000,1000);									//设置窗体大小；

panel1 =new JPanel();					//添加一个JPanel对象，名为panel1，方便布局；
panel1.setBackground(Color.BLUE);				//设置panel1颜色；
rock = new JButton("Rock(石头)");						//添加一个JButton对象，名为rock；
scissors =new JButton("Scissors(剪刀)");				//添加一个JButton对象，名为scissors；
paper = new JButton("Paper(布)");					//添加一个JButton对象，名为paper；

panel2=new JPanel();						//添加一个新的JPanel对象，名为panel2；
panel2.setBackground(Color.pink);					//设置panel2颜色；
label=new JLabel();
label.setFont(new Font("宋体", Font.CENTER_BASELINE, 16));//设置字体大小
label.setText("Please choose(Rock,Scissors,Paper)to begin!");

panel3=new JPanel();
panel3.setBackground(Color.PINK);
back = new JButton("Back(返回)");   

rock.addActionListener(this);						//给rock添加事件约束；
paper.addActionListener(this);						//给paper添加事件约束；
scissors.addActionListener(this);					//给scissors添加事件约束；
back.addActionListener(this);						//给clear添加事件约束；

panel1.add(rock);							//把rock放进panel1中；
panel1.add(scissors);						//把scissors放进panel1中；
panel1.add(paper);							//把paper放进panel1中；
panel2.add(label);							//把label放进panel2中；
panel3.add(back);		     				//把clear放进panel3中；


add(panel1,BorderLayout.NORTH);					//把panel1添加到窗体的北面；
add(panel2,BorderLayout.CENTER);				//把panel2添加到窗体的中间；
add(panel3,BorderLayout.AFTER_LINE_ENDS);                 //把panel3添加到窗体的南面；
}

public void actionPerformed(ActionEvent e) {		
	//定义一个ActionListener接口方法，当按下按钮就会调用里面的方法
if(e.getSource()==rock) //getSource()方法可获得按钮按下的操作
{								//如果你按下的是rock按键时，就会执行以下操作；
	int i=(int)(Math.random()*3);
//获取随机数i，随机数区间为[0,3)
switch(i)			
{
case 0 :label.setText("You choose Rock,and AI chooses Rock.Tie!(你出石头，电脑出石头，平局！)");
		break;//当i=0时，执行后续操作
case 1 :label.setText("You choose Rock,and AI chooses Scissors.You Win!(你出石头，电脑出剪刀，恭喜你赢了！)");
		break;		//当i=1时，与上同理；
case 2 :label.setText("You choose Rock,and AI chooses Paper.You Lose!(你出石头，电脑出布，很遗憾你输了！)");
		break;		//当i=2时，与上同理；
}
}
else if (e.getSource()==scissors) 
{								//与上同理；
	int i=(int)(Math.random()*3);
	switch(i)
	{
	case 0 :label.setText("You choose Scissors,and AI chooses Scissors.Tie!(你出剪刀，电脑出剪刀，平局！)");break;
	case 1 :label.setText("You choose Scissors,and AI chooses Paper.You Win!(你出剪刀，电脑出布，恭喜你赢了！)");break;
	case 2 :label.setText("You choose Scissors,and AI chooses Rock.You Lose!(你出剪刀，电脑出石头，很遗憾你输了！)");break;
	}
}
else if (e.getSource()==paper) 
{									//与上同理；
	int i=(int)(Math.random()*3);
	switch(i)
	{
	case 0 :label.setText("You choose Paper,and AI chooses Paper.Tie!(你出布，电脑出布，平局！)");break;
	case 1 :label.setText("You choose Paper,and AI chooses Rock.You Win!(你出布，电脑出石头，恭喜你赢了！)");break;
	case 2 :label.setText("You choose Paper,and AI chooses Scissors.You Lose!(你出布，电脑出剪刀，很遗憾你输了！)");break;
	}
}
else if(e.getSource()==back)		//当你按下back按键时，直接输出label.setText()；
{ 
	label.setText("Please choose(Rock,Scissors,Paper)to begin!"); }
}
}

class Game2048 extends JPanel {
enum State {//枚举游戏状态
start, won, running, over
}
final Color[] colorTable = {//final定义变量不可更改，设置不同颜色选择
new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3),
new Color(0xffdac3), new Color(0xe7b08e), new Color(0xe7bf8e),
new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710)
};
final static int target = 2048;//目标数字
static int highest;//最大
static int score;//当前分
private Color gridColor = new Color(0xBBADA0);//格子颜色
private Color emptyColor = new Color(0xCDC1B4);//空白格颜色
private Color startColor = new Color(0xFFEBCD);//开始界面颜色
private Random rand = new Random();//随即种子
private Tile1[][] tiles;
private int side = 4;
private State gamestate = State.start;//游戏状态
private boolean checkingAvailableMoves;
public Game2048() {
setPreferredSize(new Dimension(900, 700));//设置界面大小
setBackground(new Color(0xFAF8EF));//设置背景
setFont(new Font("SansSerif", Font.BOLD, 48));//设置字体
setFocusable(true);//获取控件的点击事件
addMouseListener(new MouseAdapter() {

public void mousePressed(MouseEvent e) {//当用户按下鼠标按钮时发生
startGame();
repaint();//重新绘制组件
}
});
addKeyListener(new KeyAdapter() {

public void keyPressed(KeyEvent e) {//判断按键
switch (e.getKeyCode()) {
case KeyEvent.VK_UP:
moveUp();
break;
case KeyEvent.VK_DOWN:
moveDown();
break;
case KeyEvent.VK_LEFT:
moveLeft();
break;
case KeyEvent.VK_RIGHT:
moveRight();
break;
}
repaint();
}
});
}

public void paintComponent(Graphics gg) {//画出容器本身自己的组件
super.paintComponent(gg);
Graphics2D g = (Graphics2D) gg;
g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
RenderingHints.VALUE_ANTIALIAS_ON);
drawGrid(g);
}
void startGame() {//开始游戏
if (gamestate != State.running) {
score = 0;
highest = 0;
gamestate = State.running;
tiles = new Tile1[side][side];
addRandomTile();
addRandomTile();
}
}
void drawGrid(Graphics2D g) {//画网格
g.setColor(gridColor);
g.fillRoundRect(200, 100, 499, 499, 15, 15);
if (gamestate == State.running) {
for (int r = 0; r < side; r++) {
for (int c = 0; c < side; c++) {
if (tiles[r][c] == null) {
g.setColor(emptyColor);//设置颜色
g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);//画圆角矩形
} else {
drawTile(g, r, c);
}
}
}
} else {
g.setColor(startColor);
g.fillRoundRect(215, 115, 469, 469, 7, 7);
g.setColor(gridColor.darker());
g.setFont(new Font("SansSerif", Font.BOLD, 128));
g.drawString("2048", 310, 270);
g.setFont(new Font("SansSerif", Font.BOLD, 20));
if (gamestate == State.won) {
g.drawString("你成功了!", 390, 350);
} else if (gamestate == State.over)
g.drawString("游戏结束", 400, 350);
g.setColor(gridColor);
g.drawString("点击鼠标左键开始游戏", 330, 480);
g.drawString("(使用方向键控制方向)", 310, 550);
}
}
void drawTile(Graphics2D g, int r, int c) {
int value = tiles[r][c].getValue();
g.setColor(colorTable[(int) (Math.log(value) / Math.log(2)) + 1]);
g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
String s = String.valueOf(value);
g.setColor(value < 128 ? colorTable[0] : colorTable[1]);
FontMetrics fm = g.getFontMetrics();
int asc = fm.getAscent();
int dec = fm.getDescent();
int x = 215 + c * 121 + (106 - fm.stringWidth(s)) / 2;
int y = 115 + r * 121 + (asc + (106 - (asc + dec)) / 2);
g.drawString(s, x, y);
}
private void addRandomTile() {//随机生成方块
int pos = rand.nextInt(side * side);
int row, col;
do {
pos = (pos + 1) % (side * side);
row = pos / side;
col = pos % side;
} while (tiles[row][col] != null);
int val = rand.nextInt(10) == 0 ? 4 : 2;
tiles[row][col] = new Tile1(val);
}
private boolean move(int countDownFrom, int yIncr, int xIncr) {//移动方块以及操作
boolean moved = false;
for (int i = 0; i < side * side; i++) {
int j = Math.abs(countDownFrom - i);
int r = j / side;
int c = j % side;
if (tiles[r][c] == null)
continue;
int nextR = r + yIncr;
int nextC = c + xIncr;
while (nextR >= 0 && nextR < side && nextC >= 0 && nextC < side) {
Tile1 next = tiles[nextR][nextC];
Tile1 curr = tiles[r][c];
if (next == null) {
if (checkingAvailableMoves)
return true;
tiles[nextR][nextC] = curr;
tiles[r][c] = null;
r = nextR;
c = nextC;
nextR += yIncr;
nextC += xIncr;
moved = true;
} else if (next.canMergeWith(curr)) {
if (checkingAvailableMoves)
return true;
int value = next.mergeWith(curr);
if (value > highest)
highest = value;
score += value;
tiles[r][c] = null;
moved = true;
break;
} else
break;
}
}
if (moved) {
if (highest < target) {
clearMerged();
addRandomTile();
if (!movesAvailable()) {
gamestate = State.over;
}
} else if (highest == target)
gamestate = State.won;
}
return moved;
}
boolean moveUp() {//上移
return move(0, -1, 0);
}
boolean moveDown() {//下移
return move(side * side - 1, 1, 0);
}
boolean moveLeft() {//左移
return move(0, 0, -1);
}
boolean moveRight() {//右移
return move(side * side - 1, 0, 1);
}
void clearMerged() {
for (Tile1[] row : tiles)
for (Tile1 tile : row)
if (tile != null)
tile.setMerged(false);
}
boolean movesAvailable() {
checkingAvailableMoves = true;
boolean hasMoves = moveUp() || moveDown() || moveLeft() || moveRight();
checkingAvailableMoves = false;
return hasMoves;
}
}

class Tile1 {//Title类
private boolean merged;
private int value;
Tile1(int val) {
value = val;
}
int getValue() {
return value;
}
void setMerged(boolean m) {
merged = m;
}
boolean canMergeWith(Tile1 other) {
return !merged && other != null && !other.merged && value == other.getValue();
}
int mergeWith(Tile1 other) {
if (canMergeWith(other)) {
value *= 2;
merged = true;
return value;
}
return -1;
}
}
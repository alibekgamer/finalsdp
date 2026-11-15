package music;
import javax.swing.*;import javax.swing.border.*;import java.awt.*;import java.util.*;
public class MusicApp extends JFrame {
 private final LibraryFacade library=new LibraryFacade();private final TrackPublisher publisher=new TrackPublisher();private final MusicPlayer player=new MusicPlayer(publisher);
 private final DefaultListModel<Track> model=new DefaultListModel<>();private final JList<Track> list=new JList<>(model);
 private final JTextArea lyrics=new JTextArea();private final JLabel now=new JLabel("Choose a track");private final JLabel status=new JLabel("Ready");
 private final JCheckBox echo=new JCheckBox("Echo"),lowpass=new JCheckBox("Low-pass");
 public MusicApp(){super("WaveBox | Music Streaming Service");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);setSize(930,570);setLocationRelativeTo(null);
  Color bg=new Color(22,25,35),panel=new Color(35,39,53),fg=new Color(240,243,250);getContentPane().setBackground(bg);setLayout(new BorderLayout(14,14));
  JLabel header=new JLabel("  WaveBox   /   MUSIC STREAMING SERVICE");header.setFont(new Font("SansSerif",Font.BOLD,22));header.setForeground(new Color(113,232,189));add(header,BorderLayout.NORTH);
  JPanel left=new JPanel(new BorderLayout(8,8));left.setBackground(panel);left.setBorder(new EmptyBorder(16,16,16,16));
  JTextField search=new JTextField();search.setToolTipText("Search title, artist or genre");left.add(search,BorderLayout.NORTH);
  list.setBackground(panel);list.setForeground(fg);list.setSelectionBackground(new Color(70,91,113));list.setFont(new Font("SansSerif",Font.PLAIN,15));list.setFixedCellHeight(43);left.add(new JScrollPane(list),BorderLayout.CENTER);
  JPanel sort=new JPanel(new GridLayout(1,3,6,0));String[] names={"Title","Artist","Genre"};SortStrategy[] strategies={new SortByTitle(),new SortByArtist(),new SortByGenre()};for(int i=0;i<3;i++){final SortStrategy s=strategies[i];JButton b=new JButton(names[i]);b.addActionListener(e->refresh(s.sort(library.search(search.getText()))));sort.add(b);}left.add(sort,BorderLayout.SOUTH);
  JPanel right=new JPanel(new BorderLayout(12,12));right.setBackground(panel);right.setBorder(new EmptyBorder(20,20,20,20));now.setForeground(fg);now.setFont(new Font("SansSerif",Font.BOLD,20));right.add(now,BorderLayout.NORTH);
  lyrics.setEditable(false);lyrics.setText("Select a track to see live lyrics");lyrics.setFont(new Font("SansSerif",Font.PLAIN,19));lyrics.setBackground(panel);lyrics.setForeground(new Color(200,215,227));lyrics.setBorder(new EmptyBorder(18,8,8,8));right.add(lyrics,BorderLayout.CENTER);
  JPanel controls=new JPanel(new GridLayout(3,1,6,6));controls.setBackground(panel);JPanel buttons=new JPanel(new GridLayout(1,4,8,0));
  Command[] commands={new PreviousCommand(player),new PlayCommand(player),new PauseCommand(player),new NextCommand(player)};String[] labels={"Previous","Play","Pause","Next"};for(int i=0;i<4;i++){final Command c=commands[i];final String name=labels[i];JButton b=new JButton(name);b.addActionListener(e->{player.setEffects(echo.isSelected(),lowpass.isSelected());c.execute();status.setText(name+" | "+(player.current()==null?"No track":player.current().title));});buttons.add(b);}controls.add(buttons);
  JPanel effects=new JPanel();effects.setBackground(panel);echo.setBackground(panel);echo.setForeground(fg);lowpass.setBackground(panel);lowpass.setForeground(fg);effects.add(new JLabel("Audio effects: "));effects.add(echo);effects.add(lowpass);controls.add(effects);status.setForeground(new Color(113,232,189));controls.add(status);right.add(controls,BorderLayout.SOUTH);
  JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right);split.setDividerLocation(430);split.setResizeWeight(.48);add(split,BorderLayout.CENTER);
  publisher.subscribe(t->{now.setText(t==null?"No track":t.title+"  —  "+t.artist);lyrics.setText(t==null?"No lyrics":t.lyrics);});
  search.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){public void insertUpdate(javax.swing.event.DocumentEvent e){update();}public void removeUpdate(javax.swing.event.DocumentEvent e){update();}public void changedUpdate(javax.swing.event.DocumentEvent e){update();}private void update(){refresh(library.search(search.getText()));}});
  list.addListSelectionListener(e->{if(!e.getValueIsAdjusting()&&list.getSelectedValue()!=null){Track selected=list.getSelectedValue();java.util.List<Track> current=new ArrayList<>();current.add(selected);for(int i=0;i<model.size();i++)if(model.get(i)!=selected)current.add(model.get(i));player.setPlaylist(current);}});
  refresh(library.all());list.setSelectedIndex(0);
 }
 private void refresh(java.util.List<Track> tracks){model.clear();for(Track t:tracks)model.addElement(t);player.setPlaylist(tracks);}
 public static void main(String[] args){SwingUtilities.invokeLater(()->new MusicApp().setVisible(true));}
}
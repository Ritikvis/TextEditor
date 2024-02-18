// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Texteditor implements ActionListener {
//    Declaring properties of TextEditor
    JFrame jframe;
    JMenuBar menubar;
    JMenu file,edit;
//    File menu items
    JMenuItem newFile,openFile,saveFile;
//    Edit menu items
    JMenuItem cut,copy,paste,selectAll,close;
    JTextArea textArea;

    Texteditor(){
//        Initialize the frame
        jframe = new JFrame();
//        Initialize the menuBar
        menubar = new JMenuBar();
//        Initialize textarea
        textArea = new JTextArea();
//       Initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
//         Initialize file menu items
        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");
//      Add action listners to file menu items
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
//      Add menu items to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
//       Initialize edit menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("SelectAll");
        close = new JMenuItem("Close");

//       Adding to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);
//        Add action listners to edit menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

//      Add menu to menubar
        menubar.add(file);
        menubar.add(edit);

        jframe.add(textArea);

//      Set MenuBar to frame
        jframe.setJMenuBar(menubar);
//        Create Content Pane
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5 ,5,5));
        panel.setLayout(new BorderLayout(0,0));
//        Add text area to the panel
        panel.add(textArea,BorderLayout.CENTER);
//        Create Scrool panel
        JScrollPane jScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//       Add Scrol pane to panel
        panel.add(jScrollPane);
//        Add panel to frame
        jframe.add(panel);
//        Set dimensional to the frame
        jframe.setBounds(100,100,400,400);
        jframe.setVisible(true);
        jframe.setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource()==cut){
//       perform cut option
            textArea.cut();
        }
        if(actionEvent.getSource()==copy){
//      perform copy option
            textArea.copy();

        }
        if(actionEvent.getSource()==paste){
//       perform paste option

            textArea.paste();

        }
        if(actionEvent.getSource()==selectAll) {
//      perform selectall option
            textArea.selectAll();

        }
        if(actionEvent.getSource()==close) {
//      perform close option
            System.exit(0);

        }
        if(actionEvent.getSource()==openFile){
//            open a file chooser
            JFileChooser fileChooser = new JFileChooser("C");
            int chooseOption = fileChooser.showOpenDialog(null);
//            if we have clicked on open button
            if(chooseOption==JFileChooser.APPROVE_OPTION){
//                Getting selected file
                File file  = fileChooser.getSelectedFile();
//                get the path of selected file
                String filepath = file.getPath();
                try{
//                    Initialize file reader
                    FileReader fileReader = new FileReader(filepath);
//                    Initialize buffer reader
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate = " ", output="";
//                    Read content of file line by ;ine
                    while ((intermediate=bufferedReader.readLine())!=null){
                        output+=intermediate+"\n";
                    }
                }
//                Set the output String to text area
                catch (IOException fileNotFoundException){
                    fileNotFoundException.printStackTrace();
                }

            }
        }
        if(actionEvent.getSource()==saveFile){
//            picker file picker
            JFileChooser fileChooser = new JFileChooser(("C"));
//             Get choose option from file chooser
            int chooseOption = fileChooser.showSaveDialog(null);
//           cheak if we clickedon save button
            if(chooseOption==JFileChooser.APPROVE_OPTION){
//                Create a new file choosen directory path and file name
                File file = new File(fileChooser.getSelectedFile().getAbsoluteFile()+".txt");
                try{
//                     Initailize File writer
                    FileWriter fileWriter  = new FileWriter(file);
//                    Initailize buffered writer
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                    Write content of text area of file
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                }
                catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        if(actionEvent.getSource()==newFile){
            Texteditor newTextEditor = new Texteditor();
        }

    }


    public static void main(String[] args) {
        Texteditor main = new Texteditor();

    }
}
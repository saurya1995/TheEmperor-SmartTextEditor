package theemperor;

import java.io.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.FileUserDictionary;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

class FileOperation {

    TheEmperor npd;

    boolean saved;
    boolean newFileFlag;
    String fileName;
    String applicationTitle = "TheEmperor";

    File fileRef;
    JFileChooser chooser;
    String userDictionaryPath = "/dictionary/";
/////////////////////////////

    boolean isSave() {
        return saved;
    }

    void setSave(boolean saved) {
        this.saved = saved;
    }

    String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }
/////////////////////////

    FileOperation(TheEmperor npd) {
        boolean wordWrap = true;
        this.npd = npd;
        saved = true;
        newFileFlag = true;
        fileName = "Untitled";
        fileRef = new File(fileName);
        this.npd.f.setTitle(fileName + " - " + applicationTitle);
        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new MyFileFilter(".java", "Java Source Files(*.java)"));
        chooser.addChoosableFileFilter(new MyFileFilter(".txt", "Text Files(*.txt)"));
        chooser.addChoosableFileFilter(new MyFileFilter(".doc", "Doc Files(*.doc)"));
        chooser.addChoosableFileFilter(new MyFileFilter(".pdf", "Pdf Files(*.pdf)"));
        chooser.setCurrentDirectory(new File("."));
        wordwrap(wordWrap);
        spellChecker();
    }
//////////////////////////////////////

    private void spellChecker() {
//SET DICTIONARY PROVIDER FROM DICTIONARY PATH
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath));
//REGISTER DICTIONARY
        SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "en");
//REGISTER TEXTFIELD     
        SpellChecker.register(this.npd.ta);
    }
//////////////////////////////////////

    boolean saveFile(File temp) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(temp);
            fout.write(npd.ta.getText());
        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                fout.close();
            } catch (IOException excp) {
            }
        }
        updateStatus(temp, true);
        return true;
    }
////////////////////////

    boolean saveThisFile() {

        if (!newFileFlag) {
            return saveFile(fileRef);
        }

        return saveAsFile();
    }
////////////////////////////////////    

    boolean saveAsFile() {
        File temp = null;
        chooser.setDialogTitle("Save As...");
        chooser.setApproveButtonText("Save");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_S);
        chooser.setApproveButtonToolTipText("Click me to save!");

        do {
            if (chooser.showSaveDialog(this.npd.f) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();
            if (!temp.exists()) {
                break;
            }
            if (JOptionPane.showConfirmDialog(
                    this.npd.f, "<html>" + temp.getPath() + " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                break;
            }
        } while (true);

        return saveFile(temp);
    }

////////////////////////
    boolean openFile(File temp) {
        Boolean pdf, d;
        pdf = temp.getName().endsWith(".pdf");
        d = temp.getName().endsWith(".doc");
        String path = temp.getPath();
        if (pdf == true) {
            PDFManager pdfManager = new PDFManager();
            try {
                pdfManager.setFilePath(path);
                this.npd.ta.setText(pdfManager.ToText());
            } catch (Exception e) {
            }
        } else if (d == true) {
            try {
                File file = new File(path);
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());

                HWPFDocument doc = new HWPFDocument(fis);
                WordExtractor we = new WordExtractor(doc);
                String[] paragraphs = we.getParagraphText();
                for (String para : paragraphs) {
                    this.npd.ta.append(para.toString());
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            FileInputStream fin = null;
            BufferedReader din = null;

            try {
                fin = new FileInputStream(temp);
                din = new BufferedReader(new InputStreamReader(fin));
                String str = " ";
                while (str != null) {
                    str = din.readLine();
                    if (str == null) {
                        break;
                    }
                    this.npd.ta.append(str + "\n");
                }

            } catch (IOException ioe) {
                updateStatus(temp, false);
                return false;
            } finally {
                try {
                    din.close();
                    fin.close();
                } catch (IOException excp) {
                }
            }
        }
        updateStatus(temp, true);
        this.npd.ta.setCaretPosition(0);
        return true;
    }
///////////////////////

    void wordwrap(boolean b) {
        this.npd.ta.setLineWrap(b);
    }
////////////////////////

    void clearAll() {
        this.npd.ta.setText("");
    }
//////////////////////

    void openFile() {
        if (!confirmSave()) {
            return;
        }
        chooser.setDialogTitle("Open File...");
        chooser.setApproveButtonText("Open this");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_O);
        chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

        File temp = null;
        do {
            if (chooser.showOpenDialog(this.npd.f) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            temp = chooser.getSelectedFile();

            if (temp.exists()) {
                break;
            }

            JOptionPane.showMessageDialog(this.npd.f,
                    "<html>" + temp.getName() + "<br>file not found.<br>"
                    + "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);

        this.npd.ta.setText("");

        if (!openFile(temp)) {
            fileName = "Untitled";
            saved = true;
            this.npd.f.setTitle(fileName + " - " + applicationTitle);
        }
        if (!temp.canWrite()) {
            newFileFlag = true;
        }

    }
////////////////////////

    void updateStatus(File temp, boolean saved) {
        if (saved) {
            this.saved = true;
            fileName = new String(temp.getName());
            if (!temp.canWrite()) {
                fileName += "(Read only)";
                newFileFlag = true;
            }
            fileRef = temp;
            npd.f.setTitle(fileName + " - " + applicationTitle);
            npd.statusBar.setText("File : " + temp.getPath() + " saved/opened successfully.");
            newFileFlag = false;
        } else {
            npd.statusBar.setText("Failed to save/open : " + temp.getPath());
        }
    }
///////////////////////

    boolean confirmSave() {
        String strMsg = "<html>The text in the " + fileName + " file has been changed.<br>"
                + "Do you want to save the changes?<html>";
        if (!saved) {
            int x = JOptionPane.showConfirmDialog(this.npd.f, strMsg, applicationTitle, JOptionPane.YES_NO_CANCEL_OPTION);

            if (x == JOptionPane.CANCEL_OPTION) {
                return false;
            }
            if (x == JOptionPane.YES_OPTION && !saveAsFile()) {
                return false;
            }
        }
        return true;
    }
///////////////////////////////////////

    void newFile() {
        if (!confirmSave()) {
            return;
        }

        this.npd.ta.setText("");
        fileName = new String("Untitled");
        fileRef = new File(fileName);
        saved = true;
        newFileFlag = true;
        this.npd.f.setTitle(fileName + " - " + applicationTitle);
    }
//////////////////////////////////////
}

public class TheEmperor implements ActionListener, MenuConstants {

    JFrame f;
    JTextArea ta;
    JLabel statusBar;

    private String fileName = "Untitled";
    private boolean saved = true;
    String applicationName = "The Emperor";

    String searchString, replaceString;
    int lastSearchIndex;

    FileOperation fileHandler;
    FontChooser fontDialog = null;
    JColorChooser bcolorChooser = null;
    JColorChooser fcolorChooser = null;
    JDialog backgroundDialog = null;
    JDialog foregroundDialog = null;
    JMenuItem cutItem, auto, copyItem, deleteItem, clearItem, replaceItem, gotoItem, selectAllItem;
///////////////////////////////

    TheEmperor() {
        f = new JFrame(fileName + " - " + applicationName);
        ta = new JTextArea(30, 60);
        statusBar = new JLabel("||       Line 1, Column 1, WordCount 0   ", JLabel.RIGHT);
        f.add(new JScrollPane(ta), BorderLayout.CENTER);
        f.add(statusBar, BorderLayout.SOUTH);
        f.add(new JLabel("  "), BorderLayout.EAST);
        f.add(new JLabel("  "), BorderLayout.WEST);
        createMenuBar(f);
        f.pack();
        f.setLocation(250, 200);
        f.setVisible(true);
        f.setLocation(250, 200);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fileHandler = new FileOperation(this);

/////////////////////
        ta.addCaretListener(
                new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                int lineNumber = 0, column = 0, pos = 0;

                try {
                    pos = ta.getCaretPosition();
                    lineNumber = ta.getLineOfOffset(pos);
                    column = pos - ta.getLineStartOffset(lineNumber);
                } catch (Exception excp) {
                }
                if (ta.getText().length() == 0) {
                    lineNumber = 0;
                    column = 0;
                }
                //////////////////////////word count
                String text = ta.getText();
                int c = 0;
                char ch[] = new char[text.length()];
                for (int i = 0; i < text.length(); i++) {
                    ch[i] = text.charAt(i);
                    if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)) || ((ch[i] != ' ') && (ch[i - 1] == '\n'))) {
                        c++;
                    }

                }
                //System.out.println("word count"+c);
                statusBar.setText("||          Line " + (lineNumber + 1) + ", Column " + (column + 1) + ", WordCount " + c + "   ");
            }
        });
//////////////////
        DocumentListener myListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                fileHandler.saved = false;
            }

            public void removeUpdate(DocumentEvent e) {
                fileHandler.saved = false;
            }

            public void insertUpdate(DocumentEvent e) {
                fileHandler.saved = false;
            }
        };
        ta.getDocument().addDocumentListener(myListener);
/////////
        WindowListener frameClose = new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                if (fileHandler.confirmSave()) {
                    System.exit(0);
                }
            }
        };
        f.addWindowListener(frameClose);

    }

////////////////////////////////////
    void goTo() {
        int lineNumber = 0;
        try {
            lineNumber = ta.getLineOfOffset(ta.getCaretPosition()) + 1;
            String tempStr = JOptionPane.showInputDialog(f, "Enter Line Number:", "" + lineNumber);
            if (tempStr == null) {
                return;
            }
            lineNumber = Integer.parseInt(tempStr);
            ta.setCaretPosition(ta.getLineStartOffset(lineNumber - 1));
        } catch (Exception e) {
        }
    }
///////////////////////////////////

    public void saveOutput() throws IOException {
        String fn, dir, filename;
        FileDialog fd = new FileDialog(TheEmperor.this.f, "Save", FileDialog.SAVE);
        fd.show();
        if (fd.getFile() != null) {
            fn = fd.getFile();
            dir = fd.getDirectory();
            filename = dir + fn + ".pdf";
            System.out.println("file" + filename);
            try {
                Document pdfDoc = new Document();
                PdfWriter writer = PdfWriter.getInstance(pdfDoc, new FileOutputStream(filename));
                pdfDoc.open();
                String text = ta.getText();
                Paragraph preface = new Paragraph();
                //  Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                //   Font.BOLD);
                preface.add(new Paragraph(text));
                pdfDoc.add(preface);
                pdfDoc.close();
            } catch (Exception e) {
                System.out.println("File not found" + e);
            }
            ta.requestFocus();

        }
    }
///////////////////////////////////

    public void actionPerformed(ActionEvent ev) {
        String cmdText = ev.getActionCommand();
////////////////////////////////////
        if (cmdText.equals(fileNew)) {
            fileHandler.newFile();
        } else if (cmdText.equals(fileOpen)) {
            fileHandler.openFile();
        } ////////////////////////////////////
        else if (cmdText.equals(fileSave)) {
            fileHandler.saveThisFile();
        } ////////////////////////////////////
        else if (cmdText.equals(fileSaveAs)) {
            fileHandler.saveAsFile();
        } /////////////////////////////////////
        else if (cmdText.equals(fileSavePdf)) {
            try {
                saveOutput();
            } catch (Exception e) {
            }
        } ////////////////////////////////////
        else if (cmdText.equals(fileExit)) {
            if (fileHandler.confirmSave()) {
                System.exit(0);
            }
        } /////////////////////////////////////
        else if (cmdText.equals(filePrint)) {
            JOptionPane.showMessageDialog(
                    TheEmperor.this.f,
                    "Get your printer repaired first! It seems you dont have one!",
                    "Bad Printer",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } ////////////////////////////////////
        else if (cmdText.equals(editCut)) {
            ta.cut();
        } ////////////////////////////////////
        else if (cmdText.equals(editCopy)) {
            ta.copy();
        } ////////////////////////////////////
        else if (cmdText.equals(editPaste)) {
            ta.paste();
        } ////////////////////////////////////
        else if (cmdText.equals(editDelete)) {
            ta.replaceSelection("");
        } ////////////////////////////////////clear all
        else if (cmdText.equals(editClear)) {
            fileHandler.clearAll();
        } ////////////////////////////////////
        else if (cmdText.equals(editGoTo)) {
            if (ta.getText().length() == 0) {
                return;	// text box have no text
            }
            goTo();
        } ////////////////////////////////////
        else if (cmdText.equals(editSelectAll)) {
            ta.selectAll();
        } ////////////////////////////////////
        else if (cmdText.equals(editTimeDate)) {
            ta.insert(new Date().toString(), ta.getSelectionStart());
        } ////////////////////////////////////
        else if (cmdText.equals(formatWordWrap)) {
            JCheckBoxMenuItem temp = (JCheckBoxMenuItem) ev.getSource();
            boolean b = temp.isSelected();
            ta.setLineWrap(b);
        }
        ////////////////////////////////////
        else if (cmdText.equals(formatFont)) {
            if (fontDialog == null) {
                fontDialog = new FontChooser(ta.getFont());
            }

            if (fontDialog.showDialog(this.f, "Choose a font")) {
                ta.setFont(fontDialog.createFont());
            }
        } 
        ////////////////////////////////////
        else if (cmdText.equals(autoSpacing)) {
            String text = ta.getText();
            String str;
            BufferedReader reader = new BufferedReader(new StringReader(text));
            this.ta.setText("");
            try {
                while ((str = reader.readLine()) != null) {
                    //System.out.println(str);     
                    if (str.length() > 0) {
                        str = str.replaceAll("[,.!?;:]", "$0 ").replaceAll("\\s+", " ");
                    }
                    this.ta.append(str);
                    this.ta.append("\n");
                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }///////////////////////////////////
        else if (cmdText.equals(autoComplete)) {
            //ta.copy();
            int col = -1;
            AutoTextComplete atc = new AutoTextComplete(this.ta);
            if (col >= 0) {
                atc.setActiveColumn(col);
            }
            atc.setItems(new String[]{"if", "hello", "how", "are", "you", "I", "am", "fine", "teamasva", "saurya", "car", "while", "then", "else", "for", "continue", "const",
                "final", "do", "switch", "case", "int", "double", "float", "long", "import", "include",
                "public", "protected", "private", "static", "main", "void", "String", "class", "Before", "text", "editors", "existed", "computer",
                "text", "was", "punched", "into", "cards", "with", "keypunch", "machines", "Physical", "boxes", "of", "these", "thin", "cardboard", "cards", "were", "then",
                "inserted", "into", "a", "card-reader", "Magnetic", "tape", "and", "disk", "card-image", "files", "created", "from", "such", "card", "decks", "often", "had",
                "no", "line-separation", "characters", "at", "all", "and", "assumed", "fixed-length", "character", "records", "An", "alternative", "to", "cards", "was",
                "punched", "paper", "tape", "It", "could", "be", "created", "by", "some", "teleprinters", "which", "used", "special", "characters", "to", "indicate", "ends",
                "of", "records", "The", "first", "text", "editors", "were", "line", "editors", "oriented", "to", "teleprinter", "or", "typewriter", "style", "terminals", "without",
                "displays", "Commands", "effected", "edits", "to", "a", "file", "at", "an", "imaginary", "insertion", "point", "called", "the", "cursor", "When", "computer", "terminals",
                "with", "video", "screens", "became", "available", "screen-based", "text", "editors", "became", "common", "One", "of", "the", "earliest", "full-screen", "editors", "was",
                "which", "was", "written", "for", "the", "operator", "console", "of", "the", "CDC", "series", "computers", "in"});
        } ////////////////////////////////////
        else if (cmdText.equals(specialCharacter)) {
            Special obj1 = new Special(ta);
            obj1.setVisible(true);
        } ////////////////////////////////////
        else if (cmdText.equals(formatForeground)) {
            showForegroundColorDialog();
        } ////////////////////////////////////
        else if (cmdText.equals(formatBackground)) {
            showBackgroundColorDialog();
        } ////////////////////////////////////
        else if (cmdText.equals(viewStatusBar)) {
            JCheckBoxMenuItem temp = (JCheckBoxMenuItem) ev.getSource();
            statusBar.setVisible(temp.isSelected());
        } ////////////////////////////////////
        else if (cmdText.equals(helpAboutEmperor)) {
            JOptionPane.showMessageDialog(TheEmperor.this.f, aboutText, "About The Emperor", JOptionPane.INFORMATION_MESSAGE);
        } else {
            statusBar.setText("This " + cmdText + " command is yet to be implemented");
        }
    }//action Performed
////////////////////////////////////

    void showBackgroundColorDialog() {
        if (bcolorChooser == null) {
            bcolorChooser = new JColorChooser();
        }
        if (backgroundDialog == null) {
            backgroundDialog = JColorChooser.createDialog(TheEmperor.this.f,
                    formatBackground,
                    false,
                    bcolorChooser,
                    new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    TheEmperor.this.ta.setBackground(bcolorChooser.getColor());
                }
            },
                    null);
        }

        backgroundDialog.setVisible(true);
    }
////////////////////////////////////

    void showForegroundColorDialog() {
        if (fcolorChooser == null) {
            fcolorChooser = new JColorChooser();
        }
        if (foregroundDialog == null) {
            foregroundDialog = JColorChooser.createDialog(TheEmperor.this.f,
                    formatForeground,
                    false,
                    fcolorChooser,
                    new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    TheEmperor.this.ta.setForeground(fcolorChooser.getColor());
                }
            },
                    null);
        }

        foregroundDialog.setVisible(true);
    }

///////////////////////////////////
    JMenuItem createMenuItem(String s, int key, JMenu toMenu, ActionListener al) {
        JMenuItem temp = new JMenuItem(s, key);
        temp.addActionListener(al);
        toMenu.add(temp);

        return temp;
    }
////////////////////////////////////

    JMenuItem createMenuItem(String s, int key, JMenu toMenu, int aclKey, ActionListener al) {
        JMenuItem temp = new JMenuItem(s, key);
        temp.addActionListener(al);
        temp.setAccelerator(KeyStroke.getKeyStroke(aclKey, ActionEvent.CTRL_MASK));
        toMenu.add(temp);

        return temp;
    }
////////////////////////////////////

    JCheckBoxMenuItem createCheckBoxMenuItem(String s, int key, JMenu toMenu, ActionListener al) {
        JCheckBoxMenuItem temp = new JCheckBoxMenuItem(s);
        temp.setMnemonic(key);
        temp.addActionListener(al);
        temp.setSelected(false);
        toMenu.add(temp);

        return temp;
    }
////////////////////////////////////

    JMenu createMenu(String s, int key, JMenuBar toMenuBar) {
        JMenu temp = new JMenu(s);
        temp.setMnemonic(key);
        toMenuBar.add(temp);
        return temp;
    }

/////////////////////////////////////   
    void createMenuBar(JFrame f) {
        JMenuBar mb = new JMenuBar();
        JMenuItem temp;

        JMenu fileMenu = createMenu(fileText, KeyEvent.VK_F, mb);
        JMenu editMenu = createMenu(editText, KeyEvent.VK_E, mb);
        JMenu formatMenu = createMenu(formatText, KeyEvent.VK_O, mb);
        JMenu viewMenu = createMenu(viewText, KeyEvent.VK_V, mb);
        JMenu helpMenu = createMenu(helpText, KeyEvent.VK_H, mb);

        createMenuItem(fileNew, KeyEvent.VK_N, fileMenu, KeyEvent.VK_N, this);
        createMenuItem(fileOpen, KeyEvent.VK_O, fileMenu, KeyEvent.VK_O, this);
        //createMenuItem(fileOpenPdf, KeyEvent.VK_O, fileMenu, KeyEvent.VK_O, this);
        createMenuItem(fileSave, KeyEvent.VK_S, fileMenu, KeyEvent.VK_S, this);
        createMenuItem(fileSaveAs, KeyEvent.VK_A, fileMenu, this);
        createMenuItem(fileSavePdf, KeyEvent.VK_S, fileMenu, KeyEvent.VK_S, this);
        fileMenu.addSeparator();
        temp = createMenuItem(filePageSetup, KeyEvent.VK_U, fileMenu, this);
        temp.setEnabled(false);
        createMenuItem(filePrint, KeyEvent.VK_P, fileMenu, KeyEvent.VK_P, this);
        fileMenu.addSeparator();
        createMenuItem(fileExit, KeyEvent.VK_X, fileMenu, this);

        temp = createMenuItem(editUndo, KeyEvent.VK_U, editMenu, KeyEvent.VK_Z, this);
        temp.setEnabled(false);
        editMenu.addSeparator();
        cutItem = createMenuItem(editCut, KeyEvent.VK_T, editMenu, KeyEvent.VK_X, this);
        copyItem = createMenuItem(editCopy, KeyEvent.VK_C, editMenu, KeyEvent.VK_C, this);
        createMenuItem(editPaste, KeyEvent.VK_P, editMenu, KeyEvent.VK_V, this);
        deleteItem = createMenuItem(editDelete, KeyEvent.VK_L, editMenu, this);
        deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        editMenu.addSeparator();
        clearItem = createMenuItem(editClear, KeyEvent.ALT_DOWN_MASK, editMenu, KeyEvent.ALT_DOWN_MASK, this);
        replaceItem = createMenuItem(editReplace, KeyEvent.VK_R, editMenu, KeyEvent.VK_H, this);
        gotoItem = createMenuItem(editGoTo, KeyEvent.VK_G, editMenu, KeyEvent.VK_G, this);
        editMenu.addSeparator();
        selectAllItem = createMenuItem(editSelectAll, KeyEvent.VK_A, editMenu, KeyEvent.VK_A, this);
        createMenuItem(editTimeDate, KeyEvent.VK_D, editMenu, this).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

        createCheckBoxMenuItem(formatWordWrap, KeyEvent.VK_W, formatMenu, this).setSelected(true);
        createMenuItem(autoSpacing, KeyEvent.VK_W, formatMenu, this);
        auto = createMenuItem(autoComplete, KeyEvent.VK_A, formatMenu, this);
        createMenuItem(formatFont, KeyEvent.VK_F, formatMenu, this);
        createMenuItem(specialCharacter, KeyEvent.VK_W, formatMenu, this);

        formatMenu.addSeparator();
        createMenuItem(formatForeground, KeyEvent.VK_T, formatMenu, this);
        createMenuItem(formatBackground, KeyEvent.VK_P, formatMenu, this);

        createCheckBoxMenuItem(viewStatusBar, KeyEvent.VK_S, viewMenu, this).setSelected(true);
        LookAndFeelMenu.createLookAndFeelMenuItem(viewMenu,this.f);
        temp = createMenuItem(helpHelpTopic, KeyEvent.VK_H, helpMenu, this);
        temp.setEnabled(false);
        helpMenu.addSeparator();
        createMenuItem(helpAboutEmperor, KeyEvent.VK_A, helpMenu, this);

        MenuListener editMenuListener = new MenuListener() {
            public void menuSelected(MenuEvent ev) {
                if (TheEmperor.this.ta.getText().length() == 0) {
                    replaceItem.setEnabled(false);
                    selectAllItem.setEnabled(false);
                    gotoItem.setEnabled(false);
                } else {

                    replaceItem.setEnabled(true);
                    selectAllItem.setEnabled(true);
                    gotoItem.setEnabled(true);
                }
                if (TheEmperor.this.ta.getSelectionStart() == ta.getSelectionEnd()) {
                    cutItem.setEnabled(false);
                    copyItem.setEnabled(false);
                    deleteItem.setEnabled(false);
                } else {
                    cutItem.setEnabled(true);
                    copyItem.setEnabled(true);
                    deleteItem.setEnabled(true);
                }
            }

            public void menuDeselected(MenuEvent evt) {
            }

            public void menuCanceled(MenuEvent evt) {
            }
        };
        editMenu.addMenuListener(editMenuListener);
        f.setJMenuBar(mb);
    }

////////////////////////////////////
    public static void main(String[] s) {
        new TheEmperor();
    }
}

////////////////////////
interface MenuConstants {

    final String fileText = "File";
    final String editText = "Edit";
    final String formatText = "Format";
    final String viewText = "View";
    final String helpText = "Help";

    final String fileNew = "New";
    final String fileOpen = "Open...";
    final String fileSave = "Save";
    final String fileSaveAs = "Save As...";
    final String fileSavePdf = "Save Pdf";
    final String filePageSetup = "Page Setup...";
    final String filePrint = "Print";
    final String fileExit = "Exit";

    final String editUndo = "Undo";
    final String editCut = "Cut";
    final String editCopy = "Copy";
    final String editPaste = "Paste";
    final String editDelete = "Delete";
    final String editClear = "Clear";

    final String editReplace = "Replace";
    final String editGoTo = "Go To...";
    final String editSelectAll = "Select All";
    final String editTimeDate = "Time/Date";

    final String formatWordWrap = "Word Wrap";
    final String autoSpacing = "Autospace...";
    final String autoComplete = "Autocomplete...";
    final String specialCharacter = "Special Character";
//final String formatPdf="Format Pdf";
    final String formatFont = "Font...";
    final String formatForeground = "Set Text color...";
    final String formatBackground = "Set Pad color...";

    final String viewStatusBar = "Status Bar";

    final String helpHelpTopic = "Help Topic";
    final String helpAboutEmperor = "About TheEmperor";

    final String aboutText
            = "<html><big>THE EMPEROR</big><hr><hr>"
            + "<p align=right>PREPARED BY SauryaPande!"
            + "<hr><p align=left><br>"
            + "<strong><b><i><font size=+1>The Emperor is a modern,easy-to-use,text editor for </font></i></b</strong><br>"
            + "<strong><b><i><font size=+1>word processing.</font></i></b</strong><br>"
            + "<hr>Your comments as well as bug reports are very welcome at:<p align=center>"
            + "<em><big>sauryapande@gmail.com</big></em><hr><html>";
}

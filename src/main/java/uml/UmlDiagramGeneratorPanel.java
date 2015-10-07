package uml;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * 
 */
@SuppressWarnings("serial")
public class UmlDiagramGeneratorPanel extends JPanel {
  public UmlDiagramGeneratorPanel(JFrame frame) {
    this.frame = frame;
    setLayout(new BorderLayout());

    JLabel titleLabel = new JLabel("UML Diagram Genarator for Java");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 30));

    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new BorderLayout());
    titlePanel.add(titleLabel, BorderLayout.CENTER);
    add(titlePanel, BorderLayout.PAGE_START);
    
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    add(mainPanel, BorderLayout.CENTER);
    
    JPanel startPanel = new JPanel();
    startPanel.setBorder(BorderFactory.createTitledBorder(
        "Please enter Java class name to display in the UML diagram."));
    startPanel.setLayout(new BorderLayout());
    mainPanel.add(startPanel, BorderLayout.PAGE_START);
    
    classTextField = new JTextField(40);
    classTextField.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        UmlDiagramGeneratorPanel.this.addClass();
      }
    });
    JButton clearClassButton = new JButton("Clear");
    JButton addClassButton = new JButton("Add Class");

    clearClassButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        classTextField.setText("");
      }
    });
    addClassButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        UmlDiagramGeneratorPanel.this.addClass();
      }
    });
   
    JButton exitButton = new JButton("Exit");
    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        UmlDiagramGeneratorPanel.this.exit();
      }
    });
    
    startPanel.add(classTextField, BorderLayout.CENTER);
    JPanel addButtonsPanel = new JPanel();
    addButtonsPanel.setLayout(new GridLayout(1, 2));
    addButtonsPanel.add(clearClassButton);
    addButtonsPanel.add(addClassButton);
    startPanel.add(addButtonsPanel, BorderLayout.LINE_END);

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(2, 0));
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    
    classListModel = new DefaultListModel<String>();
    JList<String> classList = new JList<String>(classListModel);
    classList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    classList.setLayoutOrientation(JList.VERTICAL);
    classList.setVisibleRowCount(-1);
    JScrollPane listScroller = new JScrollPane(classList);
   
    JButton removeButton = new JButton("Remove Selected Class");
    removeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (classList.getSelectedIndex() != -1 &&
            classList.getSelectedIndex() < classList.getModel().getSize()) {
          classListModel.remove(classList.getSelectedIndex());
        }
      }
    });
   
    JButton clearButton = new JButton("Clear All Classes");
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        classListModel.removeAllElements();
      }
    });
    
    JPanel listButtonsPanel = new JPanel();
    listButtonsPanel.setLayout(new FlowLayout());
    listButtonsPanel.add(removeButton);
    listButtonsPanel.add(clearButton);
    
    JPanel listPanel = new JPanel();
    listPanel.setLayout(new BorderLayout());
    listPanel.add(listScroller, BorderLayout.CENTER);
    listPanel.add(listButtonsPanel, BorderLayout.PAGE_END);
   
    centerPanel.add(listPanel);
    
    JPanel optionsPanel = new JPanel();
    optionsPanel.setLayout(new GridLayout(0, 2));
    centerPanel.add(optionsPanel);
    
    JPanel matcherPanel = new JPanel();
    matcherPanel.setLayout(new GridLayout(11, 0));
    optionsPanel.add(matcherPanel);

    // TODO: radio
    JRadioButton classMatcherButton
        = new JRadioButton("Only show input classes.");
    JRadioButton packageMatcherButton
        = new JRadioButton("Only show classes in the same packages as input classes.");
    packageMatcherButton.setSelected(true);
    JRadioButton allPackageMatcherButton
        = new JRadioButton("Show classes from all packages.");
   
    ButtonGroup packageButtonGroup = new ButtonGroup();
    packageButtonGroup.add(classMatcherButton);
    packageButtonGroup.add(packageMatcherButton);
    packageButtonGroup.add(allPackageMatcherButton);
    
    JPanel packageButtonsPanel = new JPanel();
    //packageButtonsPanel.setLayout(new GridLayout(2, 0));
    //packageButtonsPanel.setBorder(
    //    BorderFactory.createTitledBorder("Select Packages to show."));
    matcherPanel.add(classMatcherButton);
    matcherPanel.add(packageMatcherButton);
    matcherPanel.add(allPackageMatcherButton);
    matcherPanel.add(packageButtonsPanel);
   
    JCheckBox publicMatcherButton = new JCheckBox("Only show public classes / fields / methods.");
    JCheckBox filterFieldsButton = new JCheckBox("Do not show fields.");
    JCheckBox filterMethodsButton = new JCheckBox("Do not show methods.");
    JCheckBox filterFieldTypeButton = new JCheckBox("Do not pull in classes appear as field types.");
    JCheckBox filterMethodReturnTypeButton =
        new JCheckBox("Do not pull in classes appear as method return types.");
    JCheckBox filterMethodParameterTypesButton =
        new JCheckBox("Do not pull in classes appear as method parameter types.");
    JCheckBox filterAnnotationButton =
        new JCheckBox("Do not show annotations.");

    matcherPanel.add(publicMatcherButton); 
    matcherPanel.add(filterFieldsButton);
    matcherPanel.add(filterMethodsButton);
    matcherPanel.add(filterFieldTypeButton);
    matcherPanel.add(filterMethodReturnTypeButton);
    matcherPanel.add(filterMethodParameterTypesButton);
    matcherPanel.add(filterAnnotationButton);
    
    JPanel colorPanel = new JPanel();
    colorPanel.setLayout(new GridLayout(12, 0));
    optionsPanel.add(colorPanel);
    
    List<UmlClassDiagramPalette> palettes = Arrays.asList(
        UmlClassDiagramPalette.YELLOW_HEADER,
        UmlClassDiagramPalette.YELLOW,
        UmlClassDiagramPalette.YELLOW_THEME,
        UmlClassDiagramPalette.CYAN_HEADER,
        UmlClassDiagramPalette.CYAN,
        UmlClassDiagramPalette.CYAN_THEME,
        UmlClassDiagramPalette.BLUE_HEADER,
        UmlClassDiagramPalette.BLUE,
        UmlClassDiagramPalette.BLUE_THEME,
        UmlClassDiagramPalette.RED_HEADER,
        UmlClassDiagramPalette.RED,
        UmlClassDiagramPalette.RED_THEME);
    
    List<JRadioButton> paletteButtons = Arrays.asList(
        new JRadioButton("Yellow Header"),
        new JRadioButton("Yellow Solid"),
        new JRadioButton("Yellow Theme"),
        new JRadioButton("Cyan Header"),
        new JRadioButton("Cyan Solid"),
        new JRadioButton("Cyan Theme"),
        new JRadioButton("Blue Header"),
        new JRadioButton("Blue Solid"),
        new JRadioButton("Blue Theme"),
        new JRadioButton("Red Header"),
        new JRadioButton("Red Solid"),
        new JRadioButton("Red Theme"));
   
    // Add border
    ButtonGroup paletteButtonGroup = new ButtonGroup();
    for (JRadioButton button : paletteButtons) {
      colorPanel.add(button);
      paletteButtonGroup.add(button);
    }
    paletteButtons.get(0).setSelected(true);
    
    JButton generateButton = new JButton("Generate UML Diagram");
    generateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<String> classes = listFromModel(classListModel);
        UmlMatcher matcher = new AllUmlMatcher();
        if (classMatcherButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlClassMatcher(classes));
        }
        if (packageMatcherButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, UmlPackageMatcher.createFromClasses(classes));
        }
        if (publicMatcherButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlPublicMatcher());
        }
        if (filterFieldsButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlFieldFilter());
        }
        if (filterMethodsButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlMethodFilter());
        }
        if (filterFieldTypeButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlFieldTypeFilter());
        }
        if (filterMethodReturnTypeButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlMethodReturnTypeFilter());
        }
        if (filterMethodParameterTypesButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlMethodParameterTypesFilter());
        }
        if (filterAnnotationButton.isSelected()) {
          matcher = new AndUmlMatcher(matcher, new UmlAnnotationFilter());
        }
    
        DotUmlClassDiagramStyle style = new DefaultDotUmlClassDiagramStyle();
        for (int i = 0; i < paletteButtons.size(); i++) {
          if (paletteButtons.get(i).isSelected()) {
            style = new ColoredDotUmlClassDiagramStyle(palettes.get(i));
            break;
          }
        }
        UmlDiagramGeneratorPanel.this.generateUmlDiagram(matcher, style);
      }
    });
   
    JPanel endPanel = new JPanel();
    endPanel.setLayout(new FlowLayout());
    endPanel.add(generateButton);
    mainPanel.add(endPanel, BorderLayout.PAGE_END);
  }

  protected void addClass() {
    String className = classTextField.getText();
    if (className.isEmpty()) {
      JOptionPane.showMessageDialog(
          frame,
          "Please enter a class name.",
          "Error",
          JOptionPane.ERROR_MESSAGE);
      return;     
    }
    if (classListModel.contains(className)) {
      JOptionPane.showMessageDialog(
          frame,
          String.format("Class %s is already added.", className),
          "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }
    try {
      Class.forName(className);
    } catch (ClassNotFoundException | NoClassDefFoundError e) {
      JOptionPane.showMessageDialog(
          frame,
          String.format("Class %s is not found.", className),
          "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }
    classListModel.addElement(className);
    classTextField.setText("");
  }

  private List<String> listFromModel(DefaultListModel<String> model) {
    List<String> list = new ArrayList<String>();
    for (Object c : model.toArray()) {
      list.add((String) c);
    }
    return list;
  }
  
  protected void generateUmlDiagram(UmlMatcher matcher, DotUmlClassDiagramStyle style) {
    List<String> classes = listFromModel(classListModel);
    UmlClassDiagramGenerator generator = new UmlClassDiagramGenerator();
    generator.setUmlMatcher(matcher);
    generator.setStyle(style);
    try {
      generator.generate(classes);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(
          frame,
          String.format("Failed to generate UML diagram."),
          "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }
  
  private void reset() {
    int response = JOptionPane.showConfirmDialog(
        frame,
        "Are you sure to reset UmlDiagramGenerator?",
        "Confirmation",
        JOptionPane.YES_NO_OPTION);
    if (response != 0) {
      return;
    }
  }
  
  private void exit() {
    int response = JOptionPane.showConfirmDialog(
        frame,
        "Are you sure to exit UmlDiagramGenerator?",
        "Confirmation",
        JOptionPane.YES_NO_OPTION);
    if (response == 0) {
      frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }    
  }
  
  JFrame frame;
  JTextField classTextField;
  DefaultListModel<String> classListModel;
}


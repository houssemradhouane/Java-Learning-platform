import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JComponent.*;
import javax.swing.JFileChooser;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * 
 * @author Youssef MINYARI et Othmane MOKRANE
 *
 */
public class RemplirCodeFrame extends JPanel{
	Object reponse;
	JLabel exerciceLabel, codeSaisi;
	JTextArea zoneCode;
	JButton soumettre;
	
	static boolean next = false;
	static int score = 0;
	
	static JLabel timer = new JLabel ("00 : 00 : 000") ;
	static Compteur count = new Compteur ();
	
	RemplirCodeFrame(RemplirCode exercice, JFrame fenetre) {
		exerciceLabel = new JLabel(exercice.getQuestion());
		reponse = exercice.getReponse();
		soumettre = new JButton("Soumettre");
		codeSaisi = new JLabel("Code:");
		zoneCode = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(zoneCode);
		fenetre.add(scrollPane);
		JPanel panel = new JPanel();
		panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.setBackground(Color.DARK_GRAY);
        fenetre.setContentPane(panel);
        setLayout(null);
        setBackground(Color.getHSBColor(154, 254, 25));
        setBounds(100,90,600,300);
        //setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(this);
        add(exerciceLabel); add(zoneCode); add(codeSaisi); add(soumettre);
        exerciceLabel.setBounds(40,8,520,50);
        exerciceLabel.setBorder(new LineBorder(Color.blue, 2, true));
        exerciceLabel.setHorizontalAlignment(JLabel.CENTER);
        codeSaisi.setBounds(50,80,100,30);
        codeSaisi.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED)); 
        zoneCode.setBounds(200,80,300,150);
        zoneCode.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        soumettre.setBounds(160,240,100,40);
        soumettre.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        timer.setBounds(250,420,300,30);
        timer.setFont(new Font("Verdana", Font.BOLD, 40));
        timer.setHorizontalAlignment(JLabel.CENTER);
        timer.setBorder(BorderFactory.createLineBorder(Color.white));
        timer.setForeground(Color.white);
        panel.add(timer);
        fenetre.setVisible(true);
        System.out.println(zoneCode.getText());
	}
	

	void getCode (int time) throws InterruptedException {
		class StringJavaFileObject extends SimpleJavaFileObject {
		    private final String code;

		    public StringJavaFileObject(String name, String code) {
		      super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),
		          Kind.SOURCE);
		      this.code = code;
		    }

		    @Override
		    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		      return code;
		    }
		  }

		  class ClassJavaFileObject extends SimpleJavaFileObject {
		    private final ByteArrayOutputStream outputStream;
		    private final String className;

		    protected ClassJavaFileObject(String className, Kind kind) {
		      super(URI.create("mem:///" + className.replace('.', '/') + kind.extension), kind);
		      this.className = className;
		      outputStream = new ByteArrayOutputStream();
		    }

		    @Override
		    public OutputStream openOutputStream() throws IOException {
		      return outputStream;
		    }

		    public byte[] getBytes() {
		      return outputStream.toByteArray();
		    }

		    public String getClassName() {
		      return className;
		    }
		  }

		  @SuppressWarnings("rawtypes")
		class SimpleJavaFileManager extends ForwardingJavaFileManager {
		    private final List<ClassJavaFileObject> outputFiles;

		    @SuppressWarnings("unchecked")
			protected SimpleJavaFileManager(JavaFileManager fileManager) {
		      super(fileManager);
		      outputFiles = new ArrayList<ClassJavaFileObject>();
		    }

		    @Override
		    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
		      ClassJavaFileObject file = new ClassJavaFileObject(className, kind);
		      outputFiles.add(file);
		      return file;
		    }

		    public List<ClassJavaFileObject> getGeneratedOutputFiles() {
		      return outputFiles;
		    }
		  }

		  class CompiledClassLoader extends ClassLoader {
		    private final List<ClassJavaFileObject> files;

		    private CompiledClassLoader(List<ClassJavaFileObject> files) {
		      this.files = files;
		    }

		    @Override
		    protected Class<?> findClass(String name) throws ClassNotFoundException {
		      Iterator<ClassJavaFileObject> itr = files.iterator();
		      while (itr.hasNext()) {
		        ClassJavaFileObject file = itr.next();
		        if (file.getClassName().equals(name)) {
		          itr.remove();
		          byte[] bytes = file.getBytes();
		          return super.defineClass(name, bytes, 0, bytes.length);
		        }
		      }
		      return super.findClass(name);
		    }
		  }
		
	       soumettre.addActionListener((ActionEvent e) -> {
	    	    /*File codeFile = new File("code.txt");
	   			BufferedWriter outFile;
					try {
						outFile = new BufferedWriter(new FileWriter(codeFile));
						outFile.write(zoneCode.getText());
						outFile.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}*/
				String codeString = zoneCode.getText();
				//System.out.println(codeString);
				JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

			    JavaFileObject compilationUnit =
			        new StringJavaFileObject("CodeGenTest", codeString);

			    SimpleJavaFileManager fileManager =
			        new SimpleJavaFileManager(compiler.getStandardFileManager(null, null, null));

			    JavaCompiler.CompilationTask compilationTask = compiler.getTask(
			        null, fileManager, null, null, null, Arrays.asList(compilationUnit));

			    compilationTask.call();

			    CompiledClassLoader classLoader =
			        new CompiledClassLoader(fileManager.getGeneratedOutputFiles());

			    Class<?> codeGenTest;
				try {
					codeGenTest = classLoader.loadClass("CodeGenTest");
					//Method main = codeGenTest.getMethod("main", String[].class);
					Method somme = codeGenTest.getMethod("somme", int.class, int.class);
					Object resultat = somme.invoke(null, new Object[]{null});
					if (resultat.equals(reponse)) {
						System.out.println("Success");
					}
					
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
	           //if (resultat.equals(reponse)) score++ ;  
	           //next = true ;
	       });

	       
	       while (next == false ) {
	           
	           timer.setText(String.format("%02d", count.M)+" : "+String.format("%02d", count.S)+" : "+String.format("%03d", count.Ms)); 
	              count.Ms++ ;
	              Thread.sleep(1);
	              if (count.Ms==999){
	                  count.S++ ;
	                  count.Ms=0 ;
	              }
	              if (count.S==59){
	                  count.M++ ;
	                  count.S=0;
	              }
	              
	              if ((count.S + count.M*60) > time-3 ) {
	                  
	                  timer.setForeground(Color.red);
	                  
	                       if ((count.S + count.M*60)==time) { 
	                           return ;
	                       }
	              }
	       
	       } 
	   next = false ;

	}

	int getScore() {return score ;}
	Compteur getTime() {return count ;}
	void Reset() {
	    count.M=0 ; 
	    count.Ms=0 ; 
	    count.S=0;
	    score = 0 ;
	}
}

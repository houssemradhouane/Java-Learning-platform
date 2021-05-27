/*
Construires les questions pour les test */
public class Quizs {
        /* Construire les Qcm du jeu */
	public Qcm[] quizQcm() {
		Qcm [] quiz_All = {
	    		
	    		new Qcm("Quel le type par défaut de 3.75 ","int","double","float","short","double"),
	    		new Qcm("<html>Que renvoie le code suivant <br>class Main {   \n" + 
	    				"     <br>  public static void main(String args[]) {      \n" + 
	    				"      <br>        int t;      \n" + 
	    				"      <br>        System.out.println(t); \n" + 
	    				"     <br>  }   \n" + 
	    				"<br>}","0","garbage error","runtime error","compiler error","compiler error"),
	    		new Qcm("<html>Quelle est la taille en bits d'une<br>variable int","64","32","4","16","32"),
	    		new Qcm("<html>Quel est le type du codage <br>de carctères utilisé en Java</html>","UNICODE","ASCII","ISO-LATIN-1","Autre","UNICODE"),
	    		
	    		new Qcm("<html>Que renvoie le code suivant ?\r\n"+
	    		"<br> String s = \"Java String Quiz\";" +
	    				"<br> System.out.println(s.substring(5,3));</html>","Str","Runtime Exception",
	    				"IndexOutOfBoundsException Runtime Exception","StringIndexOutOfBoundsException Compile-time error","Runtime Exception"),
	    		new Qcm("<html>Que renvoie le code suivant ?\r\n"+
	    				"<br> String s1 = \"abc\";\n" + 
	    				"<br> String s2 = \"def\";\n" + 
	    				"<br> System.out.println(s1.compareTo(s2)); </html>","0","true","-3","false","-3"),
	    		new Qcm("<html> Combien de string crées dans le code suivant ?" +
	    				"<br> String s = \"abc\";\n" + 
	    				"<br> String s1 = new String(\"abcd\")</html>","1","2","3","4","3"),
	    		new Qcm("<html>String s1 = \"Cat\";\n" + 
	    				"<br>String s2 = \"Cat\";\n" + 
	    				"<br>String s3 = new String(\"Cat\");\n" + 
	    				"<br>System.out.print(s1 == s2);\n" + 
	    				"<br>System.out.print(s1 == s3);</html>","truetrue","falsetrue","truefalse","falsefalse","truefalse"),

	    		
	    		new Qcm("<html>Que renvoie le code suivant ?\r\n"+
	    				"<br> int [ ] a = new int [5];\n" + 
	    				"<br> a[0] = 5; a[1] = 4; a[2] = 3;\n" +
	    				
	    				"<br> System.out.print(a[0] + a[1] + a[4]); </html>","9","5 3 1","5 3 0","8","9"),
	    		new Qcm("<html>Qu'affiche le code suivant ?\r\n" + 
	            		"  <br>   int [ ] odd = {1, 3, 5, 7, 9, 11 };\r\n" + 
	            		"   <br>  System.out.println( odd[0] + \"  \" + odd[3] ) ; <br>","17","8","1 7","1 5","1 7"),
	    		new Qcm("<html>Que renvoie le code suivant ?\r\n"+
	    				" <br>  String [ ] name = { \"Joe\", \"Sue\", \"Tom\", \"Jill\", \"Patty\"};\n" + 
	    				" <br<      for (int i = 0; i < name.length; i = i + 2)\n" + 
	    				"  <br>         System.out.print(name[i] + \" \");","Joe Sue Tom Jill Patty","Patty Jill Tom Sue Joe",
	    				"Joe Tom Patty","Sue Jill","Joe Tom Patty"),
	    		new Qcm("<html> int [ ] dedo = { 1, 3, 6, 9, 2, 5, 7};\n" + 
	    				" <br>      int que = dedo[0];\n" + 
	    				" <br>     for (int k = 0; k < dedo.length; k++)\n" + 
	    				"  <br>    {\n" + 
	    				" <br>         if (dedo[k] < que)\n" + 
	    				"   <br>          que = dedo[k];\n" + 
	    				"   br>    }\n" + 
	    				"   <br>   System.out.print(que);</html>","1","2","1 3 6 9 2 5 7","7","1 3 6 9 2 5 7"),

	    	
	    		
	            new Qcm("<html>La méthode qui affiche la liste des" +
	    				"<br> des méthode appellées avant la levée d'une exception ?","printErrors()","traceStack()","getMessage()","printStackTrace","printStackTrace"),
	            new Qcm("Quelle est la classe mère des exceptions ?","Objet","Comparable","Throwable","Iterable","Throwable"),
	            new Qcm("<html>Quel est le handler qui<br> récupère l'exception quand y'a pas<br>"
	            		+ "de catch ?</html>","default handler","finally","throw handler","Java run time system","default handler"),
	            new Qcm("<html>Quelle est la méthode des exceptions<br>qui retourne un message string ?</html>","printMessage()","getMessage()","getError()","traceMessage()","getMessage()"),

	            new Qcm("De quel classe la méthode toString est héritée ?","Objet","Comparable","throwable","Iterable","Objet"),
	            new Qcm("<html>Which of the following declares an array of<br>integers named number?<br>","int number ;","int [ ] number ;","int new number [ ] ;","int number = int [ ] ;","int [ ] number ;"),
	            new Qcm("<html>Quel est le type de données utilisé<br>par les Sets pour stoquer les élements ?</html>","Array","Map","ArrayList","Object","Map"),
	            new Qcm("<html>Quelle type de données il faut utiliser"
	            		+ "<br> pour que l'itérateur affiche"
	            		+ "<br> les éléments dans leurs ordre"
	            		+ "<br> d'insertion  ?</html>","LinkedHashSet","TreeSet","HashSet","HashMap","LinkedHashSet")
	           
	        };
		return quiz_All; 
	}
        /* Construire les Qrc du jeu */
	public Qrc[] quizQrc() {
		Qrc [] qrcs= { new Qrc("La taille d'une variable float ?","32"),
				new Qrc("Que renvoie (char)65 ?","A"),
				new Qrc("Classe parente de toute les classe ?","Objet"),
     		   new Qrc("<html> Que renvoie le code suivant :"+
        "<br> String s = \"Java\"+1+2+\"Quiz\"+\"\"+(3+4);\n" + 
        "<br> System.out.println(s); </html>","Java12Quiz7"),
     		   new Qrc("varible final ?","constante"),
     		   new Qrc("<html>La capacité par défaut de type ArrayList?</html>","10")
        };
		return qrcs;
	}


}

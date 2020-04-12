package files_and_regex;

/**
 * Files & RegularExpressions example script 
 * Exercises 16-19, page 386 Think in Java (4th edition) - Bruce Eckel
 * @author feBueno
 */

import net.mindview.util.TextFile;
import java.io.File;
import java.util.regex.*;
import net.mindview.util.*;
import static net.mindview.util.Print.print;

public class PatternsInFiles {
	 /**
	  * Provided in command line a directory/file path and a Regular Expression, prints:
	  * file, line, match and position in line were each match started.
	  * 
	  * @param args: String: directory/file path; String: Regular Expression
	  * 
	  * Example1, print words that start with [Ssct]: ./src/files_and_regex/PatternsInFiles.java "\b[Ssct]\w+"
	  * Example2, print comments: ./src/files_and_regex/PatternsInFiles.java "(\/\*.)|(\s\*\s.+)|(\/{2,}?.+)|(\s\*\/)|(\s\*\s)"
	  * Example3, print String literals: ./src/files_and_regex/PatternsInFiles.java "\"(.*?)\""
	  * Example4, print class names: ./src/files_and_regex/PatternsInFiles.java "(?<=class\s)(.*)(?=\{)"
	  */
	static void printlines(String filename, int fileindex, int lineindex, Matcher m) {
	    for(String line : new TextFile(filename)) {
	    	  lineindex++;
		      m.reset(line);
		      while(m.find())
		        System.out.println("f"+fileindex + ": " + "L"+lineindex + ": " +
		          m.group() + ": " + m.start());
		    }
	}
	
 public static void main(String[] args) throws Exception {
	    if(args.length < 2) {
	      System.out.println("Usage: java JGrep file regex");
	      System.exit(0);
	    }
	    Pattern p = Pattern.compile(args[1]);
	    // Iterate through the lines of the input file:
	    int fileindex = 1;
	    int lineindex = 0;
	    Matcher m = p.matcher("");
		File[] files = new File(args[0]).listFiles();
		if(files!=null) {//if argument is a directory
			for(File f:files) {
				print("--------"+f.toString()+"--------");
				printlines(f.toString(),fileindex++,lineindex,m);
			}
		} else {//if argument is a file
			printlines(args[0],fileindex, lineindex,m);
		}
	  }
} 
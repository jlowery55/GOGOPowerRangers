import java.util.*;
import java.io.*;

public class FastaFunctionPrediction {
  
  public static void main(String[] args) throws FileNotFoundException {
    Map<String, Map<String, Double>> sequenceMap = new HashMap<String, Map<String, Double>>();
    String fileName = "result.txt";
    Scanner input = new Scanner(new File(fileName));
    
    String res = "res.txt";
    PrintStream fin = new PrintStream(new File(res));
    
    
    Map<String, String> functionToGoTerm = new HashMap<String, String>();
    String goTermsFile = "F_3_GO_table.txt";
    Scanner populateGoTerms = new Scanner(new File(goTermsFile));
    while(populateGoTerms.hasNext()){
      String goTerm = populateGoTerms.next();
      String function = populateGoTerms.next();
      functionToGoTerm.put(function, goTerm);
    }
    
    
    while(input.hasNext()){
     // String line = input.nextLine();
      
      String seq = input.next();
      String func = input.next();
      double prob = input.nextDouble();
      
      Map<String, Double> funcToProb = new HashMap<String, Double>();
      if(sequenceMap.containsKey(seq)) {
        funcToProb = sequenceMap.get(seq);
      }
      funcToProb.put(func, prob);
      sequenceMap.put(seq, funcToProb);
    }
  //  System.out.print(sequenceMap);
 
    String fasta = "selected.fasta";
    Scanner fastaInput = new Scanner(new File(fasta));
    
    Set<String> sequenceSet = new HashSet<String>();
    String wordNames = "New_Balanced_FragDATABASE_34567_top2000.txt";
    Scanner inWord = new Scanner(new File(wordNames));
    while(inWord.hasNextLine()) {
    	String seq = inWord.nextLine();
    	//String seqWord = seq,next();
    	sequenceSet.add(seq);
    }
    // set that will contain all sequence words
    while(fastaInput.hasNextLine()){
      String name = fastaInput.nextLine();
      String seq = fastaInput.nextLine();
      
      List<String> words = new ArrayList<String>();
      for(int i = 0; i < seq.length() - 4; i++){
        String small = seq.substring(i, i+3);
        String large = seq.substring(i, i+4);
        
        if(sequenceSet.contains(small)) {
          words.add(small);
        }
        if(sequenceSet.contains(large)) {
          words.add(large);
        }
      }
      //System.out.println(sequenceSet);
      
      Map<String, Double> functionTotalProb = new HashMap<String, Double>();
      for(int i = 0; i < words.size(); i++){
        String word = words.get(i);
        Map<String, Double> map = sequenceMap.get(word);
        for(String func : map.keySet()){
          if(functionTotalProb.containsKey(func)){
            double prob = functionTotalProb.get(func);
            double newProb = map.get(func);
            functionTotalProb.put(func, prob + newProb);
          } else {
            double newProb = map.get(func);
            functionTotalProb.put(func, newProb);
          }
        }
      }
      String outFile = "help.txt";
      PrintStream out = new PrintStream(new File(outFile));
      System.setOut(out);
      
      for(String func : functionTotalProb.keySet()) {
        double prob = functionTotalProb.get(func);
        System.out.println(prob + " " + func);
      }
      
      String inFile = "help.txt";
      Scanner in = new Scanner(new File(inFile));
      
      Map<Double, String> result = new TreeMap<Double, String>();
      while(in.hasNext()){
        double probA = in.nextDouble();
        String function = in.next();
        result.put(probA, function);
      }
 
      System.setOut(fin);
      int i = 0;
      for(double value : result.keySet()){
        i++;
        String fun = result.get(value);
        System.out.println(fun + " " + value);
        if(i == 10) {
          break;
        }
      }
        //declare this at the beginning, overwrites each sequence, only saving the last sequence
        //weight probabilities
        //swap function word for GO Terms
        //add fasta sequence names
        //format output correctly for Cao's prediction too
      }
    }
  }

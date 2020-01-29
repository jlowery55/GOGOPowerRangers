import java.util.*;
import java.io.*;

public class PredictionScript {
  
  public static void main(String[] args) throws new FileNotFoundException {
    Map<String, Map<String, Double>> sequenceMap = new HashMap<String, Map<String, Double>>();
    String fileName = "result.txt";
    Scanner input = new Scanner(new File(fileName));
    
    while(input.hasNextLine()){
      String line = input.nextLine();
      
      String seq = input.next();
      String func = input.next();
      double prob = input.nextDouble();
      
      Map<String, Double> funcToProb = new HashMap<String, Double>();
      if(sequenceMap.containsKey(seq)) {
        funcToProb = sequenceMap.get(seq);
      }
      funcToProb.add(func, prob);
      sequenceMap.add(seq, funcToProb);
    }
    
    String fasta = "selected.fasta";
    Scanner fastaInput = new Scanner(new File(fasta));
    
    Set<String> sequenceSet = new HashSet<String>(); // set that will contain all sequence words
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
      Map<String, Double> functionTotalProb = new HashMap<String, Double>();
      for(int i = 0; i < words.size(); i++){
        String word = words.get(i);
        Map<String, Double> map = sequenceMap.get(seq);
        for(String func : map.keySet()){
          if(functionTotalProb.containsKey(func)){
            double prob = functionTotalProb.get(func);
            double newProb = map.get(func);
            functionTotalProb.put(func, prop + newProb);
          } else {
            double newProb = map.get(func);
            functionTotalProb.put(func, newProb);
          }
        }
      }
      String outFile = "help.txt";
      PrintStream out = new PrintStream(new File(outFile));
      System.setOut(out);
      
      for(String func : functionTotalProb.keySet)) {
        double prob = funcitonTotalProb.get(func);
        System.out.println(prob + " " + func);
      }
      
      String inFile = "help.txt";
      Scanner in = new Scanner(new File(inFile));
      
      Map<double, String> result = new TreeMap<double, String>();
      while(in.hasNextLine()){
        double proba = in.nextDouble();
        String function = in.next();
        result.add(proba, function);
      }
      
      String res = "res.txt";
      PrintStream fin = new PrintStream(new File(res));
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
      
    }
    
    
    
  }
}

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
    
    Map<String, String> inputSequences = new HashMap<String, String>();
    while(fastaInput.hasNextLine()){
      String name = fastaInput.nextLine();
      String seq = fastaInput.nextLine();
      
      inputSequences.put(name, seq);
    }
    
    
  }
}

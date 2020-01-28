public class PorteinPrediction{
  
  public static void main(String[] args){
    Map<String, Map<String, Integer>> functionToSequence = new HashMap<String, Map<String, Integer>>();
    Map<String, Integer> functionCount = new HashMap<String, Integer>();
    Map<String, Integer> sequenceCount = new HashMap<String, Integer>();
    Map<String, String> goTerms = new HashMap<String, String>();
    
    String sequencesFile = "New_Balanced_FragDATABASE_34567_top2000.txt";
    Scanner populateSequenceCount = new Scanner(new File(sequences));
    
    String goTermsFile = "F_3_GO_table.txt";
    Scanner populateGOTerms = new Scanner(new File(goTermsFile));
    
    while(populateSequenceFile.hasNext()){ //might need to be .hasNextLine depending on if the file reads token for token or line for line
      String sequence = sequencesFile.next();
      sequenceCount.put(sequence, 0);
    }
    
    while(populateGOTerms.hasNextLine()){
      String line = populateGOTerms.nextLine();
      String goTerm = line.next();
      String function = line.next();
      goTerms.put(goTerm, function);
      functionCount.put(function, 0);
    }
    
    String inputFile = "New_filtered_balanced_protein_language_data_34567_top2000.txt";
    Scanner data = new Scanner(new File(inputFile));
    
    while(data.hasNextLine()){
      String line = data.nextLine();
      Scanner scanLine = new Scanner(line);
      List<String> sequences = new ArrayList<String>();
      while(scanLine.hasNext()){
        String singleSequence = scanLine.next();
        if(!singleSequence.contains("|")){
          sequences.add(singleSequence);
        } else {
          
        }
      }
    }
  }
}

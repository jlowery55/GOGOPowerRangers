public class PorteinPrediction{
  
  public static void main(String[] args){
    // map holding functions to a map with protein sequences and number of times a given sequence appears with the said function
    Map<String, Map<String, Integer>> functionToSequence = new HashMap<String, Map<String, Integer>>();
    
    // map containing the total number of times each function appears
    Map<String, Integer> functionCount = new HashMap<String, Integer>();
   
    // map containing the total number of times each sequence appears
    Map<String, Integer> sequenceCount = new HashMap<String, Integer>();
    
    // maps go terms to functions
    Map<String, String> goTerms = new HashMap<String, String>();
    
    // file containing all of the sequences
    String sequencesFile = "New_Balanced_FragDATABASE_34567_top2000.txt";
    Scanner populateSequenceCount = new Scanner(new File(sequences));
    
    //file containing all of the GOTerms to the functions they correspond to
    String goTermsFile = "F_3_GO_table.txt";
    Scanner populateGOTerms = new Scanner(new File(goTermsFile));
    
    // reads entire sequence file and populates sequence map
    while(populateSequenceFile.hasNext()){ //might need to be .hasNextLine depending on if the file reads token for token or line for line
      String sequence = sequencesFile.next();
      sequenceCount.put(sequence, 0);
    }
    
    // reads goterm file and populates goterm map and function count map
    while(populateGOTerms.hasNextLine()){
      String line = populateGOTerms.nextLine();
      String goTerm = line.next();
      String function = line.next();
      goTerms.put(goTerm, function);
      functionCount.put(function, 0);
    }
    
    // file containing the sequences and the functions the relate to
    String inputFile = "New_filtered_balanced_protein_language_data_34567_top2000.txt";
    Scanner data = new Scanner(new File(inputFile));
    
    
    while(data.hasNextLine()){
      
      // reads line
      String line = data.nextLine();
      Scanner scanLine = new Scanner(line);
      
      // list to keep track of all sequences in line
      List<String> sequences = new ArrayList<String>();
     
      // list to keep track of all functions that appear in the line
      List<String> functions = new ArrayList<String>();
     
      // to flag when we are no longer scanning in sequences and begin scanning in functions
      boolean functionNotFound = true;
      while(functionNotFound){
        String singleSequence = scanLine.next();
        
        // if the token does not contain '|', this means we are still encountering sequences and so add them to the list and
        // increment the number of times we have seen this sequence by one
        if(!singleSequence.contains("|")){
          sequences.add(singleSequence);
          sequenceCount.put(singleSequence, sequenceCount.get(singleSequence)++);
        } else {
          
          // encountering the bar means we have a sequence|function with no white space
          // we get the first string which is the sequence by getting the index od the bar and using substring function
          // we get the second string which is the function by getting the character after the bar
          int i = singleSequence.indexOf('|');
          String first = singleSequence.substring(0, i);
          sequences.add(first);
          String second = singleSequence.substring(i + 1); //possibly need second index which goes to the end
          functionCount.put(second, functionCount.get(second)++);
          functionFound = true;
          functions.add(second);
        }
      }
      
      // scan until the line is not empty, there could be several more functions after the |
      while(scanLine.hasNext()){
        String function = scanLine.next();
        functions.add(function);
      }
      
      // iterate through each function we have found
      for(int i = 0; i < functions.size(); i++){
        String f = functions.get(i);
       
        // get the map that is mapped to the function f
        Map<String, Integer> add = functionToSequence.get(f);
        
        // remove from the map because we will add it back later with a modified version
        functionToSequence.remove(f);
        
        // add to the new map each sequence that is encountered plus one because it has seen it plus one more times
        for(int j = 0; j < sequences.size(); j++){
          String s = sequences.get(j);
          add.put(s, add.get(s)++);
        }
        
        // put the modified map back into the main map
        functionToSequence.put(f, add);
      }
    }
  }
}

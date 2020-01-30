# CS487Final
Main home for our Bioinformatics Final

TrainingScript.java is a program to calculate the probabilites of sequence "words" appearing with specific protein functions. This is accomplished by creating a map that has functions as sequences that map to another map of sequences with those values being the number of times the key "word" is mapped to the original key function. 

We keep a count of total amount of times each word is seen in the data set we are given. This is used to then calculate the probability that each word shows up to each function. This is done by taking the integer value from the mapping to the new map and dividing it by total number of times the word is seen. This is then saved by creating a new map with doubles as the probability instead of integers as the count. This is then printed to a file. 

After the result is printed it is then read in by PredictionScript.java. This takes in the word sequences first and then uses these as keys which maps to new maps containing functions as keys and the probabilities as values. We then begin reading in the fasta file. We iterate through the sequence searching the database of words for matches and add it to a list for every hit we get. We then iterated through this map and added up the probabilites to given each sequence and function pair a weight. 
These pairs are then ordered by highest total probability and printed out.

To run this program, make sure to have New_Balanced_FragDATABASE_34567_top2000.txt, F_3_GO_table.txt, New_filtered_balanced_protein_language_data_34567_top2000.txt, TrainingScript.java, and PredictionScript.java in the same file. Run TrainingScript.java to train the model. Then run PredictionScript.java to get the protein function predictions. Make sure to have a file containing fasta sequences named "selected.fasta".

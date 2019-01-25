#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <set>
/*SIDE PROJECT 01 - Simple C to Python translator*/
void nextWordPos(std::string instruction, int &pos){
	while(instruction[pos]!=' '){pos++;}
	return pos;
}
/*Used to extract the the name of a variable in a given C instruction*/
std::string extractVarName(std::string instruction){
	std::string varName = "";
	int position = 0;
	nextWordPos(instruction,position); //advance to the next space character
	position++; //advance one more space
	while(instruction[position]!=' ' && instruction[position]!='='){ //extract the var name
		varName+=instruction[position];
		position++;
	}
	return varName; //return the var name
}
/*This function is used to copy everything after the = sign in an assignment statement.*/
std::string copyTheRest(std::string instruction){
	std::string theRest = "";
	int position = 0;
	while(instruction[position]!='='){position++;}
	position++;
	while(instruction[position]!=';'){
		theRest+=instruction[position];
		position++;
	}
	return theRest;
}
/*This function is used to retrieve the function name in a like like this: "void funcName(int a, int b){".
funcName would be the string returned.*/
std::string retrieveFuncName(std::string instruction){
	std::string funcName = ""; //YOU STOPPED RIGHT HERE
}
/*Used to determine whether we are dealing with a function or a variable set-up*/
bool findLeftParenthesis(std::instruction, int pos){
	bool found = false;
	while(instruction[pos]!=' '){ //When we hit a space, we stop the search
		if(instruction[pos]=='('){ //return true if we hit a leftParen
			found = true;
		}	
	}	
	return found;
}
std::string extract_type(std::string instruction, data){
	int i = 0;
	std::string firstWord = "";
	while(instruction[i]!=' '){
		firstWord+=instruction[i];	
	}
	bool is_Function = data.find(firstWord) != data.end(); //If we've extracted a data type
	if(is_Function) return firstWord;
	else return "";
}
bool findAssignmentOp(std::string instruction){ //Looks for assignment operator in an instruction
	for(int i = 0; i < instruction.size(); i++){
			if(instruction[i]=='=') return true;
	}
	return false;	
}

/*This function is responsible for describing a C statement as a function, variable, if-else clause, loop, as a combo of operations
or something else. The first thing this function looks for is whether or not the first part of the instruction is a datatype. For example,
if we have "int name;" or "int main()" then we are in one of two cases, either we have a function or a variable. However, if the first part 
of the instruction is NOT a datatype, then we have a lot more options to go through: we could have a #include statement, we could have a
simple assignment statement, we could have a return statement... These are the possibilities we will deal with for now.*/
std::string categorize(std::string instruction, std::set<std::string> datatypes){ //We pass in an instruction and the set of all datatypes.
	std::string category = "";
	int posInString = 0;
	std::string datatype = extract_type(instruction,datatypes);
	if (datatype!="") {
		nextWordPos(instruction,posInString); //advance position in the string, bringing us to the next 'word'
		if(findLeftParenthesis(instruction,posInString)) category = "FUNCTION";
		else category = "VARIABLE";
	}
	else{
		if(instruction[0] == '#') category = "INCLUDE";
		else if(instruction[0]!='#' && findAssignmentOp(instruction)) category = "ASSIGNMENT";
		else category = "RETURN";
	}
	return category;
}


/*This function is responsible for choosing how we should translate the C instruction*/
void parseInstructions(std::vector<std::string> instruc, std::ofstream &out){
		unsigned int i = 0;
		while(i < instruc.size()){
				std::string line = instruc[i];
				std::set<std::string> data = {"int","double","char","std::string","void"}; //The datatypes of concern
				std::string category = categorize(line,data); //We categorize our instruction
				if(category=="VARIABLE"){
					std::cout << extractVarName(instruc) << " = " << copyTheRest(instruc) << std::endl;
				}
				else if(category=="INCLUDE"){
					//To be continued...
				}
				else if(category=="FUNCTION"){
					std::cout << "def " << retrieveFuncName(instruc)
				}
		}
}


/*This function is responsible for parsing our file*/
std::vector<std::string> parseFile(std::ifstream &file){
	std::vector<std::string> lines; //We create the vector that will hold our instructions
	std::string line; //Temporary variable used to hold each line
	while(std::getline(file,line)){
		int j = 0;
		int startingIndex = 0;
		while(line[j]=='\t'){
			startingIndex++;
			j++;	
		}
		lines.push_back(line.substr(startingIndex,line.size()-startingIndex)); //Add our new line to lines
	}
	return lines; //Finally, return our set of instructions to translate.
}

/*Our main function is where we will use all of the other functions we have created*/
int main(int argc, char *argv[]){ //error checking. We want TWO command line arguments, which means argc==3.
	if(argc!=3){
		std::cout << "Usage: ./a.out infile.src outfile.src" << std::endl;
		return 1;
	} 
	std::ifstream myfile;
	myfile.open(argv[1]); //our input file
	std::vector<std::string> instructions = parseFile(myfile);
	myfile.close();
	std::ofstream outfile;
	outfile.open(argv[2]);
	parseInstructions(instructions,outfile);
	return 0;

}
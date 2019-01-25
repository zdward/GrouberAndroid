SIDE PROJECT 01 -- Zachary D. Ward
Simple C to Python Translator
------------------------------------------------------
This translator takes in a .src file of simple C code and translates it into high-level python code.

ASSUMPTIONS:
- The C code is error-free
- Not using the standard namespace

 Examples of C code that this program can translate are:

Example 1 -- Simple Example
-----------------------------------
int main(int argc, char* argv){ 
	int a = 3;
	int b = 3;
	int c = a + b;
	return 0;
}

TRANSLATED:
def main():
	a = 3
	b = 3
	c = a + b

if __name__ == "__main__"
main()	

------------------------------------

Example 2 -- Functions, Branches (Ifs and Else), Loops..
------------------------------------
int exponent(int base, int power){
	int ret = 1;
	for(int i = 0; i < power; i++){
		ret*=base;
	}
	return ret;
}
int main(){
	int base;
	int power;
	std::cout << "Enter a base: " << std::endl;
	std::cin >> base>> std::endl;
	std::cout << "Enter an exponent: " << std::endl;
	std::cin >> power >> std::endl;
	if(base==power) std::cout << "n^n = " << exponent(base,power) << std::endl;
	else std::cout << "a^n = " << exponent(base,power) << std::endl;
	return 0;
}

TRANSLATED:

def exponent(base, power):
	ret = 1
	for i in range(len(power)):
		ret*=base
	return ret

def main():
	base = input("Enter a base: ")
	power = input("Enter an exponent: "")
	if(base==power)
		print("n^n =",exponent(base,power))
	else
		print("a^n =",exponent(base,power))

if __name__ == "__main__"
	main()
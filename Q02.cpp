#include <iostream>

using namespace std;

void check_num(int num){
  int auxiliar, temporario, ultimo=1, penultimo=1;
  bool pertence = false;
  
  if(num == 1){
    cout << "Faz parte da sequencia" << endl;
  }
  else{
    for(; ultimo<=num ;){  
      
        temporario = penultimo;
        penultimo = ultimo;
        ultimo = ultimo + temporario;
      
      if(ultimo == num){
        pertence = true;
      }
      
    }
    
    if(pertence){
      cout << "Faz parte da sequencia" << endl;
    }
    else{
      cout << "Nao faz parte da sequencia" << endl;
    }
    
  }
}


int main()
{
  int num;
  cout << "Digite o numero que deseja saber se pertence a sequencia de fib: ";
  cin >> num;
  check_num(num);

    return 0;
}

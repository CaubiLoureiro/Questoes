#include <stdio.h>

//Funcao para inverter string
void inverte(char* string){
  //Inicializa variaveis
  int len_string, indice_copia;
  len_string = strlen(string) - 1;
  char string_invertida[len_string + 1];
  indice_copia = 0;
  /*For para percorrer a string ao contrario salvando os caracteres em
  string_invertida*/
  for(;len_string >= 0; len_string--){
    *(string_invertida + indice_copia) = *(string + len_string);
    indice_copia++;
    
  }
  //Completa a string com o \0 para final de string
  string_invertida[indice_copia] = "\0";
  printf("%s", string_invertida);
}


//Main
int main(void) {
  /*Para fins ilustrativos limite de strings com 101 caracteres, mas é possivel
  usar alocação dinamica para deixar o programa menos limitado a um tamanho*/
  char string[101];
  printf("%s", "Digite uma string: ");
  scanf("%101s", string);
  inverte(string);
  return 0;
}

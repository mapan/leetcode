int isAnagrmaOfPalindrome(char *string){
unsigned int bitc = 0, i = 0;
int out = 0;

while(*string){
    i = *(string++) - 'a';
    bitc ^= (1 << i);
    }

out = (int)(bitc & (bitc - 1));

return !out;
}

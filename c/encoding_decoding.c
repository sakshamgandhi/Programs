/*
BASE 64 ENCODING AND DECODING
encode unhi words ko karna hai jaha tak 6 is div hai uske baad valle ko chod dena hai
jaise agar 16 hai list ka size toh first 12 tak ENCODING karni hai and baaki ko '?' se represent karna if 1 else ':' for 0
*/

#include <stdio.h>
#include <malloc.h>
#include <string.h>
#include <math.h>

//
//ECODING FUNCTIONS
//

int* opr_bin(char *in_str, int *k) {
    int *bin_list;
    bin_list = (int* ) malloc (sizeof (int ) * 1024);
    for(int i = 0; i < strlen(in_str ); ++i) {
	int tmp = (int ) in_str[i];
	int tmp2 = 7;
	while(tmp2 >= 0) {
	    int reg_express = !(! (tmp & (int )pow(2, tmp2)));
	    bin_list[*k] = reg_express;
	    *k += 1;
	    tmp2 -= 1;
	}
    }
    return bin_list;
}


char* ENCODING(int *bin_list, char *map_list, int *k) {
    int t = *k;
    char *encoded_list;
    int k2 = 0;
    encoded_list = (char *) malloc (sizeof (char ) * 1024);
    
    while(t % 6 != 0) {
	t -= 1;
    }
    
    int en_count = 5;
    int tmp = 0;
    int i = 0;
    while(i < t) {
	if(en_count >= 0) {
	    tmp = tmp + (bin_list[i] * pow(2, en_count));
	    en_count -= 1;
	    i += 1;
	}
	else {
	    en_count = 5;
	    encoded_list[k2] = map_list[tmp];
	    k2 += 1;
	    tmp = 0;
	}
    }
    encoded_list[k2] = map_list[tmp];
    k2 += 1;
    if (t != *k) {
	for(int i = t; i < *k; ++i) {
	    char x = ':';
	    if(bin_list[i] == 1) x = '?';
	    encoded_list[k2] = x;
	    k2 += 1;
	}
    }
    encoded_list[k2] = '\0';
    return encoded_list;
}


//
//DECODING FUNCTIONS
//

int* opr_bin2(char *encoded_list, char* map_list, int *k) {
    int *bin_list;
    bin_list = (int* ) malloc (sizeof (int ) * 1024);
    for(int i = 0; i < strlen(encoded_list ); ++i) {
	for(int j = 0; j < strlen(map_list ); ++j) {
	    if(encoded_list[i] == map_list[j]) {
		for(int tmp = 5; tmp >= 0; --tmp) {
		    bin_list[*k] = (int )(! (! (j & (int )pow(2, tmp))));
		    *k += 1;
		}
		break;
	    }
	    else if(encoded_list[i] == '?') {
		bin_list[*k] = 1;
		*k += 1;
		break;
	    }
	    else if(encoded_list[i] == ':') {
		bin_list[*k] = 0;
		*k += 1;
		break;
	    }
	    else {
		continue;
	    }
	}
    }
    return bin_list;
}

char* DECODING(int *bin_list, int *k) {
    char *decoded_list;
    decoded_list = (char *) malloc (sizeof (char ) * 1024);
    int de_count = 7, tmp = 0, i = 0, k2 = 0;
    while(i < *k) {
	if(de_count >= 0) {
	    tmp = tmp + (bin_list[i] * (int )pow(2, de_count));
	    de_count -= 1;
	    i += 1;
	}
	else {
	    decoded_list[k2] = tmp;
	    k2 += 1;
	    tmp = 0;
	    de_count = 7;
	}
    }
    decoded_list[k2] = tmp;
    k2 += 1;
    decoded_list[k2] = '\0';
    return decoded_list;
}



int main() {
    char *in_str, *map_list, *encoded_list, *decoded_list;
    int *bin_list;
    in_str = (char *) malloc (sizeof (char ) * 1024);
    map_list = (char *) malloc (sizeof (char ) * 64);
    int k = 0;
    for(int i = 65; i <= 90; ++i, ++k) map_list[k] = i;
    for(int i = 97; i <= 122; ++i, ++k) map_list[k] = i;
    for(int i = 48; i <= 57; ++i, ++k) map_list[k] = i;
    map_list[k] = '+'; k++;
    map_list[k] = '-'; k++;
    map_list[k] = '\0';

    scanf("%[^\n]", in_str);

    //ENCODING
    k = 0;
    bin_list = opr_bin(in_str, &k);
    //for(int i = 0; i < k; ++i) printf("%d ",bin_list[i]);
    encoded_list = ENCODING(bin_list, map_list, &k);
    printf("ENCODED LIST %s\n", encoded_list);
    free(in_str );
    free(bin_list );

    //DECODING
    k = 0;
    bin_list = opr_bin2(encoded_list, map_list, &k);
    //for(int i = 0; i < k; ++i) printf("%d ",bin_list[i]);
    decoded_list = DECODING(bin_list, &k);
    printf("DECODED LIST %s\n", decoded_list);
    free(bin_list );
    free(encoded_list );
    free(decoded_list );
    free(map_list );
    return 0;
}

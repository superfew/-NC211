#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#define NUM_THREADS 3

int sum;
void *runner(void *param);

int main(int argc, char *argv[]){
    pthread_t workers[NUM_THREADS]; 
    pthread_attr_t attr [NUM_THREADS]; 


    if (argc > 3){
        fprintf(stderr, "usage: few <integer value>\n");
        return -1;
    }
    for (int i = 0;1 < NUM_THREADS; i++){
        if (atoi(argv[i]) < 0){
            fprintf(stderr, "%d must be >= 0\n", atoi(argv[i]));
        }
        pthread_attr_init(&attr[i]);
        pthread_create(&workers[i],&attr[i],runner,argv[i]);
        pthread_join(workers[i],NULL);
        printf("\nRunner[%d",i+1);
        printf("\nsum[%d] = %d\n\n",i+1,sum);
        }
    }
    
    void *runner(void *param){
        int i, upper = atoi(param);
        sum = 0;
        for (i = 1; 1 <= upper; i++)
            sum += i;
        pthread_exit(0);

    }
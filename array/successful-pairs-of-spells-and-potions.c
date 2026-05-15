
#pragma GCC optimize("O3, unroll-loops")
int* successfulPairs(int* spells, int n, int* potions, int m, long long success, int* returnSize) {
    *returnSize=n;
    int freq[100001]={0}, pMax=0;
    for(int i=0; i<m; i++){
        const int p=potions[i];
        freq[p]++;
        pMax=fmax(pMax, p);
    }
    // freq=suffix sum for freq
    for (int p=pMax-1; p>=0; p--) {
        freq[p]+=freq[p+1];
    }

    for (int i=0; i<n; i++){
        int spell=spells[i];
        const long long k=(success+spell-1)/spell;
        spells[i]=(k<=pMax)?freq[k]:0;
    }
    return spells;
}
import sys
from collections import defaultdict

input = sys.stdin.readline
n = int(input())

teamDict = defaultdict(list)

for i in range(n):
    mentor, menti = input().split()
    teamDict[mentor].append(menti)

teamDict=dict(sorted(teamDict.items()))

for key in teamDict:
    menti_List = sorted(teamDict[key], reverse=True)
    for menti in menti_List:
        print(key, menti)
        


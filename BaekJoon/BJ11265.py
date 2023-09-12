import sys

input = sys.stdin.readline
n, m = map(int, input().split())
graphParty = [list(map(int, input().split())) for _ in range(n)]
graphUser = [list(map(int, input().split())) for _ in range(m)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            if graphParty[i][j]> graphParty[i][k]+graphParty[k][j]:
                graphParty[i][j] = graphParty[i][k]+graphParty[k][j]

for a, b, time in graphUser:
    if graphParty[a-1][b-1] <= time:
        print("Enjoy other party")
    else:
        print("Stay here")
n = int(input())

dp = [x for x in range (n+1)] ## 0~11 in list len 12

for i in range(1,n+1):   
    """
    # i range: 1 ~ 12 -> if i = 9 :
                         dp[9] = 9
    """
    for j in range(1,i): # j range: 1 ~ i
        if j*j > i : 
            break
        if dp[i] > dp[i-j*j] + 1 : 
            dp[i] = dp[i-j*j] + 1
            # print(dp[i-j*j])
        # print(i,j,dp)

print(dp[n])

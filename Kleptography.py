charToNum = {chr(97+i):i for i in range(26)} #dictionary which maps characters to their numbers
numToChar = {v:k for (k,v) in charToNum.items()} #dictionary which maps number to their character

n, m = [int(i) for i in input().split()] #we have to convert them to ints
last = input() #the last n letters of the plain text 
encrypted = input() #the entire encrypted text

regular = [' ' for i in range(m-n)] #there are m-n characters we do not know 
regular = regular + list(last)

i = m-1
while(i > n-1):
    regular[i-n] = chr((26 + ord(encrypted[i]) - ord(regular[i])) % 26 + 97)
    i -= 1

print(''.join(regular))
import sys

for i in sys.stdin:
    moves = i

cup = 1

for move in moves:
    if move == 'A' and cup == 1:
        cup = 2
    elif move == 'A' and cup == 2:
        cup = 1
    elif move == 'B' and cup == 3:
        cup = 2
    elif move == 'B' and cup == 2:
        cup = 3
    elif move == 'C' and cup == 1:
        cup = 3
    elif move == 'C' and cup == 3:
        cup = 1
        
print(cup)
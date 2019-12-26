import sys

board = []

for i in range(0,8):
    board.append(input())

def validRow(row,board):
    queenInRow = False #keeping track of whether or not we have already seen a queen in this row

    for r in board[row]:
        if(r=='*' and queenInRow): #if we see a qeeun after seeing another queen return false
            return False
        elif(r=='*'):
            queenInRow = True

    return True

def validCol(col,board):
    qeeunInCol = False #keeping track of whether or not we have already seen a queen in the column

    for i in range(0,8):
        if(board[i][col] == '*' and qeeunInCol): #if we have already seen a queen and we see another queen return false
            return False
        elif(board[i][col] == '*'):
            qeeunInCol = True

    return True

def validDiag(x,y,board):

    i = x - 1
    j = y - 1

    while(i >= 0 and j >= 0):
        if(board[i][j] == '*'):
            return False
        i -= 1
        j -= 1

    i = x - 1
    j = y + 1

    while(i >= 0 and j < len(board[0])):
        if(board[i][j] == '*'):
            return False
        i -= 1
        j += 1

    i = x + 1
    j = y - 1

    while(i < len(board) and j >= 0):
        if(board[i][j] == '*'):
            return False
        i += 1
        j -= 1

    i = x + 1
    j = y + 1

    while(i < len(board) and j < len(board[0])):
        if(board[i][j] == '*'):
            return False
        i += 1
        j += 1

    return True 

#go through each row and column and make sure it is valid 
for i in range(0,8):
    if(not validRow(i,board) or not validCol(i,board)):
        print("invalid")
        sys.exit()
        break

count = 0 #we have to make sure that we actually have 8 queens on the board
#if a queen has been placed make sure that the diagonals work out
for i in range(0,len(board)):
    for j in range(0,len(board[i])):
        if(board[i][j] == '*'):
            count += 1
            if not validDiag(i,j,board):
                print("invalid")
                sys.exit()

if(count != 8): #if we don't have 8 queens then print invalid, and exit
    print("invalid")
    sys.exit()
        
print("valid")


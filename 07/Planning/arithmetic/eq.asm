// possible improvement?
@SP
AM=M-1
D=M
A=A-1
M=M-D
D=M //seems redundant, but will not correctly identify false instances otherwise
@True
D;JEQ
@SP
A=M-1
M=1
(True)
@SP
A=M-1
M=M-1
// possible improvement?
@SP
AM=M-1
D=M
A=A-1
M=M-D
D=M 
@True
D;JLT
@SP
A=M-1
M=0
@End
0;JMP
(True)
@SP
A=M-1
M=-1
(End)
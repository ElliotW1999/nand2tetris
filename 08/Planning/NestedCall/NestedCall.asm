@256
D=A
@SP
M=D
@return$0
D=A
@SP
M=M+1
A=M-1
M=D
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
M=M+1
A=M-1
M=D
@5
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@0
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@SP
M=M-1
A=M
D=M
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init
0;JMP
(return$0)
// function Sys.init 0
(Sys.init)
// push constant 4000
@4000
D=A
@SP
M=M+1
A=M-1
M=D
// pop pointer 0
@SP
AM=M-1
D=M
@3
M=D
// push constant 5000
@5000
D=A
@SP
M=M+1
A=M-1
M=D
// pop pointer 1
@SP
AM=M-1
D=M
@4
M=D
// call Sys.main 0
@return$1
D=A
@SP
M=M+1
A=M-1
M=D
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
M=M+1
A=M-1
M=D
@5
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@0
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@SP
M=M-1
A=M
D=M
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.main
0;JMP
(return$1)
// pop temp 1
@SP
AM=M-1
D=M
@6
M=D
// label LOOP
(Sys.init$LOOP)
// goto LOOP
@Sys.init$LOOP
0;JMP
// function Sys.main 5
(Sys.main)
@0
D=A
@SP
M=M+1
A=M-1
M=D

@0
D=A
@SP
M=M+1
A=M-1
M=D

@0
D=A
@SP
M=M+1
A=M-1
M=D

@0
D=A
@SP
M=M+1
A=M-1
M=D

@0
D=A
@SP
M=M+1
A=M-1
M=D

// push constant 4001
@4001
D=A
@SP
M=M+1
A=M-1
M=D
// pop pointer 0
@SP
AM=M-1
D=M
@3
M=D
// push constant 5001
@5001
D=A
@SP
M=M+1
A=M-1
M=D
// pop pointer 1
@SP
AM=M-1
D=M
@4
M=D
// push constant 200
@200
D=A
@SP
M=M+1
A=M-1
M=D
// pop local 1
@1
D=A
@LCL
D=D+M
@13
M=D
@SP
M=M-1
A=M
D=M
@13
A=M
M=D
// push constant 40
@40
D=A
@SP
M=M+1
A=M-1
M=D
// pop local 2
@2
D=A
@LCL
D=D+M
@13
M=D
@SP
M=M-1
A=M
D=M
@13
A=M
M=D
// push constant 6
@6
D=A
@SP
M=M+1
A=M-1
M=D
// pop local 3
@3
D=A
@LCL
D=D+M
@13
M=D
@SP
M=M-1
A=M
D=M
@13
A=M
M=D
// push constant 123
@123
D=A
@SP
M=M+1
A=M-1
M=D
// call Sys.add12 1
@return$2
D=A
@SP
M=M+1
A=M-1
M=D
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
M=M+1
A=M-1
M=D
@5
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@1
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@SP
M=M-1
A=M
D=M
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.add12
0;JMP
(return$2)
// pop temp 0
@SP
AM=M-1
D=M
@5
M=D
// push local 0
@0
D=A
@LCL
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
// push local 1
@1
D=A
@LCL
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
// push local 2
@2
D=A
@LCL
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
// push local 3
@3
D=A
@LCL
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
// push local 4
@4
D=A
@LCL
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
// add
@SP
AM=M-1
D=M
A=A-1
M=D+M
// add
@SP
AM=M-1
D=M
A=A-1
M=D+M
// add
@SP
AM=M-1
D=M
A=A-1
M=D+M
// add
@SP
AM=M-1
D=M
A=A-1
M=D+M
// return
@LCL
D=M
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
@13
M=D
@13
D=M
@SP
M=M+1
A=M-1
M=D
@5
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@SP
AM=M-1
A=M
D=M
@14
M=D
@SP
AM=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@13
D=M
@15
M=D-1
A=M
D=M
@THAT
M=D
@15
M=M-1
A=M
D=M
@THIS
M=D
@15
M=M-1
A=M
D=M
@ARG
M=D
@15
M=M-1
A=M
D=M
@LCL
M=D
@14
A=M
0;JMP
// function Sys.add12 0
(Sys.add12)
// push constant 4002
@4002
D=A
@SP
M=M+1
A=M-1
M=D
// pop pointer 0
@SP
AM=M-1
D=M
@3
M=D
// push constant 5002
@5002
D=A
@SP
M=M+1
A=M-1
M=D
// pop pointer 1
@SP
AM=M-1
D=M
@4
M=D
// push argument 0
@0
D=A
@ARG
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
// push constant 12
@12
D=A
@SP
M=M+1
A=M-1
M=D
// add
@SP
AM=M-1
D=M
A=A-1
M=D+M
// return
@LCL
D=M
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
@13
M=D
@13
D=M
@SP
M=M+1
A=M-1
M=D
@5
D=A
@SP
M=M+1
A=M-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@SP
AM=M-1
A=M
D=M
@14
M=D
@SP
AM=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@13
D=M
@15
M=D-1
A=M
D=M
@THAT
M=D
@15
M=M-1
A=M
D=M
@THIS
M=D
@15
M=M-1
A=M
D=M
@ARG
M=D
@15
M=M-1
A=M
D=M
@LCL
M=D
@14
A=M
0;JMP

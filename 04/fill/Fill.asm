// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.

// for (i=16384;i<24576;i++) {
//		M[i]=1		
//	}

(MAIN)
	@24576
	D=A
	@n
	M=D

	@16384
	D=A
	@i
	M=D
	
	@24576	//if [add]24576 != 0 goto LOOP
	D=M
	@LOOP
	D;JNE
	
	@MAIN
	0;JMP

(LOOP)
	@i	//if i==24575 goto WAIT
	D=M
	@n
	D=D-M
	@WAIT
	D;JEQ
	
	@i	//M[i]=-1	
	A=M
	M=-1	
	
	@i	//i++
	M=M+1
	
	@LOOP
	0;JMP

(WAIT)
	@16384
	D=A
	@i
	M=D
	
	@24576	//if [add]24576 = 0 goto CLEAR
	D=M
	@CLEAR
	D;JEQ
	
	@WAIT
	0;JMP
	
(CLEAR)	
	@i	//if i==24575 goto MAIN
	D=M
	@n
	D=D-M
	@MAIN
	D;JEQ

	@i	//M[i]=0	
	A=M
	M=0	
	
	@i	//i++
	M=M+1

	@CLEAR
	0;JMP
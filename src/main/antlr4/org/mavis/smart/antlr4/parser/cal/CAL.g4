grammar CAL;

s
:
	e
;

e
:
	e MULT e   #MULT
	| e ADD e  #ADD
	| INT      #INT
;
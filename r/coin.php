<?php
//Ben
//20170426
//20190414

// The sum that needs to be decomposed.
$s=100;
$s = $_POST['s'];
//info about coins
//$v=array(1, 3, 5);
$v=array(5,7);
$v = $_POST['v'];//comma separated integers representing coins of different values
$v = preg_split("/[\s,]+/", $v); //decompose a string into an array

//Revert array back to string
$inputV = '';
for($j=0;$j<count($v);$j++){
	$inputV .= "$v[$j],";
}	
$inputV = substr($inputV, 0, strlen($inputV)-1);

print "Your sum: $s<BR>";
print "Your coins: $inputV<BR>";
print "<hr/><hr/>";

$vmin=min($v);
$vc=count($v);

//!!!max number of coins needed using the coin of smallest value.
$minmax=round($s/$vmin)+0.5;

//!!!$minv is the key variable in this script. The main task is to find out $minv for each 0<=$i<=$s
$minv = array();

//initiate $minv with $minmax
for($i=1;$i<=$s;$i++){
	$minv[$i]=$minmax;	
}
//a special case.
$minv[0]=0;

//!!!path is the sequence of the index of the coin value selected at each step for each $i
$path = array();

//!!!coint count 
$cv=array();

//This block is the core of the program.
for($i=1;$i<=$s;$i++){
	print ("Sum: $i<BR>");
	// note the next loop identify $minv for $i by considering all coin values
	for($j=0;$j<count($v);$j++){
		//$errC is a flag for remember whether coin $v[$j] is OK.
		if($v[$j]>$i ){
			$errC[$j] = 1;
			print "&nbsp;&nbsp;Last Coin $v[$j]:\tvalue bigger than sum<BR>";
		}else{
			//$minvp is the potential new.
			$minvp=$minv[$i-$v[$j]]+1;
			
			//Because $minv[$i] has the initial value at this moment, it is a reasonably big number. If $minvp is even bigger, this means the potential last step before trying $v[$j] also has the initializing value, ie, the sub-task is impossible.
			if($minvp>$minv[$i]){
				$errC[$j] = 2;
				print "&nbsp;&nbsp;Last Coin $v[$j]:\tsub-task impossible<BR>";
			}else{
				$errC[$j] = 0;
				$minv[$i]=$minvp;	
				$path[$i] = $j;  //record which coin is selected for $i
			}	
		}	
	}

	//print out the results.
	if($minv[$i]==$minmax){
		print ("<font color=red>Mission impossible!</font><BR>");
	}else{
		print ("$minv[$i] coin needed.<BR>");
		
		//count numbers of coins along the path
		//first initialize $cv with 0
		for($j=0;$j<count($v);$j++){
			$cv[$j]= 0;
		}
		//second count and go back along the path from $i back to 0
		$k=$i; 
		while($k){
			$cv[$path[$k]]++;
			$k-=$v[$path[$k]];
		}
		
		//print out result in a way that is easy to understood
		//equation left and righ side.
		$el = "$i";
		$er = "";
		$erv = 0;
		for($j=0;$j<$vc;$j++){
			if($cv[$j]){
				print "&nbsp;&nbsp;Coin $v[$j]:" . $cv[$j] . "<BR>";
				$er .= " $v[$j]*" . $cv[$j] . " +";
				$erv += $v[$j]*$cv[$j];
			}
		}
		//remove the last + sign of the right side of the equation.
		$er = substr($er, 0, strlen($er)-1);
		//print out the equation.
		print "$el = $er<BR>";
		//check whether the quation holds.
		if($i==$erv)print "<font color=Green>Correct!</font> ";
		else{
			print "<font color=red>Wrong!</font> ";
			print "erv: $erv<BR>";
		}
	}
	print ("<hr/>");
}
?>

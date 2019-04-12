open(IN, "<number.txt") || die "无法打开number.txt";
open(OUT, ">result.txt") || die "无法打开result.txt";
$a = 0;
while ($line = <IN>){
    $a+= $line;
}
print OUT"$a";
close(IN);
close(OUT);
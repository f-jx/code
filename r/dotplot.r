#define two sequences
s1='NALMSQNH';
s2='MNALSQLN';
#s1='NALMSQNHNALMSQNH';
#s2='MNALSQLNNALMSQNH';

#define dot matrix
ncs1=nchar(s1);
ncs2=nchar(s2);
m=matrix(nrow = ncs2, ncol=ncs1);

#define a matrix corresponding to s1
ms1=matrix(nrow = 1, ncol=ncs1);

#make the first element of ms1 empty, why???
ms1[1]="";

#define a vector corresponding to s2
ms2=c();


for(i in 1:ncs2){
	#take a character of s2 
	c2=substring(s2, i, i);
	
	#compare with chars of s1 and assign values to dot matrix
	for(j in 1:ncs1){
		c1=substring(s1, j, j);
		if(c1==c2){
			m[i,j]="·";
		}else{
			m[i,j]="";
		}
	}
	
	#assign values to ms2, this needs some thinking
	ms2[i]=c2;
}
print("matrix:\n");
print(m, quote=FALSE);

#print("ms2:\n");
#print(ms2);

#add s2 as a column
m1=cbind(ms2, m, deparse.level = 0);
print("m with row names:\n");
print(m1, quote=FALSE);

#assign values to ms1
for(j in 1:ncs1){
	ms1[j+1]=substring(s1, j, j);
}
print("ms1:\n");
print(ms1, quote=FALSE);

#add s1 as a row
m2=rbind(ms1, m1, deparse.level = 0);
print("m with row names and column names:\n");
print(m2, quote=FALSE);


#convert matrix to data frame
md=data.frame(m2);
print("data frame:\n");
print(md);



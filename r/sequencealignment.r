#Ben Han
#20180418
#20190415

#define two sequences
s1='MNALQM';
s2='NALMSQA';

#s1='NALMSQNHNALMSQNH';
#s2='MNALSQLNNALMSQNH';

print(paste("seq1:", s1), quote=FALSE);
print(paste("seq2:", s2), quote=FALSE);

#define dot matrix
ncs1=nchar(s1);
ncs2=nchar(s2);
nncol=ncs1+1;
nnrow = ncs2+1;
m=matrix(nrow = nnrow, ncol=nncol);
#initialize the matrix
m[1,1]=0;

#gap penalty
gp=-6;


for(j in 2:nncol){
	m[1,j]=gp*(j-1);
}
for(i in 2:nnrow){
	m[i,1]=gp*(i-1);
}
while(FALSE){
print("matrixxxxx m:\n");
print(m);
}
#define score matrix. Not a real matrix. Need to modify later.
s=matrix(nrow = ncs2+1, ncol=ncs1+1);
s[2,2]=-2;s[2,3]=6;s[2,4]=-2;s[2,5]=-3;s[2,6]=0;s[2,7]=-2;
s[3,2]=-1;s[3,3]=-2;s[3,4]=4;s[3,5]=-1;s[3,6]=-1;s[3,7]=-1;
s[4,2]=2;s[4,3]=-3;s[4,4]=-1;s[4,5]=4;s[4,6]=-2;s[4,7]=2;
s[5,2]=5;s[5,3]=-2;s[5,4]=-1;s[5,5]=2;s[5,6]=0;s[5,7]=5;
s[6,2]=-1;s[6,3]=1;s[6,4]=1;s[6,5]=-2;s[6,6]=0;s[6,7]=-1;
s[7,2]=0;s[7,3]=0;s[7,4]=-1;s[7,5]=-2;s[7,6]=5;s[7,7]=0;
s[8,2]=-1;s[8,3]=-2;s[8,4]=4;s[8,5]=-1;s[8,6]=-1;s[8,7]=-1;
#print("matrix s:\n");
#print(s);

#define path matrix
p=matrix(nrow = nnrow, ncol=nncol);
p[1,1]='O';
for(j in 2:nncol){
	p[1,j]='<';
}
for(i in 2:nnrow){
	p[i,1]='^';
}

#assign values to m and p
for(i in 2:nnrow){
	for(j in 2:nncol){
		d=m[i-1, j-1]+s[i, j];
		l=m[i, j-1]+gp;
		u=m[i-1, j]+gp;
		mx=max(d, l, u);
		m[i,j]=mx;
		if(mx==d){
			p[i,j]='`';
		}else if(mx==l){
			p[i,j]='<';
		}else{
			p[i,j]='^';
		}
	}
}
if(FALSE){
print("matrix m:", quote=FALSE);
print(m, quote=FALSE);
print("matrix p:", quote=FALSE);
print(p, quote=FALSE);
}
#define a matrix corresponding to s1
ms1=matrix(nrow = 1, ncol=ncs1);

#assign values to ms1
ms1[1]="";
ms1[2]="";
for(j in 1:ncs1){
	ms1[j+2]=substring(s1, j, j);
}

#print("ms1:");
#print(ms1, quote=FALSE);

#define a vector corresponding to s2
ms2=c();
ms2[1]="";
for(i in 1:ncs2){
	#take a character of s2 
	c2=substring(s2, i, i);
	#assign values to ms2, this needs some thinking
	ms2[i+1]=c2;
}
#print("ms2:");
#print(ms2, quote=FALSE);

#add s2 as a column
m1=cbind(ms2, m, deparse.level = 0);
#print("m with row names:\n");
#print(m1, quote=FALSE);

#add s1 as a row
m2=rbind(ms1, m1, deparse.level = 0);
print("score map:");
print(m2, quote=FALSE);

#add s2 as a column
p1=cbind(ms2, p, deparse.level = 0);
#add s1 as a row
p2=rbind(ms1, p1, deparse.level = 0);
print("path map:");
print(p2, quote=FALSE);

#generate alignment and score
#x, y are path indices
x=nnrow;
y=nncol;


#aligned s1 is sc1;aligned s2 is sc2;they include gaps
sc1=c();
sc2=c();
#index for alignment, why we start from 1? Becuase we don't know the length of the alignment
i=0;
#do we need to recalculate the score? Actually not. The recalculation is only for verifying that the alignment is correct.
score=0;
while(!((x==1)&&(y==1))){
	i=i+1;
	pxy=p[x,y];
	if(pxy=='`'){
		sc1[i] = substr(s1, y-1, y-1);
		sc2[i] = substr(s2, x-1, x-1);
		ds=s[x, y];
		x=x-1;
		y=y-1;
	}else if(pxy=='<'){
		sc1[i] = substr(s1, y-1, y-1);
		sc2[i] = '-';
		ds=gp;
		y=y-1;
	}else{
		sc1[i] = '-';
		sc2[i] = substr(s2, x-1, x-1);
		ds=gp;
		x=x-1;		
	}
	#print(c(sc1, sc2), quote=FALSE);
	score=score+ds;
	
}

#revert sc1 and sc2
sc1r=c();
sc2r=c();
for(j in 1:i){
	sc1r[j] = sc1[i+1-j];
	sc2r[j] = sc2[i+1-j];
}

print("Alignment:", quote=FALSE);
print(sc1r, quote=FALSE);
print(sc2r, quote=FALSE);
print(c("Total score: ", score), quote=FALSE);
print(c("Number of pairs: ", i), quote=FALSE);

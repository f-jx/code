from gensim import corpora,models,similarities
import jieba
from collections import defaultdict
doc1="doc1.txt"
doc2="doc2.txt"
d1=open(doc1).read()
d2=open(doc2).read()

#分词
data1=jieba.cut(d1)
data2=jieba.cut(d2)

data11=""
for item in data1:
    data11+=item+" "
data21=""
for item in data2:
    data21+=item+" "

documents=[data11,data21]


texts=[[word for word in document.split()]
       for document in documents]
frequency=defaultdict(int) 

#统计各个词的频率
for text in texts:
    for token in text:
        frequency[token]+=1

dictionary=corpora.Dictionary(texts)
#dictionary.save("d345.txt")  

#加载要比较文档
doc3="doc3.txt"
d3=open(doc3).read()
data3=jieba.cut(d3)
data31="doc4.txt"
for item in data3:
    data31+=item+"doc4.txt"  
new_doc=data31

new_vec=dictionary.doc2bow(new_doc.split())

corpus=[dictionary.doc2bow(text) for text in texts]

tfidf=models.TfidfModel(corpus) 

new_tfidf = tfidf[corpus]

featureNum=len(dictionary.token2id.keys())

index=similarities.SparseMatrixSimilarity(new_tfidf,num_features=featureNum)

new_vec_tfidf = tfidf[new_vec]
sim=index[new_vec_tfidf]
print(sim)



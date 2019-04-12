from gensim import corpora,models,similarities
import jieba
from collections import defaultdict

#定义及移除停用词
def stopwordslist(filepath):
    stopwords = [line.strip() for line in open(filepath, 'r').readlines()]
    return stopwords

# 加载停用词方法
def movestopwords(sentence):
    stopwords = stopwordslist('stopword.txt')  
    outstr = ''
    for word in sentence:
        if word not in stopwords:
            if word != '\t'and'\n':
                outstr += word
    return outstr


d1=open('doc1.txt').read()
d2=open('doc2.txt').read()
d3=open('doc3.txt').read()
d4=open('doc4.txt').read()
d5=open('doc5.txt').read()

#分词
data1=jieba.cut(d1)
data2=jieba.cut(d2)
data3=jieba.cut(d3)
data4=jieba.cut(d4)
data5=jieba.cut(d5)
data1=movestopwords(data1)
data2=movestopwords(data2)
data3=movestopwords(data3)
data4=movestopwords(data4)
data5=movestopwords(data5)
data11=""
for item in data1:
    data11+=item+" "
data21=""
for item in data2:
    data21+=item+" "
data31=""
for item in data3:
    data31+=item+" "
data41=""
for item in data4:
    data41+=item+" "
data51=""
for item in data5:
    data51+=item+" "

documents=[data11,data21,data31,data41,data51]

texts=[[word for word in document.split()]
       for document in documents]
frequency=defaultdict(int)

#统计词频
for text in texts:
    for token in text:
        frequency[token]+=1

dictionary=corpora.Dictionary(texts)
#dictionary.save("d345.txt")

#加载要比较文档contrast
contrast='doc3.txt'
d_contrast=open(contrast).read()
data_contrast=jieba.cut(d_contrast)
data_contrast=movestopwords(data_contrast)
data_contrast1=""
for item in data3:
    data_contrast1+=item+" "
new_doc=data_contrast1

new_vec=dictionary.doc2bow(new_doc.split())

corpus=[dictionary.doc2bow(text) for text in texts]

tfidf=models.TfidfModel(corpus)

new_tfidf = tfidf[corpus]

featureNum=len(dictionary.token2id.keys())

index=similarities.SparseMatrixSimilarity(new_tfidf,num_features=featureNum)

new_vec_tfidf = tfidf[new_vec]
sim=index[new_vec_tfidf]

print(sim)

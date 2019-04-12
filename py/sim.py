from gensim import corpora,models,similarities

import jieba
from collections import defaultdict

#定义停用词list以及移除停用词movestopwords
def stopwordslist(filepath):
    stopwords = [line.strip() for line in open(filepath, 'r').readlines()]
    return stopwords


def movestopwords(sentence):
    stopwords = stopwordslist('stopword.txt')  # 这里加载停用词的路径
    outstr = ''
    for word in sentence:
        if word not in stopwords:
            if word != '\t'and'\n':
                outstr += word
    return outstr


d1=open('doc5.txt').read()
d2=open('empty.txt').read()

#分词
data1=jieba.cut(d1)
data2=jieba.cut(d2)
data1=movestopwords(data1)
data2=movestopwords(data2)
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
d3=open('contrast.txt').read()
data3=jieba.cut(d3)
data3=movestopwords(data3)
data31=""
for item in data3:
    data31+=item+" "
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

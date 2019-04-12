# MOOK网教程，极客学院2019scrapy
import re


s1 = 'uioxxIxx8490jerxxlovexxoavbd8xxyouxxiopb0d'
s2 = '''uioxxI
xx8490jerxxlovexxoavbd8xxyouxxiopb0d'''

print(re.findall('xx.*xx', s1))
print(re.findall('xx.*?xx', s1))
print(re.findall('xx(.*?)xx', s1))
print(re.findall('xx(.*?)xx', s2))
print(re.findall('xx(.*?)xx', s2, re.S))
# print(re.findall('xx(.*?)xx8490jerxx(x*?)xx', s1)[0])
# print(re.search('xx(.*?)xx8490jerxx(x*?)xx', s1).group(2))

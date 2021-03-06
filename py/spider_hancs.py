import re
import requests
import os


def spider(filename):
    # 读取source.txt，赋值给filenames
    fr = open("source.txt", "r")
    filenames = fr.read()
    fr.close()
    # 若文件已存在就不用爬了，直接返回0结束方法
    if filename in filenames:
        print('http://159.226.67.97/hanclass/'+filename+' has checked')
        return 0
    else:
        # 进一步判断，有//代表外部网站，退出当前方法
        if "//" in filename:
            print("it is an other website: "+filename)
            return 0
        else:
            # 包含路径的文件名
            path_filename = 'hanclass/'+filename
            # 利用正则表达，贪心算法提取路径名，为创建对应路径做准备
            path = re.findall('(.*)/', path_filename)[0]
            # 同站的链接filename用的是相对路径，所以需要补齐它的url
            url = 'http://159.226.67.97/hanclass/'+filename
            # 将包含路径的文件名列入source.txt中，代表这个链接已经浏览过了
            fw = open("source.txt", "a+")
            fw.write(path_filename+'\n')
            fw.close()
            # 若文件已经存在且不是php或html，则直接打印结果，结束当前方法，不需要再爬，节约时间和资源
            if (os.path.exists(path_filename)) and not((".php" in path_filename[-5:]) or (".html" in path_filename[-5:])):
                print(url+" is exist and needn't to search link")
                return 0
            else:
                html = requests.get(
                    url, headers={
                        'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0'},
                    cookies={'PHPSESSID': 'b38djl29b3b4udfnordjadpgk5'})
                # 若文件不存在，则需要保存，若存在就结束当前if语句
                if not(os.path.exists(path_filename)):
                    if not(os.path.exists(path)):
                        os.makedirs(path)
                    fw = open(path_filename, 'wb')
                    fw.write(html.content)
                    fw.close()
                # 若文件是php或html，就需要进一步深度爬取链接，否则结束当前if语句
                if (".php" in path_filename[-5:]) or (".html" in path_filename[-5:]):
                    # 因为有的链接<a href=后面没加引号，很不规范，直接筛选出带引号的链接。之后再处理
                    nfilenames = re.findall('<a href=(.*?) ', html.text)
                    for each in nfilenames:
                        # 嵌套两个正则表达式，除去双引号和单引号
                        spider(re.sub('\'', '', re.sub('"', '', each)))
                # 以上两个if语句并没有结束标志，所以需要补一个结束语句
                return 0


# 新建source.txt文件，若文件存在则覆盖
fd = open("source.txt", "w")
fd.close()
spider("outline.php")
# 删除source.txt文件
os.remove("source.txt")

# 以下用全局变量来代替source.txt的办法

# filenames = set()
# spider("outline.php")
# # 最后打印出所有下载了的文件列表
# for each in filenames:
#     print(each)


# def spider(filename):
#     # 声明全局变量filenames
#     global filenames
#     # 若文件已存在就不用爬了，直接返回0结束方法
#     if filename in filenames:
#         print('http://159.226.67.97/hanclass/'+filename+' has checked')
#         return 0
#     else:
#         # 进一步判断，有//代表外部网站，退出当前方法
#         if "//" in filename:
#             print("it is an other website: "+filename)
#             return 0
#         else:
#             # 包含路径的文件名
#             path_filename = 'hanclass/'+filename
#             # 利用正则表达，贪心算法提取路径名，为创建对应路径做准备
#             path = re.findall('(.*)/', path_filename)[0]
#             # 同站的链接filename用的是相对路径，所以需要补齐它的url
#             url = 'http://159.226.67.97/hanclass/'+filename
#             # 将包含路径的文件名列入filenames中，代表这个文件链接已经浏览过了
#             filenames.add(filename)
#             # 若文件已经存在且不是php或html，则直接打印结果，结束当前方法，不需要再爬，节约时间和资源
#             if (os.path.exists(path_filename)) and not((".php" in path_filename[-5:]) or (".html" in path_filename[-5:])):
#                 print(url+" is exist and needn't to search link")
#                 return 0
#             else:
#                 html = requests.get(
#                     url, headers={
#                         'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0'},
#                     cookies={'PHPSESSID': 'b38djl29b3b4udfnordjadpgk5'})
#                 # 若文件不存在，则需要保存，若存在就结束当前if语句
#                 if not(os.path.exists(path_filename)):
#                     if not(os.path.exists(path)):
#                         os.makedirs(path)
#                     fw = open(path_filename, 'wb')
#                     fw.write(html.content)
#                     fw.close()
#                 # 若文件是php或html，就需要进一步深度爬取链接，否则结束当前if语句
#                 if (".php" in path_filename[-5:]) or (".html" in path_filename[-5:]):
#                     # 因为有的链接<a href=后面没加引号，很不规范，直接筛选出带引号的链接。之后再处理
#                     nfilenames = re.findall('<a href=(.*?) ', html.text)
#                     for each in nfilenames:
#                         # 嵌套两个正则表达式，除去双引号和单引号
#                         spider(re.sub('\'', '', re.sub('"', '', each)))
#                 # 以上两个if语句并没有结束标志，所以需要补一个结束语句
#                 return 0

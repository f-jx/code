import requests
import re
import sys
sys.setdefaultencoding("utf-8")

class spider(object):
    def changepage(self,url,total_page):
        now_page = int (re.search('pageNum=(\d+)',url,re.S).group(1))
            

if __name__ == '__main__':
    classinfo = []
    url = 'http://www.jikexueyuan.com/course/?pageNum=1'
    jikespider = spider()
    all_links = jikespider.changepage(url,20)

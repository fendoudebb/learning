## 累加
[https://www.zhangbj.com/p/369.html](https://www.zhangbj.com/p/369.html)
```bash
awk '{sum+=$1}END{print $sum}' test.txt
```
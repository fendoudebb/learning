## 删除
- 删除全部，啥也没输出
```bash
sed d a.txt
```

- 删除第三行并输出
```bash
sed 3d a.txt
```

- 删除3-5行并输出
```bash
sed 3,5d a.txt
```

- 删除第5行到最后一行并输出
```bash
sed 3,$d a.txt
```

- 删除偶数行并输出
```bash
sed 0~2d a.txt
```

- 删除奇数行并输出
```bash
sed 1~2d a.txt
```

- 从第一行起每隔3行删除并输出
```bash
sed 1~3d a.txt
```
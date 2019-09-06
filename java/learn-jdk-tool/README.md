## jstat
- jstat -gccause <pid> 2000 20
- jstat -gcutil <pid> 2000 20

## 输出项
- S0：幸存区1当前使用比例（Survivor space 0 utilization as a percentage of the space's current capacity.）
- S1：幸存区2当前使用比例（Survivor space 1 utilization as a percentage of the space's current capacity.）
- E：伊甸园区使用比例（Eden space utilization as a percentage of the space's current capacity.）
- O：老年代使用比例（Old space utilization as a percentage of the space's current capacity.）
- M：元数据区使用比例（Metaspace utilization as a percentage of the space's current capacity.）
- CCS：压缩使用比例（Compressed class space utilization as a percentage.）
- YGC：年轻代垃圾回收次数（Number of young generation GC events.）
- YGCT：年轻代垃圾回收消耗时间Young generation garbage collection time.
- FGC：老年代垃圾回收次数（Number of full GC events.）
- FGCT：老年代垃圾回收消耗时间（Full garbage collection time.）
- GCT：垃圾回收消耗总时间（Total garbage collection time.）
- LGCC：最后一次GC原因（Cause of last garbage collection）
- GCC：当前GC原因（Cause of current garbage collection）

## 参考
[https://www.zhangbj.com/p/398.html](https://www.zhangbj.com/p/398.html)
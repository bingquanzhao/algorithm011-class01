学习笔记
## 递归
递归模板
```
public void recur(int level, int param) {
        if (level > MAX_LEVEL) {
            return;
        }
        process(level, param);
        // 下一次循环中需要的param
        recur(level + 1, newParam);
    }
```
递归程序最开始需要一个结束条件
接下来需要写对最小可执行单元的操作
接下来是一个递归 ，递归中需要对当前level+1

## 回溯 
是在递归中加入向上跳转重新调试的代码块

## 分治
在递归中假如将子结果集进行合并或者操作

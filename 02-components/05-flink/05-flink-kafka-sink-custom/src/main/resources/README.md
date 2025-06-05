## kafka 测试报文
```Json
{
  "header": {
    "ip": "111",
    "channel": "22",
    "time": "2024-07-15 15:51:00",
    "busType": "Demo",
    "reqId": "9999999"
  },
  "data": {
    "id": "111",
    "name": "22",
    "rtime": "2024-07-15 15:51:00",
    "tag": "Demo",
    "flag": "9999999"
  }
}
  ```

## 启动命令 java参数增加
```Shell
--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED
  ```

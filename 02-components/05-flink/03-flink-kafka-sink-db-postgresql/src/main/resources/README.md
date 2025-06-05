## kafka 测试报文
```Json
{
  "header": {
    "ip": "111",
    "channel": "22",
    "time": "2024-07-15 16:39:00",
    "busType": "Demo",
    "reqId": "9999999"
  },
  "data": {
    "F_VC_ID": "111",
    "F_VC_NAME": "22",
    "F_DT_CREATE_TIME": "2024-07-15 15:51:00",
    "F_DT_UPDATE_TIME": "2024-07-15 15:51:00",
    "F_INT_DEL_FLAG": 0
  }
}
  ```

## 启动命令 java参数增加
```Shell
--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED
  ```

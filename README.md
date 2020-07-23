# fantasytennisapi

Tests:

```bash
# PingController
curl "http://localhost:8081/ping"

# SimpleController
curl "http://localhost:8081/simple/get"

curl -H "Content-Type: application/json" -XPOST -d '{"field1": "new_value", "field2": "new_value"}' "http://localhost:8081/simple/add"
```

DrawController is also available.
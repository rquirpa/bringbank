## Create the war file

Open a terminal and run:

    mvn clean install

## Run using the embedded tomcat

Open a terminal and run:

    mvn tomcat7:run 


## Request sample
    
```    
curl -X GET \
  'http://user:password@localhost:9090/v1/current-accounts/savings-kids-john/transactions?sort=-id' \
  -H 'Postman-Token: 5548a220-d1e8-48d3-935e-b343636f2698' \
  -H 'cache-control: no-cache'
```

```
curl -X GET \
  http://user:password@localhost:9090/v1/current-accounts/savings-kids-john/transactions-type/SEPA \
  -H 'Postman-Token: f5318307-bc3d-42f3-ba19-92f84b29ea45' \
  -H 'cache-control: no-cache'
```

```  
curl -X GET \
  http://user:password@localhost:9090/v1/current-accounts/savings-kids-john/total-amounts \
  -H 'Postman-Token: 1168f2ad-1534-4669-b2cf-17bdeb6085f9' \
  -H 'cache-control: no-cache'  
```
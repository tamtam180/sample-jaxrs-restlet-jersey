# README

JerseyとRestletの違いを示すサンプルです。  
Restletでは、空のリストが受け取れず要素数1(最初の要素がnull)のリストを作ります。  

JerseyとRestletを同居すると以下のエラーが出ることがあります。

    java.lang.IllegalArgumentException: This method supports only the Types Cookie, CacheControl, EntityTag, NewCookie and MediaType 

このエラーが出たときは、クラスパスの指定でJerseyのライブラリをRestletよりも前に書くことで回避することが可能です。

# 実行結果

## Server: @QueryParam("name")

(param)|Jersey|Restlet|
---|---|---
GET ?|[]|[null]
GET ?name=1|[1]|[1]
GET ?name=1&name=2|[1, 2]|[1, 2]
GET ?name[]=1|[]|[null]
GET ?name[]=1&name[]=2|[]|[null]

## Server: @QueryParam("name[]")

(param)|Jersey|Restlet
---|---|---
GET ?|[]|[null]
GET ?name=1|[]|[null]
GET ?name=1&name=2|[]|[null]
GET ?name[]=1|[1]|[1]
GET ?name[]=1&name[]=2|[1, 2]|[1, 2]


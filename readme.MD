


```shell
docker-compose up -d
```


```shell
./gradlew docker
```



## Money Service MVP Version (머니 서비스, Minimal Viable Product)
- 고객의 선불충전금액, 패캠머니의 증액/감액 담당, 기록- 

머니 관련
MemberMoney
LinkedBankAccount
//엄밀히는 Bank Service 의 Data
//Money 입장에서 "연동 되었다" 의미 한정 필요


"머니 증액(충전)/감액 관련"
increaseMoneyRequest        // 실물 계좌 -> 범인계좌로 현금 이동
DecreaseMoneyRequest        // 송금 시 사용 예정
MoneyChangingResultDetail
MoneyChangingHistory

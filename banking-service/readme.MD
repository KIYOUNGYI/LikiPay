## 계좌연동

- RegisteredBankAccount
- RegisteredBankAccountHistory

## 펌뱅킹

- RequestFirmBanking (받는 사람, 보내는 사람, 은행정보, 시간 등등)
- RequestFirmBankingHistory
- BankAccount

## Banking Service MVP Version

- 외부 은행과 입/출금 요청 펌뱅킹 통신을 담당하고, 내부 고객의 계좌 정보를 등록하는 서비스

## Query
- 입금/출금 요청(펌뱅킹) 내역 조회
- firm - FirmBankingInfo (by-membershipId)
  - Request : membershipId
  - Response : FirmBanking object

- 고객의 연동된 계좌 (고객 계좌 연동정보) 조회
- find - RegisteredBankAccount(By-membershipId)
  - Request : membershipId
  - Response : RegisteredBankAccount Object 

## Command
- 고객 정보에 대해 요청된 Account 정보를 매핑, 연동
  - register - BankAccount(-with-membershipId)

  - Request: membershipId, BankAccount
  - Response : RegisteredBankAccount Object

- 실제 실물 계좌에서의 입/출금을 요청하는 폼뱅킹을 요청, 수행
- request - FirmBanking -(-to Remittance)-(-with BankAccount)

    - Request : from Bank Account to Bank Account, Money
    - Response : RequestFirmBanking UUID


# 38-COLLABORATION-ANDROID-BUNJANG
> **LET'S SOPT 38기 안드로이드 1조**
> ⚡번개장터(BUNJANG)

---
## 🪧 Convention

#### 📌 Tag
| 유형 | 설명 | 유형 | 설명 |
| :---: | :--- | :---: | :--- |
| `feat` | 새로운 기능 구현 | `mod` | 코드 수정 |
| `add` | 부수적인 코드/라이브러리 추가 | `del` | 코드 삭제 |
| `fix` | 버그 수정 | `refactor` | 리팩토링 |
| `init` | 프로젝트 초기 세팅 | `chore` | 변수명/함수명 등 사소한 수정 |

#### 💬 Commit
**Commit Format**: `Type/#IssueNumber: 작업 내용` (ex: `feature/#2: 홈 뷰 구현`)

---
## 👥 Team
| 최승재 | 박지영 | 김예지 |
| :---: | :---: | :---: |
| `Android Lead Developer` | `Android Developer` | `Android Developer` |

---

## 🛠 Tech Stacks

### **Language & UI**

**Language**

<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white">

**UI Framework**

<img src="https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=Jetpack%20Compose&logoColor=white">

**Design Pattern**

<img src="https://img.shields.io/badge/MVVM-7CA82B?style=for-the-badge"> <img src="https://img.shields.io/badge/Google%20Recommended%20Architecture-4285F4?style=for-the-badge&logo=Google&logoColor=white">



### **Library**

**Network**

<img src="https://img.shields.io/badge/Retrofit2-FF6F00?style=for-the-badge"> <img src="https://img.shields.io/badge/OkHttp-CC0000?style=for-the-badge"> <img src="https://img.shields.io/badge/Kotlin%20Serialization-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white">

**Dependency**

<img src="https://img.shields.io/badge/Hilt-00CCFF?style=for-the-badge">

---

## ✨ Key Interfaces

### 1. 🏠 홈 (Home)
- `LazyVerticalGrid`를 활용해 2열로 상품 리스트를 배치
- 상품의 이미지, 상품명, 가격, 시간 정보를 한눈에 볼 수 있도록 컴포넌트화

### 2. 🔍 제품 상세 설명 (Product Detail)
- 상품의 상세 이미지, 판매자 정보, 상품 상태 및 설명을 상세하게 제공

### 3. 🛍 거래 완료 (Completed)
- 구매 확정 및 거래 완료 프로세스를 처리하는 화면

---

## 📂 Project Structure
```text
com.sopt.bunjan
├── core           # 공통 코드 및 Util
├── data           # API 통신 및 데이터 로직
├── navigation     # 화면 이동 및 Route 관리
└── presentation   # UI 레이어
    ├── home       # 홈 그리드 리스트 화면
    ├── detail     # 상품 상세 화면
    └── completed  # 거래 완료 화면

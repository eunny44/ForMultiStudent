# default.png 안나오는 해결책

## 데이터베이스 imgdata 안에 들어있는 값 삭제
```
delete from imgdata;
```
거기에 mtInfoImg가 이미 들어가있는데(저번 주에 그것때문에 오류 나서 데이터베이스에 아마 이미지 이름을 test.png 정도로 해서 넣어뒀을 거임.)      
img_name 값이 default.png가 아니라서 그럼.   
RealMultiController 에서 img_id 값이 mtInfoImg인게 없으면 데이터베이스에 넣으라고 한건데    
이미 들어가있으니까 문제 안생겨서 있는 이미지로 출력하는거다.   


추가적으로 AdminController 수정도 해야하는데 내가 저번주에 잊고 안올려둠. 다시 올려뒀다.   
하지만 이건 이미지 안나오는 거랑 관련은 없음.   
default.png 파일을 삭제를 안하는 것일 뿐.   

---------------------------------------------------------------

## 이해하기 쉽도록 역할 정리
### 1. RealMultiController
mt.jsp를 getmapping할 때 mtInfoImg라는 값이 데이터베이스 내에 있는지 확인한다.   
있으면 그 값에서 이름 추출해서 해당 이미지 보여주는 거고   
없으면 img_id가 mtInfoImg이고 img_name이 default.png인 값을 데이터베이스에 넣어준다.    
그러면 mt.jsp에서 이미지 경로 따라서 이미지를 출력해준다.   

### 2. AdminController
mt 정보 수정시에 새로운 이미지를 올렸을 때 default.png 이미지가 새로 올린 이미지 이전의 이미지면 안 지운다.   
테스트할 때 파일 수정했을 때 default.png가 사라지면 매번 다시 넣어줘야 하니까 추가한 것 중 하나.   
마찬가지로 //200808 달아뒀다.

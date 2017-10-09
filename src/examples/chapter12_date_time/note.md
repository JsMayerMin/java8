새로운 날짜와 시간 API
=====
* 자바8에서 새로운 날짜와 시간 라이브러리를 제공하는 이유
* 사람이나 기계가 이해할 수 있는 날짜와 시간 표현 방법
* 시간의 양 정의하기
* 날짜 조작, 포매팅, 파싱
* 시간대와 캘린더 다루기

#### 1.자바8에서 새로운 날짜와 시간 라이브러리를 제공하는 이유
과거 자바에서 제공하는 시간 api는 개발자들을 만족시키지 못했다. 
자바를 처음 접할는 개발자들이 많은 비난을 했던 api는 대부분 자바에 시간 api였다.
> 문제점들 
> * Date클래스 특정시점을 날자가 아닌 밀리초 단위로 제공
> * 1900년 기준으로 하는 offset
> * 0에서 시작하는 달 인덱스
> * ex> Date date = new Date(114, 2, 18); //2014년 3월 18일이다. ㅠㅠ 
> * Date는 JVM 기본 시간대 CET (중앙 유럽시간대) 를 사용했다. 그렇다고 Date클래스가 시간대 정보를 알고 있는 것도 아니다.
> * 이러한 문제를 해결하고자 Canlendar를 제공했지만 여전히 문제가 많았다.
> * 1900년도 시작 offset은 없앴지만 달 인덱스는 여전히 0부터 시작
> * DateFormat같은 일부 기능은 Date 클래스에만 적용됨.
> * 또한 DateFormat은 Thread-safe하지 않다.
> * Date, Calendar모두 mutable클래스이다.

드디어 자바 8에서는 지금까지의 날짜와 시간문제를 개선하는 api를 제공하기 시작했다. Joda-time같은 third-party의 많은 기능
을 java.time 패키지에 추가했다.<br>

LocalDate, LocalTime, Instant, Duration, Period 등 새로운 클래스 제공한다.<br>

#### 2. 사람이나 기계가 이해할 수 있는 날짜와 시간 표현 방법
<p>
LocalDate, LocalTime -> 둘다 모두 불변이며 LocalDate에는 어떠한 시간대 정보도 포함하지 않는다.<br>
DateTimeFormatter -> DateFormat을 대체하는 클래스이다.<br>
LocalDateTime -> LocalDate, LocalTime을 동시에 갖는 클래스이다.<br>
</p>

#### 3. 시간의 양 정의하기
<p>

</p>

#### 4. 날짜 조작, 포매팅, 파싱

#### 5. 시간대와 캘린더 다루기

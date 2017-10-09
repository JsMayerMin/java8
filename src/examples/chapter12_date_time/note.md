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

LocalDate, LocalTime, Instant, Duration, Period 등 새로운 클래스 제공한다.

모든 클래스는 불변이다.

#### 2. 사람이나 기계가 이해할 수 있는 날짜와 시간 표현 방법
* LocalDate, LocalTime -> 둘다 모두 불변이며 LocalDate에는 어떠한 시간대 정보도 포함하지 않는다.
* DateTimeFormatter -> DateFormat을 대체하는 클래스이다.
* LocalDateTime -> LocalDate, LocalTime을 동시에 갖는 클래스이다.

#### 3. 시간의 양 정의하기
 * Instant : 기계적인 관점에서 시간을 양으로 표현한다. Unix Epoch time(1970년 1월 1일 0시 0분 0초 UTC)를 기준으로 
 특정 시점까지의 시간을 초로 표현하며, 나노초 단위의 정밀도를 제공한다.
 * Duration : 두 시간 객체 사이의 지속시간을 만들 수 있다. 초와 나노초 단위로 제공하므로 LocalDateTime, Instant, LocalTime 클래스를 사용할 수 있다.
 * Period : LocalDate를 사용할 수 있다. 

#### 4. 날짜 조작, 포매팅, 파싱
지금까지 살펴본 모든 클래스는 불변이지만 시간을 조정해야하는 요구사항이 발생한다. 
with~,plus~,minus~ 함수는 모두 새로운 객체를 반환한다.

TemporalAdjusters에 구현된 정적 메소들를 통해서 날짜와 관련된 다양한 작업을 할 수 있다.

ex> 다음주 일요일, 마주하는 일요일, 이번달 마지막날, 다음달 첫째주 일요일 등등


#### 5. 시간대와 캘린더 다루기
ZoneId, ZoneOffset, ZonedDateTime, OffsetDateTime 등을 활용해서 해당 지역 국가의 시간을 컨트롤 할 수 있다.

ISO-8601 캘린더 시스템이 표준이며, ThaiBuddhistDate, MinguoDate, JapaneseDate, HirahDate 4개의 캘린터 시스템을 추가로 제공한다.


#### 요약



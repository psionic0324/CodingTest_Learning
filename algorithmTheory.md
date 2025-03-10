### [시간, 공간복잡도]

> 컴퓨터는 1초에 대략 3~5억개의 연산을 처리함

시간복잡도 : 입력의 크기와 문제를 해결하는데 걸리는 시간의 상관관계

빅오표기법 : 주어진 식을 값이 가장 큰 대표항만 남겨서 나타내는 방법 ex) 5N + 3 -> O(N)

```text
O(1) < O(logN) < O(N) < O(NlogN) < O(N^2) < O(2^N) < O(N!)  
N <= 11 -> O(N!)  
N <= 25 -> O(2^N)  
N <= 5,000 -> O(N^2)  
N <= 1,000,000 -> O(NlogN)  
N <= 10,000,000 -> O(N)  
그 이상 -> O(logN), O(1)
```

공간복잡도 : 입력의 크기와 문제를 해결하는데 필요한 메모리의 상관관계  
(공간 복잡도는 크게 중요하지 않음, 512MB = 1.2억개의 int)

### [자료형] (Java 기준)

char : 2byte  
int : 4byte  
long : 8byte  
float : 4byte  
double : 8byte  
(실수 자료형의 경우 오차가 발생할 수 있으므로 주의)

### [표준 입출력]

```
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
String b = sc.next();
sc.close(); (close()를 해주지 않으면 자원이 누수될 수 있음)
```

그런데 Scanner는 느리기 때문에 BufferedReader를 사용하는 것이 좋음

```
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int a = Integer.parseInt(br.readLine());
String b = br.readLine();
```

(BufferedReader는 scanner와 달리 예외처리를 해주어야 함)  
System.in은 키보드로부터 입력을 받는 표준 입력 스트림  
inputStreamReader는 바이트 스트림을 문자 스트림으로 변환하는 보조 스트림

### [배열 Array]

배열은 메모리 상에 원소를 연속하게 배치한 자료구조  
배열의 성질

- O(1)에 k번째 원소를 확인/변경 가능
- 추가적으로 소모되는 메모리(=overhead)가 거의 없음
- Cache hit rate가 높음 (Cache hit : 메모리에서 데이터를 찾아 성공적으로 제공되는 것)
- 메모리 상에 연속한 위치를 차지하므로 할당에 제약이 있음
  배열의 성능
- 임의의 위치에 있는 원소를 확인/변경하는 경우 : O(1)
- 원소를 끝에 추가하거나 삭제하는 경우 : O(1)
- 임의의 위치에 원소를 추가하거나 삭제하는 경우 : O(N)

```
type[] name = new type[]; (name.length)
String name = ~;
.toCharArray();
.charAt();
.split();
```

### [연결 리스트 LinkedList]

연결 리스트는 원소를 저장할 때 그 다음 원소가 있는 위치를 포함시킴  
연결 리스트의 성질

- k번째 원소를 확인/변경하기 위해 O(k)가 필요함
- 임의의 위치에 원소를 추가/제거는 O(1)
- 원소들이 메모리 상에 연속해있지 않아 Cache hit rate가 낮지만 할당이 다소 쉬움
  연결 리스트의 종류
- 단일 연결 리스트, 이중 연결 리스트, 원형 연결 리스트
  연결 리스트의 구현

```
struct NODE {
  struct NODE *prev, *next;
  int data;
}
```

```
LinkedList<type> name = new LinkedList<>();
List<type> name = new ArrayList<>(); Vector<>(); (Arrays.asList(""))
```

***

### [스택 Stack]

스택은 FILO(First In Last Out) 자료구조라고 부름  
스택의 성질

- 원소의 추가/제거는 O(1)
- 제일 상단의 원소 확인이 O(1)
- 제일 상단이 아닌 나머지 원소들의 확인/변경은 불가능

스택의 함수

```
Stack<자료형> 이름 = new Stack<>();
```

1. 삽입

```
.add(value); 성공시 true, 실패 시 예외 발생
.push(value); 성공시 true, 실패시 false
```

2. 삭제

```
.remove(index); 반환 값 : 제거한 원소 (잘못된 index 입력 시 예외 발생)
.pop(); 반환 값 : 제거한 원소
```

3. 상단값 확인

```
.peek(); 반환 값 : 제일 상단의 값
```

4. 크기 확인

```
.size(); 반환 값 : 스택의 크기
```

5. 비어있는지 확인

```
.isEmpty(); 반환 값(boolean) : 비어있으면 true, 아니면 false
```

***

[StringTokenizer & StringBuilder]

```
StringTokenizer st = new StringTokenizer(br.readLine());
st.nextToken();

StringBuilder sb = new StringBuilder();
sb.append();
sb.toString();

(앞뒤 공백 제거 : trim())
```

***

### [큐 Queue]

큐는 FIFO(First In First Out) 자료구조라고 부름  
큐의 성질

- 원소의 추가/제거는 O(1)
- 제일 앞/뒤의 원소 확인이 O(1) (자바는 뒤 원소 확인이 어려움)
- 제일 앞/뒤가 아닌 나머지 원소들의 확인/변경이 불가능
  큐의 함수

```
Queue<자료형> 이름 = new LinkedList<>();
```

1. 삽입

```
.add(value) -> 성공시 true, 실패 시 예외 발생
.offer(value) -> 성공시 true, 실패시 false
```

2. 삭제

```
.remove() -> 삭제된 값 반환 (공백이면 예외 발생)
.poll() -> 삭제된 값 반환
```

3. front값 확인

```
.element() -> head 값 반환 (공백이면 예외 발생)
.peek() -> head 값 반환 (공백이면 null 반환)
```

4. 크기 확인

```
.size() -> 큐 사이즈 확인
```

5. 비어있는지 확인

```
.isEmpty() -> 공백이면 true, 아니면 false 반환
```

***

### [덱 Deque]

덱은 양쪽에서 삽입과 삭제가 전부 가능함  
Double Ended Queue라는 뜻을 가지고 있음

덱의 성질

- 원소의 추가/제거는 O(1)
- 제일 앞/뒤의 원소 확인이 O(1)
- 제일 앞/뒤가 아닌 나머지 원소들의 확인/변경이 불가능
  덱의 함수

```
  Deque<자료형> 이름 = new LinkedList<>();
```

1. 삽입 (.~First(), .~Last()를 붙임)

```
   .add(value) -> 성공시 true, 실패 시 예외 발생
   .offer(value) -> 성공시 true, 실패시 false
   ```

2. 삭제

```
   .remove() -> 삭제된 값 반환 (공백이면 예외 발생)
   .poll() -> 삭제된 값 반환 (공백이면 NULL)
   ```

3. front값 확인

```
   .get() -> 값 반환 (공백이면 예외 발생)
   .peek() -> 값 반환 (공백이면 null 반환)
   ```

4. 크기 확인

```
   .size() -> 큐 사이즈 확인
   ```

5. 비어있는지 확인

```
   .isEmpty() -> 공백이면 true, 아니면 false 반환
```

***

### [BFS Breadth First Search 너비 우선 탐색]

BFS는 그래프나 트리를 탐색하는 알고리즘 중 하나로,  
시작 노드에서 가까운 노드부터 차례대로 탐색하는 알고리즘

BFS 진행 과정

1. 탐색을 시작할 노드를 큐에 넣고 방문표시함
2. 큐에서 노드를 꺼내고 방문하지 않은 인접 노드를 큐에 추가하고 방문표시
3. 큐가 빌 때 까지 반복

BFS의 구현

```
class Node {
    int x;
    int y;
    Node (x, y) {
        this.x = x;
        this.y = y;
    }
}

int[][] board = new int[][];
boolean[][] visited = new boolean[][];
int[] dx = {1, 0, -1, 0};
int[] dy = {0, 1, 0, -1};
Queue<Node> queue = new LinkedList<>();

bfs() {
    queue.add(start);
    visit[][] = true;
    
    while(!queue.isEmpty()) {
        Node cur = queue.remove();
        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (visited[nx][ny] || board[nx][ny] != 1)
                continue;
            queue.add(new Node(nx, ny));
            visited[nx][ny] = true;
        }
    }
}
```
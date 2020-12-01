import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class test {
	static int 카페수 = 5;  // 카페 수 DB에서 실제 카페 수 가져와서 넣기.
	static int 해시태그수 = 10;
	static int [] 카페id = new int[카페수];  // id (primary key) 넣어줄 배열선언.
	static String [] 카페해시태그 = new String[카페수];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new 카페id초기화();
		Map<Integer,Integer> map = new HashMap<>();  // 카페id, 겹치는 수치를 저장할 map 선언. 
		//예) 카페아이디가 120인 카페는 해당 유저와 3개의 해시태그가 겹칠 때  120=3 이런식으로 저장
		
		for(int index=0;index<카페수;index++) {  //모든 카페 비교
			
			String test_hashtag = 카페해시태그[index];  //
			
			String test_user_hashtag = "hj,sb,haha";  // user의 해시태그 가져왔다고 가정. 테스트
			
			Set<String> set_hashtag = new HashSet<String>();  // 카페 해시태그가 저장될 set
			Set<String> set_user_hashtag = new HashSet<String>();  // 유저 해시태그가 저장될 set
			int start = 0;

			for(int i=0;i<test_hashtag.length();i++){  // 카페 해시태그 슬라이싱해서 저장 set에 저장.
				if(test_hashtag.charAt(i) == ','){
					set_hashtag.add(test_hashtag.substring(start,i));
			        start=i+1;
				}
			}
			System.out.println(set_hashtag);  // 슬라이싱된 카페 해시태그 출력 (테스트).
			
			start = 0;
			for(int i=0;i<test_user_hashtag.length();i++){ //유저 해시태그 슬라이싱해서 저장 set에 저장.
				if(test_user_hashtag.charAt(i) == ','){
					set_user_hashtag.add(test_user_hashtag.substring(start,i));
			        start=i+1;
				}
			}
			System.out.println(set_user_hashtag);  // 슬라이싱된 유저 해시태그 출력 (테스트).
			
			Iterator<String> it = set_user_hashtag.iterator();  //하나씩 꺼내서 겹치는거 찾기 위해 선언.
			int count=0;
	        while (it.hasNext()) {
	            Object tmp = it.next();
	            if (set_hashtag.contains(tmp)) {  // 유저의 해시태그가 카페해시태그 set에 있다면, count++
	                count++;
	            }
	        }
	        System.out.println(count);  // 유저의 해시태그가 해당 카페 해시태그와 몇개나 겹치는지 count 출력(테스트)
	        
	        
	        map.put(카페id[index],count);  // getKey() = id, getValue() = 수치
	       
		}
		System.out.println("map 출력 (key=value) : "+map);
		System.out.println("value값으로 key 찾기 시작.");  // 이걸 응용해서 순서대로 나열하면 될거같아.
		for(int i=0;i<해시태그수;i++) {
			System.out.println("해시태그 "+(해시태그수-i)+"개가 겹치는 id값들 : "+getKey(map,해시태그수-i));  // 여기에 웹페이지에 나열하는 코드가 들어가면 높은 순서대로 
		}
		
		List<Integer> list = getKey(map,2);  // 특정 value 로 Key 값 찾기.
		System.out.println("하나만 찍어보기 (value 값이 2인 경우 중에서 첫번째 id만) list.get(0) : "+list.get(0));  // value로 Key값 찾아서 여러개 중 index화 하여 찍어보기. 테스트는 0으로했음.
        
	}
	public static List<Integer> getKey(Map<Integer, Integer> map, Object value) {
		List<Integer> list = new ArrayList<Integer>();
	    for(Object o: map.keySet()) {
	        if(map.get(o).equals(value)) {
	        	//System.out.println(o.getClass().getName());  // type 확인.
	        	list.add((Integer) o);
	        }
	    }
	    return list;
	}

}

class 카페id초기화 extends test{
	public 카페id초기화() {
		for(int i=0;i<카페수;i++) {
			카페id[i] = (i+1)*1+10000;  // 디비에서 카페 id(primary Key) 실제 값 가져오기.
			카페해시태그[i] = "해준,승빈,똥,똥개넘,혜준이마음,귀여워,";  // 디비에서 카페해시태그 실제 값 가져오기.
		}
		카페해시태그[3] = "해준,승빈,똥,ㅅㄹㅎ,";  // 테스트로 다른값 넣기
		카페해시태그[1] = "해준,승빈,ㅅㄹㅎ,귀여워,확씨,";  // 테스트로 다른값 넣기
	}
	
}

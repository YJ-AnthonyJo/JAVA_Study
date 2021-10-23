import Package.HouseKim;
//다른 클래스에서 HouseKim 클래스를 사용하려면 다음과 같이 import 해야한다.

import Package.*;
//이와 같이 *을 이용하면 Package내의 모든 클래스를 import하게 된다.
//질문 : 서브패키지까지 import되는 것인가?
// ->안된다.
//아래와 같은 서브패키지 import가 필요하다.
import Package.person.EungYongPark;


public class Package_Use {
    EungYongPark var = new EungYongPark();
}


//만일, 같은 패키지(폴더) 내에 있는 클래스라면 따로 import할 필요는 없다.
//같은 패키지 내에서는 import없이 사용가능하다.

//패키지의 장점
//1. 클래스의 분류가 용이하다.
//2. 패키지가 다르다면 동일한 클래스명을 사용할 수 있다.
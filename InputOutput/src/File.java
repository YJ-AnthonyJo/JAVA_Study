import java.io.*;
import java.nio.charset.StandardCharsets;

public class File {
    public static void main(String[] args) throws IOException {
        //**********OUT**********
        FileOutputStream output = new FileOutputStream("./out.txt");
        // out.txt가 생성된다. 음.. 무조건 w모드인가?
//        output.close();
        //프로그램 종료시 자동으로 객체를 삭제한다. 하지만 직접 종료해주는 것이 좋다.
        //사용했던 파일을 닫지 않고 다시 사용하고자 할때는 에러가 발생할 수 있기에..

        //파일에 내용쓰기
        for(int i=0;i<10;i++){
            String data = (i+1)+"번째 줄입니다.\r\n";
            //byte배열로 써야한다. -> String을 byte배열로 바꾸는 getBytes()메소드를 이용해야한다.
            //줄바꿈은 Windows의 경우 \r\n(CRLF), 유닉스의 경우 \n(LF)로 하면 된다.
            output.write(data.getBytes(StandardCharsets.UTF_8));
        }
        output.close();

        //위 방법 : String을 byte로 바꾸어야 -> 불편하다. -> 편리한 방법을 사용하자
        // : FileWriter
        FileWriter fw = new FileWriter("./out1.txt");
        for(int i=0;i<10;i++){
            String data = (i+1)+"번째 줄입니다.\r\n";
            fw.write(data);
        }
        fw.close();

        //\r\n안붙이는 방법 : PrintWriter사용.
        PrintWriter pw = new PrintWriter("./out2.txt");
        for(int i=0;i<10;i++){
            String data = (i+1)+"번째 줄입니다.";
            pw.println(data);
        }
        pw.close();
        //PrintStream과의 차이.
        //System.out대신에 PrintWriter를 이용할 뿐이다.


        //a모드(추가 모드)로 열기
        //FileWriter
        fw = new FileWriter("out1.txt", true); //두번째 인자 : append여부
        for(int i=10;i<20;i++) {
            String data = (i+1)+"번째 줄입니다.\r\n";
            fw.write(data);
        }
        fw.close();

        //PrintWriter
        //PrintWriter의 생성인자로 파일명 대신 추가모드가 열련 FileWriter의 객체를 전달한다.
        pw = new PrintWriter(new FileWriter("./out2.txt", true));
        for(int i=10;i<20;i++) {
            String data = (i+1)+"번째 줄입니다.";
            pw.println(data);
        }
        pw.close();

        //**********IN**********(파일 읽기)
        //1024바이트만 읽기
        byte[] b = new byte[1024];
        FileInputStream input = new FileInputStream("./out2.txt");
        input.read(b);
        System.out.println(new String(b));
        input.close();

        //라인단위로 연속적으로 읽기 : BufferedReader사용.
        //BufferReader객체.readlnie : 더 이상 읽을 라인이 없을 경우 null리턴
        BufferedReader br = new BufferedReader(new FileReader("./out2.txt"));
        while (true){
            String line = br.readLine();
            if(line==null) break;
            System.out.println(line);
        }
        br.close();
    }
}

//Throws??
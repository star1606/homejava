package jang;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;

import airplane.Air;
import org.json.XML;

public class Shrimp extends JFrame {

	int panelX = 400;
	int panelY = 180;
	
	// 공공데이터에서 받아온 값을 사용하기 위한 스태틱 변수
	static int aa = 0;
	static int bb = 0;
	static int cc = 0;
	
	static int a = 0;
	static int b = 0;
	static int c = 0;
	
	//패널 생성 및 그래프 그리기
	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawString("2019.10", (int) (panelX * (0.2)), (int) (panelY * (0.9)));
			g.drawString("2019.11", (int) (panelX * (0.4)), (int) (panelY * (0.9)));
			g.drawString("2019.12", (int) (panelX * (0.6)), (int) (panelY * (0.9)));

			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(aa), (int) (panelX * (0.2)) + 10, (int) (panelY * (0.8) - a) - 10);
			g.drawString(Integer.toString(bb), (int) (panelX * (0.4)) + 10, (int) (panelY * (0.8) - b) - 10);
			g.drawString(Integer.toString(cc), (int) (panelX * (0.6)) + 10, (int) (panelY * (0.8) - c) - 10);

			g.setColor(Color.BLUE);
			g.fillRect((int) (panelX * (0.2)), (int) (panelY * (0.8) - a), 50, a);
			g.fillRect((int) (panelX * (0.4)), (int) (panelY * (0.8) - b), 50, b);
			g.fillRect((int) (panelX * (0.6)), (int) (panelY * (0.8) - c), 50, c);

		}
	}
	
	// 패널 인스턴스 생성
	private MyPanel mp = new MyPanel();
	
	// GUI생성자 
	public Shrimp() {
		setTitle("중국산 뱀장어(앵궐라종) 수입현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mp); // 패널을 mp로 교체
		mp.setLayout(null); // 레이아웃을 absolute로 교체

		setSize(panelX, panelY + 30);
		setVisible(true);
	}

	public static String change(String date) throws Exception {
		// 1번 주소 객체 만들기
		URL url = new URL("http://apis.data.go.kr/1192000/openapi/service/ManageExpNationItemService/getExpNationItemList?serviceKey=zkymID3s0eE1ymiOd0WYTwCEMeo4qKgV5e9DGU6QHceEc%2BWgah6BN5uEhr9tFRjolXkryBNbw9CNLnn6z9LTpg%3D%3D&numOfRows=10&pageNo=10&baseDt="+ date +"&nationNm=%EC%A4%91%EA%B5%AD&imxprtSeNm=%EC%88%98%EC%9E%85&itemNm=%EB%B1%80%EC%9E%A5%EC%96%B4");

		// 2번 스트림 연결
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// 3번 버퍼 연결 (문자열)
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		
		// 4. 문자 더하기
		StringBuilder sb = new StringBuilder();
		
		String input = "";
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		
		br.close(); // 버퍼 닫기
		con.disconnect(); // 스트림 닫기
		
		
		// XML을 JSON으로 변환 (org.json 이용)
		// https://github.com/stleary/JSON-java
		org.json.JSONObject jsonOb = XML.toJSONObject(sb.toString());
		String jsonString = jsonOb.toString();
		
		
		// 5. 자바 오브젝트로 변환
		Gson gson = new Gson();
		Jang jang = gson.fromJson(jsonString, Jang.class);
		
		// 수입량 리턴
		return jang.getResponseXml().getBody().getItem().get(0).getImxprtWt();
	}

	public static void main(String[] args) {
		
		// 3개월간의 수입량을 저장하기위한 어레이리스트
		ArrayList<String> amount = new ArrayList<>();
		
		try {
			// 월별 수입량을 리스트에 추가
			amount.add(change("201910"));
			amount.add(change("201911"));
			amount.add(change("201912"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 월별 수입량 중 최대값 구하기
		double max = 0;
		double test = 0;
		for (String string : amount) {
			int i = Integer.parseInt(string);
			test = i;
			if(i > max) {
				max = i;
			}
		}
		
		
		// 스태틱 변수에 값 넘겨주기
		Shrimp.aa = Integer.parseInt(amount.get(0));
		Shrimp.bb = Integer.parseInt(amount.get(1));
		Shrimp.cc = Integer.parseInt(amount.get(2));
		
		Shrimp.a = (int)(Integer.parseInt(amount.get(0)) / max * 100);
		Shrimp.b = (int)(Integer.parseInt(amount.get(1)) / max * 100);
		Shrimp.c = (int)(Integer.parseInt(amount.get(2)) / max * 100);
		
		// GUI실행
		new Shrimp();
	}
}

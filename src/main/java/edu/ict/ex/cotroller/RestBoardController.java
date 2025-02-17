package edu.ict.ex.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.page.PageVO;
import edu.ict.ex.service.BoardService;
import edu.ict.ex.service.DeptSevice;
import edu.ict.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


//RestController 란 기존의 controller의 속성하고는 판이하게 다름

//https://luckyguystory.tistory.com/96
//ResponseEntity<String> 객체
//@RestController : Controller가 REST 방식을 처리하기 위한 것임을 명시
//@ResponseBody : 일반적인 JSP와 같은 뷰로 전달되는 게 아니라 데이터 자체를 전달하기 위한 용도
//@PathVariable : URL 경로에 있는 값을 파라미터로 추출할 때 사용
//@CrossOrigin : Ajax의 크로스 도메인 문제를 해결해주는 어노테이션
//@RequestBody : JSON 데이터를 원하는 타입으로 바인딩 처리

@Slf4j
@RestController
@RequestMapping("/boards")
public class RestBoardController {

	@Autowired
	private BoardService boardService;
	
	//자바객체를 json으로 바꿔서 서비스 하고 있음
	@GetMapping("/list")
	public List<BoardVO> list(){
		log.info("list() ..");
		
		return boardService.getList();		
	}
	
	//특정 게시판 번호를 받으면 해당 게시판 정보 서비스
	@GetMapping("/{bid}") // 경로 변수 
	public BoardVO content(BoardVO boardVO){
		log.info("content() ..");
				
		return boardService.get(boardVO.getBid());
	}
	
	//@PathVariable : URL 경로에 있는 값을 파라미터로 추출할 때 사용
	
	@GetMapping("/shop/{id}/{product}") // 경로 변수 
	public String content(@PathVariable int id,@PathVariable String product){
		System.out.println("아이디==========" +  id);
				
		return  "<h1>"+ "상품번호는 " +  id + product + "</h1>"; 
	}
	
	@GetMapping("/{bid}/{bname}/{btitle}") // 경로 변수 
	public BoardVO bidcontent(BoardVO boardVO){
		System.out.println("아이디==========" +  boardVO);
				
		return boardVO;
	}
	
	
	@GetMapping("/rest") // 경로 변수 
	public ModelAndView rest(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rest/rest");
				
		return  mv;
	}
	
	//     /boards/
	//@RequestBody json을 자바 객체로 변환
//	@PostMapping("/") 
//	public String write(@RequestBody BoardVO board ){
//		log.info("write..");
//		log.info("board" + board);
//		
//		String words = "SUCCESS";
//		
//		try {
//			boardService.writeBoard(board);
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//			 words = "FAIL";
//		}
//		
//				
//		return  words;
//	}
	
	@PostMapping("/") 
	public ResponseEntity<String> write(@RequestBody BoardVO board ){
		
		log.info("write..");
		log.info("board" + board);
		
		ResponseEntity<String> entity = null;
		
		try {
			boardService.writeBoard(board);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);	
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);	
		}
						
		return  entity;
	}
	
	@DeleteMapping("/{bid}") 
	public ResponseEntity<String> delete(BoardVO board){
		
		log.info("delete..");
		log.info("board" + board);
		
		ResponseEntity<String> entity = null;
		
		try {
			int rn = boardService.remove(board.getBid());
			// 삭제가 성공하면 삭제된 갯수 출력
			log.info("delete 넘어온 숫자:::::" + rn);
			
			entity = new ResponseEntity<String>(String.valueOf(rn), HttpStatus.OK);	
			
		} catch (Exception e) {
			e.printStackTrace();
			// 삭제가 실패하면 실패 상태메시지 저장
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);	
		}
						
		return  entity;
	}
	
	
}

package com.spring.board;

import java.util.List;

public interface BoardService {

	//3-1. �� ��� ó�� �޼ҵ�: insertBoard() 
	void insertBoard(BoardDTO dto);

	//3-2. �� ���� ó�� �޼ҵ�: updateBoard() 
	void updateBoard(BoardDTO dto);

	//3-3. �� ���� ó�� �޼ҵ�: deleteBoard() 
	void deleteBoard(BoardDTO dto);

	//3-4. �� �� ��ȸ ó�� �޼ҵ�: getBoard() : ���ڵ� 1���� DB���� select �ؼ� DTO ��ü�� ��Ƽ� ����
	BoardDTO getBoard(BoardDTO dto);

	//3-3. �� ��� ó�� �޼ҵ�: getBoardList() : ���� ���ڵ� 
	List<BoardDTO> getBoardList(BoardDTO dto);

}
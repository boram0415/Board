package board.dto;


import board.entity.BoardEntity;
import lombok.*;
import java.time.LocalDateTime;

// DTO (Date Transfer object) == VO , Bean  (비슷한것들임 , 동일한 목적을 가지고 있음)
// DTO DB 에서 받아온 데이터를 controller 에서 가공할 수 있는 데이터
// Entity 데이터들의 집약체 (실제 데이터를 담는 곳)

@Getter
@Setter
@ToString
/*
*  기본 생성자를 생성함과 동시에 access = PROTECTED 옵션을 주면
* 모든 필드에 대한 값이 들어가야함을 보장하고 싶을 때 기본 생성자 호출을 막음으로써 무분별한 객체 생성을 막을 수 있다.
 * */
@NoArgsConstructor
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;


    public BoardDTO(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());
        return boardDTO;
    }

}

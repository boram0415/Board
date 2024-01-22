package board.service;

import board.dto.BoardDTO;
import board.entity.BoardEntity;
import board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toSaveEntity(boardDTO));
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntitiyList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for (BoardEntity entity : boardEntitiyList) {
            boardDTOList.add(BoardDTO.toBoardDTO(entity));
        }
        return boardDTOList;
    }

    @Transactional
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        BoardEntity boardEntity;
        if (optionalBoardEntity.isPresent()) {
            boardEntity = optionalBoardEntity.get();
            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
            return boardDTO;
        } else {
            return null;
        }

    }
}

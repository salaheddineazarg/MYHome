package com.spring.myhome.service.interfaces;

import com.spring.myhome.dto.Piece.PieceDto;
import com.spring.myhome.dto.Piece.PieceDtoResponse;
import com.spring.myhome.entities.Piece;

import java.util.List;
import java.util.UUID;

public interface IPiece extends IData<PieceDtoResponse, PieceDto, UUID>{


    List<Piece> savePieceService( List<PieceDto> pieceDtos,UUID floorId);
}

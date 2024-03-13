package com.spring.myhome.controller;


import com.spring.myhome.dto.Piece.PieceDto;
import com.spring.myhome.dto.Piece.PieceDtoResponse;
import com.spring.myhome.service.interfaces.IPiece;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/piece")
public class PieceController  extends GenericControllerImpl<PieceDtoResponse, PieceDto,IPiece> {


    public PieceController(IPiece service){
        super(service);
    }

}


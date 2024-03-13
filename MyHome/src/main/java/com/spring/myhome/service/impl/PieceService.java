package com.spring.myhome.service.impl;

import com.spring.myhome.dto.Piece.PieceDto;
import com.spring.myhome.dto.Piece.PieceDtoResponse;
import com.spring.myhome.entities.Floor;
import com.spring.myhome.entities.Piece;
import com.spring.myhome.repository.FloorRepository;
import com.spring.myhome.repository.PieceRepository;
import com.spring.myhome.service.interfaces.IPiece;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PieceService extends GenericServiceImpl<PieceDtoResponse,PieceDto, Piece,PieceRepository>
        implements IPiece {


    private  final ModelMapper modelMapper;
    private final PieceRepository pieceRepository;

    private final FloorRepository floorRepository;


    public PieceService(PieceRepository pieceRepository,
                        ModelMapper modelMapper,
                        FloorRepository floorRepository){
        super(pieceRepository);
        this.modelMapper = modelMapper;
        this.pieceRepository =pieceRepository;
        this.floorRepository = floorRepository;

    }


    @Override
    public Optional<PieceDtoResponse> saveService(PieceDto pieceDto) {
        Piece piece = convertRequestToEntity(pieceDto);
        Floor floor = floorRepository.findById(pieceDto.getFloor_id()).get();
        if (floor.getPieceNbr()> pieceRepository.countPieceByFloorId(pieceDto.getFloor_id())){
            piece = pieceRepository.save(piece);

            return Optional.of(convertEntityToResponse(piece));
        }

        return Optional.empty();
    }

    @Override
    protected Piece convertRequestToEntity(PieceDto pieceDto) {
        return modelMapper.map(pieceDto,Piece.class);
    }

    @Override
    protected PieceDtoResponse convertEntityToResponse(Piece piece) {
        return modelMapper.map(piece, PieceDtoResponse.class);
    }
}

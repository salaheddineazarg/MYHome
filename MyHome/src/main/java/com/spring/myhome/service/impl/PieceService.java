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

import java.util.ArrayList;
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
        return super.saveService(pieceDto);
    }

    @Override
    public List<Piece> savePieceService(List<PieceDto> pieceDtos) {
        List<Piece> savedPieces = new ArrayList<>();
        for (PieceDto pieceDto : pieceDtos) {
            Piece piece = convertRequestToEntity(pieceDto);
            Optional<Floor> floorOptional = floorRepository.findById(pieceDto.getFloor_id());
            if (floorOptional.isPresent()) {
                Floor floor = floorOptional.get();
                if (floor.getPieceNbr() > pieceRepository.countPieceByFloorId(pieceDto.getFloor_id())) {
                    piece = pieceRepository.save(piece);
                    savedPieces.add(piece);
                }
            }
        }
        return savedPieces;
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

/*     */ package mzm.gsp.chess.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity3.confbean.SChessCfg;
/*     */ import mzm.gsp.chess.ChessPieceInfo;
/*     */ import mzm.gsp.chess.SChessMoveFailRep;
/*     */ import mzm.gsp.chess.SNotifyChessMove;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChessGameInfo;
/*     */ import xbean.ChessPiece;
/*     */ 
/*     */ public class PCChessMoveReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fromCellIndex;
/*     */   private final int toCellIndex;
/*     */   
/*     */   public PCChessMoveReq(long roleId, int fromCellIndex, int toCellIndex)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.fromCellIndex = fromCellIndex;
/*  23 */     this.toCellIndex = toCellIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  29 */     Long chessGameId = xtable.Role2chessgameinfo.get(Long.valueOf(this.roleId));
/*  30 */     if (null == chessGameId)
/*     */     {
/*     */ 
/*  33 */       onFail(-1, null);
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     ChessGameInfo xChessGameInfo = xtable.Chessgameinfo.get(chessGameId);
/*  38 */     if (null == xChessGameInfo)
/*     */     {
/*  40 */       String logstr = String.format("[chess]PCChessMoveReq.processImp@xChessGameInfo not exsists!!!|chessGameId=%d,roleId=%d", new Object[] { chessGameId, Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  43 */       ChessGameManager.logger.error(logstr);
/*  44 */       onFail(-1, null);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!ChessGameManager.isCurrentPlayerSelf(this.roleId, xChessGameInfo))
/*     */     {
/*  50 */       onFail(-2, xChessGameInfo);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (xChessGameInfo.getNext_operate_time() > mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/*  56 */       onFail(-11, xChessGameInfo);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     SChessCfg sChessCfg = SChessCfg.get(xChessGameInfo.getCfg_id());
/*  62 */     if (!ChessGameManager.isChessCellIndexValid(this.fromCellIndex, sChessCfg))
/*     */     {
/*  64 */       onFail(-3, xChessGameInfo);
/*  65 */       return false;
/*     */     }
/*  67 */     if (!ChessGameManager.isChessCellIndexValid(this.toCellIndex, sChessCfg))
/*     */     {
/*  69 */       onFail(-7, xChessGameInfo);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     ChessPiece xFromChessPiece = (ChessPiece)xChessGameInfo.getChess_board_index2chess_piece().get(Integer.valueOf(this.fromCellIndex));
/*  74 */     if (null == xFromChessPiece)
/*     */     {
/*     */ 
/*  77 */       onFail(-4, xChessGameInfo);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (!xFromChessPiece.getVisible())
/*     */     {
/*  83 */       onFail(-6, xChessGameInfo);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (!ChessGameManager.isChessPieceSelf(this.roleId, xFromChessPiece, xChessGameInfo))
/*     */     {
/*  89 */       onFail(-5, xChessGameInfo);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if (!isMoveValid(this.fromCellIndex, this.toCellIndex, sChessCfg))
/*     */     {
/*  95 */       onFail(-8, xChessGameInfo);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     boolean haveKill = false;
/*     */     
/* 102 */     ChessPiece xToChessPiece = (ChessPiece)xChessGameInfo.getChess_board_index2chess_piece().get(Integer.valueOf(this.toCellIndex));
/* 103 */     ChessGameManager.OperationType operationType; ChessGameManager.OperationType operationType; if (null == xToChessPiece)
/*     */     {
/*     */ 
/* 106 */       xChessGameInfo.getChess_board_index2chess_piece().remove(Integer.valueOf(this.fromCellIndex));
/* 107 */       xChessGameInfo.getChess_board_index2chess_piece().put(Integer.valueOf(this.toCellIndex), xFromChessPiece);
/* 108 */       operationType = ChessGameManager.OperationType.MOVE;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 114 */       if ((xFromChessPiece.getOwn_by_a() == xToChessPiece.getOwn_by_a()) && (xToChessPiece.getVisible()))
/*     */       {
/* 116 */         onFail(-9, xChessGameInfo);
/* 117 */         return false; }
/*     */       ChessGameManager.OperationType operationType;
/* 119 */       if (xToChessPiece.getVisible())
/*     */       {
/*     */ 
/* 122 */         if (!ChessGameManager.canChessAKillChessB(xFromChessPiece.getChess_piece_index(), xToChessPiece.getChess_piece_index(), sChessCfg))
/*     */         {
/*     */ 
/* 125 */           onFail(-10, xChessGameInfo);
/* 126 */           return false;
/*     */         }
/*     */         
/* 129 */         xChessGameInfo.getChess_board_index2chess_piece().remove(Integer.valueOf(this.toCellIndex));
/* 130 */         xChessGameInfo.getChess_board_index2chess_piece().remove(Integer.valueOf(this.fromCellIndex));
/* 131 */         xChessGameInfo.getChess_board_index2chess_piece().put(Integer.valueOf(this.toCellIndex), xFromChessPiece);
/* 132 */         haveKill = true;
/* 133 */         operationType = ChessGameManager.OperationType.MOVE_AND_ATTACK;
/*     */       }
/*     */       else
/*     */       {
/*     */         ChessGameManager.OperationType operationType;
/* 138 */         if (xFromChessPiece.getOwn_by_a() == xToChessPiece.getOwn_by_a())
/*     */         {
/*     */ 
/* 141 */           xToChessPiece.setVisible(true);
/* 142 */           operationType = ChessGameManager.OperationType.OTHER;
/*     */         }
/*     */         else
/*     */         {
/*     */           ChessGameManager.OperationType operationType;
/* 147 */           if (ChessGameManager.canChessAKillChessB(xFromChessPiece.getChess_piece_index(), xToChessPiece.getChess_piece_index(), sChessCfg))
/*     */           {
/*     */ 
/* 150 */             xChessGameInfo.getChess_board_index2chess_piece().remove(Integer.valueOf(this.toCellIndex));
/* 151 */             xChessGameInfo.getChess_board_index2chess_piece().remove(Integer.valueOf(this.fromCellIndex));
/* 152 */             xChessGameInfo.getChess_board_index2chess_piece().put(Integer.valueOf(this.toCellIndex), xFromChessPiece);
/* 153 */             operationType = ChessGameManager.OperationType.TURN_AND_ATTACK;
/*     */           }
/*     */           else
/*     */           {
/* 157 */             xToChessPiece.setVisible(true);
/* 158 */             xChessGameInfo.getChess_board_index2chess_piece().remove(Integer.valueOf(this.fromCellIndex));
/* 159 */             operationType = ChessGameManager.OperationType.TURN_AND_BE_ATTACKED;
/*     */           }
/* 161 */           haveKill = true;
/*     */         }
/*     */       }
/*     */     }
/* 165 */     onSuccess(xToChessPiece, xChessGameInfo);
/* 166 */     sendNotifyChessMoveToClient(xChessGameInfo.getPlayer_a(), xToChessPiece);
/* 167 */     sendNotifyChessMoveToClient(xChessGameInfo.getPlayer_b(), xToChessPiece);
/*     */     
/* 169 */     ChessGameManager.recordPlayerOperateRound(this.roleId, xChessGameInfo);
/*     */     
/* 171 */     ChessGameManager.onGameRoundEnd(chessGameId.longValue(), haveKill, operationType);
/* 172 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(ChessPiece xToChessPiece, ChessGameInfo xChessGameInfo)
/*     */   {
/* 185 */     sendChessMoveSuccessToClient(xToChessPiece);
/*     */     
/* 187 */     String logstr = String.format("[chess]PCChessMoveReq.processImp@PCChessMoveReq success|roleId=%d,finalChessGameInfo=%s,from=%d,to=%d", new Object[] { Long.valueOf(this.roleId), xChessGameInfo, Integer.valueOf(this.fromCellIndex), Integer.valueOf(this.toCellIndex) });
/*     */     
/*     */ 
/* 190 */     ChessGameManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */   private void sendChessMoveSuccessToClient(ChessPiece xToChessPiece)
/*     */   {
/* 195 */     mzm.gsp.chess.SChessMoveSuccessRep sChessMoveSuccessRep = new mzm.gsp.chess.SChessMoveSuccessRep();
/* 196 */     if (null != xToChessPiece)
/*     */     {
/* 198 */       ChessPieceInfo chessPieceInfo = new ChessPieceInfo();
/* 199 */       chessPieceInfo.chess_piece_index = xToChessPiece.getChess_piece_index();
/* 200 */       chessPieceInfo.chess_cell_index = this.toCellIndex;
/* 201 */       chessPieceInfo.owner = ChessGameManager.getChessPieceBlueOrRed(xToChessPiece);
/* 202 */       sChessMoveSuccessRep.to_cell_piece_info = chessPieceInfo;
/*     */     }
/* 204 */     OnlineManager.getInstance().send(this.roleId, sChessMoveSuccessRep);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode, ChessGameInfo xChessGameInfo)
/*     */   {
/* 215 */     sendChessMoveFailToClient(errorCode);
/*     */     
/* 217 */     String logstr = String.format("[chess]PCChessMoveReq.processImp@PCChessMoveReq failed|errorCode=%d,roleId=%d,ChessGameInfo=%s,from=%d,to=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), xChessGameInfo, Integer.valueOf(this.fromCellIndex), Integer.valueOf(this.toCellIndex) });
/*     */     
/*     */ 
/* 220 */     ChessGameManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */   private void sendChessMoveFailToClient(int errorCode)
/*     */   {
/* 225 */     SChessMoveFailRep sChessMoveFailRep = new SChessMoveFailRep();
/* 226 */     sChessMoveFailRep.error_code = errorCode;
/* 227 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChessMoveFailRep);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendNotifyChessMoveToClient(long targetRoleId, ChessPiece xToChessPiece)
/*     */   {
/* 239 */     SNotifyChessMove sNotifyChessMove = new SNotifyChessMove();
/* 240 */     ChessPieceInfo chessPieceInfo = new ChessPieceInfo();
/* 241 */     chessPieceInfo.chess_cell_index = this.toCellIndex;
/* 242 */     if (null != xToChessPiece)
/*     */     {
/* 244 */       chessPieceInfo.chess_piece_index = xToChessPiece.getChess_piece_index();
/* 245 */       chessPieceInfo.owner = ChessGameManager.getChessPieceBlueOrRed(xToChessPiece);
/*     */     }
/* 247 */     sNotifyChessMove.to_cell_piece_info = chessPieceInfo;
/* 248 */     sNotifyChessMove.from_cell_index = this.fromCellIndex;
/* 249 */     OnlineManager.getInstance().send(targetRoleId, sNotifyChessMove);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isMoveValid(int fromCellIndex, int toCellIndex, SChessCfg sChessCfg)
/*     */   {
/* 263 */     return ChessGameManager.isChessCellsAdjoin(fromCellIndex, toCellIndex, sChessCfg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\PCChessMoveReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
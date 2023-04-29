/*     */ package mzm.gsp.chess.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity3.confbean.SChessCfg;
/*     */ import mzm.gsp.chess.ChessPieceInfo;
/*     */ import mzm.gsp.chess.SChessTurnOverFailRep;
/*     */ import mzm.gsp.chess.SChessTurnOverSuccessRep;
/*     */ import mzm.gsp.chess.SNotifyChessTurnOver;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChessGameInfo;
/*     */ import xbean.ChessPiece;
/*     */ 
/*     */ public class PCChessTurnOverReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cellIndex;
/*     */   
/*     */   public PCChessTurnOverReq(long roleId, int cellIndex)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.cellIndex = cellIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  28 */     Long chessGameId = xtable.Role2chessgameinfo.get(Long.valueOf(this.roleId));
/*  29 */     if (null == chessGameId)
/*     */     {
/*     */ 
/*  32 */       onFail(-1, null);
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     ChessGameInfo xChessGameInfo = xtable.Chessgameinfo.get(chessGameId);
/*  37 */     if (null == xChessGameInfo)
/*     */     {
/*  39 */       String logstr = String.format("[chess]PCChessTurnOverReq.processImp@xChessGameInfo not exsists|chessGameId=%d,roleId=%d", new Object[] { chessGameId, Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  42 */       ChessGameManager.logger.error(logstr);
/*  43 */       onFail(-1, null);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!ChessGameManager.isCurrentPlayerSelf(this.roleId, xChessGameInfo))
/*     */     {
/*  49 */       onFail(-2, xChessGameInfo);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (xChessGameInfo.getNext_operate_time() > mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/*  55 */       onFail(-6, xChessGameInfo);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     SChessCfg sChessCfg = SChessCfg.get(xChessGameInfo.getCfg_id());
/*  60 */     if (!ChessGameManager.isChessCellIndexValid(this.cellIndex, sChessCfg))
/*     */     {
/*  62 */       onFail(-3, xChessGameInfo);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     ChessPiece xChessPiece = (ChessPiece)xChessGameInfo.getChess_board_index2chess_piece().get(Integer.valueOf(this.cellIndex));
/*  67 */     if (null == xChessPiece)
/*     */     {
/*     */ 
/*  70 */       onFail(-4, xChessGameInfo);
/*  71 */       return false;
/*     */     }
/*  73 */     if (xChessPiece.getVisible())
/*     */     {
/*     */ 
/*  76 */       onFail(-5, xChessGameInfo);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     xChessPiece.setVisible(true);
/*  81 */     onSuccess(xChessPiece, xChessGameInfo);
/*  82 */     sendNotifyChessTurnOverToClient(xChessGameInfo.getPlayer_a(), xChessPiece);
/*  83 */     sendNotifyChessTurnOverToClient(xChessGameInfo.getPlayer_b(), xChessPiece);
/*     */     
/*  85 */     ChessGameManager.recordPlayerOperateRound(this.roleId, xChessGameInfo);
/*     */     
/*  87 */     ChessGameManager.onGameRoundEnd(chessGameId.longValue(), false, ChessGameManager.OperationType.OTHER);
/*  88 */     return true;
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
/*     */   private void onSuccess(ChessPiece xChessPiece, ChessGameInfo xChessGameInfo)
/*     */   {
/* 101 */     sendChessTurnOverSuccessToClient(xChessPiece);
/*     */     
/* 103 */     String logstr = String.format("[chess]PCChessTurnOverReq.processImp@PCChessTurnOverReq success|roleId=%d,ChessGameInfo=%s,cellIndex=%d", new Object[] { Long.valueOf(this.roleId), xChessGameInfo, Integer.valueOf(this.cellIndex) });
/*     */     
/*     */ 
/* 106 */     ChessGameManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */   private void sendChessTurnOverSuccessToClient(ChessPiece xChessPiece)
/*     */   {
/* 111 */     ChessPieceInfo chessPieceInfo = new ChessPieceInfo();
/* 112 */     chessPieceInfo.chess_piece_index = xChessPiece.getChess_piece_index();
/* 113 */     chessPieceInfo.chess_cell_index = this.cellIndex;
/* 114 */     chessPieceInfo.owner = ChessGameManager.getChessPieceBlueOrRed(xChessPiece);
/* 115 */     SChessTurnOverSuccessRep sChessTurnOverSuccessRep = new SChessTurnOverSuccessRep();
/* 116 */     sChessTurnOverSuccessRep.cell_piece_info = chessPieceInfo;
/* 117 */     OnlineManager.getInstance().send(this.roleId, sChessTurnOverSuccessRep);
/*     */   }
/*     */   
/*     */   private void sendNotifyChessTurnOverToClient(long roleId, ChessPiece xChessPiece)
/*     */   {
/* 122 */     ChessPieceInfo chessPieceInfo = new ChessPieceInfo();
/* 123 */     chessPieceInfo.chess_piece_index = xChessPiece.getChess_piece_index();
/* 124 */     chessPieceInfo.chess_cell_index = this.cellIndex;
/* 125 */     chessPieceInfo.owner = ChessGameManager.getChessPieceBlueOrRed(xChessPiece);
/* 126 */     SNotifyChessTurnOver sNotifyChessTurnOver = new SNotifyChessTurnOver();
/* 127 */     sNotifyChessTurnOver.cell_piece_info = chessPieceInfo;
/* 128 */     OnlineManager.getInstance().send(roleId, sNotifyChessTurnOver);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode, ChessGameInfo xChessGameInfo)
/*     */   {
/* 140 */     sendChessTurnOverFailToClient(errorCode);
/*     */     
/* 142 */     String logstr = String.format("[chess]PCChessTurnOverReq.processImp@PCChessTurnOverReq fail|errorCode=%d,roleId=%d,ChessGameInfo=%s,cellIndex=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), xChessGameInfo, Integer.valueOf(this.cellIndex) });
/*     */     
/*     */ 
/* 145 */     ChessGameManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */   private void sendChessTurnOverFailToClient(int errorCode)
/*     */   {
/* 150 */     SChessTurnOverFailRep sChessTurnOverFailRep = new SChessTurnOverFailRep();
/* 151 */     sChessTurnOverFailRep.error_code = errorCode;
/* 152 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChessTurnOverFailRep);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\PCChessTurnOverReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
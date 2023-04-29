/*     */ package mzm.gsp.chess.main;
/*     */ 
/*     */ import mzm.gsp.activity3.confbean.SChessCfg;
/*     */ import mzm.gsp.chess.SSurrenderFailRep;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChessGameInfo;
/*     */ 
/*     */ public class PCSurrenderReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCSurrenderReq(long roleId)
/*     */   {
/*  15 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  21 */     Long chessGameId = xtable.Role2chessgameinfo.get(Long.valueOf(this.roleId));
/*  22 */     if (null == chessGameId)
/*     */     {
/*     */ 
/*  25 */       onFail(-1, null);
/*  26 */       return false;
/*     */     }
/*     */     
/*  29 */     ChessGameInfo xChessGameInfo = xtable.Chessgameinfo.get(chessGameId);
/*  30 */     if (null == xChessGameInfo)
/*     */     {
/*  32 */       String logstr = String.format("[chess]PCSurrenderReq.processImp@xChessGameInfo not exsists|chessGameId=%d,roleId=%d", new Object[] { chessGameId, Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  35 */       ChessGameManager.logger.error(logstr);
/*  36 */       onFail(-1, null);
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     if (!isSurrenderAllowed(xChessGameInfo))
/*     */     {
/*  43 */       onFail(-3, xChessGameInfo);
/*  44 */       return false;
/*     */     }
/*  46 */     onSuccess(xChessGameInfo);
/*     */     
/*  48 */     ChessGameManager.chessGameFinishBySurrender(this.roleId, chessGameId.longValue(), xChessGameInfo);
/*  49 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isSurrenderAllowed(ChessGameInfo xChessGameInfo)
/*     */   {
/*  60 */     SChessCfg sChessCfg = SChessCfg.get(xChessGameInfo.getCfg_id());
/*  61 */     if (xChessGameInfo.getRound() >= sChessCfg.surrenderRoundCount)
/*     */     {
/*  63 */       return true;
/*     */     }
/*  65 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(ChessGameInfo xChessGameInfo)
/*     */   {
/*  76 */     sendSurrenderSuccessToClient();
/*     */     
/*  78 */     String logstr = String.format("[chess]PCSurrenderReq.processImp@PCSurrenderReq success|roleId=%d,ChessGameInfo=%s", new Object[] { Long.valueOf(this.roleId), xChessGameInfo });
/*     */     
/*  80 */     ChessGameManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */   private void sendSurrenderSuccessToClient()
/*     */   {
/*  85 */     OnlineManager.getInstance().send(this.roleId, new mzm.gsp.chess.SSurrenderSuccessRep());
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
/*  97 */     sendSurrenderFailToClient(errorCode);
/*     */     
/*  99 */     String logstr = String.format("[chess]PCSurrenderReq.processImp@PCSurrenderReq fail|roleId=%d,errorCode=%d,ChessGameInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode), xChessGameInfo });
/*     */     
/*     */ 
/* 102 */     ChessGameManager.logger.info(logstr);
/*     */   }
/*     */   
/*     */   private void sendSurrenderFailToClient(int errorCode)
/*     */   {
/* 107 */     SSurrenderFailRep sSurrenderFailRep = new SSurrenderFailRep();
/* 108 */     sSurrenderFailRep.error_code = errorCode;
/* 109 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sSurrenderFailRep);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\PCSurrenderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
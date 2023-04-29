/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.ChessGameInfo;
/*    */ import xtable.Role2chessgameinfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 13 */     Long chessGameId = Role2chessgameinfo.select(Long.valueOf(roleId));
/* 14 */     if (null == chessGameId)
/*    */     {
/* 16 */       return true;
/*    */     }
/*    */     
/* 19 */     ChessGameInfo xChessGameInfo = xtable.Chessgameinfo.select(chessGameId);
/* 20 */     if (null == xChessGameInfo)
/*    */     {
/* 22 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleId, 1561);
/* 23 */       Role2chessgameinfo.remove(Long.valueOf(roleId));
/* 24 */       return true;
/*    */     }
/*    */     
/*    */     long enemyRoleId;
/* 28 */     if (roleId == xChessGameInfo.getPlayer_a())
/*    */     {
/* 30 */       enemyRoleId = xChessGameInfo.getPlayer_b();
/*    */     } else { long enemyRoleId;
/* 32 */       if (roleId == xChessGameInfo.getPlayer_b())
/*    */       {
/* 34 */         enemyRoleId = xChessGameInfo.getPlayer_a();
/*    */       }
/*    */       else
/*    */       {
/* 38 */         String logstr = String.format("[chess]POnRoleLogin.processImp@player not in game while have the gameId |roleId=%d", new Object[] { Long.valueOf(roleId) });
/*    */         
/* 40 */         ChessGameManager.logger.error(logstr);
/* 41 */         return true;
/*    */       } }
/*    */     long enemyRoleId;
/* 44 */     ChessGameManager.synChessGameInfoToClient(roleId, enemyRoleId, xChessGameInfo);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
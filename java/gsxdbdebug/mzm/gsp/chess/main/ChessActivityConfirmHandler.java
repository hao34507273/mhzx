/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.chess.SChessActivityConfirmDesc;
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class ChessActivityConfirmHandler
/*    */   implements TeamConfirmHandler
/*    */ {
/*    */   public Protocol getConfirmProtocol(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 18 */     if (!(context instanceof ChessActivityConfirmContext))
/*    */     {
/* 20 */       return null;
/*    */     }
/* 22 */     ChessActivityConfirmContext chessContext = (ChessActivityConfirmContext)context;
/* 23 */     return new SChessActivityConfirmDesc(chessContext.getActivityCfgId(), chessContext.getChessGameCfgId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterAllAccepted(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 29 */     if (!(context instanceof ChessActivityConfirmContext))
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     ChessActivityConfirmContext chessContext = (ChessActivityConfirmContext)context;
/*    */     
/* 35 */     List<Long> roleIds = TeamInterface.getTeamMemberList(teamId, false);
/* 36 */     ChessGameContext chessGameContext = new ChessGameContext(chessContext.getActivityCfgId());
/* 37 */     ChessGameInterface.startChessGame(roleIds, chessContext.getChessGameCfgId(), chessGameContext);
/*    */     
/* 39 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 42 */       ActivityInterface.logActivity(roleId, chessContext.getActivityCfgId(), ActivityLogStatus.ATTEND);
/*    */       
/* 44 */       ActivityInterface.tlogActivity(roleId, chessContext.getActivityCfgId(), ActivityLogStatus.ATTEND);
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessActivityConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
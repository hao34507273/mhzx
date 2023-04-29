/*    */ package mzm.gsp.gangrace.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.gangrace.SRunningInfoRes;
/*    */ import mzm.gsp.gangrace.main.game.RaceGame;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PGetRunningInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetRunningInfoReq(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     int stage = GangRaceManager.getInstance().getGameStage();
/* 21 */     if (stage <= 0) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     long gangid = GangInterface.getGangId(this.roleid);
/* 26 */     if (gangid <= 0L) {
/* 27 */       GangRaceManager.sendErrorInfo(this.roleid, 1);
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 33 */     RaceGame game = GangRaceManager.getInstance().getGame(gangid);
/* 34 */     if (game == null) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     SRunningInfoRes res = new SRunningInfoRes();
/* 39 */     res.begintime = GangRaceManager.getInstance().getGameStageTime();
/* 40 */     res.runninginfos.addAll(game.getRunningInfo());
/* 41 */     res.ranks.put(Integer.valueOf(1), Integer.valueOf(game.getWinIndex()));
/*    */     
/* 43 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\PGetRunningInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.gangrace.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.gangrace.SPlayerInfoRes;
/*    */ import mzm.gsp.gangrace.main.game.RaceGame;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PGetPlayerInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetPlayerInfoReq(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (GangRaceManager.getInstance().getGameStage() < 0) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     long gangid = GangInterface.getGangId(this.roleid);
/* 25 */     if (gangid <= 0L) {
/* 26 */       GangRaceManager.sendErrorInfo(this.roleid, 1);
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     RaceGame game = GangRaceManager.getInstance().getGame(gangid);
/* 31 */     if (game == null) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     SPlayerInfoRes res = new SPlayerInfoRes();
/* 36 */     res.playerinfos.addAll(game.getPlayerInfo());
/*    */     
/* 38 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\PGetPlayerInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
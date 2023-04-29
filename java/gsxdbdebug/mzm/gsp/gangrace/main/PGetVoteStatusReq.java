/*    */ package mzm.gsp.gangrace.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.gangrace.SVotingStatusRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangRaceGameInfo;
/*    */ import xbean.GangRaceRoleInfo;
/*    */ 
/*    */ public class PGetVoteStatusReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetVoteStatusReq(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     int stage = GangRaceManager.getInstance().getGameStage();
/* 22 */     if (stage == -1)
/*    */     {
/* 24 */       GangRaceManager.sendErrorInfo(this.roleid, 0);
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     long gangid = mzm.gsp.gang.main.GangInterface.getGangId(this.roleid);
/* 30 */     if (gangid <= 0L) {
/* 31 */       GangRaceManager.sendErrorInfo(this.roleid, 1);
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     GangRaceRoleInfo xGangRaceRoleInfoBean = GangRaceManager.getXGangRaceRoleInfo(this.roleid);
/*    */     
/* 38 */     GangRaceGameInfo xGangRaceGameInfoBean = GangRaceManager.getXGangRaceGameInfo(gangid);
/*    */     
/* 40 */     mzm.gsp.gangrace.main.game.RaceGame game = GangRaceManager.getInstance().getGame(gangid);
/* 41 */     if (game == null) {
/* 42 */       GangRaceManager.sendErrorInfo(this.roleid, 0);
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     GangRaceManager.resetRoleGangRaceGameInfo(game, xGangRaceRoleInfoBean, xGangRaceGameInfoBean);
/*    */     
/* 48 */     SVotingStatusRes res = new SVotingStatusRes();
/* 49 */     res.idx2votemoney.putAll(xGangRaceGameInfoBean.getRaceid2money());
/* 50 */     if ((xGangRaceRoleInfoBean != null) && (!xGangRaceRoleInfoBean.getRaceid2money().isEmpty())) {
/* 51 */       res.myvoteinfo.putAll(xGangRaceRoleInfoBean.getRaceid2money());
/*    */     }
/* 53 */     OnlineManager.getInstance().send(this.roleid, res);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\PGetVoteStatusReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
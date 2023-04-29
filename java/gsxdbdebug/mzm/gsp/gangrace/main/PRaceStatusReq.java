/*    */ package mzm.gsp.gangrace.main;
/*    */ 
/*    */ import mzm.gsp.gangrace.SRaceStatusRes;
/*    */ import mzm.gsp.gangrace.main.game.RaceGame;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangRaceRoleInfo;
/*    */ import xtable.Role2gangraceinfo;
/*    */ 
/*    */ public class PRaceStatusReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PRaceStatusReq(long roleid)
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
/* 29 */     if (!GangRaceManager.isRoleStateCanJoinGangRaceActivity(this.roleid))
/*    */     {
/* 31 */       GangRaceManager.logInfo("PRaceStatusReq.processImp@role state can not join gangrace activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     long gangid = mzm.gsp.gang.main.GangInterface.getGangId(this.roleid);
/* 37 */     if (gangid <= 0L) {
/* 38 */       GangRaceManager.sendErrorInfo(this.roleid, 1);
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     GangRaceRoleInfo xGangRaceRoleInfoBean = Role2gangraceinfo.select(Long.valueOf(this.roleid));
/*    */     
/* 45 */     RaceGame game = GangRaceManager.getInstance().getGame(gangid);
/* 46 */     if (game == null) {
/* 47 */       GangRaceManager.sendErrorInfo(this.roleid, 0);
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     int gameId = game.getGameId();
/* 52 */     if ((stage == 0) && (xGangRaceRoleInfoBean != null) && (xGangRaceRoleInfoBean.getGameid() == gameId) && (!xGangRaceRoleInfoBean.getRaceid2money().isEmpty())) {
/* 53 */       stage = 1;
/*    */     }
/*    */     
/* 56 */     int beginTime = GangRaceManager.getInstance().getGameStageTime();
/* 57 */     int curRound = GangRaceManager.getInstance().getCurGameRound();
/* 58 */     int maxRound = GangRaceManager.getInstance().getMaxGameRound();
/* 59 */     OnlineManager.getInstance().send(this.roleid, new SRaceStatusRes(stage, beginTime, curRound, maxRound));
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\PRaceStatusReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
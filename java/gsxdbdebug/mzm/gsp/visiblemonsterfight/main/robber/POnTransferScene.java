/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.SSyncFightRobberTipRes;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst;
/*    */ 
/*    */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (((MapTransferArg)this.arg).roleList.size() > 1) {
/* 16 */       return false;
/*    */     }
/* 18 */     long roleid = ((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue();
/* 19 */     long gangid = GangInterface.getGangId(roleid);
/* 20 */     if (gangid <= 0L) {
/* 21 */       return false;
/*    */     }
/* 23 */     if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(SGangRobberConst.getInstance().ACTIVITYID)) {
/* 24 */       return false;
/*    */     }
/* 26 */     if (mzm.gsp.team.main.TeamInterface.isTeamMemberNormal(roleid)) {
/* 27 */       return false;
/*    */     }
/* 29 */     long gangWorldid = GangInterface.getGangWorldId(gangid);
/* 30 */     if (gangWorldid != ((MapTransferArg)this.arg).newWorldId) {
/* 31 */       return false;
/*    */     }
/* 33 */     if (MapInterface.getMonsterNumInWorld(gangWorldid) > 0) {
/* 34 */       SSyncFightRobberTipRes syncFightRobberTipRes = new SSyncFightRobberTipRes();
/* 35 */       OnlineManager.getInstance().send(roleid, syncFightRobberTipRes);
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
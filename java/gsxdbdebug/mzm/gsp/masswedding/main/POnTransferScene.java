/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.MassWedding;
/*    */ import xbean.MassWeddingBless;
/*    */ import xbean.MassWeddingRankInfos;
/*    */ import xbean.MassWeddingRobSubscribe;
/*    */ 
/*    */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     long newWorldid = ((MapTransferArg)this.arg).newWorldId;
/* 21 */     long oldWorldid = ((MapTransferArg)this.arg).oldWorldId;
/* 22 */     if (newWorldid == oldWorldid) {
/* 23 */       return false;
/*    */     }
/* 25 */     if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(SMassWeddingConsts.getInstance().activityid)) {
/* 26 */       return false;
/*    */     }
/* 28 */     List<Long> allRoles = new ArrayList();
/* 29 */     allRoles.addAll(((MapTransferArg)this.arg).roleList);
/* 30 */     Map<Long, Long> roleid2MarryRoleidMap = new HashMap();
/* 31 */     for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 32 */       long marryRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(roleid);
/* 33 */       if (marryRoleid >= 0L) {
/* 34 */         allRoles.add(Long.valueOf(marryRoleid));
/* 35 */         roleid2MarryRoleidMap.put(Long.valueOf(roleid), Long.valueOf(marryRoleid));
/*    */       }
/*    */     }
/* 38 */     lock(xtable.Role2properties.getTable(), allRoles);
/* 39 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 40 */     if (xMassWedding == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     long worldid = xMassWedding.getWorldid();
/* 44 */     boolean leave = worldid == ((MapTransferArg)this.arg).oldWorldId;
/*    */     
/* 46 */     if (leave) {
/* 47 */       MassWeddingRobSubscribe xMassWeddingRobSubscribe = MassWeddingManager.getMassWeddingRobSubScribe(true);
/*    */       
/* 49 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 50 */         if (xMassWedding.getStage() == 0) {
/* 51 */           Long marryRoleid = (Long)roleid2MarryRoleidMap.get(Long.valueOf(roleid));
/* 52 */           if (marryRoleid != null) {
/* 53 */             MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/*    */             
/* 55 */             MassWeddingManager.onRoleLeaveInSignUp(roleid, marryRoleid.longValue(), xMassWeddingRankInfos);
/*    */           }
/*    */         }
/* 58 */         MassWeddingManager.unSubScribe(xMassWeddingRobSubscribe, roleid);
/*    */         
/* 60 */         MassWeddingManager.tlogMassWeddingAttend(RoleInterface.getUserId(roleid), roleid, RoleInterface.getLevel(roleid), 2);
/*    */       }
/*    */       
/*    */ 
/* 64 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 39);
/*    */     }
/*    */     
/* 67 */     if (xMassWedding.getWorldid() != newWorldid) {
/* 68 */       return true;
/*    */     }
/*    */     
/* 71 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 72 */     MassWeddingBless xMassWeddingBless = MassWeddingManager.getMassWeddingBless(true);
/* 73 */     xbean.MassWeddingRob xMassWeddingRob = MassWeddingManager.getMassWeddingRob(true);
/* 74 */     MassWeddingManager.onRoleEnterMassWeddingWorld(((MapTransferArg)this.arg).roleList, xMassWedding, xMassWeddingRankInfos, xMassWeddingBless, xMassWeddingRob);
/*    */     
/* 76 */     for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 77 */       MassWeddingManager.tlogMassWeddingAttend(RoleInterface.getUserId(roleid), roleid, RoleInterface.getLevel(roleid), 1);
/*    */     }
/*    */     
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
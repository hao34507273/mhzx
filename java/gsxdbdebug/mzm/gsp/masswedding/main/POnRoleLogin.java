/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.MassWedding;
/*    */ import xbean.MassWeddingRankInfos;
/*    */ import xbean.MassWeddingRedgift;
/*    */ import xtable.Masswedding;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     final long roleid = ((Long)this.arg).longValue();
/* 24 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 28 */         long marryRoleid = MarriageInterface.getMarriedRoleid(roleid);
/* 29 */         String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 30 */         lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 31 */         MassWeddingRedgift xMassWeddingRedgift = xtable.Role2massweddingredgift.get(Long.valueOf(roleid));
/* 32 */         if (xMassWeddingRedgift != null) {
/* 33 */           MassWeddingManager.checkAndAwardRedGift(roleid, userid, xMassWeddingRedgift.getRedgiftcfgid(), xMassWeddingRedgift);
/*    */         }
/*    */         
/* 36 */         MassWedding xMassWedding = Masswedding.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 37 */         if (xMassWedding == null) {
/* 38 */           RoleStatusInterface.unsetStatus(roleid, 36);
/* 39 */           RoleStatusInterface.unsetStatus(roleid, 39);
/*    */         } else {
/* 41 */           long worldid = MapInterface.getRoleWorldInstanceId(roleid);
/* 42 */           if (worldid != xMassWedding.getWorldid()) {
/* 43 */             RoleStatusInterface.unsetStatus(roleid, 36);
/* 44 */             RoleStatusInterface.unsetStatus(roleid, 39);
/* 45 */             List<Long> roleids = new ArrayList();
/* 46 */             roleids.add(Long.valueOf(roleid));
/* 47 */             if (marryRoleid >= 0L) {
/* 48 */               roleids.add(Long.valueOf(marryRoleid));
/*    */             }
/* 50 */             MapInterface.removeMapGroup(mzm.gsp.map.main.group.MapGroupType.MGT_GROUP_WEDDING, roleid, roleids);
/*    */           }
/*    */         }
/*    */         
/* 54 */         return true;
/*    */       }
/*    */     });
/* 57 */     if (!ActivityInterface.isActivityOpen(SMassWeddingConsts.getInstance().activityid)) {
/* 58 */       return false;
/*    */     }
/* 60 */     long worldid = MapInterface.getRoleWorldInstanceId(((Long)this.arg).longValue());
/* 61 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 62 */     if (xMassWedding == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     if (worldid != xMassWedding.getWorldid()) {
/* 66 */       return true;
/*    */     }
/*    */     
/* 69 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 70 */     xbean.MassWeddingBless xMassWeddingBless = MassWeddingManager.getMassWeddingBless(true);
/* 71 */     xbean.MassWeddingRob xMassWeddingRob = MassWeddingManager.getMassWeddingRob(true);
/* 72 */     MassWeddingManager.onRoleEnterMassWeddingWorld(Arrays.asList(new Long[] { (Long)this.arg }), xMassWedding, xMassWeddingRankInfos, xMassWeddingBless, xMassWeddingRob);
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
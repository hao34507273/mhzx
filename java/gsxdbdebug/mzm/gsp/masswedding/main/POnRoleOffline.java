/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import xbean.MassWedding;
/*    */ import xbean.MassWeddingRankInfos;
/*    */ 
/*    */ public class POnRoleOffline extends mzm.gsp.online.event.PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 14 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(false);
/* 15 */     if (xMassWedding == null) {
/* 16 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 20 */     long marryRoleid = MarriageInterface.getMarriedRoleid(roleid);
/*    */     
/* 22 */     if (xMassWedding.getStage() != 0) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (marryRoleid != -1L) {
/* 27 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(marryRoleid) }));
/* 28 */       MassWedding xMassWedding2 = MassWeddingManager.getMassWedding(true);
/* 29 */       if (xMassWedding2.getStage() != 0) {
/* 30 */         return false;
/*    */       }
/* 32 */       MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 33 */       MassWeddingManager.onRoleLeaveInSignUp(roleid, marryRoleid, xMassWeddingRankInfos);
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\POnRoleOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
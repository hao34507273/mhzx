/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.SNotifyKnockOutCorpsQualification;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PNotifyKnockOutQualifiaction
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long corpsId;
/*    */   private final int knockOutType;
/*    */   private final Set<Long> nowQualifiactionCorpsIdSet;
/*    */   
/*    */   public PNotifyKnockOutQualifiaction(long roleId, long corpsId, int knockOutType, Set<Long> nowQualifiactionCorpsIdSet)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.corpsId = corpsId;
/* 25 */     this.knockOutType = knockOutType;
/* 26 */     this.nowQualifiactionCorpsIdSet = nowQualifiactionCorpsIdSet;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (this.nowQualifiactionCorpsIdSet.contains(Long.valueOf(this.corpsId)))
/*    */     {
/* 34 */       SNotifyKnockOutCorpsQualification notifyKnockOutCorpsQualication = new SNotifyKnockOutCorpsQualification(this.knockOutType, 1);
/*    */       
/*    */ 
/*    */ 
/* 38 */       OnlineManager.getInstance().send(this.roleId, notifyKnockOutCorpsQualication);
/*    */     }
/*    */     
/* 41 */     CrossBattleKnockoutManager.updateCanJoinNowStageKnockOutCorpsIdSet(this.nowQualifiactionCorpsIdSet);
/*    */     
/* 43 */     StringBuilder sBuilder = new StringBuilder();
/* 44 */     sBuilder.append("[crossbattle]PNotifyKnockOutQualifiaction.processImp@notify and update success");
/* 45 */     sBuilder.append("|role_id=").append(this.roleId);
/* 46 */     sBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 47 */     sBuilder.append("|corps_id=").append(this.corpsId);
/* 48 */     sBuilder.append("|now_qualifiaction_corps_id_set=").append(this.nowQualifiactionCorpsIdSet);
/*    */     
/* 50 */     GameServer.logger().info(sBuilder.toString());
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PNotifyKnockOutQualifiaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
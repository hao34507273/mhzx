/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.qingfu.event.CostYuanbaoArg;
/*    */ 
/*    */ public class ROnUserCostYuanbao extends mzm.gsp.qingfu.event.CostYuanbaoRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 12 */       return;
/*    */     }
/*    */     
/* 15 */     String userid = ((CostYuanbaoArg)this.arg).userid;
/* 16 */     long roleid = ((CostYuanbaoArg)this.arg).roleid;
/* 17 */     new POnUserCostYuanbaoForQingfu(userid, roleid, ((CostYuanbaoArg)this.arg).billno).call();
/*    */     
/* 19 */     long oldAccumTotalCost = ((CostYuanbaoArg)this.arg).oldTotalCost + ((CostYuanbaoArg)this.arg).oldTotalCostBind;
/* 20 */     new POnUserCostYuanbaoForAccumTotalCostActivity(userid, roleid, oldAccumTotalCost).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\ROnUserCostYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
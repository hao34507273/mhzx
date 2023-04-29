/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.achievement.main.goaltype.BuyTss.Context;
/*    */ import mzm.gsp.qingfu.event.TssChangedArg;
/*    */ import mzm.gsp.qingfu.event.TssChangedArg.TssChangedInfo;
/*    */ import mzm.gsp.qingfu.event.TssChangedRunnable;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class ROnUserTssChanged
/*    */   extends TssChangedRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 17 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 23 */         String userId = ((TssChangedArg)ROnUserTssChanged.this.arg).userid;
/* 24 */         long roleId = QingfuInterface.getSuitableRoleId(userId);
/* 25 */         for (Map.Entry<String, TssChangedArg.TssChangedInfo> entry : ((TssChangedArg)ROnUserTssChanged.this.arg).changedInfos.entrySet())
/*    */         {
/* 27 */           int serviceId = Integer.valueOf((String)entry.getKey()).intValue();
/* 28 */           int times = (int)QingfuInterface.getTssBuyTimes(userId, serviceId, false);
/* 29 */           BuyTss.Context context = new BuyTss.Context(serviceId, times);
/* 30 */           AchievementManager.updateGoalTypeState(roleId, 5300, context, "ROnUserTssChanged.process@handle BUY_TSS success");
/*    */         }
/* 32 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\ROnUserTssChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class PGM_AwardToRolesXTime extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int awardId;
/*    */   private final int modifyId;
/*    */   private final int count;
/*    */   
/*    */   public PGM_AwardToRolesXTime(long roleId, int awardId, int modifyId, int count)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.awardId = awardId;
/* 18 */     this.modifyId = modifyId;
/* 19 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (this.count > 200)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.roleId, "奖励次数不能超过200次！");
/* 28 */       return false;
/*    */     }
/* 30 */     String awardTime = getAwardTimeStr();
/* 31 */     for (int i = 0; i < this.count; i++)
/*    */     {
/* 33 */       NoneRealTimeTaskManager.getInstance().addTask(new PGM_AwardRoles(this.roleId, this.awardId, this.modifyId, awardTime));
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   String getAwardTimeStr()
/*    */   {
/* 40 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PGM_AwardToRolesXTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
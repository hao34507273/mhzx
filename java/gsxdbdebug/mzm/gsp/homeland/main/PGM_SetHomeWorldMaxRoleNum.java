/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class PGM_SetHomeWorldMaxRoleNum
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private int maxNum;
/*    */   
/*    */   public PGM_SetHomeWorldMaxRoleNum(long gmRoleId, int maxNum)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.maxNum = maxNum;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     int res = HomelandManager.setGM_MaxRoleNum(this.maxNum);
/* 22 */     if (res > 0)
/*    */     {
/* 24 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("家园人数上限设置成功，上限为%d", new Object[] { Integer.valueOf(res) }));
/*    */     }
/*    */     else
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("家园人数上限设置失败，不允许为负数", new Object[0]));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PGM_SetHomeWorldMaxRoleNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
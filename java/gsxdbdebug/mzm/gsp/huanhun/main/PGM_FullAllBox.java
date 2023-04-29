/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ public class PGM_FullAllBox extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_FullAllBox(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(this.roleId));
/* 21 */     if (xHunInfo == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     for (int i = 1; i < 9; i++)
/*    */     {
/* 28 */       NoneRealTimeTaskManager.getInstance().addTask(new PGM_FullXBox(this.roleId, i));
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PGM_FullAllBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
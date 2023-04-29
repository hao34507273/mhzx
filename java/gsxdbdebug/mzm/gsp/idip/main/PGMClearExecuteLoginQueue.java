/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.PGM_ClearExtuteLoginQueue;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMClearExecuteLoginQueue extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   
/*    */   public PGMClearExecuteLoginQueue(long gmRoleId)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     new PGM_ClearExtuteLoginQueue().execute();
/* 20 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作成功");
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMClearExecuteLoginQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
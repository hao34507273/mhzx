/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMMaxTaskPerRole extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int maxTask;
/*    */   
/*    */   public PGMMaxTaskPerRole(long gmRoleId, int maxTask)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.maxTask = maxTask;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (this.maxTask <= 0)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "数量无效");
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     OnlineManager.getInstance().setMaxTaskPerRole(this.maxTask);
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作成功");
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMMaxTaskPerRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
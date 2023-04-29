/*    */ package mzm.gsp.role.log;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RefreshRankLog
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int logRankType;
/*    */   
/*    */   public PGM_RefreshRankLog(long roleId, int logRankType)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.logRankType = logRankType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     switch (this.logRankType)
/*    */     {
/*    */     case 1: 
/* 29 */       LogRankManager.logFVRankAsyn();
/* 30 */       break;
/*    */     case 2: 
/* 32 */       LogRankManager.logFVRankAsyn();
/* 33 */       break;
/*    */     
/*    */     default: 
/* 36 */       GmManager.getInstance().sendResultToGM(this.roleId, "输入参数错误，1：角色战斗力；2：角色综合战斗力~");
/* 37 */       return false;
/*    */     }
/* 39 */     GmManager.getInstance().sendResultToGM(this.roleId, "角色排行榜log数据刷新成功~");
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\PGM_RefreshRankLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
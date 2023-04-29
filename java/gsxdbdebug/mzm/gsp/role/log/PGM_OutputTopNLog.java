/*    */ package mzm.gsp.role.log;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_OutputTopNLog extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int logRankType;
/*    */   
/*    */   public PGM_OutputTopNLog(long roleId, int logRankType)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.logRankType = logRankType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     PTLogXTypeRankData p = new PTLogXTypeRankData(this.logRankType, false);
/* 21 */     if (!p.call())
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.roleId, "o(*￣︶￣*)o 执行打印信息指令失败啦~");
/* 24 */       return false;
/*    */     }
/* 26 */     GmManager.getInstance().sendResultToGM(this.roleId, "执行打印信息指令成功,请联系程序拉取log~");
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\PGM_OutputTopNLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
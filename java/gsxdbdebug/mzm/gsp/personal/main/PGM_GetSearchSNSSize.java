/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetSearchSNSSize extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   
/*    */   public PGM_GetSearchSNSSize(long gmRoleId)
/*    */   {
/* 12 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     int size = SearchTaskOneByOne.getInstance().taskSize();
/* 19 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("当前排队搜索队列长度:%d", new Object[] { Integer.valueOf(size) }));
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PGM_GetSearchSNSSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AddShimen
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int value;
/*    */   
/*    */   public PGM_AddShimen(long roleid, int value)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.value = value;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     TLogArg tLogArg = new TLogArg(LogReason.GM_ADD);
/* 30 */     MallInterface.addJifen(this.roleid, this.value, 3, true, tLogArg);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PGM_AddShimen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
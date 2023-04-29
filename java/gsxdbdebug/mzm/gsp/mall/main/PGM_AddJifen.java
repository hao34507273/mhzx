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
/*    */ public class PGM_AddJifen
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int value;
/*    */   private final int jifentype;
/*    */   
/*    */   public PGM_AddJifen(long roleid, int value, int jifentype)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.value = value;
/* 23 */     this.jifentype = jifentype;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     TLogArg logArg = new TLogArg(LogReason.GM_ADD);
/* 30 */     MallInterface.addJifen(this.roleid, this.value, this.jifentype, true, logArg);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PGM_AddJifen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
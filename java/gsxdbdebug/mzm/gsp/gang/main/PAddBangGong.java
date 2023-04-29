/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PAddBangGong
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int value;
/*    */   private TLogArg arg;
/*    */   
/*    */   public PAddBangGong(long roleId, int value, TLogArg arg)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.value = value;
/* 18 */     this.arg = arg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     ModBangGongResult result = GangManager.addBangGongInAll(this.roleId, this.value, this.arg, false);
/* 25 */     return result.isSucceed();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PAddBangGong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
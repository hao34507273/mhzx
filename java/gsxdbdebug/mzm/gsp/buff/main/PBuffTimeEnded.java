/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBuffTimeEnded
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int buffId;
/*    */   private final long installTime;
/*    */   
/*    */   public PBuffTimeEnded(long roleId, int buffId, long installTime)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.buffId = buffId;
/* 19 */     this.installTime = installTime;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     return BuffManager.uninstallBuff(this.roleId, this.buffId, this.installTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PBuffTimeEnded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
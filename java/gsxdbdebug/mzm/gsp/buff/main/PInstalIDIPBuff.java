/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PInstalIDIPBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int buffcfgId;
/*    */   private final int multiple;
/*    */   private final long endTime;
/*    */   
/*    */   public PInstalIDIPBuff(long roleId, int buffcfgId, int multiple, long endTime)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.buffcfgId = buffcfgId;
/* 18 */     this.multiple = multiple;
/* 19 */     this.endTime = endTime;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     return BuffManager.installIDIPBuff(this.roleId, this.buffcfgId, this.multiple, this.endTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PInstalIDIPBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
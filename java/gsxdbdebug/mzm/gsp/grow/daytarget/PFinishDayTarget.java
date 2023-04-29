/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import mzm.gsp.grow.confbean.SDayTargetCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.TargetData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PFinishDayTarget
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int targetId;
/*    */   
/*    */   public PFinishDayTarget(long roleId, int targetId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.targetId = targetId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!DayTargetManager.isDayTargetOpen(this.roleId, false))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     RoleDayInfo roleDayInfo = new RoleDayInfo(this.roleId, true);
/* 32 */     TargetData xData = roleDayInfo.getTargetData(this.targetId);
/* 33 */     SDayTargetCfg cfg = SDayTargetCfg.get(this.targetId);
/* 34 */     if (cfg == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     xData.setTargetstate(2);
/* 39 */     DayTargetManager.synTargetInfo(this.roleId, this.targetId, 2, cfg.num);
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\PFinishDayTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
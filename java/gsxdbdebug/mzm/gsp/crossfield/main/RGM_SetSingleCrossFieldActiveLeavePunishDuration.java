/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.crossfield.confbean.SCrossFieldConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGM_SetSingleCrossFieldActiveLeavePunishDuration
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int duration;
/*    */   
/*    */   public RGM_SetSingleCrossFieldActiveLeavePunishDuration(long gmRoleid, int duration)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.duration = duration;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 25 */     if (this.duration < 0)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("时长错误|时长=%d", new Object[] { Integer.valueOf(this.duration) }));
/* 28 */       return;
/*    */     }
/* 30 */     SCrossFieldConsts.getInstance().ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND = this.duration;
/* 31 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置主动离开战场惩罚时长成功|时长=%d", new Object[] { Integer.valueOf(this.duration) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\RGM_SetSingleCrossFieldActiveLeavePunishDuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.multioccupation.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MultiOccupation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ResetMultiOccupCoolDown
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ResetMultiOccupCoolDown(long gmid, long roleid)
/*    */   {
/* 17 */     this.gmid = gmid;
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     MultiOccupation xMultiOccup = MultiOccupManager.getXMultiOccup(this.roleid, true);
/*    */     
/* 26 */     if (xMultiOccup == null) {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmid, "尚未开启过新职业，无需重置转职冷却时间");
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     xMultiOccup.setActivate_time(0L);
/* 32 */     xMultiOccup.setSwitch_time(0L);
/*    */     
/*    */ 
/* 35 */     MultiOccupManager.sendMultiOccup(this.roleid, xMultiOccup);
/*    */     
/* 37 */     GmManager.getInstance().sendResultToGM(this.gmid, "重置开启新职业和切换职业冷却时间成功");
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\PGM_ResetMultiOccupCoolDown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import mzm.gsp.chivalry.confbean.ChivalryConsts;
/*    */ import mzm.gsp.guaji.event.FinishOneGuajiEventProcedure;
/*    */ import mzm.gsp.guaji.main.FinishOneGuajiEventArg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnFinishOneGuajiEvent
/*    */   extends FinishOneGuajiEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     ChivalryManager.addFactionNewGuyTypeChivalry(((FinishOneGuajiEventArg)this.arg).getFightRoleIds(), 8, ChivalryConsts.getInstance().SHUA_YE_FACTION_ADD_PER_ONE_NEW_GUY, new TLogArg(LogReason.GUA_JI_FACTION_TAKE_NEW_GUY_AWARD));
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\POnFinishOneGuajiEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.bless.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.bless.confbean.SBlessConst;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 13 */     if (type != 329)
/*    */     {
/* 15 */       return;
/*    */     }
/*    */     
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     int activityCfgid = SBlessConst.getInstance().HALF_ANNIVERSARY_ACTIVITY_CFG_ID;
/* 24 */     BlessManager.onOpenChange(activityCfgid, ((OpenChangeComplexArg)this.arg).isOpen());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bless\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
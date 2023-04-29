/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.drawandguess.confbean.SOpenCfgid2ActivityCfgid;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ 
/*    */ public class POnOpenChange extends mzm.gsp.open.event.OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 13 */     if (!SOpenCfgid2ActivityCfgid.getAll().containsKey(Integer.valueOf(type)))
/*    */     {
/* 15 */       return;
/*    */     }
/*    */     
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return;
/*    */     }
/* 22 */     int activityCfgid = SOpenCfgid2ActivityCfgid.get(type).activityCfgid;
/* 23 */     DrawAndGuessManager.onOpenChange(activityCfgid, ((OpenChangeComplexArg)this.arg).isOpen());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.npcreward.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.npcreward.confbean.SOpenCfgid2ActivityCfgid;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ 
/*    */ public class ROnOpenChange extends mzm.gsp.open.event.OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 11 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 12 */     if (!SOpenCfgid2ActivityCfgid.getAll().containsKey(Integer.valueOf(type)))
/*    */     {
/* 14 */       return;
/*    */     }
/*    */     
/* 17 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 19 */       return;
/*    */     }
/* 21 */     int activityCfgid = SOpenCfgid2ActivityCfgid.get(type).activityCfgid;
/* 22 */     NPCRewardManager.onOpenChange(activityCfgid, ((OpenChangeComplexArg)this.arg).isOpen());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npcreward\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
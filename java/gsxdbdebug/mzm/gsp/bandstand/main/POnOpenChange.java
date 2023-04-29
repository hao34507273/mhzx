/*    */ package mzm.gsp.bandstand.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SBandstandActivityCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ public class POnOpenChange extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (((OpenChangeComplexArg)this.arg).getType() != 548)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     for (SBandstandActivityCfg sBandstandActivityCfg : SBandstandActivityCfg.getAll().values())
/*    */     {
/* 28 */       int npcId = sBandstandActivityCfg.npcId;
/* 29 */       SNpc sNpc = SNpc.get(npcId);
/* 30 */       if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */       {
/* 32 */         if (ActivityInterface.isActivityOpen(sBandstandActivityCfg.activityId))
/*    */         {
/* 34 */           ControllerInterface.triggerController(sNpc.controllerId);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 39 */         ControllerInterface.collectController(sNpc.controllerId);
/*    */       }
/*    */     }
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
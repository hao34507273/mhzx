/*    */ package mzm.gsp.lonngboatrace.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     for (LonngBoatRaceActivityCfg cfg : LonngBoatRaceActivityCfg.getAll().values())
/*    */     {
/* 20 */       if (cfg.switchId == ((OpenChangeComplexArg)this.arg).getType())
/*    */       {
/* 22 */         boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 23 */         SNpc sNpc = NpcInterface.getNpc(cfg.npcId);
/* 24 */         if (isOpen)
/*    */         {
/* 26 */           if (!ActivityInterface.isActivityOpen(cfg.activityId))
/* 27 */             return false;
/* 28 */           ControllerInterface.triggerController(sNpc.controllerId);
/*    */         }
/*    */         else
/*    */         {
/* 32 */           ControllerInterface.collectController(sNpc.controllerId);
/*    */         }
/*    */       }
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.lonngboatrace.main;
/*    */ 
/*    */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLonngBoatRaceStart
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public POnLonngBoatRaceStart(int activityId)
/*    */   {
/* 20 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     LonngBoatRaceActivityCfg activityCfg = LonngBoatRaceActivityCfg.get(this.activityId);
/* 27 */     if (activityCfg == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     if (!OpenInterface.getOpenStatus(activityCfg.switchId))
/* 32 */       return false;
/* 33 */     SNpc sNpc = NpcInterface.getNpc(activityCfg.npcId);
/* 34 */     ControllerInterface.triggerController(sNpc.controllerId);
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\POnLonngBoatRaceStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.lonngboatrace.main;
/*    */ 
/*    */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLonngBoatRaceEnd
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public POnLonngBoatRaceEnd(int activityId)
/*    */   {
/* 19 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     LonngBoatRaceActivityCfg activityCfg = LonngBoatRaceActivityCfg.get(this.activityId);
/* 26 */     if (activityCfg == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     SNpc sNpc = NpcInterface.getNpc(activityCfg.npcId);
/* 31 */     ControllerInterface.collectController(sNpc.controllerId);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\POnLonngBoatRaceEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
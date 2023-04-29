/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class PointRaceFightContext implements FightContext
/*    */ {
/*    */   public final long worldid;
/*    */   public final long activeCorpsid;
/*    */   public final long passiveCorpsid;
/*    */   
/*    */   public PointRaceFightContext(long worldid, long activeCorpsid, long passiveCorpsid)
/*    */   {
/* 13 */     this.worldid = worldid;
/* 14 */     this.activeCorpsid = activeCorpsid;
/* 15 */     this.passiveCorpsid = passiveCorpsid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
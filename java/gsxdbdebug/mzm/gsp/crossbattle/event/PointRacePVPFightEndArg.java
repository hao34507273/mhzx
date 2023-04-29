/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ public class PointRacePVPFightEndArg
/*    */ {
/*    */   public final long worldid;
/*    */   public final long activeCorpsid;
/*    */   public final long passiveCorpsid;
/*    */   
/*    */   public PointRacePVPFightEndArg(long worldid, long activeCorpsid, long passiveCorpsid)
/*    */   {
/* 11 */     this.worldid = worldid;
/* 12 */     this.activeCorpsid = activeCorpsid;
/* 13 */     this.passiveCorpsid = passiveCorpsid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\PointRacePVPFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
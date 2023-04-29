/*    */ package mzm.gsp.aircraft.event;
/*    */ 
/*    */ 
/*    */ public class AircraftModelChangeArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final AircraftChangeReason aircraftChangeReason;
/*    */   
/*    */   public AircraftModelChangeArg(long roleId, AircraftChangeReason aircraftChangeReason)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.aircraftChangeReason = aircraftChangeReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\event\AircraftModelChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
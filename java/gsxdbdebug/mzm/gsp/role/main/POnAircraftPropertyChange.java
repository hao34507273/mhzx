/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.aircraft.event.AircraftPropertyChangeArg;
/*    */ import mzm.gsp.aircraft.event.AircraftPropertyChangeProcedure;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface;
/*    */ 
/*    */ public class POnAircraftPropertyChange extends AircraftPropertyChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     RoleOutFightObj outFightObj = new RoleOutFightObj(((AircraftPropertyChangeArg)this.arg).roleId);
/* 12 */     outFightObj.setAircraftPro(AircraftInterface.getAircraftPropertyMap(((AircraftPropertyChangeArg)this.arg).roleId, true));
/* 13 */     outFightObj.syncClientRoleProperty();
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnAircraftPropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
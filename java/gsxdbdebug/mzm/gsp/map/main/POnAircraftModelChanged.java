/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.aircraft.event.AircraftModelChangeArg;
/*    */ import mzm.gsp.aircraft.event.AircraftModelChangeProcedure;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface.RideAircraftObj;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ 
/*    */ public class POnAircraftModelChanged extends AircraftModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleid = ((AircraftModelChangeArg)this.arg).roleId;
/* 16 */     Map<Integer, Object> changeProps = new HashMap();
/* 17 */     AircraftInterface.RideAircraftObj rideAircraftObj = AircraftInterface.getRideAircraftObj(roleid, true);
/* 18 */     if (rideAircraftObj != null)
/*    */     {
/* 20 */       changeProps.put(Integer.valueOf(13), Integer.valueOf(rideAircraftObj.aircraftCfgId));
/* 21 */       changeProps.put(Integer.valueOf(23), Integer.valueOf(rideAircraftObj.aircraftDyeColorId));
/*    */     }
/* 23 */     new MMH_OnRoleAppearanceChanged(roleid, 11, changeProps).execute();
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnAircraftModelChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
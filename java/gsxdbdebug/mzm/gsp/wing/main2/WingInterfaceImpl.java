/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.WingPlan;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingInterfaceImpl
/*    */ {
/*    */   static Map<Integer, Integer> getCurWingPlanPros(long roleId, boolean remainLock)
/*    */   {
/* 24 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, remainLock);
/* 25 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 26 */     if (xWingPlan == null)
/*    */     {
/* 28 */       return new HashMap();
/*    */     }
/*    */     
/* 31 */     RoleWingPlan xPlan = new RoleWingPlan(roleId, 1, xWingPlan);
/* 32 */     return xPlan.getWingPro();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static Map<Integer, Integer> getCurWingPlanSkills(long roleId, boolean remainLock)
/*    */   {
/* 48 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, remainLock);
/* 49 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 50 */     if (xWingPlan == null)
/*    */     {
/* 52 */       return new HashMap();
/*    */     }
/*    */     
/* 55 */     RoleWingPlan xPlan = new RoleWingPlan(roleId, 1, xWingPlan);
/* 56 */     return xPlan.getAllSkillsInfo();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static WingInterface.WingExteriorInfo getEquipedWingId(long roleId, boolean remainRoleLock)
/*    */   {
/* 68 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, remainRoleLock);
/* 69 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 70 */     if (xWingPlan == null)
/*    */     {
/* 72 */       return null;
/*    */     }
/*    */     
/* 75 */     RoleWingPlan xPlan = new RoleWingPlan(roleId, 1, xWingPlan);
/* 76 */     int eqWingId = xPlan.getOutLookWing();
/* 77 */     if (eqWingId <= 0)
/*    */     {
/* 79 */       return null;
/*    */     }
/*    */     
/* 82 */     int exteriorId = WingCfgManager.getExteriorId(eqWingId);
/* 83 */     if (exteriorId <= 0)
/*    */     {
/* 85 */       GameServer.logger().error(String.format("[wing]WingInterfaceImpl.getEquipedWingId@ get exteriorId error!|eqWingId=%d", new Object[] { Integer.valueOf(eqWingId) }));
/*    */       
/* 87 */       return null;
/*    */     }
/* 89 */     int colorId = xPlan.getWingColorId(eqWingId);
/* 90 */     if (colorId <= 0)
/*    */     {
/* 92 */       GameServer.logger().error(String.format("[wing]WingInterfaceImpl.getEquipedWingId@ get colorId error!|eqWingId=%d", new Object[] { Integer.valueOf(eqWingId) }));
/*    */       
/* 94 */       return null;
/*    */     }
/*    */     
/* 97 */     return new WingInterface.WingExteriorInfo(exteriorId, colorId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\WingInterfaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
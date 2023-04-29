/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xbean.BasicPropertiesSystem;
/*    */ import xbean.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LogRolePropertySystemManager
/*    */ {
/*    */   public static final int PROPERTY_CHANGE_ACTION__TEMPLET = 1;
/*    */   public static final int PROPERTY_CHANGE_ACTION__ACTIVE_DISTRIBUTE = 2;
/*    */   public static final int PROPERTY_CHANGE_ACTION__SWITCH = 3;
/*    */   public static final int PROPERTY_CHANGE_ACTION__AUTOMATIC = 4;
/*    */   public static final int PROPERTY_CHANGE_ACTION__CLEAR = 5;
/*    */   
/*    */   private static String getPropertySystemMsg(Map<Integer, BasicPropertiesSystem> xPropertysysmap, int systemIndex)
/*    */   {
/* 25 */     if ((xPropertysysmap == null) || (xPropertysysmap.size() == 0))
/*    */     {
/* 27 */       return "";
/*    */     }
/* 29 */     BasicPropertiesSystem xBasicPropertiesSystem = (BasicPropertiesSystem)xPropertysysmap.get(Integer.valueOf(systemIndex));
/* 30 */     if (xBasicPropertiesSystem == null)
/*    */     {
/* 32 */       return "";
/*    */     }
/*    */     
/* 35 */     StringBuffer sb = new StringBuffer();
/* 36 */     sb.append("[").append(systemIndex).append(",").append(xBasicPropertiesSystem.getPotentialpoint()).append(",").append(xBasicPropertiesSystem.getIsautospecialpoint() ? 1 : 0).append(",").append(xBasicPropertiesSystem.getBasicpropertymap()).append(",").append(xBasicPropertiesSystem.getAutoassignpointpref()).append("]");
/*    */     
/*    */ 
/*    */ 
/* 40 */     return sb.toString();
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
/*    */   static void tlogRolePropertySystem(String userId, long roleId, Properties xProperties, int actionType, int systemIndex)
/*    */   {
/* 56 */     String vGameIP = GameServerInfoManager.getHostIP();
/*    */     
/* 58 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(xProperties.getLevel()), Integer.valueOf(xProperties.getActivitybpsys()), Integer.valueOf(actionType), Integer.valueOf(systemIndex), getPropertySystemMsg(xProperties.getPropertysysmap(), 0), getPropertySystemMsg(xProperties.getPropertysysmap(), 1), getPropertySystemMsg(xProperties.getPropertysysmap(), 2) };
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 63 */     TLogManager.getInstance().addLog(roleId, "RolePropertySystem", colums);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\LogRolePropertySystemManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
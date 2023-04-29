/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlantTreeTlogManager
/*    */ {
/*    */   public static final int ACTION_ONLINR_REWARD_POINT = 1;
/*    */   public static final int ACTION_ADD_POINT_OPERATION = 2;
/*    */   public static final int ACTION_ADD_SPECIAL_STATE = 3;
/*    */   public static final int ACTION_REMOVE_SPECIAL_STATE = 4;
/*    */   public static final int ACTION_GET_SECTION_AWARD = 5;
/*    */   public static final int ACTION_GET_ACTIVITY_AWARD = 6;
/*    */   
/*    */   static void addPlantTreeTlog(long roleid, int activityCfgid, long targetid, int action, int currentSectionid, int currentSectionPoint, int specialStateIndex, int addPoint, int addPointOperationCfgid, int addOrRemoveSpecialStateIndex, int awardSectionid)
/*    */   {
/* 34 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 35 */     String userid = RoleInterface.getUserId(roleid);
/* 36 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 37 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Long.valueOf(targetid), Integer.valueOf(action), Integer.valueOf(currentSectionid), Integer.valueOf(currentSectionPoint), Integer.valueOf(specialStateIndex), Integer.valueOf(addPoint), Integer.valueOf(addPointOperationCfgid), Integer.valueOf(addOrRemoveSpecialStateIndex), Integer.valueOf(awardSectionid) });
/*    */     
/*    */ 
/* 40 */     TLogManager.getInstance().addLog(roleid, "PlantTreeForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PlantTreeTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
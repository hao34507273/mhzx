/*    */ package mzm.gsp.storywall.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StoryWallModule
/*    */   implements Module
/*    */ {
/* 19 */   public static int MAX_STORY_COUNT = 3;
/* 20 */   public static Logger logger = Logger.getLogger("StoryWall");
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 24 */     NoneRealTimeTaskManager.getInstance().addTask(new PRefreshStoryWall());
/* 25 */     ActivityInterface.registerActivityByLogicType(59, new StoryWallActivityHandler());
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */   public static void logInfo(String format, Object... args) {
/* 45 */     logger.info(String.format(format, args));
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
/*    */   static void tlogStoryWall(long roleId, long storyId, int awardId)
/*    */   {
/* 60 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 61 */     String userid = RoleInterface.getUserId(roleId);
/* 62 */     int rolelevel = RoleInterface.getLevel(roleId);
/*    */     
/* 64 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(storyId), Integer.valueOf(awardId) };
/*    */     
/* 66 */     TLogManager.getInstance().addLog(roleId, "StoryWall", colums);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isRoleStateCanJoinStorywallActivity(long roleid)
/*    */   {
/* 77 */     return RoleStatusInterface.checkCanSetStatus(roleid, 152, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storywall\main\StoryWallModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
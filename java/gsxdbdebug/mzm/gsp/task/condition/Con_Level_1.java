/*    */ package mzm.gsp.task.condition;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.confbean.STaskConlevel;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ConBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Con_Level_1
/*    */   extends AbsCondition
/*    */ {
/*    */   public Con_Level_1(int conId, int conType, int sTaskId)
/*    */   {
/* 23 */     super(conId, conType, sTaskId);
/*    */   }
/*    */   
/*    */   STaskConlevel getConlevel()
/*    */   {
/* 28 */     return STaskConlevel.get(getConId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*    */   {
/* 34 */     STaskConlevel conLevel = getConlevel();
/* 35 */     int taskId = getTaskId();
/* 36 */     int level = RoleInterface.getLevel(roleId);
/* 37 */     if ((conLevel.minLevel > 0) && (conLevel.minLevel > level))
/*    */     {
/* 39 */       if (GameServer.logger().isDebugEnabled())
/*    */       {
/* 41 */         GameServer.logger().debug(String.format("[Task]Con_Level_1.isComplete@ 玩家等级不满足条件!|roleId=%d|graphId=%d|taskId=%d|roleLevel=%d|conType=%d|conLevelLow=%d|conLevelHigh=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(level), Integer.valueOf(getConType()), Integer.valueOf(conLevel.minLevel), Integer.valueOf(conLevel.maxLevel) }));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 46 */       return false;
/*    */     }
/* 48 */     if ((conLevel.maxLevel > 0) && (conLevel.maxLevel < level))
/*    */     {
/* 50 */       if (GameServer.logger().isDebugEnabled())
/*    */       {
/* 52 */         GameServer.logger().debug(String.format("[Task]Con_Level_1.isComplete@玩家等级不满足条件！|roleId=%d|graphId=%d|taskId=%d|roleLevel=%d|conTyp=%d|conLevelLow=%d|conLevelHigh=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(level), Integer.valueOf(getConType()), Integer.valueOf(conLevel.minLevel), Integer.valueOf(conLevel.maxLevel) }));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 57 */       return false;
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 65 */     return 1;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Level_1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
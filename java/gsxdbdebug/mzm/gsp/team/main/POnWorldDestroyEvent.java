/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.event.WorldDestroyEventProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnWorldDestroyEvent
/*    */   extends WorldDestroyEventProcedure
/*    */ {
/* 16 */   private static final Logger logger = Logger.getLogger(POnWorldDestroyEvent.class);
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     long worldId = ((Long)this.arg).longValue();
/* 22 */     if (worldId <= 0L)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     Map<Long, JoinTeamCheckHandler> handlers = TeamManager.getJoinTeamCheckHandlers();
/* 27 */     JoinTeamCheckHandler handler = (JoinTeamCheckHandler)handlers.get(Long.valueOf(worldId));
/* 28 */     if (handler == null)
/*    */     {
/* 30 */       return true;
/*    */     }
/* 32 */     logger.error("world已经销毁，但是没有销毁加入队伍注册，类名：" + handler.getClass().getName());
/*    */     
/* 34 */     handlers.remove(Long.valueOf(worldId));
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnWorldDestroyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
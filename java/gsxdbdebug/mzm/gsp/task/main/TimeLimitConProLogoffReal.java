/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.task.condition.ConditionEnum;
/*    */ import mzm.gsp.task.confbean.STaskContimeLimit;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ConBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimeLimitConProLogoffReal
/*    */   extends TimeLimitConPro
/*    */ {
/*    */   public TimeLimitConProLogoffReal(long roleId)
/*    */   {
/* 22 */     super(roleId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   boolean handle(int graphId, int taskId, int conId, ConBean xConBean)
/*    */   {
/* 29 */     Map<Integer, Long> xParams = xConBean.getParammap();
/* 30 */     if ((xParams == null) || (xParams.size() == 0))
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     Long leftTime = (Long)xParams.get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()));
/* 35 */     if (leftTime == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     STaskContimeLimit cfg = STaskContimeLimit.get(conId);
/* 40 */     if (cfg == null)
/*    */     {
/* 42 */       GameServer.logger().error(String.format("[task]TimeLimitConProLogoffReal.handle@ STaskContimeLimit is null!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(conId) }));
/*    */       
/*    */ 
/*    */ 
/* 46 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 50 */     Long sessionId = (Long)xParams.get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_END_SESSIONID.getParamType()));
/* 51 */     if (sessionId == null)
/*    */     {
/* 53 */       GameServer.logger().error(String.format("[task]TimeLimitConProLogoffReal.handle@ sessionId is null!|roleId=%d|graphId=%d|taskId=%d|conId=%d|sessionId=%s", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(conId), sessionId }));
/*    */       
/*    */ 
/*    */ 
/* 57 */       return false;
/*    */     }
/* 59 */     Session session = Session.removeSession(sessionId.longValue());
/* 60 */     if (session == null)
/*    */     {
/*    */ 
/* 63 */       GameServer.logger().error(String.format("[task]TimeLimitConProLogoffReal.handle@ session is null!|roleId=%d|graphId=%d|taskId=%d|conId=%d|sessionId=%s", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(conId), sessionId }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 68 */     xParams.put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_END_SESSIONID.getParamType()), Long.valueOf(0L));
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   TimeLimitConPro.HandType getType()
/*    */   {
/* 76 */     return TimeLimitConPro.HandType.RoleLogoffAsReal;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TimeLimitConProLogoffReal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
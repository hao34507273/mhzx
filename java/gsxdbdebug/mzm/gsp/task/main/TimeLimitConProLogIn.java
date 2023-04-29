/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.condition.ConditionEnum;
/*     */ import mzm.gsp.task.confbean.STaskContimeLimit;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeLimitConProLogIn
/*     */   extends TimeLimitConPro
/*     */ {
/*     */   public TimeLimitConProLogIn(long roleId)
/*     */   {
/*  26 */     super(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */   boolean handle(int graphId, int taskId, int conId, ConBean xConBean)
/*     */   {
/*  32 */     Map<Integer, Long> xParams = xConBean.getParammap();
/*  33 */     if ((xParams == null) || (xParams.size() == 0))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     Long leftTime = (Long)xParams.get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()));
/*  38 */     if (leftTime == null)
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     STaskContimeLimit cfg = STaskContimeLimit.get(conId);
/*  43 */     if (cfg == null)
/*     */     {
/*  45 */       GameServer.logger().error(String.format("[task]TimeLimitConProLogIn.handle@ STaskContimeLimit is null!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(conId) }));
/*     */       
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     Long sessionId = (Long)xParams.get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_END_SESSIONID.getParamType()));
/*  54 */     if (sessionId != null)
/*     */     {
/*  56 */       Session session = Session.getSession(sessionId.longValue());
/*  57 */       if (session != null)
/*     */       {
/*     */ 
/*  60 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/*  62 */           GameServer.logger().debug(String.format("[task]TimeLimitConProLogIn.handle@ session is not null, role login within protect time!|roleId=%d|graphId=%d|taskId=%d|conId=%d|sessionId=%d", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(conId), sessionId }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  67 */         return false;
/*     */       }
/*  69 */       xParams.put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_END_SESSIONID.getParamType()), Long.valueOf(0L));
/*     */     }
/*  71 */     leftTime = Long.valueOf(getRealLeftTime(graphId, taskId, conId, xParams, leftTime.longValue()));
/*  72 */     if (leftTime.longValue() <= 3000L)
/*     */     {
/*     */ 
/*  75 */       xParams.put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()), Long.valueOf(0L));
/*  76 */       xParams.put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_START_TIME.getParamType()), Long.valueOf(0L));
/*     */       
/*  78 */       TaskInterface.updateTaskCondition(getRoleId(), taskId, 14, new Object());
/*  79 */       return true;
/*     */     }
/*     */     
/*  82 */     TaskTimeLimitSession session = new TaskTimeLimitSession(TimeUnit.MILLISECONDS.toSeconds(leftTime.longValue()), getRoleId(), graphId, taskId, cfg);
/*     */     
/*  84 */     xParams.put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_END_SESSIONID.getParamType()), Long.valueOf(session.getSessionId()));
/*  85 */     xParams.put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_START_TIME.getParamType()), Long.valueOf(DateTimeUtils.getCurrTimeInMillis()));
/*  86 */     xParams.put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()), leftTime);
/*  87 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long getRealLeftTime(int graphId, int taskId, int conId, Map<Integer, Long> xParams, long oldLeftTime)
/*     */   {
/* 101 */     Long startTime = (Long)xParams.get(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_START_TIME.getParamType()));
/* 102 */     if (startTime == null)
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[task]TimeLimitConProLogIn.handle@ startTime is null!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(conId) }));
/*     */       
/*     */ 
/*     */ 
/* 108 */       return -1L;
/*     */     }
/* 110 */     long lastLogoffTime = RoleInterface.getLastLogoffTime(getRoleId());
/* 111 */     long leftTime = oldLeftTime - (lastLogoffTime - startTime.longValue());
/* 112 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 114 */       GameServer.logger().debug(String.format("[task]TimeLimitConProLogIn.getRealLeftTime@ left time info:|roleId=%d|graphId=%d|taskId=%d|conId=%d|leftTime=%d|lastStartTime=%s|lastLogoffTime=%s", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(conId), Long.valueOf(leftTime), DateTimeUtils.formatTimestamp(startTime.longValue()), DateTimeUtils.formatTimestamp(lastLogoffTime) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 120 */     return leftTime;
/*     */   }
/*     */   
/*     */ 
/*     */   TimeLimitConPro.HandType getType()
/*     */   {
/* 126 */     return TimeLimitConPro.HandType.RoleLogin;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TimeLimitConProLogIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
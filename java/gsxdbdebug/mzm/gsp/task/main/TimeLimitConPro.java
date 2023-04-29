/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xbean.TaskDataBean;
/*     */ import xtable.Role2task;
/*     */ 
/*     */ public abstract class TimeLimitConPro
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public TimeLimitConPro(long roleId)
/*     */   {
/*  22 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   public long getRoleId()
/*     */   {
/*  27 */     return this.roleId;
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
/*     */   boolean handleTimeConTask()
/*     */   {
/*  41 */     TaskDataBean xTaskDataBean = Role2task.get(Long.valueOf(this.roleId));
/*  42 */     if (xTaskDataBean == null)
/*     */     {
/*  44 */       GameServer.logger().error(String.format("[task]TimeLimitConPro.handleTimeConTask@ role task data is null!|roleId=%d|type=%s", new Object[] { Long.valueOf(this.roleId), getType() }));
/*     */       
/*     */ 
/*  47 */       return false;
/*     */     }
/*  49 */     Iterator<Map.Entry<Integer, GraphBean>> it = xTaskDataBean.getGraphbeans().entrySet().iterator();
/*  50 */     while (it.hasNext())
/*     */     {
/*  52 */       Map.Entry<Integer, GraphBean> entry = (Map.Entry)it.next();
/*  53 */       handEachGraph(((Integer)entry.getKey()).intValue(), (GraphBean)entry.getValue());
/*     */     }
/*  55 */     return true;
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
/*     */   private void handEachGraph(int graphId, GraphBean xGraphBean)
/*     */   {
/*  68 */     Map<Integer, TaskBean> xTaskData = xGraphBean.getNodebean().getTaskbeans();
/*  69 */     if ((xTaskData == null) || (xTaskData.size() == 0))
/*     */     {
/*  71 */       GameServer.logger().error(String.format("[task]TimeLimitConPro.handEachGraph@ role xTaskData is null!|roleId=%d|type=%s|graphId=%d", new Object[] { Long.valueOf(getRoleId()), getType(), Integer.valueOf(graphId) }));
/*     */       
/*     */ 
/*  74 */       return;
/*     */     }
/*  76 */     Iterator<Map.Entry<Integer, TaskBean>> it = xTaskData.entrySet().iterator();
/*  77 */     while (it.hasNext())
/*     */     {
/*  79 */       Map.Entry<Integer, TaskBean> entry = (Map.Entry)it.next();
/*  80 */       handEachTask(graphId, ((Integer)entry.getKey()).intValue(), (TaskBean)entry.getValue());
/*     */     }
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
/*     */ 
/*     */   private void handEachTask(int graphId, int taskId, TaskBean xTaskBean)
/*     */   {
/*  96 */     if (xTaskBean.getTaskstate() != 2)
/*     */     {
/*  98 */       return;
/*     */     }
/* 100 */     Map<Integer, ConBean> xConBeans = xTaskBean.getConmap();
/* 101 */     if ((xConBeans == null) || (xConBeans.size() == 0))
/*     */     {
/* 103 */       return;
/*     */     }
/* 105 */     Iterator<Map.Entry<Integer, ConBean>> it = xConBeans.entrySet().iterator();
/* 106 */     while (it.hasNext())
/*     */     {
/* 108 */       Map.Entry<Integer, ConBean> entry = (Map.Entry)it.next();
/* 109 */       handle(graphId, taskId, ((Integer)entry.getKey()).intValue(), (ConBean)entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract boolean handle(int paramInt1, int paramInt2, int paramInt3, ConBean paramConBean);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract HandType getType();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum HandType
/*     */   {
/* 134 */     RoleLogin, 
/* 135 */     RoleLogoffAsReal;
/*     */     
/*     */     private HandType() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TimeLimitConPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
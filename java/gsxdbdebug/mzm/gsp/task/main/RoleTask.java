/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xbean.TaskDataBean;
/*     */ import xtable.Role2task;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleTask
/*     */ {
/*     */   private final long roleId;
/*     */   private TaskDataBean taskDataBean;
/*     */   
/*     */   RoleTask(long roleId, boolean isRetainLock)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     if (isRetainLock)
/*     */     {
/*  41 */       this.taskDataBean = Role2task.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  45 */       this.taskDataBean = Role2task.select(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */   
/*     */   long getRoleId()
/*     */   {
/*  51 */     return this.roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TaskDataBean getTaskDataBean()
/*     */   {
/*  61 */     return this.taskDataBean;
/*     */   }
/*     */   
/*     */   public void setTaskDataBean(TaskDataBean taskDataBean)
/*     */   {
/*  66 */     this.taskDataBean = taskDataBean;
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
/*     */   public boolean hasTask(int graphId, int taskId)
/*     */   {
/*  80 */     if (this.taskDataBean == null)
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     if (this.taskDataBean.getGraphbeans().containsKey(Integer.valueOf(graphId)))
/*     */     {
/*  86 */       GraphBean graphBean = (GraphBean)this.taskDataBean.getGraphbeans().get(Integer.valueOf(graphId));
/*  87 */       return graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(taskId));
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasGraph(int graphId)
/*     */   {
/* 101 */     if (this.taskDataBean == null)
/*     */     {
/* 103 */       return false;
/*     */     }
/* 105 */     return this.taskDataBean.getGraphbeans().containsKey(Integer.valueOf(graphId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasTask(int taskId)
/*     */   {
/* 116 */     if (this.taskDataBean == null)
/*     */     {
/* 118 */       return false;
/*     */     }
/* 120 */     for (GraphBean graphBean : this.taskDataBean.getGraphbeans().values())
/*     */     {
/* 122 */       if (graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(taskId)))
/*     */       {
/* 124 */         return true;
/*     */       }
/*     */     }
/* 127 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TaskBean getTaskBean(int graphId, int taskId)
/*     */   {
/* 139 */     if (this.taskDataBean == null)
/*     */     {
/* 141 */       return null;
/*     */     }
/* 143 */     if (this.taskDataBean.getGraphbeans().containsKey(Integer.valueOf(graphId)))
/*     */     {
/* 145 */       GraphBean graphBean = (GraphBean)this.taskDataBean.getGraphbeans().get(Integer.valueOf(graphId));
/* 146 */       return (TaskBean)graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(taskId));
/*     */     }
/* 148 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<TaskBean> getTaskBeans(int taskId)
/*     */   {
/* 159 */     List<TaskBean> taskBeans = new ArrayList();
/* 160 */     if (this.taskDataBean != null)
/*     */     {
/* 162 */       for (GraphBean graphBean : this.taskDataBean.getGraphbeans().values())
/*     */       {
/* 164 */         if (graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(taskId)))
/*     */         {
/* 166 */           taskBeans.add(graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(taskId)));
/*     */         }
/*     */       }
/*     */     }
/* 170 */     return taskBeans;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<TaskBean> getAllTaskBean()
/*     */   {
/* 180 */     List<TaskBean> taskBeanList = new ArrayList();
/* 181 */     if (this.taskDataBean == null)
/*     */     {
/* 183 */       return taskBeanList;
/*     */     }
/* 185 */     for (GraphBean graphBean : this.taskDataBean.getGraphbeans().values())
/*     */     {
/* 187 */       taskBeanList.addAll(graphBean.getNodebean().getTaskbeans().values());
/*     */     }
/* 189 */     return taskBeanList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, List<TaskBean>> getAllTaskBeanMap()
/*     */   {
/* 200 */     Map<Integer, List<TaskBean>> m = new HashMap();
/* 201 */     if (this.taskDataBean == null)
/*     */     {
/* 203 */       return m;
/*     */     }
/* 205 */     Iterator<Map.Entry<Integer, GraphBean>> it = this.taskDataBean.getGraphbeans().entrySet().iterator();
/* 206 */     while (it.hasNext())
/*     */     {
/* 208 */       Map.Entry<Integer, GraphBean> entry = (Map.Entry)it.next();
/* 209 */       int graphId = ((Integer)entry.getKey()).intValue();
/* 210 */       GraphBean xGraphBean = (GraphBean)entry.getValue();
/* 211 */       List<TaskBean> taskBeanList = new ArrayList();
/* 212 */       taskBeanList.addAll(xGraphBean.getNodebean().getTaskbeans().values());
/* 213 */       m.put(Integer.valueOf(graphId), taskBeanList);
/*     */     }
/* 215 */     return m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, List<TaskStateInfo>> getTaskStateInfo()
/*     */   {
/* 226 */     Map<Integer, List<TaskStateInfo>> map = new HashMap();
/* 227 */     if (this.taskDataBean == null)
/*     */     {
/* 229 */       return map;
/*     */     }
/* 231 */     Iterator<Map.Entry<Integer, GraphBean>> it = this.taskDataBean.getGraphbeans().entrySet().iterator();
/* 232 */     int graphId; while (it.hasNext())
/*     */     {
/* 234 */       Map.Entry<Integer, GraphBean> entry = (Map.Entry)it.next();
/* 235 */       graphId = ((Integer)entry.getKey()).intValue();
/* 236 */       GraphBean xGraphBean = (GraphBean)entry.getValue();
/* 237 */       for (TaskBean xTaskBean : xGraphBean.getNodebean().getTaskbeans().values())
/*     */       {
/* 239 */         int taskId = xTaskBean.getTaskid();
/* 240 */         int taskState = xTaskBean.getTaskstate();
/* 241 */         TaskStateInfo taskStateInfo = new TaskStateInfo(graphId, taskId, taskState);
/* 242 */         List<TaskStateInfo> taskStateInfos = (List)map.get(Integer.valueOf(taskId));
/* 243 */         if (taskStateInfos == null)
/*     */         {
/* 245 */           taskStateInfos = new ArrayList();
/* 246 */           map.put(Integer.valueOf(taskId), taskStateInfos);
/*     */         }
/* 248 */         taskStateInfos.add(taskStateInfo);
/*     */       }
/*     */     }
/* 251 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphBean getGraphBean(int graphId)
/*     */   {
/* 262 */     if (this.taskDataBean == null)
/*     */     {
/* 264 */       return null;
/*     */     }
/* 266 */     return (GraphBean)this.taskDataBean.getGraphbeans().get(Integer.valueOf(graphId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean remGraphBean(GraphBean graphBean)
/*     */   {
/* 276 */     if (this.taskDataBean == null)
/*     */     {
/* 278 */       return false;
/*     */     }
/* 280 */     return this.taskDataBean.getGraphbeans().remove(Integer.valueOf(graphBean.getGraphid())) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, GraphBean> getAllTeamGraph()
/*     */   {
/* 290 */     Map<Integer, GraphBean> teamGraphBeanMap = new HashMap();
/* 291 */     if (this.taskDataBean == null)
/*     */     {
/* 293 */       return teamGraphBeanMap;
/*     */     }
/* 295 */     for (GraphBean graphBean : this.taskDataBean.getGraphbeans().values())
/*     */     {
/* 297 */       int graphId = graphBean.getGraphid();
/* 298 */       Graph graph = GraphManager.getGraphById(graphId);
/* 299 */       if (graph != null)
/*     */       {
/*     */ 
/*     */ 
/* 303 */         if (graph.getSgraph().teamTaskGraph)
/*     */         {
/* 305 */           teamGraphBeanMap.put(Integer.valueOf(graphBean.getGraphid()), graphBean); }
/*     */       }
/*     */     }
/* 308 */     return teamGraphBeanMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\RoleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
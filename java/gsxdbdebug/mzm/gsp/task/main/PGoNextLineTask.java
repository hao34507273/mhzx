/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGoNextLineTask
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int graphId;
/*     */   
/*     */   public PGoNextLineTask(long roleId, int graphId)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.graphId = graphId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  40 */     if (graph == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (graph.isRingTypeGraph())
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[task]PGoNextLineTask.processImp@ is not line type graph!|graphId=%d", new Object[] { Integer.valueOf(this.graphId) }));
/*     */       
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     Set<Long> lockRoles = new HashSet();
/*  52 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  53 */     if (teamId == null)
/*     */     {
/*     */ 
/*  56 */       String leaderUserId = RoleInterface.getUserId(this.roleId);
/*  57 */       lock(Lockeys.get(User.getTable(), leaderUserId));
/*  58 */       lockRoles.add(Long.valueOf(this.roleId));
/*  59 */       lock(Basic.getTable(), lockRoles);
/*     */     }
/*     */     else
/*     */     {
/*  63 */       List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  64 */       lockRoles.addAll(teamMemberList);
/*  65 */       List<String> userIds = new ArrayList();
/*  66 */       for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */         
/*  68 */         userIds.add(RoleInterface.getUserId(tmpRoleId));
/*     */       }
/*     */       
/*  71 */       lock(User.getTable(), userIds);
/*     */       
/*  73 */       lock(Basic.getTable(), lockRoles);
/*  74 */       lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(teamId.longValue()) }));
/*     */     }
/*     */     
/*     */ 
/*  78 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/*  79 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/*     */     
/*  81 */     if (graphBean == null)
/*     */     {
/*     */ 
/*  84 */       if (graph.isTeamGraph())
/*     */       {
/*  86 */         List<Long> memeberList = TeamInterface.getTeamMemberList(TeamInterface.getTeamidByRoleid(this.roleId, false).longValue(), false);
/*  87 */         if (((Long)memeberList.get(0)).longValue() != this.roleId)
/*     */         {
/*  89 */           GameServer.logger().error(String.format("[task]PGoNextLineTask.processImp@ not leader!|graphId=%d|roleId=%d", new Object[] { Integer.valueOf(this.graphId), Long.valueOf(this.roleId) }));
/*     */           
/*  91 */           return false;
/*     */         }
/*  93 */         if (!RoleTaskManager.activeTeamGraph(this.graphId, memeberList))
/*     */         {
/*  95 */           GameServer.logger().error(String.format("[task]PGoNextLineTask.processImp@ active graph failed!|graphId=%d|roleId=%d", new Object[] { Integer.valueOf(this.graphId), Long.valueOf(this.roleId) }));
/*     */           
/*     */ 
/*  98 */           return false;
/*     */         }
/* 100 */         graphBean = roleTask.getGraphBean(this.graphId);
/*     */       }
/*     */       else
/*     */       {
/* 104 */         graphBean = RoleTaskManager.activeGraph(this.graphId, this.roleId);
/* 105 */         if (graphBean == null)
/*     */         {
/* 107 */           GameServer.logger().error(String.format("[task]PGoNextLineTask.processImp@ active graph failed!|graphId=%d|roleId=%d", new Object[] { Integer.valueOf(this.graphId), Long.valueOf(this.roleId) }));
/*     */           
/*     */ 
/* 110 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 115 */     Map<Integer, TaskBean> taskBeanMap = graphBean.getNodebean().getTaskbeans();
/* 116 */     if (taskBeanMap.size() > 1)
/*     */     {
/* 118 */       for (TaskBean taskBean : taskBeanMap.values())
/*     */       {
/* 120 */         RoleTaskManager.sendUpdateTaskState(this.roleId, this.graphId, taskBean.getTaskid(), 4);
/*     */       }
/* 122 */       graphBean.getNodebean().getTaskbeans().clear();
/* 123 */       taskBeanMap = graphBean.getNodebean().getTaskbeans();
/*     */     }
/* 125 */     if (taskBeanMap.size() == 1)
/*     */     {
/* 127 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*     */       {
/* 129 */         if (taskBean.getTaskstate() != 1)
/*     */         {
/* 131 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 135 */     if (taskBeanMap.size() == 0)
/*     */     {
/* 137 */       GameServer.logger().error(String.format("[task]PGoNextLineTask.processImp@ have no task to go next!|graphId=%d|roleId=%d", new Object[] { Integer.valueOf(this.graphId), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     ArrayList<TaskBean> taskBeansList = new ArrayList();
/* 144 */     for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*     */     {
/* 146 */       if (taskBean.getTaskstate() == 1)
/*     */       {
/* 148 */         taskBeansList.add(taskBean);
/*     */       }
/*     */     }
/* 151 */     if (taskBeansList.size() != 1)
/*     */     {
/* 153 */       return false;
/*     */     }
/* 155 */     Procedure.execute(new AccpetTaskProcedure(this.roleId, this.graphId, ((TaskBean)taskBeansList.get(0)).getTaskid()));
/* 156 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGoNextLineTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
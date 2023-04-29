/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.task.condition.AbsCondition;
/*     */ import mzm.gsp.task.condition.Con_Bag_9;
/*     */ import mzm.gsp.task.confbean.STaskConBag;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskEventArg
/*     */ {
/*     */   public final long roleId;
/*     */   public final int graphId;
/*     */   public final int taskId;
/*     */   public final int taskState;
/*     */   public final int taskNo;
/*     */   public final boolean isToEnd;
/*     */   private PVEFightEndArg pveArg;
/*     */   private long leaderId;
/*     */   
/*     */   public TaskEventArg(long roleId, int graphId, int taskId, int taskState, int taskNo, boolean isToEnd)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.graphId = graphId;
/*  30 */     this.taskId = taskId;
/*  31 */     this.taskState = taskState;
/*  32 */     this.taskNo = taskNo;
/*  33 */     this.isToEnd = isToEnd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getAllRoleList()
/*     */   {
/*  43 */     if (this.pveArg == null)
/*     */     {
/*  45 */       return new ArrayList();
/*     */     }
/*  47 */     return new ArrayList(this.pveArg.roleList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getRoleList()
/*     */   {
/*  57 */     if (this.pveArg == null)
/*     */     {
/*  59 */       return new ArrayList();
/*     */     }
/*  61 */     List<Long> noEcapedTeamList = new ArrayList();
/*  62 */     List<Long> tempList = new ArrayList();
/*  63 */     tempList.addAll(this.pveArg.roleList);
/*  64 */     tempList.removeAll(this.pveArg.escapedRoles);
/*  65 */     if (this.leaderId > 0L)
/*     */     {
/*  67 */       tempList.remove(Long.valueOf(this.leaderId));
/*  68 */       noEcapedTeamList.add(Long.valueOf(this.leaderId));
/*     */     }
/*  70 */     noEcapedTeamList.addAll(tempList);
/*  71 */     return noEcapedTeamList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getDiedMonsters()
/*     */   {
/*  81 */     if (this.pveArg == null)
/*     */     {
/*  83 */       return new ArrayList();
/*     */     }
/*  85 */     return new ArrayList(this.pveArg.diedMonsters);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PVEFightEndArg getPveArg()
/*     */   {
/*  95 */     return this.pveArg;
/*     */   }
/*     */   
/*     */   public void setPveArg(PVEFightEndArg pveArg)
/*     */   {
/* 100 */     this.pveArg = pveArg;
/*     */   }
/*     */   
/*     */   public void setLeaderId(long leaderId)
/*     */   {
/* 105 */     this.leaderId = leaderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isFightTask()
/*     */   {
/* 115 */     return this.pveArg != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isAllHandUped()
/*     */   {
/* 125 */     return (this.isToEnd) && (this.taskState == 8);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<TaskItemConditionInfo> getTaskConditionInfos()
/*     */   {
/* 135 */     Task task = TaskManager.getTaskById(this.taskId);
/* 136 */     if (task == null)
/*     */     {
/* 138 */       return Collections.emptySet();
/*     */     }
/* 140 */     List<AbsCondition> conditions = task.getCondition(9, 2);
/* 141 */     if ((conditions == null) || (conditions.size() == 0))
/*     */     {
/* 143 */       return Collections.emptySet();
/*     */     }
/* 145 */     Set<TaskItemConditionInfo> infos = new HashSet();
/* 146 */     for (AbsCondition condition : conditions)
/*     */     {
/* 148 */       if ((condition instanceof Con_Bag_9))
/*     */       {
/*     */ 
/*     */ 
/* 152 */         Con_Bag_9 bag_9 = (Con_Bag_9)condition;
/* 153 */         infos.add(new TaskItemConditionInfo(bag_9.getConBag().takeItemType, bag_9.getConBag().takeCfgId, bag_9.getConBag().takeCfgCount));
/*     */       }
/*     */     }
/* 156 */     return infos;
/*     */   }
/*     */   
/*     */   public class TaskItemConditionInfo
/*     */   {
/*     */     private final int itemType;
/*     */     private final int itemCfgId;
/*     */     private final int num;
/*     */     
/*     */     public TaskItemConditionInfo(int itemType, int itemCfgId, int num)
/*     */     {
/* 167 */       this.itemType = itemType;
/* 168 */       this.itemCfgId = itemCfgId;
/* 169 */       this.num = num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getItemType()
/*     */     {
/* 179 */       return this.itemType;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getItemCfgId()
/*     */     {
/* 189 */       return this.itemCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getNum()
/*     */     {
/* 199 */       return this.num;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
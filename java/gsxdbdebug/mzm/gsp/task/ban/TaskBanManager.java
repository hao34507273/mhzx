/*     */ package mzm.gsp.task.ban;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.task.main.TaskInterface;
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
/*     */ public class TaskBanManager
/*     */ {
/*     */   public static boolean isTaskBan(int graphId, int taskId, int banType)
/*     */   {
/*  26 */     return false;
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
/*     */   public static BanTaskRes addBanTaskId(int graphId, int taskId, int banType)
/*     */   {
/*  41 */     Set<Integer> taskIds = new HashSet();
/*  42 */     taskIds.add(Integer.valueOf(taskId));
/*  43 */     return addBanTaskIds(graphId, taskIds, banType);
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
/*     */ 
/*     */   public static BanTaskRes addBanTaskIds(int graphId, Set<Integer> taskIds, int banType)
/*     */   {
/*  59 */     BanTaskRes res = new BanTaskRes();
/*  60 */     if (!TaskInterface.isHaveGraphId(graphId))
/*     */     {
/*  62 */       Set<Integer> graphIds = new HashSet();
/*  63 */       graphIds.add(Integer.valueOf(graphId));
/*  64 */       res.addIllegalGraphIds(graphIds);
/*  65 */       res.setReason(BanTaskRes.BanTaskErr.IllegalGraphIds);
/*  66 */       res.setSuc(false);
/*  67 */       return res;
/*     */     }
/*  69 */     Set<Integer> illegalTaskIds = getNoExistTaskIds(taskIds);
/*  70 */     if (illegalTaskIds.size() > 0)
/*     */     {
/*  72 */       res.addIllegalTaskIds(illegalTaskIds);
/*  73 */       res.setReason(BanTaskRes.BanTaskErr.IllegalTaskIds);
/*  74 */       res.setSuc(false);
/*  75 */       return res;
/*     */     }
/*  77 */     if (!isBanTypeOk(banType))
/*     */     {
/*  79 */       res.setReason(BanTaskRes.BanTaskErr.IllegalBanType);
/*  80 */       res.setSuc(false);
/*  81 */       return res;
/*     */     }
/*  83 */     TaskBanCache taskBanCache = TaskBanContainer.getInstance().getCountInfo(banType);
/*  84 */     taskBanCache.banTasks(graphId, taskIds);
/*  85 */     return res;
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
/*     */   static void checkErrRes(BanTaskRes res, Set<Integer> graphIds, Set<Integer> taskIds, int banType)
/*     */   {
/*  98 */     Set<Integer> illegalGraphIds = getNoExistGraphIds(graphIds);
/*  99 */     if (illegalGraphIds.size() > 0)
/*     */     {
/* 101 */       res.addIllegalGraphIds(illegalGraphIds);
/* 102 */       res.setReason(BanTaskRes.BanTaskErr.IllegalGraphIds);
/* 103 */       res.setSuc(false);
/* 104 */       return;
/*     */     }
/* 106 */     Set<Integer> illegalTaskIds = getNoExistTaskIds(taskIds);
/* 107 */     if (illegalTaskIds.size() > 0)
/*     */     {
/* 109 */       res.addIllegalTaskIds(illegalTaskIds);
/* 110 */       res.setReason(BanTaskRes.BanTaskErr.IllegalTaskIds);
/* 111 */       res.setSuc(false);
/* 112 */       return;
/*     */     }
/* 114 */     if (!isBanTypeOk(banType))
/*     */     {
/* 116 */       res.setReason(BanTaskRes.BanTaskErr.IllegalBanType);
/* 117 */       res.setSuc(false);
/* 118 */       return;
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
/*     */   public static BanTaskRes addBanGraphId(int graphId, int banType)
/*     */   {
/* 131 */     Set<Integer> graphIds = new HashSet();
/* 132 */     graphIds.add(Integer.valueOf(graphId));
/* 133 */     return addBanGraphIds(graphIds, banType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static BanTaskRes addBanGraphIds(Set<Integer> graphIds, int banType)
/*     */   {
/* 145 */     BanTaskRes res = new BanTaskRes();
/* 146 */     Set<Integer> illegalGraphIds = getNoExistGraphIds(graphIds);
/* 147 */     if (illegalGraphIds.size() > 0)
/*     */     {
/* 149 */       res.addIllegalGraphIds(illegalGraphIds);
/* 150 */       res.setReason(BanTaskRes.BanTaskErr.IllegalGraphIds);
/* 151 */       res.setSuc(false);
/* 152 */       return res;
/*     */     }
/* 154 */     if (!isBanTypeOk(banType))
/*     */     {
/* 156 */       res.setReason(BanTaskRes.BanTaskErr.IllegalBanType);
/* 157 */       res.setSuc(false);
/* 158 */       return res;
/*     */     }
/* 160 */     TaskBanCache taskBanCache = TaskBanContainer.getInstance().getCountInfo(banType);
/* 161 */     taskBanCache.banAllGraph(graphIds);
/* 162 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getNoExistGraphIds(Set<Integer> graphIds)
/*     */   {
/* 174 */     if ((graphIds == null) || (graphIds.size() == 0))
/*     */     {
/* 176 */       return new HashSet();
/*     */     }
/* 178 */     Set<Integer> noExistGraphIds = new HashSet();
/* 179 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 181 */       if (!TaskInterface.isHaveGraphId(graphId))
/*     */       {
/*     */ 
/*     */ 
/* 185 */         noExistGraphIds.add(Integer.valueOf(graphId)); }
/*     */     }
/* 187 */     return noExistGraphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getNoExistTaskIds(Set<Integer> taskIds)
/*     */   {
/* 199 */     if ((taskIds == null) || (taskIds.size() == 0))
/*     */     {
/* 201 */       return new HashSet();
/*     */     }
/* 203 */     Set<Integer> noExistTaskIds = new HashSet();
/* 204 */     for (Iterator i$ = taskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*     */       
/* 206 */       if (!TaskInterface.isTaskExit(taskId))
/*     */       {
/*     */ 
/*     */ 
/* 210 */         noExistTaskIds.add(Integer.valueOf(taskId)); }
/*     */     }
/* 212 */     return noExistTaskIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isBanTypeOk(int banType)
/*     */   {
/* 224 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\TaskBanManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
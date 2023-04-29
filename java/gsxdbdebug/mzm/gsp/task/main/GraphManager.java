/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import mzm.gsp.task.confbean.SNode;
/*     */ import mzm.gsp.task.confbean.SNodeProperty;
/*     */ import mzm.gsp.task.confbean.STaskSet;
/*     */ import mzm.gsp.task.confbean.STaskToProperty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphManager
/*     */ {
/*  28 */   private static GraphManager instance = new GraphManager();
/*     */   
/*  30 */   private Map<Integer, Graph> graphsMap = new HashMap();
/*     */   
/*     */ 
/*  33 */   private Map<Integer, Graph> conditionGraphMap = new HashMap();
/*     */   
/*  35 */   private Map<Integer, Graph> graphIdGraphMap = new HashMap();
/*     */   
/*  37 */   private Map<Integer, Set<Integer>> npcIdToGraphIds = new HashMap();
/*     */   
/*  39 */   private static Map<Integer, Integer> graphId2fightType = new ConcurrentHashMap();
/*     */   
/*     */   public static final int MASTER_NPC_ID = 100;
/*     */   
/*     */   static GraphManager getInstance()
/*     */   {
/*  45 */     return instance;
/*     */   }
/*     */   
/*     */   public static Graph getGraphById(int graphId)
/*     */   {
/*  50 */     return (Graph)instance.graphsMap.get(Integer.valueOf(graphId));
/*     */   }
/*     */   
/*     */   static void setGraphFightType(int graphId, int fightType)
/*     */   {
/*  55 */     if (graphId2fightType.containsKey(Integer.valueOf(graphId)))
/*     */     {
/*  57 */       throw new RuntimeException("[task]setGraphFightType@设置任务图战斗类型出错！图id=" + graphId + " 已被注册！");
/*     */     }
/*  59 */     graphId2fightType.put(Integer.valueOf(graphId), Integer.valueOf(fightType));
/*     */   }
/*     */   
/*     */   public static Integer getGraphFightType(int graphId)
/*     */   {
/*  64 */     return (Integer)graphId2fightType.get(Integer.valueOf(graphId));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Graph createGraph(SGraph sGraph)
/*     */   {
/*  86 */     Graph graph = null;
/*  87 */     graph = new Graph(sGraph.id);
/*  88 */     if (sGraph.isRingTypeGraph)
/*     */     {
/*  90 */       int taskSetId = ((STaskToProperty)((SNode)sGraph.nodes.get(0)).taskIdToProperty.get(0)).taskId;
/*  91 */       TaskSet taskSet = TaskSetManager.getTaskSetById(taskSetId);
/*  92 */       if (taskSet.getStaskSet().giveTaskNpc > 0)
/*     */       {
/*  94 */         int giveTaskNpc = taskSet.getStaskSet().giveTaskNpc;
/*  95 */         if (this.npcIdToGraphIds.containsKey(Integer.valueOf(giveTaskNpc)))
/*     */         {
/*  97 */           ((Set)this.npcIdToGraphIds.get(Integer.valueOf(giveTaskNpc))).add(Integer.valueOf(sGraph.id));
/*     */         }
/*     */         else
/*     */         {
/* 101 */           HashSet<Integer> set = new HashSet();
/* 102 */           set.add(Integer.valueOf(sGraph.id));
/* 103 */           this.npcIdToGraphIds.put(Integer.valueOf(giveTaskNpc), set);
/*     */         }
/*     */       }
/*     */     }
/* 107 */     return graph;
/*     */   }
/*     */   
/*     */   void init() throws Exception
/*     */   {
/* 112 */     for (SGraph sgraph : SGraph.getAll().values())
/*     */     {
/* 114 */       Graph graph = createGraph(sgraph);
/* 115 */       if (graph == null)
/*     */       {
/* 117 */         throw new Exception("生成图对象出错!id:" + sgraph.id);
/*     */       }
/* 119 */       if (sgraph.taskActiveType == 1)
/*     */       {
/* 121 */         this.conditionGraphMap.put(Integer.valueOf(sgraph.id), graph);
/*     */       }
/* 123 */       else if (sgraph.taskActiveType == 2)
/*     */       {
/* 125 */         this.graphIdGraphMap.put(Integer.valueOf(sgraph.activeGraphId), graph);
/*     */       }
/* 127 */       else if (sgraph.taskActiveType != 0)
/*     */       {
/* 129 */         throw new RuntimeException("不存在的激活类型" + sgraph.taskActiveType);
/*     */       }
/* 131 */       for (SNode snode : sgraph.nodes)
/*     */       {
/* 133 */         int nodeTaskType = ((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.taskSetType;
/*     */         
/* 135 */         for (STaskToProperty sTaskToProperty : snode.taskIdToProperty)
/*     */         {
/* 137 */           int taskId = sTaskToProperty.taskId;
/* 138 */           if (nodeTaskType == 1)
/*     */           {
/* 140 */             if (!TaskManager.isHasTask(taskId))
/*     */             {
/* 142 */               throw new Exception("图中的任务不存在graphId:" + sgraph.id + " taskId:" + taskId);
/*     */             }
/*     */           }
/* 145 */           else if (nodeTaskType == 2)
/*     */           {
/* 147 */             if (!TaskSetManager.isHasTaskSet(taskId))
/*     */             {
/* 149 */               throw new Exception("图中的任务库不存在!graphId:" + sgraph.id + " taskSetId:" + taskId);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 154 */         if (!graph.addSNode(snode))
/*     */         {
/* 156 */           throw new Exception("有相同nodeId的图,graphId:" + sgraph.id);
/*     */         }
/*     */       }
/*     */       
/* 160 */       this.graphsMap.put(Integer.valueOf(sgraph.id), graph);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 167 */     for (Map.Entry<Integer, Set<Integer>> entry : this.npcIdToGraphIds.entrySet())
/*     */     {
/* 169 */       if (SNpc.get(((Integer)entry.getKey()).intValue()) == null)
/*     */       {
/* 171 */         String graphidString = "";
/* 172 */         for (Iterator i$ = ((Set)entry.getValue()).iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */           
/* 174 */           graphidString = graphidString + graphId + " ";
/*     */         }
/* 176 */         throw new RuntimeException("任务图下任务库配置的npc不存在 图id集合:" + graphidString + " npcId:" + entry.getKey());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> getAllGraphIds(int npcId)
/*     */   {
/* 189 */     if (this.npcIdToGraphIds.containsKey(Integer.valueOf(npcId)))
/*     */     {
/* 191 */       return (Set)this.npcIdToGraphIds.get(Integer.valueOf(npcId));
/*     */     }
/*     */     
/*     */ 
/* 195 */     return new HashSet();
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
/*     */   int getGraphTaskSum(int graphId)
/*     */   {
/* 209 */     Graph graph = getGraphById(graphId);
/* 210 */     if (graph == null)
/*     */     {
/* 212 */       return 0;
/*     */     }
/* 214 */     return graph.getAllTaskNum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Graph getGraphByGraphId(int graphid)
/*     */   {
/* 225 */     return (Graph)this.graphIdGraphMap.get(Integer.valueOf(graphid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Graph> getAllGraphActiveGraphs()
/*     */   {
/* 235 */     return this.graphIdGraphMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<Graph> getAllCondtionGraph()
/*     */   {
/* 245 */     return this.conditionGraphMap.values();
/*     */   }
/*     */   
/*     */   public Collection<Integer> getAllCondtionGraphIds()
/*     */   {
/* 250 */     return this.conditionGraphMap.keySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<Graph> getAllGraph()
/*     */   {
/* 260 */     return this.graphsMap.values();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getGraphTaskTypeById(int graphId)
/*     */   {
/* 271 */     Graph graph = getGraphById(graphId);
/* 272 */     if (graph == null)
/*     */     {
/* 274 */       return -1;
/*     */     }
/* 276 */     return graph.getGraphType();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\GraphManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
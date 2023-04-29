/*     */ package mzm.gsp.qingyunzhi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QingManager
/*     */ {
/*  20 */   private static final Logger logger = Logger.getLogger(QingManager.class);
/*     */   
/*     */ 
/*  23 */   static Map<Integer, Map<Integer, mzm.gsp.qingyunzhi.confbean.SQingYunZhi>> graphId2QingConf = new HashMap();
/*     */   
/*  25 */   static Map<Integer, Integer> graphId2ChapterNum = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  31 */     for (mzm.gsp.qingyunzhi.confbean.SQingYunZhi sQingYunZhi : mzm.gsp.qingyunzhi.confbean.SQingYunZhi.getAll().values()) {
/*  32 */       if (graphId2QingConf.containsKey(Integer.valueOf(sQingYunZhi.graphId)))
/*     */       {
/*  34 */         if (((Map)graphId2QingConf.get(Integer.valueOf(sQingYunZhi.graphId))).containsKey(Integer.valueOf(sQingYunZhi.nodeNum))) {
/*  35 */           throw new RuntimeException("青云志配置中图ID[" + sQingYunZhi.graphId + "]对应多个章节");
/*     */         }
/*  37 */         ((Map)graphId2QingConf.get(Integer.valueOf(sQingYunZhi.graphId))).put(Integer.valueOf(sQingYunZhi.nodeNum), sQingYunZhi);
/*     */       }
/*     */       else {
/*  40 */         Map<Integer, mzm.gsp.qingyunzhi.confbean.SQingYunZhi> nodeNum2QingConf = new HashMap();
/*  41 */         nodeNum2QingConf.put(Integer.valueOf(sQingYunZhi.nodeNum), sQingYunZhi);
/*  42 */         graphId2QingConf.put(Integer.valueOf(sQingYunZhi.graphId), nodeNum2QingConf);
/*  43 */         graphId2ChapterNum.put(Integer.valueOf(sQingYunZhi.graphId), Integer.valueOf(sQingYunZhi.chapterNum));
/*     */       }
/*     */     }
/*  46 */     mzm.gsp.qingyunzhi.confbean.SQingYunZhi.getAll().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void check()
/*     */   {
/*  54 */     for (mzm.gsp.qingyunzhi.confbean.SQingYunZhi sQingYunZhi : mzm.gsp.qingyunzhi.confbean.SQingYunZhi.getAll().values()) {
/*  55 */       if (!TaskInterface.hasGraphId(sQingYunZhi.graphId)) {
/*  56 */         throw new RuntimeException("青云志配置中图ID[" + sQingYunZhi.graphId + "]不存在");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void showCfg()
/*     */   {
/*  66 */     for (Map<Integer, mzm.gsp.qingyunzhi.confbean.SQingYunZhi> mp : graphId2QingConf.values()) {
/*  67 */       for (mzm.gsp.qingyunzhi.confbean.SQingYunZhi sQingYunZhi : mp.values()) {
/*  68 */         if (GameServer.logger().isDebugEnabled()) {
/*  69 */           GameServer.logger().debug("图id[" + sQingYunZhi.graphId + "]章节[" + sQingYunZhi.chapterNum + "]节点号[" + sQingYunZhi.nodeNum + "]节点名称[" + sQingYunZhi.nodeName + "]任务号[" + sQingYunZhi.taskNumInGraph);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static String getNodeName(long roleId, int graphId) {
/*  76 */     int chapterNum = getChapterNumByGraphId(graphId);
/*  77 */     if (chapterNum <= 0) {
/*  78 */       return "";
/*     */     }
/*  80 */     int taskNum = getGraphTaskNum(roleId, graphId);
/*  81 */     if (taskNum < 0) {
/*  82 */       return "";
/*     */     }
/*  84 */     int nodeId = getNodeNumByTaskNum(graphId, taskNum);
/*  85 */     if (nodeId < 0) {
/*  86 */       return "";
/*     */     }
/*  88 */     String nodeName = ((mzm.gsp.qingyunzhi.confbean.SQingYunZhi)((Map)graphId2QingConf.get(Integer.valueOf(graphId))).get(Integer.valueOf(nodeId))).nodeName;
/*  89 */     return nodeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getChapterNumByGraphId(int graphId)
/*     */   {
/*  98 */     if (graphId2QingConf.get(Integer.valueOf(graphId)) == null) {
/*  99 */       return -1;
/*     */     }
/* 101 */     return ((mzm.gsp.qingyunzhi.confbean.SQingYunZhi)((Map)graphId2QingConf.get(Integer.valueOf(graphId))).get(Integer.valueOf(1))).chapterNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isQingGraph(int graphId)
/*     */   {
/* 110 */     return getChapterNumByGraphId(graphId) > 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getGraphTaskNum(long roleId, int graphId)
/*     */   {
/* 120 */     return TaskInterface.getTaskNumInGraph(roleId, graphId, -1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNodeNumByTaskNum(int graphId, int taskNum)
/*     */   {
/* 130 */     int nodeNum = 1;
/* 131 */     while (((Map)graphId2QingConf.get(Integer.valueOf(graphId))).get(Integer.valueOf(nodeNum)) != null) {
/* 132 */       mzm.gsp.qingyunzhi.confbean.SQingYunZhi sQingYunZhi = (mzm.gsp.qingyunzhi.confbean.SQingYunZhi)((Map)graphId2QingConf.get(Integer.valueOf(graphId))).get(Integer.valueOf(nodeNum));
/* 133 */       if (sQingYunZhi.taskNumInGraph >= taskNum) {
/*     */         break;
/*     */       }
/* 136 */       nodeNum++;
/*     */     }
/* 138 */     if (((Map)graphId2QingConf.get(Integer.valueOf(graphId))).get(Integer.valueOf(nodeNum)) == null) {
/* 139 */       return -1;
/*     */     }
/* 141 */     return nodeNum;
/*     */   }
/*     */   
/*     */   static boolean isNeedSendSchedule(int graphId, int taskNum) {
/* 145 */     if (taskNum == 1) {
/* 146 */       return true;
/*     */     }
/* 148 */     int nodeNum = 1;
/* 149 */     while (((Map)graphId2QingConf.get(Integer.valueOf(graphId))).get(Integer.valueOf(nodeNum)) != null) {
/* 150 */       mzm.gsp.qingyunzhi.confbean.SQingYunZhi sQingYunZhi = (mzm.gsp.qingyunzhi.confbean.SQingYunZhi)((Map)graphId2QingConf.get(Integer.valueOf(graphId))).get(Integer.valueOf(nodeNum));
/* 151 */       if (sQingYunZhi.taskNumInGraph < taskNum) {
/* 152 */         int taskNumInGraph = sQingYunZhi.taskNumInGraph;
/* 153 */         taskNumInGraph++; if (taskNumInGraph == taskNum) {
/* 154 */           return true;
/*     */         }
/*     */       }
/* 157 */       nodeNum++;
/*     */     }
/* 159 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean onAcceptNewTask(long roleId, int graphId)
/*     */   {
/* 169 */     int chapterNum = getChapterNumByGraphId(graphId);
/* 170 */     if (chapterNum <= 0) {
/* 171 */       return false;
/*     */     }
/* 173 */     int taskNum = getGraphTaskNum(roleId, graphId);
/* 174 */     if (!isNeedSendSchedule(graphId, taskNum)) {
/* 175 */       return false;
/*     */     }
/* 177 */     int nodeId = getNodeNumByTaskNum(graphId, taskNum);
/* 178 */     if (nodeId < 0) {
/* 179 */       return false;
/*     */     }
/*     */     
/* 182 */     return sendSchedule(Long.valueOf(roleId), chapterNum, nodeId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean onRoleLogin(long roleId)
/*     */   {
/* 191 */     List<Integer> graphIds = TaskInterface.getRoleAllGraphIds(roleId, true);
/* 192 */     if (graphIds.size() <= 0) {
/* 193 */       return false;
/*     */     }
/* 195 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/* 196 */       int chapterNum = getChapterNumByGraphId(graphId);
/* 197 */       if (chapterNum > 0)
/*     */       {
/*     */ 
/* 200 */         int taskNum = getGraphTaskNum(roleId, graphId);
/* 201 */         int nodeNum = getNodeNumByTaskNum(graphId, taskNum);
/* 202 */         sendSchedule(Long.valueOf(roleId), chapterNum, nodeNum);
/*     */       } }
/* 204 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean sendSchedule(Long roleId, int chapterNum, int nodeNum)
/*     */   {
/* 215 */     mzm.gsp.qingyunzhi.SQingYunZhi sQingYunZhi = new mzm.gsp.qingyunzhi.SQingYunZhi();
/* 216 */     sQingYunZhi.chapternum = chapterNum;
/* 217 */     sQingYunZhi.nodenum = nodeNum;
/* 218 */     OnlineManager.getInstance().send(roleId.longValue(), sQingYunZhi);
/*     */     
/* 220 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isQingOpen(long roleId)
/*     */   {
/* 228 */     if (!OpenInterface.getOpenStatus(17)) {
/* 229 */       return false;
/*     */     }
/* 231 */     if (OpenInterface.isBanPlay(roleId, 17)) {
/* 232 */       OpenInterface.sendBanPlayMsg(roleId, 17);
/* 233 */       return false;
/*     */     }
/* 235 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Long> qingBanRoleIds(List<Long> roleIds)
/*     */   {
/* 245 */     List<Long> banRoleIds = new ArrayList();
/* 246 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 248 */       if (!OpenInterface.getOpenStatus(17)) {
/* 249 */         banRoleIds.add(Long.valueOf(roleId));
/*     */       }
/*     */     }
/* 252 */     return banRoleIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\QingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
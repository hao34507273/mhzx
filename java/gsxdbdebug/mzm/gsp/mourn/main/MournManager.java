/*     */ package mzm.gsp.mourn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity2.confbean.MournConsts;
/*     */ import mzm.gsp.activity2.confbean.SMournCfg;
/*     */ import mzm.gsp.activity2.confbean.STMournCfg;
/*     */ import mzm.gsp.mourn.MTaskInfo;
/*     */ import mzm.gsp.mourn.SMournNormalResult;
/*     */ import mzm.gsp.mourn.SSynMournInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.XMTaskInfo;
/*     */ import xbean.XMournInfo;
/*     */ import xtable.Role2mourn;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MournManager
/*     */ {
/*     */   static List<Integer> getNewMournIds(Set<Integer> ownIds)
/*     */   {
/*  41 */     List<Integer> newMournIds = new ArrayList();
/*  42 */     List<Integer> tmpIds = new ArrayList(SMournCfg.getAll().keySet());
/*  43 */     tmpIds.removeAll(ownIds);
/*  44 */     int needNum = MournConsts.getInstance().countMax - ownIds.size();
/*  45 */     if (needNum <= 0)
/*     */     {
/*  47 */       return Collections.emptyList();
/*     */     }
/*  49 */     CommonUtils.regionRandom(tmpIds, needNum, newMournIds);
/*  50 */     return newMournIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Collection<Integer> getAllRanMGraphIds()
/*     */   {
/*  60 */     return STMournCfg.getAll().keySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getOwnGraphIds(Set<Integer> mournIds)
/*     */   {
/*  71 */     Set<Integer> graphIds = new HashSet();
/*  72 */     if ((mournIds == null) || (mournIds.size() == 0))
/*     */     {
/*  74 */       return graphIds;
/*     */     }
/*  76 */     for (Iterator i$ = mournIds.iterator(); i$.hasNext();) { int mournId = ((Integer)i$.next()).intValue();
/*     */       
/*  78 */       SMournCfg cfg = SMournCfg.get(mournId);
/*  79 */       if (cfg != null)
/*     */       {
/*     */ 
/*     */ 
/*  83 */         graphIds.add(Integer.valueOf(cfg.graphId)); }
/*     */     }
/*  85 */     return graphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> isHaveMGraph(long roleId)
/*     */   {
/*  97 */     Set<Integer> containedGraphIds = new HashSet();
/*  98 */     List<Integer> graphIds = TaskInterface.getRoleAllGraphIds(roleId, false);
/*  99 */     for (Iterator i$ = getAllRanMGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 101 */       if (graphIds.contains(Integer.valueOf(graphId)))
/*     */       {
/* 103 */         containedGraphIds.add(Integer.valueOf(graphId));
/*     */       }
/*     */     }
/* 106 */     return containedGraphIds;
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
/*     */   static boolean hasMoreThanXMGraph(long roleId, int count)
/*     */   {
/* 122 */     List<Integer> graphIds = TaskInterface.getRoleAllGraphIds(roleId, false);
/* 123 */     int num = 0;
/* 124 */     for (Iterator i$ = getAllRanMGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 126 */       if (graphIds.contains(Integer.valueOf(graphId)))
/*     */       {
/* 128 */         num++;
/*     */       }
/*     */     }
/* 131 */     return num > count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMGraph(int graphId)
/*     */   {
/* 143 */     return getAllRanMGraphIds().contains(Integer.valueOf(graphId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SMournCfg getSMournCfg(int graphId)
/*     */   {
/* 154 */     STMournCfg cfg = STMournCfg.get(graphId);
/* 155 */     if (cfg == null)
/*     */     {
/* 157 */       return null;
/*     */     }
/* 159 */     return SMournCfg.get(cfg.mournId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getAllMournGraphIds()
/*     */   {
/* 169 */     Set<Integer> graphIds = new HashSet();
/* 170 */     graphIds.addAll(getAllRanMGraphIds());
/* 171 */     graphIds.add(Integer.valueOf(MournConsts.getInstance().questionGraphId));
/* 172 */     return graphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synRoleMournInfo(long roleId, XMournInfo xMournInfo)
/*     */   {
/* 183 */     if (xMournInfo == null)
/*     */     {
/* 185 */       return;
/*     */     }
/* 187 */     SSynMournInfo pro = new SSynMournInfo();
/* 188 */     for (Map.Entry<Integer, XMTaskInfo> entry : xMournInfo.getMourndatas().entrySet())
/*     */     {
/* 190 */       int mournId = ((Integer)entry.getKey()).intValue();
/* 191 */       int state = ((XMTaskInfo)entry.getValue()).getState();
/*     */       
/* 193 */       pro.mourninfos.put(Integer.valueOf(mournId), new MTaskInfo(state));
/*     */     }
/* 195 */     pro.questiontaskstate = xMournInfo.getLastmourndata().getState();
/* 196 */     pro.sort.addAll(xMournInfo.getSort());
/* 197 */     OnlineManager.getInstance().send(roleId, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMournOpen()
/*     */   {
/* 207 */     return OpenInterface.getOpenStatus(276);
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
/*     */   static void checkAndSynMournInfo(String userId, long roleId)
/*     */   {
/* 221 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, MournConsts.getInstance().activityId);
/*     */     
/* 223 */     if (!res.isCanJoin())
/*     */     {
/* 225 */       GameServer.logger().error(String.format("[mourn]PCGetMournReq.checkAndSynMournInfo@ activity is forbid!|roleId=%d|reason=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/* 228 */       return;
/*     */     }
/* 230 */     synRoleMournInfo(roleId, Role2mourn.get(Long.valueOf(roleId)));
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
/*     */   static void sendMournNotice(Collection<Long> roleIds, boolean afterSuc, int result, String... args)
/*     */   {
/* 243 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 245 */       return;
/*     */     }
/* 247 */     SMournNormalResult pro = new SMournNormalResult();
/* 248 */     pro.result = result;
/* 249 */     for (String arg : args)
/*     */     {
/* 251 */       pro.args.add(arg);
/*     */     }
/* 253 */     if (afterSuc)
/*     */     {
/* 255 */       OnlineManager.getInstance().sendMulti(pro, roleIds);
/*     */     }
/*     */     else
/*     */     {
/* 259 */       OnlineManager.getInstance().sendMultiAtOnce(pro, roleIds);
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean canDoLastTask(long roleId, XMournInfo xMournInfo)
/*     */   {
/* 265 */     if (!allMournTaskFinished(roleId, xMournInfo))
/*     */     {
/* 267 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.canDoLastTask@ not all mourn task finished!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 269 */       return false;
/*     */     }
/* 271 */     if (xMournInfo.getLastmourndata().getState() != 1)
/*     */     {
/* 273 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.canDoLastTask@ last mourn state err!|roleId=%d|state=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xMournInfo.getLastmourndata().getState()) }));
/*     */       
/*     */ 
/* 276 */       return false;
/*     */     }
/* 278 */     return true;
/*     */   }
/*     */   
/*     */   static boolean canGetLastTaskAward(long roleId, XMournInfo xMournInfo)
/*     */   {
/* 283 */     if (!allMournTaskFinished(roleId, xMournInfo))
/*     */     {
/* 285 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.canGetLastTaskAward@ not all mourn task finished!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 287 */       return false;
/*     */     }
/* 289 */     if (xMournInfo.getLastmourndata().getState() != 2)
/*     */     {
/* 291 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.canGetLastTaskAward@ last mourn state is not ALREADY_ACCEPTED!|roleId=%d|state=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xMournInfo.getLastmourndata().getState()) }));
/*     */       
/*     */ 
/*     */ 
/* 295 */       return false;
/*     */     }
/* 297 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean allMournTaskFinished(long roleId, XMournInfo xMournInfo)
/*     */   {
/* 302 */     int finishCount = 0;
/* 303 */     for (Map.Entry<Integer, XMTaskInfo> entry : xMournInfo.getMourndatas().entrySet())
/*     */     {
/* 305 */       int singleId = ((Integer)entry.getKey()).intValue();
/* 306 */       int state = ((XMTaskInfo)entry.getValue()).getState();
/* 307 */       if (state == 3)
/*     */       {
/* 309 */         finishCount++;
/*     */       }
/*     */       else {
/* 312 */         GameServer.logger().error(String.format("[mourn]PCLastMournReq.allMournTaskFinished@ not all mournId finished!|roleId=%d|mournId=%d|state=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(singleId), Integer.valueOf(state) }));
/*     */         
/*     */ 
/*     */ 
/* 316 */         return false;
/*     */       } }
/* 318 */     if (finishCount != MournConsts.getInstance().countMax)
/*     */     {
/* 320 */       GameServer.logger().error(String.format("[mourn]PCLastMournReq.allMournTaskFinished@ not all mournId finished!|roleId=%d|allMournData=%s|finishCount=%d", new Object[] { Long.valueOf(roleId), xMournInfo.getMourndatas().toString(), Integer.valueOf(finishCount) }));
/*     */       
/*     */ 
/*     */ 
/* 324 */       return false;
/*     */     }
/* 326 */     return true;
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
/*     */   static void tlogMourn(String userId, long roleId, int mournId, long state)
/*     */   {
/* 339 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 340 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 342 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(mournId), Long.valueOf(state) };
/*     */     
/* 344 */     TLogManager.getInstance().addLog(roleId, "Mourn", colums);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\MournManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
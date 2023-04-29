/*     */ package mzm.gsp.homeland.mysteryvisitor;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*     */ import mzm.gsp.homeland.confbean.MysteryVisitorNPCPositionCfg;
/*     */ import mzm.gsp.homeland.confbean.NPCPosition;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorProbabilityCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MysteryVisitorManager
/*     */ {
/*  32 */   static final Logger logger = Logger.getLogger("mysteryvisitor");
/*     */   static final int WAN = 10000;
/*  34 */   static volatile boolean postInitFlag = false;
/*     */   
/*     */   static void init()
/*     */   {
/*  38 */     ActivityInterface.registerActivityByLogicType(94, new MysteryVisitorActivityHandler());
/*  39 */     MysteryVisitorTaskNpcLibIdHandler handler = new MysteryVisitorTaskNpcLibIdHandler();
/*  40 */     for (SMysteryVisitorNPCIdCfg cfg : SMysteryVisitorNPCIdCfg.getAll().values())
/*     */     {
/*  42 */       TaskInterface.registerTaskNpcLibHandler(cfg.npc_lib_id, handler);
/*     */     }
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  48 */     postInitFlag = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMysteryVisitorSwitchOpen()
/*     */   {
/*  58 */     if (!OpenInterface.getOpenStatus(336))
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMysteryVisitorSwitchOpenForRole(long roleid)
/*     */   {
/*  73 */     if (!OpenInterface.getOpenStatus(336))
/*     */     {
/*  75 */       return false;
/*     */     }
/*  77 */     if (OpenInterface.isBanPlay(roleid, 336))
/*     */     {
/*  79 */       OpenInterface.sendBanPlayMsg(roleid, 336);
/*  80 */       return false;
/*     */     }
/*  82 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMysteryVisitorCfgid(int courdyardAestheticsDegree)
/*     */   {
/*  94 */     return ((Integer)((SMysteryVisitorProbabilityCfg)((TreeMap)SMysteryVisitorProbabilityCfg.getAll()).floorEntry(Integer.valueOf(courdyardAestheticsDegree)).getValue()).probability_infos.ceilingEntry(Integer.valueOf(1 + Xdb.random().nextInt(10000))).getValue()).intValue();
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
/*     */   static void addMysteryVisitorIntoCourtyard(long roleid, long worldid, int mapCfgid)
/*     */   {
/* 111 */     if (!isMysteryVisitorSwitchOpenForRole(roleid))
/*     */     {
/*     */ 
/* 114 */       onAddMysteryVisitorIntoCourtyardFail(roleid, worldid, mapCfgid, -1, null);
/*     */       
/* 116 */       return;
/*     */     }
/*     */     
/* 119 */     String userid = RoleInterface.getUserId(roleid);
/* 120 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/* 122 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 125 */       Map<String, Object> extraInfo = new HashMap();
/* 126 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 127 */       onAddMysteryVisitorIntoCourtyardFail(roleid, worldid, mapCfgid, 1, extraInfo);
/*     */       
/* 129 */       return;
/*     */     }
/*     */     
/* 132 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(roleid));
/* 133 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/* 136 */       return;
/*     */     }
/* 138 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() <= 0)
/*     */     {
/*     */ 
/* 141 */       onAddMysteryVisitorIntoCourtyardFail(roleid, worldid, mapCfgid, 3, null);
/*     */       
/* 143 */       return;
/*     */     }
/* 145 */     SMysteryVisitorCfg cfg = SMysteryVisitorCfg.get(xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id());
/* 146 */     if (cfg == null)
/*     */     {
/*     */ 
/* 149 */       onAddMysteryVisitorIntoCourtyardFail(roleid, worldid, mapCfgid, -4, null);
/* 150 */       return;
/*     */     }
/* 152 */     switch (cfg.type)
/*     */     {
/*     */ 
/*     */ 
/*     */     case 1: 
/* 157 */       onAddMysteryVisitorIntoCourtyardFail(roleid, worldid, mapCfgid, 9, null);
/*     */       
/* 159 */       return;
/*     */     
/*     */ 
/*     */     case 2: 
/*     */     case 3: 
/* 164 */       MysteryVisitorNPCPositionCfg npcPositionCfg = MysteryVisitorNPCPositionCfg.get(cfg.id);
/* 165 */       if (npcPositionCfg == null)
/*     */       {
/*     */ 
/* 168 */         return;
/*     */       }
/* 170 */       MapInterface.addMapEntity(MapEntityType.MET_MYSTERY_VISITOR, roleid, worldid, mapCfgid, ((NPCPosition)npcPositionCfg.npc_positions.get(Integer.valueOf(mapCfgid))).x, ((NPCPosition)npcPositionCfg.npc_positions.get(Integer.valueOf(mapCfgid))).y, cfg.id, null, null, null, null);
/*     */       
/*     */ 
/* 173 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     default: 
/* 178 */       onAddMysteryVisitorIntoCourtyardFail(roleid, worldid, mapCfgid, -4, null);
/* 179 */       return;
/*     */     }
/*     */     
/*     */     
/* 183 */     StringBuilder sb = new StringBuilder();
/* 184 */     sb.append(String.format("[mysteryvisitor]MysteryVisitorManager.addMysteryVisitorIntoCourtyard@add mystery visitor into courtyard success|roleid=%d|worldid=%d|map_cfg_id=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(cfg.id) }));
/*     */     
/*     */ 
/* 187 */     logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private static void onAddMysteryVisitorIntoCourtyardFail(long roleid, long worldid, int mapCfgid, int res, Map<String, Object> extraInfo)
/*     */   {
/* 193 */     StringBuilder sb = new StringBuilder();
/* 194 */     sb.append(String.format("[mysteryvisitor]MysteryVisitorManager.addMysteryVisitorIntoCourtyard@add mystery visitor into courtyard fail|roleid=%d|worldid=%d|map_cfg_id=%d|res=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 197 */     if (extraInfo != null)
/*     */     {
/* 199 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 201 */         sb.append("|").append((String)entry.getKey());
/* 202 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 205 */     logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeMysteryVisitorByRoleid(long roleid)
/*     */   {
/* 216 */     MapInterface.removeMapEntity(MapEntityType.MET_MYSTERY_VISITOR, roleid, null);
/*     */     
/* 218 */     StringBuilder sb = new StringBuilder();
/* 219 */     sb.append(String.format("[mysteryvisitor]MysteryVisitorManager.removeMysteryVisitorByRoleid@remove mystery visitor success|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */     
/*     */ 
/* 222 */     logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\MysteryVisitorManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
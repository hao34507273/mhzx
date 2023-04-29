/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.planttree.SSynPlantTreeBasicInfo;
/*     */ import mzm.gsp.planttree.SSynPlantTreeDetailInfo;
/*     */ import mzm.gsp.planttree.SSynPlantTreeUpdateInfo;
/*     */ import mzm.gsp.planttree.SSynRolePlantTreeInfo;
/*     */ import mzm.gsp.planttree.confbean.PlantTreeConsts;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.planttree.confbean.SSectionInfo;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlantTreeManager
/*     */ {
/*  28 */   static volatile boolean postInitFlag = false;
/*  29 */   static Logger logger = Logger.getLogger("planttree");
/*     */   
/*     */   static void init()
/*     */   {
/*  33 */     ActivityInterface.registerActivityByLogicType(75, new PlantTreeActivityHandler());
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  38 */     postInitFlag = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPlantTreeSwitchOpen(int activityCfgid)
/*     */   {
/*  49 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(activityCfgid);
/*  50 */     if (cfg == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPlantTreeSwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/*  70 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(activityCfgid);
/*  71 */     if (cfg == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/*  81 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  82 */       return false;
/*     */     }
/*  84 */     return true;
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
/*     */   static xbean.PlantTreeLog createXPlantTreeLog(int logType, List<String> extraDatas)
/*     */   {
/*  98 */     xbean.PlantTreeLog xPlantTreeLog = Pod.newPlantTreeLog();
/*  99 */     xPlantTreeLog.setLog_type(logType);
/* 100 */     xPlantTreeLog.setTimestamp((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/* 101 */     xPlantTreeLog.getExtradatas().addAll(extraDatas);
/* 102 */     return xPlantTreeLog;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPlantTreeLog(PlantTreeInfo xPlantTreeInfo, List<xbean.PlantTreeLog> xPlantTreeLogs)
/*     */   {
/* 113 */     for (xbean.PlantTreeLog xPlantTreeLog : xPlantTreeLogs)
/*     */     {
/* 115 */       if (xPlantTreeInfo.getLogs().size() < PlantTreeConsts.getInstance().MAX_LOG_NUM)
/*     */       {
/* 117 */         xPlantTreeInfo.getLogs().add(xPlantTreeLog);
/*     */       }
/*     */       else
/*     */       {
/* 121 */         xPlantTreeInfo.getLogs().remove(0);
/* 122 */         xPlantTreeInfo.getLogs().add(xPlantTreeLog);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static SSynPlantTreeBasicInfo fillPlantTreeBasicInfo(long roleid, int activityCfgid, PlantTreeInfo xPlantTreeInfo)
/*     */   {
/* 138 */     SSynPlantTreeBasicInfo protocol = new SSynPlantTreeBasicInfo();
/* 139 */     protocol.owner_id = roleid;
/* 140 */     protocol.activity_cfg_id = activityCfgid;
/* 141 */     protocol.current_section_id = xPlantTreeInfo.getCurrent_section_id();
/* 142 */     protocol.current_section_point = ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue();
/* 143 */     protocol.special_state_index = xPlantTreeInfo.getSpecial_state_index();
/* 144 */     return protocol;
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
/*     */   static SSynPlantTreeDetailInfo fillPlantTreeDetailInfo(long roleid, int activityCfgid, PlantTreeInfo xPlantTreeInfo)
/*     */   {
/* 158 */     SSynPlantTreeDetailInfo protocol = new SSynPlantTreeDetailInfo();
/* 159 */     protocol.owner_id = roleid;
/* 160 */     protocol.activity_cfg_id = activityCfgid;
/* 161 */     protocol.current_section_id = xPlantTreeInfo.getCurrent_section_id();
/* 162 */     protocol.current_section_point = ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue();
/* 163 */     protocol.special_state_index = xPlantTreeInfo.getSpecial_state_index();
/* 164 */     protocol.logs.addAll(batchConvertXPlantTreeLog2PlantTreeLog(xPlantTreeInfo.getLogs()));
/* 165 */     return protocol;
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
/*     */   static SSynPlantTreeUpdateInfo fillPlantTreeUpdateInfo(long roleid, int activityCfgid, PlantTreeInfo xPlantTreeInfo, List<xbean.PlantTreeLog> xPlantTreeLogs)
/*     */   {
/* 180 */     SSynPlantTreeUpdateInfo protocol = new SSynPlantTreeUpdateInfo();
/* 181 */     protocol.owner_id = roleid;
/* 182 */     protocol.activity_cfg_id = activityCfgid;
/* 183 */     protocol.current_section_id = xPlantTreeInfo.getCurrent_section_id();
/* 184 */     protocol.current_section_point = ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue();
/* 185 */     protocol.special_state_index = xPlantTreeInfo.getSpecial_state_index();
/* 186 */     protocol.logs.addAll(batchConvertXPlantTreeLog2PlantTreeLog(xPlantTreeLogs));
/* 187 */     return protocol;
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
/*     */   static SSynRolePlantTreeInfo fillRolePlantTreeInfo(long roleid, int activityCfgid, PlantTreeInfo xPlantTreeInfo)
/*     */   {
/* 201 */     SSynRolePlantTreeInfo protocol = new SSynRolePlantTreeInfo();
/* 202 */     protocol.activity_cfg_id = activityCfgid;
/* 203 */     protocol.award_section_ids.addAll(xPlantTreeInfo.getAward_section_ids());
/* 204 */     protocol.has_get_activity_complete_award = (xPlantTreeInfo.getHas_get_activity_complete_award() ? 1 : 0);
/* 205 */     protocol.add_point_times = xPlantTreeInfo.getAdd_point_times();
/* 206 */     protocol.remove_special_state_award_times = xPlantTreeInfo.getRemove_special_state_award_times();
/* 207 */     return protocol;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static mzm.gsp.planttree.PlantTreeLog convertXPlantTreeLog2PlantTreeLog(xbean.PlantTreeLog xPlantTreeLog)
/*     */   {
/* 218 */     mzm.gsp.planttree.PlantTreeLog plantTreeLog = new mzm.gsp.planttree.PlantTreeLog();
/* 219 */     plantTreeLog.log_type = xPlantTreeLog.getLog_type();
/* 220 */     plantTreeLog.timestamp = xPlantTreeLog.getTimestamp();
/* 221 */     plantTreeLog.extradatas.addAll(xPlantTreeLog.getExtradatas());
/* 222 */     return plantTreeLog;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<mzm.gsp.planttree.PlantTreeLog> batchConvertXPlantTreeLog2PlantTreeLog(List<xbean.PlantTreeLog> xPlantTreeLogs)
/*     */   {
/* 233 */     List<mzm.gsp.planttree.PlantTreeLog> plantTreeLogs = new ArrayList();
/* 234 */     for (xbean.PlantTreeLog xPlantTreeLog : xPlantTreeLogs)
/*     */     {
/* 236 */       plantTreeLogs.add(convertXPlantTreeLog2PlantTreeLog(xPlantTreeLog));
/*     */     }
/* 238 */     return plantTreeLogs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getActivityNeedPoint(int activityCfgid, PlantTreeInfo xPlantTreeInfo)
/*     */   {
/* 250 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(activityCfgid);
/* 251 */     int needPoint = ((SSectionInfo)cfg.section_infos.get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).section_total_point - ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue();
/*     */     
/* 253 */     for (int i = xPlantTreeInfo.getCurrent_section_id() + 1; i <= cfg.section_num; i++)
/*     */     {
/* 255 */       needPoint += ((SSectionInfo)cfg.section_infos.get(Integer.valueOf(i))).section_total_point;
/*     */     }
/* 257 */     return needPoint;
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
/*     */   static void addActivityPoint(int activityCfgid, PlantTreeInfo xPlantTreeInfo, int realAddPoint)
/*     */   {
/* 270 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(activityCfgid);
/* 271 */     int needAdddPoint = realAddPoint;
/* 272 */     while (needAdddPoint > 0)
/*     */     {
/* 274 */       int currentSectionid = xPlantTreeInfo.getCurrent_section_id();
/* 275 */       int currentSectionPoint = ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(currentSectionid))).intValue();
/* 276 */       int currentSectionTotalPoint = ((SSectionInfo)cfg.section_infos.get(Integer.valueOf(currentSectionid))).section_total_point;
/* 277 */       int currentSectionNeedPoint = currentSectionTotalPoint - currentSectionPoint;
/* 278 */       if (needAdddPoint < currentSectionNeedPoint)
/*     */       {
/*     */ 
/* 281 */         xPlantTreeInfo.getSections().put(Integer.valueOf(currentSectionid), Integer.valueOf(currentSectionPoint + needAdddPoint));
/* 282 */         needAdddPoint = 0;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 287 */         xPlantTreeInfo.getSections().put(Integer.valueOf(currentSectionid), Integer.valueOf(currentSectionPoint + currentSectionNeedPoint));
/* 288 */         if (currentSectionid < cfg.section_num)
/*     */         {
/*     */ 
/* 291 */           xPlantTreeInfo.getSections().put(Integer.valueOf(currentSectionid + 1), Integer.valueOf(0));
/* 292 */           xPlantTreeInfo.setCurrent_section_id(currentSectionid + 1);
/*     */         }
/* 294 */         needAdddPoint -= currentSectionNeedPoint;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Long> getRelatedRoleids(int activityType, long roleid)
/*     */   {
/* 311 */     Set<Long> roleids = new HashSet();
/* 312 */     switch (activityType)
/*     */     {
/*     */     case 1: 
/* 315 */       roleids.addAll(FriendInterface.getAllFriends(roleid, false));
/* 316 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 321 */     return roleids;
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
/*     */   static boolean checkRelationship(int activityType, long roleid1, long roleid2)
/*     */   {
/* 335 */     if (roleid1 == roleid2)
/*     */     {
/* 337 */       return true;
/*     */     }
/* 339 */     switch (activityType)
/*     */     {
/*     */     case 1: 
/* 342 */       if (FriendInterface.isFriend(roleid1, roleid2, false))
/*     */       {
/* 344 */         return true;
/*     */       }
/* 346 */       return false;
/*     */     }
/* 348 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PlantTreeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
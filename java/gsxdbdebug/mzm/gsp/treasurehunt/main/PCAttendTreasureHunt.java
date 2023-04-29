/*     */ package mzm.gsp.treasurehunt.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.treasurehunt.SAttendTreasureHuntSuccess;
/*     */ import mzm.gsp.treasurehunt.STreasureHuntNormalFail;
/*     */ import mzm.gsp.treasurehunt.confbean.STreasureHuntCfg;
/*     */ import mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2TreasureHuntInfo;
/*     */ import xbean.Role2TreasureHuntWorldInfo;
/*     */ import xbean.RoleTreasureHuntActivityInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2treasurehunt;
/*     */ import xtable.Role2treasurehuntworld;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendTreasureHunt extends mzm.gsp.util.LogicProcedure implements MapCallback<Long>
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private int nowProcess;
/*     */   private STreasureHuntCfg sTreasureHuntCfg;
/*     */   private STreasureHuntChapterCfg sTreasureHuntChapterCfg;
/*     */   private String userId;
/*     */   
/*     */   public PCAttendTreasureHunt(long roleId, int activityCfgId)
/*     */   {
/*  46 */     this.roleId = roleId;
/*  47 */     this.activityCfgId = activityCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     this.sTreasureHuntCfg = STreasureHuntCfg.get(this.activityCfgId);
/*  54 */     if (this.sTreasureHuntCfg == null)
/*     */     {
/*  56 */       onFail(1);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!isTreasureHuntSwitchOpen(this.roleId, this.sTreasureHuntCfg.switch_type))
/*     */     {
/*  62 */       onFail(13);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     this.userId = RoleInterface.getUserId(this.roleId);
/*  67 */     if (this.userId == null)
/*     */     {
/*  69 */       onFail(2);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(this.sTreasureHuntCfg.npc_id, this.sTreasureHuntCfg.npc_service_id, this.roleId))
/*     */     {
/*     */ 
/*  76 */       onFail(15);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     lock(Lockeys.get(User.getTable(), this.userId));
/*     */     
/*  82 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(this.userId, this.roleId, this.activityCfgId);
/*     */     
/*  84 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  86 */       if (activityJoinResult.isActivityJoinCountMax())
/*     */       {
/*  88 */         onFail(14);
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       Map<String, Object> extraMap = new HashMap();
/*  93 */       extraMap.put("ret", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/*  95 */       onFail(3, extraMap);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     Role2TreasureHuntWorldInfo xRole2TreasureHuntWorldInfo = Role2treasurehuntworld.get(Long.valueOf(this.roleId));
/* 100 */     if (xRole2TreasureHuntWorldInfo != null)
/*     */     {
/* 102 */       onFail(4);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     Role2TreasureHuntInfo xRole2TreasureHuntInfo = Role2treasurehunt.get(Long.valueOf(this.roleId));
/* 107 */     if (xRole2TreasureHuntInfo == null)
/*     */     {
/* 109 */       xRole2TreasureHuntInfo = Pod.newRole2TreasureHuntInfo();
/* 110 */       Role2treasurehunt.add(Long.valueOf(this.roleId), xRole2TreasureHuntInfo);
/*     */     }
/*     */     
/* 113 */     RoleTreasureHuntActivityInfo xRole2TreasureHuntActivityInfo = (RoleTreasureHuntActivityInfo)xRole2TreasureHuntInfo.getTreasure_hunt_activity_map().get(Integer.valueOf(this.activityCfgId));
/*     */     
/* 115 */     this.nowProcess = 0;
/* 116 */     if (xRole2TreasureHuntActivityInfo == null)
/*     */     {
/* 118 */       this.nowProcess = 0;
/*     */     }
/*     */     else
/*     */     {
/* 122 */       this.nowProcess = xRole2TreasureHuntActivityInfo.getAwarded_chapter_id_set().size();
/*     */     }
/*     */     
/* 125 */     if (this.nowProcess >= this.sTreasureHuntCfg.chapter_id_list.size())
/*     */     {
/* 127 */       Map<String, Object> extraMap = new HashMap();
/* 128 */       extraMap.put("now_process", Integer.valueOf(this.nowProcess));
/* 129 */       extraMap.put("chapter_id_list_size", Integer.valueOf(this.sTreasureHuntCfg.chapter_id_list.size()));
/*     */       
/* 131 */       onFail(5, extraMap);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     List<Integer> mapCfgIdList = new ArrayList();
/* 136 */     for (int index = this.nowProcess; index < this.sTreasureHuntCfg.chapter_id_list.size(); index++)
/*     */     {
/* 138 */       int chapterId = ((Integer)this.sTreasureHuntCfg.chapter_id_list.get(index)).intValue();
/*     */       
/* 140 */       STreasureHuntChapterCfg sTreasureHuntChapterCfg = STreasureHuntChapterCfg.get(chapterId);
/* 141 */       if (sTreasureHuntChapterCfg == null)
/*     */       {
/* 143 */         onFail(6);
/* 144 */         return false;
/*     */       }
/*     */       
/* 147 */       mapCfgIdList.add(Integer.valueOf(sTreasureHuntChapterCfg.map_cfg_id));
/*     */     }
/*     */     
/* 150 */     int nowChapter = ((Integer)this.sTreasureHuntCfg.chapter_id_list.get(this.nowProcess)).intValue();
/* 151 */     this.sTreasureHuntChapterCfg = STreasureHuntChapterCfg.get(nowChapter);
/* 152 */     if (this.sTreasureHuntChapterCfg == null)
/*     */     {
/* 154 */       Map<String, Object> extraMap = new HashMap();
/* 155 */       extraMap.put("now_chapter", Integer.valueOf(nowChapter));
/*     */       
/* 157 */       onFail(7, extraMap);
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     MapInterface.createWorld(mapCfgIdList, this);
/*     */     
/* 163 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 168 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 173 */     StringBuilder sBuilder = new StringBuilder();
/* 174 */     sBuilder.append("[treasure_hunt]PCAttendTreasureHunt.processImp@attend treasure hunt failed");
/* 175 */     sBuilder.append("|ret=").append(ret);
/* 176 */     sBuilder.append("|role_id=").append(this.roleId);
/* 177 */     sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */     
/* 179 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 181 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 183 */         sBuilder.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 186 */     GameServer.logger().error(sBuilder.toString());
/*     */     
/* 188 */     STreasureHuntNormalFail sTreasureHuntNormalFail = new STreasureHuntNormalFail();
/* 189 */     sTreasureHuntNormalFail.result = ret;
/*     */     
/* 191 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sTreasureHuntNormalFail);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 197 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Long result)
/*     */   {
/* 203 */     if (result.longValue() < 0L)
/*     */     {
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     Role2TreasureHuntWorldInfo xRole2TreasureHuntWorldInfo = Role2treasurehuntworld.get(Long.valueOf(this.roleId));
/* 209 */     if (xRole2TreasureHuntWorldInfo != null)
/*     */     {
/* 211 */       onFail(4);
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     if (!RoleStatusInterface.setStatus(this.roleId, 2191, true))
/*     */     {
/* 217 */       onFail(11);
/* 218 */       return false;
/*     */     }
/*     */     
/* 221 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2192, true))
/*     */     {
/* 223 */       onFail(10);
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     Role2TreasureHuntInfo xRole2TreasureHuntInfo = Role2treasurehunt.get(Long.valueOf(this.roleId));
/* 228 */     if (xRole2TreasureHuntInfo == null)
/*     */     {
/* 230 */       xRole2TreasureHuntInfo = Pod.newRole2TreasureHuntInfo();
/* 231 */       Role2treasurehunt.add(Long.valueOf(this.roleId), xRole2TreasureHuntInfo);
/*     */     }
/*     */     
/* 234 */     RoleTreasureHuntActivityInfo xRole2TreasureHuntActivityInfo = (RoleTreasureHuntActivityInfo)xRole2TreasureHuntInfo.getTreasure_hunt_activity_map().get(Integer.valueOf(this.activityCfgId));
/*     */     
/* 236 */     int realNowProcess = 0;
/* 237 */     if (xRole2TreasureHuntActivityInfo == null)
/*     */     {
/* 239 */       realNowProcess = 0;
/*     */     }
/*     */     else
/*     */     {
/* 243 */       realNowProcess = xRole2TreasureHuntActivityInfo.getAwarded_chapter_id_set().size();
/*     */     }
/*     */     
/* 246 */     if (realNowProcess != this.nowProcess)
/*     */     {
/* 248 */       return false;
/*     */     }
/*     */     
/* 251 */     int chapterCfgId = ((Integer)this.sTreasureHuntCfg.chapter_id_list.get(this.nowProcess)).intValue();
/* 252 */     long worldId = result.longValue();
/*     */     
/* 254 */     xRole2TreasureHuntWorldInfo = Pod.newRole2TreasureHuntWorldInfo();
/* 255 */     xRole2TreasureHuntWorldInfo.setChapter_cfg_id(chapterCfgId);
/* 256 */     xRole2TreasureHuntWorldInfo.setProcess(0);
/* 257 */     xRole2TreasureHuntWorldInfo.setWorld_id(worldId);
/*     */     
/*     */ 
/* 260 */     MapInterface.transferToScene(this.roleId, worldId, this.sTreasureHuntChapterCfg.map_cfg_id);
/*     */     
/* 262 */     long leftSeconds = this.sTreasureHuntChapterCfg.treasure_hunt_time * 60L;
/* 263 */     TreasureHuntSceneSession treasureHuntSceneSession = new TreasureHuntSceneSession(leftSeconds, this.roleId, worldId, this.activityCfgId, chapterCfgId);
/*     */     
/*     */ 
/* 266 */     xRole2TreasureHuntWorldInfo.setSession_id(treasureHuntSceneSession.getSessionId());
/*     */     
/* 268 */     Role2treasurehuntworld.add(Long.valueOf(this.roleId), xRole2TreasureHuntWorldInfo);
/*     */     
/* 270 */     TreasureHuntMapTeamHandler teamHandler = new TreasureHuntMapTeamHandler();
/* 271 */     TeamInterface.registerJoinTeam(worldId, teamHandler);
/*     */     
/* 273 */     SAttendTreasureHuntSuccess sAttendTreasurHuntSuccess = new SAttendTreasureHuntSuccess();
/* 274 */     sAttendTreasurHuntSuccess.activity_cfg_id = this.activityCfgId;
/* 275 */     sAttendTreasurHuntSuccess.left_seconds = ((int)leftSeconds);
/* 276 */     sAttendTreasurHuntSuccess.total = this.sTreasureHuntChapterCfg.map_item_num;
/* 277 */     sAttendTreasurHuntSuccess.chapter_cfg_id = chapterCfgId;
/*     */     
/* 279 */     OnlineManager.getInstance().send(this.roleId, sAttendTreasurHuntSuccess);
/*     */     
/* 281 */     tlogAttendTreasureHunt();
/*     */     
/* 283 */     StringBuilder sBuilder = new StringBuilder();
/* 284 */     sBuilder.append("[treasure_hunt]PCAttendTreasureHunt.processImp@treasure hunt success");
/* 285 */     sBuilder.append("|role_id=").append(this.roleId);
/* 286 */     sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 287 */     GameServer.logger().info(sBuilder.toString());
/* 288 */     return true;
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
/*     */   boolean isTreasureHuntSwitchOpen(long roleId, int switchId)
/*     */   {
/* 301 */     if (!OpenInterface.getOpenStatus(switchId))
/*     */     {
/* 303 */       return false;
/*     */     }
/*     */     
/* 306 */     if (OpenInterface.isBanPlay(roleId, switchId))
/*     */     {
/* 308 */       OpenInterface.sendBanPlayMsg(roleId, switchId);
/* 309 */       return false;
/*     */     }
/*     */     
/* 312 */     return true;
/*     */   }
/*     */   
/*     */   private void tlogAttendTreasureHunt()
/*     */   {
/* 317 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 319 */     StringBuilder sbLog = new StringBuilder();
/* 320 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 321 */     sbLog.append(this.userId).append('|');
/* 322 */     sbLog.append(this.roleId).append('|');
/* 323 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 325 */     sbLog.append(this.activityCfgId);
/*     */     
/* 327 */     TLogManager.getInstance().addLog(this.roleId, "AttendTreasureHunt", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\PCAttendTreasureHunt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
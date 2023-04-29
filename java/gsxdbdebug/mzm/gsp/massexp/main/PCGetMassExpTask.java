/*     */ package mzm.gsp.massexp.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.massexp.SGetMassExpTaskFailed;
/*     */ import mzm.gsp.massexp.SGetMassExpTaskSuccess;
/*     */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*     */ import mzm.gsp.massexp.confbean.SMassExpLevelModifierCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassExpInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetMassExpTask extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCGetMassExpTask(long roleid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!MassExpManager.isFunOpen(this.roleid, true))
/*     */     {
/*  41 */       Map<String, Object> extras = new HashMap();
/*  42 */       extras.put("fun_open", Boolean.valueOf(false));
/*     */       
/*  44 */       onFailed(1, extras);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!MassExpManager.canDoAction(this.roleid, 238))
/*     */     {
/*  50 */       Map<String, Object> extras = new HashMap();
/*  51 */       extras.put("can_da_action", Boolean.valueOf(false));
/*     */       
/*  53 */       onFailed(1, extras);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(SMassExpCfgConsts.getInstance().NPC_CFG_ID, SMassExpCfgConsts.getInstance().NPC_GET_TASK_SERVICE_ID, this.roleid))
/*     */     {
/*     */ 
/*  61 */       Map<String, Object> extras = new HashMap();
/*  62 */       extras.put("check_npc_service", Boolean.valueOf(false));
/*  63 */       extras.put("npc_cfg_id", Integer.valueOf(SMassExpCfgConsts.getInstance().NPC_CFG_ID));
/*  64 */       extras.put("npc_service_id", Integer.valueOf(SMassExpCfgConsts.getInstance().NPC_GET_TASK_SERVICE_ID));
/*     */       
/*  66 */       onFailed(1, extras);
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*  72 */     if (serverLevel < SMassExpCfgConsts.getInstance().SERVER_LEVEL_LIMIT)
/*     */     {
/*  74 */       Map<String, Object> extras = new HashMap();
/*  75 */       extras.put("server_level", Integer.valueOf(serverLevel));
/*  76 */       extras.put("server_level_limit", Integer.valueOf(SMassExpCfgConsts.getInstance().SERVER_LEVEL_LIMIT));
/*     */       
/*  78 */       onFailed(-1, extras);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     int standardLevel = MassExpManager.getStandardLevel();
/*  84 */     if (standardLevel == -1)
/*     */     {
/*  86 */       Map<String, Object> extras = new HashMap();
/*  87 */       extras.put("standard_level", Integer.valueOf(standardLevel));
/*     */       
/*  89 */       onFailed(-1, extras);
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     int level = RoleInterface.getLevel(this.roleid);
/*  95 */     if (level > getMaxAllowedLevel(serverLevel, standardLevel))
/*     */     {
/*  97 */       Map<String, Object> extras = new HashMap();
/*  98 */       extras.put("standard_level", Integer.valueOf(standardLevel));
/*  99 */       extras.put("level", Integer.valueOf(level));
/*     */       
/* 101 */       onFailed(-2, extras);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/* 107 */     lock(Lockeys.get(User.getTable(), userid));
/* 108 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/* 111 */     int activityCfgid = SMassExpCfgConsts.getInstance().ACTIVITY_CFG_ID;
/* 112 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid).isCanJoin())
/*     */     {
/* 114 */       Map<String, Object> extras = new HashMap();
/* 115 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/*     */       
/* 117 */       onFailed(-1, extras);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(this.roleid, activityCfgid);
/* 122 */     if (xMassExpInfo == null)
/*     */     {
/* 124 */       onFailed(1);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     if (xMassExpInfo.getStatus() == 1)
/*     */     {
/*     */ 
/* 132 */       onFailed(-3);
/* 133 */       return false;
/*     */     }
/* 135 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 136 */     if (xMassExpInfo.getStatus() == 2)
/*     */     {
/* 138 */       if (!MassExpManager.expire(xMassExpInfo.getEnd_time(), now))
/*     */       {
/* 140 */         onFailed(-3);
/* 141 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 146 */     xMassExpInfo.setStatus(1);
/* 147 */     xMassExpInfo.setStart_time(now);
/* 148 */     xMassExpInfo.setCur_index(0);
/* 149 */     xMassExpInfo.getCosts().clear();
/* 150 */     long endTime = DateTimeUtils.getBeginTimeOfNextDay(now);
/* 151 */     xMassExpInfo.setEnd_time(endTime);
/*     */     
/*     */ 
/* 154 */     MassExpManager.startObserver(this.roleid, activityCfgid, TimeUnit.MILLISECONDS.toSeconds(endTime - now));
/*     */     
/*     */ 
/* 157 */     TaskInterface.activeGraph(Long.valueOf(this.roleid), SMassExpCfgConsts.getInstance().TASK_ICON_ID);
/*     */     
/* 159 */     int exp = RoleInterface.getCurExp(this.roleid);
/* 160 */     addTlog(userid, this.roleid, activityCfgid, exp, standardLevel);
/*     */     
/* 162 */     SGetMassExpTaskSuccess resp = new SGetMassExpTaskSuccess();
/* 163 */     resp.mass_exp_info = MassExpManager.buildMassExpInfo(xMassExpInfo);
/* 164 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 166 */     GameServer.logger().info(String.format("[massexp]PCGetMassExpTask.processImp@get mass exp task success|userid=%s|roleid=%d|activity_cfgid=%d|status=%d|level=%d|standard_level=%d|exp=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(activityCfgid), Integer.valueOf(xMassExpInfo.getStatus()), Integer.valueOf(level), Integer.valueOf(standardLevel), Integer.valueOf(exp) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 171 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 176 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 181 */     if (retcode < 0)
/*     */     {
/* 183 */       SGetMassExpTaskFailed resp = new SGetMassExpTaskFailed();
/* 184 */       resp.retcode = retcode;
/* 185 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 188 */     StringBuffer logBuilder = new StringBuffer();
/* 189 */     logBuilder.append("[massexp]PCGetMassExpTask.onFailed@get mass exp failed");
/* 190 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 191 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 193 */     if (extraParams != null)
/*     */     {
/* 195 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 197 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 201 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   private void addTlog(String userid, long roleid, int activityCfgid, int exp, int standardLevel)
/*     */   {
/* 206 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 207 */     int roleLevel = RoleInterface.getLevel(roleid);
/*     */     
/* 209 */     TLogManager.getInstance().addLog(userid, "GetMassExpTaskForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Integer.valueOf(activityCfgid), Integer.valueOf(exp), Integer.valueOf(standardLevel) });
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
/*     */   private int getMaxAllowedLevel(int serverLevel, int standardLevel)
/*     */   {
/* 223 */     int modifier = SMassExpCfgConsts.getInstance().RANGE_LEVEL;
/* 224 */     for (SMassExpLevelModifierCfg cfg : SMassExpLevelModifierCfg.getAll().values())
/*     */     {
/* 226 */       if (serverLevel < cfg.serverLevel) break;
/* 227 */       modifier = cfg.levelModifier;
/*     */     }
/*     */     
/*     */ 
/* 231 */     return standardLevel - modifier;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\PCGetMassExpTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
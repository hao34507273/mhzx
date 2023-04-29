/*     */ package mzm.gsp.massexp.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.massexp.SGetAwardFailed;
/*     */ import mzm.gsp.massexp.SGetAwardSuccess;
/*     */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassExpInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetAward extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCGetAward(long roleid)
/*     */   {
/*  36 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!MassExpManager.isFunOpen(this.roleid, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!MassExpManager.canDoAction(this.roleid, 240))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     String userid = RoleInterface.getUserId(this.roleid);
/*  53 */     int activityCfgid = SMassExpCfgConsts.getInstance().ACTIVITY_CFG_ID;
/*     */     
/*     */ 
/*  56 */     lock(Lockeys.get(User.getTable(), userid));
/*  57 */     MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(this.roleid, activityCfgid);
/*  58 */     if (xMassExpInfo == null)
/*     */     {
/*  60 */       onFailed(1);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (xMassExpInfo.getStatus() == 0)
/*     */     {
/*  66 */       Map<String, Object> extras = new HashMap();
/*  67 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/*  68 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/*  69 */       extras.put("cur_index", Integer.valueOf(xMassExpInfo.getCur_index()));
/*  70 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */       
/*  72 */       onFailed(-1, extras);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (xMassExpInfo.getStatus() == 2)
/*     */     {
/*  78 */       Map<String, Object> extras = new HashMap();
/*  79 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/*  80 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/*  81 */       extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/*  82 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */       
/*  84 */       onFailed(2, extras);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  89 */     if (MassExpManager.expire(xMassExpInfo.getEnd_time(), now))
/*     */     {
/*     */ 
/*  92 */       Map<String, Object> extras = new HashMap();
/*  93 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/*  94 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/*  95 */       extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/*  96 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */       
/*  98 */       onFailed(-2, extras);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int curIndex = xMassExpInfo.getCur_index();
/* 103 */     if (curIndex == 0)
/*     */     {
/* 105 */       Map<String, Object> extras = new HashMap();
/* 106 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/* 107 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/* 108 */       extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/* 109 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */       
/* 111 */       onFailed(-1, extras);
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     xMassExpInfo.setStatus(2);
/* 117 */     xMassExpInfo.getCosts().clear();
/* 118 */     xMassExpInfo.setCur_index(0);
/*     */     
/*     */ 
/* 121 */     int awardCfgid = SMassExpCfgConsts.getInstance().AWARD_CFG_ID;
/* 122 */     List<Integer> awards = new ArrayList();
/* 123 */     for (int i = 0; i < curIndex; i++)
/*     */     {
/* 125 */       awards.add(Integer.valueOf(awardCfgid));
/*     */     }
/* 127 */     AwardReason awardReason = new AwardReason(LogReason.MASS_EXP_GET_AWARD, awardCfgid);
/* 128 */     AwardModel awardModel = AwardInterface.award(awards, null, userid, this.roleid, true, true, awardReason);
/* 129 */     if (awardModel == null)
/*     */     {
/* 131 */       Map<String, Object> extras = new HashMap();
/* 132 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/* 133 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/* 134 */       extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/* 135 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */       
/* 137 */       onFailed(3, extras);
/* 138 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 142 */     MassExpManager.stopObserver(this.roleid, activityCfgid);
/*     */     
/* 144 */     TaskInterface.closeActivityGraphWithoutEvent(this.roleid, SMassExpCfgConsts.getInstance().TASK_ICON_ID);
/*     */     
/* 146 */     addTlog(userid, this.roleid, activityCfgid, RoleInterface.getCurExp(this.roleid), xMassExpInfo.getStart_time(), curIndex);
/*     */     
/*     */ 
/*     */ 
/* 150 */     ActivityInterface.logActivity(this.roleid, activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 152 */     ActivityInterface.tlogActivity(this.roleid, activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 154 */     SGetAwardSuccess resp = new SGetAwardSuccess();
/* 155 */     resp.status = xMassExpInfo.getStatus();
/* 156 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 158 */     GameServer.logger().info(String.format("[massexp]PCGetAward.processImp@get award success|roleid=%d|cur_index", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(curIndex) }));
/*     */     
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 166 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 171 */     if (retcode < 0)
/*     */     {
/* 173 */       SGetAwardFailed resp = new SGetAwardFailed();
/* 174 */       resp.retcode = retcode;
/* 175 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 178 */     StringBuffer logBuilder = new StringBuffer();
/* 179 */     logBuilder.append("[massexp]PCGetAward.onFailed@get award failed");
/* 180 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 181 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 183 */     if (extraParams != null)
/*     */     {
/* 185 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 187 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 191 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long roleid, int activityCfgid, int exp, long startTime, int curIndex)
/*     */   {
/* 197 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 198 */     int roleLevel = RoleInterface.getLevel(roleid);
/*     */     
/* 200 */     TLogManager.getInstance().addLog(userid, "MassExpGetAwardForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Integer.valueOf(activityCfgid), Integer.valueOf(exp), Long.valueOf(startTime), Integer.valueOf(curIndex) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\PCGetAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
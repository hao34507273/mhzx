/*     */ package mzm.gsp.massexp.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.massexp.SFillGridFailed;
/*     */ import mzm.gsp.massexp.SFillGridSuccess;
/*     */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*     */ import mzm.gsp.massexp.confbean.SMassExpCostCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FillGridInfo;
/*     */ import xbean.MassExpInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCFillGrid extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int curIndex;
/*     */   
/*     */   public PCFillGrid(long roleid, int curIndex)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.curIndex = curIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if ((this.curIndex < 1) || (this.curIndex > SMassExpCfgConsts.getInstance().MAX_GRID))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!MassExpManager.isFunOpen(this.roleid, true))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!MassExpManager.canDoAction(this.roleid, 239))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     String userid = RoleInterface.getUserId(this.roleid);
/*  54 */     int activityCfgid = SMassExpCfgConsts.getInstance().ACTIVITY_CFG_ID;
/*     */     
/*     */ 
/*  57 */     lock(Lockeys.get(User.getTable(), userid));
/*  58 */     MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(this.roleid, activityCfgid);
/*  59 */     if (xMassExpInfo == null)
/*     */     {
/*  61 */       onFailed(1);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (xMassExpInfo.getStatus() != 1)
/*     */     {
/*  67 */       Map<String, Object> extras = new HashMap();
/*  68 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/*  69 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/*  70 */       extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/*  71 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */       
/*  73 */       onFailed(2, extras);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  78 */     if (MassExpManager.expire(xMassExpInfo.getEnd_time(), now))
/*     */     {
/*     */ 
/*  81 */       Map<String, Object> extras = new HashMap();
/*  82 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/*  83 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/*  84 */       extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/*  85 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */       
/*  87 */       onFailed(-3, extras);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     if (xMassExpInfo.getCur_index() >= this.curIndex)
/*     */     {
/*  94 */       onFailed(-1);
/*  95 */       return false;
/*     */     }
/*  97 */     if (xMassExpInfo.getCur_index() + 1 != this.curIndex)
/*     */     {
/*  99 */       onFailed(-2);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     int level = RoleInterface.getLevel(this.roleid);
/* 105 */     SMassExpCostCfg cfg = MassExpManager.getMassExpCostCfg(level);
/* 106 */     if (cfg == null)
/*     */     {
/*     */ 
/* 109 */       Map<String, Object> extras = new HashMap();
/* 110 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/* 111 */       extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/* 112 */       extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/* 113 */       extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/* 114 */       extras.put("level", Integer.valueOf(level));
/*     */       
/* 116 */       onFailed(1, extras);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     int moneyType = cfg.moneyType;
/* 121 */     int cost = cfg.cost;
/* 122 */     TLogArg tLogArg = new TLogArg(LogReason.MASS_EXP_FILL_GRID);
/* 123 */     if (!MassExpManager.cost(userid, this.roleid, cfg.moneyType, cost, tLogArg))
/*     */     {
/* 125 */       Map<String, Object> extras = new HashMap();
/* 126 */       extras.put("money_type", Integer.valueOf(moneyType));
/* 127 */       extras.put("cost", Integer.valueOf(cost));
/*     */       
/* 129 */       onFailed(-4, extras);
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 134 */     xMassExpInfo.setCur_index(this.curIndex);
/* 135 */     FillGridInfo xFillGridInfo = xbean.Pod.newFillGridInfo();
/* 136 */     xFillGridInfo.setCost(cost);
/* 137 */     xFillGridInfo.setCost_type(moneyType);
/* 138 */     xMassExpInfo.getCosts().put(Integer.valueOf(this.curIndex), xFillGridInfo);
/*     */     
/* 140 */     addTlog(userid, this.roleid, level, activityCfgid, xMassExpInfo.getStart_time(), moneyType, cost);
/*     */     
/* 142 */     SFillGridSuccess resp = new SFillGridSuccess();
/* 143 */     resp.cur_index = this.curIndex;
/* 144 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 146 */     GameServer.logger().info(String.format("[massexp]PCFillGrid.processImp@fill grid success|roleid=%d|cur_index=%d|money_type=%d|cost=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.curIndex), Integer.valueOf(moneyType), Integer.valueOf(cost) }));
/*     */     
/*     */ 
/*     */ 
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 155 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 160 */     if (retcode < 0)
/*     */     {
/* 162 */       SFillGridFailed resp = new SFillGridFailed();
/* 163 */       resp.cur_index = this.curIndex;
/* 164 */       resp.retcode = retcode;
/* 165 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 168 */     StringBuffer logBuilder = new StringBuffer();
/* 169 */     logBuilder.append("[massexp]PCFillGrid.onFailed@fill grid failed");
/* 170 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 171 */     logBuilder.append('|').append("cur_index=").append(this.curIndex);
/* 172 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 174 */     if (extraParams != null)
/*     */     {
/* 176 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 178 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 182 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long roleid, int level, int activityCfgid, long startTime, int moneyType, int cost)
/*     */   {
/* 188 */     String vGameIp = GameServerInfoManager.getHostIP();
/*     */     
/* 190 */     TLogManager.getInstance().addLog(userid, "MassExpFillGridForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(activityCfgid), Long.valueOf(startTime), Integer.valueOf(this.curIndex), Integer.valueOf(moneyType), Integer.valueOf(cost) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\PCFillGrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
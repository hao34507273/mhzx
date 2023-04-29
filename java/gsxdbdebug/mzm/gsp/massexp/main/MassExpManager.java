/*     */ package mzm.gsp.massexp.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.chart.main.RoleRelatedChartObj;
/*     */ import mzm.gsp.idip.main.RankType;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*     */ import mzm.gsp.massexp.confbean.SMassExpCostCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FillGridInfo;
/*     */ import xbean.MassExpActivity;
/*     */ import xbean.MassExpObserver;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2massexpactivity;
/*     */ import xtable.Role2massexpobservers;
/*     */ 
/*     */ public class MassExpManager
/*     */ {
/*     */   static void init()
/*     */   {
/*  39 */     ActivityInterface.registerActivityByLogicType(64, new MassExpActivityHandler(), false);
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
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/*  53 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid, boolean send)
/*     */   {
/*  58 */     if (!OpenInterface.getOpenStatus(196))
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     if (OpenInterface.isBanPlay(roleid, 196))
/*     */     {
/*  64 */       if (send)
/*     */       {
/*  66 */         OpenInterface.sendBanPlayMsg(roleid, 196);
/*     */       }
/*  68 */       return false;
/*     */     }
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   static void initData(String userid, long roleid, int activityCfgid)
/*     */   {
/*  75 */     MassExpActivity xMassExpActivity = Role2massexpactivity.get(Long.valueOf(roleid));
/*  76 */     if (xMassExpActivity == null)
/*     */     {
/*  78 */       xMassExpActivity = Pod.newMassExpActivity();
/*  79 */       Role2massexpactivity.insert(Long.valueOf(roleid), xMassExpActivity);
/*     */     }
/*  81 */     xbean.MassExpInfo xMassExpInfo = (xbean.MassExpInfo)xMassExpActivity.getMass_exp_infos().get(Integer.valueOf(activityCfgid));
/*  82 */     if (xMassExpInfo == null)
/*     */     {
/*  84 */       xMassExpInfo = Pod.newMassExpInfo();
/*  85 */       xMassExpActivity.getMass_exp_infos().put(Integer.valueOf(activityCfgid), xMassExpInfo);
/*     */     }
/*     */     else
/*     */     {
/*  89 */       taskEnd(userid, roleid, activityCfgid, xMassExpInfo, MassExpInitReason.ACTIVITY_INIT_DATA);
/*     */     }
/*     */     
/*     */ 
/*  93 */     xMassExpInfo.setStatus(0);
/*  94 */     xMassExpInfo.setCur_index(0);
/*  95 */     xMassExpInfo.setStart_time(0L);
/*  96 */     xMassExpInfo.getCosts().clear();
/*     */   }
/*     */   
/*     */   static xbean.MassExpInfo getMassExpInfo(long roleid, int activityCfgid)
/*     */   {
/* 101 */     MassExpActivity xMassExpActivity = Role2massexpactivity.get(Long.valueOf(roleid));
/* 102 */     if (xMassExpActivity == null)
/*     */     {
/* 104 */       return null;
/*     */     }
/* 106 */     return (xbean.MassExpInfo)xMassExpActivity.getMass_exp_infos().get(Integer.valueOf(activityCfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getStandardLevel()
/*     */   {
/* 116 */     int rankIndex = SMassExpCfgConsts.getInstance().ROLE_LEVEL_RANK_INDEX - 1;
/*     */     
/* 118 */     List<RoleRelatedChartObj> chartObjs = mzm.gsp.chart.main.RankInterface.getRoleRelatedChartObjs(RankType.ROLE_LEVEL.getValue(), rankIndex, rankIndex);
/*     */     
/* 120 */     if (chartObjs.isEmpty())
/*     */     {
/* 122 */       return -1;
/*     */     }
/* 124 */     long roleid = ((RoleRelatedChartObj)chartObjs.get(0)).getRoleid();
/* 125 */     return RoleInterface.getLevel(roleid);
/*     */   }
/*     */   
/*     */   static mzm.gsp.massexp.MassExpInfo buildMassExpInfo(xbean.MassExpInfo xMassExpInfo)
/*     */   {
/* 130 */     mzm.gsp.massexp.MassExpInfo massExpInfo = new mzm.gsp.massexp.MassExpInfo();
/* 131 */     massExpInfo.cur_index = xMassExpInfo.getCur_index();
/* 132 */     massExpInfo.start_timestamp = ((int)TimeUnit.MILLISECONDS.toSeconds(xMassExpInfo.getStart_time()));
/* 133 */     massExpInfo.end_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xMassExpInfo.getEnd_time()));
/* 134 */     massExpInfo.status = xMassExpInfo.getStatus();
/* 135 */     return massExpInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   static void taskEnd(String userid, long roleid, int activityCfgid, xbean.MassExpInfo xMassExpInfo, MassExpInitReason reason)
/*     */   {
/* 141 */     int status = xMassExpInfo.getStatus();
/* 142 */     int curIndex = xMassExpInfo.getCur_index();
/* 143 */     long startTime = xMassExpInfo.getStart_time();
/*     */     
/* 145 */     if (xMassExpInfo.getStatus() == 1)
/*     */     {
/* 147 */       returnCost(userid, roleid, activityCfgid, xMassExpInfo, reason);
/*     */     }
/*     */     
/* 150 */     xMassExpInfo.setStatus(0);
/* 151 */     xMassExpInfo.setCur_index(0);
/* 152 */     xMassExpInfo.getCosts().clear();
/*     */     
/*     */ 
/* 155 */     TaskInterface.closeActivityGraphWithoutEvent(roleid, SMassExpCfgConsts.getInstance().TASK_ICON_ID);
/*     */     
/* 157 */     GameServer.logger().info(String.format("[massexp]MassExpManager.taskEnd|userid=%s|roleid=%d|activity_cfgid=%d|status=%d|cur_index=%d|start_time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(status), Integer.valueOf(curIndex), Long.valueOf(startTime), reason.name() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static SMassExpCostCfg getMassExpCostCfg(int level)
/*     */   {
/* 165 */     for (SMassExpCostCfg cfg : SMassExpCostCfg.getAll().values())
/*     */     {
/* 167 */       if ((cfg.minLevel <= level) && (level <= cfg.maxLevel))
/*     */       {
/* 169 */         return cfg;
/*     */       }
/*     */     }
/* 172 */     GameServer.logger().error(String.format("[massexp]MassExpManager.getMassExpCostCfg@get cfg is null|level=%d", new Object[] { Integer.valueOf(level) }));
/* 173 */     return null;
/*     */   }
/*     */   
/*     */   static boolean cost(String userid, long roleid, int type, int num, TLogArg tLogArg)
/*     */   {
/* 178 */     boolean result = true;
/* 179 */     switch (type)
/*     */     {
/*     */     case 1: 
/* 182 */       CostResult costResult = QingfuInterface.costYuanbao(userid, roleid, num, CostType.COST_BIND_FIRST_MASS_EXP_FILL_GRID, tLogArg);
/*     */       
/* 184 */       if (costResult != CostResult.Success)
/*     */       {
/* 186 */         result = false;
/* 187 */         GameServer.logger().error(String.format("[massexp]MassExpManager.cost@cost yuanbao failed|userid=%s|roleid=%d|num=%d|code=%d|desc=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(num), Integer.valueOf(costResult.code), costResult.desc }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       break;
/*     */     case 2: 
/* 194 */       result = RoleInterface.cutGold(roleid, num, tLogArg);
/* 195 */       break;
/*     */     case 3: 
/* 197 */       result = RoleInterface.cutSilver(roleid, num, tLogArg);
/* 198 */       break;
/*     */     case 5: 
/* 200 */       result = RoleInterface.cutGoldIngot(roleid, num, tLogArg);
/* 201 */       break;
/*     */     case 0: 
/* 203 */       result = false;
/* 204 */       break;
/*     */     
/*     */     case 4: 
/* 207 */       result = false;
/* 208 */       break;
/*     */     default: 
/* 210 */       result = false;
/*     */     }
/*     */     
/* 213 */     if (!result)
/*     */     {
/* 215 */       GameServer.logger().error(String.format("[massexp]MassExpManager.cost@cost money failed|userid=%s|roleid=%d|money_type=%d|num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(num) }));
/*     */     }
/*     */     
/*     */ 
/* 219 */     return result;
/*     */   }
/*     */   
/*     */   static boolean expire(long time, long curTime)
/*     */   {
/* 224 */     return curTime >= time;
/*     */   }
/*     */   
/*     */   static void startObserver(long roleid, int activityCfgid, long intervalSeconds)
/*     */   {
/* 229 */     MassExpObserver xMassExpObserver = Role2massexpobservers.get(Long.valueOf(roleid));
/* 230 */     if (xMassExpObserver == null)
/*     */     {
/* 232 */       xMassExpObserver = Pod.newMassExpObserver();
/* 233 */       Role2massexpobservers.insert(Long.valueOf(roleid), xMassExpObserver);
/*     */     }
/* 235 */     Observer newObserver = new ReturnCostObserver(intervalSeconds, roleid, activityCfgid);
/* 236 */     Observer oldObserver = (Observer)xMassExpObserver.getObservers().put(Integer.valueOf(activityCfgid), newObserver);
/* 237 */     if (oldObserver != null)
/*     */     {
/* 239 */       oldObserver.stopTimer();
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean stopObserver(long roleid, int activityCfgid)
/*     */   {
/* 245 */     MassExpObserver xMassExpObserver = Role2massexpobservers.get(Long.valueOf(roleid));
/* 246 */     if (xMassExpObserver == null)
/*     */     {
/* 248 */       return false;
/*     */     }
/*     */     
/* 251 */     Observer oldObserver = (Observer)xMassExpObserver.getObservers().remove(Integer.valueOf(activityCfgid));
/* 252 */     if (oldObserver == null)
/*     */     {
/* 254 */       return false;
/*     */     }
/*     */     
/* 257 */     oldObserver.stopTimer();
/* 258 */     return true;
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
/*     */   private static void returnCost(String userid, long roleid, int activityCfgid, xbean.MassExpInfo xMassExpInfo, MassExpInitReason reason)
/*     */   {
/* 273 */     int curIndex = xMassExpInfo.getCur_index();
/* 274 */     if (curIndex <= 0)
/*     */     {
/* 276 */       GameServer.logger().info(String.format("[massexp]MassExpManager.returnCost@costs is empty|userid=%s|roleid=%d|activity_cfgid=%d|status=%d|cur_index=%d|start_time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(xMassExpInfo.getStatus()), Integer.valueOf(xMassExpInfo.getCur_index()), Long.valueOf(xMassExpInfo.getStart_time()), reason.name() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 281 */       return;
/*     */     }
/*     */     
/*     */ 
/* 285 */     Map<Integer, Integer> costs = getCost(xMassExpInfo.getCosts());
/* 286 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 287 */     TLogArg tLogArg = new TLogArg(LogReason.MASS_EXP_RETURN_COST);
/* 288 */     List<String> emptyStrings = Collections.emptyList();
/* 289 */     int mailCfgId = SMassExpCfgConsts.getInstance().MAIL_CFG_ID;
/* 290 */     fillMailMoneyAttachment(mailAttachment, costs);
/* 291 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, mailCfgId, emptyStrings, emptyStrings, mailAttachment, tLogArg);
/*     */     
/* 293 */     if (!sendMailRet.isOK())
/*     */     {
/* 295 */       GameServer.logger().error(String.format("[massexp]MassExpManager.returnCost@send mail failed|userid=%s|roleid=%d|activity_cfgid=%d|status=%d|cur_index=%d|start_time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(xMassExpInfo.getStatus()), Integer.valueOf(xMassExpInfo.getCur_index()), Long.valueOf(xMassExpInfo.getStart_time()), reason.name() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 300 */       return;
/*     */     }
/*     */     
/* 303 */     GameServer.logger().info(String.format("[massexp]MassExpManager.returnCost@send mail success|userid=%s|roleid=%d|activity_cfgid=%d|status=%d|cur_index=%d|start_time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(xMassExpInfo.getStatus()), Integer.valueOf(xMassExpInfo.getCur_index()), Long.valueOf(xMassExpInfo.getStart_time()), reason.name() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map<Integer, Integer> getCost(Map<Integer, FillGridInfo> xCosts)
/*     */   {
/* 313 */     if (xCosts.isEmpty())
/*     */     {
/* 315 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 318 */     Map<Integer, Integer> result = new HashMap();
/* 319 */     for (FillGridInfo xFillGridInfo : xCosts.values())
/*     */     {
/* 321 */       int costType = xFillGridInfo.getCost_type();
/* 322 */       Integer cost = (Integer)result.get(Integer.valueOf(costType));
/* 323 */       if (cost == null)
/*     */       {
/* 325 */         result.put(Integer.valueOf(costType), Integer.valueOf(xFillGridInfo.getCost()));
/*     */       }
/*     */       else
/*     */       {
/* 329 */         result.put(Integer.valueOf(costType), Integer.valueOf(cost.intValue() + xFillGridInfo.getCost()));
/*     */       }
/*     */     }
/* 332 */     return result;
/*     */   }
/*     */   
/*     */   private static void fillMailMoneyAttachment(MailAttachment mailAttachment, Map<Integer, Integer> moneys)
/*     */   {
/* 337 */     for (Map.Entry<Integer, Integer> entry : moneys.entrySet())
/*     */     {
/* 339 */       fillMailMoneyAttachment(mailAttachment, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private static void fillMailMoneyAttachment(MailAttachment mailAttachment, int moneyType, int num)
/*     */   {
/* 345 */     switch (moneyType)
/*     */     {
/*     */     case 1: 
/* 348 */       mailAttachment.setBindYuanBao(num);
/* 349 */       break;
/*     */     case 2: 
/* 351 */       mailAttachment.setGold(num);
/* 352 */       break;
/*     */     case 3: 
/* 354 */       mailAttachment.setSilver(num);
/* 355 */       break;
/*     */     case 5: 
/* 357 */       mailAttachment.setGoldIngot(num);
/* 358 */       break;
/*     */     case 0: 
/*     */       break;
/*     */     case 4: 
/*     */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void dataStruceChange(xbean.MassExpInfo xMassExpInfo)
/*     */   {
/* 372 */     if (xMassExpInfo.getEnd_time() == 0L)
/*     */     {
/* 374 */       xMassExpInfo.setEnd_time(xMassExpInfo.getStart_time() + TimeUnit.HOURS.toMillis(SMassExpCfgConsts.getInstance().TASK_PERIOD));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\MassExpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
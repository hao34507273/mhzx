/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*     */ import mzm.gsp.activity.confbean.SJingjiPhaseCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Opponent;
/*     */ import xbean.RoleJingJiBean;
/*     */ import xbean.RoleJingJiRank;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ import xtable.Rolejingjirank_backup;
/*     */ 
/*     */ public class JingjiSeasonObserver extends Observer
/*     */ {
/*     */   public JingjiSeasonObserver(long intervalSeconds)
/*     */   {
/*  30 */     super(intervalSeconds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  37 */     new TimeOutPro(null).execute();
/*  38 */     setIntervalSeconds(TimeUnit.MILLISECONDS.toSeconds(JingjiManager.getSeasonPersistTime()));
/*  39 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class TimeOutPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     public boolean processImp()
/*     */       throws Exception
/*     */     {
/*  49 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  50 */       long cur = now + TimeUnit.MINUTES.toMillis(1L);
/*  51 */       Calendar cal = DateTimeUtils.getCalendar();
/*  52 */       cal.setTimeInMillis(cur);
/*  53 */       cal.set(14, 0);
/*  54 */       cal.set(13, 0);
/*  55 */       cal.set(12, 0);
/*     */       
/*  57 */       long seasonStartTime = cal.getTimeInMillis();
/*  58 */       new InitSeasonStartTimePro(seasonStartTime).execute();
/*     */       
/*  60 */       List<RoleJingjiChart> roleJingjiCharts = JingJiRankManager.getInstance().getAllChartObjs();
/*  61 */       JingjiRankCache.getInstance().updateJingjiCache(roleJingjiCharts, now);
/*  62 */       long key = mzm.gsp.GameServerInfoManager.getLocalId();
/*     */       
/*  64 */       RoleJingJiRank xJingJiRank_backup = Rolejingjirank_backup.get(Long.valueOf(key));
/*  65 */       if (xJingJiRank_backup == null)
/*     */       {
/*  67 */         xJingJiRank_backup = xbean.Pod.newRoleJingJiRank();
/*  68 */         Rolejingjirank_backup.insert(Long.valueOf(key), xJingJiRank_backup);
/*     */       }
/*  70 */       xJingJiRank_backup.getRankdatas().clear();
/*  71 */       for (RoleJingjiChart r : roleJingjiCharts)
/*     */       {
/*  73 */         RoleJingJiBean xRoleJingJiBean = xbean.Pod.newRoleJingJiBean();
/*  74 */         xRoleJingJiBean.setPoint(r.getWinPoint());
/*  75 */         xRoleJingJiBean.setRoleid(r.getRoleid());
/*  76 */         xJingJiRank_backup.getRankdatas().add(xRoleJingJiBean);
/*     */       }
/*  78 */       Xdb.executor().execute(new JingjiSeasonObserver.SeasonEndRunnable(seasonStartTime, roleJingjiCharts));
/*     */       
/*  80 */       List<Long> topTenRoleids = new ArrayList();
/*  81 */       for (int i = 0; i < Math.min(roleJingjiCharts.size(), JingjiActivityCfgConsts.getInstance().MIN_RANK_FOR_PRIVATE_CHAT_FLAG); 
/*  82 */           i++)
/*     */       {
/*  84 */         topTenRoleids.add(Long.valueOf(((RoleJingjiChart)roleJingjiCharts.get(i)).getRoleid()));
/*     */       }
/*  86 */       Xdb.executor().execute(new JingjiSeasonObserver.SaveToptenRunnable(topTenRoleids));
/*     */       
/*  88 */       RoleJingjiChartInterface.clear();
/*     */       
/*  90 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class SeasonEndRunnable
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long seasonStartTime;
/*     */     
/*     */     private final List<RoleJingjiChart> roleJingjiCharts;
/*     */     
/*     */     SeasonEndRunnable(long seasonStartTime, List<RoleJingjiChart> roleJingjiCharts)
/*     */     {
/* 104 */       this.seasonStartTime = seasonStartTime;
/* 105 */       this.roleJingjiCharts = roleJingjiCharts;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 111 */       Set<Long> onRankRoles = new java.util.HashSet();
/*     */       
/* 113 */       int rank = 1;
/* 114 */       for (RoleJingjiChart roleJingjiChart : this.roleJingjiCharts)
/*     */       {
/*     */ 
/* 117 */         onRankRoles.add(Long.valueOf(roleJingjiChart.getRoleid()));
/*     */         
/* 119 */         NoneRealTimeTaskManager.getInstance().addTask(new JingjiSeasonObserver.POnSeasonEndOfferMailAward(roleJingjiChart.getRoleid(), roleJingjiChart.getWinPoint(), rank));
/*     */         
/* 121 */         rank++;
/*     */       }
/*     */       
/* 124 */       onRankRoles.addAll(OnlineManager.getInstance().getAllRolesInWorld());
/* 125 */       Iterator<Long> iterator = onRankRoles.iterator();
/*     */       
/* 127 */       while (iterator.hasNext())
/*     */       {
/* 129 */         long roleId = ((Long)iterator.next()).longValue();
/* 130 */         new JingjiSeasonObserver.POnSeasonEnd(roleId, this.seasonStartTime).call();
/* 131 */         iterator.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class SaveToptenRunnable
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final List<Long> topTenRoleids;
/*     */     
/*     */ 
/*     */     public SaveToptenRunnable(List<Long> topTenRoleids)
/*     */     {
/* 146 */       this.topTenRoleids = topTenRoleids;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 152 */       for (int i = 0; i < this.topTenRoleids.size(); i++)
/*     */       {
/* 154 */         NoneRealTimeTaskManager.getInstance().addTask(new JingjiSeasonObserver.PSaveTopTenRank(((Long)this.topTenRoleids.get(i)).longValue(), i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class POnSeasonEnd
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     private final long seasonEndTime;
/*     */     
/*     */     POnSeasonEnd(long roleid, long seasonEndTime)
/*     */     {
/* 169 */       this.roleid = roleid;
/* 170 */       this.seasonEndTime = seasonEndTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 176 */       xbean.JingjiPvp jingjiData = xtable.Role2jingjipvp.get(Long.valueOf(this.roleid));
/* 177 */       if (jingjiData == null)
/*     */       {
/* 179 */         return false;
/*     */       }
/* 181 */       JingjiManager.seasonEndInitRoleData(jingjiData, this.seasonEndTime);
/* 182 */       JingjiManager.synJingjiData(this.roleid, jingjiData);
/* 183 */       Opponent xOpponent = xtable.Role2opponent.get(Long.valueOf(this.roleid));
/* 184 */       if (xOpponent != null)
/*     */       {
/* 186 */         xOpponent.getOpponentroleids().clear();
/*     */       }
/* 188 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class POnSeasonEndOfferMailAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int winPoint;
/*     */     private final int rank;
/*     */     
/*     */     POnSeasonEndOfferMailAward(long roleid, int winPoint, int rank)
/*     */     {
/* 202 */       this.roleid = roleid;
/* 203 */       this.winPoint = winPoint;
/* 204 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 210 */       if (mzm.gsp.GameServerInfoManager.isRoamServer())
/*     */       {
/* 212 */         String logStr = String.format("[jingji]POnSeasonEndOfferMailAward.processImp@roam server can not get jingji season award|roleid=%d|winPoint=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.winPoint), Integer.valueOf(this.rank) });
/*     */         
/*     */ 
/* 215 */         JingjiManager.logger.info(logStr);
/* 216 */         return false;
/*     */       }
/*     */       
/* 219 */       int phase = JingjiManager.getPhaseByWingPoint(this.winPoint);
/* 220 */       SJingjiPhaseCfg jingjiPhaseCfg = JingjiManager.getJingjiPhaseCfgByPhase(phase);
/* 221 */       if (jingjiPhaseCfg == null)
/*     */       {
/* 223 */         String logStr = String.format("[jingji]POnSeasonEndOfferMailAward.processImp@phase error,SJingjiPhaseCfg null|roleid=%d|winPoint=%d|phase=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.winPoint), Integer.valueOf(phase), Integer.valueOf(this.rank) });
/*     */         
/*     */ 
/* 226 */         JingjiManager.logger.error(logStr);
/* 227 */         return false;
/*     */       }
/*     */       
/* 230 */       TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.JINGJI_ACTIVITY_SEASON_REWARD_ADD);
/* 231 */       List<String> contentArgs = new ArrayList();
/* 232 */       contentArgs.add(jingjiPhaseCfg.phaseName);
/* 233 */       mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.roleid, JingjiActivityCfgConsts.getInstance().SEASON_AWARD_MAIL_ID, null, contentArgs, tLogArg);
/*     */       
/*     */ 
/* 236 */       String logStr = String.format("[jingji]POnSeasonEndOfferMailAward.processImp@send season end mail success|roleid=%d|mailId=%d|winPoint=%d|phase=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(JingjiActivityCfgConsts.getInstance().SEASON_AWARD_MAIL_ID), Integer.valueOf(this.winPoint), Integer.valueOf(phase), Integer.valueOf(this.rank) });
/*     */       
/*     */ 
/* 239 */       JingjiManager.logger.info(logStr);
/* 240 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class PSaveTopTenRank
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     
/*     */     PSaveTopTenRank(long roleid, int rank)
/*     */     {
/* 253 */       this.roleid = roleid;
/* 254 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 260 */       JingjiManager.setLastseasonrank(this.roleid, this.rank);
/* 261 */       int badgeId = JingjiManager.getBadageId(this.rank + 1);
/* 262 */       if (badgeId != -1)
/*     */       {
/* 264 */         boolean ret = mzm.gsp.badge.main.BadgeInterface.addBadge(this.roleid, badgeId);
/* 265 */         if (!ret)
/*     */         {
/* 267 */           String logStr = String.format("[jingji]PSaveTopTenRank.processImp@offer season end badge failed|roleid=%d|badgeId=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(badgeId), Integer.valueOf(this.rank + 1) });
/*     */           
/*     */ 
/* 270 */           JingjiManager.logger.error(logStr);
/*     */         }
/*     */         else
/*     */         {
/* 274 */           String logStr = String.format("[jingji]PSaveTopTenRank.processImp@offer season end badge success|roleid=%d|badgeId=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(badgeId), Integer.valueOf(this.rank + 1) });
/*     */           
/*     */ 
/* 277 */           JingjiManager.logger.info(logStr);
/*     */           
/*     */ 
/* 280 */           JingjiManager.addTLog(this.roleid, "JingjiTopTenForServer", new Object[] { Integer.valueOf(this.rank + 1), Integer.valueOf(badgeId) });
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 285 */         String logStr = String.format("[jingji]PSaveTopTenRank.processImp@offer season end badge failed|roleid=%d|badgeId=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(badgeId), Integer.valueOf(this.rank + 1) });
/*     */         
/*     */ 
/* 288 */         JingjiManager.logger.error(logStr);
/*     */       }
/*     */       
/* 291 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiSeasonObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
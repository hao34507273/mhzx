/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.DateObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGiveFlowerBean;
/*     */ import xbean.RoleGiveFlowerRank;
/*     */ import xbean.RoleReceivceFlowerRank;
/*     */ import xbean.RoleReceiveFlowerBean;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Rolegiveflowerrank_backup;
/*     */ import xtable.Rolereceiveflowerrank;
/*     */ import xtable.Rolereceiveflowerrank_backup;
/*     */ import xtable.User;
/*     */ 
/*     */ public class FlowerPointObserver extends DateObserver
/*     */ {
/*     */   public FlowerPointObserver(int timeCommonCfgId)
/*     */   {
/*  32 */     super(timeCommonCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean onTimeOut()
/*     */   {
/*  39 */     new TimeOutPro(null).execute();
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   private static class TimeOutPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     public boolean processImp() throws Exception
/*     */     {
/*  48 */       long cur = DateTimeUtils.getCurrTimeInMillis() + TimeUnit.MINUTES.toMillis(1L);
/*  49 */       Calendar cal = DateTimeUtils.getCalendar();
/*  50 */       cal.setTimeInMillis(cur);
/*  51 */       cal.set(14, 0);
/*  52 */       cal.set(13, 0);
/*  53 */       cal.set(12, 0);
/*  54 */       long cleartime = cal.getTimeInMillis();
/*     */       
/*  56 */       long key = GameServerInfoManager.getLocalId();
/*  57 */       Lockeys.lock(xtable.Rolegiveflowerrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*  58 */       Lockeys.lock(Rolereceiveflowerrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */       
/*  60 */       RoleGiveFlowerRank xGiveFlowerRank = Rolegiveflowerrank_backup.get(Long.valueOf(key));
/*  61 */       RoleGiveFlowerRank xGiveFlowerRank_backup = Rolegiveflowerrank_backup.get(Long.valueOf(key));
/*  62 */       if (xGiveFlowerRank_backup == null)
/*     */       {
/*  64 */         xGiveFlowerRank_backup = Pod.newRoleGiveFlowerRank();
/*  65 */         Rolegiveflowerrank_backup.insert(Long.valueOf(key), xGiveFlowerRank_backup);
/*     */       }
/*  67 */       xGiveFlowerRank_backup.getRankdatas().clear();
/*  68 */       if (xGiveFlowerRank != null)
/*     */       {
/*  70 */         xGiveFlowerRank_backup.setVersion(xGiveFlowerRank.getVersion());
/*     */       }
/*     */       
/*  73 */       Set<Long> all = new HashSet();
/*  74 */       List<RoleGiveFlowerChart> giveCharts = GiveFlowerRankManager.getInstance().getAllChartObjs();
/*  75 */       for (int i = 0; i < giveCharts.size(); i++)
/*     */       {
/*  77 */         long roleid = ((RoleGiveFlowerChart)giveCharts.get(i)).getRoleid();
/*  78 */         int point = ((RoleGiveFlowerChart)giveCharts.get(i)).getGivePoint();
/*  79 */         RoleGiveFlowerBean xRoleGiveFlowerBean = Pod.newRoleGiveFlowerBean();
/*  80 */         xRoleGiveFlowerBean.setRoleid(roleid);
/*  81 */         xRoleGiveFlowerBean.setPoint(point);
/*  82 */         xGiveFlowerRank_backup.getRankdatas().add(xRoleGiveFlowerBean);
/*     */         
/*  84 */         all.add(Long.valueOf(roleid));
/*     */         
/*  86 */         NoneRealTimeTaskManager.getInstance().addTask(new FlowerPointObserver.AwardProcedure(roleid, i, 5, point));
/*     */       }
/*     */       
/*  89 */       RoleReceivceFlowerRank xRoleReceivceFlowerRank = Rolereceiveflowerrank.get(Long.valueOf(key));
/*  90 */       RoleReceivceFlowerRank xRoleReceivceFlowerRank_backup = Rolereceiveflowerrank_backup.get(Long.valueOf(key));
/*  91 */       if (xRoleReceivceFlowerRank_backup == null)
/*     */       {
/*  93 */         xRoleReceivceFlowerRank_backup = Pod.newRoleReceivceFlowerRank();
/*  94 */         Rolereceiveflowerrank_backup.insert(Long.valueOf(key), xRoleReceivceFlowerRank_backup);
/*     */       }
/*  96 */       xRoleReceivceFlowerRank_backup.getRankdatas().clear();
/*  97 */       if (xRoleReceivceFlowerRank != null)
/*     */       {
/*  99 */         xRoleReceivceFlowerRank_backup.setVersion(xRoleReceivceFlowerRank.getVersion());
/*     */       }
/*     */       
/* 102 */       List<RoleReceiveFlowerChart> receiveCharts = ReceiveFlowerRankManager.getInstance().getAllChartObjs();
/*     */       
/* 104 */       for (int i = 0; i < receiveCharts.size(); i++)
/*     */       {
/* 106 */         long roleid = ((RoleReceiveFlowerChart)receiveCharts.get(i)).getRoleid();
/* 107 */         int point = ((RoleReceiveFlowerChart)receiveCharts.get(i)).getReceivePoint();
/*     */         
/* 109 */         RoleReceiveFlowerBean xRoleReceiveFlowerBean = Pod.newRoleReceiveFlowerBean();
/* 110 */         xRoleReceiveFlowerBean.setRoleid(roleid);
/* 111 */         xRoleReceiveFlowerBean.setPoint(point);
/* 112 */         xRoleReceivceFlowerRank_backup.getRankdatas().add(xRoleReceiveFlowerBean);
/*     */         
/* 114 */         all.add(Long.valueOf(roleid));
/* 115 */         NoneRealTimeTaskManager.getInstance().addTask(new FlowerPointObserver.AwardProcedure(roleid, i, 6, point));
/*     */       }
/*     */       
/*     */ 
/* 119 */       new FlowerPointObserver.SetFlowerRefreshTimePro(cleartime).execute();
/*     */       
/* 121 */       all.addAll(OnlineManager.getInstance().getAllRolesInWorld());
/* 122 */       for (Long roleId : all)
/*     */       {
/* 124 */         NoneRealTimeTaskManager.getInstance().addTask(new FlowerPointObserver.POnFlowerPointObserverTimeout(roleId.longValue(), cleartime));
/*     */       }
/*     */       
/* 127 */       new FlowerPointObserver.ClearGiveFlowerRank(null).execute();
/* 128 */       new FlowerPointObserver.ClearReceiveFlowerRank(null).execute();
/* 129 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class AwardProcedure extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     private final int chartType;
/*     */     private final int point;
/*     */     
/*     */     public AwardProcedure(long roleid, int rank, int chartType, int point)
/*     */     {
/* 142 */       this.roleid = roleid;
/* 143 */       this.rank = rank;
/* 144 */       this.chartType = chartType;
/* 145 */       this.point = point;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 151 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 152 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 153 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/* 155 */       if (this.chartType == 5)
/*     */       {
/* 157 */         ItemGiveManager.tlogGiveFlowerRank(this.roleid, this.rank + 1, this.point);
/* 158 */         if (ItemGiveManager.isGiveFlowerRankAwardSwitchOpenForRole(this.roleid))
/*     */         {
/* 160 */           RankInterface.sendChartAward(userid, this.roleid, this.chartType, this.rank);
/*     */           
/* 162 */           String logstr = String.format("[flower]AwardProcedure.processImp@send flower award to role|roleid=%d|chart_type=%d|rank=%d|point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.rank), Integer.valueOf(this.point) });
/*     */           
/*     */ 
/* 165 */           ItemManager.logger.info(logstr);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 170 */           String logstr = String.format("[flower]AwardProcedure.processImp@give flower switch is closed for role|roleid=%d|chart_type=%d|rank=%d|point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.rank), Integer.valueOf(this.point) });
/*     */           
/*     */ 
/* 173 */           ItemManager.logger.info(logstr);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 178 */         ItemGiveManager.tlogReceiveFlowerRank(this.roleid, this.rank + 1, this.point);
/* 179 */         if (ItemGiveManager.isReceiveFlowerRankAwardSwitchOpenForRole(this.roleid))
/*     */         {
/* 181 */           RankInterface.sendChartAward(userid, this.roleid, this.chartType, this.rank);
/*     */           
/* 183 */           String logstr = String.format("[flower]AwardProcedure.processImp@send flower award to role|roleid=%d|chart_type=%d|rank=%d|point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.rank), Integer.valueOf(this.point) });
/*     */           
/*     */ 
/* 186 */           ItemManager.logger.info(logstr);
/*     */         }
/*     */         else
/*     */         {
/* 190 */           String logstr = String.format("[flower]AwardProcedure.processImp@receive flower switch is closed for role|roleid=%d|chart_type=%d|rank=%d|point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.rank), Integer.valueOf(this.point) });
/*     */           
/*     */ 
/* 193 */           ItemManager.logger.info(logstr);
/*     */         }
/*     */       }
/* 196 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class POnFlowerPointObserverTimeout
/*     */     extends LogicProcedure
/*     */   {
/*     */     private long roleid;
/*     */     private long cleartime;
/*     */     
/*     */     POnFlowerPointObserverTimeout(long roleid, long cleartime)
/*     */     {
/* 208 */       this.roleid = roleid;
/* 209 */       this.cleartime = cleartime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 215 */       xbean.FlowerPoint flowerPoint = xtable.Role2flowerpoint.get(Long.valueOf(this.roleid));
/* 216 */       if (flowerPoint == null)
/*     */       {
/* 218 */         return false;
/*     */       }
/* 220 */       ItemGiveManager.clearFlowerPoint(this.roleid, flowerPoint, this.cleartime);
/* 221 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class SetFlowerRefreshTimePro extends LogicProcedure
/*     */   {
/*     */     private final long cleartime;
/*     */     
/*     */     public SetFlowerRefreshTimePro(long cleartime)
/*     */     {
/* 231 */       this.cleartime = cleartime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 237 */       ItemGiveManager.setFlowerrefreshtime(this.cleartime);
/* 238 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ClearGiveFlowerRank
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 247 */       GiveFlowerRankManager.getInstance().clear();
/* 248 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ClearReceiveFlowerRank
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 257 */       ReceiveFlowerRankManager.getInstance().clear();
/* 258 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\FlowerPointObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
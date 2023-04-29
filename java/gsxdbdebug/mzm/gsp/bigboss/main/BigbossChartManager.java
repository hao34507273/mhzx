/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*     */ import mzm.gsp.bigboss.confbean.SOcp2ChartType;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BigBoss;
/*     */ 
/*     */ public class BigbossChartManager
/*     */ {
/*  29 */   private static volatile BigbossChartManager instance = null;
/*  30 */   private final Map<Integer, BigBossRankManager> ocp2RankManager = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static BigbossChartManager getInstance()
/*     */   {
/*  38 */     if (instance == null)
/*     */     {
/*  40 */       synchronized (BigbossChartManager.class)
/*     */       {
/*  42 */         if (instance == null)
/*     */         {
/*  44 */           instance = new BigbossChartManager();
/*     */         }
/*     */       }
/*     */     }
/*  48 */     return instance;
/*     */   }
/*     */   
/*     */   void initBigbossOcpRankManger()
/*     */   {
/*  53 */     for (Iterator i$ = SOcp2ChartType.getAll().keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*     */       
/*  55 */       this.ocp2RankManager.put(Integer.valueOf(ocp), new BigBossRankManager(SOcp2ChartType.get(ocp).charttype, ocp));
/*     */     }
/*     */   }
/*     */   
/*     */   BigBossRankManager getBigBossRankManager(int ocp)
/*     */   {
/*  61 */     return (BigBossRankManager)this.ocp2RankManager.get(Integer.valueOf(ocp));
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
/*     */   List<RoleBigBossChart> getRankDatasFromstartpos(int ocp, int startpos, int num)
/*     */   {
/*  74 */     BigBossRankManager bigBossRankManager = getBigBossRankManager(ocp);
/*  75 */     if (bigBossRankManager == null)
/*     */     {
/*  77 */       return null;
/*     */     }
/*     */     
/*  80 */     return bigBossRankManager.getRankObjs(startpos - 1, startpos + num - 2);
/*     */   }
/*     */   
/*     */   void rank(int ocp, long roleid, int winpoint)
/*     */   {
/*  85 */     BigBossRankManager bigBossRankManager = getBigBossRankManager(ocp);
/*  86 */     if (bigBossRankManager == null)
/*     */     {
/*  88 */       return;
/*     */     }
/*     */     
/*  91 */     RoleBigBossChart roleBigbossChart = new RoleBigBossChart(roleid, winpoint);
/*  92 */     bigBossRankManager.rank(roleBigbossChart);
/*     */   }
/*     */   
/*     */   int getRank(int ocp, long roleid)
/*     */   {
/*  97 */     BigBossRankManager bigBossRankManager = getBigBossRankManager(ocp);
/*  98 */     if (bigBossRankManager == null)
/*     */     {
/* 100 */       return -1;
/*     */     }
/*     */     
/* 103 */     return bigBossRankManager.getRank(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */   void offerAwardRole()
/*     */   {
/* 109 */     for (BigBossRankManager bigBossRankManager : this.ocp2RankManager.values())
/*     */     {
/* 111 */       List<RoleBigBossChart> roleids = bigBossRankManager.getAllChartObjs();
/* 112 */       index = 1;
/* 113 */       ocp = bigBossRankManager.getOcp();
/* 114 */       for (RoleBigBossChart roleBigBossChart : roleids)
/*     */       {
/* 116 */         long roleid = roleBigBossChart.getRoleid();
/* 117 */         int i = index;
/* 118 */         String log = String.format("[bigboss]BigbossManager.onActivityEnd@offer award to role|ocp=%d|roleid=%d|rank=%d", new Object[] { Integer.valueOf(ocp), Long.valueOf(roleid), Integer.valueOf(i) });
/*     */         
/* 120 */         BigbossManager.logger.info(log);
/* 121 */         NoneRealTimeTaskManager.getInstance().addTask(new OfferAwardToRole(ocp, roleid, i));
/* 122 */         index++;
/*     */       }
/*     */     }
/*     */     int index;
/*     */     int ocp;
/*     */   }
/*     */   
/*     */   private static class OfferAwardToRole extends LogicProcedure {
/*     */     private final int ocp;
/*     */     private final long roleid;
/*     */     private final int i;
/*     */     
/*     */     public OfferAwardToRole(int ocp, long roleid, int i) {
/* 135 */       this.ocp = ocp;
/* 136 */       this.roleid = roleid;
/* 137 */       this.i = i;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 143 */       if (GameServerInfoManager.isRoamServer())
/*     */       {
/* 145 */         String logstr = String.format("[bigboss]OfferAwardToRole.processImp@roam server can not get award|ocp=%d|roleid=%d|rank=%d", new Object[] { Integer.valueOf(this.ocp), Long.valueOf(this.roleid), Integer.valueOf(this.i) });
/*     */         
/*     */ 
/* 148 */         BigbossManager.logger.info(logstr);
/* 149 */         return false;
/*     */       }
/* 151 */       String logstr = String.format("[bigboss]OfferAwardToRole.processImp@offer award to role|ocp=%d|roleid=%d|rank=%d", new Object[] { Integer.valueOf(this.ocp), Long.valueOf(this.roleid), Integer.valueOf(this.i) });
/*     */       
/* 153 */       BigbossManager.logger.info(logstr);
/*     */       
/* 155 */       BigBoss bigBoss = BigbossManager.getBigboss(this.roleid, true);
/* 156 */       if (bigBoss == null)
/*     */       {
/* 158 */         return false;
/*     */       }
/* 160 */       bigBoss.setRank(this.i);
/* 161 */       int roleOcp = RoleInterface.getOccupationId(this.roleid);
/* 162 */       int mailid = SBigbossCfgConsts.getInstance().MAILID;
/* 163 */       int rewardid = BigbossManager.getRewardIdByRank(this.i);
/* 164 */       if ((mailid != -1) && (rewardid != -1))
/*     */       {
/* 166 */         AwardModel model = AwardInterface.getRoleAwardModel(rewardid, this.roleid, -1, new AwardReason(LogReason.BIGBOSS_ACTIVITY_REWARD_ADD, rewardid));
/*     */         
/* 168 */         if (model != null)
/*     */         {
/* 170 */           MailAttachment attachment = AwardInterface.getMailAttachmentBy(model);
/*     */           
/* 172 */           List<String> contentArgs = new ArrayList();
/* 173 */           contentArgs.add(String.valueOf(this.i));
/* 174 */           TLogArg logArg = new TLogArg(LogReason.BIGBOSS_ACTIVITY_REWARD_ADD, rewardid);
/* 175 */           mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.roleid, mailid, new ArrayList(), contentArgs, attachment, logArg);
/* 176 */           String log = String.format("[bigboss]OfferAwardToRole.processImp@offer award to role success|ocp=%d|roleid=%d|rank=%d|rewardid=%d|role_ocp=%d", new Object[] { Integer.valueOf(this.ocp), Long.valueOf(this.roleid), Integer.valueOf(this.i), Integer.valueOf(rewardid), Integer.valueOf(roleOcp) });
/*     */           
/*     */ 
/* 179 */           BigbossManager.logger.info(log);
/*     */           
/*     */ 
/*     */ 
/* 183 */           if (model.getAppellationId() > 0)
/*     */           {
/* 185 */             TitleInterface.addAppellation(this.roleid, model.getAppellationId(), true);
/*     */           }
/*     */           
/* 188 */           if (model.getTitleId() > 0)
/*     */           {
/* 190 */             TitleInterface.addTitle(this.roleid, model.getTitleId());
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 196 */           String log = String.format("[bigboss]OfferAwardToRole.processImp@offer award to role error,AwardModel null|ocp=%d|roleid=%d|rank=%d|rewardid=%d|role_ocp=%d", new Object[] { Integer.valueOf(this.ocp), Long.valueOf(this.roleid), Integer.valueOf(this.i), Integer.valueOf(rewardid), Integer.valueOf(roleOcp) });
/*     */           
/*     */ 
/* 199 */           BigbossManager.logger.error(log);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 204 */       bigBoss.setIsawarded(true);
/*     */       
/* 206 */       if (this.i <= SBigbossCfgConsts.getInstance().MIN_RANK_FOR_BULLETIN)
/*     */       {
/* 208 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 209 */         bulletinInfo.bulletintype = 21;
/* 210 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleid));
/* 211 */         bulletinInfo.params.put(Integer.valueOf(19), String.valueOf(this.i));
/* 212 */         BulletinInterface.sendBulletin(bulletinInfo);
/*     */       }
/*     */       
/* 215 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   void removeRoleFromAllRank(long roleid)
/*     */   {
/* 221 */     for (BigBossRankManager bigBossRankManager : this.ocp2RankManager.values())
/*     */     {
/* 223 */       bigBossRankManager.delete(Long.valueOf(roleid));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void clear()
/*     */   {
/* 230 */     for (Iterator i$ = this.ocp2RankManager.keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*     */       
/* 232 */       new ClearChartPro(ocp).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ClearChartPro extends LogicProcedure
/*     */   {
/*     */     private final int ocp;
/*     */     
/*     */     public ClearChartPro(int ocp)
/*     */     {
/* 242 */       this.ocp = ocp;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 248 */       BigBossRankManager bigBossRankManager = BigbossChartManager.getInstance().getBigBossRankManager(this.ocp);
/* 249 */       if (bigBossRankManager != null)
/*     */       {
/* 251 */         bigBossRankManager.clear();
/*     */       }
/* 253 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigbossChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
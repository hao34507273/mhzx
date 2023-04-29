/*     */ package mzm.gsp.qmhw.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.map.main.CloneRoleNpcModelType;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qmhw.SBrocastGetTitleRoles;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWRoleNpcCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.QMHWActivity;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PQMHWEndResult extends LogicProcedure
/*     */ {
/*     */   private final long worldid;
/*     */   private final boolean worldRight;
/*     */   
/*     */   public PQMHWEndResult(long worldid, boolean worldRight)
/*     */   {
/*  29 */     this.worldid = worldid;
/*  30 */     this.worldRight = worldRight;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     QMHWActivity xQmhwActivity = QMHWManager.getXQmhwCreateIfNotExist();
/*     */     
/*  38 */     if (xQmhwActivity.getHandleresult() == 2) {
/*  39 */       return false;
/*     */     }
/*  41 */     xQmhwActivity.setHandleresult(2);
/*  42 */     if (this.worldRight)
/*     */     {
/*  44 */       List<Long> roleids = MapInterface.getRoleList(this.worldid);
/*  45 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  46 */         MapInterface.forceTransferToScene(roleid, MapInterface.getBigWorldid(), SQMHWCfgConsts.getInstance().OUT_MAP_ID);
/*     */       }
/*     */       
/*     */ 
/*  50 */       MapInterface.destroyWorld(this.worldid);
/*     */     }
/*     */     
/*  53 */     final List<Long> getTitleRoles = new ArrayList();
/*     */     
/*  55 */     for (SQMHWRoleNpcCfg qmhwRoleNpcCfg : SQMHWRoleNpcCfg.getAll().values())
/*     */     {
/*  57 */       MapInterface.unsetCloneRoleNpcModelAsync(CloneRoleNpcModelType.QI_MAI_HUI_WU, qmhwRoleNpcCfg.npcid);
/*  58 */       int rank = qmhwRoleNpcCfg.rank;
/*  59 */       QMHWChartObj qmhwChartObj = (QMHWChartObj)QMHWChart.getInstance().getRankObj(rank - 1);
/*  60 */       if (qmhwChartObj != null) {
/*  61 */         long roleid = qmhwChartObj.getRoleid();
/*  62 */         getTitleRoles.add(Long.valueOf(roleid));
/*     */         
/*  64 */         TitleInterface.addAppellationNoneRealTime(roleid, qmhwRoleNpcCfg.titleid, true);
/*     */         
/*  66 */         List<String> contentArgs = new ArrayList();
/*  67 */         contentArgs.add(String.valueOf(qmhwRoleNpcCfg.rank));
/*  68 */         mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(roleid, SQMHWCfgConsts.getInstance().NOTIFY_MAIL_ID, new ArrayList(), contentArgs, new TLogArg(mzm.gsp.tlog.LogReason.QMHW_RANK_MAIL_AWARD, rank));
/*     */         
/*     */ 
/*  71 */         MapInterface.setCloneRoleNpcModelAsyc(CloneRoleNpcModelType.QI_MAI_HUI_WU, roleid, qmhwRoleNpcCfg.npcid, qmhwRoleNpcCfg.titleid);
/*     */       }
/*     */     }
/*     */     
/*  75 */     int awardRank = RankInterface.getAwardRank(14);
/*  76 */     if (awardRank >= 0) {
/*  77 */       List<QMHWChartObj> qmhwChartObjs = QMHWChart.getInstance().getRankObjs(0, awardRank);
/*  78 */       for (int i = 0; i < qmhwChartObjs.size(); i++) {
/*  79 */         QMHWChartObj qmhwChartObj = (QMHWChartObj)qmhwChartObjs.get(i);
/*  80 */         NoneRealTimeTaskManager.getInstance().addTask(new QMHWChartAward(qmhwChartObj.roleid, i));
/*     */       }
/*     */     }
/*  83 */     if (getTitleRoles.size() > 0)
/*     */     {
/*  85 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/*  89 */           SBrocastGetTitleRoles brocastGetTitleRoles = new SBrocastGetTitleRoles();
/*  90 */           for (Iterator i$ = getTitleRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  91 */             brocastGetTitleRoles.rolename.add(RoleInterface.getName(roleid));
/*     */           }
/*  93 */           OnlineManager.getInstance().sendAll(brocastGetTitleRoles);
/*  94 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private static final class QMHWChartAward extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     
/*     */     QMHWChartAward(long roleid, int rank) {
/* 107 */       this.roleid = roleid;
/* 108 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 113 */       String userid = RoleInterface.getUserId(this.roleid);
/* 114 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 115 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 116 */       RankInterface.sendChartAward(userid, this.roleid, 14, this.rank);
/* 117 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PQMHWEndResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.SCakeContentCfg;
/*     */ import mzm.gsp.cake.CakeHistory;
/*     */ import mzm.gsp.cake.SSynCakeHistory;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CakeDetailData;
/*     */ import xbean.CakeHistoryData;
/*     */ import xbean.FactionCakeData;
/*     */ 
/*     */ public class PCCheckCakeHistoryReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final long factionId;
/*     */   private final long checkRoleId;
/*     */   
/*     */   public PCCheckCakeHistoryReq(long roleId, int activityId, long factionId, long checkRoleId)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.activityId = activityId;
/*  35 */     this.factionId = factionId;
/*  36 */     this.checkRoleId = checkRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/*  43 */     if (activityCfg == null)
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if ((!ActivityInterface.isActivityOpen(this.activityId)) || (!OpenInterface.getOpenStatus(activityCfg.switchId)))
/*     */     {
/*     */ 
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     FactionCakeData xFactionCakeData = CakeManager.getXFactionCakeData(this.factionId, this.activityId);
/*  54 */     if (xFactionCakeData == null)
/*     */     {
/*  56 */       CakeManager.loggerError("PCCheckCakeHistoryReq.processImp@ xFactionCakeData is null!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(this.factionId) });
/*     */       
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     List<CakeHistory> historyList = getCakeHistoryList(xFactionCakeData);
/*  63 */     SSynCakeHistory p = new SSynCakeHistory();
/*  64 */     p.activityid = this.activityId;
/*  65 */     p.factionid = this.factionId;
/*  66 */     p.roleid = this.checkRoleId;
/*  67 */     p.history.addAll(historyList);
/*  68 */     OnlineManager.getInstance().send(this.roleId, p);
/*     */     
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   private List<CakeHistory> getCakeHistoryList(FactionCakeData xFactionCakeData)
/*     */   {
/*  75 */     CakeDetailData xCakeDetailData = (CakeDetailData)xFactionCakeData.getRolecakes().get(Long.valueOf(this.checkRoleId));
/*  76 */     if (xCakeDetailData == null)
/*     */     {
/*  78 */       CakeManager.loggerError("PCCheckCakeHistoryReq.getCakeHistoryList@ xCakeDetailData is null!|roleId=%d|activityId=%d|factionId=%d|checkRoleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(this.factionId), Long.valueOf(this.checkRoleId) });
/*     */       
/*     */ 
/*  81 */       return Collections.emptyList();
/*     */     }
/*  83 */     return getPCakeHistory(xCakeDetailData);
/*     */   }
/*     */   
/*     */   List<CakeHistory> getPCakeHistory(CakeDetailData xCakeDetailData)
/*     */   {
/*  88 */     if (xCakeDetailData.getHistory().isEmpty())
/*     */     {
/*     */ 
/*  91 */       return Collections.emptyList();
/*     */     }
/*  93 */     List<CakeHistory> historyList = new ArrayList();
/*  94 */     for (CakeHistoryData xCakeHistoryData : xCakeDetailData.getHistory())
/*     */     {
/*  96 */       CakeHistory pCakeHistory = new CakeHistory();
/*  97 */       pCakeHistory.historytype = xCakeHistoryData.getHistorytype();
/*  98 */       pCakeHistory.itemid = xCakeHistoryData.getItemid();
/*  99 */       pCakeHistory.recordtime = TimeUnit.MILLISECONDS.toSeconds(xCakeHistoryData.getTimeline());
/* 100 */       pCakeHistory.orgrank = (xCakeHistoryData.getBeforecakeid() > 0 ? getCakeRank(xCakeHistoryData.getBeforecakeid()) : 0);
/* 101 */       pCakeHistory.newrank = (xCakeHistoryData.getAftercakeid() > 0 ? getCakeRank(xCakeHistoryData.getAftercakeid()) : 0);
/*     */       try
/*     */       {
/* 104 */         pCakeHistory.makerolename.setString(xCakeHistoryData.getOperrolename(), "UTF-8");
/* 105 */         pCakeHistory.mastername.setString(xCakeHistoryData.getMastername(), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/*     */ 
/* 111 */       historyList.add(pCakeHistory);
/*     */     }
/* 113 */     return historyList;
/*     */   }
/*     */   
/*     */   int getCakeRank(int cakeId)
/*     */   {
/* 118 */     SCakeContentCfg cfg = SCakeContentCfg.get(cakeId);
/* 119 */     if (cfg == null)
/*     */     {
/* 121 */       return 0;
/*     */     }
/* 123 */     return cfg.range;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PCCheckCakeHistoryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
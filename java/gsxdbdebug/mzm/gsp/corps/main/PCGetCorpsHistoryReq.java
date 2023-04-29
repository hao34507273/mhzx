/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.CorpsHistoryInfo;
/*     */ import mzm.gsp.corps.SGetCorpsHistoryRep;
/*     */ import mzm.gsp.corps.confbean.SCorpsHistoryCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsHistory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetCorpsHistoryReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long corpsId;
/*     */   private final int fromHistoryId;
/*     */   private final int step;
/*     */   
/*     */   public PCGetCorpsHistoryReq(long roleId, long corpsId, int from, int step)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.corpsId = corpsId;
/*  31 */     this.fromHistoryId = from;
/*  32 */     this.step = step;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if ((this.fromHistoryId < 0) || (this.step <= 0))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(this.corpsId));
/*  44 */     if (xCorps == null)
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[corps]PCGetCorpsHistoryReq.processImp@ not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.corpsId) }));
/*     */       
/*     */ 
/*  49 */       return false;
/*     */     }
/*  51 */     CorpsManager.checkAndSetHistoryId(xCorps);
/*     */     
/*  53 */     SGetCorpsHistoryRep rep = new SGetCorpsHistoryRep();
/*  54 */     fillPHistory(xCorps, rep.historylist);
/*  55 */     rep.corpsid = this.corpsId;
/*  56 */     rep.start = this.fromHistoryId;
/*  57 */     OnlineManager.getInstance().send(this.roleId, rep);
/*     */     
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   private void fillPHistory(xbean.Corps xCorps, List<CorpsHistoryInfo> historyInfos)
/*     */   {
/*  64 */     List<CorpsHistory> xHistories = xCorps.getHistorylist();
/*  65 */     int size = xHistories.size();
/*  66 */     if (size <= 0)
/*     */     {
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     List<CorpsHistory> subList = new ArrayList();
/*  72 */     if (this.fromHistoryId == 0)
/*     */     {
/*     */ 
/*  75 */       subList.addAll(xHistories.subList(Math.max(0, size - this.step), size));
/*     */     }
/*     */     else
/*     */     {
/*  79 */       int endIndex = getHistoryIdIndex(xHistories, this.fromHistoryId);
/*  80 */       if (endIndex >= size)
/*     */       {
/*  82 */         endIndex = size;
/*     */       }
/*  84 */       subList.addAll(xHistories.subList(Math.max(0, endIndex - this.step), endIndex));
/*     */     }
/*  86 */     if (subList.size() == 0)
/*     */     {
/*  88 */       return;
/*     */     }
/*     */     
/*     */ 
/*  92 */     for (int i = subList.size() - 1; i >= 0; i--)
/*     */     {
/*  94 */       CorpsHistory xEach = (CorpsHistory)subList.get(i);
/*  95 */       historyInfos.add(getEachHistoryRecord(xEach));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getHistoryIdIndex(List<CorpsHistory> xHistories, int fromHistoryId)
/*     */   {
/* 108 */     int index = xHistories.size();
/*     */     
/* 110 */     for (int tmpIndex = 0; tmpIndex < xHistories.size(); tmpIndex++)
/*     */     {
/* 112 */       CorpsHistory xCorpsHistory = (CorpsHistory)xHistories.get(tmpIndex);
/* 113 */       int xHistoryId = xCorpsHistory.getHistoryid();
/* 114 */       if (xHistoryId == fromHistoryId)
/*     */       {
/* 116 */         index = tmpIndex;
/* 117 */         break;
/*     */       }
/* 119 */       if (xHistoryId > fromHistoryId)
/*     */       {
/* 121 */         index = tmpIndex;
/* 122 */         break;
/*     */       }
/*     */     }
/* 125 */     return index;
/*     */   }
/*     */   
/*     */   private CorpsHistoryInfo getEachHistoryRecord(CorpsHistory xCorpsOneHistory)
/*     */   {
/* 130 */     CorpsHistoryInfo pHistoryInfo = new CorpsHistoryInfo();
/* 131 */     pHistoryInfo.historytype = xCorpsOneHistory.getHistorytype();
/* 132 */     pHistoryInfo.recordtime = xCorpsOneHistory.getRecordtime();
/* 133 */     pHistoryInfo.historyid = xCorpsOneHistory.getHistoryid();
/* 134 */     for (String arg : xCorpsOneHistory.getParameters())
/*     */     {
/* 136 */       Octets octets = new Octets();
/*     */       try
/*     */       {
/* 139 */         octets.setString(arg, "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/*     */ 
/* 145 */       pHistoryInfo.parameters.add(octets);
/*     */     }
/* 147 */     showHistory(xCorpsOneHistory);
/* 148 */     return pHistoryInfo;
/*     */   }
/*     */   
/*     */   private void showHistory(CorpsHistory xCorpsOneHistory)
/*     */   {
/* 153 */     if (!GameServer.logger().isDebugEnabled())
/*     */     {
/* 155 */       return;
/*     */     }
/* 157 */     List<String> argStrings = new ArrayList(xCorpsOneHistory.getParameters());
/* 158 */     SCorpsHistoryCfg cfg = SCorpsHistoryCfg.get(xCorpsOneHistory.getHistorytype());
/* 159 */     if (cfg == null)
/*     */     {
/* 161 */       GameServer.logger().error(String.format("[corps]PCGetCorpsHistoryReq.showHistory@ type illegal!|type=%d", new Object[] { Integer.valueOf(xCorpsOneHistory.getHistorytype()) }));
/*     */       
/*     */ 
/* 164 */       return;
/*     */     }
/* 166 */     GameServer.logger().info(cfg.historyDescribe + "{" + argStrings + "}");
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCGetCorpsHistoryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
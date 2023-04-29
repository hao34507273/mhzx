/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.QueryAllPrizeRsp;
/*     */ import idip.SMailInfo1;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.compensate.main.CompensateInfo;
/*     */ import mzm.gsp.compensate.main.CompensateInterface;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QueryGlobalMailHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  23 */     int tagid = Integer.parseInt((String)params.get(0));
/*  24 */     int page = Integer.parseInt((String)params.get(1));
/*     */     
/*  26 */     if (page <= 0)
/*     */     {
/*  28 */       int retcode = Retcode.QUERY_GLOBAL_MAIL_PAGE_INVALID.value;
/*  29 */       rsp.retcode = retcode;
/*  30 */       Response response = IdipGmtUtil.getResponse(retcode, "page invalid");
/*  31 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  33 */       GameServer.logger().error(String.format("[gmt]QueryGlobalMailHandler.execute@page invalid|tagid=%d|page=%d", new Object[] { Integer.valueOf(tagid), Integer.valueOf(page) }));
/*     */       
/*  35 */       return;
/*     */     }
/*     */     
/*  38 */     QueryAllPrizeRsp queryAllPrizeRsp = new QueryAllPrizeRsp();
/*     */     
/*  40 */     List<CompensateInfo> compensateInfos = CompensateInterface.getCompensates();
/*  41 */     int length = compensateInfos.size();
/*  42 */     if (length > 0)
/*     */     {
/*  44 */       int pageSize = 10;
/*  45 */       if (tagid > 0)
/*     */       {
/*  47 */         Iterator<CompensateInfo> it = compensateInfos.iterator();
/*  48 */         List<CompensateInfo> filters = new ArrayList();
/*  49 */         while (it.hasNext())
/*     */         {
/*  51 */           CompensateInfo compensateInfo = (CompensateInfo)it.next();
/*  52 */           if (compensateInfo.getTag() == tagid)
/*     */           {
/*     */ 
/*     */ 
/*  56 */             filters.add(compensateInfo); }
/*     */         }
/*  58 */         fillMailInfos(queryAllPrizeRsp.MailList, filters, page, 10);
/*  59 */         queryAllPrizeRsp.TotalPageNo = ((filters.size() + 10 - 1) / 10);
/*     */       }
/*     */       else
/*     */       {
/*  63 */         fillMailInfos(queryAllPrizeRsp.MailList, compensateInfos, page, 10);
/*  64 */         queryAllPrizeRsp.TotalPageNo = ((length + 10 - 1) / 10);
/*     */       }
/*     */     }
/*     */     
/*  68 */     queryAllPrizeRsp.MailList_count = queryAllPrizeRsp.MailList.size();
/*     */     
/*  70 */     rsp.retcode = Retcode.SUCCESS.value;
/*  71 */     Response response = new Response();
/*  72 */     response.data = queryAllPrizeRsp;
/*  73 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/*  75 */     GameServer.logger().info(String.format("[gmt]QueryGlobalMailHandler.execute@query global mail success|tagid=%d|page=%d", new Object[] { Integer.valueOf(tagid), Integer.valueOf(page) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void fillMailInfos(List<SMailInfo1> target, List<CompensateInfo> compensateInfos, int page, int pageSize)
/*     */   {
/*  82 */     int length = compensateInfos.size();
/*  83 */     int fromIndex = pageSize * (page - 1);
/*  84 */     if (fromIndex >= length)
/*     */     {
/*  86 */       return;
/*     */     }
/*  88 */     int endIndex = fromIndex + pageSize;
/*  89 */     if (endIndex > length)
/*     */     {
/*  91 */       endIndex = length;
/*     */     }
/*  93 */     for (int i = fromIndex; i < endIndex; i++)
/*     */     {
/*  95 */       CompensateInfo compensateInfo = (CompensateInfo)compensateInfos.get(i);
/*  96 */       target.add(buildMailInfo(compensateInfo));
/*     */     }
/*     */   }
/*     */   
/*     */   private SMailInfo1 buildMailInfo(CompensateInfo compensateInfo)
/*     */   {
/* 102 */     SMailInfo1 result = new SMailInfo1();
/* 103 */     result.MailId = String.valueOf(compensateInfo.getId());
/* 104 */     result.TagId = compensateInfo.getTag();
/* 105 */     result.MailTitle = compensateInfo.getMailTitle();
/* 106 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryGlobalMailHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
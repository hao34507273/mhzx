/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryAllPrizeReq;
/*     */ import idip.IDIPPacket_QueryAllPrizeReq;
/*     */ import idip.IDIPPacket_QueryAllPrizeRsp;
/*     */ import idip.QueryAllPrizeReq;
/*     */ import idip.QueryAllPrizeRsp;
/*     */ import idip.SMailInfo1;
/*     */ import idip.core.IdipHeader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.compensate.main.CompensateInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryAllPrizeReq extends PIDIPCmd<IDIPCmd_QueryAllPrizeReq>
/*     */ {
/*     */   public PIDIPCmd_QueryAllPrizeReq(IDIPCmd_QueryAllPrizeReq cmd)
/*     */   {
/*  22 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  28 */     int tagid = ((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).TagId;
/*  29 */     int page = ((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).PageNo;
/*  30 */     if (page <= 0)
/*     */     {
/*  32 */       ((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.Result = 64066;
/*  33 */       ((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.RetErrMsg = "page <= 0";
/*  34 */       ((IDIPCmd_QueryAllPrizeReq)this.cmd).sendResponse();
/*     */       
/*  36 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryAllPrizeReq.handle@page invalid|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|tagid=%d|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).Partition), Integer.valueOf(tagid), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     List<CompensateInfo> compensateInfos = mzm.gsp.compensate.main.CompensateInterface.getCompensates();
/*  45 */     int length = compensateInfos.size();
/*  46 */     if (length > 0)
/*     */     {
/*  48 */       int pageSize = 10;
/*  49 */       if (tagid > 0)
/*     */       {
/*  51 */         Iterator<CompensateInfo> it = compensateInfos.iterator();
/*  52 */         List<CompensateInfo> filters = new ArrayList();
/*  53 */         while (it.hasNext())
/*     */         {
/*  55 */           CompensateInfo compensateInfo = (CompensateInfo)it.next();
/*  56 */           if (compensateInfo.getTag() == tagid)
/*     */           {
/*     */ 
/*     */ 
/*  60 */             filters.add(compensateInfo); }
/*     */         }
/*  62 */         fillMailInfos(((QueryAllPrizeRsp)((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).body).MailList, filters, page, 10);
/*  63 */         ((QueryAllPrizeRsp)((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).body).TotalPageNo = ((filters.size() + 10 - 1) / 10);
/*     */       }
/*     */       else
/*     */       {
/*  67 */         fillMailInfos(((QueryAllPrizeRsp)((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).body).MailList, compensateInfos, page, 10);
/*  68 */         ((QueryAllPrizeRsp)((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).body).TotalPageNo = ((length + 10 - 1) / 10);
/*     */       }
/*  70 */       ((QueryAllPrizeRsp)((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).body).MailList_count = ((QueryAllPrizeRsp)((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).body).MailList.size();
/*     */     }
/*     */     
/*  73 */     ((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.Result = 0;
/*  74 */     ((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.RetErrMsg = "ok";
/*  75 */     ((IDIPCmd_QueryAllPrizeReq)this.cmd).sendResponse();
/*     */     
/*  77 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryAllPrizeReq.handle@query mail list done|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|tagid=%d|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryAllPrizeRsp)((IDIPCmd_QueryAllPrizeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).Partition), Integer.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).TagId), Integer.valueOf(((QueryAllPrizeReq)((IDIPPacket_QueryAllPrizeReq)((IDIPCmd_QueryAllPrizeReq)this.cmd).req).body).PageNo) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void fillMailInfos(List<SMailInfo1> target, List<CompensateInfo> compensateInfos, int page, int pageSize)
/*     */   {
/*  89 */     int length = compensateInfos.size();
/*  90 */     int fromIndex = pageSize * (page - 1);
/*  91 */     if (fromIndex >= length)
/*     */     {
/*  93 */       return;
/*     */     }
/*  95 */     int endIndex = fromIndex + pageSize;
/*  96 */     if (endIndex > length)
/*     */     {
/*  98 */       endIndex = length;
/*     */     }
/* 100 */     for (int i = fromIndex; i < endIndex; i++)
/*     */     {
/* 102 */       CompensateInfo compensateInfo = (CompensateInfo)compensateInfos.get(i);
/* 103 */       target.add(buildMailInfo(compensateInfo));
/*     */     }
/*     */   }
/*     */   
/*     */   private SMailInfo1 buildMailInfo(CompensateInfo compensateInfo)
/*     */   {
/* 109 */     SMailInfo1 result = new SMailInfo1();
/* 110 */     result.MailId = String.valueOf(compensateInfo.getId());
/* 111 */     result.TagId = compensateInfo.getTag();
/*     */     try
/*     */     {
/* 114 */       result.MailTitle = idip.core.Utils.urlEncode1738(compensateInfo.getMailTitle(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 119 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryAllPrizeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
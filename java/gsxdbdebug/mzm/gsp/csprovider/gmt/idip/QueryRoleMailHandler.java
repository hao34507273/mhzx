/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.QueryMailRsp;
/*     */ import idip.SMailInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.mail.confbean.SMailCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MailContent;
/*     */ import xbean.MailInfo;
/*     */ 
/*     */ public class QueryRoleMailHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  26 */     String userid = (String)params.get(0);
/*  27 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  28 */     String tagid = (String)params.get(2);
/*  29 */     int page = Integer.parseInt((String)params.get(3));
/*     */     
/*  31 */     xbean.User xUser = xtable.User.get(userid);
/*  32 */     if (null == xUser)
/*     */     {
/*  34 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  35 */       rsp.retcode = retcode;
/*  36 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  37 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  39 */       GameServer.logger().error(String.format("[gmt]QueryRoleMailHandler.execute@user not found|userid=%s|roleid=%d|tagid=%s|page=%d", new Object[] { userid, Long.valueOf(roleid), tagid, Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  42 */       return;
/*     */     }
/*     */     
/*  45 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  47 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  48 */       rsp.retcode = retcode;
/*  49 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  50 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  52 */       GameServer.logger().error(String.format("[gmt]QueryRoleMailHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|tagid=%s|page=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), tagid, Integer.valueOf(page) }));
/*     */       
/*     */ 
/*     */ 
/*  56 */       return;
/*     */     }
/*     */     
/*  59 */     if (page <= 0)
/*     */     {
/*  61 */       int retcode = Retcode.QUERY_ROLE_MAIL_PAGE_INVALID.value;
/*  62 */       rsp.retcode = retcode;
/*  63 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  64 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  66 */       GameServer.logger().error(String.format("[gmt]QueryRoleMailHandler.execute@page invalid|userid=%s|roleid=%d|tagid=%s|page=%d", new Object[] { userid, Long.valueOf(roleid), tagid, Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     QueryMailRsp queryMailRsp = new QueryMailRsp();
/*  73 */     Pair<Map<Integer, MailInfo>, Integer> result = null;
/*  74 */     int pageSize = 10;
/*  75 */     if (!tagid.isEmpty())
/*     */     {
/*  77 */       result = MailInterface.queryMail(roleid, tagid, page, 10, true);
/*     */     }
/*     */     else
/*     */     {
/*  81 */       result = MailInterface.queryMail(roleid, page, 10, true);
/*     */     }
/*     */     
/*  84 */     for (Map.Entry<Integer, MailInfo> entry : ((Map)result.first).entrySet())
/*     */     {
/*  86 */       SMailInfo mailInfo = buildMailInfo(((Integer)entry.getKey()).intValue(), (MailInfo)entry.getValue());
/*  87 */       queryMailRsp.MailList.add(mailInfo);
/*     */     }
/*     */     
/*  90 */     queryMailRsp.MailList_count = queryMailRsp.MailList.size();
/*  91 */     queryMailRsp.TotalPageNo = ((((Integer)result.second).intValue() + 10 - 1) / 10);
/*     */     
/*  93 */     rsp.retcode = Retcode.SUCCESS.value;
/*  94 */     Response response = new Response();
/*  95 */     response.data = queryMailRsp;
/*  96 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/*  98 */     GameServer.logger().info(String.format("[gmt]QueryRoleMailHandler.execute@query role mail success|userid=%s|roleid=%d|tagid=%s|page=%d", new Object[] { userid, Long.valueOf(roleid), tagid, Integer.valueOf(page) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private SMailInfo buildMailInfo(int mailid, MailInfo xMailInfo)
/*     */   {
/* 106 */     SMailInfo result = new SMailInfo();
/* 107 */     if (xMailInfo.getMailcontent().getMailcontenttype() == 2)
/*     */     {
/* 109 */       String mailTitle = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(52));
/* 110 */       if (mailTitle != null)
/*     */       {
/* 112 */         result.MailTitle = mailTitle;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 117 */       String mailCfgid = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(51));
/*     */       
/* 119 */       if (mailCfgid != null)
/*     */       {
/* 121 */         int cfgid = Integer.parseInt(mailCfgid);
/* 122 */         SMailCfg mailCfg = MailInterface.getMailCfgById(cfgid);
/* 123 */         if (mailCfg != null)
/*     */         {
/* 125 */           result.MailTitle = mailCfg.title;
/*     */         }
/*     */       }
/*     */     }
/* 129 */     result.GetTime = ((int)TimeUnit.MILLISECONDS.toSeconds(xMailInfo.getCreatetime()));
/* 130 */     result.MailId = mailid;
/* 131 */     result.TagId = xMailInfo.getTagid();
/* 132 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryRoleMailHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
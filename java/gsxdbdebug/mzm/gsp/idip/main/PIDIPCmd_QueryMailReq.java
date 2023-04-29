/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryMailReq;
/*     */ import idip.IDIPPacket_QueryMailReq;
/*     */ import idip.IDIPPacket_QueryMailRsp;
/*     */ import idip.QueryMailReq;
/*     */ import idip.QueryMailRsp;
/*     */ import idip.SMailInfo;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MailContent;
/*     */ import xbean.MailInfo;
/*     */ 
/*     */ public class PIDIPCmd_QueryMailReq extends PIDIPCmd<IDIPCmd_QueryMailReq>
/*     */ {
/*     */   public PIDIPCmd_QueryMailReq(IDIPCmd_QueryMailReq cmd)
/*     */   {
/*  24 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  30 */     String openId = ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).OpenId;
/*  31 */     int areaId = ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).AreaId;
/*  32 */     int partition = ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).Partition;
/*     */     
/*  34 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  35 */     xbean.User xUser = xtable.User.get(userId);
/*  36 */     if (null == xUser)
/*     */     {
/*  38 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result = 1;
/*  39 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  40 */       ((IDIPCmd_QueryMailReq)this.cmd).sendResponse();
/*     */       
/*  42 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMailReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).TagId, Integer.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  53 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result = 1;
/*  54 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  55 */       ((IDIPCmd_QueryMailReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMailReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).TagId, Integer.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     long roleid = -1L;
/*     */     try
/*     */     {
/*  68 */       roleid = Long.parseLong(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  72 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result = 1;
/*  73 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  74 */       ((IDIPCmd_QueryMailReq)this.cmd).sendResponse();
/*     */       
/*  76 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).TagId, Integer.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  87 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result = 1;
/*  88 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  89 */       ((IDIPCmd_QueryMailReq)this.cmd).sendResponse();
/*     */       
/*  91 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).TagId, Integer.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     int page = ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PageNo;
/* 101 */     if (page == 0)
/*     */     {
/* 103 */       page = 1;
/*     */     }
/* 105 */     if (page <= 0)
/*     */     {
/* 107 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result = 64086;
/* 108 */       ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg = "page <= 0";
/* 109 */       ((IDIPCmd_QueryMailReq)this.cmd).sendResponse();
/*     */       
/* 111 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryMailReq.handle@page invalid|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).TagId, Integer.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     String tagid = ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).TagId;
/* 121 */     Pair<Map<Integer, MailInfo>, Integer> result = null;
/* 122 */     int pageSize = 10;
/* 123 */     if (!tagid.isEmpty())
/*     */     {
/* 125 */       result = mzm.gsp.mail.main.MailInterface.queryMail(roleid, tagid, page, 10, true);
/*     */     }
/*     */     else
/*     */     {
/* 129 */       result = mzm.gsp.mail.main.MailInterface.queryMail(roleid, page, 10, true);
/*     */     }
/*     */     
/* 132 */     for (Map.Entry<Integer, MailInfo> entry : ((Map)result.first).entrySet())
/*     */     {
/* 134 */       SMailInfo mailInfo = buildMailInfo(((Integer)entry.getKey()).intValue(), (MailInfo)entry.getValue());
/* 135 */       ((QueryMailRsp)((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).body).MailList.add(mailInfo);
/*     */     }
/* 137 */     ((QueryMailRsp)((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).body).MailList_count = ((QueryMailRsp)((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).body).MailList.size();
/* 138 */     ((QueryMailRsp)((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).body).TotalPageNo = ((((Integer)result.second).intValue() + 10 - 1) / 10);
/* 139 */     ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result = 0;
/* 140 */     ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 141 */     ((IDIPCmd_QueryMailReq)this.cmd).sendResponse();
/*     */     
/* 143 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryMailReq.handle@query mail list done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|page=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryMailRsp)((IDIPCmd_QueryMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId, tagid, Integer.valueOf(((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).PageNo) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   private SMailInfo buildMailInfo(int mailid, MailInfo xMailInfo)
/*     */   {
/* 154 */     SMailInfo result = new SMailInfo();
/* 155 */     if (xMailInfo.getMailcontent().getMailcontenttype() == 2)
/*     */     {
/* 157 */       String mailTitle = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(52));
/* 158 */       if (mailTitle != null)
/*     */       {
/*     */         try
/*     */         {
/* 162 */           result.MailTitle = Utils.urlEncode1738(mailTitle, "UTF-8");
/*     */ 
/*     */         }
/*     */         catch (UnsupportedEncodingException e) {}
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 171 */       String mailCfgid = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(51));
/*     */       
/* 173 */       if (mailCfgid != null)
/*     */       {
/* 175 */         int cfgid = Integer.parseInt(mailCfgid);
/* 176 */         mzm.gsp.mail.confbean.SMailCfg mailCfg = mzm.gsp.mail.main.MailInterface.getMailCfgById(cfgid);
/* 177 */         if (mailCfg != null)
/*     */         {
/*     */           try
/*     */           {
/* 181 */             result.MailTitle = Utils.urlEncode1738(mailCfg.title, "UTF-8");
/*     */           }
/*     */           catch (UnsupportedEncodingException e) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 189 */     result.GetTime = ((int)java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(xMailInfo.getCreatetime()));
/* 190 */     result.MailId = mailid;
/* 191 */     result.RoleId = ((QueryMailReq)((IDIPPacket_QueryMailReq)((IDIPCmd_QueryMailReq)this.cmd).req).body).RoleId;
/* 192 */     result.TagId = xMailInfo.getTagid();
/* 193 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
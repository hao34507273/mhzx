/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoCleartSayReq;
/*     */ import idip.AqDoCleartSayRsp;
/*     */ import idip.IDIPCmd_AqDoCleartSayReq;
/*     */ import idip.IDIPPacket_AqDoCleartSayReq;
/*     */ import idip.IDIPPacket_AqDoCleartSayRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.idip.SIdipClearSay;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoClearSayReq extends PIDIPCmd<IDIPCmd_AqDoCleartSayReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoClearSayReq(IDIPCmd_AqDoCleartSayReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     String openId = ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).OpenId;
/*  25 */     int areaId = ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).AreaId;
/*  26 */     int partition = ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Partition;
/*     */     
/*  28 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  29 */     xbean.User xUser = xtable.User.get(userId);
/*  30 */     if (null == xUser)
/*     */     {
/*  32 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result = 1;
/*  33 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  34 */       ((IDIPCmd_AqDoCleartSayReq)this.cmd).sendResponse();
/*     */       
/*  36 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoClearSayReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Source), ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  47 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result = (((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).Result = 1);
/*  48 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg = (((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  50 */       ((IDIPCmd_AqDoCleartSayReq)this.cmd).sendResponse();
/*     */       
/*  52 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoClearSayReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Source), ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  63 */       roleId = Long.parseLong(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  67 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result = (((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).Result = 1);
/*  68 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg = (((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  69 */       ((IDIPCmd_AqDoCleartSayReq)this.cmd).sendResponse();
/*     */       
/*  71 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoClearSayReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Source), ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  82 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result = 1;
/*  83 */       ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  84 */       ((IDIPCmd_AqDoCleartSayReq)this.cmd).sendResponse();
/*     */       
/*  86 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoClearSayReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Source), ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     SIdipClearSay sIdipClearSay = new SIdipClearSay();
/*  97 */     sIdipClearSay.roleid = roleId;
/*  98 */     OnlineManager.getInstance().sendAll(sIdipClearSay);
/*     */     
/* 100 */     ((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).Result = 0;
/* 101 */     ((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).RetMsg = "ok";
/* 102 */     ((IDIPCmd_AqDoCleartSayReq)this.cmd).sendResponse();
/*     */     
/* 104 */     StringBuilder logStr = new StringBuilder();
/* 105 */     logStr.append(((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).head.SendTime).append("|");
/* 106 */     logStr.append(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).OpenId).append("|");
/* 107 */     logStr.append(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).AreaId).append("|");
/* 108 */     logStr.append(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Partition).append("|");
/* 109 */     logStr.append(roleId).append("|");
/* 110 */     logStr.append(0).append("|");
/* 111 */     logStr.append(((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).head.Cmdid).append("|");
/* 112 */     logStr.append(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Serial).append("|");
/* 113 */     logStr.append(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Source).append("|");
/* 114 */     logStr.append(((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).Result).append("|");
/* 115 */     logStr.append(((AqDoCleartSayRsp)((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 117 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoClearSay", logStr.toString());
/*     */     
/* 119 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoClearSayReq.handle@do clear say done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoCleartSayRsp)((IDIPCmd_AqDoCleartSayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Source), ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 131 */     return ((AqDoCleartSayReq)((IDIPPacket_AqDoCleartSayReq)((IDIPCmd_AqDoCleartSayReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoClearSayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
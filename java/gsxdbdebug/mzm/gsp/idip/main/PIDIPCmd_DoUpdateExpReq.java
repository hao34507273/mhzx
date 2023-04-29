/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateExpReq;
/*     */ import idip.DoUpdateExpRsp;
/*     */ import idip.IDIPCmd_DoUpdateExpReq;
/*     */ import idip.IDIPPacket_DoUpdateExpReq;
/*     */ import idip.IDIPPacket_DoUpdateExpRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleExpUpdateRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateExpReq extends PIDIPCmd<IDIPCmd_DoUpdateExpReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateExpReq(IDIPCmd_DoUpdateExpReq cmd)
/*     */   {
/*  22 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  28 */     String openId = ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).OpenId;
/*  29 */     int areaId = ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).AreaId;
/*  30 */     int partition = ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Partition;
/*     */     
/*  32 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  33 */     xbean.User xUser = xtable.User.get(userId);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result = 1;
/*  37 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  38 */       ((IDIPCmd_DoUpdateExpReq)this.cmd).sendResponse();
/*     */       
/*  40 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Source), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Value), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result = (((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).Result = 1);
/*  53 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  55 */       ((IDIPCmd_DoUpdateExpReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Source), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Value), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  69 */       roleId = Long.parseLong(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  73 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result = (((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).Result = 1);
/*  74 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  75 */       ((IDIPCmd_DoUpdateExpReq)this.cmd).sendResponse();
/*     */       
/*  77 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Source), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Value), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  88 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result = 1;
/*  89 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  90 */       ((IDIPCmd_DoUpdateExpReq)this.cmd).sendResponse();
/*     */       
/*  92 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Value), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     int value = ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Value;
/* 102 */     Role role = RoleInterface.getRole(roleId, true);
/*     */     
/* 104 */     int beginValue = role.getExp();
/* 105 */     RoleExpUpdateRet result = null;
/* 106 */     if (value >= 0)
/*     */     {
/* 108 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 109 */       result = role.addExpForIdip(value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 113 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 114 */       result = role.cutExpForIdip(-value, tLogArg);
/*     */     }
/*     */     
/* 117 */     if (RoleExpUpdateRet.SUCCESS.compareTo(result) != 0)
/*     */     {
/* 119 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result = result.ret;
/* 120 */       ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 121 */       ((IDIPCmd_DoUpdateExpReq)this.cmd).sendResponse();
/*     */       
/* 123 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@update exp failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Value), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     ((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 133 */     ((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).EndValue = role.getExp();
/* 134 */     ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result = 0;
/* 135 */     ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 136 */     ((IDIPCmd_DoUpdateExpReq)this.cmd).sendResponse();
/*     */     
/* 138 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 140 */     logStr.append(((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).head.SendTime).append("|");
/* 141 */     logStr.append(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).OpenId).append("|");
/* 142 */     logStr.append(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).AreaId).append("|");
/* 143 */     logStr.append(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Partition).append("|");
/* 144 */     logStr.append(0).append("|");
/* 145 */     logStr.append(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Value).append("|");
/* 146 */     logStr.append(((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).head.Cmdid).append("|");
/* 147 */     logStr.append(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial).append("|");
/* 148 */     logStr.append(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Source).append("|");
/* 149 */     logStr.append(((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).BeginValue).append("|");
/* 150 */     logStr.append(((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).EndValue).append("|");
/* 151 */     logStr.append(result.ret).append("|");
/* 152 */     logStr.append(result.retMsg).append("|");
/* 153 */     logStr.append(roleId);
/*     */     
/* 155 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateExp", logStr.toString());
/*     */     
/* 157 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@update exp success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial, Integer.valueOf(((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateExpRsp)((IDIPPacket_DoUpdateExpRsp)((IDIPCmd_DoUpdateExpReq)this.cmd).rsp).body).EndValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 170 */     return ((DoUpdateExpReq)((IDIPPacket_DoUpdateExpReq)((IDIPCmd_DoUpdateExpReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateExpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
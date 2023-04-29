/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateChivalrousReq;
/*     */ import idip.DoUpdateChivalrousRsp;
/*     */ import idip.IDIPCmd_DoUpdateChivalrousReq;
/*     */ import idip.IDIPPacket_DoUpdateChivalrousReq;
/*     */ import idip.IDIPPacket_DoUpdateChivalrousRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mall.main.JifenOperateEnum;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateChivalrousReq extends PIDIPCmd<IDIPCmd_DoUpdateChivalrousReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateChivalrousReq(IDIPCmd_DoUpdateChivalrousReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     String openId = ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).OpenId;
/*  30 */     int areaId = ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).AreaId;
/*  31 */     int partition = ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Partition;
/*     */     
/*  33 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  34 */     xbean.User xUser = xtable.User.get(userId);
/*  35 */     if (null == xUser)
/*     */     {
/*  37 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result = 1;
/*  38 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  39 */       ((IDIPCmd_DoUpdateChivalrousReq)this.cmd).sendResponse();
/*     */       
/*  41 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateChivalrousReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).PlatId), ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result = (((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).Result = 1);
/*  53 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  55 */       ((IDIPCmd_DoUpdateChivalrousReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateChivalrousReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).PlatId), ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  68 */       roleId = Long.parseLong(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  72 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result = (((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).Result = 1);
/*  73 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  74 */       ((IDIPCmd_DoUpdateChivalrousReq)this.cmd).sendResponse();
/*     */       
/*  76 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateChivalrousReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).PlatId), ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  87 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result = 1;
/*  88 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  89 */       ((IDIPCmd_DoUpdateChivalrousReq)this.cmd).sendResponse();
/*     */       
/*  91 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateChivalrousReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).PlatId), ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     int beginValue = (int)MallInterface.getJifen(roleId, 1);
/*     */     
/* 102 */     int value = ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Value;
/*     */     
/* 104 */     JifenOperateEnum result = null;
/* 105 */     if (value >= 0)
/*     */     {
/* 107 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 108 */       result = MallInterface.addJifenForIdip(roleId, value, 1, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 112 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 113 */       result = MallInterface.cutJifenForIdip(roleId, -value, 1, tLogArg);
/*     */     }
/*     */     
/* 116 */     if (JifenOperateEnum.SUCCESS.compareTo(result) != 0)
/*     */     {
/* 118 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result = result.ret;
/* 119 */       ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 120 */       ((IDIPCmd_DoUpdateChivalrousReq)this.cmd).sendResponse();
/*     */       
/* 122 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateChivalrousReq.handle@update value failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     ((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 131 */     ((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).EndValue = ((int)MallInterface.getJifen(roleId, 1));
/* 132 */     ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result = 0;
/* 133 */     ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 134 */     ((IDIPCmd_DoUpdateChivalrousReq)this.cmd).sendResponse();
/*     */     
/* 136 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 138 */     logStr.append(((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).head.SendTime).append("|");
/* 139 */     logStr.append(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).OpenId).append("|");
/* 140 */     logStr.append(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).AreaId).append("|");
/* 141 */     logStr.append(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Partition).append("|");
/* 142 */     logStr.append(0).append("|");
/* 143 */     logStr.append(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Value).append("|");
/* 144 */     logStr.append(((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).head.Cmdid).append("|");
/* 145 */     logStr.append(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Serial).append("|");
/* 146 */     logStr.append(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Source).append("|");
/* 147 */     logStr.append(((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).BeginValue).append("|");
/* 148 */     logStr.append(((DoUpdateChivalrousRsp)((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).body).EndValue).append("|");
/* 149 */     logStr.append(result.ret).append("|");
/* 150 */     logStr.append(result.retMsg).append("|");
/* 151 */     logStr.append(roleId);
/*     */     
/* 153 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateChivalrous", logStr.toString());
/*     */     
/* 155 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateChivalrousReq.handle@update xia yi value success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateChivalrousRsp)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   protected String getSerialNo()
/*     */   {
/* 166 */     return ((DoUpdateChivalrousReq)((IDIPPacket_DoUpdateChivalrousReq)((IDIPCmd_DoUpdateChivalrousReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateChivalrousReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
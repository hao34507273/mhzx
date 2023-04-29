/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateReputationReq;
/*     */ import idip.DoUpdateReputationRsp;
/*     */ import idip.IDIPCmd_DoUpdateReputationReq;
/*     */ import idip.IDIPPacket_DoUpdateReputationReq;
/*     */ import idip.IDIPPacket_DoUpdateReputationRsp;
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
/*     */ public class PIDIPCmd_DoUpdateReputationReq extends PIDIPCmd<IDIPCmd_DoUpdateReputationReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateReputationReq(IDIPCmd_DoUpdateReputationReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     String openId = ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).OpenId;
/*  30 */     int areaId = ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).AreaId;
/*  31 */     int partition = ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Partition;
/*     */     
/*  33 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  34 */     xbean.User xUser = xtable.User.get(userId);
/*  35 */     if (null == xUser)
/*     */     {
/*  37 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result = 1;
/*  38 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  39 */       ((IDIPCmd_DoUpdateReputationReq)this.cmd).sendResponse();
/*     */       
/*  41 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateReputationReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Source), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Value), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  53 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result = (((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).Result = 1);
/*  54 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  56 */       ((IDIPCmd_DoUpdateReputationReq)this.cmd).sendResponse();
/*     */       
/*  58 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateReputationReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Source), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Value), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  70 */       roleId = Long.parseLong(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  74 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result = (((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).Result = 1);
/*  75 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  76 */       ((IDIPCmd_DoUpdateReputationReq)this.cmd).sendResponse();
/*     */       
/*  78 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateReputationReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Source), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Value), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  89 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result = 1;
/*  90 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  91 */       ((IDIPCmd_DoUpdateReputationReq)this.cmd).sendResponse();
/*     */       
/*  93 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateReputationReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Value), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int beginValue = (int)MallInterface.getJifen(roleId, 4);
/* 103 */     int value = ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Value;
/*     */     
/* 105 */     JifenOperateEnum result = null;
/* 106 */     if (value >= 0)
/*     */     {
/* 108 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 109 */       result = MallInterface.addJifenForIdip(roleId, value, 4, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 113 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 114 */       result = MallInterface.cutJifenForIdip(roleId, -value, 4, tLogArg);
/*     */     }
/*     */     
/* 117 */     if (result != JifenOperateEnum.SUCCESS)
/*     */     {
/* 119 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result = result.ret;
/* 120 */       ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 121 */       ((IDIPCmd_DoUpdateReputationReq)this.cmd).sendResponse();
/*     */       
/* 123 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateReputationReq.handle@update reputation failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Value), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     ((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 132 */     ((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).EndValue = ((int)MallInterface.getJifen(roleId, 4));
/* 133 */     ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result = 0;
/* 134 */     ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 135 */     ((IDIPCmd_DoUpdateReputationReq)this.cmd).sendResponse();
/*     */     
/* 137 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 139 */     logStr.append(((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).head.SendTime).append("|");
/* 140 */     logStr.append(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).OpenId).append("|");
/* 141 */     logStr.append(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).AreaId).append("|");
/* 142 */     logStr.append(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Partition).append("|");
/* 143 */     logStr.append(0).append("|");
/* 144 */     logStr.append(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Value).append("|");
/* 145 */     logStr.append(((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).head.Cmdid).append("|");
/* 146 */     logStr.append(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial).append("|");
/* 147 */     logStr.append(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Source).append("|");
/* 148 */     logStr.append(((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).BeginValue).append("|");
/* 149 */     logStr.append(((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).EndValue).append("|");
/* 150 */     logStr.append(result.ret).append("|");
/* 151 */     logStr.append(result.retMsg).append("|");
/* 152 */     logStr.append(roleId);
/*     */     
/* 154 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateReputation", logStr.toString());
/*     */     
/* 156 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateReputationReq.handle@update reputation success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial, Integer.valueOf(((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateReputationRsp)((IDIPPacket_DoUpdateReputationRsp)((IDIPCmd_DoUpdateReputationReq)this.cmd).rsp).body).EndValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 168 */     return ((DoUpdateReputationReq)((IDIPPacket_DoUpdateReputationReq)((IDIPCmd_DoUpdateReputationReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateReputationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
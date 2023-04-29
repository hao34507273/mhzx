/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateHisContributionReq;
/*     */ import idip.DoUpdateHisContributionRsp;
/*     */ import idip.IDIPCmd_DoUpdateHisContributionReq;
/*     */ import idip.IDIPPacket_DoUpdateHisContributionReq;
/*     */ import idip.IDIPPacket_DoUpdateHisContributionRsp;
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
/*     */ public class PIDIPCmd_DoUpdateHisContributionReq extends PIDIPCmd<IDIPCmd_DoUpdateHisContributionReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateHisContributionReq(IDIPCmd_DoUpdateHisContributionReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     String openId = ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).OpenId;
/*  30 */     int areaId = ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).AreaId;
/*  31 */     int partition = ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Partition;
/*     */     
/*  33 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  34 */     xbean.User xUser = xtable.User.get(userId);
/*  35 */     if (null == xUser)
/*     */     {
/*  37 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result = 1;
/*  38 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  39 */       ((IDIPCmd_DoUpdateHisContributionReq)this.cmd).sendResponse();
/*     */       
/*  41 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateHisContributionReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Source), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Value), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  53 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result = (((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).Result = 1);
/*  54 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  56 */       ((IDIPCmd_DoUpdateHisContributionReq)this.cmd).sendResponse();
/*     */       
/*  58 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateHisContributionReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Source), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Value), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial }));
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
/*  70 */       roleId = Long.parseLong(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  74 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result = (((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).Result = 1);
/*  75 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  76 */       ((IDIPCmd_DoUpdateHisContributionReq)this.cmd).sendResponse();
/*     */       
/*  78 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateHisContributionReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|plat_id=%d|area_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Byte.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(areaId), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Source), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial }));
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
/*  89 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result = 1;
/*  90 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  91 */       ((IDIPCmd_DoUpdateHisContributionReq)this.cmd).sendResponse();
/*     */       
/*  93 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateHisContributionReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|plat_id=%d|area_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Byte.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(areaId), Long.valueOf(roleId), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Source), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int beginValue = (int)MallInterface.getJifen(roleId, 3);
/* 103 */     int value = ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Value;
/*     */     
/* 105 */     JifenOperateEnum result = null;
/* 106 */     if (value >= 0)
/*     */     {
/* 108 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 109 */       result = MallInterface.addJifenForIdip(roleId, value, 3, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 113 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 114 */       result = MallInterface.cutJifenForIdip(roleId, -value, 3, tLogArg);
/*     */     }
/*     */     
/* 117 */     if (result != JifenOperateEnum.SUCCESS)
/*     */     {
/* 119 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result = result.ret;
/* 120 */       ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 121 */       ((IDIPCmd_DoUpdateHisContributionReq)this.cmd).sendResponse();
/*     */       
/* 123 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateHisContributionReq.handle@update shi men contribution failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|role_id=%d|plat_id=%d|source=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Long.valueOf(roleId), Byte.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Source), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Value), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     ((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 132 */     ((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).EndValue = ((int)MallInterface.getJifen(roleId, 3));
/* 133 */     ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result = 0;
/* 134 */     ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 135 */     ((IDIPCmd_DoUpdateHisContributionReq)this.cmd).sendResponse();
/*     */     
/* 137 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 139 */     logStr.append(((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).head.SendTime).append("|");
/* 140 */     logStr.append(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).OpenId).append("|");
/* 141 */     logStr.append(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).AreaId).append("|");
/* 142 */     logStr.append(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Partition).append("|");
/* 143 */     logStr.append(0).append("|");
/* 144 */     logStr.append(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Value).append("|");
/* 145 */     logStr.append(((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).head.Cmdid).append("|");
/* 146 */     logStr.append(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial).append("|");
/* 147 */     logStr.append(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Source).append("|");
/* 148 */     logStr.append(((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).BeginValue).append("|");
/* 149 */     logStr.append(((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).EndValue).append("|");
/* 150 */     logStr.append(result.ret).append("|");
/* 151 */     logStr.append(result.retMsg).append("|");
/* 152 */     logStr.append(roleId);
/*     */     
/* 154 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateHisContribution", logStr.toString());
/*     */     
/* 156 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateHisContributionReq.handle@update shi men contribution success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial, Integer.valueOf(((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateHisContributionRsp)((IDIPPacket_DoUpdateHisContributionRsp)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).rsp).body).EndValue) }));
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
/* 168 */     return ((DoUpdateHisContributionReq)((IDIPPacket_DoUpdateHisContributionReq)((IDIPCmd_DoUpdateHisContributionReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateHisContributionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
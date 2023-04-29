/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoAddRechargeIntegralReq;
/*     */ import idip.DoAddRechargeIntegralRsp;
/*     */ import idip.IDIPCmd_DoAddRechargeIntegralReq;
/*     */ import idip.IDIPPacket_DoAddRechargeIntegralReq;
/*     */ import idip.IDIPPacket_DoAddRechargeIntegralRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.qingfu.main.PresentInnerSaveAmtResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoAddRechargeIntegralReq extends PIDIPCmd<IDIPCmd_DoAddRechargeIntegralReq>
/*     */ {
/*     */   public PIDIPCmd_DoAddRechargeIntegralReq(IDIPCmd_DoAddRechargeIntegralReq cmd)
/*     */   {
/*  20 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  26 */     String openId = ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).OpenId;
/*  27 */     int areaId = ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).AreaId;
/*  28 */     int partition = ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Partition;
/*     */     
/*  30 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  31 */     xbean.User xUser = xtable.User.get(userId);
/*  32 */     if (null == xUser)
/*     */     {
/*  34 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).Result = 1);
/*  35 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  36 */       ((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).sendResponse();
/*     */       
/*  38 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoAddRechargeIntegralReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).PlatId), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     if (((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  50 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).Result = 1);
/*  51 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  53 */       ((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).sendResponse();
/*     */       
/*  55 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoAddRechargeIntegralReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).PlatId), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  67 */       roleId = Long.parseLong(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  71 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).Result = 1);
/*  72 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  73 */       ((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).sendResponse();
/*     */       
/*  75 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoAddRechargeIntegralReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).PlatId), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  86 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).Result = 1);
/*  87 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  88 */       ((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).sendResponse();
/*     */       
/*  90 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoAddRechargeIntegralReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     int value = ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value;
/* 100 */     if (value <= 0)
/*     */     {
/* 102 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).Result = '﫶');
/* 103 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).RetMsg = "value <= 0");
/* 104 */       ((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).sendResponse();
/*     */       
/* 106 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoAddRechargeIntegralReq.handle@value <= 0|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     long beginValue = QingfuInterface.getSaveAmt(userId, true);
/* 116 */     PresentInnerSaveAmtResult result = QingfuInterface.presentInnerSaveAmt(userId, value);
/* 117 */     if (result != PresentInnerSaveAmtResult.Success)
/*     */     {
/* 119 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).Result = '﫵');
/* 120 */       ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).RetMsg = result.desc);
/* 121 */       ((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).sendResponse();
/*     */       
/* 123 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@present inner save amt failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(result.code), result.desc, userId, Integer.valueOf(areaId), Byte.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/* 130 */     long endValue = QingfuInterface.getSaveAmt(userId, true);
/*     */     
/* 132 */     ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).Result = 0);
/* 133 */     ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg = (((DoAddRechargeIntegralRsp)((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).body).RetMsg = "ok");
/* 134 */     ((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).sendResponse();
/*     */     
/*     */ 
/* 137 */     StringBuilder logStr = new StringBuilder();
/* 138 */     logStr.append(((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).head.SendTime).append("|");
/* 139 */     logStr.append(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).OpenId).append("|");
/* 140 */     logStr.append(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).AreaId).append("|");
/* 141 */     logStr.append(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Partition).append("|");
/* 142 */     logStr.append(roleId).append("|");
/* 143 */     logStr.append(0).append("|");
/* 144 */     logStr.append(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Value).append("|");
/* 145 */     logStr.append(((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).head.Cmdid).append("|");
/* 146 */     logStr.append(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial).append("|");
/* 147 */     logStr.append(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source).append("|");
/* 148 */     logStr.append(beginValue).append("|");
/* 149 */     logStr.append(endValue).append("|");
/* 150 */     logStr.append(result.code).append("|");
/* 151 */     logStr.append(result.desc);
/* 152 */     TLogManager.getInstance().addLog(roleId, "IDIPDoAddRechargeIntegral", logStr.toString());
/*     */     
/* 154 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoAddRechargeIntegralReq.handle@add recharget integral success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|source=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoAddRechargeIntegralRsp)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Source), ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial, Long.valueOf(beginValue), Long.valueOf(endValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 159 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 165 */     return ((DoAddRechargeIntegralReq)((IDIPPacket_DoAddRechargeIntegralReq)((IDIPCmd_DoAddRechargeIntegralReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoAddRechargeIntegralReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
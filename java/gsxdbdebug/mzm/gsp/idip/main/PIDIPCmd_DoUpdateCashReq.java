/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateCashReq;
/*     */ import idip.DoUpdateCashRsp;
/*     */ import idip.IDIPCmd_DoUpdateCashReq;
/*     */ import idip.IDIPPacket_DoUpdateCashReq;
/*     */ import idip.IDIPPacket_DoUpdateCashRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateCashReq extends PIDIPCmd<IDIPCmd_DoUpdateCashReq>
/*     */ {
/*  20 */   private final int UPDATE_CASH_RESULT_OFFSET = 64456;
/*     */   
/*     */   public PIDIPCmd_DoUpdateCashReq(IDIPCmd_DoUpdateCashReq cmd)
/*     */   {
/*  24 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  30 */     String openId = ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).OpenId;
/*  31 */     int areaId = ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).AreaId;
/*  32 */     int partition = ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Partition;
/*     */     
/*  34 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  35 */     xbean.User xUser = xtable.User.get(userId);
/*  36 */     if (null == xUser)
/*     */     {
/*  38 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result = 1;
/*  39 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  40 */       ((IDIPCmd_DoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  42 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCashReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Value), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     if (((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  54 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result = (((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).Result = 1);
/*  55 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  57 */       ((IDIPCmd_DoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  59 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCashReq.handle@roleid length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Value), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  71 */       roleId = Long.parseLong(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  75 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result = (((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).Result = 1);
/*  76 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  77 */       ((IDIPCmd_DoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  79 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCashReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Value), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  90 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result = 1;
/*  91 */       ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  92 */       ((IDIPCmd_DoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  94 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCashReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Value), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     int beginValue = (int)QingfuInterface.getBalance(userId, false);
/* 104 */     int value = ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Value;
/*     */     
/* 106 */     int retcode = 0;
/* 107 */     String retMsg = null;
/* 108 */     if (value >= 0)
/*     */     {
/* 110 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 111 */       PresentResult result = QingfuInterface.presentYuanbao(userId, roleId, value, mzm.gsp.qingfu.main.PresentType.PRESENT_BIND_IDIP, tLogArg);
/*     */       
/* 113 */       if (!result.equals(PresentResult.Success))
/*     */       {
/* 115 */         ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result = (result.code + 64456);
/* 116 */         ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = result.desc;
/* 117 */         ((IDIPCmd_DoUpdateCashReq)this.cmd).sendResponse();
/*     */         
/* 119 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCashReq.handle@update yuan bao failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.code), result.desc, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */         return false;
/*     */       }
/*     */       
/* 128 */       retcode = result.code;
/* 129 */       retMsg = result.desc;
/*     */     }
/*     */     else
/*     */     {
/* 133 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 134 */       CostResult result = QingfuInterface.costYuanbao(userId, roleId, -value, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_IDIP, tLogArg);
/*     */       
/* 136 */       if (!result.equals(CostResult.Success))
/*     */       {
/* 138 */         ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result = (result.code + 64456);
/* 139 */         ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = result.desc;
/* 140 */         ((IDIPCmd_DoUpdateCashReq)this.cmd).sendResponse();
/*     */         
/* 142 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCashReq.handle@update yuan bao failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.code), result.desc, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */         return false;
/*     */       }
/*     */       
/* 151 */       retcode = result.code;
/* 152 */       retMsg = result.desc;
/*     */     }
/*     */     
/* 155 */     ((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 156 */     ((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).EndValue = ((int)QingfuInterface.getBalance(userId, false));
/* 157 */     ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result = 0;
/* 158 */     ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 159 */     ((IDIPCmd_DoUpdateCashReq)this.cmd).sendResponse();
/*     */     
/* 161 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 163 */     logStr.append(((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).head.SendTime).append("|");
/* 164 */     logStr.append(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).OpenId).append("|");
/* 165 */     logStr.append(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).AreaId).append("|");
/* 166 */     logStr.append(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Partition).append("|");
/* 167 */     logStr.append(0).append("|");
/* 168 */     logStr.append(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Value).append("|");
/* 169 */     logStr.append(((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).head.Cmdid).append("|");
/* 170 */     logStr.append(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial).append("|");
/* 171 */     logStr.append(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source).append("|");
/* 172 */     logStr.append(((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).BeginValue).append("|");
/* 173 */     logStr.append(((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).EndValue).append("|");
/* 174 */     logStr.append(retcode).append("|");
/* 175 */     logStr.append(retMsg).append("|");
/* 176 */     logStr.append(roleId);
/*     */     
/* 178 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateYuanbao", logStr.toString());
/*     */     
/* 180 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateCashReq.handle@update yuan bao success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial, Integer.valueOf(((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateCashRsp)((IDIPPacket_DoUpdateCashRsp)((IDIPCmd_DoUpdateCashReq)this.cmd).rsp).body).EndValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 187 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 193 */     return ((DoUpdateCashReq)((IDIPPacket_DoUpdateCashReq)((IDIPCmd_DoUpdateCashReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateCashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
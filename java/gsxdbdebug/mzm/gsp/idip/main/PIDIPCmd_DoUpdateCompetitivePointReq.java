/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateCompetitivePointReq;
/*     */ import idip.DoUpdateCompetitivePointRsp;
/*     */ import idip.IDIPCmd_DoUpdateCompetitivePointReq;
/*     */ import idip.IDIPPacket_DoUpdateCompetitivePointReq;
/*     */ import idip.IDIPPacket_DoUpdateCompetitivePointRsp;
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
/*     */ public class PIDIPCmd_DoUpdateCompetitivePointReq extends PIDIPCmd<IDIPCmd_DoUpdateCompetitivePointReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateCompetitivePointReq(IDIPCmd_DoUpdateCompetitivePointReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     String openId = ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).OpenId;
/*  30 */     int areaId = ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).AreaId;
/*  31 */     int partition = ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Partition;
/*     */     
/*  33 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  34 */     xbean.User xUser = xtable.User.get(userId);
/*  35 */     if (null == xUser)
/*     */     {
/*  37 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result = 1;
/*  38 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  39 */       ((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).sendResponse();
/*     */       
/*  41 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCompetitivePointReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).PlatId), ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result = (((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).Result = 1);
/*  53 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  55 */       ((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCompetitivePointReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).PlatId), ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Source), getSerialNo() }));
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
/*  68 */       roleId = Long.parseLong(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  72 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result = (((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).Result = 1);
/*  73 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  74 */       ((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).sendResponse();
/*     */       
/*  76 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCompetitivePointReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).PlatId), ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Source), getSerialNo() }));
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
/*  87 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result = 1;
/*  88 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  89 */       ((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).sendResponse();
/*     */       
/*  91 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCompetitivePointReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     int beginValue = (int)MallInterface.getJifen(roleId, 2);
/* 101 */     int value = ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value;
/*     */     
/* 103 */     JifenOperateEnum result = null;
/* 104 */     if (value >= 0)
/*     */     {
/* 106 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 107 */       result = MallInterface.addJifenForIdip(roleId, value, 2, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 111 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 112 */       result = MallInterface.cutJifenForIdip(roleId, -value, 2, tLogArg);
/*     */     }
/*     */     
/* 115 */     if (JifenOperateEnum.SUCCESS.compareTo(result) != 0)
/*     */     {
/* 117 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result = result.ret;
/* 118 */       ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 119 */       ((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).sendResponse();
/*     */       
/* 121 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateCompetitivePointReq.handle@update competitive point value failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     ((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 130 */     ((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).EndValue = ((int)MallInterface.getJifen(roleId, 2));
/* 131 */     ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result = 0;
/* 132 */     ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 133 */     ((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).sendResponse();
/*     */     
/* 135 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 137 */     logStr.append(((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).head.SendTime).append("|");
/* 138 */     logStr.append(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).OpenId).append("|");
/* 139 */     logStr.append(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).AreaId).append("|");
/* 140 */     logStr.append(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Partition).append("|");
/* 141 */     logStr.append(0).append("|");
/* 142 */     logStr.append(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value).append("|");
/* 143 */     logStr.append(((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).head.Cmdid).append("|");
/* 144 */     logStr.append(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Serial).append("|");
/* 145 */     logStr.append(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Source).append("|");
/* 146 */     logStr.append(((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).BeginValue).append("|");
/* 147 */     logStr.append(((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).EndValue).append("|");
/* 148 */     logStr.append(result.ret).append("|");
/* 149 */     logStr.append(result.retMsg).append("|");
/* 150 */     logStr.append(roleId);
/*     */     
/* 152 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateCompetitivePoint", logStr.toString());
/*     */     
/* 154 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateCompetitivePointReq.handle@update competitive point value success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|value=%d|begin_value=%d|end_value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateCompetitivePointRsp)((IDIPPacket_DoUpdateCompetitivePointRsp)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).rsp).body).EndValue), Integer.valueOf(((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 167 */     return ((DoUpdateCompetitivePointReq)((IDIPPacket_DoUpdateCompetitivePointReq)((IDIPCmd_DoUpdateCompetitivePointReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateCompetitivePointReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateGangContributionReq;
/*     */ import idip.DoUpdateGangContributionRsp;
/*     */ import idip.IDIPCmd_DoUpdateGangContributionReq;
/*     */ import idip.IDIPPacket_DoUpdateGangContributionReq;
/*     */ import idip.IDIPPacket_DoUpdateGangContributionRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.BanggongOperateEnum;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateGangContributionReq extends PIDIPCmd<IDIPCmd_DoUpdateGangContributionReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateGangContributionReq(IDIPCmd_DoUpdateGangContributionReq cmd)
/*     */   {
/*  22 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  28 */     String openId = ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).OpenId;
/*  29 */     int areaId = ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).AreaId;
/*  30 */     int partition = ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Partition;
/*     */     
/*  32 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  33 */     xbean.User xUser = xtable.User.get(userId);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result = 1;
/*  37 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  38 */       ((IDIPCmd_DoUpdateGangContributionReq)this.cmd).sendResponse();
/*     */       
/*  40 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGangContributionReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Source), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Value), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result = (((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).Result = 1);
/*  53 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  55 */       ((IDIPCmd_DoUpdateGangContributionReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGangContributionReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Source), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Value), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial }));
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
/*  69 */       roleId = Long.parseLong(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  73 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result = (((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).Result = 1);
/*  74 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  75 */       ((IDIPCmd_DoUpdateGangContributionReq)this.cmd).sendResponse();
/*     */       
/*  77 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGangContributionReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Source), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Value), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  88 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result = 1;
/*  89 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  90 */       ((IDIPCmd_DoUpdateGangContributionReq)this.cmd).sendResponse();
/*     */       
/*  92 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGangContributionReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Value), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/* 100 */     int beginValue = (int)GangInterface.getBangGong(roleId);
/* 101 */     int value = ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Value;
/*     */     
/* 103 */     BanggongOperateEnum result = null;
/* 104 */     if (value >= 0)
/*     */     {
/* 106 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 107 */       result = GangInterface.addBangGongForIdip(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 111 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 112 */       result = GangInterface.cutBangGongForIdip(roleId, -value, tLogArg);
/*     */     }
/*     */     
/* 115 */     if (BanggongOperateEnum.SUCCESS.compareTo(result) != 0)
/*     */     {
/* 117 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result = result.ret;
/* 118 */       ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 119 */       ((IDIPCmd_DoUpdateGangContributionReq)this.cmd).sendResponse();
/*     */       
/* 121 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@update gang contribution failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Value), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     ((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 131 */     ((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).EndValue = ((int)GangInterface.getBangGong(roleId));
/* 132 */     ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result = 0;
/* 133 */     ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 134 */     ((IDIPCmd_DoUpdateGangContributionReq)this.cmd).sendResponse();
/*     */     
/* 136 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 138 */     logStr.append(((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).head.SendTime).append("|");
/* 139 */     logStr.append(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).OpenId).append("|");
/* 140 */     logStr.append(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).AreaId).append("|");
/* 141 */     logStr.append(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Partition).append("|");
/* 142 */     logStr.append(0).append("|");
/* 143 */     logStr.append(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Value).append("|");
/* 144 */     logStr.append(((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).head.Cmdid).append("|");
/* 145 */     logStr.append(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial).append("|");
/* 146 */     logStr.append(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Source).append("|");
/* 147 */     logStr.append(((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).BeginValue).append("|");
/* 148 */     logStr.append(((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).EndValue).append("|");
/* 149 */     logStr.append(result.ret).append("|");
/* 150 */     logStr.append(result.retMsg).append("|");
/* 151 */     logStr.append(roleId);
/*     */     
/* 153 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateGangContribution", logStr.toString());
/*     */     
/* 155 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateExpReq.handle@update gang contribution success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|begin_value=%d|end_value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateGangContributionRsp)((IDIPPacket_DoUpdateGangContributionRsp)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).rsp).body).EndValue), ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial }));
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
/* 167 */     return ((DoUpdateGangContributionReq)((IDIPPacket_DoUpdateGangContributionReq)((IDIPCmd_DoUpdateGangContributionReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateGangContributionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
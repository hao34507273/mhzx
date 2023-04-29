/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import idip.AqDoUpdateCashReq;
/*     */ import idip.AqDoUpdateCashRsp;
/*     */ import idip.IDIPCmd_AqDoUpdateCashReq;
/*     */ import idip.IDIPPacket_AqDoUpdateCashReq;
/*     */ import idip.IDIPPacket_AqDoUpdateCashRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoUpdateCashReq extends PIDIPCmd<IDIPCmd_AqDoUpdateCashReq>
/*     */ {
/*     */   private static final int ERROR_CODE = -1080;
/*     */   
/*     */   public PIDIPCmd_AqDoUpdateCashReq(IDIPCmd_AqDoUpdateCashReq cmd)
/*     */   {
/*  26 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  32 */     String openId = ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).OpenId;
/*  33 */     int areaId = ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).AreaId;
/*  34 */     int partition = ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Partition;
/*     */     
/*  36 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  37 */     xbean.User xUser = xtable.User.get(userId);
/*  38 */     if (null == xUser)
/*     */     {
/*  40 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = 1);
/*  41 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  42 */       ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  44 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  56 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = 1);
/*  57 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  59 */       ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  61 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  73 */       roleId = Long.parseLong(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  77 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = 1);
/*  78 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  79 */       ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  81 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  93 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = 1);
/*  94 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  95 */       ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/*  97 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     int value = ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Value;
/* 108 */     if (value == 0)
/*     */     {
/* 110 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = '﯈');
/* 111 */       ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = "param invlaid: value == 0");
/* 112 */       ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */       
/* 114 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@update yuan bao failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     boolean isBind = ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type == 0;
/* 124 */     int beginValue = isBind ? (int)QingfuInterface.getBindYuanbao(userId, true) : (int)QingfuInterface.getYuanbao(userId, true);
/*     */     
/*     */ 
/* 127 */     int retcode = 0;
/* 128 */     String retMsg = null;
/* 129 */     if (value >= 0)
/*     */     {
/* 131 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_ADD);
/* 132 */       PresentType presentType = isBind ? PresentType.PRESENT_BIND_AQIDIP : PresentType.PRESENT_AQIDIP;
/* 133 */       PresentResult result = QingfuInterface.presentYuanbao(userId, roleId, value, presentType, tLogArg);
/* 134 */       if (result != PresentResult.Success)
/*     */       {
/* 136 */         ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = result.code + 64456);
/* 137 */         ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = result.desc);
/* 138 */         ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */         
/* 140 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@update yuan bao failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(result.code), result.desc, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 147 */         return false;
/*     */       }
/* 149 */       retcode = result.code;
/* 150 */       retMsg = result.desc;
/*     */     }
/*     */     else
/*     */     {
/* 154 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_REM);
/* 155 */       CostType costType = isBind ? CostType.COST_BIND_FIRST_AQIDIP : CostType.COST_AQIDIP;
/* 156 */       CostResult result = CostResult.Success;
/* 157 */       if (beginValue == -1)
/*     */       {
/* 159 */         result = CostResult.UserNotFound;
/*     */ 
/*     */ 
/*     */       }
/* 163 */       else if (beginValue != 0)
/*     */       {
/* 165 */         if (beginValue < -value)
/*     */         {
/* 167 */           result = QingfuInterface.costYuanbao(userId, roleId, beginValue, costType, tLogArg);
/* 168 */           if (result == CostResult.Success)
/*     */           {
/* 170 */             result = isBind ? CostResult.BindYuanBaoClearForAqIdip : CostResult.YuanBaoClearForAqIdip;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 175 */           result = QingfuInterface.costYuanbao(userId, roleId, -value, costType, tLogArg);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 180 */       if ((result != CostResult.Success) && (result != CostResult.BindYuanBaoClearForAqIdip) && (result != CostResult.YuanBaoClearForAqIdip))
/*     */       {
/*     */ 
/* 183 */         ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = result.code + 64456);
/* 184 */         ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = result.desc);
/* 185 */         ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */         
/* 187 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@update yuan bao failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(result.code), result.desc, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 194 */         return false;
/*     */       }
/*     */       
/* 197 */       retcode = result.code;
/* 198 */       retMsg = result.desc;
/*     */     }
/*     */     
/* 201 */     ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).Result = 0);
/* 202 */     ((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateCashRsp)((IDIPPacket_AqDoUpdateCashRsp)((IDIPCmd_AqDoUpdateCashReq)this.cmd).rsp).body).RetMsg = retMsg);
/* 203 */     ((IDIPCmd_AqDoUpdateCashReq)this.cmd).sendResponse();
/*     */     
/* 205 */     if (((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin == 1)
/*     */     {
/* 207 */       Onlines.getInstance().kick(Long.valueOf(roleId), 2052);
/*     */     }
/*     */     
/* 210 */     int endValue = isBind ? (int)QingfuInterface.getBindYuanbao(userId, true) : (int)QingfuInterface.getYuanbao(userId, true);
/*     */     
/*     */ 
/* 213 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 215 */     logStr.append(((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).head.SendTime).append("|");
/* 216 */     logStr.append(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).OpenId).append("|");
/* 217 */     logStr.append(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).AreaId).append("|");
/* 218 */     logStr.append(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Partition).append("|");
/* 219 */     logStr.append(0).append("|");
/* 220 */     logStr.append(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Value).append("|");
/* 221 */     logStr.append(((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).head.Cmdid).append("|");
/* 222 */     logStr.append(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial).append("|");
/* 223 */     logStr.append(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source).append("|");
/* 224 */     logStr.append(beginValue).append("|");
/* 225 */     logStr.append(endValue).append("|");
/* 226 */     logStr.append(retcode).append("|");
/* 227 */     logStr.append(retMsg).append("|");
/* 228 */     logStr.append(roleId);
/*     */     
/* 230 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoUpdateYuanbao", logStr.toString());
/*     */     
/* 232 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoUpdateCashReq.handle@update yuan bao success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|is_login=%d|source=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(retcode), retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Type), Integer.valueOf(value), Byte.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).IsLogin), Integer.valueOf(((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Source), ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial, Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 239 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 245 */     return ((AqDoUpdateCashReq)((IDIPPacket_AqDoUpdateCashReq)((IDIPCmd_AqDoUpdateCashReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoUpdateCashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
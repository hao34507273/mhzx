/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoBanJoinrankReq;
/*     */ import idip.AqDoBanJoinrankRsp;
/*     */ import idip.IDIPCmd_AqDoBanJoinrankReq;
/*     */ import idip.IDIPPacket_AqDoBanJoinrankReq;
/*     */ import idip.IDIPPacket_AqDoBanJoinrankRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PIDIPCmd_AqDoBanJoinrankReq
/*     */   extends PIDIPCmd<IDIPCmd_AqDoBanJoinrankReq>
/*     */ {
/*     */   private static final int ALL = 99;
/*  25 */   private static final Map<Integer, Integer> rankType = new HashMap();
/*     */   
/*     */   static {
/*  28 */     rankType.put(Integer.valueOf(1), Integer.valueOf(0));
/*  29 */     rankType.put(Integer.valueOf(2), Integer.valueOf(2));
/*  30 */     rankType.put(Integer.valueOf(3), Integer.valueOf(1));
/*  31 */     rankType.put(Integer.valueOf(4), Integer.valueOf(3));
/*  32 */     rankType.put(Integer.valueOf(5), Integer.valueOf(4));
/*  33 */     rankType.put(Integer.valueOf(6), Integer.valueOf(7));
/*  34 */     rankType.put(Integer.valueOf(7), Integer.valueOf(8));
/*  35 */     rankType.put(Integer.valueOf(8), Integer.valueOf(9));
/*  36 */     rankType.put(Integer.valueOf(9), Integer.valueOf(10));
/*  37 */     rankType.put(Integer.valueOf(10), Integer.valueOf(6));
/*  38 */     rankType.put(Integer.valueOf(11), Integer.valueOf(5));
/*     */     
/*  40 */     rankType.put(Integer.valueOf(12), Integer.valueOf(11));
/*  41 */     rankType.put(Integer.valueOf(13), Integer.valueOf(12));
/*  42 */     rankType.put(Integer.valueOf(14), Integer.valueOf(13));
/*  43 */     rankType.put(Integer.valueOf(15), Integer.valueOf(14));
/*     */   }
/*     */   
/*     */   public PIDIPCmd_AqDoBanJoinrankReq(IDIPCmd_AqDoBanJoinrankReq cmd)
/*     */   {
/*  48 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  54 */     String openId = ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).OpenId;
/*  55 */     int areaId = ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).AreaId;
/*  56 */     int partition = ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Partition;
/*     */     
/*  58 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  59 */     xbean.User xUser = xtable.User.get(userId);
/*  60 */     if (null == xUser)
/*     */     {
/*  62 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 1);
/*  63 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  64 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/*  66 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     if (((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  78 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 1);
/*  79 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  81 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/*  83 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  95 */       roleId = Long.parseLong(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  99 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 1);
/* 100 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 101 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/* 103 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 115 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 1);
/* 116 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/* 117 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/* 119 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     Integer type = (Integer)rankType.get(new Integer(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type));
/* 131 */     if ((type == null) && (((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type != 99))
/*     */     {
/* 133 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 'ﮌ');
/* 134 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "rank type not exit");
/* 135 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/* 137 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@rank type not exit|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     if (type.intValue() == 8)
/*     */     {
/* 148 */       type = Integer.valueOf(IdipManager.getBigBossChartType(roleId));
/*     */     }
/*     */     
/* 151 */     String tip = Utils.urlDecode1738(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip);
/* 152 */     if (tip.isEmpty())
/*     */     {
/* 154 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 'ﮋ');
/* 155 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "tip is empty");
/* 156 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/* 158 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@tip is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/* 166 */     if (tip.length() > 256)
/*     */     {
/* 168 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 'ﮋ');
/* 169 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = String.format("tip length > %d", new Object[] { Integer.valueOf(256) }));
/* 170 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/* 172 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@tip length > MAX_TIP_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     int time = ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time;
/* 182 */     if (time <= 0)
/*     */     {
/* 184 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 'ﮊ');
/* 185 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "time must > 0");
/* 186 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/* 188 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@time <= 0|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 194 */       return false;
/*     */     }
/*     */     
/* 197 */     boolean isClear = ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank == 1;
/* 198 */     boolean result = true;
/* 199 */     if (((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type == 99)
/*     */     {
/* 201 */       IdipManager.banRankAll(roleId, time, tip);
/* 202 */       result = RankInterface.removeRoleidInAllRankForIDIP(roleId, isClear);
/*     */     }
/*     */     else
/*     */     {
/* 206 */       IdipManager.addBanRank(roleId, type.intValue(), time, tip);
/* 207 */       result = RankInterface.removeRoleidInRankForIDIP(roleId, type.intValue(), isClear);
/*     */     }
/* 209 */     if (!result)
/*     */     {
/* 211 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 'ﮉ');
/* 212 */       ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "not in rank");
/* 213 */       ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */       
/* 215 */       tlogAqIdipDoBanJoinRank(roleId);
/*     */       
/* 217 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@do ban join rank failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */       return true;
/*     */     }
/*     */     
/* 226 */     ((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result = 0;
/* 227 */     ((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg = "ok";
/* 228 */     ((IDIPCmd_AqDoBanJoinrankReq)this.cmd).sendResponse();
/*     */     
/* 230 */     tlogAqIdipDoBanJoinRank(roleId);
/*     */     
/* 232 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoBanJoinrankReq.handle@do ban join rank done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|is_zero_rank=%d|type=%d|time=%d|tip=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank), Byte.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip, Integer.valueOf(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source), ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 238 */     return true;
/*     */   }
/*     */   
/*     */   private void tlogAqIdipDoBanJoinRank(long roleId)
/*     */   {
/* 243 */     StringBuilder logStr = new StringBuilder();
/* 244 */     logStr.append(((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).head.SendTime).append("|");
/* 245 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).OpenId).append("|");
/* 246 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).AreaId).append("|");
/* 247 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Partition).append("|");
/* 248 */     logStr.append(roleId).append("|");
/* 249 */     logStr.append(0).append("|");
/* 250 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).IsZeroRank).append("|");
/* 251 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Type).append("|");
/* 252 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Time).append("|");
/* 253 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Tip).append("|");
/* 254 */     logStr.append(((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).head.Cmdid).append("|");
/* 255 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial).append("|");
/* 256 */     logStr.append(((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Source).append("|");
/* 257 */     logStr.append(((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).Result).append("|");
/* 258 */     logStr.append(((AqDoBanJoinrankRsp)((IDIPPacket_AqDoBanJoinrankRsp)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 260 */     TLogManager.getInstance().addLog(roleId, "AqIDIPDoBanjoinRank", logStr.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 266 */     return ((AqDoBanJoinrankReq)((IDIPPacket_AqDoBanJoinrankReq)((IDIPCmd_AqDoBanJoinrankReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoBanJoinrankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
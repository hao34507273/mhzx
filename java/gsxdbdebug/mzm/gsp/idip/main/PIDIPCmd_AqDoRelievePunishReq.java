/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoRelievePunishReq;
/*     */ import idip.AqDoRelievePunishRsp;
/*     */ import idip.IDIPCmd_AqDoRelievePunishReq;
/*     */ import idip.IDIPPacket_AqDoRelievePunishReq;
/*     */ import idip.IDIPPacket_AqDoRelievePunishRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PIDIPCmd_AqDoRelievePunishReq
/*     */   extends PIDIPCmd<IDIPCmd_AqDoRelievePunishReq>
/*     */ {
/*     */   private static final int ALLRANK = 0;
/*  26 */   private static final Map<Integer, Integer> rankType = new HashMap();
/*     */   
/*     */   static {
/*  29 */     rankType.put(Integer.valueOf(1), Integer.valueOf(0));
/*  30 */     rankType.put(Integer.valueOf(2), Integer.valueOf(2));
/*  31 */     rankType.put(Integer.valueOf(3), Integer.valueOf(1));
/*  32 */     rankType.put(Integer.valueOf(4), Integer.valueOf(3));
/*  33 */     rankType.put(Integer.valueOf(5), Integer.valueOf(4));
/*  34 */     rankType.put(Integer.valueOf(6), Integer.valueOf(7));
/*  35 */     rankType.put(Integer.valueOf(7), Integer.valueOf(8));
/*  36 */     rankType.put(Integer.valueOf(8), Integer.valueOf(9));
/*  37 */     rankType.put(Integer.valueOf(9), Integer.valueOf(10));
/*  38 */     rankType.put(Integer.valueOf(10), Integer.valueOf(6));
/*  39 */     rankType.put(Integer.valueOf(11), Integer.valueOf(5));
/*     */     
/*  41 */     rankType.put(Integer.valueOf(12), Integer.valueOf(11));
/*  42 */     rankType.put(Integer.valueOf(13), Integer.valueOf(12));
/*  43 */     rankType.put(Integer.valueOf(14), Integer.valueOf(13));
/*  44 */     rankType.put(Integer.valueOf(15), Integer.valueOf(14));
/*     */   }
/*     */   
/*     */   public PIDIPCmd_AqDoRelievePunishReq(IDIPCmd_AqDoRelievePunishReq cmd)
/*     */   {
/*  49 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  55 */     String openId = ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).OpenId;
/*  56 */     int areaId = ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).AreaId;
/*  57 */     int partition = ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Partition;
/*     */     
/*  59 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  60 */     xbean.User xUser = xtable.User.get(userId);
/*  61 */     if (null == xUser)
/*     */     {
/*  63 */       ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).Result = 1);
/*  64 */       ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  65 */       ((IDIPCmd_AqDoRelievePunishReq)this.cmd).sendResponse();
/*     */       
/*  67 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRelievePunishReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|relieve_banPlay=%d|relieve_playType=%d|relieve_banJoinRank=%d|relieve_banRankType=%d|relieve_ban=%d|relieve_maskChat=%d|relieve_lockUsrInfo=%d|relieve_zeroProfit=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanPlay), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanJoinRank), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBan), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveMaskchat), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveLockUsrInfo), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveZeroProfit), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Source), ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  82 */       ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).Result = 1);
/*  83 */       ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  85 */       ((IDIPCmd_AqDoRelievePunishReq)this.cmd).sendResponse();
/*     */       
/*  87 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRelievePunishReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|relieve_banPlay=%d|relieve_playType=%d|relieve_banJoinRank=%d|relieve_banRankType=%d|relieve_ban=%d|relieve_maskChat=%d|relieve_lockUsrInfo=%d|relieve_zeroProfit=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanPlay), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanJoinRank), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBan), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveMaskchat), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveLockUsrInfo), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveZeroProfit), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Source), ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     long roleId = -1L;
/* 100 */     if (!((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/*     */       try
/*     */       {
/* 104 */         roleId = Long.parseLong(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/* 108 */         ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).Result = 1);
/* 109 */         ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 110 */         ((IDIPCmd_AqDoRelievePunishReq)this.cmd).sendResponse();
/*     */         
/* 112 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRelievePunishReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|relieve_banPlay=%d|relieve_playType=%d|relieve_banJoinRank=%d|relieve_banRankType=%d|relieve_ban=%d|relieve_maskChat=%d|relieve_lockUsrInfo=%d|relieve_zeroProfit=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Partition), ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).OpenId, ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanPlay), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanJoinRank), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBan), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveMaskchat), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveLockUsrInfo), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveZeroProfit), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Source), ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 127 */     if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanPlay == 1)
/*     */     {
/* 129 */       if (!isRoleExist(roleId, xUser))
/*     */       {
/* 131 */         onRoleNotFound(userId, xUser);
/* 132 */         return false;
/*     */       }
/*     */       
/* 135 */       if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType == Integer.MAX_VALUE)
/*     */       {
/* 137 */         IdipManager.removeBanPlayAll(roleId);
/*     */       }
/*     */       else
/*     */       {
/* 141 */         IdipManager.removeBanPlay(roleId, ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType);
/*     */       }
/*     */     }
/* 144 */     if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanJoinRank == 1)
/*     */     {
/* 146 */       if (!isRoleExist(roleId, xUser))
/*     */       {
/* 148 */         onRoleNotFound(userId, xUser);
/* 149 */         return false;
/*     */       }
/*     */       
/* 152 */       Integer type = (Integer)rankType.get(Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType));
/* 153 */       if (type != null)
/*     */       {
/* 155 */         if (type.intValue() == 8)
/*     */         {
/* 157 */           type = Integer.valueOf(IdipManager.getBigBossChartType(roleId));
/*     */         }
/* 159 */         IdipManager.removeBanRank(roleId, type.intValue());
/*     */       }
/* 161 */       else if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType == 0)
/*     */       {
/* 163 */         IdipManager.removeBanRankAll(roleId);
/*     */       }
/*     */     }
/* 166 */     if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBan == 1)
/*     */     {
/* 168 */       if (roleId == -1L)
/*     */       {
/* 170 */         ForbidInfoManager.unforbidUser(userId);
/*     */       }
/*     */       else
/*     */       {
/* 174 */         if (!isRoleExist(roleId, xUser))
/*     */         {
/* 176 */           onRoleNotFound(userId, xUser);
/* 177 */           return false;
/*     */         }
/*     */         
/* 180 */         ForbidInfoManager.unforbidRole(roleId);
/*     */       }
/*     */     }
/* 183 */     if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveMaskchat == 1)
/*     */     {
/* 185 */       if (!isRoleExist(roleId, xUser))
/*     */       {
/* 187 */         onRoleNotFound(userId, xUser);
/* 188 */         return false;
/*     */       }
/*     */       
/* 191 */       ForbidInfoManager.unforbidTalk(roleId);
/*     */     }
/* 193 */     if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveLockUsrInfo == 1)
/*     */     {
/* 195 */       if (!isRoleExist(roleId, xUser))
/*     */       {
/* 197 */         onRoleNotFound(userId, xUser);
/* 198 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 202 */       IdipManager.removeLockRoleInfo(roleId, 1);
/*     */     }
/* 204 */     if (((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveZeroProfit == 1)
/*     */     {
/* 206 */       if (!isRoleExist(roleId, xUser))
/*     */       {
/* 208 */         onRoleNotFound(userId, xUser);
/* 209 */         return false;
/*     */       }
/*     */       
/* 212 */       IdipManager.relieveZeroProfit(roleId);
/*     */     }
/*     */     
/* 215 */     ((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).Result = 0;
/* 216 */     ((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).RetMsg = "ok";
/* 217 */     ((IDIPCmd_AqDoRelievePunishReq)this.cmd).sendResponse();
/*     */     
/* 219 */     StringBuilder logStr = new StringBuilder();
/* 220 */     logStr.append(((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).head.SendTime).append("|");
/* 221 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).OpenId).append("|");
/* 222 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).AreaId).append("|");
/* 223 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Partition).append("|");
/* 224 */     logStr.append(roleId).append("|");
/* 225 */     logStr.append(0).append("|");
/*     */     
/* 227 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanPlay).append("|");
/* 228 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType).append("|");
/* 229 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanJoinRank).append("|");
/* 230 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType).append("|");
/* 231 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBan).append("|");
/* 232 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveMaskchat).append("|");
/* 233 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveLockUsrInfo).append("|");
/* 234 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveZeroProfit).append("|");
/* 235 */     logStr.append(((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).head.Cmdid).append("|");
/* 236 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Serial).append("|");
/* 237 */     logStr.append(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Source).append("|");
/* 238 */     logStr.append(((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).Result).append("|");
/* 239 */     logStr.append(((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 241 */     if (roleId != -1L)
/*     */     {
/* 243 */       TLogManager.getInstance().addLog(roleId, "AqIDIPDoRelievePunish", logStr.toString());
/*     */     }
/*     */     else
/*     */     {
/* 247 */       TLogManager.getInstance().addLog(QingfuInterface.getSuitableRoleId(userId), "AqIDIPDoRelievePunish", logStr.toString());
/*     */     }
/*     */     
/*     */ 
/* 251 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoRelievePunishReq.handle@do relieve punish done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|relieve_banPlay=%d|relieve_playType=%d|relieve_banJoinRank=%d|relieve_banRankType=%d|relieve_ban=%d|relieve_maskChat=%d|relieve_lockUsrInfo=%d|relieve_zeroProfit=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanPlay), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanJoinRank), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBan), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveMaskchat), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveLockUsrInfo), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveZeroProfit), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Source), ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 260 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 266 */     return ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Serial;
/*     */   }
/*     */   
/*     */   private boolean isRoleExist(long roleId, xbean.User xUser)
/*     */   {
/* 271 */     if (roleId == -1L)
/*     */     {
/* 273 */       return false;
/*     */     }
/* 275 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 277 */       return false;
/*     */     }
/* 279 */     return true;
/*     */   }
/*     */   
/*     */   private void onRoleNotFound(String userId, xbean.User xUser)
/*     */   {
/* 284 */     ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).Result = 1);
/* 285 */     ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRelievePunishRsp)((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/* 286 */     ((IDIPCmd_AqDoRelievePunishReq)this.cmd).sendResponse();
/*     */     
/* 288 */     GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRelievePunishReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|relieve_banPlay=%d|relieve_playType=%d|relieve_banJoinRank=%d|relieve_banRankType=%d|relieve_ban=%d|relieve_maskChat=%d|relieve_lockUsrInfo=%d|relieve_zeroProfit=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRelievePunishRsp)((IDIPCmd_AqDoRelievePunishReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Partition), ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).OpenId, ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanPlay), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelievePlayType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBanJoinRank), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveRankType), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveBan), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveMaskchat), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveLockUsrInfo), Byte.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).RelieveZeroProfit), Integer.valueOf(((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Source), ((AqDoRelievePunishReq)((IDIPPacket_AqDoRelievePunishReq)((IDIPCmd_AqDoRelievePunishReq)this.cmd).req).body).Serial }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoRelievePunishReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
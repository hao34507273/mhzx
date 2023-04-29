/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoRolelistDataReq;
/*     */ import idip.AqDoRolelistDataRsp;
/*     */ import idip.IDIPCmd_AqDoRolelistDataReq;
/*     */ import idip.IDIPPacket_AqDoRolelistDataReq;
/*     */ import idip.IDIPPacket_AqDoRolelistDataRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.arena.main.ArenaInterface;
/*     */ import mzm.gsp.bigboss.main.BigbossInterface;
/*     */ import mzm.gsp.item.main.ItemGiveManager;
/*     */ import mzm.gsp.jingji.main.JingjiInterface;
/*     */ import mzm.gsp.paraselene.main.ParaseleneInterface;
/*     */ import mzm.gsp.qmhw.main.QMHWInterface;
/*     */ import mzm.gsp.question.main.QuestionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoRolelistDataReq extends PIDIPCmd<IDIPCmd_AqDoRolelistDataReq>
/*     */ {
/*     */   private static final int ALL = 99;
/*  28 */   private static final Map<Integer, Integer> rankType = new HashMap();
/*     */   
/*     */   static {
/*  31 */     rankType.put(Integer.valueOf(1), Integer.valueOf(0));
/*  32 */     rankType.put(Integer.valueOf(2), Integer.valueOf(2));
/*  33 */     rankType.put(Integer.valueOf(3), Integer.valueOf(1));
/*  34 */     rankType.put(Integer.valueOf(4), Integer.valueOf(3));
/*  35 */     rankType.put(Integer.valueOf(5), Integer.valueOf(4));
/*  36 */     rankType.put(Integer.valueOf(6), Integer.valueOf(7));
/*  37 */     rankType.put(Integer.valueOf(7), Integer.valueOf(8));
/*  38 */     rankType.put(Integer.valueOf(8), Integer.valueOf(9));
/*  39 */     rankType.put(Integer.valueOf(9), Integer.valueOf(10));
/*  40 */     rankType.put(Integer.valueOf(10), Integer.valueOf(6));
/*  41 */     rankType.put(Integer.valueOf(11), Integer.valueOf(5));
/*     */     
/*  43 */     rankType.put(Integer.valueOf(12), Integer.valueOf(11));
/*  44 */     rankType.put(Integer.valueOf(13), Integer.valueOf(12));
/*  45 */     rankType.put(Integer.valueOf(14), Integer.valueOf(13));
/*  46 */     rankType.put(Integer.valueOf(15), Integer.valueOf(14));
/*     */   }
/*     */   
/*     */   public PIDIPCmd_AqDoRolelistDataReq(IDIPCmd_AqDoRolelistDataReq cmd)
/*     */   {
/*  51 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  57 */     String openId = ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).OpenId;
/*  58 */     int areaId = ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).AreaId;
/*  59 */     int partition = ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Partition;
/*     */     
/*  61 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  62 */     xbean.User xUser = xtable.User.get(userId);
/*  63 */     if (null == xUser)
/*     */     {
/*  65 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result = 1;
/*  66 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  67 */       ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */       
/*  69 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     if (((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  81 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).Result = 1);
/*  82 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  84 */       ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */       
/*  86 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@roleid length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  98 */       roleId = Long.parseLong(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/* 102 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).Result = 1);
/* 103 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 104 */       ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */       
/* 106 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 117 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result = 1;
/* 118 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/* 119 */       ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */       
/* 121 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 131 */     Integer type = (Integer)rankType.get(new Integer(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type));
/* 132 */     if ((type == null) && (((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type != 99))
/*     */     {
/* 134 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).Result = 'ﭐ');
/* 135 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).RetMsg = "rank type not exist");
/* 136 */       ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */       
/* 138 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@rank type not exist|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */       return false;
/*     */     }
/* 146 */     if (type == null)
/*     */     {
/* 148 */       type = Integer.valueOf(99);
/*     */     }
/*     */     
/* 151 */     int value = ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value;
/* 152 */     if (value < 0)
/*     */     {
/* 154 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).Result = 'ﭏ');
/* 155 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).RetMsg = "rank value < 0");
/* 156 */       ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */       
/* 158 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@rank value invalid|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 168 */     boolean success = true;
/* 169 */     switch (type.intValue())
/*     */     {
/*     */     case 0: 
/*     */     case 1: 
/*     */     case 2: 
/*     */     case 12: 
/*     */     case 13: 
/* 176 */       success = false;
/* 177 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 9: 
/* 182 */       success = false;
/* 183 */       break;
/*     */     
/*     */     case 11: 
/* 186 */       success = false;
/* 187 */       break;
/*     */     case 3: 
/* 189 */       JingjiInterface.insertIntoRankForIdip(roleId, value);
/* 190 */       break;
/*     */     case 4: 
/* 192 */       QuestionInterface.insertIntoRankForIdip(roleId, value);
/* 193 */       break;
/*     */     case 7: 
/* 195 */       success = ArenaInterface.setScore(roleId, value);
/* 196 */       break;
/*     */     case 8: 
/* 198 */       BigbossInterface.insertIntoRankForIdip(roleId, value);
/* 199 */       break;
/*     */     case 10: 
/* 201 */       ParaseleneInterface.insertIntoRankForIdip(roleId, value);
/* 202 */       break;
/*     */     case 6: 
/* 204 */       ItemGiveManager.insertIntoRankForIdip(roleId, value, -1);
/* 205 */       break;
/*     */     case 5: 
/* 207 */       ItemGiveManager.insertIntoRankForIdip(roleId, -1, value);
/* 208 */       break;
/*     */     case 14: 
/* 210 */       QMHWInterface.setScoreForIDIP(roleId, value);
/* 211 */       break;
/*     */     case 99: 
/* 213 */       JingjiInterface.insertIntoRankForIdip(roleId, value);
/* 214 */       QuestionInterface.insertIntoRankForIdip(roleId, value);
/* 215 */       BigbossInterface.insertIntoRankForIdip(roleId, value);
/* 216 */       ParaseleneInterface.insertIntoRankForIdip(roleId, value);
/* 217 */       ItemGiveManager.insertIntoRankForIdip(roleId, value, -1);
/* 218 */       ItemGiveManager.insertIntoRankForIdip(roleId, -1, value);
/*     */       
/*     */ 
/* 221 */       ArenaInterface.setScore(roleId, value);
/* 222 */       QMHWInterface.setScoreForIDIP(roleId, value);
/* 223 */       break;
/*     */     default: 
/* 225 */       success = false;
/*     */     }
/*     */     
/*     */     
/* 229 */     if (!success)
/*     */     {
/* 231 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).Result = 'פֿ');
/* 232 */       ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg = (((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).RetMsg = "rank type not support");
/* 233 */       ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */       
/* 235 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@rank type unsupport|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Partition), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).OpenId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 242 */       return false;
/*     */     }
/*     */     
/* 245 */     ((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).Result = 0;
/* 246 */     ((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).RetMsg = "ok";
/* 247 */     ((IDIPCmd_AqDoRolelistDataReq)this.cmd).sendResponse();
/*     */     
/* 249 */     StringBuilder logStr = new StringBuilder();
/* 250 */     logStr.append(((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).head.SendTime).append("|");
/* 251 */     logStr.append(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).OpenId).append("|");
/* 252 */     logStr.append(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).AreaId).append("|");
/* 253 */     logStr.append(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Partition).append("|");
/* 254 */     logStr.append(roleId).append("|");
/* 255 */     logStr.append(0).append("|");
/* 256 */     logStr.append(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type).append("|");
/* 257 */     logStr.append(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value).append("|");
/* 258 */     logStr.append(((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).head.Cmdid).append("|");
/* 259 */     logStr.append(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial).append("|");
/* 260 */     logStr.append(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source).append("|");
/* 261 */     logStr.append(((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).Result).append("|");
/* 262 */     logStr.append(((AqDoRolelistDataRsp)((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 264 */     TLogManager.getInstance().addLog(roleId, "AqIDIPDoRolelistData", logStr.toString());
/*     */     
/* 266 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoRolelistDataReq.handle@do role list data done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoRolelistDataRsp)((IDIPCmd_AqDoRolelistDataReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Source), ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 273 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 279 */     return ((AqDoRolelistDataReq)((IDIPPacket_AqDoRolelistDataReq)((IDIPCmd_AqDoRolelistDataReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoRolelistDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
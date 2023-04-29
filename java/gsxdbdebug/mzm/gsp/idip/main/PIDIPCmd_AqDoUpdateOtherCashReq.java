/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoUpdateOtherCashReq;
/*     */ import idip.AqDoUpdateOtherCashRsp;
/*     */ import idip.IDIPCmd_AqDoUpdateOtherCashReq;
/*     */ import idip.IDIPPacket_AqDoUpdateOtherCashReq;
/*     */ import idip.IDIPPacket_AqDoUpdateOtherCashRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.BanggongOperateEnum;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.main.JifenOperateEnum;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleExpUpdateRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.VigorOperResult;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpOperResult;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoUpdateOtherCashReq extends PIDIPCmd<IDIPCmd_AqDoUpdateOtherCashReq>
/*     */ {
/*     */   private static final int GANG_CONTRIBUTION = 7;
/*     */   private static final int ALL = 99;
/*  31 */   private static final Map<Integer, Integer> currencyTypeMap = new HashMap();
/*     */   
/*     */   static {
/*  34 */     currencyTypeMap.put(Integer.valueOf(1), Integer.valueOf(5));
/*  35 */     currencyTypeMap.put(Integer.valueOf(2), Integer.valueOf(13));
/*  36 */     currencyTypeMap.put(Integer.valueOf(3), Integer.valueOf(8));
/*  37 */     currencyTypeMap.put(Integer.valueOf(4), Integer.valueOf(9));
/*  38 */     currencyTypeMap.put(Integer.valueOf(5), Integer.valueOf(11));
/*  39 */     currencyTypeMap.put(Integer.valueOf(6), Integer.valueOf(12));
/*  40 */     currencyTypeMap.put(Integer.valueOf(7), Integer.valueOf(7));
/*  41 */     currencyTypeMap.put(Integer.valueOf(99), Integer.valueOf(99));
/*     */   }
/*     */   
/*     */   private OperateResult doUpdate(long roleId, int value)
/*     */   {
/*  46 */     OperateResult result = null;
/*  47 */     int type = ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type;
/*  48 */     switch (type)
/*     */     {
/*     */     case 1: 
/*  51 */       result = doUpdateRoleExp(roleId, value);
/*  52 */       break;
/*     */     case 2: 
/*  54 */       result = doUpdateStoreExp(roleId, value);
/*  55 */       break;
/*     */     case 3: 
/*  57 */       result = doUpdateCompetitivePoint(roleId, value);
/*  58 */       break;
/*     */     case 4: 
/*  60 */       result = doUpdateChivalrous(roleId, value);
/*  61 */       break;
/*     */     case 5: 
/*  63 */       result = doUpdateReputation(roleId, value);
/*  64 */       break;
/*     */     case 6: 
/*  66 */       result = doUpdateVigor(roleId, value);
/*  67 */       break;
/*     */     case 7: 
/*  69 */       result = doUpdateGangContribution(roleId, value);
/*  70 */       break;
/*     */     case 99: 
/*  72 */       result = doUpdateAll(roleId, value);
/*     */     }
/*     */     
/*  75 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private OperateResult doUpdateAll(long roleId, int value)
/*     */   {
/*  81 */     OperateResult result = null;
/*     */     
/*     */ 
/*  84 */     result = doUpdateRoleExp(roleId, value);
/*  85 */     if (!result.success)
/*     */     {
/*  87 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  91 */     result = doUpdateStoreExp(roleId, value);
/*  92 */     if (!result.success)
/*     */     {
/*  94 */       return result;
/*     */     }
/*     */     
/*     */ 
/*  98 */     result = doUpdateCompetitivePoint(roleId, value);
/*  99 */     if (!result.success)
/*     */     {
/* 101 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 105 */     result = doUpdateChivalrous(roleId, value);
/* 106 */     if (!result.success)
/*     */     {
/* 108 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 112 */     result = doUpdateReputation(roleId, value);
/* 113 */     if (!result.success)
/*     */     {
/* 115 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 119 */     result = doUpdateVigor(roleId, value);
/* 120 */     if (!result.success)
/*     */     {
/* 122 */       return result;
/*     */     }
/*     */     
/*     */ 
/* 126 */     result = doUpdateGangContribution(roleId, value);
/* 127 */     if (!result.success)
/*     */     {
/* 129 */       return result;
/*     */     }
/*     */     
/* 132 */     result.success = true;
/* 133 */     result.beginValue = 0;
/* 134 */     result.endValue = 0;
/* 135 */     result.ret = 0;
/* 136 */     result.retMsg = "OK";
/* 137 */     return result;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateGangContribution(long roleId, int value)
/*     */   {
/* 142 */     int beginValue = (int)GangInterface.getBangGong(roleId);
/*     */     
/* 144 */     BanggongOperateEnum result = null;
/* 145 */     if (value >= 0)
/*     */     {
/* 147 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_ADD);
/* 148 */       result = GangInterface.addBangGongForAqIdip(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 152 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_REM);
/* 153 */       result = GangInterface.cutBangGongForAqIdip(roleId, -value, tLogArg);
/*     */     }
/* 155 */     int endValue = (int)GangInterface.getBangGong(roleId);
/*     */     
/* 157 */     OperateResult operateResult = new OperateResult(null);
/* 158 */     operateResult.ret = result.ret;
/* 159 */     operateResult.retMsg = result.retMsg;
/* 160 */     if ((result != BanggongOperateEnum.SUCCESS) && (result != BanggongOperateEnum.ERROR_CLEAR_FOR_AQIDIP))
/*     */     {
/* 162 */       operateResult.success = false;
/* 163 */       operateResult.reason = "update gang contribution failed";
/* 164 */       return operateResult;
/*     */     }
/* 166 */     operateResult.beginValue = beginValue;
/* 167 */     operateResult.endValue = endValue;
/* 168 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateVigor(long roleId, int value)
/*     */   {
/* 173 */     Role role = RoleInterface.getRole(roleId, true);
/* 174 */     int beginValue = role.getVigor();
/*     */     
/* 176 */     VigorOperResult result = null;
/* 177 */     if (value >= 0)
/*     */     {
/* 179 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_ADD);
/* 180 */       result = RoleInterface.addVigorByAqIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 184 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_REM);
/* 185 */       result = RoleInterface.cutVigorByAqIDIP(roleId, -value, tLogArg);
/*     */     }
/* 187 */     int endValue = role.getVigor();
/*     */     
/* 189 */     OperateResult operateResult = new OperateResult(null);
/* 190 */     operateResult.ret = result.ret;
/* 191 */     operateResult.retMsg = result.retMsg;
/* 192 */     if ((result != VigorOperResult.SUCCESS) && (result != VigorOperResult.VIGOR_CLEAR_FOR_AQIDIP))
/*     */     {
/* 194 */       operateResult.success = false;
/* 195 */       operateResult.reason = "update vigor failed";
/* 196 */       return operateResult;
/*     */     }
/* 198 */     operateResult.beginValue = beginValue;
/* 199 */     operateResult.endValue = endValue;
/* 200 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateReputation(long roleId, int value)
/*     */   {
/* 205 */     int beginValue = (int)MallInterface.getJifen(roleId, 4);
/* 206 */     JifenOperateEnum result = null;
/* 207 */     if (value >= 0)
/*     */     {
/* 209 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_ADD);
/* 210 */       result = MallInterface.addJifenForAqIdip(roleId, value, 4, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 214 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_REM);
/* 215 */       result = MallInterface.cutJifenForAqIdip(roleId, -value, 4, tLogArg);
/*     */     }
/* 217 */     int endValue = (int)MallInterface.getJifen(roleId, 4);
/*     */     
/* 219 */     OperateResult operateResult = new OperateResult(null);
/* 220 */     operateResult.ret = result.ret;
/* 221 */     operateResult.retMsg = result.retMsg;
/* 222 */     if ((result != JifenOperateEnum.SUCCESS) && (result != JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/* 224 */       operateResult.success = false;
/* 225 */       operateResult.reason = "update reputation failed";
/* 226 */       return operateResult;
/*     */     }
/* 228 */     operateResult.beginValue = beginValue;
/* 229 */     operateResult.endValue = endValue;
/* 230 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateChivalrous(long roleId, int value)
/*     */   {
/* 235 */     int beginValue = (int)MallInterface.getJifen(roleId, 1);
/* 236 */     JifenOperateEnum result = null;
/* 237 */     if (value >= 0)
/*     */     {
/* 239 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_ADD);
/* 240 */       result = MallInterface.addJifenForAqIdip(roleId, value, 1, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 244 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_REM);
/* 245 */       result = MallInterface.cutJifenForAqIdip(roleId, -value, 1, tLogArg);
/*     */     }
/* 247 */     int endValue = (int)MallInterface.getJifen(roleId, 1);
/*     */     
/* 249 */     OperateResult operateResult = new OperateResult(null);
/* 250 */     operateResult.ret = result.ret;
/* 251 */     operateResult.retMsg = result.retMsg;
/* 252 */     if ((result != JifenOperateEnum.SUCCESS) && (result != JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/* 254 */       operateResult.success = false;
/* 255 */       operateResult.reason = "update chivalrous failed";
/* 256 */       return operateResult;
/*     */     }
/* 258 */     operateResult.beginValue = beginValue;
/* 259 */     operateResult.endValue = endValue;
/* 260 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateCompetitivePoint(long roleId, int value)
/*     */   {
/* 265 */     JifenOperateEnum result = null;
/* 266 */     int beginValue = (int)MallInterface.getJifen(roleId, 2);
/* 267 */     if (value >= 0)
/*     */     {
/* 269 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_ADD);
/* 270 */       result = MallInterface.addJifenForAqIdip(roleId, value, 2, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 274 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_REM);
/* 275 */       result = MallInterface.cutJifenForAqIdip(roleId, -value, 2, tLogArg);
/*     */     }
/* 277 */     int endValue = (int)MallInterface.getJifen(roleId, 2);
/*     */     
/* 279 */     OperateResult operateResult = new OperateResult(null);
/* 280 */     operateResult.ret = result.ret;
/* 281 */     operateResult.retMsg = result.retMsg;
/* 282 */     if ((result != JifenOperateEnum.SUCCESS) && (result != JifenOperateEnum.JIFEN_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/* 284 */       operateResult.success = false;
/* 285 */       operateResult.reason = "update competitive point failed";
/* 286 */       return operateResult;
/*     */     }
/* 288 */     operateResult.beginValue = beginValue;
/* 289 */     operateResult.endValue = endValue;
/* 290 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateStoreExp(long roleId, int value)
/*     */   {
/* 295 */     StorageExpOperResult result = null;
/*     */     
/* 297 */     int beginValue = (int)StorageExpInterface.getCurCanUseStorageExp(roleId);
/* 298 */     if (value >= 0)
/*     */     {
/* 300 */       result = StorageExpInterface.addStorageForAqIdip(roleId, value);
/*     */     }
/*     */     else
/*     */     {
/* 304 */       result = StorageExpInterface.cutStorageExpForAqIdip(roleId, -value);
/*     */     }
/* 306 */     int endValue = (int)StorageExpInterface.getCurCanUseStorageExp(roleId);
/*     */     
/* 308 */     OperateResult operateResult = new OperateResult(null);
/* 309 */     operateResult.ret = result.ret;
/* 310 */     operateResult.retMsg = result.retMsg;
/* 311 */     if ((result != StorageExpOperResult.SUCCESS) && (result != StorageExpOperResult.STORAGEEXP_CLEAR_FOR_AQIDIP))
/*     */     {
/* 313 */       operateResult.success = false;
/* 314 */       operateResult.reason = "update storeExp failed";
/* 315 */       return operateResult;
/*     */     }
/* 317 */     operateResult.beginValue = beginValue;
/* 318 */     operateResult.endValue = endValue;
/* 319 */     return operateResult;
/*     */   }
/*     */   
/*     */   private OperateResult doUpdateRoleExp(long roleId, int value)
/*     */   {
/* 324 */     Role role = RoleInterface.getRole(roleId, true);
/* 325 */     int beginValue = role.getExp();
/* 326 */     RoleExpUpdateRet result = null;
/* 327 */     if (value >= 0)
/*     */     {
/* 329 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_ADD);
/* 330 */       result = role.addExpForAqIdip(value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 334 */       TLogArg tLogArg = new TLogArg(LogReason.AQIDIP_REM);
/* 335 */       result = role.cutExpForAqIdip(-value, tLogArg);
/*     */     }
/* 337 */     int endValue = role.getExp();
/*     */     
/* 339 */     OperateResult operateResult = new OperateResult(null);
/* 340 */     operateResult.ret = result.ret;
/* 341 */     operateResult.retMsg = result.retMsg;
/* 342 */     if ((result != RoleExpUpdateRet.SUCCESS) && (result != RoleExpUpdateRet.EXP_NUM_CLEAR_AQIDIP_ERROR) && (result != RoleExpUpdateRet.ROLE_LEVEL_HAS_REACH_TOP_LIMIT_ERROR))
/*     */     {
/*     */ 
/* 345 */       operateResult.success = false;
/* 346 */       operateResult.reason = "update exp failed";
/* 347 */       return operateResult;
/*     */     }
/* 349 */     operateResult.beginValue = beginValue;
/* 350 */     operateResult.endValue = endValue;
/* 351 */     return operateResult;
/*     */   }
/*     */   
/*     */   private final class OperateResult
/*     */   {
/* 356 */     public boolean success = true;
/*     */     public int ret;
/*     */     public String retMsg;
/*     */     public String reason;
/*     */     public int beginValue;
/*     */     public int endValue;
/*     */     
/*     */     private OperateResult() {}
/*     */   }
/*     */   
/* 366 */   public PIDIPCmd_AqDoUpdateOtherCashReq(IDIPCmd_AqDoUpdateOtherCashReq cmd) { super(cmd); }
/*     */   
/*     */ 
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/* 372 */     String openId = ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).OpenId;
/* 373 */     int areaId = ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).AreaId;
/* 374 */     int partition = ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Partition;
/*     */     
/* 376 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/* 377 */     xbean.User xUser = xtable.User.get(userId);
/* 378 */     if (null == xUser)
/*     */     {
/* 380 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).Result = 1);
/* 381 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/* 382 */       ((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).sendResponse();
/*     */       
/* 384 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateOtherCashReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source), ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 390 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 394 */     if (((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/* 396 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).Result = 1);
/* 397 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/* 399 */       ((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).sendResponse();
/*     */       
/* 401 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateOtherCashReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source), ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 407 */       return false;
/*     */     }
/*     */     
/* 410 */     long roleId = -1L;
/*     */     try
/*     */     {
/* 413 */       roleId = Long.parseLong(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/* 417 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).Result = 1);
/* 418 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 419 */       ((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).sendResponse();
/*     */       
/* 421 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateOtherCashReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source), ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 427 */       return false;
/*     */     }
/*     */     
/* 430 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 432 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).Result = 1);
/* 433 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/* 434 */       ((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).sendResponse();
/*     */       
/* 436 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateOtherCashReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source), ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 442 */       return false;
/*     */     }
/*     */     
/* 445 */     int type = ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type;
/* 446 */     Integer currencyType = (Integer)currencyTypeMap.get(Integer.valueOf(type));
/* 447 */     if (currencyType == null)
/*     */     {
/* 449 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = (((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = 'ﮠ');
/* 450 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).RetMsg = "cash type not exist");
/* 451 */       ((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).sendResponse();
/*     */       
/* 453 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateOtherCashReq.handle@cash type not exist|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source), ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 459 */       return false;
/*     */     }
/*     */     
/* 462 */     int value = ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value;
/* 463 */     OperateResult result = doUpdate(roleId, value);
/* 464 */     if (!result.success)
/*     */     {
/* 466 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).Result = result.ret);
/* 467 */       ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).RetMsg = result.retMsg);
/* 468 */       ((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).sendResponse();
/*     */       
/* 470 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateOtherCashReq.handle@%s|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { result.reason, Integer.valueOf(((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source), ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 476 */       return false;
/*     */     }
/*     */     
/* 479 */     ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).Result = 0);
/* 480 */     ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateOtherCashRsp)((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).body).RetMsg = result.retMsg);
/* 481 */     ((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).sendResponse();
/*     */     
/* 483 */     StringBuilder logStr = new StringBuilder();
/* 484 */     logStr.append(((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).head.SendTime).append("|");
/* 485 */     logStr.append(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).OpenId).append("|");
/* 486 */     logStr.append(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).AreaId).append("|");
/* 487 */     logStr.append(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Partition).append("|");
/* 488 */     logStr.append(roleId).append("|");
/* 489 */     logStr.append(0).append("|");
/* 490 */     logStr.append(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type).append("|");
/* 491 */     logStr.append(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value).append("|");
/* 492 */     logStr.append(((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).head.Cmdid).append("|");
/* 493 */     logStr.append(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial).append("|");
/* 494 */     logStr.append(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source).append("|");
/* 495 */     logStr.append(result.beginValue).append("|");
/* 496 */     logStr.append(result.endValue).append("|");
/* 497 */     logStr.append(result.ret).append("|");
/* 498 */     logStr.append(result.retMsg);
/*     */     
/* 500 */     TLogManager.getInstance().addLog(roleId, "AqIDIPDoUpdateOtherCash", logStr.toString());
/*     */     
/* 502 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoUpdateOtherCashReq.handle@update other cash success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateOtherCashRsp)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Source), ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial, Integer.valueOf(result.beginValue), Integer.valueOf(result.endValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 508 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 514 */     return ((AqDoUpdateOtherCashReq)((IDIPPacket_AqDoUpdateOtherCashReq)((IDIPCmd_AqDoUpdateOtherCashReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoUpdateOtherCashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
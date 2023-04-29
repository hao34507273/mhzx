/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SCleanHomeRes;
/*     */ import mzm.gsp.homeland.SCommonResultRes;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.confbean.SMaidCfg;
/*     */ import mzm.gsp.homeland.confbean.SMaidRoomCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PCleanHomeReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int area;
/*     */   private boolean isOwner;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCleanHomeReq(long roleId, int area)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.area = area;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if ((this.area != 1) && (this.area != 2))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  54 */       String logStr = String.format("[home]PCleanHomeReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  55 */       HomelandManager.logger.info(logStr);
/*  56 */       return false;
/*     */     }
/*  58 */     String userid = RoleInterface.getUserId(this.roleId);
/*  59 */     if (userid == null)
/*     */     {
/*  61 */       String logString = String.format("[home]PCleanHomeReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  63 */       HomelandManager.logger.error(logString);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  68 */     if (homeInfoWrapper == null)
/*     */     {
/*  70 */       String logString = String.format("[home]PCleanHomeReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  72 */       HomelandManager.logger.warn(logString);
/*     */       
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  78 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  80 */       String logString = String.format("[home]PCleanHomeReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  84 */       HomelandManager.logger.info(logString);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     this.isOwner = (homeInfoWrapper.getOwnerRoleId() == this.roleId);
/*  89 */     this.partnerRoleId = (this.isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId());
/*  90 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  92 */     boolean result = false;
/*  93 */     if (this.area == 1)
/*     */     {
/*  95 */       result = cleanRoom(userid, homeInfoWrapper, currentTimeMillis);
/*     */     }
/*     */     else
/*     */     {
/*  99 */       result = cleanCourtYard(userid, homeInfoWrapper, currentTimeMillis);
/*     */     }
/*     */     
/* 102 */     return result;
/*     */   }
/*     */   
/*     */   private boolean cleanRoom(String userId, HomeInfoWrapper homeInfoWrapper, long currentTimeMillis)
/*     */   {
/* 107 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 108 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/* 112 */       String logString = String.format("[home]PCleanHomeReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/* 114 */       HomelandManager.logger.warn(logString);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 119 */     HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/*     */     
/* 121 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/* 123 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 124 */     if (sHomelandCfg == null)
/*     */     {
/* 126 */       String logString = String.format("[home]PCleanHomeReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 130 */       HomelandManager.logger.error(logString);
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 135 */     int oldcleanliness = xHomeInfo.getCleanliness();
/* 136 */     if (oldcleanliness >= sHomelandCfg.maxCleanliness)
/*     */     {
/* 138 */       String logString = String.format("[home]PCleanHomeReq.processImp@home cleanliness to max|roleId=%d|partnerRoleid=%d|homeLevel=%d|cleanliness=%d|maxCleanliness=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(oldcleanliness), Integer.valueOf(sHomelandCfg.maxCleanliness) });
/*     */       
/*     */ 
/*     */ 
/* 142 */       HomelandManager.logger.info(logString);
/* 143 */       HomelandManager.sendSCommonResultRes(this.roleId, 10);
/* 144 */       return false;
/*     */     }
/* 146 */     SMaidRoomCfg sMaidRoomCfg = SMaidRoomCfg.get(xHomeInfo.getMaidroomlevel());
/* 147 */     if (sMaidRoomCfg == null)
/*     */     {
/* 149 */       String logString = String.format("[home]PCleanHomeReq.processImp@SMaidRoomCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(xHomeInfo.getMaidroomlevel()) });
/*     */       
/*     */ 
/*     */ 
/* 153 */       HomelandManager.logger.error(logString);
/* 154 */       return false;
/*     */     }
/* 156 */     if (xHomeInfo.getDaycleancount() >= sMaidRoomCfg.dayCleanCount)
/*     */     {
/* 158 */       String logString = String.format("[home]PCleanHomeReq.processImp@day clean count not enough|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|dayCleanCount=%d|maxDayCleanCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(xHomeInfo.getDaycleancount()), Integer.valueOf(sMaidRoomCfg.dayCleanCount) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 163 */       HomelandManager.logger.error(logString);
/* 164 */       HomelandManager.sendSCommonResultRes(this.roleId, 9);
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     int currentMaidCfgId = HomelandManager.getCurrentMaidCfgId(xHomeInfo);
/* 169 */     SMaidCfg sMaidCfg = SMaidCfg.get(HomelandManager.getCurrentMaidCfgId(xHomeInfo));
/* 170 */     if (sMaidCfg == null)
/*     */     {
/* 172 */       String logString = String.format("[home]PCleanHomeReq.processImp@SMaidCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|currentMaid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(currentMaidCfgId) });
/*     */       
/*     */ 
/* 175 */       HomelandManager.logger.error(logString);
/* 176 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 180 */     int currCleanliness = xHomeInfo.getCleanliness();
/* 181 */     if (currCleanliness >= sHomelandCfg.maxCleanliness)
/*     */     {
/* 183 */       String logString = String.format("[home]PCleanHomeReq.processImp@cleanliness already to max|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|currentMaid=%d|currCleanliness=%d|maxCleanliness", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(currentMaidCfgId), Integer.valueOf(currCleanliness), Integer.valueOf(sHomelandCfg.maxCleanliness) });
/*     */       
/*     */ 
/*     */ 
/* 187 */       HomelandManager.logger.error(logString);
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     int addCleanliness = Math.min(sHomelandCfg.maxCleanliness - currCleanliness, sMaidCfg.addCleanliness);
/* 192 */     int needMoney = addCleanliness * sMaidCfg.cleanMoneyNum;
/* 193 */     if (needMoney > 0)
/*     */     {
/* 195 */       boolean ret = HomelandManager.cutMoney(userId, this.roleId, LogReason.HOME_CLEAN, currentMaidCfgId, sMaidCfg.cleanMoneyType, needMoney, CostType.COST_BIND_FIRST_CLEAN_HOME);
/*     */       
/* 197 */       if (!ret)
/*     */       {
/* 199 */         String logString = String.format("[home]PCleanHomeReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidid=%d|moneyType=%d|moneyNum=%d||addCleanlinessNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentMaidCfgId), Integer.valueOf(sMaidCfg.cleanMoneyType), Integer.valueOf(needMoney), Integer.valueOf(addCleanliness) });
/*     */         
/*     */ 
/* 202 */         HomelandManager.logger.error(logString);
/* 203 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 208 */       String logString = String.format("[home]PCleanHomeReq.processImp@needMoney money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidid=%d|moneyType=%d|moneyNum=%d||addCleanlinessNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentMaidCfgId), Integer.valueOf(sMaidCfg.cleanMoneyType), Integer.valueOf(needMoney), Integer.valueOf(addCleanliness) });
/*     */       
/*     */ 
/* 211 */       HomelandManager.logger.error(logString);
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     xHomeInfo.setDaycleancount(xHomeInfo.getDaycleancount() + 1);
/* 216 */     int oldCleanliness = xHomeInfo.getCleanliness();
/* 217 */     xHomeInfo.setCleanliness(xHomeInfo.getCleanliness() + addCleanliness);
/*     */     
/* 219 */     SCleanHomeRes res = new SCleanHomeRes();
/* 220 */     res.addcleanliness = (xHomeInfo.getCleanliness() - oldCleanliness);
/* 221 */     res.daycleancount = xHomeInfo.getDaycleancount();
/* 222 */     res.area = this.area;
/* 223 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 225 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 227 */       HomelandManager.sendSSynCleanlinessRes(this.partnerRoleId, xHomeInfo.getCleanliness(), xHomeInfo.getDaycleancount(), this.area);
/*     */     }
/*     */     
/*     */ 
/* 231 */     HomelandManager.changeHomeCleanlinessIntoWorld(homeInfoWrapper);
/*     */     
/* 233 */     String logString = String.format("[home]PCleanHomeReq.processImp@clean home success|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|dayCleanCount=%d|maxDayCleanCount=%d|oldCleanliness=%d|newCleanliness=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(xHomeInfo.getDaycleancount()), Integer.valueOf(sMaidRoomCfg.dayCleanCount), Integer.valueOf(oldCleanliness), Integer.valueOf(xHomeInfo.getCleanliness()) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 238 */     HomelandManager.logger.info(logString);
/*     */     
/* 240 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 241 */     tlogCleanHome(userId, roleLevel, sMaidCfg, currentMaidCfgId, oldcleanliness, res.addcleanliness, xHomeInfo, sMaidRoomCfg.dayCleanCount - xHomeInfo.getDaycleancount(), this.isOwner, this.partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/*     */ 
/* 245 */     HomelandManager.triggerCleanlinessChangedEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), oldcleanliness, xHomeInfo.getCleanliness());
/*     */     
/* 247 */     return true;
/*     */   }
/*     */   
/*     */   private boolean cleanCourtYard(String userId, HomeInfoWrapper homeInfoWrapper, long currentTimeMillis)
/*     */   {
/* 252 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 253 */     CourtYardManager.checkAndInitCourtYardCleanliness(xHomeInfo);
/* 254 */     int courtYardLevel = xHomeInfo.getCourtyardlevel();
/* 255 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(courtYardLevel);
/* 256 */     if (sCourtyardCfg == null)
/*     */     {
/* 258 */       Map<String, Object> extraMap = new HashMap();
/* 259 */       extraMap.put("current_court_level", Integer.valueOf(courtYardLevel));
/*     */       
/* 261 */       onCleanHomeReqFail(28, extraMap);
/* 262 */       return false;
/*     */     }
/*     */     
/* 265 */     CourtYardManager.cutCourtYardCleanliness(homeInfoWrapper, currentTimeMillis);
/* 266 */     int currCleanliness = xHomeInfo.getCourt_yard_cleanliness();
/* 267 */     if (xHomeInfo.getCourt_yard_day_clean_count() >= sCourtyardCfg.day_clean_max_count)
/*     */     {
/* 269 */       Map<String, Object> extraMap = new HashMap();
/* 270 */       extraMap.put("day_clean_max_count", Integer.valueOf(sCourtyardCfg.day_clean_max_count));
/* 271 */       extraMap.put("now_court_yard_day_clean_count", Integer.valueOf(xHomeInfo.getCourt_yard_day_clean_count()));
/*     */       
/* 273 */       onCleanHomeReqFail(9, extraMap);
/* 274 */       return false;
/*     */     }
/*     */     
/* 277 */     if (currCleanliness >= sCourtyardCfg.max_cleanliness)
/*     */     {
/* 279 */       Map<String, Object> extraMap = new HashMap();
/* 280 */       extraMap.put("current_clean_liness", Integer.valueOf(currCleanliness));
/* 281 */       extraMap.put("max_clean_liness", Integer.valueOf(sCourtyardCfg.max_cleanliness));
/*     */       
/* 283 */       onCleanHomeReqFail(10, extraMap);
/* 284 */       return false;
/*     */     }
/*     */     
/* 287 */     int addCleanliness = Math.min(sCourtyardCfg.max_cleanliness - currCleanliness, sCourtyardCfg.add_cleanliness);
/* 288 */     int needMoney = addCleanliness * sCourtyardCfg.clean_need_money_num_every_cleanliness;
/* 289 */     if (needMoney > 0)
/*     */     {
/* 291 */       boolean ret = HomelandManager.cutMoney(userId, this.roleId, LogReason.COURT_YARD_CLEAN, 0, sCourtyardCfg.clean_money_type, needMoney, CostType.COST_BIND_FIRST_CLEAN_YARD);
/*     */       
/* 293 */       if (!ret)
/*     */       {
/* 295 */         onCleanHomeReqFail(31);
/* 296 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 301 */       return false;
/*     */     }
/*     */     
/* 304 */     xHomeInfo.setCourt_yard_day_clean_count(xHomeInfo.getCourt_yard_day_clean_count() + 1);
/* 305 */     xHomeInfo.setCourt_yard_cleanliness(currCleanliness + addCleanliness);
/*     */     
/* 307 */     SCleanHomeRes res = new SCleanHomeRes();
/* 308 */     res.addcleanliness = (xHomeInfo.getCourt_yard_cleanliness() - currCleanliness);
/* 309 */     res.daycleancount = xHomeInfo.getCourt_yard_day_clean_count();
/* 310 */     res.area = this.area;
/* 311 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 313 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 315 */       HomelandManager.sendSSynCleanlinessRes(this.partnerRoleId, xHomeInfo.getCourt_yard_cleanliness(), xHomeInfo.getCourt_yard_day_clean_count(), this.area);
/*     */     }
/*     */     
/*     */ 
/* 319 */     CourtYardManager.changeCourtYardCleanlinessIntoWorld(xHomeInfo, homeInfoWrapper.getOwnerRoleId());
/*     */     
/* 321 */     tlogCleanCourtYard(userId);
/*     */     
/* 323 */     StringBuilder sb = new StringBuilder();
/* 324 */     sb.append("[home]PCleanHomeReq.processImp@clean home success");
/* 325 */     sb.append("|role_id=").append(this.roleId);
/* 326 */     sb.append("|is_owner=").append(this.isOwner);
/* 327 */     sb.append("|partner_role_id=").append(this.partnerRoleId);
/* 328 */     sb.append("|area=").append(this.area);
/* 329 */     sb.append("|day_clean_count=").append(res.daycleancount);
/* 330 */     sb.append("|add_clean_liness=").append(res.addcleanliness);
/* 331 */     sb.append("|old_clean_liness=").append(currCleanliness);
/* 332 */     sb.append("|current_currean_liness=").append(xHomeInfo.getCourt_yard_cleanliness());
/*     */     
/* 334 */     GameServer.logger().info(sb.toString());
/*     */     
/* 336 */     return true;
/*     */   }
/*     */   
/*     */   private void onCleanHomeReqFail(int ret)
/*     */   {
/* 341 */     onCleanHomeReqFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCleanHomeReqFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 346 */     StringBuilder sb = new StringBuilder();
/* 347 */     sb.append("[home]PCleanHomeReq.processImp@clean home fail");
/* 348 */     sb.append("|role_id=").append(this.roleId);
/* 349 */     sb.append("|ret=").append(ret);
/* 350 */     sb.append("|is_owner=").append(this.isOwner);
/* 351 */     sb.append("|partner_role_id=").append(this.partnerRoleId);
/* 352 */     sb.append("|area=").append(this.area);
/*     */     
/* 354 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 356 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 358 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 362 */     GameServer.logger().error(sb.toString());
/*     */     
/* 364 */     SCommonResultRes sCommonResultRes = new SCommonResultRes();
/* 365 */     sCommonResultRes.res = ret;
/*     */     
/* 367 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogCleanHome(String userid, int roleLevel, SMaidCfg sMaidCfg, int currentMaidCfgId, int oldcleanliness, int addcleanliness, HomeInfo xHomeInfo, int restcleancount, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 374 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 376 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(sMaidCfg.cleanMoneyType), Integer.valueOf(sMaidCfg.cleanMoneyNum), Integer.valueOf(currentMaidCfgId), Integer.valueOf(oldcleanliness), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(addcleanliness), Integer.valueOf(xHomeInfo.getDaycleancount()), Integer.valueOf(restcleancount), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/*     */ 
/* 380 */     TLogManager.getInstance().addLog(userid, this.roleId, "CleanHome", columnns);
/*     */   }
/*     */   
/*     */   private void tlogCleanCourtYard(String userId)
/*     */   {
/* 385 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 387 */     StringBuilder sbLog = new StringBuilder();
/* 388 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 389 */     sbLog.append(userId).append('|');
/* 390 */     sbLog.append(this.roleId).append('|');
/* 391 */     sbLog.append(roleLevel);
/*     */     
/* 393 */     TLogManager.getInstance().addLog(this.roleId, "CourtYardCleanUp", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PCleanHomeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
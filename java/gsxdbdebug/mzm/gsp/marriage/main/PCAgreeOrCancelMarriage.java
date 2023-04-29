/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.SAgreeOrCancelMarriage;
/*     */ import mzm.gsp.marriage.SAgreeOrCancelMarriageErrorRes;
/*     */ import mzm.gsp.marriage.SBroadCastAllMarriage;
/*     */ import mzm.gsp.marriage.SBroadCastMarriage;
/*     */ import mzm.gsp.marriage.SSynMarriageInfo;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.marriage.confbean.SMarriageLevelCfg;
/*     */ import mzm.gsp.marriage.confbean.SMarriageTitileCfg;
/*     */ import mzm.gsp.marriage.event.MarriageArg;
/*     */ import mzm.gsp.marriage.event.MarriageEvent;
/*     */ import mzm.gsp.marriage.event.MarrySkillChange;
/*     */ import mzm.gsp.marriage.event.MarrySkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.qingyuan.main.QingYuanInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Ceremony;
/*     */ import xbean.Ceremonys;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2marriage;
/*     */ import xtable.Weddingceremony;
/*     */ 
/*     */ public class PCAgreeOrCancelMarriage extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int operator;
/*     */   private final long sessionid;
/*     */   
/*     */   public PCAgreeOrCancelMarriage(long roleid, int operator, long sessionid)
/*     */   {
/*  55 */     this.roleid = roleid;
/*  56 */     this.operator = operator;
/*  57 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  62 */     mzm.gsp.timer.main.Session session = MarryReqSession.getSession(this.sessionid);
/*  63 */     MarryReqSession marryReqSession = null;
/*     */     
/*  65 */     if ((session instanceof MarryReqSession)) {
/*  66 */       marryReqSession = (MarryReqSession)session;
/*     */     } else {
/*  68 */       GameServer.logger().info(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@marry request session not existed|sessionid=%d", new Object[] { Long.valueOf(this.sessionid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*  77 */     long reqRoleid = marryReqSession.getRoleid();
/*  78 */     long otherRoleid = marryReqSession.getOtherRoleid();
/*     */     
/*  80 */     if (this.operator == 1) {
/*  81 */       if (otherRoleid != this.roleid) {
/*  82 */         return false;
/*     */       }
/*     */       
/*  85 */       int levelCfgid = marryReqSession.getLevel();
/*  86 */       SMarriageLevelCfg marriageLevelCfg = SMarriageLevelCfg.get(levelCfgid);
/*  87 */       if (marriageLevelCfg == null) {
/*  88 */         GameServer.logger().info(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@marry level config not existed|cfgid=%d", new Object[] { Integer.valueOf(levelCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  92 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  96 */       String reqUserid = RoleInterface.getUserId(reqRoleid);
/*  97 */       String otherUserid = RoleInterface.getUserId(otherRoleid);
/*  98 */       lock(xtable.User.getTable(), Arrays.asList(new String[] { reqUserid, otherUserid }));
/*  99 */       List<Long> allRoles = Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) });
/*     */       
/* 101 */       lock(xtable.Role2properties.getTable(), allRoles);
/*     */       
/*     */ 
/* 104 */       if (!RoleStatusInterface.checkCansetStatus(allRoles, 37, true, allRoles)) {
/* 105 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 109 */       QingYuanInterface.clearQingYuanRelation(reqRoleid, otherRoleid);
/*     */       
/* 111 */       int relationValue = FriendInterface.getRelationValue(reqRoleid, otherRoleid, true);
/* 112 */       if (relationValue < SMarriageConsts.getInstance().friendValue) {
/* 113 */         GameServer.logger().info(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@relation value not enough|value=%d", new Object[] { Integer.valueOf(relationValue) }));
/*     */         
/*     */ 
/*     */ 
/* 117 */         return false;
/*     */       }
/*     */       
/* 120 */       if ((Role2marriage.get(Long.valueOf(reqRoleid)) != null) || (Role2marriage.get(Long.valueOf(otherRoleid)) != null)) {
/* 121 */         GameServer.logger().info(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@player not in single state!", new Object[0]));
/*     */         
/* 123 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 127 */       if (marriageLevelCfg.itemOrMoney == 1)
/*     */       {
/* 129 */         int itemNum = ItemInterface.getItemNumberById(reqRoleid, marriageLevelCfg.itemid);
/* 130 */         if ((itemNum < marriageLevelCfg.itemNum) || (!ItemInterface.removeItemById(reqRoleid, 340600000, marriageLevelCfg.itemid, marriageLevelCfg.itemNum, new TLogArg(LogReason.MARRAIGE_REQ_COST))))
/*     */         {
/*     */ 
/*     */ 
/* 134 */           if (!marryReqSession.isUseYuanBao()) {
/* 135 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 136 */             agreeOrCancelMarriageErrorRes.error = 2;
/* 137 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 138 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 140 */             return false;
/*     */           }
/*     */           
/* 143 */           int yuanBaoPrice = ItemInterface.getItemYuanBaoPrice(marriageLevelCfg.itemid);
/* 144 */           if (yuanBaoPrice <= 0) {
/* 145 */             GameServer.logger().error(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@item do not has yuanbao price|itemid=%d", new Object[] { Integer.valueOf(marriageLevelCfg.itemid) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 152 */             return false;
/*     */           }
/* 154 */           int yuanBaoNum = CommonUtils.multiply(yuanBaoPrice, marriageLevelCfg.itemNum);
/* 155 */           if (yuanBaoNum <= 0) {
/* 156 */             GameServer.logger().error(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@cal yuanBaoNum is less than zero|price=%d|num=%d", new Object[] { Integer.valueOf(yuanBaoPrice), Integer.valueOf(marriageLevelCfg.itemNum) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */             return false;
/*     */           }
/* 165 */           long yuanbao = QingfuInterface.getBalance(reqUserid, true);
/* 166 */           if (yuanbao < yuanBaoNum) {
/* 167 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 168 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 169 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 170 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 172 */             return false;
/*     */           }
/* 174 */           boolean suc = QingfuInterface.costYuanbao(reqUserid, reqRoleid, yuanBaoNum, CostType.COST_BIND_FIRST_MARRIAGE_CONFIRM, new TLogArg(LogReason.MARRAIGE_REQ_COST)) == CostResult.Success;
/*     */           
/* 176 */           if (!suc) {
/* 177 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 178 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 179 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 180 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 182 */             return false;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 187 */       else if (marriageLevelCfg.itemOrMoney == 0)
/*     */       {
/* 189 */         switch (marriageLevelCfg.moneyType) {
/*     */         case 2: 
/* 191 */           long gold = RoleInterface.getGold(reqRoleid);
/* 192 */           if (gold < marriageLevelCfg.moneyNum) {
/* 193 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 194 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 195 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 196 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 198 */             return false;
/*     */           }
/* 200 */           boolean suc = RoleInterface.cutGold(reqRoleid, marriageLevelCfg.moneyNum, new TLogArg(LogReason.MARRAIGE_REQ_COST));
/*     */           
/* 202 */           if (!suc) {
/* 203 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 204 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 205 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 206 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 208 */             return false;
/*     */           }
/*     */           break;
/*     */         case 3: 
/* 212 */           long silver = RoleInterface.getSilver(reqRoleid);
/* 213 */           if (silver < marriageLevelCfg.moneyNum) {
/* 214 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 215 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 216 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 217 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 219 */             return false;
/*     */           }
/* 221 */           boolean suc1 = RoleInterface.cutSilver(reqRoleid, marriageLevelCfg.moneyNum, new TLogArg(LogReason.MARRAIGE_REQ_COST));
/*     */           
/* 223 */           if (!suc1) {
/* 224 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 225 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 226 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 227 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 229 */             return false;
/*     */           }
/*     */           break;
/*     */         case 1: 
/* 233 */           long yuanbao = QingfuInterface.getBalance(reqUserid, true);
/* 234 */           if (yuanbao < marriageLevelCfg.moneyNum) {
/* 235 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 236 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 237 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 238 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 240 */             return false;
/*     */           }
/* 242 */           boolean suc2 = QingfuInterface.costYuanbao(reqUserid, reqRoleid, marriageLevelCfg.moneyNum, CostType.COST_BIND_FIRST_MARRIAGE_CONFIRM, new TLogArg(LogReason.MARRAIGE_REQ_COST)) == CostResult.Success;
/*     */           
/* 244 */           if (!suc2) {
/* 245 */             SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 246 */             agreeOrCancelMarriageErrorRes.error = 1;
/* 247 */             agreeOrCancelMarriageErrorRes.args.add(RoleInterface.getName(reqRoleid));
/* 248 */             OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */             
/* 250 */             return false;
/*     */           }
/*     */           
/*     */           break;
/*     */         default: 
/* 255 */           GameServer.logger().error(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@|marriageLevelCfg not exist cost moneytype|moneyType=%d", new Object[] { Integer.valueOf(marriageLevelCfg.moneyType) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 262 */           return false;
/*     */         }
/*     */       }
/*     */       else {
/* 266 */         GameServer.logger().error(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@|marriageLevelCfg not exist cost type|itemOrMoney=%d", new Object[] { Integer.valueOf(marriageLevelCfg.itemOrMoney) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 273 */         return false;
/*     */       }
/* 275 */       long roleidA = 0L;
/* 276 */       long roleidB = 0L;
/*     */       
/* 278 */       xbean.Marriage xMarriage = Pod.newMarriage();
/* 279 */       xMarriage.setLevel(levelCfgid);
/* 280 */       xMarriage.setMarriagetitle(SMarriageConsts.getInstance().defaultTitle);
/* 281 */       if (RoleInterface.getGender(reqRoleid) == 1) {
/* 282 */         xMarriage.setRoleida(reqRoleid);
/* 283 */         roleidA = reqRoleid;
/* 284 */         xMarriage.setRoleidb(otherRoleid);
/* 285 */         roleidB = otherRoleid;
/*     */       } else {
/* 287 */         xMarriage.setRoleida(otherRoleid);
/* 288 */         roleidA = otherRoleid;
/* 289 */         xMarriage.setRoleidb(reqRoleid);
/* 290 */         roleidB = reqRoleid;
/*     */       }
/*     */       
/* 293 */       xMarriage.setMarrytime(DateTimeUtils.getCurrTimeInMillis());
/*     */       
/*     */ 
/* 296 */       Long marriageId = xtable.Marriage.insert(xMarriage);
/* 297 */       if (marriageId == null) {
/* 298 */         GameServer.logger().error(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@|xtable.Marriage autoincrement id is NULL", new Object[0]));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 303 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 307 */       ChildrenInterface.onMarry(reqRoleid, otherRoleid);
/*     */       
/* 309 */       Role2marriage.insert(Long.valueOf(reqRoleid), marriageId);
/* 310 */       Role2marriage.insert(Long.valueOf(otherRoleid), marriageId);
/*     */       
/*     */ 
/*     */ 
/* 314 */       Ceremonys xCeremonys = Weddingceremony.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 315 */       if ((xCeremonys != null) && (xCeremonys.getCeremonys().size() > 0)) {
/* 316 */         SAgreeOrCancelMarriageErrorRes agreeOrCancelMarriageErrorRes = new SAgreeOrCancelMarriageErrorRes();
/* 317 */         agreeOrCancelMarriageErrorRes.error = 3;
/* 318 */         OnlineManager.getInstance().sendMultiAtOnce(agreeOrCancelMarriageErrorRes, Arrays.asList(new Long[] { Long.valueOf(reqRoleid), Long.valueOf(otherRoleid) }));
/*     */         
/* 320 */         return false;
/*     */       }
/* 322 */       if (xCeremonys == null) {
/* 323 */         xCeremonys = Pod.newCeremonys();
/* 324 */         Weddingceremony.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xCeremonys);
/*     */       }
/* 326 */       Ceremony xCeremony = Pod.newCeremony();
/* 327 */       xCeremony.setLevel(levelCfgid);
/* 328 */       xCeremony.setRoleid1(roleidA);
/* 329 */       xCeremony.setRoleid2(roleidB);
/* 330 */       xCeremony.setStage(1);
/* 331 */       xCeremonys.getCeremonys().add(xCeremony);
/* 332 */       xCeremonys.setCeremonycounter(xCeremonys.getCeremonycounter() + 1);
/*     */       
/*     */ 
/*     */ 
/* 336 */       SMarriageTitileCfg marriageTitileCfg = SMarriageTitileCfg.get(SMarriageConsts.getInstance().defaultTitle);
/* 337 */       String roleNameReq = RoleInterface.getName(reqRoleid);
/* 338 */       String otherRoleName = RoleInterface.getName(otherRoleid);
/*     */       
/* 340 */       String roleAName = RoleInterface.getName(roleidA);
/* 341 */       String roleBName = RoleInterface.getName(roleidB);
/*     */       
/* 343 */       TitleInterface.addAppellation(roleidA, marriageTitileCfg.manTitle, Arrays.asList(new String[] { roleBName }), true);
/* 344 */       TitleInterface.addAppellation(roleidB, marriageTitileCfg.womenTitle, Arrays.asList(new String[] { roleAName }), true);
/*     */       
/* 346 */       BuffInterface.installBuff(roleidA, SMarriageConsts.getInstance().marriageBuffid1);
/* 347 */       BuffInterface.installBuff(roleidA, SMarriageConsts.getInstance().manModelBuff);
/*     */       
/* 349 */       BuffInterface.installBuff(roleidB, SMarriageConsts.getInstance().marriageBuffid1);
/* 350 */       BuffInterface.installBuff(roleidB, SMarriageConsts.getInstance().womenModelBuff);
/*     */       
/* 352 */       ItemInterface.addItem(reqRoleid, marriageLevelCfg.sugerItemid, marriageLevelCfg.marriageSugerItemNum, new TLogArg(LogReason.MARRIAGE_NEW_ADD));
/*     */       
/* 354 */       ItemInterface.addItem(otherRoleid, marriageLevelCfg.sugerItemid, marriageLevelCfg.marriageSugerItemNum, new TLogArg(LogReason.MARRIAGE_NEW_ADD));
/*     */       
/*     */ 
/*     */ 
/* 358 */       SBroadCastAllMarriage sBroadCastAllMarriage = new SBroadCastAllMarriage();
/* 359 */       sBroadCastAllMarriage.level = levelCfgid;
/* 360 */       sBroadCastAllMarriage.marriagecounter = xCeremonys.getCeremonycounter();
/* 361 */       sBroadCastAllMarriage.roleida = reqRoleid;
/* 362 */       sBroadCastAllMarriage.roleidaname = roleNameReq;
/* 363 */       sBroadCastAllMarriage.roleidb = otherRoleid;
/* 364 */       sBroadCastAllMarriage.roleidbname = otherRoleName;
/* 365 */       OnlineManager.getInstance().sendAll(sBroadCastAllMarriage);
/*     */       
/*     */ 
/*     */ 
/* 369 */       MarriageArg marriageArg = new MarriageArg(reqRoleid, otherRoleid, levelCfgid);
/* 370 */       TriggerEventsManger.getInstance().triggerEvent(new MarriageEvent(), marriageArg);
/*     */       
/*     */ 
/*     */ 
/* 374 */       Integer time = MarriageManager.getWeddingPlayCfg(levelCfgid, 1);
/* 375 */       if (time == null) {
/* 376 */         GameServer.logger().info(String.format("[Marriage]PCAgreeOrCancelMarriage.processImp@|play time is NULL|level=%d", new Object[] { Integer.valueOf(levelCfgid) }));
/*     */         
/*     */ 
/* 379 */         xCeremonys.getCeremonys().clear();
/*     */       } else {
/* 381 */         new WeddingPlaySession(time.intValue(), levelCfgid, 1);
/*     */         
/* 383 */         SBroadCastMarriage sBroadCastMarriage = new SBroadCastMarriage();
/* 384 */         sBroadCastMarriage.level = levelCfgid;
/* 385 */         sBroadCastMarriage.roleida = xMarriage.getRoleida();
/* 386 */         sBroadCastMarriage.roleidaname = RoleInterface.getName(xMarriage.getRoleida());
/* 387 */         sBroadCastMarriage.roleidb = xMarriage.getRoleidb();
/* 388 */         sBroadCastMarriage.roleidbname = RoleInterface.getName(xMarriage.getRoleidb());
/* 389 */         sBroadCastMarriage.stage = 1;
/* 390 */         MapInterface.brocadCastInWorldMap(MapInterface.getBigWorldid(), SMarriageConsts.getInstance().marriageMapid, sBroadCastMarriage, false);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 395 */       SSynMarriageInfo sSynMarriageInfo = new SSynMarriageInfo();
/* 396 */       MarriageManager.fillInMarriageInfo(sSynMarriageInfo, xMarriage, reqRoleid);
/* 397 */       OnlineManager.getInstance().send(otherRoleid, sSynMarriageInfo);
/*     */       
/*     */ 
/* 400 */       Map<Integer, Integer> skillMap = MarriageManager.initMarrySkill(reqRoleid, otherRoleid);
/*     */       
/*     */ 
/* 403 */       MarrySkillChangeArg marrySkillChangeArg1 = new MarrySkillChangeArg(reqRoleid);
/* 404 */       marrySkillChangeArg1.skill2Lv.putAll(skillMap);
/* 405 */       TriggerEventsManger.getInstance().triggerEvent(new MarrySkillChange(), marrySkillChangeArg1);
/*     */       
/* 407 */       MarrySkillChangeArg marrySkillChangeArg2 = new MarrySkillChangeArg(otherRoleid);
/* 408 */       marrySkillChangeArg2.skill2Lv.putAll(skillMap);
/* 409 */       TriggerEventsManger.getInstance().triggerEvent(new MarrySkillChange(), marrySkillChangeArg2);
/*     */       
/* 411 */       SSynMarriageInfo sSynMarriageInfo2 = new SSynMarriageInfo();
/* 412 */       MarriageManager.fillInMarriageInfo(sSynMarriageInfo2, xMarriage, otherRoleid);
/* 413 */       OnlineManager.getInstance().send(reqRoleid, sSynMarriageInfo2);
/* 414 */       MarryReqSession.removeSession(this.sessionid);
/*     */       
/*     */ 
/* 417 */       long beFriendTime = FriendInterface.beFriendTime(roleidA, roleidB, true);
/* 418 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 419 */       int timeMil = (int)(curTime - beFriendTime);
/* 420 */       MarriageManager.tlogMarriage(roleidA, roleidB, levelCfgid, timeMil);
/* 421 */       MarriageManager.tlogMarriage(roleidB, roleidA, levelCfgid, timeMil);
/*     */     } else {
/* 423 */       if ((reqRoleid != this.roleid) && (otherRoleid != this.roleid)) {
/* 424 */         return false;
/*     */       }
/* 426 */       MarryReqSession.removeSession(this.sessionid);
/*     */     }
/*     */     
/* 429 */     SAgreeOrCancelMarriage sAgreeOrCancelMarriage = new SAgreeOrCancelMarriage();
/* 430 */     sAgreeOrCancelMarriage.operator = this.operator;
/* 431 */     sAgreeOrCancelMarriage.operator_roleid = this.roleid;
/* 432 */     sAgreeOrCancelMarriage.rolename = RoleInterface.getName(this.roleid);
/* 433 */     OnlineManager.getInstance().sendMulti(sAgreeOrCancelMarriage, Arrays.asList(new Long[] { Long.valueOf(otherRoleid), Long.valueOf(reqRoleid) }));
/* 434 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCAgreeOrCancelMarriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
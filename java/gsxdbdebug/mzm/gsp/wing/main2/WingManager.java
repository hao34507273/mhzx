/*      */ package mzm.gsp.wing.main2;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.multioccupation.main.MultiOccupInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.wing.OccWingPlanInfo;
/*      */ import mzm.gsp.wing.SAddWingExpRep;
/*      */ import mzm.gsp.wing.SAddWingRankRep;
/*      */ import mzm.gsp.wing.SGetNewWing;
/*      */ import mzm.gsp.wing.SResetWingRep;
/*      */ import mzm.gsp.wing.SRpWingContentRep;
/*      */ import mzm.gsp.wing.SSetTargetSkillRep;
/*      */ import mzm.gsp.wing.SSynOutLook;
/*      */ import mzm.gsp.wing.SSynWingColor;
/*      */ import mzm.gsp.wing.SSynWingsData;
/*      */ import mzm.gsp.wing.SUnsetTargetSkillRep;
/*      */ import mzm.gsp.wing.SWingNormalResult;
/*      */ import mzm.gsp.wing.WingData;
/*      */ import mzm.gsp.wing.confbean.SWingCfg;
/*      */ import mzm.gsp.wing.confbean.SWingInfoCfg;
/*      */ import mzm.gsp.wing.confbean.SWingLvUpCfg;
/*      */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*      */ import mzm.gsp.wing.event.GetWingEvent;
/*      */ import mzm.gsp.wing.event.GetWingdArg;
/*      */ import mzm.gsp.wing.event.WingExpChangedArg;
/*      */ import mzm.gsp.wing.event.WingExpChangedEvent;
/*      */ import mzm.gsp.wing.event.WingModelChangedArg;
/*      */ import mzm.gsp.wing.event.WingModelChangedEvent;
/*      */ import mzm.gsp.wing.event.WingPhaseUpArg;
/*      */ import mzm.gsp.wing.event.WingPhaseUpEvent;
/*      */ import mzm.gsp.wing.event.WingPropertyChangedArg;
/*      */ import mzm.gsp.wing.event.WingPropertyChangedEvent;
/*      */ import mzm.gsp.wing.event.WingSkillChangedArg;
/*      */ import mzm.gsp.wing.event.WingSkillChangedEvent;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.AllWingPlans;
/*      */ import xbean.Pod;
/*      */ import xbean.TransferOccupationWing;
/*      */ import xbean.WingContent;
/*      */ import xbean.WingPlan;
/*      */ import xtable.Role2wingplans;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class WingManager
/*      */ {
/*      */   static final String ENCODING = "UTF-8";
/*      */   
/*      */   static boolean synRoleWingInfo(long roleId, WingPlan xWingPlan, int synType)
/*      */   {
/*   75 */     SSynWingsData synPro = new SSynWingsData();
/*      */     
/*   77 */     synPro.syntype = synType;
/*   78 */     synPro.curexp = xWingPlan.getCurexp();
/*   79 */     synPro.curlv = xWingPlan.getCurlv();
/*   80 */     synPro.currank = xWingPlan.getCurrank();
/*   81 */     synPro.curwing = xWingPlan.getCurwing();
/*      */     
/*   83 */     fillWings(xWingPlan.getWings(), synPro.wings);
/*      */     
/*   85 */     OnlineManager.getInstance().send(roleId, synPro);
/*   86 */     return true;
/*      */   }
/*      */   
/*      */   static void synRoleWingInfo(long roleId, AllWingPlans xAllWingPlan, int synType)
/*      */   {
/*   91 */     TransferOccupationWing xCurWingInfo = (TransferOccupationWing)xAllWingPlan.getTransfer_occupation_wing_map().get(Integer.valueOf(xAllWingPlan.getEffectwingoccid()));
/*      */     
/*   93 */     if (xCurWingInfo == null)
/*      */     {
/*   95 */       return;
/*      */     }
/*   97 */     WingPlan xWingPlan = (WingPlan)xCurWingInfo.getWings().get(Integer.valueOf(1));
/*   98 */     if (xWingPlan == null)
/*      */     {
/*  100 */       return;
/*      */     }
/*      */     
/*  103 */     SSynWingsData synPro = new SSynWingsData();
/*      */     
/*  105 */     synPro.syntype = synType;
/*  106 */     synPro.curexp = xWingPlan.getCurexp();
/*  107 */     synPro.curlv = xWingPlan.getCurlv();
/*  108 */     synPro.currank = xWingPlan.getCurrank();
/*  109 */     synPro.curwing = xWingPlan.getCurwing();
/*      */     
/*  111 */     synPro.effectoccupationid = xAllWingPlan.getEffectwingoccid();
/*      */     
/*  113 */     fillOccPlans(roleId, synPro.occpalns, xAllWingPlan.getTransfer_occupation_wing_map());
/*      */     
/*  115 */     fillWings(xWingPlan.getWings(), synPro.wings);
/*      */     
/*  117 */     synPro.newoccplans.addAll(xAllWingPlan.getNewoccplans());
/*      */     
/*  119 */     OnlineManager.getInstance().send(roleId, synPro);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fillOccPlans(long roleId, List<OccWingPlanInfo> occpalns, Map<Integer, TransferOccupationWing> allOccWingDatas)
/*      */   {
/*  125 */     List<Integer> ownOccIds = getRoleOccIds(roleId);
/*  126 */     if ((ownOccIds == null) || (ownOccIds.size() == 0) || (GameServerInfoManager.isRoamServer()))
/*      */     {
/*      */ 
/*  129 */       ownOccIds = new ArrayList(allOccWingDatas.keySet());
/*      */     }
/*  131 */     for (Iterator i$ = ownOccIds.iterator(); i$.hasNext();) { int occId = ((Integer)i$.next()).intValue();
/*      */       
/*  133 */       TransferOccupationWing xOccPlan = (TransferOccupationWing)allOccWingDatas.get(Integer.valueOf(occId));
/*  134 */       if (xOccPlan != null)
/*      */       {
/*      */ 
/*      */         try
/*      */         {
/*      */ 
/*  140 */           OccWingPlanInfo info = new OccWingPlanInfo();
/*  141 */           info.occid = occId;
/*  142 */           info.planname.setString(xOccPlan.getPlanname(), "UTF-8");
/*  143 */           occpalns.add(info);
/*      */         }
/*      */         catch (UnsupportedEncodingException e) {}
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static List<Integer> getRoleOccIds(long roleId)
/*      */   {
/*  154 */     return MultiOccupInterface.getOccupList(roleId, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillWings(Map<Integer, WingContent> xWings, Map<Integer, WingData> pWings)
/*      */   {
/*  165 */     for (WingContent xWingContent : xWings.values())
/*      */     {
/*  167 */       WingData pData = new WingData();
/*  168 */       fillPWingData(pData, xWingContent);
/*  169 */       pWings.put(Integer.valueOf(pData.cfgid), pData);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addExp(RoleWingPlan xPlan, int addExp, int count, int itemId, int effectOccId)
/*      */   {
/*  188 */     if (addExp < 0)
/*      */     {
/*  190 */       return false;
/*      */     }
/*  192 */     WingPlan xWingPlan = xPlan.getxWingPlan();
/*  193 */     int orgLv = xWingPlan.getCurlv();
/*      */     
/*  195 */     AddExpLvInfo addInfo = calExp(xWingPlan, addExp, count);
/*  196 */     if (addInfo.getCutCount() == 0)
/*      */     {
/*  198 */       GameServer.logger().error(String.format("[wing]WingManager.addExp@ no need cut anything!|itemId=%d|roleId=%d", new Object[] { Integer.valueOf(itemId), Long.valueOf(xPlan.getRoleId()) }));
/*      */       
/*      */ 
/*  201 */       return false;
/*      */     }
/*  203 */     xWingPlan.setCurlv(addInfo.getLv());
/*  204 */     xWingPlan.setCurexp(addInfo.getExp());
/*      */     
/*      */ 
/*  207 */     addTransferOccupationWingExp(xPlan.getRoleId(), addInfo.getExp(), addInfo.getLv());
/*      */     
/*  209 */     noticeExpAdd(xPlan, orgLv, addInfo.getCutCount() * addExp, effectOccId);
/*      */     
/*  211 */     if (!ItemInterface.removeItemById(xPlan.getRoleId(), itemId, addInfo.getCutCount(), new TLogArg(LogReason.WING_ADD_EXP_REM)))
/*      */     {
/*      */ 
/*  214 */       GameServer.logger().error(String.format("[wing]WingManager.addExp@ rm item error!|itemId=%d|roleId=%d", new Object[] { Integer.valueOf(itemId), Long.valueOf(xPlan.getRoleId()) }));
/*      */       
/*  216 */       return false;
/*      */     }
/*      */     
/*  219 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static AddExpLvInfo calExp(WingPlan xWingPlan, int addExp, int count)
/*      */   {
/*  232 */     return calExp(xWingPlan.getCurexp(), xWingPlan.getCurlv(), xWingPlan.getCurrank(), addExp, count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static AddExpLvInfo calExp(int curExp, int curLv, int curRank, int addExp, int count)
/*      */   {
/*  247 */     int lastExp = curExp;
/*  248 */     int lastLv = curLv;
/*  249 */     int orgNum = count;
/*      */     
/*  251 */     while (count > 0)
/*      */     {
/*  253 */       if (lastLv == getMaxLv())
/*      */       {
/*  255 */         lastExp = 0;
/*  256 */         GameServer.logger().info(String.format("[wing]WingManager.calLv@ lv to max!|lv=%d", new Object[] { Integer.valueOf(lastLv) }));
/*  257 */         break;
/*      */       }
/*      */       
/*  260 */       SWingLvUpCfg cfg = SWingLvUpCfg.get(lastLv);
/*  261 */       if (cfg == null)
/*      */       {
/*  263 */         lastExp = 0;
/*  264 */         GameServer.logger().warn(String.format("[wing]WingManager.calLv@ lv cfg not exist, maybe to max!|lv=%d", new Object[] { Integer.valueOf(lastLv) }));
/*      */         
/*  266 */         break;
/*      */       }
/*  268 */       int needRank = cfg.needrank;
/*  269 */       if (needRank > curRank)
/*      */       {
/*  271 */         if (!GameServer.logger().isDebugEnabled())
/*      */           break;
/*  273 */         GameServer.logger().debug(String.format("[wing]WingManager.addExp1@ curRank not enough!|lastLv=%d|lastExp=%d|curRank=%d|needRank=%d", new Object[] { Integer.valueOf(lastLv), Integer.valueOf(lastExp), Integer.valueOf(curExp), Integer.valueOf(needRank) })); break;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  280 */       lastExp += addExp;
/*      */       
/*  282 */       WingLvInfo wingLvInfo = calLv(lastLv, lastExp);
/*      */       
/*  284 */       lastExp = wingLvInfo.getExp();
/*  285 */       lastLv = wingLvInfo.getLv();
/*      */       
/*  287 */       count--;
/*      */     }
/*  289 */     return new AddExpLvInfo(lastLv, lastExp, orgNum - count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeExpAdd(RoleWingPlan xPlan, int oldLv, int addExp, int effectOccId)
/*      */   {
/*  301 */     WingPlan xWingPlan = xPlan.getxWingPlan();
/*  302 */     synClientExpAdd(xPlan.getRoleId(), oldLv, addExp, xWingPlan);
/*  303 */     trigExpAddEvent(xPlan.getRoleId(), oldLv, addExp, xWingPlan);
/*  304 */     WingTLogManager.tlogAddExp(xPlan.getRoleId(), oldLv, addExp, xWingPlan, effectOccId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void synClientExpAdd(long roleId, int oldLv, int addExp, WingPlan xWingPlan)
/*      */   {
/*  317 */     SAddWingExpRep p = new SAddWingExpRep();
/*  318 */     p.newlv = xWingPlan.getCurlv();
/*  319 */     p.curexp = xWingPlan.getCurexp();
/*  320 */     p.addexp = addExp;
/*  321 */     p.oldlv = oldLv;
/*      */     
/*  323 */     OnlineManager.getInstance().send(roleId, p);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void trigExpAddEvent(long roleId, int oldLv, int addExp, WingPlan xWingPlan)
/*      */   {
/*  336 */     TriggerEventsManger.getInstance().triggerEvent(new WingExpChangedEvent(), new WingExpChangedArg(roleId, oldLv, xWingPlan.getCurlv(), addExp));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int onLvUp(RoleWingPlan xPlan)
/*      */   {
/*  348 */     WingPlan xWingPlan = xPlan.getxWingPlan();
/*  349 */     int curLv = xWingPlan.getCurlv();
/*  350 */     WingLvInfo info = calLv(curLv, xWingPlan.getCurexp());
/*  351 */     if (info.getLv() > curLv)
/*      */     {
/*  353 */       xWingPlan.setCurlv(info.getLv());
/*  354 */       xWingPlan.setCurexp(info.getExp());
/*      */     }
/*  356 */     return info.getLv() - curLv;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static WingLvInfo calLv(int curLv, int curExp)
/*      */   {
/*  368 */     int lastLv = curLv;
/*  369 */     int lastExp = curExp;
/*  370 */     for (int lv = curLv;; lv++)
/*      */     {
/*  372 */       lastLv = lv;
/*  373 */       if (lastLv == getMaxLv())
/*      */       {
/*  375 */         lastExp = 0;
/*  376 */         GameServer.logger().info(String.format("[wing]WingManager.calLv@ lv to max!|lv=%d", new Object[] { Integer.valueOf(lv) }));
/*  377 */         break;
/*      */       }
/*  379 */       SWingLvUpCfg cfg = SWingLvUpCfg.get(lv);
/*  380 */       if (cfg == null)
/*      */       {
/*  382 */         lastExp = 0;
/*  383 */         GameServer.logger().warn(String.format("[wing]WingManager.calLv@ lv cfg not exist, maybe to max!|lv=%d", new Object[] { Integer.valueOf(lv) }));
/*  384 */         break;
/*      */       }
/*  386 */       int lvUpExp = cfg.needExp;
/*  387 */       if (lvUpExp > lastExp) {
/*      */         break;
/*      */       }
/*      */       
/*  391 */       lastExp -= lvUpExp;
/*      */     }
/*  393 */     return new WingLvInfo(lastLv, lastExp);
/*      */   }
/*      */   
/*      */   static class WingLvInfo
/*      */   {
/*      */     private final int curLv;
/*      */     private final int curExp;
/*      */     
/*      */     public WingLvInfo(int curLv, int curExp)
/*      */     {
/*  403 */       this.curLv = curLv;
/*  404 */       this.curExp = curExp;
/*      */     }
/*      */     
/*      */     int getLv()
/*      */     {
/*  409 */       return this.curLv;
/*      */     }
/*      */     
/*      */     int getExp()
/*      */     {
/*  414 */       return this.curExp;
/*      */     }
/*      */   }
/*      */   
/*      */   static class AddExpLvInfo
/*      */     extends WingManager.WingLvInfo
/*      */   {
/*      */     private final int cutCount;
/*      */     
/*      */     public AddExpLvInfo(int curLv, int curExp, int cutCount)
/*      */     {
/*  425 */       super(curExp);
/*  426 */       this.cutCount = cutCount;
/*      */     }
/*      */     
/*      */     int getCutCount()
/*      */     {
/*  431 */       return this.cutCount;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean useYuanPay(String userid, long roleId, int item, int needNum, int ownNum, int needYuanNum, long clientYuanbao, CostType costType, TLogArg tLogArg)
/*      */   {
/*  462 */     long ownYuan = QingfuInterface.getBalance(userid, false);
/*  463 */     if (ownYuan != clientYuanbao)
/*      */     {
/*  465 */       GameServer.logger().error(String.format("[wing]WingManager.useYuanPay@ yuanbao not same!|roleId=%d|plan=%d|ownYuan=%d|clientYuan=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Long.valueOf(ownYuan), Long.valueOf(clientYuanbao) }));
/*      */       
/*      */ 
/*  468 */       return false;
/*      */     }
/*      */     
/*  471 */     if (needYuanNum > 0)
/*      */     {
/*  473 */       CostResult cutYuanRes = QingfuInterface.costYuanbao(userid, roleId, needYuanNum, costType, tLogArg);
/*  474 */       if (cutYuanRes != CostResult.Success)
/*      */       {
/*  476 */         GameServer.logger().error(String.format("[wing]WingManager.useYuanPay@ cut yuanbao error!|roleId=%d|plan=%d|ownYuan=%d|needYuanNum=%d|res=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Long.valueOf(ownYuan), Integer.valueOf(needYuanNum), Integer.valueOf(cutYuanRes.code) }));
/*      */         
/*      */ 
/*      */ 
/*  480 */         if (cutYuanRes == CostResult.BalanceNotEnough)
/*      */         {
/*  482 */           sendWingNotice(roleId, 2, new String[0]);
/*      */         }
/*  484 */         return false;
/*      */       }
/*      */     }
/*  487 */     if (ownNum > 0)
/*      */     {
/*  489 */       boolean ret = ItemInterface.removeItemById(roleId, 340600000, item, ownNum, tLogArg);
/*  490 */       if (!ret)
/*      */       {
/*  492 */         GameServer.logger().error(String.format("[wing]WingManager.useYuanPay@ cut item error!|roleId=%d|plan=%d|itemId=%d|ownNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(item), Integer.valueOf(ownNum) }));
/*      */         
/*      */ 
/*  495 */         return false;
/*      */       }
/*      */     }
/*  498 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getNewWing(RoleWingPlan xPlan, int wingId)
/*      */   {
/*  513 */     long roleId = xPlan.getRoleId();
/*  514 */     if (xPlan.hasWing(wingId))
/*      */     {
/*  516 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ already own this wing!|roleId=%d|plan=%d|newWingId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(wingId) }));
/*      */       
/*      */ 
/*  519 */       sendWingNotice(roleId, 3, new String[0]);
/*  520 */       return false;
/*      */     }
/*      */     
/*  523 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingId);
/*  524 */     if (cfg == null)
/*      */     {
/*  526 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ no wing cfg data!|roleId=%d|plan=%d|newWingId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(wingId) }));
/*      */       
/*      */ 
/*  529 */       return false;
/*      */     }
/*      */     
/*  532 */     if (xPlan.createXWingData(wingId) == null)
/*      */     {
/*  534 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ create wing error!|roleId=%d|plan=%d|newWingId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(wingId) }));
/*      */       
/*      */ 
/*  537 */       return false;
/*      */     }
/*      */     
/*  540 */     WingCfgManager.RanResult res = WingCfgManager.ranSkills(cfg.initSkillLib, xPlan.getAllSkills(), 1);
/*  541 */     List<Integer> ranSkills = res.getRanSkills();
/*  542 */     if (ranSkills.size() > 0)
/*      */     {
/*  544 */       if (!xPlan.rpSkills(wingId, new HashSet(ranSkills)))
/*      */       {
/*  546 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  550 */     List<Integer> ranProIds = WingCfgManager.ranProIds(cfg.initProId, new HashSet());
/*  551 */     if (ranProIds.size() > 0)
/*      */     {
/*  553 */       if (!xPlan.rpPros(wingId, new HashSet(ranProIds)))
/*      */       {
/*  555 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  559 */     boolean addTransferOccupationNewWingResult = addTransferOccupationNewWing(roleId, wingId);
/*  560 */     if (!addTransferOccupationNewWingResult)
/*      */     {
/*  562 */       return false;
/*      */     }
/*      */     
/*  565 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeRankUp(long roleId, RoleWingPlan xPlan, int wingId, int effectOccId)
/*      */   {
/*  576 */     noticeClientRankUp(roleId, xPlan.getWingData(wingId));
/*  577 */     trigRankUpEvent(roleId, xPlan, wingId);
/*  578 */     WingTLogManager.tlogAddRank(roleId, xPlan.getxWingPlan(), wingId, effectOccId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeClientRankUp(long roleId, WingContent xWingData)
/*      */   {
/*  589 */     SAddWingRankRep rep = new SAddWingRankRep();
/*  590 */     fillPWingData(rep.wing, xWingData);
/*  591 */     OnlineManager.getInstance().send(roleId, rep);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void trigRankUpEvent(long roleId, RoleWingPlan xPlan, int wingId)
/*      */   {
/*  602 */     int curRank = xPlan.getxWingPlan().getCurrank();
/*  603 */     WingPhaseUpArg arg = new WingPhaseUpArg(roleId, curRank - 1, curRank);
/*  604 */     arg.setNewWingId(wingId);
/*  605 */     TriggerEventsManger.getInstance().triggerEvent(new WingPhaseUpEvent(), arg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeResetWing(long roleId, int wingId, byte type, List<Integer> ids, int effectOccId)
/*      */   {
/*  617 */     noticeClientReset(roleId, wingId, type, ids);
/*  618 */     trigResetEvent(roleId, wingId, type, ids);
/*  619 */     WingTLogManager.tlogReset(roleId, type, wingId, ids, effectOccId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void trigResetEvent(long roleId, int wingId, byte type, List<Integer> ids) {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void noticeClientReset(long roleId, int wingId, byte type, List<Integer> ids)
/*      */   {
/*  645 */     SResetWingRep rep = new SResetWingRep();
/*  646 */     rep.cfgid = wingId;
/*  647 */     rep.reids.addAll(ids);
/*  648 */     rep.resettype = type;
/*  649 */     OnlineManager.getInstance().send(roleId, rep);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeOutLookChange(long roleId, int oldWingId, int oldColorId, int newWingId, int newColorId, int effectOccId)
/*      */   {
/*  660 */     noticeClientOutLookChange(roleId, newWingId);
/*  661 */     trigOutLookChange(roleId, oldWingId, oldColorId, newWingId, newColorId);
/*  662 */     WingTLogManager.tlogChangeWing(roleId, newWingId, effectOccId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeClientOutLookChange(long roleId, int newWingId)
/*      */   {
/*  673 */     SSynOutLook pro = new SSynOutLook();
/*  674 */     pro.curcfgid = newWingId;
/*  675 */     OnlineManager.getInstance().send(roleId, pro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeWingReplace(long roleId, WingContent xWingData, byte type, int effectOccId)
/*      */   {
/*  687 */     noticeClientRplace(roleId, xWingData, type, effectOccId);
/*  688 */     trigReplaceEvent(roleId, xWingData, type);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void noticeClientRplace(long roleId, WingContent xWingData, byte type, int effectOccId)
/*      */   {
/*  700 */     SRpWingContentRep rep = new SRpWingContentRep();
/*  701 */     rep.cfgid = xWingData.getCfgid();
/*  702 */     rep.resettype = type;
/*  703 */     if (type == 0)
/*      */     {
/*  705 */       rep.curids.addAll(xWingData.getProids());
/*      */     }
/*      */     else
/*      */     {
/*  709 */       rep.curids.addAll(xWingData.getSkills());
/*      */     }
/*  711 */     OnlineManager.getInstance().send(roleId, rep);
/*      */     
/*  713 */     WingTLogManager.tlogRp(roleId, type, xWingData.getCfgid(), rep.curids, effectOccId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void trigReplaceEvent(long roleId, WingContent xWingData, byte type)
/*      */   {
/*  725 */     if (type == 0)
/*      */     {
/*  727 */       WingPropertyChangedArg arg = new WingPropertyChangedArg(roleId);
/*  728 */       TriggerEventsManger.getInstance().triggerEvent(new WingPropertyChangedEvent(), arg);
/*      */     }
/*      */     else
/*      */     {
/*  732 */       WingSkillChangedArg arg = new WingSkillChangedArg(roleId);
/*  733 */       TriggerEventsManger.getInstance().triggerEvent(new WingSkillChangedEvent(), arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeColorChange(long roleId, int wingId, int newColorId, int orgColorId, int effectOccId)
/*      */   {
/*  746 */     noticClientColorChange(roleId, wingId, newColorId);
/*  747 */     trigOutLookChange(roleId, wingId, orgColorId, wingId, newColorId);
/*  748 */     WingTLogManager.tlogWingChangeColor(roleId, wingId, newColorId, effectOccId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void noticClientColorChange(long roleId, int wingId, int newColorId)
/*      */   {
/*  760 */     SSynWingColor pro = new SSynWingColor();
/*  761 */     pro.cfgid = wingId;
/*  762 */     pro.colorid = newColorId;
/*  763 */     OnlineManager.getInstance().send(roleId, pro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void trigOutLookChange(long roleId, int oldWingId, int oldColorId, int newWingId, int newColorId)
/*      */   {
/*  782 */     WingModelChangedArg arg = new WingModelChangedArg(roleId, oldWingId, oldColorId, newWingId, newColorId);
/*  783 */     TriggerEventsManger.getInstance().triggerEvent(new WingModelChangedEvent(), arg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void trigGetNewWing(long roleId, int wingId)
/*      */   {
/*  794 */     GetWingdArg arg = new GetWingdArg(roleId, wingId);
/*  795 */     TriggerEventsManger.getInstance().triggerEvent(new GetWingEvent(), arg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeClientGetNewWing(long roleId, WingContent xWingData)
/*      */   {
/*  806 */     SGetNewWing rep = new SGetNewWing();
/*  807 */     fillPWingData(rep.wing, xWingData);
/*  808 */     OnlineManager.getInstance().send(roleId, rep);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeWingSetTargetSkill(long roleId, int wingId, int index, int skill_id, int effectOccId)
/*      */   {
/*  821 */     noticeClientSetTargetSkill(roleId, wingId, index, skill_id);
/*  822 */     WingTLogManager.tlogSetTargetSkill(roleId, wingId, index, skill_id, effectOccId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticeWingUnsetTargetSkill(long roleId, int wingId, int index)
/*      */   {
/*  835 */     noticeClientUnsetTargetSkill(roleId, wingId, index);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void noticeClientSetTargetSkill(long roleId, int wingId, int index, int skill_id)
/*      */   {
/*  848 */     SSetTargetSkillRep rep = new SSetTargetSkillRep();
/*  849 */     rep.cfg_id = wingId;
/*  850 */     rep.index = index;
/*  851 */     rep.skill_id = skill_id;
/*  852 */     OnlineManager.getInstance().send(roleId, rep);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void noticeClientUnsetTargetSkill(long roleId, int wingId, int index)
/*      */   {
/*  864 */     SUnsetTargetSkillRep rep = new SUnsetTargetSkillRep();
/*  865 */     rep.cfg_id = wingId;
/*  866 */     rep.index = index;
/*  867 */     OnlineManager.getInstance().send(roleId, rep);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean payPrice(String userid, long roleId, int item, int needNum, boolean useYuanbao, long clientYuan, CostType costType, TLogArg tLogArg)
/*      */   {
/*  894 */     int ownNum = ItemInterface.getItemNumberById(roleId, item);
/*  895 */     if (ownNum >= needNum)
/*      */     {
/*  897 */       return onlyPayItem(roleId, item, needNum, tLogArg);
/*      */     }
/*      */     
/*  900 */     if (!useYuanbao)
/*      */     {
/*  902 */       GameServer.logger().error(String.format("[wing]WingManager.payPrice@ item num not enough!|roleId=%d|plan=%d|needNum=%d|ownNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(needNum), Integer.valueOf(ownNum) }));
/*      */       
/*      */ 
/*  905 */       return false;
/*      */     }
/*      */     
/*  908 */     int needYuan = ItemInterface.getItemYuanBaoPrice(item) * (needNum - ownNum);
/*  909 */     if (!useYuanPay(userid, roleId, item, needNum, ownNum, needYuan, clientYuan, costType, tLogArg))
/*      */     {
/*  911 */       GameServer.logger().error(String.format("[wing]WingManager.payPrice@ use yuan pay error!|roleId=%d|plan=%d|needNum=%d|ownNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(needNum), Integer.valueOf(ownNum) }));
/*      */       
/*      */ 
/*  914 */       return false;
/*      */     }
/*      */     
/*  917 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean onlyPayItem(long roleId, int item, int needNum, TLogArg tLogArg)
/*      */   {
/*  929 */     boolean ret = ItemInterface.removeItemById(roleId, 340600000, item, needNum, tLogArg);
/*  930 */     if (!ret)
/*      */     {
/*  932 */       GameServer.logger().error(String.format("[wing]WingManager.onlyPayItem@ cut item error!|roleId=%d|plan=%d|itemId=%d|num=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(item), Integer.valueOf(needNum) }));
/*      */       
/*      */ 
/*  935 */       return false;
/*      */     }
/*  937 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillPWingData(WingData pWingData, WingContent xWingData)
/*      */   {
/*  950 */     pWingData.cfgid = xWingData.getCfgid();
/*  951 */     pWingData.colorid = xWingData.getColorid();
/*      */     
/*  953 */     pWingData.proids.addAll(xWingData.getProids());
/*  954 */     pWingData.reproids.addAll(xWingData.getReproids());
/*      */     
/*  956 */     pWingData.skills.addAll(xWingData.getSkills());
/*  957 */     pWingData.reskillids.addAll(xWingData.getReskillids());
/*      */     
/*  959 */     pWingData.target_skills.putAll(xWingData.getTarget_skills());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendWingNotice(long roleid, int result, String... args)
/*      */   {
/*  971 */     SWingNormalResult pro = new SWingNormalResult();
/*  972 */     pro.result = result;
/*  973 */     for (String arg : args)
/*      */     {
/*  975 */       pro.args.add(arg);
/*      */     }
/*  977 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMaxLv()
/*      */   {
/*  987 */     return WingCfgConsts.getInstance().WING_LV_MAX;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMaxRank()
/*      */   {
/*  997 */     return WingCfgConsts.getInstance().WING_RANGE_MAX;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingSwitchOpenForRole(long roleid)
/*      */   {
/* 1010 */     if (!OpenInterface.getOpenStatus(39))
/*      */     {
/* 1012 */       return false;
/*      */     }
/* 1014 */     if (OpenInterface.isBanPlay(roleid, 39))
/*      */     {
/* 1016 */       OpenInterface.sendBanPlayMsg(roleid, 39);
/* 1017 */       return false;
/*      */     }
/* 1019 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingAddExpSwitchOpenForRole(long roleid)
/*      */   {
/* 1031 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1033 */       return false;
/*      */     }
/*      */     
/* 1036 */     if (!OpenInterface.getOpenStatus(40))
/*      */     {
/* 1038 */       return false;
/*      */     }
/* 1040 */     if (OpenInterface.isBanPlay(roleid, 40))
/*      */     {
/* 1042 */       OpenInterface.sendBanPlayMsg(roleid, 40);
/* 1043 */       return false;
/*      */     }
/* 1045 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingPhaseUpSwitchOpenForRole(long roleid)
/*      */   {
/* 1057 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1059 */       return false;
/*      */     }
/*      */     
/* 1062 */     if (!OpenInterface.getOpenStatus(41))
/*      */     {
/* 1064 */       return false;
/*      */     }
/* 1066 */     if (OpenInterface.isBanPlay(roleid, 41))
/*      */     {
/* 1068 */       OpenInterface.sendBanPlayMsg(roleid, 41);
/* 1069 */       return false;
/*      */     }
/* 1071 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingPropertySwitchOpenForRole(long roleid)
/*      */   {
/* 1083 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1085 */       return false;
/*      */     }
/*      */     
/* 1088 */     if (!OpenInterface.getOpenStatus(42))
/*      */     {
/* 1090 */       return false;
/*      */     }
/* 1092 */     if (OpenInterface.isBanPlay(roleid, 42))
/*      */     {
/* 1094 */       OpenInterface.sendBanPlayMsg(roleid, 42);
/* 1095 */       return false;
/*      */     }
/* 1097 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingSkillSwitchOpenForRole(long roleid)
/*      */   {
/* 1109 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1111 */       return false;
/*      */     }
/*      */     
/* 1114 */     if (!OpenInterface.getOpenStatus(43))
/*      */     {
/* 1116 */       return false;
/*      */     }
/* 1118 */     if (OpenInterface.isBanPlay(roleid, 43))
/*      */     {
/* 1120 */       OpenInterface.sendBanPlayMsg(roleid, 43);
/* 1121 */       return false;
/*      */     }
/* 1123 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingDyeSwitchOpenForRole(long roleid)
/*      */   {
/* 1135 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1137 */       return false;
/*      */     }
/*      */     
/* 1140 */     if (!OpenInterface.getOpenStatus(44))
/*      */     {
/* 1142 */       return false;
/*      */     }
/* 1144 */     if (OpenInterface.isBanPlay(roleid, 44))
/*      */     {
/* 1146 */       OpenInterface.sendBanPlayMsg(roleid, 44);
/* 1147 */       return false;
/*      */     }
/* 1149 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingChangeViewSwitchOpenForRole(long roleid)
/*      */   {
/* 1161 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1163 */       return false;
/*      */     }
/*      */     
/* 1166 */     if (!OpenInterface.getOpenStatus(49))
/*      */     {
/* 1168 */       return false;
/*      */     }
/* 1170 */     if (OpenInterface.isBanPlay(roleid, 49))
/*      */     {
/* 1172 */       OpenInterface.sendBanPlayMsg(roleid, 49);
/* 1173 */       return false;
/*      */     }
/* 1175 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingSetTargetSkillSwitchOpenForRole(long roleid)
/*      */   {
/* 1187 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1189 */       return false;
/*      */     }
/*      */     
/* 1192 */     if (!OpenInterface.getOpenStatus(311))
/*      */     {
/* 1194 */       return false;
/*      */     }
/* 1196 */     if (OpenInterface.isBanPlay(roleid, 311))
/*      */     {
/* 1198 */       OpenInterface.sendBanPlayMsg(roleid, 311);
/* 1199 */       return false;
/*      */     }
/* 1201 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWingSkillGuaranteeSwitchOpenForRole(long roleid)
/*      */   {
/* 1213 */     if (!isWingSwitchOpenForRole(roleid))
/*      */     {
/* 1215 */       return false;
/*      */     }
/*      */     
/* 1218 */     if (!OpenInterface.getOpenStatus(447))
/*      */     {
/* 1220 */       return false;
/*      */     }
/* 1222 */     if (OpenInterface.isBanPlay(roleid, 447))
/*      */     {
/* 1224 */       OpenInterface.sendBanPlayMsg(roleid, 447);
/* 1225 */       return false;
/*      */     }
/* 1227 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addTransferOccupationWingExp(long roleId, int newWingExp, int newWingLevel)
/*      */   {
/* 1243 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(roleId));
/* 1244 */     if (xAllWingPlans == null)
/*      */     {
/* 1246 */       return;
/*      */     }
/*      */     
/* 1249 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/* 1250 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*      */     {
/* 1252 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*      */       {
/*      */ 
/*      */ 
/* 1256 */         TransferOccupationWing xTransferOccupationWing = (TransferOccupationWing)entry.getValue();
/* 1257 */         WingPlan xWingPlan = (WingPlan)xTransferOccupationWing.getWings().get(Integer.valueOf(1));
/* 1258 */         if (xWingPlan != null)
/*      */         {
/*      */ 
/*      */ 
/* 1262 */           xWingPlan.setCurexp(newWingExp);
/* 1263 */           xWingPlan.setCurlv(newWingLevel);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addTransferOccupationWingRank(long roleId, int newWingRank)
/*      */   {
/* 1275 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(roleId));
/* 1276 */     if (xAllWingPlans == null)
/*      */     {
/* 1278 */       return false;
/*      */     }
/*      */     
/* 1281 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/* 1282 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*      */     {
/* 1284 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*      */       {
/*      */ 
/*      */ 
/* 1288 */         TransferOccupationWing xTransferOccupationWing = (TransferOccupationWing)entry.getValue();
/* 1289 */         WingPlan xWingPlan = (WingPlan)xTransferOccupationWing.getWings().get(Integer.valueOf(1));
/* 1290 */         if (xWingPlan == null)
/*      */         {
/* 1292 */           return false;
/*      */         }
/* 1294 */         xWingPlan.setCurrank(newWingRank);
/*      */       } }
/* 1296 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addTransferOccupationNewWing(long roleId, int wingCfgId)
/*      */   {
/* 1309 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(roleId));
/* 1310 */     if (xAllWingPlans == null)
/*      */     {
/* 1312 */       GameServer.logger().error(String.format("[wing]WingManager.addTransferOccupationNewWing@role wing info null|role_id=%d|new_wing_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(wingCfgId) }));
/*      */       
/*      */ 
/*      */ 
/* 1316 */       return false;
/*      */     }
/*      */     
/* 1319 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingCfgId);
/* 1320 */     if (cfg == null)
/*      */     {
/* 1322 */       GameServer.logger().error(String.format("[wing]WingManager.addTransferOccupationNewWing@no wing cfg data|role_id=%d|new_wing_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(wingCfgId) }));
/*      */       
/*      */ 
/*      */ 
/* 1326 */       return false;
/*      */     }
/*      */     
/* 1329 */     SWingCfg sWingCfg = SWingCfg.get(cfg.outlook);
/* 1330 */     if (sWingCfg == null)
/*      */     {
/* 1332 */       GameServer.logger().error(String.format("[wing]WingManager.addTransferOccupationNewWing@ no wing outlook cfg data|role_id=%d|plan=%d|new_wing_cfg_id=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(1), Integer.valueOf(wingCfgId) }));
/*      */       
/*      */ 
/*      */ 
/* 1336 */       return false;
/*      */     }
/*      */     
/* 1339 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/*      */     
/*      */ 
/* 1342 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*      */     {
/* 1344 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1349 */         TransferOccupationWing xTransferOccupationWing = (TransferOccupationWing)entry.getValue();
/* 1350 */         WingPlan xWingPlan = (WingPlan)xTransferOccupationWing.getWings().get(Integer.valueOf(1));
/* 1351 */         if (xWingPlan == null)
/*      */         {
/* 1353 */           xWingPlan = Pod.newWingPlan();
/* 1354 */           xTransferOccupationWing.getWings().put(Integer.valueOf(1), xWingPlan);
/*      */         }
/*      */         
/* 1357 */         Map<Integer, WingContent> xWingContentMap = xWingPlan.getWings();
/* 1358 */         if (xWingContentMap.containsKey(Integer.valueOf(wingCfgId)))
/*      */         {
/* 1360 */           return false;
/*      */         }
/*      */         
/*      */ 
/* 1364 */         WingContent xWingContent = Pod.newWingContent();
/* 1365 */         xWingContent.setCfgid(wingCfgId);
/* 1366 */         xWingContent.setColorid(sWingCfg.dyeid);
/* 1367 */         xWingPlan.getWings().put(Integer.valueOf(wingCfgId), xWingContent);
/*      */         
/*      */ 
/* 1370 */         RoleWingPlan xPlan = new RoleWingPlan(roleId, 1, xWingPlan);
/* 1371 */         WingCfgManager.RanResult res = WingCfgManager.ranSkills(cfg.initSkillLib, xPlan.getAllSkills(), 1);
/*      */         
/* 1373 */         List<Integer> ranSkills = res.getRanSkills();
/* 1374 */         if (ranSkills.size() > 0)
/*      */         {
/* 1376 */           if (!xPlan.rpSkills(wingCfgId, new HashSet(ranSkills)))
/*      */           {
/* 1378 */             return false;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/* 1383 */         List<Integer> ranProIds = WingCfgManager.ranProIds(cfg.initProId, new HashSet());
/* 1384 */         if (ranProIds.size() > 0)
/*      */         {
/* 1386 */           if (!xPlan.rpPros(wingCfgId, new HashSet(ranProIds)))
/*      */           {
/* 1388 */             return false;
/*      */           }
/*      */         }
/*      */         
/* 1392 */         xWingPlan.setCurwing(wingCfgId);
/*      */       }
/*      */     }
/* 1395 */     return true;
/*      */   }
/*      */   
/*      */   static int deleteWing(long roleid, int wingCfgid)
/*      */   {
/* 1400 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingCfgid);
/* 1401 */     if (cfg == null)
/*      */     {
/* 1403 */       GameServer.logger().error(String.format("[wing]WingManager.deleteWing@wing cfg not exist|roleid=%d|wing_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid) }));
/*      */       
/* 1405 */       return 64105;
/*      */     }
/*      */     
/* 1408 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(roleid));
/* 1409 */     if (xAllWingPlans == null)
/*      */     {
/* 1411 */       GameServer.logger().error(String.format("[wing]WingManager.deleteWing@role wing data is null|roleid=%d|wing_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid) }));
/*      */       
/*      */ 
/* 1414 */       return 64106;
/*      */     }
/*      */     
/* 1417 */     boolean isDeleteSuccess = false;
/* 1418 */     boolean isTransferDeleteSuccess = false;
/* 1419 */     int occupationId = RoleInterface.getOccupationId(roleid);
/*      */     
/* 1421 */     WingPlan xWingPlan = (WingPlan)xAllWingPlans.getWings().get(Integer.valueOf(1));
/* 1422 */     isDeleteSuccess = deleteWing(roleid, wingCfgid, xWingPlan, false, occupationId, xAllWingPlans.getEffectwingoccid());
/*      */     
/*      */ 
/* 1425 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xAllWingPlans.getTransfer_occupation_wing_map().entrySet())
/*      */     {
/* 1427 */       TransferOccupationWing xTransferOccupationWing = (TransferOccupationWing)entry.getValue();
/*      */       
/* 1429 */       WingPlan xWingPlan = (WingPlan)xTransferOccupationWing.getWings().get(Integer.valueOf(1));
/* 1430 */       isTransferDeleteSuccess = deleteWing(roleid, wingCfgid, xWingPlan, true, ((Integer)entry.getKey()).intValue(), xAllWingPlans.getEffectwingoccid());
/*      */       
/*      */ 
/* 1433 */       if ((!isDeleteSuccess) && (isTransferDeleteSuccess))
/*      */       {
/* 1435 */         isDeleteSuccess = true;
/*      */       }
/*      */     }
/*      */     
/* 1439 */     if (!isDeleteSuccess)
/*      */     {
/* 1441 */       GameServer.logger().error(String.format("[wing]WingManager.deleteWing@role not own the wing|roleid=%d|wing_cfg_id=%d ", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid) }));
/*      */       
/*      */ 
/* 1444 */       return 64104;
/*      */     }
/*      */     
/* 1447 */     WingPropertyChangedArg wingPropertyChangedArg = new WingPropertyChangedArg(roleid);
/* 1448 */     TriggerEventsManger.getInstance().triggerEvent(new WingPropertyChangedEvent(), wingPropertyChangedArg);
/*      */     
/* 1450 */     WingSkillChangedArg wingSkillChangedArg = new WingSkillChangedArg(roleid);
/* 1451 */     TriggerEventsManger.getInstance().triggerEvent(new WingSkillChangedEvent(), wingSkillChangedArg);
/*      */     
/* 1453 */     OnlineManager.getInstance().forceReconnect(roleid);
/* 1454 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean deleteWing(long roleid, int wingCfgid, WingPlan xWingPlan, boolean isTransferOccupation, int occupationId, int effectOccId)
/*      */   {
/* 1460 */     String userId = RoleInterface.getUserId(roleid);
/*      */     
/* 1462 */     if (xWingPlan == null)
/*      */     {
/* 1464 */       GameServer.logger().error(String.format("[wing]WingManager.deleteWing@remove wing fail,not own wing data|roleid=%d|cfgid=%d|is_transfer_occupation=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid), Boolean.valueOf(isTransferOccupation) }));
/*      */       
/*      */ 
/*      */ 
/* 1468 */       return false;
/*      */     }
/*      */     
/* 1471 */     WingContent xWingContent = (WingContent)xWingPlan.getWings().remove(Integer.valueOf(wingCfgid));
/* 1472 */     if (xWingContent != null)
/*      */     {
/* 1474 */       GameServer.logger().info(String.format("[wing]WingManager.deleteWing@remove wing|roleid=%d|cfgid=%d|is_transfer_occupation=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid), Boolean.valueOf(isTransferOccupation) }));
/*      */       
/*      */ 
/* 1477 */       tlogRemoveWing(userId, roleid, wingCfgid, occupationId);
/*      */     }
/*      */     else
/*      */     {
/* 1481 */       GameServer.logger().error(String.format("[wing]WingManager.deleteWing@remove wing fail,not own the wing|roleid=%d|cfgid=%d|is_transfer_occupation=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid), Boolean.valueOf(isTransferOccupation) }));
/*      */       
/*      */ 
/*      */ 
/* 1485 */       return false;
/*      */     }
/*      */     
/* 1488 */     if (xWingPlan.getCurwing() == wingCfgid)
/*      */     {
/* 1490 */       if (xWingPlan.getWings().isEmpty())
/*      */       {
/* 1492 */         xWingPlan.setCurwing(0);
/* 1493 */         if (!isTransferOccupation)
/*      */         {
/* 1495 */           noticeOutLookChange(roleid, wingCfgid, xWingContent.getColorid(), 0, 0, effectOccId);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1500 */         Map.Entry<Integer, WingContent> xNewWingEntry = (Map.Entry)xWingPlan.getWings().entrySet().iterator().next();
/* 1501 */         xWingPlan.setCurwing(((Integer)xNewWingEntry.getKey()).intValue());
/* 1502 */         if (!isTransferOccupation)
/*      */         {
/* 1504 */           noticeOutLookChange(roleid, wingCfgid, xWingContent.getColorid(), ((Integer)xNewWingEntry.getKey()).intValue(), ((WingContent)xNewWingEntry.getValue()).getColorid(), effectOccId);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1510 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean changeOccPlan(long roleId, int occId, int curOccId)
/*      */   {
/* 1524 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, true);
/* 1525 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 287, true))
/*      */     {
/* 1527 */       return false;
/*      */     }
/* 1529 */     if (occId == roleWingInfo.getEffectWingOccId())
/*      */     {
/*      */ 
/* 1532 */       return true;
/*      */     }
/* 1534 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 1535 */     if (xWingPlan == null)
/*      */     {
/*      */ 
/* 1538 */       return true;
/*      */     }
/* 1540 */     WingPlan xNewWingPlan = roleWingInfo.getWingPlan(1, occId, false);
/* 1541 */     if (xNewWingPlan == null)
/*      */     {
/*      */ 
/* 1544 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1548 */     roleWingInfo.setEffectWingOccId(occId);
/*      */     
/* 1550 */     roleWingInfo.getxWingPlans().getOcc2lastplanoccid().put(Integer.valueOf(curOccId), Integer.valueOf(occId));
/*      */     
/* 1552 */     synRoleWingInfo(roleId, roleWingInfo.getxWingPlans(), 3);
/*      */     
/*      */ 
/* 1555 */     WingPropertyChangedArg wingPropertyChangedArg = new WingPropertyChangedArg(roleId, WingChangeReasonEnum.CHANGE_OCCUPATION);
/*      */     
/* 1557 */     TriggerEventsManger.getInstance().triggerEvent(new WingPropertyChangedEvent(), wingPropertyChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     
/*      */ 
/*      */ 
/* 1561 */     WingSkillChangedArg wingSkillChangedArg = new WingSkillChangedArg(roleId, WingChangeReasonEnum.CHANGE_OCCUPATION);
/* 1562 */     TriggerEventsManger.getInstance().triggerEvent(new WingSkillChangedEvent(), wingSkillChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     
/*      */ 
/* 1565 */     int newWingCfgId = xNewWingPlan.getCurwing();
/* 1566 */     int newWingColorId = getWingColorId(newWingCfgId, xNewWingPlan);
/*      */     
/* 1568 */     int oldWingCfgId = xWingPlan.getCurwing();
/* 1569 */     int oldWingColorId = getWingColorId(oldWingCfgId, xWingPlan);
/*      */     
/*      */ 
/* 1572 */     WingModelChangedArg wingModelChangedArg = new WingModelChangedArg(roleId, oldWingCfgId, oldWingColorId, newWingCfgId, newWingColorId, WingChangeReasonEnum.CHANGE_OCCUPATION);
/*      */     
/*      */ 
/* 1575 */     TriggerEventsManger.getInstance().triggerEvent(new WingModelChangedEvent(), wingModelChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     
/*      */ 
/* 1578 */     return true;
/*      */   }
/*      */   
/*      */   static void transformOccData(long roleId, AllWingPlans xAllWingPlans)
/*      */   {
/* 1583 */     int occId = RoleInterface.getOccupationId(roleId);
/* 1584 */     TransferOccupationWing xCurOccWingData = (TransferOccupationWing)xAllWingPlans.getTransfer_occupation_wing_map().get(Integer.valueOf(occId));
/* 1585 */     if (xCurOccWingData != null)
/*      */     {
/*      */ 
/* 1588 */       return;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1598 */     xCurOccWingData = Pod.newTransferOccupationWing();
/*      */     
/* 1600 */     xCurOccWingData.setCurplan(xAllWingPlans.getCurplan());
/* 1601 */     Map<Integer, WingPlan> xOldOccupationWingPlanMap = xCurOccWingData.getWings();
/* 1602 */     for (Map.Entry<Integer, WingPlan> entry : xAllWingPlans.getWings().entrySet())
/*      */     {
/* 1604 */       xOldOccupationWingPlanMap.put(entry.getKey(), ((WingPlan)entry.getValue()).copy());
/*      */     }
/*      */     
/* 1607 */     xAllWingPlans.getTransfer_occupation_wing_map().put(Integer.valueOf(occId), xCurOccWingData);
/*      */     
/* 1609 */     xAllWingPlans.setEffectwingoccid(occId);
/*      */     
/* 1611 */     xAllWingPlans.getOcc2lastplanoccid().put(Integer.valueOf(occId), Integer.valueOf(occId));
/*      */     
/*      */ 
/* 1614 */     WingPropertyChangedArg wingPropertyChangedArg = new WingPropertyChangedArg(roleId, WingChangeReasonEnum.CHANGE_ADAPTATION);
/*      */     
/* 1616 */     TriggerEventsManger.getInstance().triggerEvent(new WingPropertyChangedEvent(), wingPropertyChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     
/*      */ 
/* 1619 */     WingSkillChangedArg wingSkillChangedArg = new WingSkillChangedArg(roleId, WingChangeReasonEnum.CHANGE_ADAPTATION);
/* 1620 */     TriggerEventsManger.getInstance().triggerEvent(new WingSkillChangedEvent(), wingSkillChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */   }
/*      */   
/*      */ 
/*      */   private static int getWingColorId(int wingId, WingPlan xWingPlan)
/*      */   {
/* 1626 */     WingContent xWingData = (WingContent)xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 1627 */     if (xWingData == null)
/*      */     {
/* 1629 */       return -1;
/*      */     }
/* 1631 */     return xWingData.getColorid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRemoveWing(String userId, long roleId, int wingCfgId, int occupationId)
/*      */   {
/* 1646 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1648 */     StringBuilder sbLog = new StringBuilder();
/* 1649 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1650 */     sbLog.append(userId).append('|');
/* 1651 */     sbLog.append(roleId).append('|');
/* 1652 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1654 */     sbLog.append(wingCfgId).append('|');
/* 1655 */     sbLog.append(occupationId);
/*      */     
/* 1657 */     TLogManager.getInstance().addLog(roleId, "WingDelete", sbLog.toString());
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\WingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
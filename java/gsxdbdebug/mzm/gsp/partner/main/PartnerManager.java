/*      */ package mzm.gsp.partner.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.partner.RolePartnerInfo;
/*      */ import mzm.gsp.partner.SActivePartnerRep;
/*      */ import mzm.gsp.partner.SChangeDefaultLinupReq;
/*      */ import mzm.gsp.partner.SChangeZhanWeiRep;
/*      */ import mzm.gsp.partner.SChangeZhenFaReq;
/*      */ import mzm.gsp.partner.SNewGetSkill;
/*      */ import mzm.gsp.partner.SPartnerLogginInfo;
/*      */ import mzm.gsp.partner.SPartnerNormalResult;
/*      */ import mzm.gsp.partner.SReplaceLovesReq;
/*      */ import mzm.gsp.partner.SShuffleLovesReq;
/*      */ import mzm.gsp.partner.SSynPartnerSkills;
/*      */ import mzm.gsp.partner.SSynPartnerYuanShen;
/*      */ import mzm.gsp.partner.SSyncPartnerRep;
/*      */ import mzm.gsp.partner.SSyncSinglePartnerPro;
/*      */ import mzm.gsp.partner.SkillList;
/*      */ import mzm.gsp.partner.confbean.PartnerConstants;
/*      */ import mzm.gsp.partner.confbean.SPartnerCfg;
/*      */ import mzm.gsp.partner.confbean.SPartnerSkillCfg;
/*      */ import mzm.gsp.partner.confbean.STYuanCostCfg;
/*      */ import mzm.gsp.partner.event.ChangePartnerZhenFaId;
/*      */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg;
/*      */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg.ChangeZhenFaIdType;
/*      */ import mzm.gsp.partner.event.GetPartner;
/*      */ import mzm.gsp.partner.event.LineUpPartner;
/*      */ import mzm.gsp.partner.event.LineUpPartnerEventArg;
/*      */ import mzm.gsp.partner.event.PartnerEventArg;
/*      */ import mzm.gsp.partner.event.PartnerLoveFlushArg;
/*      */ import mzm.gsp.partner.event.PartnerPositionChange;
/*      */ import mzm.gsp.partner.event.ShuffleLoves;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkill;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*      */ import mzm.gsp.zhenfa.main.ZhenfaInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.PartnerBag;
/*      */ import xbean.Pod;
/*      */ import xdb.Xdb;
/*      */ import xtable.Role2partnerbag;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PartnerManager
/*      */ {
/*   68 */   private static final Logger logger = Logger.getLogger(PartnerManager.class);
/*      */   
/*      */   static final int lineSumNum = 2;
/*      */   
/*      */   private static final int LOVE_RAN_SEED = 10000;
/*      */   
/*      */   private static final int PARTNER_STATE_JOIN = 1;
/*      */   private static final int PARTNER_STATE_REST = 2;
/*      */   public static final int WAN = 10000;
/*      */   
/*      */   static void checkCfg()
/*      */   {
/*   80 */     for (SPartnerCfg sPartnerCfg : SPartnerCfg.getAll().values())
/*      */     {
/*   82 */       isHavePartnerSkillList(sPartnerCfg.skills);
/*      */     }
/*   84 */     for (SPartnerSkillCfg sPartnerSkillCfg : SPartnerSkillCfg.getAll().values())
/*      */     {
/*   86 */       if (sPartnerSkillCfg.skillId != 0) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isHavePartnerSkill(int partnerSkillId)
/*      */   {
/*   95 */     return SPartnerSkillCfg.get(partnerSkillId) != null;
/*      */   }
/*      */   
/*      */   static boolean isHavePartnerSkillList(List<Integer> partnerSkillList)
/*      */   {
/*  100 */     for (Iterator i$ = partnerSkillList.iterator(); i$.hasNext();) { int partnerSkillId = ((Integer)i$.next()).intValue();
/*      */       
/*  102 */       if (partnerSkillId > 0)
/*      */       {
/*      */ 
/*      */ 
/*  106 */         if (!isHavePartnerSkill(partnerSkillId))
/*      */         {
/*  108 */           throw new RuntimeException("不存在的伙伴技能，id=" + partnerSkillId); }
/*      */       }
/*      */     }
/*  111 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onRoleLoggin(long roleId)
/*      */   {
/*  122 */     if (RoleInterface.getLevel(roleId) < PartnerConstants.getInstance().OPEN_LEVEL)
/*      */     {
/*  124 */       return false;
/*      */     }
/*      */     
/*  127 */     RolePartner rolePartner = getRolePartner(roleId, true);
/*      */     
/*  129 */     SPartnerLogginInfo sPartnerLogginInfo = new SPartnerLogginInfo();
/*      */     
/*      */ 
/*  132 */     if (rolePartner == null)
/*      */     {
/*  134 */       return false;
/*      */     }
/*  136 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/*  138 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  142 */     if (rolePartner.getPartnerBag().getLineups().size() > 0)
/*      */     {
/*  144 */       int index = 0;
/*  145 */       for (xbean.LineUp linuUp : rolePartner.getPartnerBag().getLineups().values())
/*      */       {
/*  147 */         mzm.gsp.partner.LineUp lineUpPro = new mzm.gsp.partner.LineUp();
/*  148 */         lineUpPro.zhenfaid = linuUp.getZhenfaid();
/*  149 */         lineUpPro.positions.addAll(toList(linuUp.getPositions()));
/*  150 */         sPartnerLogginInfo.rolepartnerinfo.lineups.put(Integer.valueOf(index), lineUpPro);
/*  151 */         index++;
/*      */       }
/*  153 */       if (index > 3)
/*      */       {
/*  155 */         if (logger.isDebugEnabled())
/*      */         {
/*  157 */           logger.debug("上线时同步阵容出错，阵容数多于3个");
/*      */         }
/*  159 */         return false;
/*      */       }
/*  161 */       sPartnerLogginInfo.rolepartnerinfo.defaultlineupnum = rolePartner.getPartnerBag().getDefaultlineupnum();
/*      */     }
/*      */     else
/*      */     {
/*  165 */       sPartnerLogginInfo.rolepartnerinfo.defaultlineupnum = -1;
/*      */     }
/*      */     
/*      */     Iterator i$;
/*  169 */     if (rolePartner.getPartnerBag().getOwnpartnerids().size() > 0)
/*      */     {
/*  171 */       sPartnerLogginInfo.rolepartnerinfo.ownpartners.addAll(rolePartner.getPartnerBag().getOwnpartnerids());
/*      */       
/*  173 */       for (i$ = rolePartner.getPartnerBag().getOwnpartnerids().iterator(); i$.hasNext();) { int partnerId = ((Integer)i$.next()).intValue();
/*      */         
/*  175 */         mzm.gsp.partner.Property propertyPro = new mzm.gsp.partner.Property();
/*  176 */         if (fillProperty(partnerId, rolePartner, propertyPro))
/*      */         {
/*      */ 
/*      */ 
/*  180 */           sPartnerLogginInfo.rolepartnerinfo.partner2property.put(Integer.valueOf(partnerId), propertyPro);
/*      */         }
/*      */       }
/*      */     }
/*  184 */     OnlineManager.getInstance().send(roleId, sPartnerLogginInfo);
/*  185 */     return true;
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
/*      */   static boolean fillProperty(int partnerId, RolePartner rolePartner, mzm.gsp.partner.Property propertyPro)
/*      */   {
/*  201 */     xbean.Property xProperty = (xbean.Property)rolePartner.getPartnerBag().getPartner2property().get(Integer.valueOf(partnerId));
/*  202 */     return fillProperty(rolePartner.getRoleId(), propertyPro, xProperty);
/*      */   }
/*      */   
/*      */   static boolean fillProperty(long roleId, mzm.gsp.partner.Property propertyPro, xbean.Property xProperty)
/*      */   {
/*  207 */     PartnerOutFightObj partnerOutFightObj = new PartnerOutFightObj(roleId, xProperty);
/*  208 */     if (xProperty == null)
/*      */     {
/*  210 */       return false;
/*      */     }
/*  212 */     if (xProperty.getOwnskills().size() > 0)
/*      */     {
/*  214 */       propertyPro.skillinfos = new HashMap(xProperty.getOwnskills());
/*      */     }
/*  216 */     if (xProperty.getSubyuanlv().size() > 0)
/*      */     {
/*  218 */       propertyPro.levels = new ArrayList(xProperty.getSubyuanlv());
/*      */     }
/*  220 */     propertyPro.yuanlv = xProperty.getYuanlv();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  225 */     if (xProperty.getLoves().size() > 0)
/*      */     {
/*  227 */       propertyPro.loves.addAll(xProperty.getLoves());
/*      */     }
/*  229 */     if (xProperty.getLovestoreplace().size() > 0)
/*      */     {
/*  231 */       propertyPro.lovestoreplace.addAll(xProperty.getLovestoreplace());
/*      */     }
/*  233 */     propertyPro.hp = partnerOutFightObj.getFinalMaxHP();
/*  234 */     propertyPro.mp = partnerOutFightObj.getFinalMaxMP();
/*      */     
/*  236 */     propertyPro.maxhp = partnerOutFightObj.getFinalMaxHP();
/*  237 */     propertyPro.maxmp = partnerOutFightObj.getFinalMaxMP();
/*  238 */     propertyPro.magatk = partnerOutFightObj.getFinalMAGATK();
/*  239 */     propertyPro.magcrt = partnerOutFightObj.getFinalMAGCRTLEVEL();
/*      */     
/*      */ 
/*  242 */     propertyPro.magdef = partnerOutFightObj.getFinalMAGDEF();
/*  243 */     propertyPro.phyatk = partnerOutFightObj.getFinalPHYATK();
/*      */     
/*  245 */     propertyPro.phycrt = partnerOutFightObj.getFinalPHYCRITLEVEL();
/*  246 */     propertyPro.phydef = partnerOutFightObj.getFinalPHYDEF();
/*  247 */     propertyPro.sealres = partnerOutFightObj.getFinalSealRst();
/*  248 */     propertyPro.speed = partnerOutFightObj.getFinalSpeed();
/*      */     
/*  250 */     propertyPro.fightvalue = xProperty.getFightvalue();
/*      */     
/*  252 */     return true;
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
/*      */   static void synSinglePartnerPro(long roleId, xbean.Property xProperty)
/*      */   {
/*  267 */     SSyncSinglePartnerPro pro = new SSyncSinglePartnerPro();
/*  268 */     pro.partnerid = xProperty.getPartnercfgid();
/*  269 */     fillProperty(roleId, pro.property, xProperty);
/*  270 */     OnlineManager.getInstance().send(roleId, pro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onRoleLevelUp(long roleId)
/*      */   {
/*  281 */     if (RoleInterface.getLevel(roleId) <= PartnerConstants.getInstance().OPEN_LEVEL)
/*      */     {
/*  283 */       return false;
/*      */     }
/*      */     
/*  286 */     RolePartner rolePartner = getRolePartner(roleId, true);
/*  287 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/*  289 */       return false;
/*      */     }
/*  291 */     if (rolePartner.getPartnerBag().getOwnpartnerids().size() <= 0)
/*      */     {
/*  293 */       return false;
/*      */     }
/*      */     
/*  296 */     if (!checkAndSendNewSkill(roleId, rolePartner, false))
/*      */     {
/*  298 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  302 */     syncPartnerProInfo(roleId, rolePartner, true);
/*  303 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkAndSendNewSkill(long roleId, RolePartner rolePartner, boolean needSend)
/*      */   {
/*  314 */     SNewGetSkill sNewGetSkill = new SNewGetSkill();
/*  315 */     for (Iterator i$ = rolePartner.getAllPartners().iterator(); i$.hasNext();) { int partnerId = ((Integer)i$.next()).intValue();
/*      */       
/*  317 */       PartnerCfg cfg = PartnerInitManager.getInstance().getPartnerCfg(partnerId);
/*  318 */       if (cfg == null)
/*      */       {
/*  320 */         GameServer.logger().error(String.format("PartnerManager.checkAndSendNewSkill@ partner cfg not exist!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*      */         
/*      */ 
/*  323 */         return false;
/*      */       }
/*      */       
/*  326 */       SkillList skillListPro = checkNewSkill(roleId, partnerId, cfg, rolePartner);
/*  327 */       if (skillListPro.skills.size() > 0)
/*      */       {
/*  329 */         sNewGetSkill.partner2skills.put(Integer.valueOf(partnerId), skillListPro);
/*      */       }
/*      */     }
/*  332 */     if ((needSend) && (sNewGetSkill.partner2skills.size() > 0))
/*      */     {
/*  334 */       OnlineManager.getInstance().send(roleId, sNewGetSkill);
/*      */     }
/*  336 */     return true;
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
/*      */   static void syncPartnerProInfo(long roleId, RolePartner rolePartner, boolean needUpdate)
/*      */   {
/*  349 */     SSyncPartnerRep pro = new SSyncPartnerRep();
/*  350 */     for (xbean.Property xProperty : rolePartner.getAllProperty().values())
/*      */     {
/*  352 */       int partnerId = xProperty.getPartnercfgid();
/*  353 */       if (needUpdate)
/*      */       {
/*  355 */         PartnerOutFightObj outFObj = new PartnerOutFightObj(rolePartner.getRoleId(), xProperty);
/*  356 */         outFObj.updateOutFightProperty();
/*      */       }
/*  358 */       mzm.gsp.partner.Property propertyPro = new mzm.gsp.partner.Property();
/*  359 */       if (fillProperty(partnerId, rolePartner, propertyPro))
/*      */       {
/*      */ 
/*      */ 
/*  363 */         pro.partnerid2property.put(Integer.valueOf(partnerId), propertyPro); }
/*      */     }
/*  365 */     if (pro.partnerid2property.size() > 0)
/*      */     {
/*  367 */       OnlineManager.getInstance().send(roleId, pro);
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
/*      */   static boolean onActivePartnerRep(String userid, long roleId, int partnerId)
/*      */   {
/*  380 */     RolePartner rolePartner = getRolePartner(roleId, true);
/*  381 */     return onActivePartnerRep(userid, roleId, partnerId, rolePartner);
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
/*      */   static boolean onActivePartnerRep(String userid, long roleId, int partnerId, RolePartner rolePartner)
/*      */   {
/*  395 */     if (RoleInterface.getLevel(roleId) < PartnerConstants.getInstance().OPEN_LEVEL)
/*      */     {
/*  397 */       return false;
/*      */     }
/*      */     
/*  400 */     if (rolePartner == null)
/*      */     {
/*  402 */       return false;
/*      */     }
/*  404 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(partnerId));
/*  405 */     if (partnerCfg == null)
/*      */     {
/*  407 */       GameServer.logger().error(String.format("[partner]PartnerManager.onAddLineUpPartner@ no partner cfg!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*      */       
/*      */ 
/*  410 */       return false;
/*      */     }
/*      */     
/*  413 */     if (!beforeActivePartner(userid, roleId, partnerCfg, rolePartner))
/*      */     {
/*  415 */       return false;
/*      */     }
/*  417 */     rolePartner.getPartnerBag().getOwnpartnerids().add(Integer.valueOf(partnerId));
/*  418 */     if (!afterActivePartner(roleId, partnerId, partnerCfg, rolePartner))
/*      */     {
/*  420 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  424 */     TriggerEventsManger.getInstance().triggerEvent(new GetPartner(), new PartnerEventArg(roleId, partnerId));
/*      */     
/*  426 */     PartnerLogManager.addPatnerOwnLog(roleId, partnerId);
/*      */     
/*  428 */     return true;
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
/*      */   private static boolean beforeActivePartner(String userid, long roleId, PartnerCfg partnerCfg, RolePartner rolePartner)
/*      */   {
/*  441 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/*  443 */       PartnerBag partnerBag = creatPartnerBagBean(rolePartner);
/*  444 */       Role2partnerbag.insert(Long.valueOf(roleId), partnerBag);
/*      */     }
/*  446 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/*  448 */       return false;
/*      */     }
/*  450 */     if (rolePartner.getPartnerBag().getOwnpartnerids().contains(Integer.valueOf(partnerCfg.getId())))
/*      */     {
/*  452 */       if (logger.isDebugEnabled())
/*      */       {
/*  454 */         GameServer.logger().error(String.format("[partner]PartnerManager.beforeActivePartner@ already own this partner!|roleId=%d|level=%d|partnerId=%d|needLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)), Integer.valueOf(partnerCfg.getId()), Integer.valueOf(partnerCfg.getsPartnerCfg().unlockLevel) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  460 */       return false;
/*      */     }
/*  462 */     if (partnerCfg.getsPartnerCfg().unlockLevel > RoleInterface.getLevel(roleId))
/*      */     {
/*  464 */       GameServer.logger().error(String.format("[partner]PartnerManager.beforeActivePartner@ not get to level!|roleId=%d|level=%d|partnerId=%d|needLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)), Integer.valueOf(partnerCfg.getId()), Integer.valueOf(partnerCfg.getsPartnerCfg().unlockLevel) }));
/*      */       
/*      */ 
/*      */ 
/*  468 */       return false;
/*      */     }
/*  470 */     return tryGetNewPartner(userid, roleId, partnerCfg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean tryGetNewPartner(String userid, long roleId, PartnerCfg partnerCfg)
/*      */   {
/*  481 */     int num = partnerCfg.getsPartnerCfg().unlockItemNum;
/*  482 */     switch (partnerCfg.getsPartnerCfg().unlockItem)
/*      */     {
/*      */     case 1: 
/*  485 */       if (!RoleInterface.cutGold(roleId, num, new TLogArg(LogReason.PARTNER_ACTIVE_REM)))
/*      */       {
/*  487 */         GameServer.logger().error(String.format("[partner]PartnerManager.tryGetNewPartner@ not enough gold!|roleId=%d|needGold=%d|ownGold=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(num), Long.valueOf(RoleInterface.getGold(roleId)) }));
/*      */         
/*      */ 
/*      */ 
/*  491 */         return false;
/*      */       }
/*      */       break;
/*      */     case 0: 
/*  495 */       if (QingfuInterface.costYuanbao(userid, roleId, num, CostType.COST_BIND_FIRST_PARTNER_ACTIVE, new TLogArg(LogReason.PARTNER_ACTIVE_REM)) != CostResult.Success)
/*      */       {
/*      */ 
/*  498 */         GameServer.logger().error(String.format("[partner]PartnerManager.tryGetNewPartner@ not enough yuanbao!|roleId=%d|needYuanbao=%d|ownYuanbao=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(num), Long.valueOf(QingfuInterface.getBalance(userid, true)) }));
/*      */         
/*      */ 
/*      */ 
/*  502 */         return false;
/*      */       }
/*      */       break;
/*      */     case 2: 
/*  506 */       if (!RoleInterface.cutSilver(roleId, num, new TLogArg(LogReason.PARTNER_ACTIVE_REM)))
/*      */       {
/*  508 */         GameServer.logger().error(String.format("[partner]PartnerManager.tryGetNewPartner@ not enough silver!|roleId=%d|needSilver=%d|ownSilver=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(num), Long.valueOf(RoleInterface.getSilver(roleId)) }));
/*      */         
/*      */ 
/*      */ 
/*  512 */         return false;
/*      */       }
/*      */       break;
/*      */     case 3: 
/*  516 */       int itemid = partnerCfg.getsPartnerCfg().unlockItemId;
/*  517 */       if (!ItemInterface.removeItemById(roleId, itemid, num, new TLogArg(LogReason.PARTNER_ACTIVE_REM)))
/*      */       {
/*  519 */         GameServer.logger().error(String.format("[partner]PartnerManager.tryGetNewPartner@ not enough item!|roleId=%d|needItemId=%d|needItemNum=%d|ownItemNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(itemid), Integer.valueOf(num), Integer.valueOf(ItemInterface.getItemNumberById(roleId, itemid)) }));
/*      */         
/*      */ 
/*      */ 
/*  523 */         return false;
/*      */       }
/*      */       
/*      */       break;
/*      */     default: 
/*  528 */       if (logger.isDebugEnabled())
/*      */       {
/*  530 */         GameServer.logger().error(String.format("[partner]PartnerManager.tryGetNewPartner@ active type error!|roleId=%d|type=%d|needItemNum=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerCfg.getsPartnerCfg().unlockItem), Integer.valueOf(num) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  535 */       return false;
/*      */     }
/*  537 */     return true;
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
/*      */   static boolean afterActivePartner(long roleId, int partnerId, PartnerCfg partnerCfg, RolePartner rolePartner)
/*      */   {
/*  553 */     xbean.Property xProperty = (xbean.Property)rolePartner.getPartnerBag().getPartner2property().get(Integer.valueOf(partnerId));
/*  554 */     if (xProperty == null)
/*      */     {
/*  556 */       xProperty = Pod.newProperty();
/*  557 */       xProperty.setPartnercfgid(partnerId);
/*  558 */       rolePartner.getPartnerBag().getPartner2property().put(Integer.valueOf(partnerId), xProperty);
/*      */     }
/*      */     
/*  561 */     Partner xPartner = new Partner(roleId, xProperty);
/*  562 */     xPartner.initSubLv();
/*  563 */     xPartner.setYuanLv(1);
/*  564 */     xPartner.onYuanLevelChange(false);
/*      */     
/*      */ 
/*  567 */     checkNewSkill(roleId, partnerId, partnerCfg, rolePartner);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  573 */     initLoves(xProperty);
/*      */     
/*  575 */     PartnerOutFightObj partnerOutFightObj = new PartnerOutFightObj(roleId, xProperty);
/*  576 */     xProperty.setHp(partnerOutFightObj.getFinalMaxHP());
/*  577 */     xProperty.setMp(partnerOutFightObj.getFinalMaxMP());
/*      */     
/*  579 */     SActivePartnerRep sActivePartnerRep = new SActivePartnerRep();
/*  580 */     sActivePartnerRep.partnerid = partnerId;
/*  581 */     mzm.gsp.partner.Property property = new mzm.gsp.partner.Property();
/*      */     
/*  583 */     if (!fillProperty(partnerId, rolePartner, property))
/*      */     {
/*  585 */       return false;
/*      */     }
/*  587 */     sActivePartnerRep.property = property;
/*  588 */     OnlineManager.getInstance().send(roleId, sActivePartnerRep);
/*  589 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void initLoves(xbean.Property xProperty)
/*      */   {
/*  599 */     xProperty.getLoves().clear();
/*  600 */     xProperty.getLoves().add(Integer.valueOf(PartnerConstants.getInstance().NULL_LOVE_ID));
/*  601 */     xProperty.getLoves().add(Integer.valueOf(PartnerConstants.getInstance().NULL_LOVE_ID));
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
/*      */   private static boolean getLove(PartnerCfg partnerCfg, RolePartner rolePartner)
/*      */   {
/*  614 */     Set<Integer> loveIds = LoveCfgManager.getNewLoveContentIds(partnerCfg.getLoveId(), new HashSet());
/*  615 */     if (loveIds.size() != PartnerConstants.getInstance().LOVE_NUM)
/*      */     {
/*  617 */       return false;
/*      */     }
/*  619 */     ((xbean.Property)rolePartner.getPartnerBag().getPartner2property().get(Integer.valueOf(partnerCfg.getId()))).getLoves().clear();
/*  620 */     ((xbean.Property)rolePartner.getPartnerBag().getPartner2property().get(Integer.valueOf(partnerCfg.getId()))).getLoves().addAll(loveIds);
/*  621 */     return true;
/*      */   }
/*      */   
/*      */   private static List<Integer> getLoveIdList(Map<Integer, Integer> fLove2RateMap, int seed)
/*      */   {
/*  626 */     List<Integer> loveIdList = new ArrayList();
/*  627 */     Map<Integer, Integer> tempMap = new HashMap();
/*  628 */     tempMap.putAll(fLove2RateMap);
/*  629 */     for (int i = 0; i < PartnerConstants.getInstance().LOVE_NUM; i++)
/*      */     {
/*  631 */       int loveId = getLoveId(tempMap, seed);
/*  632 */       if (loveId < 0)
/*      */       {
/*  634 */         if (logger.isDebugEnabled())
/*      */         {
/*  636 */           logger.debug("没有随机到情缘！");
/*      */         }
/*  638 */         return new ArrayList();
/*      */       }
/*  640 */       seed -= ((Integer)fLove2RateMap.get(Integer.valueOf(loveId))).intValue();
/*  641 */       tempMap.remove(Integer.valueOf(loveId));
/*  642 */       loveIdList.add(Integer.valueOf(loveId));
/*      */     }
/*      */     
/*  645 */     return loveIdList;
/*      */   }
/*      */   
/*      */   static List<Integer> getLoveList(Map<Integer, Integer> fLove2RateMap, List<Integer> ownLoveList)
/*      */   {
/*  650 */     Map<Integer, Integer> tempLoveMap = new HashMap();
/*  651 */     tempLoveMap.putAll(fLove2RateMap);
/*  652 */     int seed = 10000;
/*  653 */     for (Iterator i$ = ownLoveList.iterator(); i$.hasNext();) { int loveId = ((Integer)i$.next()).intValue();
/*      */       
/*  655 */       seed -= ((Integer)tempLoveMap.get(Integer.valueOf(loveId))).intValue();
/*  656 */       tempLoveMap.remove(Integer.valueOf(loveId));
/*      */     }
/*      */     
/*  659 */     return getLoveIdList(tempLoveMap, seed);
/*      */   }
/*      */   
/*      */   private static int getLoveId(Map<Integer, Integer> fLove2RateMap, int seed)
/*      */   {
/*  664 */     if ((seed <= 0) || (fLove2RateMap.size() <= 0))
/*      */     {
/*  666 */       return -1;
/*      */     }
/*  668 */     Random random = Xdb.random();
/*  669 */     int ran = random.nextInt(seed);
/*  670 */     int num_temp = 0;
/*  671 */     Iterator<Map.Entry<Integer, Integer>> it = fLove2RateMap.entrySet().iterator();
/*  672 */     while (it.hasNext())
/*      */     {
/*  674 */       Map.Entry<Integer, Integer> love2RateMap = (Map.Entry)it.next();
/*  675 */       num_temp += ((Integer)love2RateMap.getValue()).intValue();
/*  676 */       if (num_temp > ran)
/*      */       {
/*      */ 
/*      */ 
/*  680 */         return ((Integer)love2RateMap.getKey()).intValue(); }
/*      */     }
/*  682 */     return -1;
/*      */   }
/*      */   
/*      */   static PartnerBag creatPartnerBagBean(RolePartner rolePartner)
/*      */   {
/*  687 */     PartnerBag partnerBag = Pod.newPartnerBag();
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
/*  699 */     partnerBag.setDefaultlineupnum(0);
/*  700 */     if (partnerBag.getLineups().get(Integer.valueOf(0)) == null)
/*      */     {
/*  702 */       xbean.LineUp lineUp = Pod.newLineUp();
/*  703 */       partnerBag.getLineups().put(Integer.valueOf(0), lineUp);
/*      */     }
/*  705 */     rolePartner.setPartnerBag(partnerBag);
/*  706 */     return partnerBag;
/*      */   }
/*      */   
/*      */   static SkillList checkNewSkill(long roleId, int partnerId, PartnerCfg partnerCfg, RolePartner rolePartner)
/*      */   {
/*  711 */     SkillList skillListPro = new SkillList();
/*  712 */     Partner xPartner = rolePartner.getXPartner(partnerId);
/*  713 */     if (xPartner == null)
/*      */     {
/*      */ 
/*  716 */       return skillListPro;
/*      */     }
/*      */     
/*  719 */     for (Iterator i$ = partnerCfg.getsPartnerCfg().skills.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/*  721 */       if ((skillId > 0) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  726 */         (!xPartner.getSPartnerkills().containsKey(Integer.valueOf(skillId))))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  731 */         SPartnerSkillCfg cfg = SPartnerSkillCfg.get(skillId);
/*  732 */         if (cfg == null)
/*      */         {
/*  734 */           GameServer.logger().error(String.format("[partner]PartnerManager.checkNewSkill@ parnter skillcfg not exist!|roleId=%d|skillId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(skillId) }));
/*      */           
/*      */ 
/*      */ 
/*  738 */           return skillListPro;
/*      */         }
/*      */         
/*  741 */         if (canOpenSkill(cfg, roleId))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  746 */           xPartner.modSkill(skillId, 1);
/*  747 */           skillListPro.skills.add(Integer.valueOf(skillId));
/*      */         } } }
/*  749 */     return skillListPro;
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
/*      */   private static boolean canOpenSkill(SPartnerSkillCfg cfg, long roleId)
/*      */   {
/*  763 */     if (cfg.needPartnerLevel > RoleInterface.getLevel(roleId))
/*      */     {
/*  765 */       return false;
/*      */     }
/*  767 */     int xiulianCount = 0;
/*  768 */     List<XiuLianSkill> xSkills = XiuLianSkillInterface.getXiuLianSkill(roleId, 4, false);
/*  769 */     for (XiuLianSkill xSkill : xSkills)
/*      */     {
/*  771 */       if (xSkill.getSkillLevel() >= cfg.needPartnerXiuLianLevel)
/*      */       {
/*  773 */         xiulianCount++;
/*      */       }
/*      */     }
/*      */     
/*  777 */     return xiulianCount >= cfg.needPartnerXiuLianLevelCount;
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
/*      */   static boolean onAddLineUpPartner(long roleId, int partnerId, int lineUpNum)
/*      */   {
/*  790 */     RolePartner rolePartner = getRolePartner(roleId, true);
/*  791 */     return onAddLineUpPartner(roleId, partnerId, lineUpNum, rolePartner);
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
/*      */   static boolean onAddLineUpPartner(long roleId, int partnerId, int lineUpNum, RolePartner rolePartner)
/*      */   {
/*  805 */     if (rolePartner == null)
/*      */     {
/*  807 */       return false;
/*      */     }
/*  809 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/*  811 */       return false;
/*      */     }
/*  813 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(partnerId));
/*  814 */     if (partnerCfg == null)
/*      */     {
/*  816 */       GameServer.logger().error(String.format("[partner]PartnerManager.onAddLineUpPartner@ no partner cfg!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*      */       
/*      */ 
/*  819 */       return false;
/*      */     }
/*      */     
/*  822 */     if (!rolePartner.getPartnerBag().getOwnpartnerids().contains(Integer.valueOf(partnerId)))
/*      */     {
/*  824 */       GameServer.logger().error(String.format("[partner]PartnerManager.onAddLineUpPartner@ no own this partner yet!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*      */       
/*      */ 
/*      */ 
/*  828 */       return false;
/*      */     }
/*  830 */     if ((lineUpNum != 0) && (lineUpNum != 1) && (lineUpNum != 2))
/*      */     {
/*      */ 
/*  833 */       GameServer.logger().error(String.format("[partner]PartnerManager.onAddLineUpPartner@ lineUp from client not exist!|roleId=%d|partnerId=%d|lineUpNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId), Integer.valueOf(lineUpNum) }));
/*      */       
/*      */ 
/*      */ 
/*  837 */       return false;
/*      */     }
/*  839 */     if (rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(lineUpNum)) == null)
/*      */     {
/*  841 */       xbean.LineUp lineUp = Pod.newLineUp();
/*  842 */       rolePartner.getPartnerBag().getLineups().put(Integer.valueOf(lineUpNum), lineUp);
/*      */     }
/*      */     
/*  845 */     return innerAddPartner(roleId, partnerId, lineUpNum, rolePartner);
/*      */   }
/*      */   
/*      */   private static boolean innerAddPartner(long roleId, int partnerId, int lineUpNum, RolePartner rolePartner)
/*      */   {
/*  850 */     xbean.LineUp lineUp = (xbean.LineUp)rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(lineUpNum));
/*      */     
/*  852 */     if (lineUp.getPositions().size() >= PartnerConstants.getInstance().FIGHT_NUM)
/*      */     {
/*  854 */       GameServer.logger().error(String.format("[partner]PartnerManager.innerAddPartner@ lineUp members full!|roleId=%d|partnerId=%d|lineUpNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId), Integer.valueOf(lineUpNum) }));
/*      */       
/*      */ 
/*      */ 
/*  858 */       return false;
/*      */     }
/*      */     
/*  861 */     if (lineUp.getPositions().containsValue(Integer.valueOf(partnerId)))
/*      */     {
/*  863 */       GameServer.logger().error(String.format("[partner]PartnerManager.innerAddPartner@ already in this lineUp!|roleId=%d|partnerId=%d|lineUpNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId), Integer.valueOf(lineUpNum) }));
/*      */       
/*      */ 
/*      */ 
/*  867 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  871 */     if (!add2LineUpPositionList(partnerId, lineUpNum, lineUp))
/*      */     {
/*  873 */       return false;
/*      */     }
/*      */     
/*  876 */     sendLineUpChangePro(roleId, lineUpNum, lineUp);
/*      */     
/*  878 */     if (rolePartner.getPartnerBag().getDefaultlineupnum() == lineUpNum)
/*      */     {
/*  880 */       TriggerEventsManger.getInstance().triggerEvent(new PartnerPositionChange(), new PartnerPositionChangeEventArg(roleId, PartnerPositionChangeEventArg.PositionChangeTye.ADD_PARTNER));
/*      */     }
/*      */     
/*      */ 
/*  884 */     int partnerNum = lineUp.getPositions().size();
/*  885 */     TriggerEventsManger.getInstance().triggerEvent(new LineUpPartner(), new LineUpPartnerEventArg(roleId, partnerId, lineUpNum, partnerNum));
/*      */     
/*      */ 
/*  888 */     PartnerLogManager.partnerStatueChangeLog(roleId, partnerId, ++lineUpNum, 1);
/*  889 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean add2LineUpPositionList(int partnerId, int lineUpNum, xbean.LineUp lineUp)
/*      */   {
/*  895 */     int index = -1;
/*  896 */     for (int i = 0; i < 5; i++)
/*      */     {
/*  898 */       if (!lineUp.getPositions().containsKey(Integer.valueOf(i)))
/*      */       {
/*      */ 
/*      */ 
/*  902 */         index = i;
/*  903 */         break;
/*      */       } }
/*  905 */     if (index < 0)
/*      */     {
/*  907 */       GameServer.logger().error(String.format("[partner]PartnerManager.innerAddPartner@ lineUp members full!|partnerId=%d|lineUpNum=%d", new Object[] { Integer.valueOf(partnerId), Integer.valueOf(lineUpNum) }));
/*      */       
/*      */ 
/*  910 */       return false;
/*      */     }
/*  912 */     lineUp.getPositions().put(Integer.valueOf(index), Integer.valueOf(partnerId));
/*  913 */     return true;
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
/*      */   static boolean onRemoveLineUpPartner(long roleId, int partnerId, int lineUpNum)
/*      */   {
/*  926 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(partnerId));
/*  927 */     if (partnerCfg == null)
/*      */     {
/*  929 */       GameServer.logger().error(String.format("[partner]PartnerManager.onAddLineUpPartner@ no partner cfg!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*      */       
/*      */ 
/*  932 */       return false;
/*      */     }
/*  934 */     RolePartner rolePartner = getRolePartner(roleId, true);
/*  935 */     if (rolePartner == null)
/*      */     {
/*  937 */       return false;
/*      */     }
/*  939 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/*  941 */       return false;
/*      */     }
/*      */     
/*  944 */     if (!rolePartner.getPartnerBag().getOwnpartnerids().contains(Integer.valueOf(partnerId)))
/*      */     {
/*  946 */       if (logger.isDebugEnabled())
/*      */       {
/*  948 */         logger.debug("玩家没有激活该仙侣[" + partnerId + "]");
/*      */       }
/*  950 */       return false;
/*      */     }
/*      */     
/*  953 */     int lineUpSize = rolePartner.getPartnerBag().getLineups().size();
/*  954 */     lineUpSize++; if (lineUpSize <= lineUpNum)
/*      */     {
/*  956 */       if (logger.isDebugEnabled())
/*      */       {
/*  958 */         logger.debug("没有对应的阵容槽， 槽号[" + lineUpNum + "]");
/*      */       }
/*  960 */       return false;
/*      */     }
/*  962 */     return innerRmPartner(roleId, partnerId, lineUpNum, rolePartner);
/*      */   }
/*      */   
/*      */   private static boolean innerRmPartner(long roleId, int partnerId, int lineUpNum, RolePartner rolePartner)
/*      */   {
/*  967 */     xbean.LineUp lineUp = (xbean.LineUp)rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(lineUpNum));
/*  968 */     if (lineUp == null)
/*      */     {
/*  970 */       return false;
/*      */     }
/*  972 */     Map<Integer, Integer> postionMap = lineUp.getPositions();
/*  973 */     if ((postionMap == null) || (postionMap.size() == 0))
/*      */     {
/*  975 */       return false;
/*      */     }
/*  977 */     int index = -1;
/*  978 */     Iterator<Map.Entry<Integer, Integer>> it_position = postionMap.entrySet().iterator();
/*  979 */     while (it_position.hasNext())
/*      */     {
/*  981 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it_position.next();
/*  982 */       if (((Integer)entry.getValue()).intValue() == partnerId)
/*      */       {
/*  984 */         it_position.remove();
/*  985 */         index = ((Integer)entry.getKey()).intValue();
/*  986 */         break;
/*      */       }
/*      */     }
/*  989 */     if (index < 0)
/*      */     {
/*  991 */       if (logger.isDebugEnabled())
/*      */       {
/*  993 */         logger.debug("站位列表里没有该仙侣，槽位[" + lineUpNum + "]，仙侣[" + partnerId + "]");
/*      */       }
/*  995 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  999 */     while (lineUp.getPositions().get(Integer.valueOf(++index)) != null)
/*      */     {
/* 1001 */       int index_temp = index - 1;
/* 1002 */       Integer value_temp = (Integer)lineUp.getPositions().get(Integer.valueOf(index));
/* 1003 */       lineUp.getPositions().remove(Integer.valueOf(index));
/* 1004 */       lineUp.getPositions().put(Integer.valueOf(index_temp), value_temp);
/*      */     }
/*      */     
/* 1007 */     sendLineUpChangePro(roleId, lineUpNum, lineUp);
/*      */     
/*      */ 
/* 1010 */     if (rolePartner.getPartnerBag().getDefaultlineupnum() == lineUpNum)
/*      */     {
/* 1012 */       TriggerEventsManger.getInstance().triggerEvent(new PartnerPositionChange(), new PartnerPositionChangeEventArg(roleId, PartnerPositionChangeEventArg.PositionChangeTye.RM_PARTNER));
/*      */     }
/*      */     
/*      */ 
/* 1016 */     PartnerLogManager.partnerStatueChangeLog(roleId, partnerId, ++lineUpNum, 2);
/*      */     
/* 1018 */     return true;
/*      */   }
/*      */   
/*      */   static void sendLineUpChangePro(long roleId, int lineUpNum, xbean.LineUp lineUp)
/*      */   {
/* 1023 */     SChangeZhanWeiRep pro = new SChangeZhanWeiRep();
/* 1024 */     pro.lineupnum = lineUpNum;
/* 1025 */     mzm.gsp.partner.LineUp lineUpPro = new mzm.gsp.partner.LineUp();
/* 1026 */     List<Integer> positions = toList(lineUp.getPositions());
/* 1027 */     lineUpPro.positions.addAll(positions);
/* 1028 */     lineUpPro.zhenfaid = lineUp.getZhenfaid();
/* 1029 */     pro.lineup = lineUpPro;
/*      */     
/* 1031 */     OnlineManager.getInstance().send(roleId, pro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onChangeDefaultLinupReq(long roleId, int lineUpNum)
/*      */   {
/* 1043 */     RolePartner rolePartner = getRolePartner(roleId, true);
/* 1044 */     if (rolePartner == null)
/*      */     {
/* 1046 */       return false;
/*      */     }
/* 1048 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1050 */       return false;
/*      */     }
/*      */     
/* 1053 */     if ((lineUpNum != 0) && (lineUpNum != 1) && (lineUpNum != 2))
/*      */     {
/*      */ 
/* 1056 */       if (logger.isDebugEnabled())
/*      */       {
/* 1058 */         logger.debug("客户端要求增加的阵容不存在，阵容号[" + lineUpNum + "]");
/*      */       }
/* 1060 */       return false;
/*      */     }
/* 1062 */     if (rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(lineUpNum)) == null)
/*      */     {
/* 1064 */       xbean.LineUp lineUp = Pod.newLineUp();
/* 1065 */       rolePartner.getPartnerBag().getLineups().put(Integer.valueOf(lineUpNum), lineUp);
/*      */     }
/*      */     
/* 1068 */     int lineUpSize = rolePartner.getPartnerBag().getLineups().size();
/* 1069 */     lineUpSize++; if (lineUpSize <= lineUpNum)
/*      */     {
/* 1071 */       if (logger.isDebugEnabled())
/*      */       {
/* 1073 */         logger.debug("没有对应的阵容槽， 槽号[" + lineUpNum + "]");
/*      */       }
/* 1075 */       return false;
/*      */     }
/* 1077 */     if (rolePartner.getPartnerBag().getDefaultlineupnum() == lineUpNum)
/*      */     {
/* 1079 */       if (logger.isDebugEnabled())
/*      */       {
/* 1081 */         logger.debug("默认阵容号没有发生变化，不需要更换， 槽号[" + lineUpNum + "]");
/*      */       }
/* 1083 */       return false;
/*      */     }
/* 1085 */     rolePartner.getPartnerBag().setDefaultlineupnum(lineUpNum);
/*      */     
/*      */ 
/* 1088 */     SChangeDefaultLinupReq sChangeDefaultLinupReq = new SChangeDefaultLinupReq();
/* 1089 */     sChangeDefaultLinupReq.lineupnum = lineUpNum;
/* 1090 */     OnlineManager.getInstance().send(roleId, sChangeDefaultLinupReq);
/*      */     
/*      */ 
/* 1093 */     if (rolePartner.getPartnerBag().getDefaultlineupnum() == lineUpNum)
/*      */     {
/* 1095 */       TriggerEventsManger.getInstance().triggerEvent(new PartnerPositionChange(), new PartnerPositionChangeEventArg(roleId, PartnerPositionChangeEventArg.PositionChangeTye.CHANGE_DEFAULT_LINEUP));
/*      */     }
/*      */     
/*      */ 
/* 1099 */     PartnerLogManager.partnerDefaultSquadChangeLog(roleId, ++lineUpNum);
/*      */     
/* 1101 */     return true;
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
/*      */   static boolean onChangeZhenFaReq(long roleId, int lineUpNum, int zhenFaId, ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type)
/*      */   {
/* 1115 */     RolePartner rolePartner = getRolePartner(roleId, true);
/* 1116 */     return changeZhenFa(roleId, lineUpNum, zhenFaId, rolePartner, type);
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
/*      */   static boolean changeZhenFa(long roleId, int lineUpNum, int zhenFaId, RolePartner rolePartner, ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type)
/*      */   {
/* 1130 */     if (rolePartner == null)
/*      */     {
/* 1132 */       return false;
/*      */     }
/* 1134 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1136 */       return false;
/*      */     }
/*      */     
/* 1139 */     if (zhenFaId != 0)
/*      */     {
/* 1141 */       if ((zhenFaId < 0) || (!ZhenfaInterface.isZhenfaExists(zhenFaId)))
/*      */       {
/* 1143 */         logger.error("玩家：" + roleId + "，更换的阵法id不存在，id=" + zhenFaId);
/* 1144 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1148 */     int lineUpSize = rolePartner.getPartnerBag().getLineups().size();
/* 1149 */     lineUpSize++; if (lineUpSize <= lineUpNum)
/*      */     {
/* 1151 */       if (logger.isDebugEnabled())
/*      */       {
/* 1153 */         logger.debug("没有对应的阵容槽， 槽号[" + lineUpNum + "]");
/*      */       }
/* 1155 */       return false;
/*      */     }
/*      */     
/* 1158 */     return changeZhenFaId(roleId, lineUpNum, zhenFaId, rolePartner, type);
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
/*      */   static boolean changeZhenFaId(long roleId, int lineUpNum, int zhenFaId, RolePartner rolePartner, ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type)
/*      */   {
/* 1172 */     xbean.LineUp lineUp = (xbean.LineUp)rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(lineUpNum));
/* 1173 */     if (lineUp == null)
/*      */     {
/* 1175 */       lineUp = Pod.newLineUp();
/* 1176 */       rolePartner.getPartnerBag().getLineups().put(Integer.valueOf(lineUpNum), lineUp);
/*      */     }
/* 1178 */     if (lineUp.getZhenfaid() == zhenFaId)
/*      */     {
/* 1180 */       if (logger.isDebugEnabled())
/*      */       {
/* 1182 */         logger.debug("阵容阵法没有发生变化，不需要更换， 阵容号[" + lineUpNum + "]，阵法id[" + zhenFaId + "]");
/*      */       }
/* 1184 */       return false;
/*      */     }
/* 1186 */     lineUp.setZhenfaid(zhenFaId);
/*      */     
/* 1188 */     afterChangeZhenFaId(roleId, lineUpNum, zhenFaId, type);
/* 1189 */     return true;
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
/*      */   static void afterChangeZhenFaId(long roleId, int lineUpNum, int zhenFaId, ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type)
/*      */   {
/* 1203 */     TriggerEventsManger.getInstance().triggerEvent(new ChangePartnerZhenFaId(), new ChangePartnerZhenFaIdArg(roleId, lineUpNum, zhenFaId, type));
/*      */     
/*      */ 
/*      */ 
/* 1207 */     SChangeZhenFaReq sChangeZhenFaReq = new SChangeZhenFaReq();
/* 1208 */     sChangeZhenFaReq.lineupnum = lineUpNum;
/* 1209 */     sChangeZhenFaReq.zhenfaid = zhenFaId;
/* 1210 */     OnlineManager.getInstance().send(roleId, sChangeZhenFaReq);
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
/*      */   private static boolean onChangeZhanWeiReq(long roleId, int lineUpNum, int oldIndex, int newIndex)
/*      */   {
/* 1224 */     if ((lineUpNum < 0) || (lineUpNum > 2))
/*      */     {
/* 1226 */       if (logger.isDebugEnabled())
/*      */       {
/* 1228 */         logger.debug("传入的阵容号错误，阵容号[" + lineUpNum + "]");
/*      */       }
/* 1230 */       return false;
/*      */     }
/* 1232 */     RolePartner rolePartner = getRolePartner(roleId, true);
/* 1233 */     xbean.LineUp xLineUp = getLineUp(lineUpNum, rolePartner);
/* 1234 */     if (xLineUp == null)
/*      */     {
/* 1236 */       return false;
/*      */     }
/*      */     
/* 1239 */     Map<Integer, Integer> pos = xLineUp.getPositions();
/* 1240 */     if (pos == null)
/*      */     {
/* 1242 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1250 */     int oldIndex_real = oldIndex - 1;
/* 1251 */     int newIndex_real = newIndex - 1;
/* 1252 */     Integer oldPartnerId = (Integer)pos.get(Integer.valueOf(oldIndex_real));
/* 1253 */     Integer newPartnerId = (Integer)pos.get(Integer.valueOf(newIndex_real));
/*      */     
/* 1255 */     if ((oldPartnerId == null) || (newPartnerId == null))
/*      */     {
/* 1257 */       return false;
/*      */     }
/*      */     
/* 1260 */     xLineUp.getPositions().put(Integer.valueOf(newIndex_real), oldPartnerId);
/* 1261 */     xLineUp.getPositions().put(Integer.valueOf(oldIndex_real), newPartnerId);
/*      */     
/* 1263 */     sendLineUpChangePro(roleId, lineUpNum, xLineUp);
/*      */     
/* 1265 */     if (rolePartner.getPartnerBag().getDefaultlineupnum() == lineUpNum)
/*      */     {
/* 1267 */       TriggerEventsManger.getInstance().triggerEvent(new PartnerPositionChange(), new PartnerPositionChangeEventArg(roleId, PartnerPositionChangeEventArg.PositionChangeTye.CHANGE_ZHAN_WEI));
/*      */     }
/*      */     
/* 1270 */     return true;
/*      */   }
/*      */   
/*      */   private static xbean.LineUp getLineUp(int lineUpNum, RolePartner rolePartner)
/*      */   {
/* 1275 */     if (rolePartner == null)
/*      */     {
/* 1277 */       return null;
/*      */     }
/* 1279 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1281 */       return null;
/*      */     }
/* 1283 */     return (xbean.LineUp)rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(lineUpNum));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onReplaceLovesReq(long roleId, int partnerId)
/*      */   {
/* 1295 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(partnerId));
/* 1296 */     if (partnerCfg == null)
/*      */     {
/* 1298 */       if (logger.isDebugEnabled())
/*      */       {
/* 1300 */         logger.debug("不存在的仙侣id" + partnerId);
/*      */       }
/* 1302 */       return false;
/*      */     }
/* 1304 */     RolePartner rolePartner = getRolePartner(roleId, true);
/* 1305 */     if (rolePartner == null)
/*      */     {
/* 1307 */       return false;
/*      */     }
/* 1309 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1311 */       return false;
/*      */     }
/*      */     
/* 1314 */     if (!rolePartner.getPartnerBag().getOwnpartnerids().contains(Integer.valueOf(partnerId)))
/*      */     {
/* 1316 */       if (logger.isDebugEnabled())
/*      */       {
/* 1318 */         logger.debug("玩家没有激活该仙侣[" + partnerId + "]");
/*      */       }
/* 1320 */       return false;
/*      */     }
/*      */     
/* 1323 */     xbean.Property partner = (xbean.Property)rolePartner.getPartnerBag().getPartner2property().get(Integer.valueOf(partnerId));
/* 1324 */     if (partner == null)
/*      */     {
/* 1326 */       return false;
/*      */     }
/* 1328 */     if ((partner.getLoves().size() != 2) || (partner.getLovestoreplace().size() != 2))
/*      */     {
/* 1330 */       return false;
/*      */     }
/* 1332 */     partner.getLoves().clear();
/* 1333 */     partner.getLoves().addAll(partner.getLovestoreplace());
/* 1334 */     partner.getLovestoreplace().clear();
/*      */     
/*      */ 
/* 1337 */     SReplaceLovesReq sReplaceLovesReq = new SReplaceLovesReq();
/* 1338 */     sReplaceLovesReq.partnerid = partnerId;
/* 1339 */     sReplaceLovesReq.lovestoreplace.addAll(partner.getLoves());
/*      */     
/* 1341 */     OnlineManager.getInstance().send(roleId, sReplaceLovesReq);
/*      */     
/* 1343 */     PartnerLogManager.addPatnerShuffleLog(roleId, partnerId, 2);
/* 1344 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onShuffleLovesReq(long roleId, int partnerId)
/*      */   {
/* 1356 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(partnerId));
/* 1357 */     if (partnerCfg == null)
/*      */     {
/* 1359 */       if (logger.isDebugEnabled())
/*      */       {
/* 1361 */         logger.debug("不存在的仙侣id" + partnerId);
/*      */       }
/* 1363 */       return false;
/*      */     }
/* 1365 */     RolePartner rolePartner = getRolePartner(roleId, true);
/* 1366 */     if (rolePartner == null)
/*      */     {
/* 1368 */       return false;
/*      */     }
/* 1370 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1372 */       return false;
/*      */     }
/*      */     
/* 1375 */     if (!rolePartner.getPartnerBag().getOwnpartnerids().contains(Integer.valueOf(partnerId)))
/*      */     {
/* 1377 */       if (logger.isDebugEnabled())
/*      */       {
/* 1379 */         logger.debug("玩家没有激活该仙侣[" + partnerId + "]");
/*      */       }
/* 1381 */       return false;
/*      */     }
/*      */     
/* 1384 */     xbean.Property partner = (xbean.Property)rolePartner.getPartnerBag().getPartner2property().get(Integer.valueOf(partnerId));
/* 1385 */     if (partner == null)
/*      */     {
/* 1387 */       return false;
/*      */     }
/*      */     
/* 1390 */     if (!RoleInterface.cutGold(roleId, PartnerConstants.getInstance().WASHGOLD_NUM, new TLogArg(LogReason.PARTNER_SHUFFLE_LOVES_REM)))
/*      */     {
/*      */ 
/* 1393 */       GameServer.logger().error(String.format("[partner]PartnerManager.onShuffleLovesReq@ not enough gold!|roleId=%d|needGold=%d|ownGold=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(PartnerConstants.getInstance().WASHGOLD_NUM), Long.valueOf(RoleInterface.getGold(roleId)) }));
/*      */       
/*      */ 
/*      */ 
/* 1397 */       return false;
/*      */     }
/* 1399 */     List<Integer> ownLoveList = partner.getLoves();
/*      */     
/* 1401 */     List<Integer> loveList = getNewLoves(partnerCfg, partner);
/* 1402 */     if (loveList.size() != PartnerConstants.getInstance().LOVE_NUM)
/*      */     {
/* 1404 */       return false;
/*      */     }
/* 1406 */     partner.getLovestoreplace().clear();
/* 1407 */     partner.getLovestoreplace().addAll(loveList);
/* 1408 */     SShuffleLovesReq sShuffleLovesReq = new SShuffleLovesReq();
/* 1409 */     sShuffleLovesReq.partnerid = partnerId;
/* 1410 */     sShuffleLovesReq.lovestoreplace.addAll(loveList);
/* 1411 */     OnlineManager.getInstance().send(roleId, sShuffleLovesReq);
/*      */     
/*      */ 
/* 1414 */     PartnerLogManager.addPatnerShuffleLog(roleId, partnerId, 1);
/*      */     
/*      */ 
/* 1417 */     TriggerEventsManger.getInstance().triggerEvent(new ShuffleLoves(), new PartnerLoveFlushArg(roleId, partnerId, ownLoveList, loveList));
/*      */     
/*      */ 
/* 1420 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<Integer> getNewLoves(PartnerCfg partnerCfg, xbean.Property partner)
/*      */   {
/* 1430 */     Set<Integer> newLoves = LoveCfgManager.getNewLoveContentIds(partnerCfg.getLoveId(), new HashSet());
/* 1431 */     return new ArrayList(newLoves);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isInOwnPartnerList(long roleId, int partnerId)
/*      */   {
/* 1443 */     PartnerCfg partnerCfg = (PartnerCfg)PartnerInitManager.getInstance().getPartnerCfgMap().get(Integer.valueOf(partnerId));
/* 1444 */     if (partnerCfg == null)
/*      */     {
/* 1446 */       if (logger.isDebugEnabled())
/*      */       {
/* 1448 */         logger.debug("不存在的仙侣id" + partnerId);
/*      */       }
/* 1450 */       return false;
/*      */     }
/* 1452 */     RolePartner rolePartner = getRolePartner(roleId, true);
/* 1453 */     if (rolePartner == null)
/*      */     {
/* 1455 */       return false;
/*      */     }
/* 1457 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1459 */       return false;
/*      */     }
/* 1461 */     return rolePartner.getPartnerBag().getOwnpartnerids().contains(Integer.valueOf(partnerId));
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
/*      */   static RolePartner getRolePartner(long roleId, boolean isRetainLock)
/*      */   {
/* 1476 */     RolePartner rolePartner = new RolePartner(roleId, isRetainLock);
/* 1477 */     return rolePartner;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendNormalResult(long roleid, int result, String... args)
/*      */   {
/* 1489 */     SPartnerNormalResult pro = new SPartnerNormalResult();
/* 1490 */     pro.result = result;
/* 1491 */     for (String arg : args)
/*      */     {
/* 1493 */       pro.args.add(arg);
/*      */     }
/* 1495 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
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
/*      */   static Map<Integer, Integer> getFightPartnerListWithoutRoleImpl(long roleId, boolean remainRoleLock)
/*      */   {
/* 1510 */     RolePartner rolePartner = getRolePartner(roleId, remainRoleLock);
/* 1511 */     if (rolePartner == null)
/*      */     {
/* 1513 */       return null;
/*      */     }
/* 1515 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1517 */       return null;
/*      */     }
/* 1519 */     int index = rolePartner.getPartnerBag().getDefaultlineupnum();
/* 1520 */     if (index < 0)
/*      */     {
/* 1522 */       return null;
/*      */     }
/* 1524 */     if (rolePartner.getPartnerBag().getLineups() == null)
/*      */     {
/* 1526 */       return null;
/*      */     }
/* 1528 */     if (rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(index)) == null)
/*      */     {
/* 1530 */       return null;
/*      */     }
/* 1532 */     return ((xbean.LineUp)rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(index))).getPositions();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getDefLineUp(long roleId, boolean remainRoleLock)
/*      */   {
/* 1544 */     RolePartner rolePartner = getRolePartner(roleId, remainRoleLock);
/* 1545 */     return getDefLineUp(rolePartner);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getDefLineUp(RolePartner rolePartner)
/*      */   {
/* 1554 */     if (rolePartner == null)
/*      */     {
/* 1556 */       return -1;
/*      */     }
/* 1558 */     if (rolePartner.getPartnerBag() == null)
/*      */     {
/* 1560 */       return -1;
/*      */     }
/* 1562 */     int index = rolePartner.getPartnerBag().getDefaultlineupnum();
/* 1563 */     if (index < 0)
/*      */     {
/* 1565 */       return -1;
/*      */     }
/* 1567 */     if (rolePartner.getPartnerBag().getLineups() == null)
/*      */     {
/* 1569 */       return -1;
/*      */     }
/* 1571 */     return index;
/*      */   }
/*      */   
/*      */   static List<Integer> toList(Map<Integer, Integer> map_index)
/*      */   {
/* 1576 */     List<Integer> finalList = new ArrayList();
/* 1577 */     for (int j = 0; j < 4; j++)
/*      */     {
/* 1579 */       finalList.add(Integer.valueOf(0));
/*      */     }
/* 1581 */     if ((map_index == null) || (map_index.size() == 0))
/*      */     {
/* 1583 */       return finalList;
/*      */     }
/* 1585 */     for (int i = 0; i < 4; i++)
/*      */     {
/* 1587 */       Integer id_temp = (Integer)map_index.get(Integer.valueOf(i));
/* 1588 */       if (id_temp == null)
/*      */       {
/* 1590 */         finalList.set(i, Integer.valueOf(0));
/*      */       }
/*      */       else
/*      */       {
/* 1594 */         finalList.set(i, id_temp);
/*      */       }
/*      */     }
/* 1597 */     return finalList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void noticSubYuanLvChange(long roleId, Partner xPartner)
/*      */   {
/* 1607 */     SSynPartnerYuanShen pro = new SSynPartnerYuanShen();
/* 1608 */     pro.levels = new ArrayList(xPartner.getSubYuanLevel());
/* 1609 */     pro.yuanlv = xPartner.getYuanLevel();
/* 1610 */     pro.partnerid = xPartner.getId();
/* 1611 */     OnlineManager.getInstance().send(roleId, pro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synPartnerLvs(long roleId, Partner xPartner)
/*      */   {
/* 1619 */     SSynPartnerSkills pro = new SSynPartnerSkills();
/* 1620 */     pro.partnerid = xPartner.getId();
/* 1621 */     pro.skills = new HashMap(xPartner.getSPartnerkills());
/* 1622 */     OnlineManager.getInstance().send(roleId, pro);
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
/*      */   static int getItemNumToLevel(int costId, List<Integer> subYuanLvs)
/*      */   {
/* 1636 */     STYuanCostCfg cfg = STYuanCostCfg.get(costId);
/* 1637 */     if (cfg == null)
/*      */     {
/* 1639 */       GameServer.logger().error(String.format("[partner]partnerManager.getItemNumToLevel@ costId not exist!|costId=%d", new Object[] { Integer.valueOf(costId) }));
/*      */       
/* 1641 */       return -1;
/*      */     }
/* 1643 */     Map<Integer, Integer> lv2Ownnum = getYuanLv2OwnNum(subYuanLvs);
/* 1644 */     if (lv2Ownnum.size() == 0)
/*      */     {
/* 1646 */       GameServer.logger().error(String.format("[partner]partnerManager.getItemNumToLevel@ lv2num size is 0!|costId=%d|subYanLvs=%s", new Object[] { Integer.valueOf(costId), subYuanLvs.toString() }));
/*      */       
/*      */ 
/* 1649 */       return -1;
/*      */     }
/*      */     
/* 1652 */     Map<Integer, Integer> lv2itemNum = getYuanLv2NeedItemNum(lv2Ownnum, cfg.yuanLv2needNum);
/* 1653 */     if (GameServer.logger().isDebugEnabled())
/*      */     {
/* 1655 */       GameServer.logger().debug(String.format("[partner]partnerManager.getItemNumToLevel@ subYuan level 2 need item num|costId=%d|subYanLvs=%s|lv2itemNum=%s", new Object[] { Integer.valueOf(costId), subYuanLvs.toString(), lv2itemNum.toString() }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1661 */     return getNeedSumCount(lv2Ownnum, lv2itemNum);
/*      */   }
/*      */   
/*      */   private static int getNeedSumCount(Map<Integer, Integer> lv2Ownnum, Map<Integer, Integer> lv2itemNum)
/*      */   {
/* 1666 */     int needCount = 0;
/* 1667 */     for (Map.Entry<Integer, Integer> entry : lv2Ownnum.entrySet())
/*      */     {
/* 1669 */       Integer needNum = (Integer)lv2itemNum.get(entry.getKey());
/* 1670 */       if (needNum == null)
/*      */       {
/* 1672 */         GameServer.logger().error(String.format("[partner]partnerManager.getNeedSumCount@ lv2itemNum: lv 2 num is null!|lv=%d|lv2itemNum=%s", new Object[] { entry.getKey(), lv2itemNum.toString() }));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 1678 */         needCount += needNum.intValue() * ((Integer)entry.getValue()).intValue(); }
/*      */     }
/* 1680 */     return needCount;
/*      */   }
/*      */   
/*      */   private static Map<Integer, Integer> getYuanLv2NeedItemNum(Map<Integer, Integer> lv2num, Map<Integer, Integer> cfgLv2itemNum)
/*      */   {
/* 1685 */     List<Integer> lvs = new ArrayList(lv2num.keySet());
/* 1686 */     Collections.sort(lvs);
/*      */     
/* 1688 */     Map<Integer, Integer> lv2itemNum = new HashMap();
/* 1689 */     for (int i = 0; i < lvs.size(); i++)
/*      */     {
/* 1691 */       int lv = ((Integer)lvs.get(i)).intValue();
/* 1692 */       int bfLv = 0;
/* 1693 */       int sum = 0;
/* 1694 */       if (i > 0)
/*      */       {
/* 1696 */         bfLv = ((Integer)lvs.get(i - 1)).intValue();
/* 1697 */         Integer bfNum = (Integer)lv2itemNum.get(Integer.valueOf(bfLv));
/* 1698 */         if (bfNum != null)
/*      */         {
/* 1700 */           sum += bfNum.intValue();
/*      */         }
/*      */       }
/* 1703 */       for (int j = bfLv + 1; j <= lv; j++)
/*      */       {
/* 1705 */         Integer needNum = (Integer)cfgLv2itemNum.get(Integer.valueOf(j - 1));
/* 1706 */         if (needNum != null)
/*      */         {
/*      */ 
/*      */ 
/* 1710 */           sum += needNum.intValue(); }
/*      */       }
/* 1712 */       lv2itemNum.put(Integer.valueOf(lv), Integer.valueOf(sum));
/*      */     }
/* 1714 */     return lv2itemNum;
/*      */   }
/*      */   
/*      */   private static Map<Integer, Integer> getYuanLv2OwnNum(List<Integer> subYuanLvs)
/*      */   {
/* 1719 */     Map<Integer, Integer> lv2num = new HashMap();
/* 1720 */     for (Iterator i$ = subYuanLvs.iterator(); i$.hasNext();) { int lv = ((Integer)i$.next()).intValue();
/*      */       
/* 1722 */       Integer num = (Integer)lv2num.get(Integer.valueOf(lv));
/* 1723 */       if (num == null)
/*      */       {
/* 1725 */         num = Integer.valueOf(0);
/*      */       }
/* 1727 */       lv2num.put(Integer.valueOf(lv), Integer.valueOf(num.intValue() + 1));
/*      */     }
/* 1729 */     return lv2num;
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
/*      */   static void onSinglePartnerProChange(long roleId, Partner xPartner)
/*      */   {
/* 1742 */     PartnerOutFightObj obj = new PartnerOutFightObj(roleId, xPartner.xProperty);
/* 1743 */     obj.updateOutFightProperty();
/*      */     
/* 1745 */     synSinglePartnerPro(roleId, xPartner.xProperty);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
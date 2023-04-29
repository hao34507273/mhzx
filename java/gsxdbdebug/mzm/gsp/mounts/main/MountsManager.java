/*      */ package mzm.gsp.mounts.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.item.main.ItemOperateResult;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.mail.main.SendMailRet;
/*      */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*      */ import mzm.gsp.mounts.SMountsNormalFail;
/*      */ import mzm.gsp.mounts.SMountsUnProtectPetSuccess;
/*      */ import mzm.gsp.mounts.confbean.MountsPassiveSkillBean;
/*      */ import mzm.gsp.mounts.confbean.MountsStarLifeLevelBean;
/*      */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*      */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*      */ import mzm.gsp.mounts.confbean.SMountsPassiveSkillCfg;
/*      */ import mzm.gsp.mounts.confbean.SMountsStarLifeCfg;
/*      */ import mzm.gsp.mounts.confbean.SMountsUnLockItemCfg;
/*      */ import mzm.gsp.mounts.event.AppearanceMountsObserver;
/*      */ import mzm.gsp.mounts.event.AppearanceMountsObserverArg;
/*      */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChange;
/*      */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*      */ import mzm.gsp.mounts.event.MountsRoleActiveSkillChange;
/*      */ import mzm.gsp.mounts.event.MountsRoleActiveSkillChangeArg;
/*      */ import mzm.gsp.mounts.event.MountsRolePropertyChange;
/*      */ import mzm.gsp.mounts.event.MountsRolePropertyChangeArg;
/*      */ import mzm.gsp.mounts.event.RideMountsModelChange;
/*      */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.pet.main.PetInterface;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.AppearenceMountsInfo;
/*      */ import xbean.Role2MountsInfo;
/*      */ import xdb.Xdb;
/*      */ import xtable.Role2mounts;
/*      */ 
/*      */ public class MountsManager
/*      */ {
/*      */   static void triggerRideMountsModelChangeEvent(RideMountsModelChangeArg eventArg)
/*      */   {
/*   64 */     TriggerEventsManger.getInstance().triggerEvent(new RideMountsModelChange(), eventArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(eventArg.getRoleId())));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerMountsRolePropertyChangeEvent(MountsRolePropertyChangeArg eventArg)
/*      */   {
/*   76 */     TriggerEventsManger.getInstance().triggerEvent(new MountsRolePropertyChange(), eventArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(eventArg.getRoleId())));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerMountsPetPassiveSkillChangeEvent(MountsPetPassiveSkillChangeArg eventArg)
/*      */   {
/*   88 */     TriggerEventsManger.getInstance().triggerEvent(new MountsPetPassiveSkillChange(), eventArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(eventArg.getRoleId())));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerMountsRoleActiveSkillChangeEvent(MountsRoleActiveSkillChangeArg eventArg)
/*      */   {
/*  100 */     TriggerEventsManger.getInstance().triggerEvent(new MountsRoleActiveSkillChange(), eventArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(eventArg.getRoleId())));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerAppearanceMountsObserverEvent(AppearanceMountsObserverArg eventArg)
/*      */   {
/*  112 */     TriggerEventsManger.getInstance().triggerEvent(new AppearanceMountsObserver(), eventArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(eventArg.getRoleId())));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerAppearanceMountsExpiredEvent(long roleId, int mountsCfgId, long currentMountsId, long expiredMountsId)
/*      */   {
/*  122 */     sendAppearenceMountsExpiredMail(roleId, mountsCfgId);
/*      */     
/*  124 */     triggerMountsRolePropertyChangeEvent(new MountsRolePropertyChangeArg(roleId));
/*      */     
/*      */ 
/*  127 */     if (currentMountsId == expiredMountsId)
/*      */     {
/*  129 */       triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(roleId, 0, -1, -1, 1));
/*      */       
/*      */ 
/*  132 */       MultiRoleMountsManager.onRoleUnrideMounts(roleId, 0);
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
/*      */   static boolean isLevelOpen(long roleId, String logString)
/*      */   {
/*  147 */     int level = RoleInterface.getLevel(roleId);
/*  148 */     if (level < SMountsConsts.getInstance().mountsOpenLevel)
/*      */     {
/*      */ 
/*  151 */       GameServer.logger().error(String.format("[mounts]%s@mounts function level not enough|role_id=%d|role_level=%d|need_level=%d", new Object[] { logString, Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(SMountsConsts.getInstance().mountsOpenLevel) }));
/*      */       
/*      */ 
/*  154 */       return false;
/*      */     }
/*  156 */     return true;
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
/*      */   static MountsPassiveSkillBean getPassiveSkillCfgIdRank(int mountsCfgId, int passiveSkillCfgId)
/*      */   {
/*  171 */     SMountsPassiveSkillCfg sMountsPassiveSkillCfg = SMountsPassiveSkillCfg.get(mountsCfgId);
/*  172 */     if (sMountsPassiveSkillCfg == null)
/*      */     {
/*  174 */       return null;
/*      */     }
/*      */     
/*  177 */     for (Map.Entry<Integer, MountsPassiveSkillBean> entry : sMountsPassiveSkillCfg.rankPassiveSkillMap.entrySet())
/*      */     {
/*  179 */       MountsPassiveSkillBean mountsPassiveSkillBean = (MountsPassiveSkillBean)entry.getValue();
/*  180 */       if (mountsPassiveSkillBean.randomPassiveSkillProbMap.containsKey(Integer.valueOf(passiveSkillCfgId)))
/*      */       {
/*  182 */         return mountsPassiveSkillBean;
/*      */       }
/*      */     }
/*      */     
/*  186 */     return null;
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
/*      */   static int getRefreshPassiveSkillCfgId(Map<Integer, Integer> randomPassiveSkillProbMap, int nowPassiveSkillCfgId, int lastRefreshPassiveSkillCfgId)
/*      */   {
/*  204 */     TreeMap<Integer, Integer> randomPassiveSkillMap = new TreeMap();
/*  205 */     int baseProb = 0;
/*      */     
/*  207 */     for (Map.Entry<Integer, Integer> entry : randomPassiveSkillProbMap.entrySet())
/*      */     {
/*  209 */       int passiveSkillCfgId = ((Integer)entry.getKey()).intValue();
/*  210 */       int passiveSkillProb = ((Integer)entry.getValue()).intValue();
/*      */       
/*  212 */       if ((nowPassiveSkillCfgId != passiveSkillCfgId) && (lastRefreshPassiveSkillCfgId != passiveSkillCfgId))
/*      */       {
/*      */ 
/*      */ 
/*  216 */         baseProb += passiveSkillProb;
/*  217 */         randomPassiveSkillMap.put(Integer.valueOf(baseProb), Integer.valueOf(passiveSkillCfgId));
/*      */       }
/*      */     }
/*  220 */     int random = Xdb.random().nextInt(baseProb);
/*  221 */     return ((Integer)randomPassiveSkillMap.ceilingEntry(Integer.valueOf(random)).getValue()).intValue();
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
/*      */   static Map.Entry<Integer, xbean.BattleMountsInfo> getProtectePetMounts(long roleId, long petId, Role2MountsInfo xRole2MountsInfo)
/*      */   {
/*  238 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> entry : xRole2MountsInfo.getBattle_mounts_info_map().entrySet())
/*      */     {
/*  240 */       List<Long> xCheckProtectPetIdList = ((xbean.BattleMountsInfo)entry.getValue()).getProtect_pet_id_list();
/*  241 */       if (xCheckProtectPetIdList.contains(Long.valueOf(petId)))
/*      */       {
/*  243 */         return entry;
/*      */       }
/*      */     }
/*  246 */     return null;
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
/*      */   static boolean isPetInProtect(long roleId, long petId, Role2MountsInfo xRole2MountsInfo)
/*      */   {
/*  262 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> entry : xRole2MountsInfo.getBattle_mounts_info_map().entrySet())
/*      */     {
/*  264 */       List<Long> xCheckProtectPetIdList = ((xbean.BattleMountsInfo)entry.getValue()).getProtect_pet_id_list();
/*  265 */       if (xCheckProtectPetIdList.contains(Long.valueOf(petId)))
/*      */       {
/*  267 */         return true;
/*      */       }
/*      */     }
/*  270 */     return false;
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
/*      */   static xbean.BattleMountsInfo getBattleMounts(long roleId, long mountsId, Role2MountsInfo xRole2MountsInfo)
/*      */   {
/*  290 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> entry : xRole2MountsInfo.getBattle_mounts_info_map().entrySet())
/*      */     {
/*  292 */       xbean.BattleMountsInfo xBattleMountsInfo = (xbean.BattleMountsInfo)entry.getValue();
/*  293 */       if (mountsId == xBattleMountsInfo.getMounts_id())
/*      */       {
/*  295 */         return xBattleMountsInfo;
/*      */       }
/*      */     }
/*  298 */     return null;
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
/*      */   static boolean isMountsSwitchOpen(long roleId, String logString)
/*      */   {
/*  313 */     if (!OpenInterface.getOpenStatus(160))
/*      */     {
/*  315 */       GameServer.logger().info(String.format("[mounts]%s@mounts system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*  316 */       return false;
/*      */     }
/*      */     
/*  319 */     if (OpenInterface.isBanPlay(roleId, 160))
/*      */     {
/*  321 */       GameServer.logger().info(String.format("[mounts]%s@mounts system is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*      */       
/*  323 */       OpenInterface.sendBanPlayMsg(roleId, 160);
/*  324 */       return false;
/*      */     }
/*      */     
/*  327 */     return true;
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
/*      */   static void sendAppearenceMountsExpiredMail(long roleId, int mountsCfgId)
/*      */   {
/*  340 */     SMountsCfg sMountsCfg = SMountsCfg.get(mountsCfgId);
/*  341 */     if (sMountsCfg == null)
/*      */     {
/*  343 */       return;
/*      */     }
/*      */     
/*  346 */     List<String> contextList = new ArrayList();
/*  347 */     contextList.add(sMountsCfg.mountsName);
/*  348 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleId, SMountsConsts.getInstance().appearenceMountsExpiredMailId, new ArrayList(), contextList, new MailAttachment(), new TLogArg(LogReason.MOUNTS_EXPIRED));
/*      */     
/*      */ 
/*  351 */     if (!sendMailRet.isOK())
/*      */     {
/*  353 */       GameServer.logger().error(String.format("[mounts]PMountsExpiredSession.processImp@send expired mail failed|role_id=%d|mounts_cfg_id=%d|ret=%d|ret_msg=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(sMountsCfg.id), Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean costItem(String userId, long roleId, int isUseYuanBao, long clientYuanBao, int needYuanBao, int costItemType, int calculateYuanBaoItemId, int needItemNum, CostType costType, LogReason logReason)
/*      */   {
/*  390 */     int hasItemNum = ItemInterface.getItemNumberByType(roleId, 340600000, costItemType, true);
/*      */     
/*  392 */     if (isUseYuanBao == 1)
/*      */     {
/*  394 */       long currentYuanBao = QingfuInterface.getBalance(userId, true);
/*  395 */       if (currentYuanBao != clientYuanBao)
/*      */       {
/*  397 */         GameServer.logger().error(String.format("[mounts]MountsManager.costItem@client yuan bao not same with server yuan bao|user_id=%s|role_id=%d|client_yuan_bao=%d|server_yuan_bao=%d", new Object[] { userId, Long.valueOf(roleId), Long.valueOf(clientYuanBao), Long.valueOf(currentYuanBao) }));
/*      */         
/*      */ 
/*      */ 
/*  401 */         return false;
/*      */       }
/*  403 */       if (hasItemNum < needItemNum)
/*      */       {
/*  405 */         int yuanbaoNum = (needItemNum - hasItemNum) * ItemInterface.getItemYuanBaoPrice(calculateYuanBaoItemId);
/*  406 */         if (yuanbaoNum != needYuanBao)
/*      */         {
/*  408 */           return false;
/*      */         }
/*      */         
/*      */ 
/*  412 */         if (!ItemInterface.removeItemsByItemType(roleId, costItemType, hasItemNum, true, new TLogArg(logReason)).success())
/*      */         {
/*  414 */           sSyncMountsNormalFail(roleId, 20);
/*  415 */           return false;
/*      */         }
/*      */         
/*      */ 
/*  419 */         CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, yuanbaoNum, costType, new TLogArg(logReason));
/*      */         
/*  421 */         if (costResult != CostResult.Success)
/*      */         {
/*  423 */           GameServer.logger().error(String.format("[mounts]MountsManager.costItem@cut yuan bao failed|user_id=%s|role_id=%d|ret=%d|ret_msg=%s", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(costResult.code), costResult.desc }));
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*  428 */           sSyncMountsNormalFail(roleId, 19);
/*  429 */           return false;
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  434 */         sSyncMountsNormalFail(roleId, 48);
/*  435 */         return false;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  440 */       if (hasItemNum < needItemNum)
/*      */       {
/*  442 */         sSyncMountsNormalFail(roleId, 31);
/*  443 */         return false;
/*      */       }
/*  445 */       if (!ItemInterface.removeItemsByItemType(roleId, costItemType, needItemNum, true, new TLogArg(logReason)).success())
/*      */       {
/*  447 */         sSyncMountsNormalFail(roleId, 20);
/*  448 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  452 */     return true;
/*      */   }
/*      */   
/*      */   static void sSyncMountsNormalFail(long roleId, int ret)
/*      */   {
/*  457 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/*  458 */     sMountsNormalFail.result = ret;
/*      */     
/*  460 */     OnlineManager.getInstance().sendAtOnce(roleId, sMountsNormalFail);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onPetRemoveFromBag(String userId, long roleId, long petId, String logString)
/*      */   {
/*  468 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*  469 */     if (xRole2MountsInfo == null)
/*      */     {
/*  471 */       return;
/*      */     }
/*      */     
/*  474 */     Map.Entry<Integer, xbean.BattleMountsInfo> xBattleMountsEntryInfo = getProtectePetMounts(roleId, petId, xRole2MountsInfo);
/*      */     
/*  476 */     if (xBattleMountsEntryInfo == null)
/*      */     {
/*  478 */       return;
/*      */     }
/*  480 */     xbean.BattleMountsInfo xBattleMountsInfo = (xbean.BattleMountsInfo)xBattleMountsEntryInfo.getValue();
/*      */     
/*  482 */     long mountsId = xBattleMountsInfo.getMounts_id();
/*  483 */     xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/*  484 */     if (xMountsInfo == null)
/*      */     {
/*  486 */       return;
/*      */     }
/*  488 */     List<Long> xBattleMountsProtectPetList = xBattleMountsInfo.getProtect_pet_id_list();
/*  489 */     int protectIndex = xBattleMountsProtectPetList.indexOf(Long.valueOf(petId));
/*  490 */     if (protectIndex >= 0)
/*      */     {
/*  492 */       xBattleMountsProtectPetList.set(protectIndex, Long.valueOf(-1L));
/*      */     }
/*      */     
/*  495 */     SMountsUnProtectPetSuccess sMountsUnProtectPetSuccess = new SMountsUnProtectPetSuccess();
/*  496 */     sMountsUnProtectPetSuccess.cell_id = ((Integer)xBattleMountsEntryInfo.getKey()).intValue();
/*  497 */     sMountsUnProtectPetSuccess.protect_index = protectIndex;
/*  498 */     sMountsUnProtectPetSuccess.pet_id = petId;
/*      */     
/*  500 */     OnlineManager.getInstance().send(roleId, sMountsUnProtectPetSuccess);
/*      */     
/*  502 */     triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(roleId, petId));
/*      */     
/*  504 */     tlogMountsProtectPet(userId, roleId, xBattleMountsInfo.getMounts_id(), xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), petId, 0, protectIndex);
/*      */     
/*      */ 
/*  507 */     GameServer.logger().info(String.format("[mounts]%s.processImp@handle pet remove from pet bag success|role_id=%d|pet_id=%d|cell_id=%d|mounts_id=%d", new Object[] { logString, Long.valueOf(roleId), Long.valueOf(petId), xBattleMountsEntryInfo.getKey(), Long.valueOf(xBattleMountsInfo.getMounts_id()) }));
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
/*      */   static void fillMountsInfoProtocol(xbean.MountsInfo xMountsInfo, mzm.gsp.mounts.MountsInfo sMountsInfo)
/*      */   {
/*  523 */     sMountsInfo.mounts_cfg_id = xMountsInfo.getMounts_cfg_id();
/*  524 */     sMountsInfo.mounts_rank = xMountsInfo.getMounts_rank();
/*  525 */     sMountsInfo.current_score = xMountsInfo.getCurrent_score();
/*  526 */     int currentOrnamentRank = xMountsInfo.getCurrent_ornament_rank();
/*  527 */     if (currentOrnamentRank == 0)
/*      */     {
/*  529 */       xMountsInfo.setCurrent_ornament_rank(xMountsInfo.getMounts_rank());
/*      */     }
/*  531 */     sMountsInfo.current_ornament_rank = xMountsInfo.getCurrent_ornament_rank();
/*  532 */     fillMountsStarInfo(sMountsInfo, xMountsInfo.getCurrent_mounts_star_level(), xMountsInfo.getCurrent_max_star_num());
/*      */     
/*  534 */     sMountsInfo.color_id = xMountsInfo.getMounts_dye_color_id();
/*  535 */     for (xbean.PassiveSkillInfo xPassiveSkillInfo : xMountsInfo.getMounts_passive_skill_list())
/*      */     {
/*  537 */       mzm.gsp.mounts.PassiveSkillInfo passiveSkillInfo = new mzm.gsp.mounts.PassiveSkillInfo();
/*  538 */       passiveSkillInfo.current_passive_skill_cfg_id = xPassiveSkillInfo.getPassive_skill_cfg_id();
/*  539 */       passiveSkillInfo.refresh_passive_skill_cfg_id = xPassiveSkillInfo.getRefresh_passive_skill_cfg_id();
/*      */       
/*  541 */       sMountsInfo.passive_skill_list.add(passiveSkillInfo);
/*      */     }
/*  543 */     sMountsInfo.protect_pet_expand_size = xMountsInfo.getProtect_pet_expand_size();
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillBattleMountsInfoProtocol(Role2MountsInfo xRole2MountsInfo, Map<Integer, mzm.gsp.mounts.BattleMountsInfo> battleMountsMap)
/*      */   {
/*  549 */     for (Map.Entry<Integer, xbean.BattleMountsInfo> entry : xRole2MountsInfo.getBattle_mounts_info_map().entrySet())
/*      */     {
/*  551 */       mzm.gsp.mounts.BattleMountsInfo battleMountsInfo = new mzm.gsp.mounts.BattleMountsInfo();
/*  552 */       xbean.BattleMountsInfo xBattleMountsInfo = (xbean.BattleMountsInfo)entry.getValue();
/*  553 */       battleMountsInfo.mounts_id = xBattleMountsInfo.getMounts_id();
/*  554 */       battleMountsInfo.is_chief_battle_mounts = (xRole2MountsInfo.getCurrent_chief_battle_mounts() == ((Integer)entry.getKey()).intValue() ? 1 : 0);
/*      */       
/*  556 */       battleMountsInfo.protect_pet_id_list.addAll(xBattleMountsInfo.getProtect_pet_id_list());
/*  557 */       battleMountsMap.put(entry.getKey(), battleMountsInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillMountsStarInfo(mzm.gsp.mounts.MountsInfo sMountsInfo, int mountsCurrentLevel, int currentMaxStarNum)
/*      */   {
/*  564 */     sMountsInfo.current_star_level = mountsCurrentLevel;
/*  565 */     sMountsInfo.current_max_active_star_num = currentMaxStarNum;
/*  566 */     SMountsStarLifeCfg sMountsStarLifeCfg = SMountsStarLifeCfg.get(sMountsInfo.mounts_cfg_id);
/*  567 */     if (sMountsStarLifeCfg == null)
/*      */     {
/*  569 */       return;
/*      */     }
/*  571 */     MountsStarLifeLevelBean mountsStarLifeLevelBean = (MountsStarLifeLevelBean)sMountsStarLifeCfg.starLifeLevelMap.get(Integer.valueOf(mountsCurrentLevel));
/*  572 */     if (mountsStarLifeLevelBean == null)
/*      */     {
/*  574 */       return;
/*      */     }
/*      */     
/*  577 */     if (mountsStarLifeLevelBean.starNumMap.isEmpty())
/*      */     {
/*  579 */       return;
/*      */     }
/*      */     
/*  582 */     if (((Integer)mountsStarLifeLevelBean.starNumMap.lastKey()).intValue() == currentMaxStarNum)
/*      */     {
/*  584 */       sMountsInfo.current_star_level = (mountsCurrentLevel + 1);
/*  585 */       sMountsInfo.current_max_active_star_num = 0;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsActiveStarLife(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int activeStarLevel, int activeStarNum, int isUseYuanBao)
/*      */   {
/*  596 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  598 */     StringBuilder sbLog = new StringBuilder();
/*  599 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  600 */     sbLog.append(userId).append('|');
/*  601 */     sbLog.append(roleId).append('|');
/*  602 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  604 */     sbLog.append(mountsId).append('|');
/*  605 */     sbLog.append(mountsCfgId).append('|');
/*  606 */     sbLog.append(mountsRank).append('|');
/*  607 */     sbLog.append(activeStarLevel).append('|');
/*  608 */     sbLog.append(activeStarNum).append('|');
/*  609 */     sbLog.append(isUseYuanBao);
/*      */     
/*  611 */     TLogManager.getInstance().addLog(roleId, "MountsActiveStarLifeStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsBattle(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int battleOperator)
/*      */   {
/*  620 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  622 */     StringBuilder sbLog = new StringBuilder();
/*  623 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  624 */     sbLog.append(userId).append('|');
/*  625 */     sbLog.append(roleId).append('|');
/*  626 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  628 */     sbLog.append(mountsId).append('|');
/*  629 */     sbLog.append(mountsCfgId).append('|');
/*  630 */     sbLog.append(mountsRank).append('|');
/*  631 */     sbLog.append(battleOperator);
/*      */     
/*  633 */     TLogManager.getInstance().addLog(roleId, "MountsBattleStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsDye(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int colorId, int isUseYuanBao, int oldColorId)
/*      */   {
/*  642 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  644 */     StringBuilder sbLog = new StringBuilder();
/*  645 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  646 */     sbLog.append(userId).append('|');
/*  647 */     sbLog.append(roleId).append('|');
/*  648 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  650 */     sbLog.append(mountsId).append('|');
/*  651 */     sbLog.append(mountsCfgId).append('|');
/*  652 */     sbLog.append(mountsRank).append('|');
/*  653 */     sbLog.append(colorId).append('|');
/*  654 */     sbLog.append(isUseYuanBao).append('|');
/*  655 */     sbLog.append(oldColorId);
/*      */     
/*  657 */     TLogManager.getInstance().addLog(roleId, "MountsDyeStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsProtectPet(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, long petId, int protectPetOperator, int protectIndex)
/*      */   {
/*  666 */     int roleLevel = RoleInterface.getLevel(roleId);
/*  667 */     int petCfgId = PetInterface.getPetCfgIdByPetId(roleId, petId);
/*      */     
/*  669 */     StringBuilder sbLog = new StringBuilder();
/*  670 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  671 */     sbLog.append(userId).append('|');
/*  672 */     sbLog.append(roleId).append('|');
/*  673 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  675 */     sbLog.append(mountsId).append('|');
/*  676 */     sbLog.append(mountsCfgId).append('|');
/*  677 */     sbLog.append(mountsRank).append('|');
/*  678 */     sbLog.append(petId).append('|');
/*  679 */     sbLog.append(petCfgId).append('|');
/*  680 */     sbLog.append(protectPetOperator).append('|');
/*  681 */     sbLog.append(protectIndex);
/*      */     
/*  683 */     TLogManager.getInstance().addLog(roleId, "MountsPetProtectStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsRankUp(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank)
/*      */   {
/*  692 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  694 */     StringBuilder sbLog = new StringBuilder();
/*  695 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  696 */     sbLog.append(userId).append('|');
/*  697 */     sbLog.append(roleId).append('|');
/*  698 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  700 */     sbLog.append(mountsId).append('|');
/*  701 */     sbLog.append(mountsCfgId).append('|');
/*  702 */     sbLog.append(mountsRank);
/*  703 */     TLogManager.getInstance().addLog(roleId, "MountsRankUpStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsRefreshPassiveSkill(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int currentPassiveSkillCfgId, int refreshPassiveSkillCfgId, int isUseYuanBao, List<xbean.PassiveSkillInfo> passiveSkillList)
/*      */   {
/*  713 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  715 */     StringBuilder sbLog = new StringBuilder();
/*  716 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  717 */     sbLog.append(userId).append('|');
/*  718 */     sbLog.append(roleId).append('|');
/*  719 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  721 */     sbLog.append(mountsId).append('|');
/*  722 */     sbLog.append(mountsCfgId).append('|');
/*  723 */     sbLog.append(mountsRank).append('|');
/*  724 */     sbLog.append(currentPassiveSkillCfgId).append('|');
/*  725 */     sbLog.append(refreshPassiveSkillCfgId).append('|');
/*  726 */     sbLog.append(isUseYuanBao);
/*      */     
/*  728 */     int count = 0;
/*  729 */     for (xbean.PassiveSkillInfo xPassiveSkillInfo : passiveSkillList)
/*      */     {
/*  731 */       count++;
/*  732 */       sbLog.append('|').append(xPassiveSkillInfo.getPassive_skill_cfg_id());
/*      */     }
/*      */     
/*  735 */     while (count < 3)
/*      */     {
/*  737 */       count++;
/*  738 */       sbLog.append("|0");
/*      */     }
/*  740 */     TLogManager.getInstance().addLog(roleId, "MountsRefreshPassiveSkillStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsReplacePassiveSkill(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int oldPassiveSkillCfgId, int replacePassiveSkillCfgId, List<xbean.PassiveSkillInfo> passiveSkillList)
/*      */   {
/*  750 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  752 */     StringBuilder sbLog = new StringBuilder();
/*  753 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  754 */     sbLog.append(userId).append('|');
/*  755 */     sbLog.append(roleId).append('|');
/*  756 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  758 */     sbLog.append(mountsId).append('|');
/*  759 */     sbLog.append(mountsCfgId).append('|');
/*  760 */     sbLog.append(mountsRank).append('|');
/*  761 */     sbLog.append(oldPassiveSkillCfgId).append('|');
/*  762 */     sbLog.append(replacePassiveSkillCfgId);
/*      */     
/*  764 */     int count = 0;
/*  765 */     for (xbean.PassiveSkillInfo xPassiveSkillInfo : passiveSkillList)
/*      */     {
/*  767 */       count++;
/*  768 */       sbLog.append('|').append(xPassiveSkillInfo.getPassive_skill_cfg_id());
/*      */     }
/*      */     
/*  771 */     while (count < 3)
/*      */     {
/*  773 */       count++;
/*  774 */       sbLog.append("|0");
/*      */     }
/*  776 */     TLogManager.getInstance().addLog(roleId, "MountsReplacePassiveSkillStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsRide(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int rideOperator)
/*      */   {
/*  785 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  787 */     StringBuilder sbLog = new StringBuilder();
/*  788 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  789 */     sbLog.append(userId).append('|');
/*  790 */     sbLog.append(roleId).append('|');
/*  791 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  793 */     sbLog.append(mountsId).append('|');
/*  794 */     sbLog.append(mountsCfgId).append('|');
/*  795 */     sbLog.append(mountsRank).append('|');
/*  796 */     sbLog.append(rideOperator);
/*      */     
/*  798 */     TLogManager.getInstance().addLog(roleId, "MountsRideStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsSetChiefBattle(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int operator)
/*      */   {
/*  807 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  809 */     StringBuilder sbLog = new StringBuilder();
/*  810 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  811 */     sbLog.append(userId).append('|');
/*  812 */     sbLog.append(roleId).append('|');
/*  813 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  815 */     sbLog.append(mountsId).append('|');
/*  816 */     sbLog.append(mountsCfgId).append('|');
/*  817 */     sbLog.append(mountsRank).append('|');
/*  818 */     sbLog.append(operator);
/*      */     
/*  820 */     TLogManager.getInstance().addLog(roleId, "MountsSetChiefBattleStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsUnLock(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int unlockItemId, List<xbean.PassiveSkillInfo> xPassiveSkillList)
/*      */   {
/*  829 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  831 */     StringBuilder sbLog = new StringBuilder();
/*  832 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  833 */     sbLog.append(userId).append('|');
/*  834 */     sbLog.append(roleId).append('|');
/*  835 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  837 */     sbLog.append(mountsId).append('|');
/*  838 */     sbLog.append(mountsCfgId).append('|');
/*  839 */     sbLog.append(mountsRank).append('|');
/*  840 */     sbLog.append(unlockItemId);
/*      */     
/*  842 */     int count = 0;
/*  843 */     for (xbean.PassiveSkillInfo xPassiveSkillInfo : xPassiveSkillList)
/*      */     {
/*  845 */       count++;
/*  846 */       sbLog.append('|').append(xPassiveSkillInfo.getPassive_skill_cfg_id());
/*      */     }
/*      */     
/*  849 */     while (count < 3)
/*      */     {
/*  851 */       count++;
/*  852 */       sbLog.append("|0");
/*      */     }
/*  854 */     TLogManager.getInstance().addLog(roleId, "MountsUnLockStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsCostItemAddScore(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int costItemId, int costItemNum, int addScore, int currentScore)
/*      */   {
/*  863 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  865 */     StringBuilder sbLog = new StringBuilder();
/*  866 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  867 */     sbLog.append(userId).append('|');
/*  868 */     sbLog.append(roleId).append('|');
/*  869 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  871 */     sbLog.append(mountsId).append('|');
/*  872 */     sbLog.append(mountsCfgId).append('|');
/*  873 */     sbLog.append(mountsRank).append('|');
/*  874 */     sbLog.append(costItemId).append('|');
/*  875 */     sbLog.append(costItemNum).append('|');
/*  876 */     sbLog.append(addScore).append('|');
/*  877 */     sbLog.append(currentScore);
/*      */     
/*  879 */     TLogManager.getInstance().addLog(roleId, "MountsCostItemAddScoreStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsCostMountsAddScore(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, long costMountsId, int costMountsCfgId, int costMountsRank, int addScore, int currentScore)
/*      */   {
/*  889 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  891 */     StringBuilder sbLog = new StringBuilder();
/*  892 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  893 */     sbLog.append(userId).append('|');
/*  894 */     sbLog.append(roleId).append('|');
/*  895 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  897 */     sbLog.append(mountsId).append('|');
/*  898 */     sbLog.append(mountsCfgId).append('|');
/*  899 */     sbLog.append(mountsRank).append('|');
/*  900 */     sbLog.append(costMountsId).append('|');
/*  901 */     sbLog.append(costMountsCfgId).append('|');
/*  902 */     sbLog.append(costMountsRank).append('|');
/*  903 */     sbLog.append(addScore).append('|');
/*  904 */     sbLog.append(currentScore);
/*      */     
/*  906 */     TLogManager.getInstance().addLog(roleId, "MountsCostMountsAddScoreStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsCostItemRankUp(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int costItemId, int costItemNum, int isUseYuanBao, List<xbean.PassiveSkillInfo> xPassiveSkillList)
/*      */   {
/*  916 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  918 */     StringBuilder sbLog = new StringBuilder();
/*  919 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  920 */     sbLog.append(userId).append('|');
/*  921 */     sbLog.append(roleId).append('|');
/*  922 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  924 */     sbLog.append(mountsId).append('|');
/*  925 */     sbLog.append(mountsCfgId).append('|');
/*  926 */     sbLog.append(mountsRank).append('|');
/*  927 */     sbLog.append(costItemId).append('|');
/*  928 */     sbLog.append(costItemNum).append('|');
/*  929 */     sbLog.append(isUseYuanBao);
/*      */     
/*  931 */     int count = 0;
/*  932 */     for (xbean.PassiveSkillInfo xPassiveSkillInfo : xPassiveSkillList)
/*      */     {
/*  934 */       count++;
/*  935 */       sbLog.append('|').append(xPassiveSkillInfo.getPassive_skill_cfg_id());
/*      */     }
/*      */     
/*  938 */     while (count < 3)
/*      */     {
/*  940 */       count++;
/*  941 */       sbLog.append("|0");
/*      */     }
/*      */     
/*  944 */     TLogManager.getInstance().addLog(roleId, "MountsCostItemRankUpStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogMountsSelectOrnamentRank(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int oldOrnamentRank, int newOrnamentRank)
/*      */   {
/*  953 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  955 */     StringBuilder sbLog = new StringBuilder();
/*  956 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  957 */     sbLog.append(userId).append('|');
/*  958 */     sbLog.append(roleId).append('|');
/*  959 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  961 */     sbLog.append(mountsId).append('|');
/*  962 */     sbLog.append(mountsCfgId).append('|');
/*  963 */     sbLog.append(mountsRank).append('|');
/*  964 */     sbLog.append(oldOrnamentRank).append('|');
/*  965 */     sbLog.append(newOrnamentRank);
/*      */     
/*  967 */     TLogManager.getInstance().addLog(roleId, "MountsSelectOrnamentRankStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkMutexStatus(long roleId)
/*      */   {
/*  975 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 83, true))
/*      */     {
/*  977 */       GameServer.logger().error(String.format("[mounts]MountsManager.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       
/*  979 */       return false;
/*      */     }
/*  981 */     return true;
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
/*      */   static boolean isExpandProtectPetSizeSwitchOpen(long roleId, String logString)
/*      */   {
/*  996 */     if (!OpenInterface.getOpenStatus(393))
/*      */     {
/*  998 */       GameServer.logger().info(String.format("[mounts]%s@expand protect pet size switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*      */       
/* 1000 */       return false;
/*      */     }
/*      */     
/* 1003 */     if (OpenInterface.isBanPlay(roleId, 393))
/*      */     {
/* 1005 */       GameServer.logger().info(String.format("[mounts]%s@expand protect pet size is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*      */       
/*      */ 
/* 1008 */       OpenInterface.sendBanPlayMsg(roleId, 393);
/* 1009 */       return false;
/*      */     }
/*      */     
/* 1012 */     return true;
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
/*      */   static void tlogMountsCostItemExpandProtectPetSize(String userId, long roleId, long mountsId, int mountsCfgId, int mountsRank, int costItemId, int costItemNum, int isUseYuanBao, int beforeProtectSize, int afterProtectSize)
/*      */   {
/* 1033 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1035 */     StringBuilder sbLog = new StringBuilder();
/* 1036 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1037 */     sbLog.append(userId).append('|');
/* 1038 */     sbLog.append(roleId).append('|');
/* 1039 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1041 */     sbLog.append(mountsId).append('|');
/* 1042 */     sbLog.append(mountsCfgId).append('|');
/* 1043 */     sbLog.append(mountsRank).append('|');
/* 1044 */     sbLog.append(costItemId).append('|');
/* 1045 */     sbLog.append(costItemNum).append('|');
/* 1046 */     sbLog.append(isUseYuanBao).append('|');
/*      */     
/* 1048 */     sbLog.append(beforeProtectSize).append('|');
/* 1049 */     sbLog.append(afterProtectSize);
/*      */     
/* 1051 */     TLogManager.getInstance().addLog(roleId, "MountsCostItemExpandProtectPetSize", sbLog.toString());
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
/*      */   static int getMountsNumMinRank(long roleId, int minRank, int mountsCfgId, boolean isRemainRoleLock)
/*      */   {
/* 1068 */     Role2MountsInfo xRole2MountsInfo = null;
/* 1069 */     if (isRemainRoleLock)
/*      */     {
/* 1071 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 1075 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 1078 */     if (xRole2MountsInfo == null)
/*      */     {
/* 1080 */       return 0;
/*      */     }
/*      */     
/* 1083 */     int mountsCount = 0;
/* 1084 */     for (xbean.MountsInfo xMountsInfo : xRole2MountsInfo.getMounts_info_map().values())
/*      */     {
/* 1086 */       if ((mountsCfgId <= 0) || (xMountsInfo.getMounts_cfg_id() == mountsCfgId))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1091 */         if (xMountsInfo.getMounts_rank() >= minRank)
/*      */         {
/* 1093 */           mountsCount++; }
/*      */       }
/*      */     }
/* 1096 */     return mountsCount;
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
/*      */   static int removeMounts(long roleId, int mountsUnlockItemCfgId, long mountsId)
/*      */   {
/* 1113 */     xbean.Basic xBasic = xtable.Basic.get(Long.valueOf(roleId));
/* 1114 */     if (xBasic == null)
/*      */     {
/* 1116 */       logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64036);
/* 1117 */       return 64036;
/*      */     }
/*      */     
/* 1120 */     SMountsUnLockItemCfg sMountsUnLockItemCfg = SMountsUnLockItemCfg.get(mountsUnlockItemCfgId);
/* 1121 */     if (sMountsUnLockItemCfg == null)
/*      */     {
/* 1123 */       logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64034);
/* 1124 */       return 64034;
/*      */     }
/*      */     
/* 1127 */     boolean isForever = (sMountsUnLockItemCfg.lastTime == -1) || (sMountsUnLockItemCfg.lastTime == 0);
/*      */     
/* 1129 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/* 1130 */     if (xRole2MountsInfo == null)
/*      */     {
/* 1132 */       logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64031);
/* 1133 */       return 64031;
/*      */     }
/*      */     
/* 1136 */     boolean isRealDelete = false;
/* 1137 */     long realRemoveMountsId = mountsId;
/* 1138 */     xbean.MountsInfo xMountsInfo = null;
/*      */     
/* 1140 */     if (isForever)
/*      */     {
/* 1142 */       if (mountsId == -1L)
/*      */       {
/* 1144 */         Iterator<Map.Entry<Long, xbean.MountsInfo>> iterator = xRole2MountsInfo.getMounts_info_map().entrySet().iterator();
/* 1145 */         while (iterator.hasNext())
/*      */         {
/* 1147 */           Map.Entry<Long, xbean.MountsInfo> entry = (Map.Entry)iterator.next();
/*      */           
/* 1149 */           xMountsInfo = (xbean.MountsInfo)entry.getValue();
/* 1150 */           if ((xMountsInfo.getMounts_cfg_id() == sMountsUnLockItemCfg.mountsCfgId) && (xMountsInfo.getMounts_rank() == sMountsUnLockItemCfg.mountsRank))
/*      */           {
/*      */ 
/* 1153 */             iterator.remove();
/* 1154 */             realRemoveMountsId = ((Long)entry.getKey()).longValue();
/* 1155 */             isRealDelete = true;
/* 1156 */             break;
/*      */           }
/*      */         }
/*      */         
/* 1160 */         if ((xMountsInfo == null) || (xMountsInfo.getMounts_cfg_id() != sMountsUnLockItemCfg.mountsCfgId) || (xMountsInfo.getMounts_rank() != sMountsUnLockItemCfg.mountsRank))
/*      */         {
/*      */ 
/* 1163 */           logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64032);
/* 1164 */           return 64032;
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1169 */         xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().remove(Long.valueOf(mountsId));
/* 1170 */         if (xMountsInfo == null)
/*      */         {
/* 1172 */           logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64035);
/* 1173 */           return 64035;
/*      */         }
/*      */         
/* 1176 */         if ((xMountsInfo.getMounts_cfg_id() != sMountsUnLockItemCfg.mountsCfgId) || (xMountsInfo.getMounts_rank() != sMountsUnLockItemCfg.mountsRank))
/*      */         {
/*      */ 
/* 1179 */           logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64033);
/* 1180 */           return 64033;
/*      */         }
/* 1182 */         isRealDelete = true;
/*      */       }
/*      */       
/*      */ 
/*      */     }
/* 1187 */     else if (mountsId == -1L)
/*      */     {
/* 1189 */       Iterator<Map.Entry<Long, xbean.MountsInfo>> iterator = xRole2MountsInfo.getMounts_info_map().entrySet().iterator();
/* 1190 */       while (iterator.hasNext())
/*      */       {
/* 1192 */         Map.Entry<Long, xbean.MountsInfo> entry = (Map.Entry)iterator.next();
/*      */         
/* 1194 */         xMountsInfo = (xbean.MountsInfo)entry.getValue();
/* 1195 */         if ((xMountsInfo.getMounts_cfg_id() == sMountsUnLockItemCfg.mountsCfgId) && (xMountsInfo.getMounts_rank() == sMountsUnLockItemCfg.mountsRank))
/*      */         {
/*      */ 
/* 1198 */           AppearenceMountsInfo xAppearenceMountsInfo = (AppearenceMountsInfo)xRole2MountsInfo.getAppearence_mounts_info_map().get(entry.getKey());
/*      */           
/*      */ 
/* 1201 */           long leftTime = xAppearenceMountsInfo.getStart_time() + xAppearenceMountsInfo.getEffect_time() - DateTimeUtils.getCurrTimeInMillis();
/*      */           
/*      */ 
/* 1204 */           if (leftTime < sMountsUnLockItemCfg.lastTime * 3600000L)
/*      */           {
/* 1206 */             iterator.remove();
/* 1207 */             isRealDelete = true;
/* 1208 */             realRemoveMountsId = ((Long)entry.getKey()).longValue(); break;
/*      */           }
/*      */           
/*      */ 
/* 1212 */           xAppearenceMountsInfo.setEffect_time(xAppearenceMountsInfo.getEffect_time() - sMountsUnLockItemCfg.lastTime * 3600000L);
/*      */           
/*      */ 
/* 1215 */           break;
/*      */         }
/*      */       }
/*      */       
/* 1219 */       if ((xMountsInfo == null) || (xMountsInfo.getMounts_cfg_id() != sMountsUnLockItemCfg.mountsCfgId) || (xMountsInfo.getMounts_rank() != sMountsUnLockItemCfg.mountsRank))
/*      */       {
/*      */ 
/* 1222 */         logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64032);
/* 1223 */         return 64032;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1228 */       xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/* 1229 */       if (xMountsInfo == null)
/*      */       {
/* 1231 */         logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64035);
/* 1232 */         return 64035;
/*      */       }
/*      */       
/* 1235 */       if ((xMountsInfo.getMounts_cfg_id() != sMountsUnLockItemCfg.mountsCfgId) || (xMountsInfo.getMounts_rank() != sMountsUnLockItemCfg.mountsRank))
/*      */       {
/*      */ 
/* 1238 */         logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 64033);
/* 1239 */         return 64033;
/*      */       }
/*      */       
/* 1242 */       AppearenceMountsInfo xAppearenceMountsInfo = (AppearenceMountsInfo)xRole2MountsInfo.getAppearence_mounts_info_map().get(Long.valueOf(mountsId));
/*      */       
/*      */ 
/* 1245 */       long leftTime = xAppearenceMountsInfo.getStart_time() + xAppearenceMountsInfo.getEffect_time() - DateTimeUtils.getCurrTimeInMillis();
/*      */       
/*      */ 
/* 1248 */       if (leftTime < sMountsUnLockItemCfg.lastTime * 3600000L)
/*      */       {
/* 1250 */         isRealDelete = true;
/*      */         
/* 1252 */         xRole2MountsInfo.getMounts_info_map().remove(Long.valueOf(mountsId));
/*      */       }
/*      */       else
/*      */       {
/* 1256 */         xAppearenceMountsInfo.setEffect_time(xAppearenceMountsInfo.getEffect_time() - sMountsUnLockItemCfg.lastTime * 3600000L);
/*      */         
/* 1258 */         realRemoveMountsId = -1L;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1263 */     if ((realRemoveMountsId == xRole2MountsInfo.getCurrent_ride_mounts_id()) && (isRealDelete))
/*      */     {
/* 1265 */       xRole2MountsInfo.setCurrent_ride_mounts_id(0L);
/*      */       
/*      */ 
/* 1268 */       triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(roleId, 0, -1, -1, 1));
/*      */     }
/*      */     
/*      */ 
/* 1272 */     if (isRealDelete)
/*      */     {
/* 1274 */       xRole2MountsInfo.getAppearence_mounts_info_map().remove(Long.valueOf(realRemoveMountsId));
/*      */     }
/*      */     
/* 1277 */     if (isRealDelete)
/*      */     {
/* 1279 */       Iterator<xbean.BattleMountsInfo> xBattleMountsIterator = xRole2MountsInfo.getBattle_mounts_info_map().values().iterator();
/* 1280 */       while (xBattleMountsIterator.hasNext())
/*      */       {
/* 1282 */         xbean.BattleMountsInfo xBattleMountsInfo = (xbean.BattleMountsInfo)xBattleMountsIterator.next();
/* 1283 */         if (xBattleMountsInfo.getMounts_id() == realRemoveMountsId)
/*      */         {
/* 1285 */           xBattleMountsIterator.remove();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1291 */     triggerMountsRolePropertyChangeEvent(new MountsRolePropertyChangeArg(roleId));
/*      */     
/* 1293 */     tlogRemoveMounts(xBasic.getUser_id(), roleId, mountsUnlockItemCfgId, xMountsInfo.getMounts_cfg_id(), mountsId, realRemoveMountsId, isRealDelete);
/*      */     
/*      */ 
/* 1296 */     OnlineManager.getInstance().forceReconnect(roleId);
/*      */     
/* 1298 */     logRemoveMounts(roleId, mountsUnlockItemCfgId, mountsId, 0);
/*      */     
/* 1300 */     return 0;
/*      */   }
/*      */   
/*      */   private static void logRemoveMounts(long roleId, int mountsUnlockItemCfgId, long mountsId, int ret)
/*      */   {
/* 1305 */     StringBuilder stringBuilder = new StringBuilder();
/* 1306 */     stringBuilder.append("[mounts]MountsManager.logRemoveMounts@log remove mounts");
/* 1307 */     stringBuilder.append("|role_id=").append(roleId);
/* 1308 */     stringBuilder.append("|mounts_id=").append(mountsId);
/* 1309 */     stringBuilder.append("|mounts_unlock_item_cfg_id=").append(mountsUnlockItemCfgId);
/* 1310 */     stringBuilder.append("|ret=").append(ret);
/*      */     
/* 1312 */     GameServer.logger().info(stringBuilder.toString());
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
/*      */   static void tlogRemoveMounts(String userId, long roleId, int mountsUnlockItemCfgId, int mountsCfgId, long mountsId, long realRemoveMountsId, boolean isRealRemove)
/*      */   {
/* 1330 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1332 */     StringBuilder sbLog = new StringBuilder();
/* 1333 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1334 */     sbLog.append(userId).append('|');
/* 1335 */     sbLog.append(roleId).append('|');
/* 1336 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1338 */     sbLog.append(mountsUnlockItemCfgId).append('|');
/* 1339 */     sbLog.append(mountsCfgId).append('|');
/* 1340 */     sbLog.append(mountsId).append('|');
/* 1341 */     sbLog.append(realRemoveMountsId).append('|');
/* 1342 */     sbLog.append(isRealRemove ? "1" : "0");
/*      */     
/* 1344 */     TLogManager.getInstance().addLog(roleId, "MountsDelete", sbLog.toString());
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\MountsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*      */ package mzm.gsp.award.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.award.AwardBean;
/*      */ import mzm.gsp.award.AwardInfoBean;
/*      */ import mzm.gsp.award.MultiRoleAwardBean;
/*      */ import mzm.gsp.award.RoleInfo;
/*      */ import mzm.gsp.award.SAwardNormalResult;
/*      */ import mzm.gsp.award.SCheckFixAwardInfoRep;
/*      */ import mzm.gsp.award.SItemCarryMaxErr;
/*      */ import mzm.gsp.award.SSendDefaultAwardInfo;
/*      */ import mzm.gsp.award.SSynMultiRoleAwardItemRes;
/*      */ import mzm.gsp.award.STakeSelectAwardRes;
/*      */ import mzm.gsp.award.confbean.AwardCfgConsts;
/*      */ import mzm.gsp.award.confbean.FixItemBean;
/*      */ import mzm.gsp.award.confbean.SAward;
/*      */ import mzm.gsp.award.confbean.SAwardExp;
/*      */ import mzm.gsp.award.confbean.SAwardItem;
/*      */ import mzm.gsp.award.confbean.SAwardMoney;
/*      */ import mzm.gsp.award.confbean.SFixAwardTable;
/*      */ import mzm.gsp.award.confbean.SFixItemTable;
/*      */ import mzm.gsp.award.drop.DropManager;
/*      */ import mzm.gsp.award.event.RoleSelectAward;
/*      */ import mzm.gsp.award.event.RoleSelectAwardArg;
/*      */ import mzm.gsp.award.event.SendAwardProtocolsEvent;
/*      */ import mzm.gsp.award.gem.AwardGemManager;
/*      */ import mzm.gsp.award.watchdog.AwardWatchDogManager;
/*      */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*      */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*      */ import mzm.gsp.gang.main.GangInterface;
/*      */ import mzm.gsp.gang.main.ModBangGongResult;
/*      */ import mzm.gsp.gang.main.ModBangGongResult.ErrorResult;
/*      */ import mzm.gsp.idip.main.IdipManager;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.item.main.ItemOperateResult;
/*      */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mall.main.JifenOperateResult;
/*      */ import mzm.gsp.mall.main.MallInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.pet.main.Pet;
/*      */ import mzm.gsp.pet.main.PetInterface;
/*      */ import mzm.gsp.qingfu.main.PresentResult;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.resourcecheck.main.ResourceCheckInterface;
/*      */ import mzm.gsp.role.main.ModMoneyResult;
/*      */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.server.main.ServerInterface;
/*      */ import mzm.gsp.title.main.TitleInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import mzm.gsp.util.Pair;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Item2CountBean;
/*      */ import xbean.MultiRoleAwardCache;
/*      */ import xbean.MultiRoleAwardContext;
/*      */ import xbean.MultiRoleAwards;
/*      */ import xbean.Pod;
/*      */ import xdb.Procedure;
/*      */ import xio.Protocol;
/*      */ import xtable.Role2multiroleaward;
/*      */ 
/*      */ public class RoleAwardManager
/*      */ {
/*   82 */   private static final Logger logger = Logger.getLogger(RoleAwardManager.class);
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
/*      */   static void calAwardExp(List<Long> roleList, Collection<Long> allRoleList, SAward sAward, int modifileId, long roleId, AwardModel awardModel)
/*      */   {
/*   97 */     double totalRoleExp = 0.0D;
/*   98 */     double totalPetExp = 0.0D;
/*   99 */     double xiulianExp = 0.0D;
/*  100 */     List<SAwardExp> sExpAwards = AwardManager.getExpAwardCfgs(sAward.awardExpId);
/*  101 */     if ((sExpAwards == null) || (sExpAwards.size() == 0))
/*      */     {
/*  103 */       return;
/*      */     }
/*  105 */     SAwardExp awardExp = getExpAward(allRoleList, sAward.awardExpId, sExpAwards, roleId);
/*  106 */     if (awardExp == null)
/*      */     {
/*  108 */       return;
/*      */     }
/*  110 */     totalRoleExp += ExpCalculator.calRoleExp(sAward, awardExp, roleList, allRoleList, roleId, modifileId, awardModel);
/*  111 */     totalPetExp += ExpCalculator.calPetExp(sAward, awardExp, roleList, allRoleList, roleId, modifileId, awardModel);
/*  112 */     xiulianExp += ExpCalculator.calXiulianExp(sAward, awardExp, roleList, allRoleList, roleId, modifileId, awardModel);
/*      */     
/*  114 */     awardModel.getOriginalValue().setRoleExp(awardExp.roleBaseExp);
/*  115 */     awardModel.getOriginalValue().setPetExp(awardExp.petBaseExp);
/*  116 */     awardModel.getOriginalValue().setXiuLianExp(awardExp.practiceExp);
/*      */     
/*  118 */     awardModel.setRoleExp(parseDouble(totalRoleExp));
/*  119 */     awardModel.setPetExp(parseDouble(totalPetExp));
/*  120 */     awardModel.setXiuLianExp(parseDouble(xiulianExp));
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
/*      */   static Map<Long, AwardModel> award(List<String> userList, List<Long> roleList, Collection<Long> allRoleList, int dropId, int modifileId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  133 */     SAward sAward = AwardManager.getAwardCfg(dropId);
/*  134 */     if (sAward == null)
/*      */     {
/*  136 */       return new HashMap();
/*      */     }
/*  138 */     Map<Long, AwardModel> roleAwardMap = new HashMap();
/*      */     
/*  140 */     for (int i = 0; i < roleList.size(); i++)
/*      */     {
/*  142 */       String userId = (String)userList.get(i);
/*  143 */       long roleId = ((Long)roleList.get(i)).longValue();
/*      */       
/*  145 */       AwardModel awardModel = getAwardModel(roleList, allRoleList, dropId, modifileId, sAward, roleId, awardReason);
/*  146 */       if (!giveAward(isSend, awardReason, userId, roleId, activeGet, awardModel))
/*      */       {
/*  148 */         return new HashMap();
/*      */       }
/*  150 */       roleAwardMap.put(Long.valueOf(roleId), awardModel);
/*      */     }
/*  152 */     return roleAwardMap;
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
/*      */   static boolean giveAward(boolean isSend, AwardReason awardReason, String userId, long roleId, boolean activeGet, AwardModel awardModel)
/*      */   {
/*  166 */     if (awardModel == null)
/*      */     {
/*  168 */       return false;
/*      */     }
/*  170 */     boolean ret = doAward(awardModel, userId, roleId, activeGet, awardReason);
/*  171 */     if (!ret)
/*      */     {
/*  173 */       return false;
/*      */     }
/*  175 */     if (isSend)
/*      */     {
/*  177 */       return sendAwardInfo(roleId, awardModel);
/*      */     }
/*  179 */     return true;
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
/*      */   static AwardModel getAwardModel(List<Long> roleList, Collection<Long> allRoleList, int dropId, int modifileId, SAward sAward, long roleId, AwardReason awardReason)
/*      */   {
/*  194 */     AwardModel awardModel = new AwardModel(dropId, AwardModel.AwardType.NORMAL);
/*  195 */     if (!calAllAward(roleId, modifileId, roleList, allRoleList, sAward, awardModel, awardReason))
/*      */     {
/*  197 */       GameServer.logger().error(String.format("[award]RoleAwardManager.getAwardModel@ calAllAward err!|roleId=%d|roleList=%s|allRoleList=%s|dropId=%d|modifileId=%d", new Object[] { Long.valueOf(roleId), roleList.toString(), allRoleList.toString(), Integer.valueOf(dropId), Integer.valueOf(modifileId) }));
/*      */       
/*      */ 
/*      */ 
/*  201 */       return null;
/*      */     }
/*  203 */     return awardModel;
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
/*      */   static AwardModel awardAtTime(int awardId, Map<Long, Integer> awardTimeInfo, String userId, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  230 */     return awardAtTime(Arrays.asList(new Long[] { Long.valueOf(roleId) }), Arrays.asList(new Long[] { Long.valueOf(roleId) }), awardId, -1, userId, roleId, awardReason, awardTimeInfo, isSend, activeGet);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static AwardModel awardAtTime(List<Long> roleList, Collection<Long> allRoleList, int awardId, int modifileId, String userId, long roleId, AwardReason awardReason, Map<Long, Integer> awardTimeInfo, boolean isSend, boolean activeGet)
/*      */   {
/*  238 */     SAward sAward = AwardManager.getAwardCfg(awardId);
/*  239 */     if (sAward == null)
/*      */     {
/*  241 */       return null;
/*      */     }
/*  243 */     AwardModel awardModel = getAwardModelAtTime(roleList, allRoleList, awardId, modifileId, sAward, roleId, awardReason, awardTimeInfo);
/*      */     
/*  245 */     if (awardModel == null)
/*      */     {
/*  247 */       return null;
/*      */     }
/*  249 */     if (!giveAward(isSend, awardReason, userId, roleId, activeGet, awardModel))
/*      */     {
/*  251 */       return null;
/*      */     }
/*  253 */     return awardModel;
/*      */   }
/*      */   
/*      */ 
/*      */   static AwardModel getAwardModelAtTime(List<Long> roleList, Collection<Long> allRoleList, int dropId, int modifileId, SAward sAward, long roleId, AwardReason awardReason, Map<Long, Integer> awardTimeInfo)
/*      */   {
/*  259 */     if ((awardTimeInfo == null) || (awardTimeInfo.size() == 0))
/*      */     {
/*      */ 
/*  262 */       return getAwardModel(roleList, allRoleList, dropId, modifileId, sAward, roleId, awardReason);
/*      */     }
/*      */     
/*  265 */     AwardModel awardModel = new AwardModel(dropId, AwardModel.AwardType.NORMAL);
/*  266 */     for (Map.Entry<Long, Integer> entry : awardTimeInfo.entrySet())
/*      */     {
/*  268 */       int awardCount = ((Integer)entry.getValue()).intValue();
/*  269 */       if (awardCount < 0)
/*      */       {
/*  271 */         GameServer.logger().error(String.format("[award]RoleAwardManager.getAwardModelAtTime@ awardCount err!|roleId=%d|roleList=%s|allRoleList=%s|dropId=%d|modifileId=%d|awardTimeInfo=%s", new Object[] { Long.valueOf(roleId), roleList.toString(), allRoleList.toString(), Integer.valueOf(dropId), Integer.valueOf(modifileId), awardTimeInfo.toString() }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  276 */         return null;
/*      */       }
/*  278 */       if (awardCount != 0)
/*      */       {
/*      */ 
/*      */ 
/*  282 */         awardReason.setAwardTime(((Long)entry.getKey()).longValue());
/*  283 */         for (int count = 0; count < awardCount; count++)
/*      */         {
/*  285 */           awardModel.add(getAwardModel(roleList, allRoleList, dropId, modifileId, sAward, roleId, awardReason)); }
/*      */       }
/*      */     }
/*  288 */     return awardModel;
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
/*      */   static SAwardExp getExpAward(Collection<Long> roleList, int dropId, List<SAwardExp> sAwards, long roleId)
/*      */   {
/*  308 */     SAwardExp retAward = null;
/*  309 */     if ((sAwards == null) || (sAwards.size() == 0))
/*      */     {
/*  311 */       return retAward;
/*      */     }
/*      */     
/*  314 */     int level = getLevel(roleList, roleId, ((SAwardExp)sAwards.get(0)).levelType);
/*  315 */     if (level == 0)
/*      */     {
/*  317 */       if (sAwards.size() > 1)
/*      */       {
/*  319 */         logger.error("怪物等级类型：经验奖励awardId不唯一 dropId=" + dropId);
/*  320 */         return retAward;
/*      */       }
/*      */       
/*      */ 
/*  324 */       return (SAwardExp)sAwards.get(0);
/*      */     }
/*      */     
/*  327 */     for (SAwardExp sAward : sAwards)
/*      */     {
/*  329 */       if ((level >= sAward.levelMin) && (level <= sAward.levelMax))
/*      */       {
/*  331 */         retAward = sAward;
/*  332 */         break;
/*      */       }
/*      */     }
/*      */     
/*  336 */     if (retAward == null)
/*      */     {
/*  338 */       logger.error("没有符合玩家的掉落配置level=" + level + ",经验奖励dropId=" + dropId);
/*  339 */       return retAward;
/*      */     }
/*  341 */     return retAward;
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
/*      */   static SAwardMoney getMoneyAward(Collection<Long> roleList, int dropId, List<SAwardMoney> sAwards, long roleId)
/*      */   {
/*  361 */     SAwardMoney retAward = null;
/*  362 */     if ((sAwards == null) || (sAwards.size() == 0))
/*      */     {
/*  364 */       return retAward;
/*      */     }
/*      */     
/*  367 */     int level = getLevel(roleList, roleId, ((SAwardMoney)sAwards.get(0)).levelType);
/*  368 */     if (level == 0)
/*      */     {
/*  370 */       if (sAwards.size() > 1)
/*      */       {
/*  372 */         logger.error("怪物等级类型：货币奖励awardId不唯一 dropId=" + dropId);
/*  373 */         return retAward;
/*      */       }
/*      */       
/*      */ 
/*  377 */       return (SAwardMoney)sAwards.get(0);
/*      */     }
/*      */     
/*  380 */     for (SAwardMoney sAward : sAwards)
/*      */     {
/*  382 */       if ((level >= sAward.levelMin) && (level <= sAward.levelMax))
/*      */       {
/*  384 */         retAward = sAward;
/*  385 */         break;
/*      */       }
/*      */     }
/*      */     
/*  389 */     if (retAward == null)
/*      */     {
/*  391 */       logger.error("没有符合玩家的掉落配置level=" + level + ",货币奖励dropId=" + dropId);
/*  392 */       return retAward;
/*      */     }
/*  394 */     return retAward;
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
/*      */   static SAwardItem getItemAward(Collection<Long> roleList, int dropId, List<SAwardItem> sAwards, long roleId)
/*      */   {
/*  414 */     SAwardItem retAward = null;
/*  415 */     if ((sAwards == null) || (sAwards.size() == 0))
/*      */     {
/*  417 */       return retAward;
/*      */     }
/*      */     
/*  420 */     int level = getLevel(roleList, roleId, ((SAwardItem)sAwards.get(0)).levelType);
/*  421 */     if (level == 0)
/*      */     {
/*  423 */       if (sAwards.size() > 1)
/*      */       {
/*  425 */         logger.error("怪物等级类型：物品奖励awardId不唯一 dropId=" + dropId);
/*  426 */         return retAward;
/*      */       }
/*      */       
/*      */ 
/*  430 */       return (SAwardItem)sAwards.get(0);
/*      */     }
/*      */     
/*  433 */     for (SAwardItem sAward : sAwards)
/*      */     {
/*  435 */       if ((level >= sAward.levelMin) && (level <= sAward.levelMax))
/*      */       {
/*  437 */         retAward = sAward;
/*  438 */         break;
/*      */       }
/*      */     }
/*      */     
/*  442 */     if (retAward == null)
/*      */     {
/*      */ 
/*  445 */       return retAward;
/*      */     }
/*  447 */     return retAward;
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
/*      */   static Map<Long, AwardModel> award(List<String> userList, List<Long> roleList, Collection<Long> allRoleList, List<Integer> awardIds, Map<Integer, Integer> awardId2ModifileId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  461 */     Map<Long, AwardModel> roleAwardMap = new LinkedHashMap();
/*  462 */     int modifileId = -1;
/*  463 */     for (Iterator i$ = awardIds.iterator(); i$.hasNext();) { int awardId = ((Integer)i$.next()).intValue();
/*      */       
/*  465 */       SAward sAward = AwardManager.getAwardCfg(awardId);
/*  466 */       if (sAward == null)
/*      */       {
/*  468 */         return new HashMap();
/*      */       }
/*  470 */       for (int i = 0; i < roleList.size(); i++)
/*      */       {
/*  472 */         long roleId = ((Long)roleList.get(i)).longValue();
/*  473 */         modifileId = -1;
/*  474 */         if ((awardId2ModifileId != null) && (awardId2ModifileId.containsKey(Integer.valueOf(awardId))))
/*      */         {
/*  476 */           modifileId = ((Integer)awardId2ModifileId.get(Integer.valueOf(awardId))).intValue();
/*      */         }
/*  478 */         AwardModel awardModel = new AwardModel(awardId, AwardModel.AwardType.NORMAL);
/*  479 */         calAllAward(roleId, modifileId, roleList, allRoleList, sAward, awardModel, awardReason);
/*  480 */         if (roleAwardMap.containsKey(Long.valueOf(roleId)))
/*      */         {
/*  482 */           ((AwardModel)roleAwardMap.get(Long.valueOf(roleId))).add(awardModel);
/*      */         }
/*      */         else
/*      */         {
/*  486 */           roleAwardMap.put(Long.valueOf(roleId), awardModel);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  491 */     int index = 0;
/*  492 */     for (Map.Entry<Long, AwardModel> entry : roleAwardMap.entrySet())
/*      */     {
/*  494 */       boolean ret = doAward((AwardModel)entry.getValue(), (String)userList.get(index), ((Long)entry.getKey()).longValue(), activeGet, awardReason);
/*  495 */       if (!ret)
/*      */       {
/*  497 */         return new HashMap();
/*      */       }
/*  499 */       if (isSend)
/*      */       {
/*  501 */         sendAwardInfo(((Long)entry.getKey()).longValue(), (AwardModel)entry.getValue());
/*      */       }
/*  503 */       index++;
/*      */     }
/*  505 */     return roleAwardMap;
/*      */   }
/*      */   
/*      */   static boolean sendAwardInfo(long roleId, AwardModel awardModel)
/*      */   {
/*  510 */     if (awardModel.isZeroState())
/*      */     {
/*  512 */       IdipManager.zeroProfitMsg(roleId);
/*  513 */       return true;
/*      */     }
/*  515 */     SSendDefaultAwardInfo sAwardInfo = new SSendDefaultAwardInfo();
/*  516 */     fillAwardBean(sAwardInfo.awardinfo, awardModel);
/*  517 */     OnlineManager.getInstance().send(roleId, sAwardInfo);
/*  518 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static AwardBean getAwardBean(AwardModel awardModel)
/*      */   {
/*  530 */     if (awardModel == null)
/*      */     {
/*  532 */       return null;
/*      */     }
/*  534 */     AwardBean awardBean = new AwardBean();
/*  535 */     fillAwardBean(awardBean, awardModel);
/*  536 */     return awardBean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillAwardBean(AwardBean awardBean, AwardModel awardModel)
/*      */   {
/*  548 */     if (awardModel == null)
/*      */     {
/*  550 */       return;
/*      */     }
/*      */     
/*  553 */     awardBean.yuanbao = awardModel.getYuanbao();
/*  554 */     awardBean.silver = awardModel.getSilver();
/*  555 */     awardBean.gold = awardModel.getGold();
/*  556 */     awardBean.gang = awardModel.getGang();
/*  557 */     awardBean.goldingot = ((int)awardModel.getGoldIngot());
/*      */     
/*      */ 
/*  560 */     awardBean.roleexp = awardModel.getRoleExp();
/*  561 */     awardBean.petexp = awardModel.getPetExp();
/*  562 */     awardBean.xiulianexp = awardModel.getXiuLianExp();
/*      */     
/*  564 */     if ((awardModel.getItemMap() != null) && (awardModel.getItemMap().size() > 0))
/*      */     {
/*  566 */       awardBean.itemmap.putAll(awardModel.getItemMap());
/*      */     }
/*      */     
/*  569 */     if ((awardModel.getTokenMap() != null) && (awardModel.getTokenMap().size() > 0))
/*      */     {
/*  571 */       awardBean.tokenmap.putAll(awardModel.getTokenMap());
/*      */     }
/*      */     
/*  574 */     HashMap<Integer, mzm.gsp.award.AwardAddBean> awardAddMap = awardModel.getAwardAddMap();
/*  575 */     if ((awardAddMap != null) && (awardAddMap.size() > 0))
/*      */     {
/*  577 */       awardBean.awardaddmap = awardAddMap;
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
/*      */   static AwardModel award(int dropId, String userid, long roleId, int modifileId, List<Long> roleIds, Collection<Long> allRoleList, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  594 */     SAward sAward = AwardManager.getAwardCfg(dropId);
/*  595 */     if (sAward == null)
/*      */     {
/*  597 */       return null;
/*      */     }
/*      */     
/*  600 */     AwardModel awardModel = new AwardModel(dropId, AwardModel.AwardType.NORMAL);
/*  601 */     if (!calAllAward(roleId, modifileId, roleIds, allRoleList, sAward, awardModel, awardReason))
/*      */     {
/*  603 */       GameServer.logger().error(String.format("[award]RoleAwardManager.award@ calAllAward err!|roleId=%d|modifileId=%d|roleIds=%s|allRoleList=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(modifileId), roleIds.toString(), allRoleList.toString() }));
/*      */       
/*      */ 
/*      */ 
/*  607 */       return null;
/*      */     }
/*      */     
/*  610 */     if (doAward(awardModel, userid, roleId, activeGet, awardReason))
/*      */     {
/*  612 */       if (isSend)
/*      */       {
/*  614 */         sendAwardInfo(roleId, awardModel);
/*      */       }
/*  616 */       return awardModel;
/*      */     }
/*  618 */     return null;
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
/*      */   private static boolean calAllAward(long roleId, int modifileId, List<Long> roleIds, Collection<Long> allRoleList, SAward sAward, AwardModel awardModel, AwardReason awardReason)
/*      */   {
/*  634 */     calAwardExp(roleIds, allRoleList, sAward, modifileId, roleId, awardModel);
/*  635 */     awardModel.addItem(calAwardItem(roleIds, allRoleList, sAward, modifileId, roleId, awardModel));
/*  636 */     if (!awardReason.isJustQuery())
/*      */     {
/*  638 */       awardModel.addItem(calGemItem(roleId, sAward.awardId));
/*  639 */       awardModel.addItem(getTimeDropItem(roleId, sAward.globaDropLibId, sAward.awardId, getAwardTime(awardReason)));
/*      */     }
/*  641 */     calAwardMoney(roleIds, allRoleList, sAward, modifileId, roleId, awardModel);
/*  642 */     awardModel.setAppellationId(sAward.appellationId);
/*  643 */     awardModel.setTitleId(sAward.titleId);
/*  644 */     if (!checkYuanBao(roleId, sAward.awardId, AwardModel.AwardType.NORMAL, awardModel.getYuanbao(), awardReason))
/*      */     {
/*  646 */       return false;
/*      */     }
/*  648 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static long getAwardTime(AwardReason awardReason)
/*      */   {
/*  659 */     return awardReason.getAwardTime() > 0L ? awardReason.getAwardTime() : DateTimeUtils.getCurrTimeInMillis();
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
/*      */   private static boolean checkYuanBao(long roleId, int dropId, AwardModel.AwardType awardType, long yuanbaoNum, AwardReason awardReason)
/*      */   {
/*  674 */     if (yuanbaoNum <= 0L)
/*      */     {
/*  676 */       return true;
/*      */     }
/*  678 */     if (awardReason == null)
/*      */     {
/*  680 */       GameServer.logger().error(String.format("[award]RoleAwardManager.calAllAward@ no awardReason!|roleId=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(dropId) }));
/*      */       
/*  682 */       return false;
/*      */     }
/*  684 */     boolean res = false;
/*  685 */     switch (awardType)
/*      */     {
/*      */     case FIX: 
/*  688 */       res = ResourceCheckInterface.canAddBindYuanbaoByFixAward(awardReason.getLogReason(), dropId);
/*  689 */       break;
/*      */     case NORMAL: 
/*  691 */       res = ResourceCheckInterface.canAddBindYuanbaoByAward(awardReason.getLogReason(), dropId);
/*  692 */       break;
/*      */     }
/*      */     
/*      */     
/*      */ 
/*  697 */     if (!res)
/*      */     {
/*  699 */       GameServer.logger().error(String.format("[award]RoleAwardManager.checkYuanBao@ canAddBindYuanbaoByAward error!|roleId=%d|awardId=%d|logReason=%d|type=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(dropId), Integer.valueOf(awardReason.getLogReason().value), awardType.toString() }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  704 */     return res;
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
/*      */   private static Map<Integer, Integer> calGemItem(long roleId, int awardId)
/*      */   {
/*  718 */     Map<Integer, Integer> gemItems = new HashMap();
/*  719 */     gemItems.putAll(AwardGemManager.getGemItemAndCount(roleId, awardId));
/*  720 */     return gemItems;
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
/*      */   private static Map<Integer, Integer> getTimeDropItem(long roleId, int globaDropLibId, int awardId, long awardTime)
/*      */   {
/*  736 */     Map<Integer, Integer> dropItems = new HashMap();
/*  737 */     dropItems.putAll(DropManager.getTimeDropItems(roleId, globaDropLibId, awardId, awardTime));
/*  738 */     return dropItems;
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
/*      */   private static void checkTreasureAndDoAction(long roleId, Map<Integer, Integer> itemMap, TLogArg itemAddReason)
/*      */   {
/*  751 */     Map<Integer, Integer> treasureItemMap = new HashMap();
/*      */     
/*  753 */     Iterator<Map.Entry<Integer, Integer>> it = itemMap.entrySet().iterator();
/*  754 */     while (it.hasNext())
/*      */     {
/*  756 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/*  757 */       int itemId = ((Integer)entry.getKey()).intValue();
/*  758 */       if (ItemBulletinInterface.needBulletin(itemId))
/*      */       {
/*      */ 
/*      */ 
/*  762 */         treasureItemMap.put(Integer.valueOf(itemId), entry.getValue()); }
/*      */     }
/*  764 */     if (treasureItemMap.size() == 0)
/*      */     {
/*  766 */       return;
/*      */     }
/*  768 */     Procedure.execute(new PTreasureHandle(roleId, treasureItemMap, itemAddReason));
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean doAward(AwardModel awardModel, String userId, long roleId, boolean activeGet, AwardReason awardReason)
/*      */   {
/*  774 */     if ((awardModel.getItemMap() != null) && (awardModel.getItemMap().size() > 0))
/*      */     {
/*  776 */       if (activeGet)
/*      */       {
/*  778 */         if (!awardItemInMax(roleId, awardModel, awardReason))
/*      */         {
/*  780 */           if (logger.isDebugEnabled())
/*      */           {
/*  782 */             logger.debug(String.format("[award]RoleAwardManager.doAward@ active get award, add item fail|roleId=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardModel.getAwardId()) }));
/*      */           }
/*      */           
/*      */ 
/*  786 */           return false;
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  791 */         ItemOperateResult addItemResult = ItemInterface.addItem(roleId, awardModel.getItemMap(), awardReason.isAwardItemBind(), awardReason.getTLogArg());
/*      */         
/*  793 */         if ((!addItemResult.success()) && (!addItemResult.isBagFull()))
/*      */         {
/*  795 */           return false;
/*      */         }
/*  797 */         awardModel.addAwardItemId2uuids(addItemResult.getChangedItemId2Uuids());
/*      */       }
/*  799 */       checkTreasureAndDoAction(roleId, awardModel.getItemMap(), awardReason.getTLogArg());
/*      */       
/*  801 */       if (!handleItemDouble(awardModel, roleId))
/*      */       {
/*  803 */         GameServer.logger().error(String.format("[award]RoleAwardManager.doAward@ handleItemDouble fail|roleId=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardModel.getAwardId()) }));
/*      */         
/*      */ 
/*  806 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  810 */     Role role = RoleInterface.getRole(roleId, true);
/*  811 */     if (!role.addExp(awardModel.getRoleExp(), awardReason.getTLogArg(), true))
/*      */     {
/*  813 */       awardModel.setRoleExp(0);
/*      */     }
/*      */     
/*      */ 
/*  817 */     Pet pet = PetInterface.getFightPet(roleId, true);
/*  818 */     if (pet != null)
/*      */     {
/*  820 */       if (pet.addExp(awardModel.getPetExp()) == 0)
/*      */       {
/*  822 */         awardModel.setPetExp(0);
/*      */       }
/*      */       
/*      */     }
/*      */     else {
/*  827 */       awardModel.setPetExp(0);
/*      */     }
/*      */     
/*      */ 
/*  831 */     if (awardModel.getYuanbao() > 0L)
/*      */     {
/*  833 */       if (QingfuInterface.presentYuanbao(userId, roleId, (int)awardModel.getYuanbao(), awardReason.getPresentType(), awardReason.getTLogArg()) != PresentResult.Success)
/*      */       {
/*      */ 
/*  836 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  840 */     if (awardModel.getSilver() > 0L)
/*      */     {
/*  842 */       ModMoneyResult addSRes = RoleInterface.addSilver(roleId, awardModel.getSilver(), awardReason.getTLogArg(), activeGet);
/*      */       
/*  844 */       if (!addSRes.isSucceed())
/*      */       {
/*  846 */         if (addSRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*      */         {
/*  848 */           sendNormalRetAtOnce(roleId, 22, new String[0]);
/*      */         }
/*  850 */         return false;
/*      */       }
/*  852 */       awardModel.setSilver((int)addSRes.getModValue());
/*      */     }
/*      */     
/*  855 */     if (awardModel.getGold() > 0L)
/*      */     {
/*  857 */       ModMoneyResult addGRes = RoleInterface.addGold(roleId, awardModel.getGold(), awardReason.getTLogArg(), activeGet);
/*  858 */       if (!addGRes.isSucceed())
/*      */       {
/*  860 */         if (addGRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*      */         {
/*  862 */           sendNormalRetAtOnce(roleId, 21, new String[0]);
/*      */         }
/*  864 */         return false;
/*      */       }
/*  866 */       awardModel.setGold((int)addGRes.getModValue());
/*      */     }
/*      */     
/*  869 */     if (awardModel.getGoldIngot() > 0L)
/*      */     {
/*  871 */       ModMoneyResult addGRes = RoleInterface.addGoldIngotInAll(roleId, awardModel.getGoldIngot(), awardReason.getTLogArg(), activeGet);
/*      */       
/*  873 */       if (!addGRes.isSucceed())
/*      */       {
/*  875 */         if (addGRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*      */         {
/*  877 */           sendNormalRetAtOnce(roleId, 27, new String[0]);
/*      */         }
/*  879 */         return false;
/*      */       }
/*  881 */       awardModel.setGoldIngot((int)addGRes.getModValue());
/*      */     }
/*      */     
/*      */ 
/*  885 */     if (awardModel.getGang() > 0)
/*      */     {
/*  887 */       if (!addAwardBangGong(awardModel, roleId, activeGet, awardReason))
/*      */       {
/*  889 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  894 */     Iterator<Map.Entry<Integer, Integer>> it = awardModel.getTokenMap().entrySet().iterator();
/*  895 */     while (it.hasNext())
/*      */     {
/*  897 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/*  898 */       int tokenType = ((Integer)entry.getKey()).intValue();
/*  899 */       int num = ((Integer)entry.getValue()).intValue();
/*  900 */       if (num > 0)
/*      */       {
/*      */ 
/*      */ 
/*  904 */         JifenOperateResult res = MallInterface.addJifen(roleId, num, tokenType, !activeGet, awardReason.getTLogArg());
/*  905 */         if (!res.isSuccess())
/*      */         {
/*  907 */           if (res.isToMax())
/*      */           {
/*  909 */             String tokenName = AwardManager.getTokenNameBy(tokenType);
/*  910 */             sendNormalRetAtOnce(roleId, 23, new String[] { tokenName });
/*      */           }
/*  912 */           return false;
/*      */         }
/*  914 */         int addNumLast = (int)res.getChangenum();
/*  915 */         if (addNumLast == 0)
/*      */         {
/*  917 */           it.remove();
/*      */         }
/*  919 */         if (addNumLast != num)
/*      */         {
/*  921 */           entry.setValue(Integer.valueOf(addNumLast));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  926 */     if (awardModel.getAppellationId() > 0)
/*      */     {
/*  928 */       TitleInterface.addAppellation(roleId, awardModel.getAppellationId());
/*      */     }
/*      */     
/*  931 */     if (awardModel.getTitleId() > 0)
/*      */     {
/*  933 */       TitleInterface.addTitle(roleId, awardModel.getTitleId());
/*      */     }
/*      */     
/*      */ 
/*  937 */     if (awardModel.getXiuLianExp() > 0)
/*      */     {
/*  939 */       XiuLianSkillInterface.addXiuLianExp(roleId, awardModel.getXiuLianExp(), awardReason.getTLogArg());
/*      */     }
/*      */     
/*      */ 
/*  943 */     AwardWatchDogManager.addRoleTotalAward(roleId, awardModel);
/*      */     
/*  945 */     addExtroExpAward(awardModel, roleId);
/*      */     
/*  947 */     if ((awardModel.getNeedSendProtocols() != null) && (awardModel.getNeedSendProtocols().size() > 0))
/*      */     {
/*  949 */       TriggerEventsManger.getInstance().triggerEvent(new SendAwardProtocolsEvent(), new NeedSendProtocolsArg(roleId, awardModel));
/*      */     }
/*      */     
/*  952 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean addAwardBangGong(AwardModel awardModel, long roleId, boolean activeGet, AwardReason awardReason)
/*      */   {
/*  957 */     ModBangGongResult res = awardBangGong(roleId, awardModel.getGang(), awardReason.getTLogArg(), activeGet);
/*  958 */     if (res.isSucceed())
/*      */     {
/*  960 */       return true;
/*      */     }
/*  962 */     ModBangGongResult.ErrorResult gangRes = res.getRes();
/*  963 */     if (gangRes == ModBangGongResult.ErrorResult.ERROR_BANGGONG_NOT_IN_GANG)
/*      */     {
/*  965 */       if (!activeGet)
/*      */       {
/*      */ 
/*  968 */         return true;
/*      */       }
/*      */       
/*  971 */       sendNormalRetAtOnce(roleId, 30, new String[0]);
/*      */     }
/*  973 */     if (gangRes == ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT)
/*      */     {
/*  975 */       if (!activeGet)
/*      */       {
/*      */ 
/*  978 */         return true;
/*      */       }
/*  980 */       sendNormalRetAtOnce(roleId, 23, new String[] { AwardManager.getMoneyNameBy(4) });
/*      */     }
/*      */     
/*  983 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean handleItemDouble(AwardModel awardModel, long roleId)
/*      */   {
/*  995 */     if (!awardModel.isItemDoubleAward())
/*      */     {
/*  997 */       return true;
/*      */     }
/*  999 */     Pair<Boolean, Protocol> pair = ItemInterface.triggerDoubleItemAward(roleId, awardModel.getItemMap());
/* 1000 */     if (!((Boolean)pair.first).booleanValue())
/*      */     {
/* 1002 */       logger.debug(String.format("[award]RoleAwardManager.doAward@ get double award err!|roleId=%d|awardId=%d|awardItems=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardModel.getAwardId()), awardModel.getItemMap() }));
/*      */       
/*      */ 
/* 1005 */       return false;
/*      */     }
/* 1007 */     if (pair.second == null)
/*      */     {
/* 1009 */       return true;
/*      */     }
/* 1011 */     awardModel.addNeedSendProtocols(Arrays.asList(new Protocol[] { (Protocol)pair.second }));
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
/*      */   private static void addExtroExpAward(AwardModel awardModel, long roleId)
/*      */   {
/* 1025 */     if (awardModel.getRoleExp() <= 0)
/*      */     {
/* 1027 */       return;
/*      */     }
/* 1029 */     List<Protocol> needSendProtocols = awardExroExp(roleId, awardModel.getRoleExp());
/* 1030 */     if ((needSendProtocols == null) || (needSendProtocols.size() == 0))
/*      */     {
/* 1032 */       return;
/*      */     }
/* 1034 */     awardModel.addNeedSendProtocols(needSendProtocols);
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
/*      */   static List<Protocol> awardExroExp(long roleId, int addExp)
/*      */   {
/* 1050 */     if (addExp <= 0)
/*      */     {
/* 1052 */       return null;
/*      */     }
/* 1054 */     List<Protocol> protocolList = ItemInterface.afterAwardRoleExp(roleId, addExp);
/* 1055 */     return protocolList;
/*      */   }
/*      */   
/*      */   static boolean awardItemInMax(long roleId, AwardModel awardModel, AwardReason awardReason)
/*      */   {
/* 1060 */     ItemOperateResult res = ItemInterface.addItemCheckCarrymax(roleId, awardModel.getItemMap(), awardReason.isAwardItemBind(), awardReason.getTLogArg());
/*      */     
/* 1062 */     if (res.success())
/*      */     {
/* 1064 */       awardModel.addAwardItemId2uuids(res.getChangedItemId2Uuids());
/* 1065 */       return true;
/*      */     }
/* 1067 */     if (res.isBagFull())
/*      */     {
/* 1069 */       sendNormalRetAtOnce(roleId, 24, new String[] { String.valueOf(res.getFullBagId()) });
/*      */     }
/* 1071 */     if (res.isToCarryMax())
/*      */     {
/* 1073 */       SItemCarryMaxErr errPro = new SItemCarryMaxErr();
/* 1074 */       errPro.itemid = res.getTocarrymaxitemid();
/* 1075 */       OnlineManager.getInstance().sendAtOnce(roleId, errPro);
/*      */     }
/* 1077 */     return false;
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
/*      */   private static ModBangGongResult awardBangGong(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*      */   {
/* 1091 */     if (withinMax)
/*      */     {
/* 1093 */       return GangInterface.addBangGongWithinMax(roleId, addValue, arg);
/*      */     }
/* 1095 */     return GangInterface.addBangGong(roleId, addValue, arg);
/*      */   }
/*      */   
/*      */   static int parseDouble(double value)
/*      */   {
/* 1100 */     int ret = 0;
/* 1101 */     if (value > 2.147483647E9D)
/*      */     {
/* 1103 */       ret = Integer.MAX_VALUE;
/*      */     }
/*      */     else
/*      */     {
/* 1107 */       ret = (int)value;
/*      */     }
/* 1109 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */   static void calAwardMoney(List<Long> roleList, Collection<Long> allRoleList, SAward sAward, int modifileId, long roleId, AwardModel awardModel)
/*      */   {
/* 1115 */     int moneyAwardId = sAward.awardMoneyId;
/* 1116 */     List<SAwardMoney> sMoneyAwards = AwardManager.getMoneyAwardCfgs(moneyAwardId);
/* 1117 */     if ((sMoneyAwards == null) || (sMoneyAwards.size() == 0))
/*      */     {
/* 1119 */       return;
/*      */     }
/* 1121 */     SAwardMoney moneyAward = getMoneyAward(allRoleList, moneyAwardId, sMoneyAwards, roleId);
/* 1122 */     if (moneyAward == null)
/*      */     {
/* 1124 */       return;
/*      */     }
/* 1126 */     AwardAddRet awardAddRet = MoneyCalculator.getMoneyAddParam(roleList, allRoleList, roleId, sAward.addModifyCnfId);
/* 1127 */     AwardModRet awardModRet = MoneyCalculator.getMoneyModifileParam(roleList, allRoleList, roleId, modifileId);
/* 1128 */     fillMoney(sAward, roleId, awardModel, moneyAward.id, awardAddRet, awardModRet);
/* 1129 */     fillToken(sAward, roleId, awardModel, moneyAward, awardAddRet, awardModRet);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fillToken(SAward sAward, long roleId, AwardModel awardModel, SAwardMoney moneyAward, AwardAddRet awardAddRet, AwardModRet awardModRet)
/*      */   {
/* 1136 */     Map<Integer, Integer> tokenMap = new HashMap();
/* 1137 */     calTokenMap(sAward, roleId, moneyAward.id, tokenMap, awardAddRet, awardModRet, awardModel);
/* 1138 */     awardModel.getTokenMap().putAll(tokenMap);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fillMoney(SAward sAward, long roleId, AwardModel awardModel, int sAwardMoneyId, AwardAddRet awardAddRet, AwardModRet awardModRet)
/*      */   {
/* 1144 */     double gold = AwardManager.getMoneyNumByType(sAwardMoneyId, 2);
/* 1145 */     double silver = AwardManager.getMoneyNumByType(sAwardMoneyId, 3);
/* 1146 */     double yuanBao = AwardManager.getMoneyNumByType(sAwardMoneyId, 1);
/* 1147 */     double gang = AwardManager.getMoneyNumByType(sAwardMoneyId, 4);
/* 1148 */     double goldIngot = AwardManager.getMoneyNumByType(sAwardMoneyId, 5);
/*      */     
/* 1150 */     yuanBao = calMoney(roleId, 4, yuanBao, 8, sAward, awardAddRet.getYuanbaoRet(), awardModRet.getYuanbaoRet(), awardModel);
/*      */     
/* 1152 */     gold = calMoney(roleId, 5, gold, 16, sAward, awardAddRet.getGoldRet(), awardModRet.getGoldRet(), awardModel);
/*      */     
/* 1154 */     silver = calMoney(roleId, 6, silver, 32, sAward, awardAddRet.getSilverRet(), awardModRet.getSilverRet(), awardModel);
/*      */     
/* 1156 */     gang = calMoney(roleId, 7, gang, 64, sAward, awardAddRet.getGangRet(), awardModRet.getGangRet(), awardModel);
/*      */     
/* 1158 */     goldIngot = calMoney(roleId, 13, goldIngot, 16, sAward, awardAddRet.getGoldIngotRet(), awardModRet.getGoldIngotRet(), awardModel);
/*      */     
/* 1160 */     awardModel.setYuanBao(parseDouble(yuanBao));
/* 1161 */     awardModel.setGold(parseDouble(gold));
/* 1162 */     awardModel.setSilver(parseDouble(silver));
/* 1163 */     awardModel.setGang(parseDouble(gang));
/* 1164 */     awardModel.setGoldIngot(parseDouble(goldIngot));
/*      */   }
/*      */   
/*      */ 
/*      */   private static void calTokenMap(SAward sAward, long roleId, int sAwardMoneyId, Map<Integer, Integer> tokenMap, AwardAddRet awardAddRet, AwardModRet awardModRet, AwardModel awardModel)
/*      */   {
/* 1170 */     double xiayi = AwardManager.getTokenNumByType(sAwardMoneyId, 1);
/* 1171 */     double shimen = AwardManager.getTokenNumByType(sAwardMoneyId, 3);
/* 1172 */     double jifen = AwardManager.getTokenNumByType(sAwardMoneyId, 2);
/* 1173 */     double shengwang = AwardManager.getTokenNumByType(sAwardMoneyId, 4);
/* 1174 */     double ladderScore = AwardManager.getTokenNumByType(sAwardMoneyId, 5);
/* 1175 */     double xhkpPoint = AwardManager.getTokenNumByType(sAwardMoneyId, 8);
/* 1176 */     double cardEssence = AwardManager.getTokenNumByType(sAwardMoneyId, 9);
/* 1177 */     double cardScore = AwardManager.getTokenNumByType(sAwardMoneyId, 10);
/* 1178 */     double backGameActivityPoint = AwardManager.getTokenNumByType(sAwardMoneyId, 11);
/* 1179 */     double singleBattlePoint = AwardManager.getTokenNumByType(sAwardMoneyId, 6);
/* 1180 */     double xhkpCompensatePoint = AwardManager.getTokenNumByType(sAwardMoneyId, 12);
/* 1181 */     double bandstandScore = AwardManager.getTokenNumByType(sAwardMoneyId, 13);
/* 1182 */     double petFightScore = AwardManager.getTokenNumByType(sAwardMoneyId, 14);
/* 1183 */     double petMarkScore1 = AwardManager.getTokenNumByType(sAwardMoneyId, 15);
/* 1184 */     double petMarkScore2 = AwardManager.getTokenNumByType(sAwardMoneyId, 16);
/* 1185 */     double drawCarnivalPoint = AwardManager.getTokenNumByType(sAwardMoneyId, 17);
/*      */     
/* 1187 */     xiayi = calMoney(roleId, 8, xiayi, 128, sAward, awardAddRet.getXiayiRet(), awardModRet.getXiayiRet(), awardModel);
/*      */     
/* 1189 */     shimen = calMoney(roleId, 10, shimen, 1024, sAward, awardAddRet.getShimenRet(), awardModRet.getShimenRet(), awardModel);
/*      */     
/* 1191 */     jifen = calMoney(roleId, 9, jifen, 256, sAward, awardAddRet.getJifenRet(), awardModRet.getJifenRet(), awardModel);
/*      */     
/* 1193 */     shengwang = calMoney(roleId, 11, shengwang, 512, sAward, awardAddRet.getShengwangRet(), awardModRet.getShengwangRet(), awardModel);
/*      */     
/* 1195 */     ladderScore = calMoney(roleId, 11, ladderScore, 512, sAward, awardAddRet.getLadderScoreRet(), awardModRet.getLadderScoreRet(), awardModel);
/*      */     
/* 1197 */     xhkpPoint = calMoney(roleId, 16, xhkpPoint, 8192, sAward, awardAddRet.getXhkpPointRet(), awardModRet.getXhkpPointRet(), awardModel);
/*      */     
/*      */ 
/* 1200 */     cardEssence = calMoney(roleId, 17, cardEssence, 16384, sAward, awardAddRet.getCardEssenceRet(), awardModRet.getCardEssenceRet(), awardModel);
/*      */     
/*      */ 
/* 1203 */     cardScore = calMoney(roleId, 18, cardScore, 32768, sAward, awardAddRet.getCardScoreRet(), awardModRet.getCardScoreRet(), awardModel);
/*      */     
/*      */ 
/* 1206 */     backGameActivityPoint = calMoney(roleId, 19, backGameActivityPoint, 65536, sAward, awardAddRet.getBackGameActivityPointRet(), awardModRet.getBackGameActivityPointRet(), awardModel);
/*      */     
/*      */ 
/* 1209 */     singleBattlePoint = calMoney(roleId, 10, singleBattlePoint, 1024, sAward, awardAddRet.getSingleBattlePointRet(), awardModRet.getSingleBattlePointRet(), awardModel);
/*      */     
/* 1211 */     xhkpCompensatePoint = calMoney(roleId, 20, xhkpCompensatePoint, 131072, sAward, awardAddRet.getXhkpCompensatePointRet(), awardModRet.getXhkpCompensatePointRet(), awardModel);
/*      */     
/*      */ 
/* 1214 */     bandstandScore = calMoney(roleId, 21, bandstandScore, 262144, sAward, awardAddRet.getBandstandScoreRet(), awardModRet.getBandstandScoreRet(), awardModel);
/*      */     
/*      */ 
/* 1217 */     petFightScore = calMoney(roleId, 22, petFightScore, 524288, sAward, awardAddRet.getPetFightScore(), awardModRet.getPetFightScore(), awardModel);
/*      */     
/*      */ 
/* 1220 */     petMarkScore1 = calMoney(roleId, 23, petMarkScore1, 1048576, sAward, awardAddRet.getPetMarkScore1(), awardModRet.getPetMarkScore1(), awardModel);
/*      */     
/*      */ 
/* 1223 */     petMarkScore2 = calMoney(roleId, 24, petMarkScore2, 2097152, sAward, awardAddRet.getPetMarkScore2(), awardModRet.getPetMarkScore2(), awardModel);
/*      */     
/*      */ 
/*      */ 
/* 1227 */     drawCarnivalPoint = calMoney(roleId, 25, drawCarnivalPoint, 4194304, sAward, awardAddRet.getDrawCarnivalPointRet(), awardModRet.getDrawCarnivalPointRet(), awardModel);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1232 */     if (xiayi > 0.0D)
/*      */     {
/* 1234 */       tokenMap.put(Integer.valueOf(1), Integer.valueOf((int)Math.floor(xiayi)));
/*      */     }
/* 1236 */     if (shimen > 0.0D)
/*      */     {
/* 1238 */       tokenMap.put(Integer.valueOf(3), Integer.valueOf((int)Math.floor(shimen)));
/*      */     }
/* 1240 */     if (jifen > 0.0D)
/*      */     {
/* 1242 */       tokenMap.put(Integer.valueOf(2), Integer.valueOf((int)Math.floor(jifen)));
/*      */     }
/* 1244 */     if (shengwang > 0.0D)
/*      */     {
/* 1246 */       tokenMap.put(Integer.valueOf(4), Integer.valueOf((int)Math.floor(shengwang)));
/*      */     }
/* 1248 */     if (ladderScore > 0.0D)
/*      */     {
/* 1250 */       tokenMap.put(Integer.valueOf(5), Integer.valueOf((int)Math.floor(ladderScore)));
/*      */     }
/* 1252 */     if (xhkpPoint > 0.0D)
/*      */     {
/* 1254 */       tokenMap.put(Integer.valueOf(8), Integer.valueOf((int)Math.floor(xhkpPoint)));
/*      */     }
/* 1256 */     if (cardEssence > 0.0D)
/*      */     {
/* 1258 */       tokenMap.put(Integer.valueOf(9), Integer.valueOf((int)Math.floor(cardEssence)));
/*      */     }
/* 1260 */     if (cardScore > 0.0D)
/*      */     {
/* 1262 */       tokenMap.put(Integer.valueOf(10), Integer.valueOf((int)Math.floor(cardScore)));
/*      */     }
/* 1264 */     if (backGameActivityPoint > 0.0D)
/*      */     {
/* 1266 */       tokenMap.put(Integer.valueOf(11), Integer.valueOf((int)Math.floor(backGameActivityPoint)));
/*      */     }
/* 1268 */     if (singleBattlePoint > 0.0D)
/*      */     {
/* 1270 */       tokenMap.put(Integer.valueOf(6), Integer.valueOf((int)Math.floor(singleBattlePoint)));
/*      */     }
/* 1272 */     if (xhkpCompensatePoint > 0.0D)
/*      */     {
/* 1274 */       tokenMap.put(Integer.valueOf(12), Integer.valueOf((int)Math.floor(xhkpCompensatePoint)));
/*      */     }
/* 1276 */     if (bandstandScore > 0.0D)
/*      */     {
/* 1278 */       tokenMap.put(Integer.valueOf(13), Integer.valueOf((int)Math.floor(bandstandScore)));
/*      */     }
/* 1280 */     if (petFightScore > 0.0D)
/*      */     {
/* 1282 */       tokenMap.put(Integer.valueOf(14), Integer.valueOf((int)Math.floor(petFightScore)));
/*      */     }
/* 1284 */     if (petMarkScore1 > 0.0D)
/*      */     {
/* 1286 */       tokenMap.put(Integer.valueOf(15), Integer.valueOf((int)Math.floor(petMarkScore1)));
/*      */     }
/* 1288 */     if (petMarkScore2 > 0.0D)
/*      */     {
/* 1290 */       tokenMap.put(Integer.valueOf(16), Integer.valueOf((int)Math.floor(petMarkScore2)));
/*      */     }
/* 1292 */     if (drawCarnivalPoint > 0.0D)
/*      */     {
/* 1294 */       tokenMap.put(Integer.valueOf(17), Integer.valueOf((int)Math.floor(drawCarnivalPoint)));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static double calMoney(long roleId, int awardType, double baseValue, int buffNeedType, SAward sAward, double awardAddRet, double awardModRet, AwardModel awardModel)
/*      */   {
/* 1301 */     if (baseValue <= 0.0D)
/*      */     {
/* 1303 */       return 0.0D;
/*      */     }
/* 1305 */     AwardAddParam addParam = new AwardAddParam();
/* 1306 */     addParam.addAllAddParam(awardAddRet);
/* 1307 */     if (!PBuffEffect.calBuffAdd(sAward.addModifyCnfId, roleId, addParam, awardType, buffNeedType))
/*      */     {
/* 1309 */       awardModel.setZeroState(true);
/* 1310 */       return 0.0D;
/*      */     }
/*      */     
/* 1313 */     recordSilver(awardType, awardModel, baseValue, awardModRet, addParam);
/*      */     
/* 1315 */     double value = MoneyCalculator.calMoney(baseValue, addParam.getAllAddParam(), awardModRet);
/* 1316 */     return value;
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
/*      */   private static void recordSilver(int awardType, AwardModel awardModel, double baseValue, double awardModRet, AwardAddParam addParam)
/*      */   {
/* 1331 */     if (awardType != 6)
/*      */     {
/* 1333 */       return;
/*      */     }
/* 1335 */     for (Map.Entry<Integer, Double> entry : addParam.getAddType2Num().entrySet())
/*      */     {
/* 1337 */       double addValue = calAddValue(baseValue, ((Double)entry.getValue()).doubleValue(), awardModRet);
/* 1338 */       if (addValue >= 1.0D)
/*      */       {
/* 1340 */         awardModel.addAwardAddNum(10, ((Integer)entry.getKey()).intValue(), addValue);
/*      */       }
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
/*      */   private static double calAddValue(double base, double addParam, double modParam)
/*      */   {
/* 1359 */     double ret = 0.0D;
/* 1360 */     ret = base * addParam * modParam;
/* 1361 */     return ret;
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
/*      */   static List<Integer> calAwardItem(List<Long> roleList, Collection<Long> allRoleList, SAward sAward, int modifileId, long roleId, AwardModel awardModel)
/*      */   {
/* 1382 */     List<Integer> items = ItemCalculator.calItem(roleList, allRoleList, sAward, roleId, modifileId, awardModel);
/* 1383 */     return items;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getServerLevel()
/*      */   {
/* 1395 */     return ServerInterface.getCurrentServerLevel();
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
/*      */   static int getLevel(Collection<Long> roleList, long roleId, int levelType)
/*      */   {
/* 1410 */     switch (levelType)
/*      */     {
/*      */     case 1: 
/* 1413 */       return RoleInterface.getLevel(roleId);
/*      */     case 2: 
/* 1415 */       int toalLevel = 0;
/* 1416 */       for (Long teamerRoleId : roleList)
/*      */       {
/* 1418 */         toalLevel += RoleInterface.getLevel(teamerRoleId.longValue());
/*      */       }
/* 1420 */       return toalLevel / roleList.size();
/*      */     
/*      */     case 3: 
/* 1423 */       return 0;
/*      */     }
/*      */     
/* 1426 */     return RoleInterface.getLevel(roleId);
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
/*      */   static AwardModel awardFixAward(int fixAwardId, String userid, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/* 1440 */     AwardModel awardModel = getRoleFixAwardModel(fixAwardId, roleId, awardReason);
/*      */     
/* 1442 */     if (awardModel == null)
/*      */     {
/* 1444 */       GameServer.logger().error(String.format("[award]RoleAwardManager.awardFixAward@ getRoleFixAwardModel err!|fixAwardId=%d|roleId=%d", new Object[] { Integer.valueOf(fixAwardId), Long.valueOf(roleId) }));
/*      */       
/*      */ 
/* 1447 */       return null;
/*      */     }
/* 1449 */     boolean ret = doAward(awardModel, userid, roleId, activeGet, awardReason);
/* 1450 */     if (!ret)
/*      */     {
/* 1452 */       GameServer.logger().error(String.format("[award]RoleAwardManager.awardFixAward@ doAward err!|fixAwardId=%d|roleId=%d", new Object[] { Integer.valueOf(fixAwardId), Long.valueOf(roleId) }));
/*      */       
/*      */ 
/* 1455 */       return null;
/*      */     }
/* 1457 */     if (isSend)
/*      */     {
/* 1459 */       sendAwardInfo(roleId, awardModel);
/*      */     }
/* 1461 */     return awardModel;
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
/*      */   static AwardModel awardFixAwardNTime(int fixAwardId, int awardTime, String userid, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/* 1479 */     if (awardTime <= 0)
/*      */     {
/* 1481 */       return null;
/*      */     }
/* 1483 */     AwardModel awardModel = getRoleFixAwardModel(fixAwardId, roleId, awardReason);
/* 1484 */     if (awardModel == null)
/*      */     {
/* 1486 */       GameServer.logger().error(String.format("[award]RoleAwardManager.awardFixAwardNTime@ getRoleFixAwardModel err!|fixAwardId=%d|roleId=%d", new Object[] { Integer.valueOf(fixAwardId), Long.valueOf(roleId) }));
/*      */       
/*      */ 
/*      */ 
/* 1490 */       return null;
/*      */     }
/* 1492 */     AwardModel totalModel = new AwardModel(awardModel.getAwardId(), AwardModel.AwardType.FIX);
/*      */     
/* 1494 */     for (int i = 0; i < awardTime; i++)
/*      */     {
/* 1496 */       totalModel.add(awardModel);
/*      */     }
/* 1498 */     boolean ret = doAward(totalModel, userid, roleId, activeGet, awardReason);
/* 1499 */     if (!ret)
/*      */     {
/* 1501 */       GameServer.logger().error(String.format("[award]RoleAwardManager.awardFixAwardNTime@ doAward err!|fixAwardId=%d|roleId=%d", new Object[] { Integer.valueOf(fixAwardId), Long.valueOf(roleId) }));
/*      */       
/*      */ 
/* 1504 */       return null;
/*      */     }
/* 1506 */     if (isSend)
/*      */     {
/* 1508 */       sendAwardInfo(roleId, totalModel);
/*      */     }
/* 1510 */     return totalModel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static AwardModel getRoleFixAwardModel(int fixAwardId, long roleId, AwardReason awardReason)
/*      */   {
/* 1522 */     AwardModel awardModel = getFixAwardModel(fixAwardId, roleId, awardReason);
/* 1523 */     return awardModel;
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
/*      */   static AwardModel getFixAwardModel(int fixAwardId, long roleId, AwardReason awardReason)
/*      */   {
/* 1536 */     SFixAwardTable sFixAwardTable = getFixAwardCfg(fixAwardId, roleId);
/* 1537 */     if (sFixAwardTable == null)
/*      */     {
/* 1539 */       logger.error(String.format("[award]RoleAwardManager.getFixAwardModel@no fixAwardCfg!|roleId=%d|fixAwardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(fixAwardId) }));
/*      */       
/* 1541 */       return null;
/*      */     }
/* 1543 */     AwardModel awardModel = new AwardModel(sFixAwardTable.id, AwardModel.AwardType.FIX);
/* 1544 */     awardModel.setAddEffectId(sFixAwardTable.addModifyCnfId);
/*      */     
/* 1546 */     int awardExpId = sFixAwardTable.expAwardId;
/* 1547 */     List<SAwardExp> sAwardExps = AwardManager.getExpAwardCfgs(awardExpId);
/* 1548 */     if ((sAwardExps != null) && (sAwardExps.size() > 0))
/*      */     {
/* 1550 */       SAwardExp sAwardExp = getExpAward(Arrays.asList(new Long[] { Long.valueOf(roleId) }), awardExpId, sAwardExps, roleId);
/* 1551 */       if (sAwardExp != null)
/*      */       {
/* 1553 */         calFixAwardExp(roleId, sAwardExp, awardModel);
/*      */       }
/*      */     }
/*      */     
/* 1557 */     int awardMoneyId = sFixAwardTable.moneyAwardId;
/* 1558 */     List<SAwardMoney> sAwardMoneys = AwardManager.getMoneyAwardCfgs(awardMoneyId);
/* 1559 */     if ((sAwardMoneys != null) && (sAwardMoneys.size() > 0))
/*      */     {
/* 1561 */       SAwardMoney sAwardMoney = getMoneyAward(Arrays.asList(new Long[] { Long.valueOf(roleId) }), awardMoneyId, sAwardMoneys, roleId);
/* 1562 */       if (sAwardMoney != null)
/*      */       {
/* 1564 */         calFixAwardCurrency(roleId, sAwardMoney.id, awardModel);
/*      */       }
/*      */     }
/*      */     
/* 1568 */     int fixItemId = sFixAwardTable.fixItemId;
/* 1569 */     SFixItemTable fixItemTable = SFixItemTable.get(fixItemId);
/* 1570 */     if (fixItemTable != null)
/*      */     {
/* 1572 */       calFixAwardItem(roleId, fixItemTable, awardModel);
/*      */     }
/* 1574 */     awardModel.setAppellationId(sFixAwardTable.appellationId);
/* 1575 */     awardModel.setTitleId(sFixAwardTable.titleId);
/* 1576 */     if (!checkYuanBao(roleId, fixAwardId, AwardModel.AwardType.FIX, awardModel.getYuanbao(), awardReason))
/*      */     {
/* 1578 */       GameServer.logger().error(String.format("[award]RoleAwardManager.getFixAwardModel@checkYuanBao err!|roleId=%d|dropId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(fixAwardId) }));
/*      */       
/*      */ 
/* 1581 */       return null;
/*      */     }
/* 1583 */     return awardModel;
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
/*      */   static List<Integer> getFixAwardItems(long roleId, int fixAwardId)
/*      */   {
/* 1599 */     SFixAwardTable sFixAwardTable = getFixAwardCfg(fixAwardId, roleId);
/* 1600 */     if (sFixAwardTable == null)
/*      */     {
/* 1602 */       return new ArrayList();
/*      */     }
/* 1604 */     return getFixAwardItems(sFixAwardTable.fixItemId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<Integer> getFixAwardItems(int fixItemId)
/*      */   {
/* 1616 */     SFixItemTable fixItemTable = SFixItemTable.get(fixItemId);
/* 1617 */     if (fixItemTable == null)
/*      */     {
/* 1619 */       return new ArrayList();
/*      */     }
/* 1621 */     Set<Integer> items = new java.util.HashSet();
/* 1622 */     for (FixItemBean fixItemBean : fixItemTable.itemList)
/*      */     {
/* 1624 */       items.add(Integer.valueOf(fixItemBean.itemId));
/*      */     }
/* 1626 */     return new ArrayList(items);
/*      */   }
/*      */   
/*      */   static boolean onCheckFixAwardInfoReq(long roleId, int fixAwardId, int itemIndex, AwardReason awardReason)
/*      */   {
/* 1631 */     AwardModel awardModel = getFixAwardModel(fixAwardId, roleId, awardReason);
/* 1632 */     if (awardModel == null)
/*      */     {
/* 1634 */       GameServer.logger().error(String.format("[award]RoleAwardManager.onCheckFixAwardInfoReq@getFixAwardModel err!|roleId=%d|fixAwardId=%d|itemIndex=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(fixAwardId), Integer.valueOf(itemIndex) }));
/*      */       
/*      */ 
/*      */ 
/* 1638 */       return false;
/*      */     }
/* 1640 */     SCheckFixAwardInfoRep sCheckFixAwardInfoRep = new SCheckFixAwardInfoRep();
/*      */     
/*      */ 
/* 1643 */     sCheckFixAwardInfoRep.itemmap.putAll(awardModel.getItemMap());
/*      */     
/* 1645 */     awardModel.fillAllCurrencyBeans(sCheckFixAwardInfoRep.moneyvalue);
/*      */     
/* 1647 */     awardModel.fillAllExpBeans(sCheckFixAwardInfoRep.expvalue);
/*      */     
/*      */ 
/* 1650 */     sCheckFixAwardInfoRep.appellationid = awardModel.getAppellationId();
/* 1651 */     sCheckFixAwardInfoRep.titleid = awardModel.getTitleId();
/*      */     
/*      */ 
/* 1654 */     sCheckFixAwardInfoRep.itemindex = itemIndex;
/* 1655 */     OnlineManager.getInstance().send(roleId, sCheckFixAwardInfoRep);
/* 1656 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean fillAwardInfoBean(AwardModel awardModel, AwardInfoBean awardInfoBean)
/*      */   {
/* 1668 */     if (awardInfoBean == null)
/*      */     {
/* 1670 */       return false;
/*      */     }
/*      */     
/* 1673 */     awardModel.fillAllCurrencyBeans(awardInfoBean.moneybeans);
/*      */     
/* 1675 */     awardModel.fillAllExpBeans(awardInfoBean.expbeans);
/*      */     
/* 1677 */     awardInfoBean.itemmap.putAll(awardModel.getItemMap());
/*      */     
/* 1679 */     awardInfoBean.appellationid = awardModel.getAppellationId();
/* 1680 */     awardInfoBean.titleid = awardModel.getTitleId();
/* 1681 */     return true;
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
/*      */   static SFixAwardTable getFixAwardCfg(int fixAwardId, long roleId)
/*      */   {
/* 1695 */     int occupationId = RoleInterface.getOccupationId(roleId);
/* 1696 */     int gender = RoleInterface.getGender(roleId);
/* 1697 */     return AwardManager.getFixAwardCfg(fixAwardId, occupationId, gender);
/*      */   }
/*      */   
/*      */   private static void calFixAwardExp(long roleId, SAwardExp sAwardExp, AwardModel awardModel)
/*      */   {
/* 1702 */     awardModel.setRoleExp(calFixAward(roleId, sAwardExp.roleBaseExp, 1, 1, awardModel));
/*      */     
/* 1704 */     awardModel.setPetExp(calFixAward(roleId, sAwardExp.petBaseExp, 2, 2, awardModel));
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
/*      */   static int calFixAward(long roleId, int baseValue, int awardType, int buffNeedType, AwardModel awardModel)
/*      */   {
/* 1719 */     if (baseValue == 0)
/*      */     {
/* 1721 */       return 0;
/*      */     }
/* 1723 */     AwardAddParam addParam = new AwardAddParam();
/* 1724 */     if (!PBuffEffect.calBuffAdd(awardModel.getAddEffectId(), roleId, addParam, awardType, buffNeedType))
/*      */     {
/* 1726 */       awardModel.setZeroState(true);
/* 1727 */       return 0;
/*      */     }
/* 1729 */     return getFixAwardNum(baseValue, addParam.getAllAddParam());
/*      */   }
/*      */   
/*      */   static int getFixAwardNum(int baseValue, double addRate)
/*      */   {
/* 1734 */     return parseDouble(baseValue * (1.0D + addRate));
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
/*      */   private static void calFixAwardCurrency(long roleId, int sAwardMoneyId, AwardModel awardModel)
/*      */   {
/* 1747 */     calFixMoney(roleId, sAwardMoneyId, awardModel);
/* 1748 */     calFixTokenMap(roleId, sAwardMoneyId, awardModel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void calFixMoney(long roleId, int sAwardMoneyId, AwardModel awardModel)
/*      */   {
/* 1760 */     int yuanBao = AwardManager.getMoneyNumByType(sAwardMoneyId, 1);
/* 1761 */     awardModel.setYuanBao(calFixAward(roleId, yuanBao, 4, 8, awardModel));
/*      */     
/*      */ 
/* 1764 */     int gold = AwardManager.getMoneyNumByType(sAwardMoneyId, 2);
/* 1765 */     awardModel.setGold(calFixAward(roleId, gold, 5, 16, awardModel));
/*      */     
/* 1767 */     int goldIngot = AwardManager.getMoneyNumByType(sAwardMoneyId, 5);
/* 1768 */     awardModel.setGoldIngot(calFixAward(roleId, goldIngot, 13, 16, awardModel));
/*      */     
/*      */ 
/* 1771 */     int silver = AwardManager.getMoneyNumByType(sAwardMoneyId, 3);
/* 1772 */     awardModel.setSilver(calFixAward(roleId, silver, 6, 32, awardModel));
/*      */     
/* 1774 */     int gang = AwardManager.getMoneyNumByType(sAwardMoneyId, 4);
/* 1775 */     awardModel.setGang(calFixAward(roleId, gang, 7, 64, awardModel));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void calFixTokenMap(long roleId, int sAwardMoneyId, AwardModel awardModel)
/*      */   {
/* 1787 */     int xiayi = AwardManager.getTokenNumByType(sAwardMoneyId, 1);
/*      */     
/* 1789 */     int shimen = AwardManager.getTokenNumByType(sAwardMoneyId, 3);
/*      */     
/* 1791 */     int jifen = AwardManager.getTokenNumByType(sAwardMoneyId, 2);
/*      */     
/* 1793 */     int shengwang = AwardManager.getTokenNumByType(sAwardMoneyId, 4);
/*      */     
/* 1795 */     int ladderScore = AwardManager.getTokenNumByType(sAwardMoneyId, 5);
/*      */     
/* 1797 */     int moralValue = AwardManager.getTokenNumByType(sAwardMoneyId, 7);
/*      */     
/* 1799 */     int xhkpPoint = AwardManager.getTokenNumByType(sAwardMoneyId, 8);
/*      */     
/* 1801 */     int cardEssence = AwardManager.getTokenNumByType(sAwardMoneyId, 9);
/* 1802 */     int cardScore = AwardManager.getTokenNumByType(sAwardMoneyId, 10);
/*      */     
/* 1804 */     int backGameActivityPoint = AwardManager.getTokenNumByType(sAwardMoneyId, 11);
/*      */     
/* 1806 */     int singleBattlePoint = AwardManager.getTokenNumByType(sAwardMoneyId, 6);
/*      */     
/* 1808 */     int xhkpCompensatePoint = AwardManager.getTokenNumByType(sAwardMoneyId, 12);
/*      */     
/* 1810 */     int bandstandScore = AwardManager.getTokenNumByType(sAwardMoneyId, 13);
/*      */     
/* 1812 */     int petFightScore = AwardManager.getTokenNumByType(sAwardMoneyId, 14);
/*      */     
/* 1814 */     int petMarkScore1 = AwardManager.getTokenNumByType(sAwardMoneyId, 15);
/* 1815 */     int petMarkScore2 = AwardManager.getTokenNumByType(sAwardMoneyId, 16);
/*      */     
/* 1817 */     int drawCarnivalPoint = AwardManager.getTokenNumByType(sAwardMoneyId, 17);
/*      */     
/* 1819 */     Map<Integer, Integer> tokenMap = new HashMap();
/* 1820 */     if (xiayi > 0)
/*      */     {
/* 1822 */       tokenMap.put(Integer.valueOf(1), Integer.valueOf(calFixAward(roleId, xiayi, 8, 128, awardModel)));
/*      */     }
/*      */     
/* 1825 */     if (shimen > 0)
/*      */     {
/* 1827 */       tokenMap.put(Integer.valueOf(3), Integer.valueOf(calFixAward(roleId, shimen, 10, 1024, awardModel)));
/*      */     }
/*      */     
/* 1830 */     if (jifen > 0)
/*      */     {
/* 1832 */       tokenMap.put(Integer.valueOf(2), Integer.valueOf(calFixAward(roleId, jifen, 9, 256, awardModel)));
/*      */     }
/*      */     
/* 1835 */     if (shengwang > 0)
/*      */     {
/* 1837 */       tokenMap.put(Integer.valueOf(4), Integer.valueOf(calFixAward(roleId, shengwang, 11, 512, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1842 */     if (ladderScore > 0)
/*      */     {
/* 1844 */       tokenMap.put(Integer.valueOf(5), Integer.valueOf(calFixAward(roleId, ladderScore, 11, 512, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1849 */     if (moralValue > 0)
/*      */     {
/* 1851 */       tokenMap.put(Integer.valueOf(7), Integer.valueOf(calFixAward(roleId, moralValue, 14, 4096, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1856 */     if (xhkpPoint > 0)
/*      */     {
/* 1858 */       tokenMap.put(Integer.valueOf(8), Integer.valueOf(calFixAward(roleId, xhkpPoint, 16, 8192, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1863 */     if (cardEssence > 0)
/*      */     {
/* 1865 */       tokenMap.put(Integer.valueOf(9), Integer.valueOf(calFixAward(roleId, cardEssence, 17, 16384, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1870 */     if (cardScore > 0)
/*      */     {
/* 1872 */       tokenMap.put(Integer.valueOf(10), Integer.valueOf(calFixAward(roleId, cardScore, 18, 32768, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1877 */     if (backGameActivityPoint > 0)
/*      */     {
/* 1879 */       tokenMap.put(Integer.valueOf(11), Integer.valueOf(calFixAward(roleId, backGameActivityPoint, 19, 65536, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1884 */     if (singleBattlePoint > 0)
/*      */     {
/* 1886 */       tokenMap.put(Integer.valueOf(6), Integer.valueOf(calFixAward(roleId, singleBattlePoint, 10, 1024, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1891 */     if (xhkpCompensatePoint > 0)
/*      */     {
/* 1893 */       tokenMap.put(Integer.valueOf(12), Integer.valueOf(calFixAward(roleId, xhkpCompensatePoint, 20, 131072, awardModel)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1898 */     if (bandstandScore > 0)
/*      */     {
/* 1900 */       tokenMap.put(Integer.valueOf(13), Integer.valueOf(calFixAward(roleId, bandstandScore, 21, 262144, awardModel)));
/*      */     }
/*      */     
/* 1903 */     if (petFightScore > 0)
/*      */     {
/* 1905 */       tokenMap.put(Integer.valueOf(14), Integer.valueOf(calFixAward(roleId, petFightScore, 22, 524288, awardModel)));
/*      */     }
/*      */     
/* 1908 */     if (petMarkScore1 > 0)
/*      */     {
/* 1910 */       tokenMap.put(Integer.valueOf(15), Integer.valueOf(calFixAward(roleId, petMarkScore1, 23, 1048576, awardModel)));
/*      */     }
/*      */     
/* 1913 */     if (petMarkScore2 > 0)
/*      */     {
/* 1915 */       tokenMap.put(Integer.valueOf(16), Integer.valueOf(calFixAward(roleId, petMarkScore2, 24, 2097152, awardModel)));
/*      */     }
/*      */     
/* 1918 */     if (drawCarnivalPoint > 0)
/*      */     {
/* 1920 */       tokenMap.put(Integer.valueOf(17), Integer.valueOf(calFixAward(roleId, drawCarnivalPoint, 25, 4194304, awardModel)));
/*      */     }
/*      */     
/*      */ 
/* 1924 */     awardModel.getTokenMap().putAll(tokenMap);
/*      */   }
/*      */   
/*      */   private static void calFixAwardItem(long roleId, SFixItemTable fixItemTable, AwardModel awardModel)
/*      */   {
/* 1929 */     AwardAddParam addParam = new AwardAddParam();
/* 1930 */     if (!PBuffEffect.calBuffAdd(awardModel.getAddEffectId(), roleId, addParam, 12, 2048))
/*      */     {
/*      */ 
/* 1933 */       awardModel.setZeroState(true);
/* 1934 */       return;
/*      */     }
/* 1936 */     Map<Integer, Integer> itemMap = new HashMap();
/* 1937 */     for (FixItemBean fixItemBean : fixItemTable.itemList)
/*      */     {
/* 1939 */       itemMap.put(Integer.valueOf(fixItemBean.itemId), Integer.valueOf(fixItemBean.num));
/*      */     }
/* 1941 */     awardModel.addItem(itemMap);
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
/*      */   static void awardFixAwardModelImpl(Collection<Long> roleList, int fixAwardId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/* 1960 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/* 1962 */       NoneRealTimeTaskManager.getInstance().addTask(new addFixAward(roleId, fixAwardId, activeGet, isSend, awardReason));
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
/*      */   static void awardToAllImpl(Collection<Long> roleList, int awardId, int modifyId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/* 1984 */     if (!AwardInterface.hasAwardId(awardId))
/*      */     {
/* 1986 */       logger.error("奖励总表内不存在该awardId：" + awardId);
/* 1987 */       return;
/*      */     }
/* 1989 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/* 1991 */       NoneRealTimeTaskManager.getInstance().addTask(new PGiveAwrd(roleId, awardId, activeGet, isSend, modifyId, awardReason));
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
/*      */   static AwardModel awardFixAward(int fixAwardId, List<String> userList, List<Long> roleList, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/* 2006 */     AwardModel awardModel = null;
/* 2007 */     int size = userList.size();
/* 2008 */     for (int i = 0; i < size; i++)
/*      */     {
/* 2010 */       String userId = (String)userList.get(i);
/* 2011 */       long roleId = ((Long)roleList.get(i)).longValue();
/* 2012 */       awardModel = awardFixAward(fixAwardId, userId, roleId, activeGet, isSend, awardReason);
/* 2013 */       if (awardModel == null) {
/*      */         break;
/*      */       }
/*      */       
/* 2017 */       if (isSend)
/*      */       {
/* 2019 */         sendAwardInfo(roleId, awardModel);
/*      */       }
/*      */     }
/* 2022 */     return awardModel;
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
/*      */   static void awardMultiRoleSelectAward(List<Long> allRoles, List<Long> notAwardRoles, List<MultiRoleAwardBean> multiRoleAwardBeans, MultiRoleSelectAwardContext context, TLogArg tLogArg)
/*      */   {
/* 2042 */     if ((multiRoleAwardBeans.size() <= 0) || (allRoles.size() <= 0) || (tLogArg == null))
/*      */     {
/* 2044 */       return;
/*      */     }
/* 2046 */     if (notAwardRoles != null)
/*      */     {
/* 2048 */       if (allRoles.size() == notAwardRoles.size())
/*      */       {
/* 2050 */         return;
/*      */       }
/*      */     }
/*      */     
/* 2054 */     MultiRoleAwardCache xMultiRoleAwardCache = Pod.newMultiRoleAwardCache();
/* 2055 */     long awardUuid = xtable.Multiroleaward.insert(xMultiRoleAwardCache).longValue();
/* 2056 */     if (context != null)
/*      */     {
/* 2058 */       MultiRoleAwardContext multiRoleAwardContext = Pod.newMultiRoleAwardContext();
/* 2059 */       multiRoleAwardContext.setContext(context);
/* 2060 */       xtable.Multiroleawardcontext.insert(Long.valueOf(awardUuid), multiRoleAwardContext);
/*      */     }
/* 2062 */     xMultiRoleAwardCache.setTlogarg(tLogArg);
/*      */     
/* 2064 */     java.util.Collections.shuffle(multiRoleAwardBeans);
/*      */     
/* 2066 */     for (MultiRoleAwardBean awardBean : multiRoleAwardBeans)
/*      */     {
/* 2068 */       Item2CountBean item2Count = Pod.newItem2CountBean();
/* 2069 */       item2Count.setCount(awardBean.count);
/* 2070 */       item2Count.setItemid(awardBean.id);
/* 2071 */       xMultiRoleAwardCache.getAwarditemids().add(item2Count);
/*      */     }
/* 2073 */     xMultiRoleAwardCache.getRoles().addAll(allRoles);
/* 2074 */     if (notAwardRoles != null)
/*      */     {
/* 2076 */       xMultiRoleAwardCache.getOperroleids().addAll(notAwardRoles);
/*      */     }
/*      */     
/*      */ 
/* 2080 */     SSynMultiRoleAwardItemRes synMultiRoleAwardItemRes = new SSynMultiRoleAwardItemRes();
/* 2081 */     synMultiRoleAwardItemRes.awarduuid = awardUuid;
/* 2082 */     if (notAwardRoles != null)
/*      */     {
/* 2084 */       synMultiRoleAwardItemRes.notawardroles.addAll(notAwardRoles);
/*      */     }
/* 2086 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*      */ 
/* 2089 */       MultiRoleAwards xMultiRoleAwards = Role2multiroleaward.get(Long.valueOf(roleid));
/* 2090 */       if (xMultiRoleAwards == null)
/*      */       {
/* 2092 */         xMultiRoleAwards = Pod.newMultiRoleAwards();
/* 2093 */         Role2multiroleaward.insert(Long.valueOf(roleid), xMultiRoleAwards);
/*      */       }
/* 2095 */       xMultiRoleAwards.getAwards().add(Long.valueOf(awardUuid));
/*      */       
/* 2097 */       RoleInfo roleInfo = new RoleInfo();
/* 2098 */       fillRoleInfo(roleInfo, roleid);
/* 2099 */       synMultiRoleAwardItemRes.roles.add(roleInfo);
/*      */     }
/*      */     
/* 2102 */     OnlineManager.getInstance().sendMulti(synMultiRoleAwardItemRes, allRoles);
/*      */     
/* 2104 */     new MultiRoleSelectAwardTimer(AwardCfgConsts.getInstance().MULTI_AWARD_ROLE_END_TIME, awardUuid, allRoles);
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillRoleInfo(RoleInfo roleInfo, long roleid)
/*      */   {
/* 2110 */     roleInfo.rolename = RoleInterface.getName(roleid);
/* 2111 */     roleInfo.roleid = roleid;
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
/*      */   static void awardMultiAwardRole(final long roleid, long awardUuid, MultiRoleAwardCache multiRoleAwardCache, MultiRoleSelectAwardContext context, int index, TLogArg tLogArg)
/*      */   {
/* 2125 */     multiRoleAwardCache.getOperroleids().add(Long.valueOf(roleid));
/* 2126 */     multiRoleAwardCache.getIndexmap().put(Integer.valueOf(index), Long.valueOf(roleid));
/* 2127 */     Item2CountBean item2Count = null;
/* 2128 */     if (index < multiRoleAwardCache.getAwarditemids().size())
/*      */     {
/* 2130 */       item2Count = (Item2CountBean)multiRoleAwardCache.getAwarditemids().get(index);
/*      */     }
/* 2132 */     if (item2Count != null)
/*      */     {
/* 2134 */       int itemid = item2Count.getItemid();
/* 2135 */       final int itemcount = item2Count.getCount();
/* 2136 */       if (!IdipManager.isZeroProfit(roleid))
/*      */       {
/* 2138 */         ItemInterface.addItem(roleid, itemid, itemcount, tLogArg);
/* 2139 */         if (ItemBulletinInterface.needBulletin(item2Count.getItemid()))
/*      */         {
/* 2141 */           Procedure.execute(new LogicProcedure()
/*      */           {
/*      */ 
/*      */             protected boolean processImp()
/*      */               throws Exception
/*      */             {
/* 2147 */               this.val$tLogArg.getLogReason().gainPreciousItem(roleid, itemcount, this.val$itemcount);
/* 2148 */               return true;
/*      */             }
/*      */           });
/*      */         }
/*      */       }
/* 2153 */       RoleSelectAwardArg roleSelectAwardArg = new RoleSelectAwardArg(roleid, itemid, itemcount, context);
/* 2154 */       TriggerEventsManger.getInstance().triggerEvent(new RoleSelectAward(), roleSelectAwardArg);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2159 */     STakeSelectAwardRes sTakeAwardRes = new STakeSelectAwardRes();
/* 2160 */     sTakeAwardRes.awarduuid = awardUuid;
/* 2161 */     sTakeAwardRes.index = index;
/* 2162 */     sTakeAwardRes.roleid = roleid;
/* 2163 */     if (item2Count != null)
/*      */     {
/* 2165 */       sTakeAwardRes.awardbean.count = item2Count.getCount();
/* 2166 */       sTakeAwardRes.awardbean.id = item2Count.getItemid();
/*      */     }
/* 2168 */     OnlineManager.getInstance().sendMulti(sTakeAwardRes, multiRoleAwardCache.getRoles());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void fillNotAwardBean(Map<Integer, MultiRoleAwardBean> index2award, MultiRoleAwardCache multiRoleAwardCache)
/*      */   {
/* 2175 */     for (int i = 0; i < multiRoleAwardCache.getAwarditemids().size(); i++)
/*      */     {
/* 2177 */       if (!multiRoleAwardCache.getIndexmap().containsKey(Integer.valueOf(i)))
/*      */       {
/* 2179 */         Item2CountBean item2Count = (Item2CountBean)multiRoleAwardCache.getAwarditemids().get(i);
/* 2180 */         MultiRoleAwardBean awardBean = new MultiRoleAwardBean();
/* 2181 */         awardBean.id = item2Count.getItemid();
/* 2182 */         awardBean.count = item2Count.getCount();
/* 2183 */         index2award.put(Integer.valueOf(i), awardBean);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillAwardRole(Map<Long, MultiRoleAwardBean> roleAwards, MultiRoleAwardCache multiRoleAwardCache)
/*      */   {
/* 2191 */     for (Map.Entry<Integer, Long> entry : multiRoleAwardCache.getIndexmap().entrySet())
/*      */     {
/* 2193 */       int index = ((Integer)entry.getKey()).intValue();
/* 2194 */       long roleid = ((Long)entry.getValue()).longValue();
/* 2195 */       if (multiRoleAwardCache.getAwarditemids().size() > index)
/*      */       {
/* 2197 */         Item2CountBean item2Count = (Item2CountBean)multiRoleAwardCache.getAwarditemids().get(index);
/* 2198 */         MultiRoleAwardBean awardBean = new MultiRoleAwardBean();
/* 2199 */         awardBean.id = item2Count.getItemid();
/* 2200 */         awardBean.count = item2Count.getCount();
/* 2201 */         roleAwards.put(Long.valueOf(roleid), awardBean);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void sendNormalRetAtOnce(long roleid, int ret, String... args)
/*      */   {
/* 2208 */     sendNormalRet(roleid, ret, true, args);
/*      */   }
/*      */   
/*      */   static void sendNormalRetAfterSuc(long roleid, int ret, String... args)
/*      */   {
/* 2213 */     sendNormalRet(roleid, ret, false, args);
/*      */   }
/*      */   
/*      */   static void sendNormalRet(long roleid, int ret, boolean rightNow, String... args)
/*      */   {
/* 2218 */     SAwardNormalResult awardNormalResult = new SAwardNormalResult();
/* 2219 */     awardNormalResult.result = ret;
/* 2220 */     for (String arg : args)
/*      */     {
/* 2222 */       awardNormalResult.args.add(arg);
/*      */     }
/* 2224 */     if (rightNow)
/*      */     {
/* 2226 */       OnlineManager.getInstance().sendAtOnce(roleid, awardNormalResult);
/*      */     }
/*      */     else
/*      */     {
/* 2230 */       OnlineManager.getInstance().send(roleid, awardNormalResult);
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
/*      */   static void awardCurrencyNotice(long roleId, int bigType, int littleType, int value)
/*      */   {
/* 2250 */     if (value <= 0)
/*      */     {
/* 2252 */       return;
/*      */     }
/* 2254 */     SSendDefaultAwardInfo sAwardInfo = new SSendDefaultAwardInfo();
/* 2255 */     if (!fillSingleAwardBean(bigType, littleType, value, sAwardInfo.awardinfo))
/*      */     {
/* 2257 */       return;
/*      */     }
/* 2259 */     OnlineManager.getInstance().send(roleId, sAwardInfo);
/*      */   }
/*      */   
/*      */   private static boolean fillSingleAwardBean(int bigType, int littleType, int value, AwardBean awardBean)
/*      */   {
/* 2264 */     if (bigType == 1) {}
/*      */     
/*      */ 
/* 2267 */     switch (bigType)
/*      */     {
/*      */     case 1: 
/* 2270 */       if (!addMoney(littleType, value, awardBean))
/*      */       {
/* 2272 */         return false;
/*      */       }
/*      */       break;
/*      */     case 2: 
/* 2276 */       awardBean.tokenmap.put(Integer.valueOf(littleType), Integer.valueOf(value));
/* 2277 */       break;
/*      */     default: 
/* 2279 */       return false;
/*      */     }
/* 2281 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean addMoney(int littleType, int value, AwardBean awardBean)
/*      */   {
/* 2286 */     switch (littleType)
/*      */     {
/*      */     case 2: 
/* 2289 */       awardBean.gold = value;
/* 2290 */       break;
/*      */     case 1: 
/* 2292 */       awardBean.yuanbao = value;
/* 2293 */       break;
/*      */     case 3: 
/* 2295 */       awardBean.silver = value;
/* 2296 */       break;
/*      */     case 5: 
/* 2298 */       awardBean.goldingot = value;
/* 2299 */       break;
/*      */     case 4: 
/* 2301 */       awardBean.gang = value;
/* 2302 */       break;
/*      */     
/*      */     default: 
/* 2305 */       return false;
/*      */     }
/* 2307 */     return true;
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
/*      */   static void fillMailAttchMentBy(List<AwardModel> awardModelsWithoutItemBind, List<AwardModel> awardModelsWithItemBind, MailAttachment attachment)
/*      */   {
/* 2325 */     if (attachment == null)
/*      */     {
/* 2327 */       return;
/*      */     }
/* 2329 */     AwardModel tempAwardModelNoBind = combineAwardModels(awardModelsWithoutItemBind);
/* 2330 */     AwardModel tempAwardModelWithBind = combineAwardModels(awardModelsWithItemBind);
/* 2331 */     tempAwardModelNoBind.fillMailAttchMent(attachment, false);
/* 2332 */     tempAwardModelWithBind.fillMailAttchMent(attachment, true);
/*      */   }
/*      */   
/*      */   private static AwardModel combineAwardModels(List<AwardModel> awardModels)
/*      */   {
/* 2337 */     AwardModel tempAwardModel = new AwardModel();
/* 2338 */     if ((awardModels == null) || (awardModels.size() == 0))
/*      */     {
/* 2340 */       return tempAwardModel;
/*      */     }
/* 2342 */     for (AwardModel each : awardModels)
/*      */     {
/* 2344 */       tempAwardModel.add(each);
/*      */     }
/* 2346 */     return tempAwardModel;
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
/*      */   static AwardModel awardPoolAward(int awardPoolLibId, String userId, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/* 2370 */     AwardPoolResultData awardPoolData = AwardPoolInterface.getAwardPoolData(awardPoolLibId, RoleInterface.getLevel(roleId), false);
/*      */     
/* 2372 */     if (awardPoolData == null)
/*      */     {
/* 2374 */       GameServer.logger().error(String.format("[award]RoleAwardManager.awardPoolAward@ randomAwardPoolForRole's awardPoolData is null!|roleId=%d|awardPoolSumId=%d|awardReason=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardPoolLibId), awardReason }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 2379 */       return null;
/*      */     }
/* 2381 */     AwardModel awardModel = AwardModel.getAwardModel(awardPoolData);
/* 2382 */     if (!giveAward(isSend, awardReason, userId, roleId, activeGet, awardModel))
/*      */     {
/* 2384 */       GameServer.logger().error(String.format("[award]RoleAwardManager.awardPoolAward@ awardToRoleByAwardModel error!|roleId=%d|awardPoolSumId=%d|awardReason=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardPoolLibId), awardReason }));
/*      */       
/*      */ 
/*      */ 
/* 2388 */       return null;
/*      */     }
/* 2390 */     return awardModel;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\RoleAwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
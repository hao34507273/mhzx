/*      */ package mzm.gsp.award.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.award.AwardBean;
/*      */ import mzm.gsp.award.AwardInfoBean;
/*      */ import mzm.gsp.award.ExpAwardBean;
/*      */ import mzm.gsp.award.MoneyAwardBean;
/*      */ import mzm.gsp.award.MultiRoleAwardBean;
/*      */ import mzm.gsp.award.confbean.ItemPair;
/*      */ import mzm.gsp.award.confbean.SAward;
/*      */ import mzm.gsp.award.confbean.SAwardItem;
/*      */ import mzm.gsp.award.confbean.SModifyValueTable;
/*      */ import mzm.gsp.award.drop.DropManager;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AwardInterface
/*      */ {
/*      */   public static AwardModel award(int awardId, String userId, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*   55 */     List<String> userList = new ArrayList();
/*   56 */     userList.add(userId);
/*   57 */     List<Long> roleList = new ArrayList();
/*   58 */     roleList.add(Long.valueOf(roleId));
/*   59 */     return (AwardModel)award(awardId, userList, roleList, roleList, activeGet, isSend, awardReason).get(Long.valueOf(roleId));
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
/*      */   public static AwardModel awardAtTime(int awardId, long awardTime, String userId, long roleId, int modifyId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*   86 */     Map<Long, Integer> awardTimeInfo = new HashMap();
/*   87 */     if (awardTime > 0L)
/*      */     {
/*   89 */       awardTimeInfo.put(Long.valueOf(awardTime), Integer.valueOf(1));
/*      */     }
/*   91 */     return awardAtTime(awardId, awardTimeInfo, userId, roleId, modifyId, activeGet, isSend, awardReason);
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
/*      */   public static AwardModel awardAtTime(int awardId, Map<Long, Integer> awardTimeInfo, String userId, long roleId, int modifyId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  118 */     return RoleAwardManager.awardAtTime(Arrays.asList(new Long[] { Long.valueOf(roleId) }), Arrays.asList(new Long[] { Long.valueOf(roleId) }), awardId, modifyId, userId, roleId, awardReason, awardTimeInfo, isSend, activeGet);
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
/*      */   public static void awardNoneRealTime(int awardId, String userId, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  142 */     List<String> userList = new ArrayList();
/*  143 */     userList.add(userId);
/*  144 */     List<Long> roleList = new ArrayList();
/*  145 */     roleList.add(Long.valueOf(roleId));
/*  146 */     NoneRealTimeTaskManager.getInstance().addTask(new PAward(awardId, userList, roleList, roleList, -1, activeGet, isSend, awardReason));
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
/*      */   public static AwardModel award(int awardId, String userId, long roleId, int modifileId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  172 */     List<String> userList = new ArrayList();
/*  173 */     userList.add(userId);
/*  174 */     List<Long> roleList = new ArrayList();
/*  175 */     roleList.add(Long.valueOf(roleId));
/*  176 */     return (AwardModel)award(awardId, userList, roleList, roleList, modifileId, activeGet, isSend, awardReason).get(Long.valueOf(roleId));
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
/*      */   public static AwardModel award(List<Integer> awardIds, Map<Integer, Integer> awradId2ModifileId, String userId, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  203 */     List<String> userList = new ArrayList();
/*  204 */     userList.add(userId);
/*  205 */     List<Long> roleList = new ArrayList();
/*  206 */     roleList.add(Long.valueOf(roleId));
/*  207 */     return (AwardModel)RoleAwardManager.award(userList, roleList, roleList, awardIds, awradId2ModifileId, activeGet, isSend, awardReason).get(Long.valueOf(roleId));
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
/*      */   public static AwardModel award(int awardId, String userId, long roleId, int modifileId, List<Long> roleIds, Collection<Long> allRoleList, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  239 */     return RoleAwardManager.award(awardId, userId, roleId, modifileId, roleIds, allRoleList, activeGet, isSend, awardReason);
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
/*      */   public static Map<Long, AwardModel> award(int awardId, List<String> userList, List<Long> roleList, Collection<Long> allRoleList, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  266 */     return RoleAwardManager.award(userList, roleList, allRoleList, awardId, -1, activeGet, isSend, awardReason);
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
/*      */   public static Map<Long, AwardModel> award(List<Integer> awardIds, List<String> userList, List<Long> roleList, Collection<Long> allRoleList, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  293 */     return RoleAwardManager.award(userList, roleList, allRoleList, awardIds, null, activeGet, isSend, awardReason);
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
/*      */   public static Map<Long, AwardModel> award(int awardId, List<String> userlList, List<Long> roleList, Collection<Long> allRoleList, int modifileId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  320 */     return RoleAwardManager.award(userlList, roleList, allRoleList, awardId, modifileId, activeGet, isSend, awardReason);
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
/*      */   public static Map<Long, AwardModel> awrad(List<Integer> awardIds, Map<Integer, Integer> awardId2ModifileId, List<String> userList, List<Long> roleList, Collection<Long> allRolList, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  350 */     return RoleAwardManager.award(userList, roleList, allRolList, awardIds, awardId2ModifileId, activeGet, isSend, awardReason);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean hasAwardId(int awardId)
/*      */   {
/*  362 */     return AwardManager.hasNormalAward(awardId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean hasFixAwardId(int fixAwardId)
/*      */   {
/*  374 */     return AwardManager.hasFixAward(fixAwardId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean hasModifileId(int modifileId)
/*      */   {
/*  385 */     return SModifyValueTable.get(modifileId) != null;
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
/*      */   public static AwardModel awardFixAward(int fixAwardId, String userid, long roleId, boolean activGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  405 */     return RoleAwardManager.awardFixAward(fixAwardId, userid, roleId, activGet, isSend, awardReason);
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
/*      */   public static AwardModel awardFixAwardNTime(int fixAwardId, int n, String userid, long roleId, boolean activGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  427 */     return RoleAwardManager.awardFixAwardNTime(fixAwardId, n, userid, roleId, activGet, isSend, awardReason);
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
/*      */   public static AwardModel awardPoolAward(int awardPoolLibId, String userId, long roleId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  451 */     return RoleAwardManager.awardPoolAward(awardPoolLibId, userId, roleId, activeGet, isSend, awardReason);
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
/*      */   public static AwardModel getRoleAwardModel(int awardId, long roleId, int modefileId, List<Long> roleList, Collection<Long> allRolList, AwardReason awardReason)
/*      */   {
/*  474 */     SAward sAward = AwardManager.getAwardCfg(awardId);
/*  475 */     if (sAward == null)
/*      */     {
/*  477 */       return null;
/*      */     }
/*  479 */     return RoleAwardManager.getAwardModel(roleList, allRolList, awardId, modefileId, sAward, roleId, awardReason);
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
/*      */   public static AwardModel getRoleAwardModel(int awardId, long roleId, int modefileId, AwardReason awardReason)
/*      */   {
/*  500 */     return getRoleAwardModel(awardId, roleId, modefileId, Arrays.asList(new Long[] { Long.valueOf(roleId) }), Arrays.asList(new Long[] { Long.valueOf(roleId) }), awardReason);
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
/*      */   public static AwardModel getRoleFixAwardModel(int fixAwardId, long roleId, AwardReason awardReason)
/*      */   {
/*  519 */     return RoleAwardManager.getRoleFixAwardModel(fixAwardId, roleId, awardReason);
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
/*      */   public static boolean awardToRoleByAwardModel(String userid, long roleId, AwardModel awardModel, boolean activGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  543 */     return RoleAwardManager.giveAward(isSend, awardReason, userid, roleId, activGet, awardModel);
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
/*      */   public static List<Integer> getFixAwardItems(long roleId, int fixAwardId)
/*      */   {
/*  559 */     return RoleAwardManager.getFixAwardItems(roleId, fixAwardId);
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
/*      */   public static Set<Integer> getAwardItemTableList(long roleId, Set<Integer> awardIds)
/*      */   {
/*  573 */     if ((awardIds == null) || (awardIds.size() == 0))
/*      */     {
/*  575 */       return new HashSet();
/*      */     }
/*  577 */     Set<Integer> itemIds = new HashSet();
/*  578 */     for (Iterator i$ = awardIds.iterator(); i$.hasNext();) { int awardId = ((Integer)i$.next()).intValue();
/*      */       
/*  580 */       itemIds.addAll(getAwardItemTableList(roleId, awardId));
/*      */     }
/*  582 */     return itemIds;
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
/*      */   public static List<Integer> getAwardItemTableList(long roleId, int awardId)
/*      */   {
/*  601 */     List<Long> roleList = new ArrayList();
/*  602 */     roleList.add(Long.valueOf(roleId));
/*  603 */     return getAwardItemTableList(roleId, roleList, awardId);
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
/*      */   public static List<Integer> getAwardItemTableList(long roleId, List<Long> roleList, int awardId)
/*      */   {
/*  622 */     List<Integer> itemList = new ArrayList();
/*  623 */     SAward sAward = AwardManager.getAwardCfg(awardId);
/*  624 */     if (sAward == null)
/*      */     {
/*  626 */       return itemList;
/*      */     }
/*  628 */     int itemAwardId = sAward.awardItemId;
/*  629 */     if (itemAwardId <= 0)
/*      */     {
/*  631 */       return itemList;
/*      */     }
/*  633 */     List<SAwardItem> sAwarditems = AwardManager.getItemAwardCfgs(itemAwardId);
/*  634 */     if ((sAwarditems == null) || (sAwarditems.size() == 0))
/*      */     {
/*  636 */       return itemList;
/*      */     }
/*  638 */     SAwardItem sAwardIteam = RoleAwardManager.getItemAward(roleList, itemAwardId, sAwarditems, roleId);
/*  639 */     if (sAwardIteam == null)
/*      */     {
/*  641 */       return itemList;
/*      */     }
/*  643 */     for (ItemPair itemPair : sAwardIteam.awardItemList)
/*      */     {
/*  645 */       if (itemPair.itemRate > 0)
/*      */       {
/*  647 */         itemList.add(Integer.valueOf(itemPair.itemId));
/*      */       }
/*      */     }
/*  650 */     return itemList;
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
/*      */   public static Set<Integer> getAwardItemList(int AwardItemTableId)
/*      */   {
/*  664 */     return ItemCalculator.getAwartItemSet(AwardItemTableId);
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
/*      */   public static AwardBean getAwardBean(AwardModel awardModel)
/*      */   {
/*  677 */     return RoleAwardManager.getAwardBean(awardModel);
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
/*      */   public static void fillAwardBean(AwardBean awardBean, AwardModel awardModel)
/*      */   {
/*  690 */     RoleAwardManager.fillAwardBean(awardBean, awardModel);
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
/*      */   public static void awardFixAwardNoneRealTime(Collection<Long> roleList, int fixAwardId, boolean activeGet, AwardReason awardReason)
/*      */   {
/*  710 */     RoleAwardManager.awardFixAwardModelImpl(roleList, fixAwardId, activeGet, true, awardReason);
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
/*      */   public static void awardToAllNoneRealTime(Collection<Long> roleList, int awardId, int modifyId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*      */   {
/*  733 */     RoleAwardManager.awardToAllImpl(roleList, awardId, modifyId, activeGet, isSend, awardReason);
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
/*      */   public static boolean fillAwardInfoBean(AwardModel awardModel, AwardInfoBean awardInfoBean)
/*      */   {
/*  746 */     return RoleAwardManager.fillAwardInfoBean(awardModel, awardInfoBean);
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
/*      */   public static boolean fillMoneyAwardBean(AwardModel awardModel, List<MoneyAwardBean> moneyBeans)
/*      */   {
/*  759 */     awardModel.fillAllCurrencyBeans(moneyBeans);
/*  760 */     return true;
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
/*      */   public static boolean fillExpAwardBeanBean(AwardModel awardModel, List<ExpAwardBean> expAwardBeans)
/*      */   {
/*  773 */     awardModel.fillAllExpBeans(expAwardBeans);
/*  774 */     return true;
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
/*      */   public static void awardMultiRoleSelectAward(List<Long> allRoles, List<Long> notAwardRoles, List<MultiRoleAwardBean> multiRoleAwardBeans, MultiRoleSelectAwardContext context, TLogArg tLogArg)
/*      */   {
/*  797 */     RoleAwardManager.awardMultiRoleSelectAward(allRoles, notAwardRoles, multiRoleAwardBeans, context, tLogArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getTokenOwnMax(int tokenType)
/*      */   {
/*  809 */     return AwardManager.getTokenOwnMax(tokenType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMoneyOwnMax(int moneyType)
/*      */   {
/*  821 */     return AwardManager.getMoneyOwnMax(moneyType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getTokenNameBy(int tokenType)
/*      */   {
/*  833 */     return AwardManager.getTokenNameBy(tokenType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getMoneyNameBy(int moneyType)
/*      */   {
/*  845 */     return AwardManager.getMoneyNameBy(moneyType);
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
/*      */   public static void sendNormalRet(long roleid, int ret, boolean rightNow, String... args)
/*      */   {
/*  862 */     RoleAwardManager.sendNormalRet(roleid, ret, rightNow, args);
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
/*      */   public static void fillMailAttachMentBy(List<AwardModel> awardModels, MailAttachment attachment)
/*      */   {
/*  876 */     if ((awardModels == null) || (awardModels.size() == 0) || (attachment == null))
/*      */     {
/*  878 */       return;
/*      */     }
/*  880 */     AwardModel tempAwardModel = new AwardModel();
/*  881 */     for (AwardModel each : awardModels)
/*      */     {
/*  883 */       tempAwardModel.add(each);
/*      */     }
/*  885 */     tempAwardModel.fillMailAttchMent(attachment, false);
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
/*      */   public static void fillMailAttchMentBy(List<AwardModel> awardModelsWithoutItemBind, List<AwardModel> awardModelsWithItemBind, MailAttachment attachment)
/*      */   {
/*  903 */     RoleAwardManager.fillMailAttchMentBy(awardModelsWithoutItemBind, awardModelsWithItemBind, attachment);
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
/*      */   public static MailAttachment getMailAttachmentBy(AwardModel awardModel)
/*      */   {
/*  916 */     return getMailAttachmentBy(awardModel, false);
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
/*      */   public static MailAttachment getMailAttachmentBy(AwardModel awardModel, boolean isItemBind)
/*      */   {
/*  931 */     if (awardModel == null)
/*      */     {
/*  933 */       return null;
/*      */     }
/*  935 */     return awardModel.getMailAttachment(isItemBind);
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
/*      */   public static void awardCurrencyNotice(long roleId, int bigType, int littleType, int value)
/*      */   {
/*  958 */     RoleAwardManager.awardCurrencyNotice(roleId, bigType, littleType, value);
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
/*      */   public static Map<Integer, Integer> getAwardType2ConId(int sBuffEffId)
/*      */   {
/*  972 */     return PBuffEffect.getAwardType2ConId(sBuffEffId);
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
/*      */   public static Map<Integer, Set<Integer>> getAwardType2ConIds(Set<Integer> sBuffEffIds)
/*      */   {
/*  986 */     return PBuffEffect.getAwardType2ConIds(sBuffEffIds);
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
/*      */   public static Set<Integer> getTimeDropItemIds(int awardId)
/*      */   {
/*  999 */     return DropManager.getAllTimeDropItemIds(awardId);
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
/*      */   public static boolean registerBuffId2AddType(int buffId, int addType)
/*      */   {
/* 1013 */     return BuffAwardTipRegManager.registerBuffAddType(buffId, addType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void unregisterBuffId2AddType(int buffId)
/*      */   {
/* 1023 */     BuffAwardTipRegManager.unRegisterBuffAddType(buffId);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
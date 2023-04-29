/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.children.SAddChild;
/*     */ import mzm.gsp.children.childhood.ChildhoodManager;
/*     */ import mzm.gsp.children.confbean.SBabyPropertyCfg;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.AddChildIntoHome;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.BabyPeriodInfo;
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGM_AddChildren extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int status;
/*     */   
/*     */   public PGM_AddChildren(long roleId, int status)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.status = status;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  42 */       notifyClient(this.roleId, "功能开关未打开");
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if ((this.status != 0) && (this.status != 1) && (this.status != 2))
/*     */     {
/*     */ 
/*  49 */       notifyClient(this.roleId, "参数0/1/2");
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     long marriedId = MarriageInterface.getMarriedId(this.roleId, false);
/*     */     
/*  55 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     if (marriedRoleId > 0L)
/*     */     {
/*  59 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/*  60 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/*  61 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  65 */       lock(Lockeys.get(User.getTable(), userId));
/*  66 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*  69 */     if (marriedId > 0L)
/*     */     {
/*  71 */       lock(Lockeys.get(xtable.Marriage.getTable(), Long.valueOf(marriedId)));
/*     */     }
/*  73 */     Role2ChildrenInfo xRole2ChildrenInfo = ChildrenManager.initAndGetChildrenInfo(this.roleId);
/*     */     
/*  75 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  76 */     ChildInfo xChildInfo = ChildrenManager.generatorChild(this.roleId, currentTimeMillis);
/*  77 */     long childId = xtable.Children.insert(xChildInfo).longValue();
/*     */     
/*  79 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = ChildrenManager.generatorChildGrowthDiary(currentTimeMillis, childId);
/*     */     
/*     */ 
/*  82 */     xChildInfo.setOwn_role_id(this.roleId);
/*  83 */     xChildInfo.setChild_name("子女" + childId);
/*  84 */     xChildInfo.setChild_period(this.status);
/*  85 */     if (marriedRoleId > 0L)
/*     */     {
/*  87 */       xChildInfo.setAnother_parent_role_id(marriedRoleId);
/*  88 */       xChildGrowthDiaryInfo.setAnother_give_birth_parent_role_id(marriedRoleId);
/*     */     }
/*     */     
/*  91 */     xRole2ChildrenInfo.getChild_id_list().add(Long.valueOf(childId));
/*     */     
/*  93 */     if (this.status == 0)
/*     */     {
/*  95 */       BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*  96 */       for (Map.Entry<Integer, SBabyPropertyCfg> babyPropertyEntry : SBabyPropertyCfg.getAll().entrySet())
/*     */       {
/*  98 */         xBabyPeriodInfo.getBaby_property_info_map().put(babyPropertyEntry.getKey(), Integer.valueOf(((SBabyPropertyCfg)babyPropertyEntry.getValue()).init_value));
/*     */       }
/*     */       
/* 101 */       xBabyPeriodInfo.setBaby_period_operator(-1);
/* 102 */       xBabyPeriodInfo.setAuto_breed(false);
/*     */     }
/*     */     
/* 105 */     if (this.status >= 1)
/*     */     {
/* 107 */       ChildhoodManager.checkModelCfgid(childId, xChildInfo);
/*     */     }
/*     */     
/* 110 */     if (this.status == 2)
/*     */     {
/* 112 */       int childrenModelCfgid = SChildrenConsts.getInstance().BOY_ADULT1_BASE_CFG_ID;
/* 113 */       if (xChildInfo.getChild_gender() == 2)
/*     */       {
/* 115 */         childrenModelCfgid = SChildrenConsts.getInstance().GIRL_ADULT1_BASE_CFG_ID;
/*     */       }
/* 117 */       Map<Integer, Integer> aptMap = new HashMap();
/* 118 */       aptMap.put(Integer.valueOf(1), Integer.valueOf(1000));
/* 119 */       aptMap.put(Integer.valueOf(3), Integer.valueOf(1000));
/* 120 */       aptMap.put(Integer.valueOf(5), Integer.valueOf(1000));
/* 121 */       aptMap.put(Integer.valueOf(2), Integer.valueOf(1000));
/* 122 */       aptMap.put(Integer.valueOf(4), Integer.valueOf(1000));
/* 123 */       aptMap.put(Integer.valueOf(6), Integer.valueOf(1000));
/* 124 */       ChildrenManager.stepInAdulthood(childrenModelCfgid, xChildInfo, aptMap);
/*     */       
/* 126 */       ChildrenManager.triggerChildRatingChange(this.roleId, childId, false);
/*     */     }
/* 128 */     SAddChild sAddChild = new SAddChild();
/* 129 */     sAddChild.child_id = childId;
/*     */     
/* 131 */     if (this.status == 2)
/*     */     {
/* 133 */       ChildrenManager.fillChildBean(this.roleId, childId, xChildInfo, sAddChild.child_info, true);
/*     */     }
/*     */     else
/*     */     {
/* 137 */       ChildrenManager.fillChildBean(this.roleId, childId, xChildInfo, sAddChild.child_info, false);
/*     */     }
/*     */     
/* 140 */     OnlineManager.getInstance().send(this.roleId, sAddChild);
/* 141 */     if (marriedId > 0L)
/*     */     {
/* 143 */       OnlineManager.getInstance().send(marriedRoleId, sAddChild);
/*     */     }
/*     */     
/* 146 */     notifyClient(this.roleId, "增加子女成功");
/*     */     
/* 148 */     ChildrenManager.trigChildrenEvent(new AddChildIntoHome(), new mzm.gsp.children.event.AddChildIntoHomeArg(this.roleId, childId, mzm.gsp.homeland.main.HomelandInterface.getCurrentHomeMapId(this.roleId), mzm.gsp.children.event.ChildAddHomeReason.GIVE_BIRTH));
/*     */     
/*     */ 
/*     */ 
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyClient(long roleId, String str)
/*     */   {
/* 157 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 158 */     messagetip.result = Integer.MAX_VALUE;
/* 159 */     messagetip.args.add(str);
/* 160 */     OnlineManager.getInstance().sendAtOnce(roleId, messagetip);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PGM_AddChildren.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SStartBreedBabyChildSuccess;
/*     */ import mzm.gsp.children.confbean.BabyOperatorCostBean;
/*     */ import mzm.gsp.children.confbean.SBabyOperatorCfg;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.ChildBabyPeriodBreedTimer;
/*     */ import mzm.gsp.children.event.ChildBabyPeriodBreedTimerArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BabyPeriodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCStartBreedBabyChild extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   private final int operator;
/*     */   
/*     */   public PCStartBreedBabyChild(long roleId, long childId, int operator)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.childId = childId;
/*  33 */     this.operator = operator;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  41 */       onStartBreedBabyChildFail(21);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!ChildrenManager.canDoAction(this.roleId, 844))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if ((this.operator != 0) && (this.operator != 2) && (this.operator != 1) && (this.operator != 3))
/*     */     {
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  62 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  65 */     if (!HomelandInterface.isAtHome(this.roleId, true))
/*     */     {
/*  67 */       onStartBreedBabyChildFail(9);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*  72 */     if (xChildInfo == null)
/*     */     {
/*  74 */       onStartBreedBabyChildFail(2);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  80 */       onStartBreedBabyChildFail(1);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleId, xChildInfo))
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/*  91 */       onStartBreedBabyChildFail(3);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*  96 */     if (xBabyPeriodInfo.getAuto_breed())
/*     */     {
/*     */ 
/*  99 */       GameServer.logger().error(String.format("PCStartBreedBabyChild.processImp@auto breed|roleid=%d|childid=%d|operator=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     if (xBabyPeriodInfo.getBaby_period_operator() != -1)
/*     */     {
/* 107 */       onStartBreedBabyChildFail(45);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     Integer tiredValue = (Integer)xBabyPeriodInfo.getBaby_property_info_map().get(Integer.valueOf(3));
/* 112 */     if ((tiredValue != null) && (tiredValue.intValue() >= SChildrenConsts.getInstance().baby_max_tired_value) && (this.operator != 3))
/*     */     {
/*     */ 
/* 115 */       onStartBreedBabyChildFail(46);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     SBabyOperatorCfg sBabyOperatorCfg = SBabyOperatorCfg.get(this.operator);
/* 120 */     if (sBabyOperatorCfg == null)
/*     */     {
/* 122 */       onStartBreedBabyChildFail(47);
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     for (BabyOperatorCostBean costBean : sBabyOperatorCfg.cost_currency_list)
/*     */     {
/* 128 */       int costCurrencyType = costBean.cost_currency_type;
/* 129 */       int costCurrencyValue = costBean.cost_currency_type_value;
/*     */       
/* 131 */       boolean result = ChildrenManager.costCurrencyValue(this.roleId, costCurrencyType, costCurrencyValue);
/* 132 */       if (!result)
/*     */       {
/* 134 */         onStartBreedBabyChildFail(48);
/* 135 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 139 */     long startMillSecondsTime = DateTimeUtils.getCurrTimeInMillis();
/* 140 */     xBabyPeriodInfo.setBaby_period_operator(this.operator);
/* 141 */     xBabyPeriodInfo.setBaby_period_operator_start_time(startMillSecondsTime);
/*     */     
/* 143 */     ChildBabyPeriodBreedTimerArg breedTimerArg = new ChildBabyPeriodBreedTimerArg(sBabyOperatorCfg.operator_cd_time, this.roleId, this.childId, this.operator, startMillSecondsTime);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 148 */     ChildrenManager.trigChildrenEvent(new ChildBabyPeriodBreedTimer(), breedTimerArg);
/*     */     
/* 150 */     ChildrenManager.tlogBabyBreedOperator(userId, this.roleId, this.childId, this.operator);
/*     */     
/* 152 */     SStartBreedBabyChildSuccess sStartBreedBabyChildSuccess = new SStartBreedBabyChildSuccess();
/* 153 */     sStartBreedBabyChildSuccess.child_id = this.childId;
/* 154 */     sStartBreedBabyChildSuccess.operator = this.operator;
/*     */     
/* 156 */     OnlineManager.getInstance().send(this.roleId, sStartBreedBabyChildSuccess);
/*     */     
/* 158 */     long anotherParentRoleId = xChildInfo.getAnother_parent_role_id();
/* 159 */     if ((this.operator == 3) && (anotherParentRoleId != -1L))
/*     */     {
/* 161 */       long realAnotherParentRoleId = anotherParentRoleId == this.roleId ? xChildInfo.getOwn_role_id() : anotherParentRoleId;
/*     */       
/* 163 */       OnlineManager.getInstance().send(realAnotherParentRoleId, sStartBreedBabyChildSuccess);
/*     */     }
/*     */     
/* 166 */     GameServer.logger().info(String.format("[[children]PCStartBreedBabyChild.processImp@start breed child success]role_id=%d|child_id=%d|operator=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId), Integer.valueOf(this.operator) }));
/*     */     
/*     */ 
/*     */ 
/* 170 */     return true;
/*     */   }
/*     */   
/*     */   private void onStartBreedBabyChildFail(int ret)
/*     */   {
/* 175 */     onStartBreedBabyChildFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onStartBreedBabyChildFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 180 */     StringBuilder sbLog = new StringBuilder();
/* 181 */     sbLog.append("[children]PCStartBreedBabyChild.processImp@start breed child failed");
/* 182 */     sbLog.append("|ret=").append(ret);
/* 183 */     sbLog.append("|role_id=").append(this.roleId);
/* 184 */     sbLog.append("|child_id=").append(this.childId);
/* 185 */     sbLog.append("|operator=").append(this.operator);
/*     */     
/* 187 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 189 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 191 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 194 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 196 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 197 */     sChildNormalFail.result = ret;
/*     */     
/* 199 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCStartBreedBabyChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
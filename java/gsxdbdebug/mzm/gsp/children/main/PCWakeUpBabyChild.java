/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SWakeUpBabyChild;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BabyPeriodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCWakeUpBabyChild
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCWakeUpBabyChild(long roleId, long childId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  39 */       onWakeUpBabyChildFail(21);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!ChildrenManager.canDoAction(this.roleId, 845))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     String userId = RoleInterface.getUserId(this.roleId);
/*  54 */     lock(Lockeys.get(User.getTable(), userId));
/*  55 */     if (!HomelandInterface.isAtHome(this.roleId, true))
/*     */     {
/*  57 */       onWakeUpBabyChildFail(9);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*  62 */     if (xChildInfo == null)
/*     */     {
/*  64 */       onWakeUpBabyChildFail(2);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (xChildInfo.getChild_period() != 0)
/*     */     {
/*  70 */       onWakeUpBabyChildFail(33);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  76 */       onWakeUpBabyChildFail(1);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/*  82 */       onWakeUpBabyChildFail(3);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*  87 */     if (xBabyPeriodInfo.getAuto_breed())
/*     */     {
/*     */ 
/*  90 */       GameServer.logger().error(String.format("PCWakeUpBabyChild.processImp@auto breed|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId) }));
/*     */       
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (xBabyPeriodInfo.getBaby_period_operator() != 3)
/*     */     {
/*  97 */       onWakeUpBabyChildFail(50);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 102 */     long deltaHours = (currentTimeMillis - xBabyPeriodInfo.getBaby_period_operator_start_time()) / 3600000L;
/*     */     
/*     */ 
/* 105 */     int cutTiredValue = (int)(SChildrenConsts.getInstance().baby_sleep_reduce_tired__every_hour * deltaHours);
/*     */     
/* 107 */     Map<Integer, Integer> xBabyPropertyMap = xBabyPeriodInfo.getBaby_property_info_map();
/*     */     
/* 109 */     Integer oldTiredValue = (Integer)xBabyPropertyMap.get(Integer.valueOf(3));
/* 110 */     Map<Integer, Integer> intParameterMap = new HashMap();
/* 111 */     intParameterMap.put(Integer.valueOf(4), Integer.valueOf(3));
/* 112 */     if (oldTiredValue != null)
/*     */     {
/* 114 */       int newTiredValue = oldTiredValue.intValue() - cutTiredValue;
/* 115 */       int realTiredValue = newTiredValue > 0 ? newTiredValue : 0;
/* 116 */       xBabyPropertyMap.put(Integer.valueOf(3), Integer.valueOf(realTiredValue));
/* 117 */       intParameterMap.put(Integer.valueOf(3), Integer.valueOf(realTiredValue - oldTiredValue.intValue()));
/* 118 */       ChildrenInterface.fillChildGrowthDiary(this.childId, intParameterMap, null, 0);
/*     */     }
/*     */     else
/*     */     {
/* 122 */       xBabyPropertyMap.put(Integer.valueOf(3), Integer.valueOf(0));
/*     */     }
/*     */     
/* 125 */     xBabyPeriodInfo.setBaby_period_operator(-1);
/* 126 */     xBabyPeriodInfo.setBaby_period_operator_start_time(0L);
/*     */     
/*     */ 
/* 129 */     ChildrenManager.cancelBreedChildObserver(this.childId);
/*     */     
/* 131 */     ChildrenManager.tlogBabyBreedOperator(userId, this.roleId, this.childId, 4);
/*     */     
/* 133 */     SWakeUpBabyChild sWakeUpBabyChild = new SWakeUpBabyChild();
/* 134 */     sWakeUpBabyChild.child_id = this.childId;
/* 135 */     sWakeUpBabyChild.now_tired_value = ((Integer)xBabyPropertyMap.get(Integer.valueOf(3))).intValue();
/*     */     
/* 137 */     OnlineManager.getInstance().send(this.roleId, sWakeUpBabyChild);
/*     */     
/* 139 */     long xAnotherParentRoleId = xChildInfo.getAnother_parent_role_id();
/* 140 */     if (xAnotherParentRoleId != -1L)
/*     */     {
/* 142 */       long realAnotherParentRoleId = this.roleId != xAnotherParentRoleId ? xAnotherParentRoleId : xChildInfo.getOwn_role_id();
/*     */       
/* 144 */       OnlineManager.getInstance().send(realAnotherParentRoleId, sWakeUpBabyChild);
/*     */     }
/*     */     
/* 147 */     GameServer.logger().info(String.format("[children]PCWakeUpBabyChild.processImp@handle wake up children success|role_id=%d|child_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId) }));
/*     */     
/*     */ 
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   private void onWakeUpBabyChildFail(int ret)
/*     */   {
/* 155 */     onWakeUpBabyChildFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onWakeUpBabyChildFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 160 */     StringBuilder sbLog = new StringBuilder();
/* 161 */     sbLog.append("[children]PCWakeUpBabyChild.processImp@wake up child failed");
/* 162 */     sbLog.append("|ret=").append(ret);
/* 163 */     sbLog.append("|role_id=").append(this.roleId);
/* 164 */     sbLog.append("|child_id=").append(this.childId);
/*     */     
/* 166 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 168 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 170 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 173 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 175 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 176 */     sChildNormalFail.result = ret;
/*     */     
/* 178 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCWakeUpBabyChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
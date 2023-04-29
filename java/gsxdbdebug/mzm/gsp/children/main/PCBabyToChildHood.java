/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SBabyToChildHoodSuccess;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.childhood.ChildhoodManager;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.ChildPeriodChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Childrengrowthdiary;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBabyToChildHood extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCBabyToChildHood(long roleId, long childId)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  42 */       onBabyToChildHoodFail(21);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!ChildhoodManager.isFunOpen(this.roleId))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!ChildrenManager.canDoAction(this.roleId, 832))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  63 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  64 */     if (marriedRoleId > 0L)
/*     */     {
/*  66 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/*  67 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/*  68 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  72 */       lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     }
/*  74 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/*     */     
/*  76 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childId));
/*  77 */     if (xChildInfo == null)
/*     */     {
/*  79 */       onBabyToChildHoodFail(2);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (xChildInfo.getChild_period() != 0)
/*     */     {
/*  85 */       onBabyToChildHoodFail(33);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleId, xChildInfo))
/*     */     {
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  96 */       onBabyToChildHoodFail(1);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/* 102 */       onBabyToChildHoodFail(3);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     xbean.BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*     */     
/* 108 */     long currentTimeMillis = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 110 */     int xBabyPeriodHealthScore = ChildrenManager.refreshAndGetHealthValue(this.roleId, this.childId, xBabyPeriodInfo, currentTimeMillis);
/*     */     
/* 112 */     if (xBabyPeriodHealthScore < SChildrenConsts.getInstance().baby_to_childhood_need_health_value)
/*     */     {
/* 114 */       onBabyToChildHoodFail(34);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     xChildInfo.setChild_period(1);
/* 119 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 120 */     if (xChildInfo.getChild_gender() == 2)
/*     */     {
/* 122 */       xChildhoodInfo.setChild_hood_model_cfg_id(SChildrenConsts.getInstance().GIRL_CHILDHOOD_BASE_CFG_ID);
/*     */     }
/*     */     else
/*     */     {
/* 126 */       xChildhoodInfo.setChild_hood_model_cfg_id(SChildrenConsts.getInstance().BOY_CHILDHOOD_BASE_CFG_ID);
/*     */     }
/*     */     
/* 129 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = Childrengrowthdiary.get(Long.valueOf(this.childId));
/* 130 */     if (xChildGrowthDiaryInfo == null)
/*     */     {
/* 132 */       onBabyToChildHoodFail(35);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     xChildGrowthDiaryInfo.setChildhood_begin_time(currentTimeMillis);
/*     */     
/*     */ 
/* 139 */     if ((xRole2ChildrenInfo != null) && (xRole2ChildrenInfo.getShow_child_id() == this.childId))
/*     */     {
/* 141 */       xRole2ChildrenInfo.setShow_child_period(1);
/* 142 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleId, mzm.gsp.children.event.ChildShowModelChangeReason.PERIOD_CHANGE));
/*     */     }
/*     */     
/*     */ 
/* 146 */     ChildrenManager.trigChildrenEvent(new ChildPeriodChange(), new mzm.gsp.children.event.ChildPeriodChangeArg(this.roleId, this.childId));
/*     */     
/* 148 */     ChildrenManager.tlogBabyBreedOperator(userId, this.roleId, this.childId, 4);
/*     */     
/* 150 */     SBabyToChildHoodSuccess sBabyToChildHoodSuccess = new SBabyToChildHoodSuccess();
/* 151 */     sBabyToChildHoodSuccess.child_id = this.childId;
/* 152 */     ChildrenManager.fillChildBean(xChildInfo.getOwn_role_id(), this.childId, xChildInfo, sBabyToChildHoodSuccess.child_bean, false);
/*     */     
/*     */ 
/* 155 */     OnlineManager.getInstance().send(this.roleId, sBabyToChildHoodSuccess);
/* 156 */     if (marriedRoleId > 0L)
/*     */     {
/* 158 */       OnlineManager.getInstance().send(marriedRoleId, sBabyToChildHoodSuccess);
/*     */     }
/*     */     
/* 161 */     GameServer.logger().info(String.format("[children]PCBabyToChildHood.processImp@baby to child hood success|role_id=%d|child_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId) }));
/*     */     
/*     */ 
/* 164 */     return true;
/*     */   }
/*     */   
/*     */   private void onBabyToChildHoodFail(int ret)
/*     */   {
/* 169 */     onBabyToChildHoodFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onBabyToChildHoodFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 174 */     StringBuilder sbLog = new StringBuilder();
/* 175 */     sbLog.append("[children]PCBabyToChildHood.processImp@baby to child fail");
/* 176 */     sbLog.append("|ret=").append(ret);
/* 177 */     sbLog.append("|role_id=").append(this.roleId);
/* 178 */     sbLog.append("|child_id=").append(this.childId);
/* 179 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 181 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 183 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 186 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 188 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 189 */     sChildNormalFail.result = ret;
/*     */     
/* 191 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCBabyToChildHood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
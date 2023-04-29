/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.cake.SGetCakeAward;
/*     */ import mzm.gsp.item.confbean.SCakeItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CakeData;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCUseCakeItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   private final int num;
/*     */   
/*     */   public PCUseCakeItem(long roleId, long uuid, int num)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.uuid = uuid;
/*  39 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (this.num != 1)
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userId = RoleInterface.getUserId(this.roleId);
/*  51 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  53 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  54 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.uuid);
/*  55 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     SCakeItemCfg itemCfg = SCakeItemCfg.get(basicItem.getCfgId());
/*  60 */     if (itemCfg == null)
/*     */     {
/*  62 */       CakeManager.loggerError("PCUseCakeItem.processImp@ SCakeItemCfg is null!|roleId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()) });
/*     */       
/*  64 */       return false;
/*     */     }
/*  66 */     Integer activityId = basicItem.getExtra(ItemStoreEnum.CAKE_ACTIVITY_ID);
/*  67 */     if (activityId == null)
/*     */     {
/*  69 */       CakeManager.loggerError("PCUseCakeItem.processImp@ activityId is null!|roleId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()) });
/*     */       
/*  71 */       return false;
/*     */     }
/*  73 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId.intValue());
/*  74 */     if (activityCfg == null)
/*     */     {
/*  76 */       CakeManager.loggerError("PCUseCakeItem.processImp@ SCakeActivityCfg is null!|roleId=%d|itemId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()), activityId });
/*     */       
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     long cakeMasterId = getCakeMasterId(basicItem);
/*  82 */     if (cakeMasterId <= 0L)
/*     */     {
/*  84 */       CakeManager.loggerError("PCUseCakeItem.processImp@ cakeMasterId is invalid!|roleId=%d|itemId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()), activityId });
/*     */       
/*  86 */       return false;
/*     */     }
/*  88 */     CakeData xCakeData = getAndInitCakeData(activityId);
/*     */     
/*  90 */     if (!checkUseCount(activityCfg, cakeMasterId, xCakeData))
/*     */     {
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     AwardModel awardModel = AwardInterface.award(itemCfg.awardId, userId, this.roleId, true, false, new AwardReason(LogReason.AWARD_EAT_CAKE, basicItem.getCfgId()));
/*     */     
/*  98 */     if (awardModel == null)
/*     */     {
/* 100 */       CakeManager.loggerError("PCUseCakeItem.processImp@ award err!|roleId=%d|itemId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()), activityId });
/*     */       
/* 102 */       return false;
/*     */     }
/* 104 */     if (!ItemInterface.removeItemByUuid(this.roleId, this.uuid, 1, new TLogArg(LogReason.COST_EAT_CAKE)))
/*     */     {
/* 106 */       CakeManager.loggerError("PCUseCakeItem.processImp@ removeItemByUuid err!|roleId=%d|itemId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()), activityId });
/*     */       
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     recordEatCake(cakeMasterId, xCakeData);
/*     */     
/* 114 */     noticeClientLeftCount(activityCfg, cakeMasterId, xCakeData, awardModel);
/*     */     
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   private CakeData getAndInitCakeData(Integer activityId)
/*     */   {
/* 121 */     CakeData xCakeData = CakeManager.getXCakeDataIfAbsent(this.roleId, activityId.intValue());
/* 122 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 123 */     if (DateTimeUtils.needDailyReset(xCakeData.getUpdateeatetime(), curTime, 0))
/*     */     {
/* 125 */       xCakeData.setEateothercaketime(0);
/* 126 */       xCakeData.setEateselfcaketime(0);
/* 127 */       xCakeData.setUpdateeatetime(curTime);
/*     */     }
/* 129 */     return xCakeData;
/*     */   }
/*     */   
/*     */   long getCakeMasterId(BasicItem basicItem)
/*     */   {
/* 134 */     Integer targetRoleIdHigh = basicItem.getExtra(ItemStoreEnum.CAKE_MAKER_ID_HIGH);
/* 135 */     Integer targetRoleIdLow = basicItem.getExtra(ItemStoreEnum.CAKE_MAKER_ID_LOW);
/* 136 */     if ((targetRoleIdHigh == null) || (targetRoleIdLow == null))
/*     */     {
/* 138 */       return -1L;
/*     */     }
/* 140 */     return CommonUtils.getLong(targetRoleIdHigh.intValue(), targetRoleIdLow.intValue());
/*     */   }
/*     */   
/*     */ 
/*     */   private void noticeClientLeftCount(SCakeActivityCfg activityCfg, long cakeMasterId, CakeData xCakeData, AwardModel awardModel)
/*     */   {
/* 146 */     int leftCount = 0;
/* 147 */     int belongType = 1;
/* 148 */     if (cakeMasterId == this.roleId)
/*     */     {
/* 150 */       leftCount = activityCfg.useSelfCakeCountMax - xCakeData.getEateselfcaketime();
/*     */     }
/*     */     else
/*     */     {
/* 154 */       leftCount = activityCfg.useOtherCakeCountMax - xCakeData.getEateothercaketime();
/* 155 */       belongType = 2;
/*     */     }
/* 157 */     SGetCakeAward p = new SGetCakeAward();
/* 158 */     AwardInterface.fillAwardBean(p.awardbean, awardModel);
/* 159 */     p.belongtype = belongType;
/* 160 */     p.leftnum = leftCount;
/* 161 */     OnlineManager.getInstance().send(this.roleId, p);
/*     */   }
/*     */   
/*     */   private void recordEatCake(long cakeMasterId, CakeData xCakeData)
/*     */   {
/* 166 */     if (cakeMasterId == this.roleId)
/*     */     {
/* 168 */       xCakeData.setEateselfcaketime(xCakeData.getEateselfcaketime() + 1);
/*     */     }
/*     */     else
/*     */     {
/* 172 */       xCakeData.setEateothercaketime(xCakeData.getEateothercaketime() + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean checkUseCount(SCakeActivityCfg activityCfg, long cakeMasterId, CakeData xCakeData)
/*     */   {
/* 178 */     if (cakeMasterId == this.roleId)
/*     */     {
/* 180 */       if (activityCfg.useSelfCakeCountMax <= xCakeData.getEateselfcaketime())
/*     */       {
/* 182 */         CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), false, 20, new String[0]);
/* 183 */         return false;
/*     */       }
/* 185 */       return true;
/*     */     }
/* 187 */     if (activityCfg.useOtherCakeCountMax <= xCakeData.getEateothercaketime())
/*     */     {
/* 189 */       CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), false, 21, new String[0]);
/* 190 */       return false;
/*     */     }
/* 192 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PCUseCakeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
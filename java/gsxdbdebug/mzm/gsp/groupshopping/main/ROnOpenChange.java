/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*     */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*     */ import mzm.gsp.open.event.OpenChangeRunnable;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ public class ROnOpenChange extends OpenChangeRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  23 */     int activityId = GroupShoppingManager.currentActivityId;
/*  24 */     if (activityId == 0) {
/*  25 */       return;
/*     */     }
/*  27 */     if (((OpenChangeComplexArg)this.arg).getType() == 504)
/*     */     {
/*  29 */       if (((OpenChangeComplexArg)this.arg).isOpen())
/*     */       {
/*  31 */         if (OpenInterface.getOpenStatus(507)) {
/*  32 */           tryRestartCancelledBigGroupShopping(activityId);
/*     */         }
/*     */       }
/*     */       else {
/*  36 */         if (OpenInterface.getOpenStatus(505))
/*  37 */           tryCloseAllIncompletedSmallGroupShopping(activityId);
/*  38 */         if (OpenInterface.getOpenStatus(507)) {
/*  39 */           tryCloseAllIncompletedBigGroupShopping(activityId);
/*     */         }
/*     */       }
/*  42 */     } else if (((OpenChangeComplexArg)this.arg).getType() == 507)
/*     */     {
/*  44 */       if (((OpenChangeComplexArg)this.arg).isOpen())
/*     */       {
/*  46 */         if (OpenInterface.getOpenStatus(504)) {
/*  47 */           tryRestartCancelledBigGroupShopping(activityId);
/*     */         }
/*     */         
/*     */       }
/*  51 */       else if (OpenInterface.getOpenStatus(504)) {
/*  52 */         tryCloseAllIncompletedBigGroupShopping(activityId);
/*     */       }
/*     */     }
/*  55 */     else if (((OpenChangeComplexArg)this.arg).getType() == 505)
/*     */     {
/*  57 */       if (!((OpenChangeComplexArg)this.arg).isOpen())
/*     */       {
/*  59 */         if (OpenInterface.getOpenStatus(504))
/*  60 */           tryCloseAllIncompletedSmallGroupShopping(activityId);
/*     */       }
/*     */     }
/*  63 */     GroupShoppingLogger.info("ROnOpenChange.process()@done|type=%d|isopen=%d", new Object[] { Integer.valueOf(((OpenChangeComplexArg)this.arg).getType()), Integer.valueOf(((OpenChangeComplexArg)this.arg).isOpen() ? 1 : 0) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tryCloseAllIncompletedBigGroupShopping(final int activityId)
/*     */   {
/*  71 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  77 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(activityId);
/*  78 */         if (GroupShoppingManager.currentActivityId == 0)
/*  79 */           return false;
/*  80 */         if (xGroupShoppingInfo == null) {
/*  81 */           return false;
/*     */         }
/*  83 */         for (BigGroupShoppingItemInfo xBigGroupShoppingItemInfo : xGroupShoppingInfo.getBig_group_infos().values())
/*     */         {
/*  85 */           long groupId = xBigGroupShoppingItemInfo.getGroup_id();
/*  86 */           if (groupId != 0L)
/*     */           {
/*     */ 
/*  89 */             ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(Long.valueOf(groupId));
/*  90 */             if ((xShoppingGroupInfo != null) && (xShoppingGroupInfo.getStatus() == 0))
/*     */             {
/*     */ 
/*  93 */               NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, groupId, true, true, false));
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*  98 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tryCloseAllIncompletedSmallGroupShopping(final int activityId)
/*     */   {
/* 108 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 114 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(activityId);
/* 115 */         if (GroupShoppingManager.currentActivityId == 0)
/* 116 */           return false;
/* 117 */         if (xGroupShoppingInfo == null) {
/* 118 */           return false;
/*     */         }
/*     */         
/* 121 */         for (Long groupId : xGroupShoppingInfo.getIncompleted_small_groups()) {
/* 122 */           NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, groupId.longValue(), true, true, false));
/*     */         }
/* 124 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tryRestartCancelledBigGroupShopping(final int activityId)
/*     */   {
/* 134 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 140 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(activityId);
/* 141 */         if (GroupShoppingManager.currentActivityId == 0)
/* 142 */           return false;
/* 143 */         if (xGroupShoppingInfo == null)
/* 144 */           return false;
/* 145 */         long now = DateTimeUtils.getCurrTimeInMillis();
/* 146 */         Calendar calendar = DateTimeUtils.getCalendar();
/*     */         
/* 148 */         for (Map.Entry<Integer, BigGroupShoppingItemInfo> entry : xGroupShoppingInfo.getBig_group_infos().entrySet())
/*     */         {
/* 150 */           long groupId = ((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id();
/* 151 */           if (groupId != 0L)
/*     */           {
/* 153 */             Integer status = Shopping_group_info.selectStatus(Long.valueOf(groupId));
/* 154 */             if ((status != null) && (status.intValue() == 3))
/*     */             {
/* 156 */               SBigGroupShoppingItemCfg groupShoppingItemCfg = SBigGroupShoppingItemCfg.get(((Integer)entry.getKey()).intValue());
/* 157 */               if (groupShoppingItemCfg != null)
/*     */               {
/* 159 */                 STimeLimitCommonCfg timeLimitCfg = STimeLimitCommonCfg.get(groupShoppingItemCfg.timeLimitCfgId);
/* 160 */                 if (timeLimitCfg != null)
/*     */                 {
/* 162 */                   calendar.set(timeLimitCfg.endYear, timeLimitCfg.endMonth - 1, timeLimitCfg.endDay, timeLimitCfg.endHour, timeLimitCfg.endMinute);
/*     */                   
/* 164 */                   if (now < calendar.getTimeInMillis())
/* 165 */                     NoneRealTimeTaskManager.getInstance().addTask(new PCreateBigShoppingGroup(activityId, ((Integer)entry.getKey()).intValue(), true));
/*     */                 }
/*     */               }
/*     */             } } }
/* 169 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
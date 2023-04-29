/*    */ package mzm.gsp.groupshopping.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Calendar;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*    */ import mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.BigGroupShoppingItemInfo;
/*    */ import xbean.GroupShoppingInfo;
/*    */ import xbean.ShoppingGroupInfo;
/*    */ import xtable.Shopping_group_info;
/*    */ 
/*    */ public class GroupShoppingModule implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 23 */     ActivityInterface.registerActivityByLogicType(126, new GroupShoppingActivityHandler());
/*    */     
/* 25 */     checkAndCleanUnclosedGroupShoppingData();
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void checkAndCleanUnclosedGroupShoppingData()
/*    */   {
/* 53 */     List<Integer> activityIds = new ArrayList();
/* 54 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 55 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 56 */     for (Integer activityId : GroupShoppingActivityCfg.getAll().keySet())
/*    */     {
/* 58 */       SActivityCfg activityCfg = SActivityCfg.get(activityId.intValue());
/* 59 */       if (activityCfg != null)
/*    */       {
/* 61 */         STimeLimitCommonCfg timeLimitCfg = STimeLimitCommonCfg.get(activityCfg.activityLimitTimeid);
/* 62 */         if (timeLimitCfg != null)
/*    */         {
/* 64 */           calendar.set(timeLimitCfg.endYear, timeLimitCfg.endMonth - 1, timeLimitCfg.endDay, timeLimitCfg.endHour, timeLimitCfg.endMinute);
/*    */           
/* 66 */           if (calendar.getTimeInMillis() < now)
/* 67 */             activityIds.add(activityId);
/*    */         }
/*    */       }
/*    */     }
/* 71 */     for (final Integer activityId : activityIds)
/*    */     {
/* 73 */       NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 78 */           GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(activityId.intValue());
/* 79 */           if (xGroupShoppingInfo == null) {
/* 80 */             return false;
/*    */           }
/*    */           
/*    */ 
/* 84 */           for (BigGroupShoppingItemInfo xBigGroupShoppingItemInfo : xGroupShoppingInfo.getBig_group_infos().values())
/*    */           {
/* 86 */             long groupId = xBigGroupShoppingItemInfo.getGroup_id();
/* 87 */             if (groupId != 0L)
/*    */             {
/* 89 */               ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(Long.valueOf(groupId));
/* 90 */               if (xShoppingGroupInfo == null)
/*    */               {
/* 92 */                 xBigGroupShoppingItemInfo.setGroup_id(0L);
/*    */               }
/* 94 */               else if (xShoppingGroupInfo.getStatus() == 0)
/*    */               {
/* 96 */                 NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId.intValue(), groupId, false, false, false));
/*    */               }
/*    */             }
/*    */           }
/*    */           
/*    */ 
/*    */ 
/* :3 */           for (Long groupId : xGroupShoppingInfo.getIncompleted_small_groups()) {
/* :4 */             NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId.intValue(), groupId.longValue(), false, false, false));
/*    */           }
/*    */           
/* :7 */           return true;
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
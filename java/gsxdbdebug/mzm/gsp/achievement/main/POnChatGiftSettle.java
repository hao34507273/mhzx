/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractTwoCondAccumulate.Context;
/*    */ import mzm.gsp.chatgift.event.ChatGiftSettleArg;
/*    */ import mzm.gsp.chatgift.event.ChatGiftSettleProcedure;
/*    */ 
/*    */ public class POnChatGiftSettle extends ChatGiftSettleProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (((ChatGiftSettleArg)this.arg).roleMoneyNums.isEmpty())
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 22 */     Set<Long> bestLuckRoles = new HashSet();
/* 23 */     int bestLuckAmount = 0;
/* 24 */     Set<Long> worstLuckRoles = new HashSet();
/* 25 */     int worstLuckAmount = Integer.MAX_VALUE;
/* 26 */     for (Map.Entry<Long, Integer> entry : ((ChatGiftSettleArg)this.arg).roleMoneyNums.entrySet())
/*    */     {
/* 28 */       int moneyAmount = ((Integer)entry.getValue()).intValue();
/* 29 */       if (moneyAmount > bestLuckAmount)
/*    */       {
/* 31 */         bestLuckAmount = moneyAmount;
/* 32 */         bestLuckRoles.clear();
/* 33 */         bestLuckRoles.add(entry.getKey());
/*    */       }
/* 35 */       else if (moneyAmount == bestLuckAmount)
/*    */       {
/* 37 */         bestLuckRoles.add(entry.getKey());
/*    */       }
/*    */       
/* 40 */       if (moneyAmount < worstLuckAmount)
/*    */       {
/* 42 */         worstLuckAmount = moneyAmount;
/* 43 */         worstLuckRoles.clear();
/* 44 */         worstLuckRoles.add(entry.getKey());
/*    */       }
/* 46 */       else if (moneyAmount == worstLuckAmount)
/*    */       {
/* 48 */         worstLuckRoles.add(entry.getKey());
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 53 */     Set<Long> roleIds = new HashSet();
/* 54 */     roleIds.addAll(bestLuckRoles);
/* 55 */     roleIds.addAll(worstLuckRoles);
/* 56 */     AchievementManager.collectLocks(roleIds);
/*    */     
/* 58 */     AbstractTwoCondAccumulate.Context ctx = new AbstractTwoCondAccumulate.Context(((ChatGiftSettleArg)this.arg).channelType, ((ChatGiftSettleArg)this.arg).giftMoneyType, 1);
/*    */     
/* 60 */     for (Iterator i$ = bestLuckRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 62 */       AchievementManager.updateGoalTypeState(roleId, 1205, ctx, "POnChatGiftSettle.processImp@handle CHAT_GIFT_BEST_LUCK_COUNT finish");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 67 */     for (Iterator i$ = worstLuckRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 69 */       AchievementManager.updateGoalTypeState(roleId, 1206, ctx, "POnChatGiftSettle.processImp@handle CHAT_GIFT_WORST_LUCK_COUNT finish");
/*    */     }
/*    */     
/*    */ 
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChatGiftSettle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
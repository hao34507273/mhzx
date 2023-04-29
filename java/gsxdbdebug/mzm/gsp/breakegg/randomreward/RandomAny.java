/*    */ package mzm.gsp.breakegg.randomreward;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.nationalholiday.confbean.SRewardRandomCfg;
/*    */ import mzm.gsp.nationalholiday.confbean.SShowRewardRandomCfg;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomAny
/*    */   extends AbstractRandomPolicy<IRandomPolicyArgs>
/*    */ {
/*    */   public RandomAny(int groupId)
/*    */   {
/* 21 */     super(groupId, SingletonArgs.DEFAULT.getArgs());
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Integer> getRewardInfoIds(int number, boolean forShow)
/*    */   {
/* 27 */     List<Integer> randomResultList = new ArrayList(number);
/*    */     
/* 29 */     if (forShow)
/*    */     {
/* 31 */       SShowRewardRandomCfg sShowRewardRandomCfg = SShowRewardRandomCfg.get(this.groupId);
/*    */       
/* 33 */       if (sShowRewardRandomCfg == null)
/*    */       {
/* 35 */         return randomResultList;
/*    */       }
/*    */       
/*    */       int randomResult;
/* 39 */       for (int i = 0; i < number; i++)
/*    */       {
/* 41 */         randomResult = Xdb.random().nextInt(sShowRewardRandomCfg.sumWight);
/* 42 */         for (Map.Entry<Integer, Integer> entry : sShowRewardRandomCfg.cfgId2randomWight.entrySet())
/*    */         {
/* 44 */           if (randomResult < ((Integer)entry.getValue()).intValue())
/*    */           {
/* 46 */             randomResultList.add(entry.getKey());
/* 47 */             break;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 54 */       SRewardRandomCfg sRewardRandomCfg = SRewardRandomCfg.get(this.groupId);
/*    */       
/*    */       int randomResult;
/* 57 */       for (int i = 0; i < number; i++)
/*    */       {
/* 59 */         randomResult = Xdb.random().nextInt(sRewardRandomCfg.sumWight);
/* 60 */         for (Map.Entry<Integer, Integer> entry : sRewardRandomCfg.cfgId2randomWight.entrySet())
/*    */         {
/* 62 */           if (randomResult < ((Integer)entry.getValue()).intValue())
/*    */           {
/* 64 */             randomResultList.add(entry.getKey());
/* 65 */             break;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 70 */     return randomResultList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\randomreward\RandomAny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
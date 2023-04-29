/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.personal.confbean.SNSConsts;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.PersonalInfo;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((RoleLevelUpArg)this.arg).newLevel < SNSConsts.getInstance().OPEN_LEVEL)
/*    */     {
/* 15 */       return true;
/*    */     }
/*    */     
/* 18 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 19 */     if (xPersonalInfo == null)
/*    */     {
/* 21 */       return true;
/*    */     }
/* 23 */     if (xPersonalInfo.getAdverts().isEmpty())
/*    */     {
/* 25 */       return true;
/*    */     }
/*    */     
/* 28 */     for (Map.Entry<Integer, Long> entry : xPersonalInfo.getAdverts().entrySet())
/*    */     {
/* 30 */       long advertId = ((Long)entry.getValue()).longValue();
/* 31 */       int advertType = ((Integer)entry.getKey()).intValue();
/* 32 */       UpdateCacheOneByOne.getInstance().add(new ROnLevelChange(advertType, advertId, ((RoleLevelUpArg)this.arg).oldLevel, ((RoleLevelUpArg)this.arg).newLevel));
/*    */     }
/* 34 */     UpdateCacheOneByOne.getInstance().add(new RUpdateLevel(((RoleLevelUpArg)this.arg).roleId, ((RoleLevelUpArg)this.arg).newLevel));
/*    */     
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   private static class ROnLevelChange extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final int advertType;
/*    */     private final long advertId;
/*    */     private final int oldLevel;
/*    */     private final int newLevel;
/*    */     
/*    */     public ROnLevelChange(int advertType, long advertId, int oldLevel, int newLevel)
/*    */     {
/* 48 */       this.advertType = advertType;
/* 49 */       this.advertId = advertId;
/* 50 */       this.oldLevel = oldLevel;
/* 51 */       this.newLevel = newLevel;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 57 */       FilterInfo oldFilterInfo = SNSIndexManager.getInstance().getFilteInfo(this.advertId, this.advertType);
/* 58 */       if (oldFilterInfo == null)
/*    */       {
/* 60 */         return;
/*    */       }
/*    */       
/* 63 */       SNSIndexManager.getInstance().levelChange(this.advertType, this.advertId, this.oldLevel, this.newLevel);
/*    */       
/* 65 */       AdvertChart advertChart = AdvertChartCache.getInstance().get(this.advertId);
/* 66 */       if (advertChart != null)
/*    */       {
/* 68 */         FilterInfo newFilterInfo = new FilterInfo(oldFilterInfo.advertType, this.newLevel, oldFilterInfo.gender, oldFilterInfo.province);
/*    */         
/* 70 */         SNSRankManager.getInstance().filterChanged(this.advertId, oldFilterInfo, newFilterInfo, advertChart);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private static class RUpdateLevel extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     private final int newLevel;
/*    */     
/*    */     public RUpdateLevel(long roleId, int newLevel)
/*    */     {
/* 82 */       this.roleId = roleId;
/* 83 */       this.newLevel = newLevel;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 89 */       AdvertDataCache.getInstance().roleLevelChange(this.roleId, this.newLevel);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
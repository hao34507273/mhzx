/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class AwardFix extends GiftAwardType
/*    */ {
/*    */   public AwardFix(String userId, long roleId, int usetType)
/*    */   {
/* 14 */     super(userId, roleId, usetType);
/*    */   }
/*    */   
/*    */ 
/*    */   boolean doAward()
/*    */   {
/* 20 */     int awardId = getGiftId();
/* 21 */     if (awardId <= 0)
/*    */     {
/*    */ 
/* 24 */       return true;
/*    */     }
/* 26 */     AwardModel awardModel = AwardInterface.awardFixAward(awardId, getUserId(), getRoleId(), true, true, new AwardReason(LogReason.COMPLETE_CLIENT_AWARD, getUseType()));
/*    */     
/* 28 */     if (awardModel == null)
/*    */     {
/* 30 */       GameServer.logger().error(String.format("[gift]AwardFix.doAward@ give fix award fail!|roleId=%d|usetType=%d|mailId=%d", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(getUseType()), Integer.valueOf(getGiftId()) }));
/*    */       
/*    */ 
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   int getAwardType()
/*    */   {
/* 41 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\AwardFix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
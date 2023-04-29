/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.giftaward.confbean.SClientGetGiftCfg;
/*    */ 
/*    */ public abstract class GiftAwardType
/*    */ {
/*    */   private final String userId;
/*    */   private final long roleId;
/*    */   private final int useType;
/*    */   private int global;
/*    */   private int giftId;
/*    */   
/*    */   public GiftAwardType(String userId, long roleId, int usetType)
/*    */   {
/* 16 */     this.userId = userId;
/* 17 */     this.roleId = roleId;
/* 18 */     this.useType = usetType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean giveAward()
/*    */   {
/* 28 */     if (!init())
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     return doAward();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean init()
/*    */   {
/* 42 */     SClientGetGiftCfg cfg = SClientGetGiftCfg.get(this.useType);
/* 43 */     if (cfg == null)
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[gift]GiftAwardType.giveAward@ SOnlyOneGiftCfg not exist!|roleId=%d|useType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType) }));
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/* 50 */     this.global = cfg.global;
/* 51 */     this.giftId = cfg.giftId;
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   abstract boolean doAward();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   abstract int getAwardType();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   int getGlobal()
/*    */   {
/* 71 */     return this.global;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   int getGiftId()
/*    */   {
/* 81 */     return this.giftId;
/*    */   }
/*    */   
/*    */   long getRoleId()
/*    */   {
/* 86 */     return this.roleId;
/*    */   }
/*    */   
/*    */   int getUseType()
/*    */   {
/* 91 */     return this.useType;
/*    */   }
/*    */   
/*    */   String getUserId()
/*    */   {
/* 96 */     return this.userId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\GiftAwardType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
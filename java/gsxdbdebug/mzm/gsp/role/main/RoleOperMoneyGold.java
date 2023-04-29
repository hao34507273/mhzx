/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.event.BasicEvent;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.role.event.GoldValueChange;
/*    */ import mzm.gsp.role.event.MoneyChangeArg;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.yuanbao.main.CurrencyType;
/*    */ import xbean.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleOperMoneyGold
/*    */   extends RoleOperMoney
/*    */ {
/*    */   public RoleOperMoneyGold(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*    */   {
/* 24 */     super(roleId, addValue, arg, withinMax);
/*    */   }
/*    */   
/*    */   public RoleOperMoneyGold(long roleId, long changeValue, TLogArg arg)
/*    */   {
/* 29 */     super(roleId, changeValue, arg);
/*    */   }
/*    */   
/*    */ 
/*    */   public long getRoleOwnMoney(Properties xProperties)
/*    */   {
/* 35 */     return xProperties.getGold();
/*    */   }
/*    */   
/*    */ 
/*    */   public long getRoleCanOwnMoneyMax()
/*    */   {
/* 41 */     return AwardInterface.getMoneyOwnMax(2);
/*    */   }
/*    */   
/*    */ 
/*    */   public int reachMaxErrCode()
/*    */   {
/* 47 */     return 11;
/*    */   }
/*    */   
/*    */ 
/*    */   public long setXMoneyValue(Properties xProperties, long value)
/*    */   {
/* 53 */     RoleModuleManager.setGold(getRoleId(), xProperties, value, canCutToNegative());
/* 54 */     return xProperties.getGold();
/*    */   }
/*    */   
/*    */ 
/*    */   public CurrencyType getCurrencyType()
/*    */   {
/* 60 */     return CurrencyType.CURRENCY_GOLD;
/*    */   }
/*    */   
/*    */ 
/*    */   boolean canCutToNegative()
/*    */   {
/* 66 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   BasicEvent<MoneyChangeArg> getEvent()
/*    */   {
/* 72 */     return new GoldValueChange();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleOperMoneyGold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
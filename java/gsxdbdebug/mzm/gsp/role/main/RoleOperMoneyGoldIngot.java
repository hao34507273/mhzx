/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.event.BasicEvent;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.role.event.GoldIngotValueChange;
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
/*    */ public class RoleOperMoneyGoldIngot
/*    */   extends RoleOperMoney
/*    */ {
/*    */   public RoleOperMoneyGoldIngot(long roleId, long changeValue, TLogArg arg, boolean withinMax)
/*    */   {
/* 24 */     super(roleId, changeValue, arg, withinMax);
/*    */   }
/*    */   
/*    */   public RoleOperMoneyGoldIngot(long roleId, long changeValue, TLogArg arg)
/*    */   {
/* 29 */     super(roleId, changeValue, arg);
/*    */   }
/*    */   
/*    */ 
/*    */   public long getRoleOwnMoney(Properties xProperties)
/*    */   {
/* 35 */     return xProperties.getGoldingot();
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
/* 53 */     xProperties.setGoldingot(value);
/* 54 */     return xProperties.getGoldingot();
/*    */   }
/*    */   
/*    */ 
/*    */   public CurrencyType getCurrencyType()
/*    */   {
/* 60 */     return CurrencyType.CURRENCY_GOLD_INGOT;
/*    */   }
/*    */   
/*    */ 
/*    */   BasicEvent<MoneyChangeArg> getEvent()
/*    */   {
/* 66 */     return new GoldIngotValueChange();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleOperMoneyGoldIngot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
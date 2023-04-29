/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Role2DoubleItemInfo;
/*    */ 
/*    */ public class PGM_GetDoubleItemTimes extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetDoubleItemTimes(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Role2DoubleItemInfo xRole2DoubleItemInfo = xtable.Role2doubleitem.get(Long.valueOf(this.roleId));
/* 19 */     if (xRole2DoubleItemInfo == null)
/*    */     {
/* 21 */       GmManager.getInstance().sendResultToGM(this.roleId, "今日的双倍触发次数为0次,今日的保底触发次数为0次,累计的保持计数0次");
/* 22 */       return true;
/*    */     }
/*    */     
/* 25 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("今日的双倍触发次数为%d次,今日的保底触发次数为%d次,累计的保持计数%d次", new Object[] { Integer.valueOf(xRole2DoubleItemInfo.getToday_trigger_times()), Integer.valueOf(xRole2DoubleItemInfo.getToday_guarantee_times()), Integer.valueOf(xRole2DoubleItemInfo.getGuarantee_not_trigger_times()) }));
/*    */     
/*    */ 
/*    */ 
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_GetDoubleItemTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
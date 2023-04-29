/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaoTuInterface
/*    */ {
/*    */   public static boolean needBulletin(int itemId)
/*    */   {
/* 13 */     return ItemBulletinInterface.needBulletin(itemId);
/*    */   }
/*    */   
/*    */   public static int getBaotuActivityid()
/*    */   {
/* 18 */     return BaoTuActivityCfgConsts.getInstance().ACTIVITYID;
/*    */   }
/*    */   
/*    */   public static boolean isBaoBaoController(int controllerId)
/*    */   {
/* 23 */     return BaotuManager.isBaoBaoController(controllerId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean autoFinishBaoTu(String userId, long roleId)
/*    */   {
/* 35 */     return BaotuManager.autoFinishBaoTu(userId, roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\BaoTuInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
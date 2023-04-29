/*    */ package mzm.gsp.skylantern.main;
/*    */ 
/*    */ import mzm.gsp.greetingcard.GreetingCardData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkyLanternInterface
/*    */ {
/*    */   public static boolean isNearByPos(long roleid, int mapCfgid, int x, int y)
/*    */   {
/* 19 */     return SkyLanternManager.isNearByPos(roleid, mapCfgid, x, y);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int sendGreetingCardWithoutBagItem(long roleId, int itemCfgId, int channel, GreetingCardData data)
/*    */   {
/* 36 */     return SkyLanternManager.sendGreetingCardWithoutBagItem(roleId, itemCfgId, channel, data);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skylantern\main\SkyLanternInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
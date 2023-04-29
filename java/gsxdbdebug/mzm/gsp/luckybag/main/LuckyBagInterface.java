/*   */ package mzm.gsp.luckybag.main;
/*   */ 
/*   */ import java.util.Map;
/*   */ 
/*   */ public class LuckyBagInterface
/*   */ {
/*   */   public static void worldBroadcast(long roleid, Map<Integer, Integer> itemMap)
/*   */   {
/* 9 */     LuckyBagManager.worldBroadcast(roleid, 0, itemMap);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\LuckyBagInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public class MenpaiPVPInterface
/*    */ {
/*    */   public static int getMenpaiChampionNpc(int menpai)
/*    */   {
/* 20 */     return MenpaiPVPConfigManager.getInstance().getMenpaiChampionNpc(menpai);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<Integer> getAllMenpaiChampionNpcs()
/*    */   {
/* 29 */     return MenpaiPVPConfigManager.getInstance().getAllMenpaiChampionNpc();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getMenpaiChampionAppellation(int menpai)
/*    */   {
/* 40 */     return MenpaiPVPConfigManager.getInstance().getMenpaiAppellation(menpai);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
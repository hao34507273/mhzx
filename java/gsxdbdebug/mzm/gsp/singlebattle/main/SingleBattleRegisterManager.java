/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ public class SingleBattleRegisterManager
/*    */ {
/*  9 */   private static Map<Integer, EachPlayTypeHandler> playType2Handler = new ConcurrentHashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void registerPlayHandler(int playType, EachPlayTypeHandler handler)
/*    */   {
/* 21 */     if (handler == null)
/*    */     {
/* 23 */       throw new RuntimeException(String.format("[singlebattle]SingleBattleRegisterManager.registerPlayHandler@ EachPlayTypeHandler is null!|playType=%d", new Object[] { Integer.valueOf(playType) }));
/*    */     }
/*    */     
/*    */ 
/* 27 */     if (playType2Handler.containsKey(Integer.valueOf(playType)))
/*    */     {
/* 29 */       throw new RuntimeException(String.format("[singlebattle]SingleBattleRegisterManager.registerPlayHandler@ duplicate register!|playType=%d", new Object[] { Integer.valueOf(playType) }));
/*    */     }
/*    */     
/*    */ 
/* 33 */     playType2Handler.put(Integer.valueOf(playType), handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static EachPlayTypeHandler getEachPlayTypeHandler(int playType)
/*    */   {
/* 45 */     return (EachPlayTypeHandler)playType2Handler.get(Integer.valueOf(playType));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleRegisterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
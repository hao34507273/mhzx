/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class OnlineRoleSizeExtendMap<K, V> extends java.util.LinkedHashMap<K, V>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
/*    */   {
/* 11 */     if (size() > LoginManager.getInstance().getMaxPlayerNumber() * 2 + LoginManager.getInstance().getMaxQueueSize())
/*    */     {
/* 13 */       return true;
/*    */     }
/* 15 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineRoleSizeExtendMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
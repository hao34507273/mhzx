/*    */ package mzm.gsp.multioccupation.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.MultiOccupation;
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
/*    */ 
/*    */ public class MultiOccupInterface
/*    */ {
/*    */   public static boolean hasOccupation(long roleid, int occupation, boolean remainLock)
/*    */   {
/* 25 */     MultiOccupation xMultiOccup = MultiOccupManager.getXMultiOccup(roleid, remainLock);
/* 26 */     if (xMultiOccup != null) {
/* 27 */       return MultiOccupManager.hasOccup(xMultiOccup, occupation);
/*    */     }
/* 29 */     int currentOccup = RoleInterface.getOccupationId(roleid);
/* 30 */     return occupation == currentOccup;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getOccupCount(long roleid, boolean remainLock)
/*    */   {
/* 42 */     MultiOccupation xMultiOccup = MultiOccupManager.getXMultiOccup(roleid, remainLock);
/* 43 */     if (xMultiOccup == null)
/*    */     {
/* 45 */       return 1;
/*    */     }
/* 47 */     return xMultiOccup.getOccupations().size();
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
/*    */   public static List<Integer> getOccupList(long roleid, boolean remainLock)
/*    */   {
/* 60 */     List<Integer> occupList = new ArrayList();
/*    */     
/* 62 */     MultiOccupation xMultiOccup = MultiOccupManager.getXMultiOccup(roleid, remainLock);
/* 63 */     if (xMultiOccup != null) {
/* 64 */       occupList.addAll(xMultiOccup.getOccupations());
/*    */     }
/*    */     else
/*    */     {
/* 68 */       int currentOccup = RoleInterface.getOccupationId(roleid);
/* 69 */       occupList.add(Integer.valueOf(currentOccup));
/*    */     }
/* 71 */     return occupList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\MultiOccupInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
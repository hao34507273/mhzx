/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpaceBitMask
/*    */ {
/*    */   public static final int GROUND = 1;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final int SKY = 2;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final int ALL = 3;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isGroundValid(int spaceFlags)
/*    */   {
/* 31 */     return (spaceFlags & 0x1) == 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isSkyValid(int spaceFlags)
/*    */   {
/* 42 */     return (spaceFlags & 0x2) == 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\SpaceBitMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
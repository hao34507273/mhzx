/*     */ package mzm.gsp.map.main.scene;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SceneViewBitMask
/*     */ {
/*     */   public static final int BIT_MASK_NONE = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int BIT_MASK_CAN_SEE = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int BIT_MASK_ENTER_INTO_OTHERS_VIEW = 2;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int BIT_MASK_OTHERS_ENTER_INTO_MY_VIEW = 4;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int BIT_MASK_LEAVE_FROM_OTHERS_VIEW = 8;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int BIT_MASK_OTHERS_LEAVE_FROM_MY_VIEW = 16;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int BIT_MASK_MOVE_IN_OTHERS_VIEW = 32;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCanSee(int result)
/*     */   {
/*  53 */     return (result & 0x1) == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isEnterIntoOthersView(int result)
/*     */   {
/*  64 */     return (result & 0x2) == 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isOthersEnterIntoMyView(int result)
/*     */   {
/*  75 */     return (result & 0x4) == 4;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isLeaveFromOthersView(int result)
/*     */   {
/*  86 */     return (result & 0x8) == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isOthersLeaveFromMyView(int result)
/*     */   {
/*  97 */     return (result & 0x10) == 16;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMoveInOthersView(int result)
/*     */   {
/* 108 */     return (result & 0x20) == 32;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\SceneViewBitMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
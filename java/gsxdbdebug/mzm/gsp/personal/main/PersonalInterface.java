/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PersonalInterface
/*     */ {
/*     */   public static String getHeadImageURL(long roleId, boolean remainLock)
/*     */   {
/*  28 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getSign(long roleId, boolean remainLock)
/*     */   {
/*  42 */     return PersonalManager.getSign(roleId, remainLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getProvince(long roleId, boolean remainLock)
/*     */   {
/*  58 */     return PersonalManager.getProvince(roleId, remainLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCity(long roleId, boolean remainLock)
/*     */   {
/*  74 */     return PersonalManager.getCity(roleId, remainLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Long> getDesireMasters()
/*     */   {
/*  84 */     return SNSManager.getDesireMasters();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getPraisedNum(long roleid, boolean remainLock)
/*     */   {
/*  96 */     return PersonalManager.getPraisedNum(roleid, remainLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getBePraisedNum(long roleid, boolean remainLock)
/*     */   {
/* 108 */     return PersonalManager.getBePraisedNum(roleid, remainLock);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PersonalInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
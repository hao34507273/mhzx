/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.gsp.personal.main.AdvertChart;
/*    */ import mzm.gsp.personal.main.AdvertData;
/*    */ import mzm.gsp.personal.main.FilterInfo;
/*    */ import mzm.gsp.personal.main.RoleData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReleaseAdvertArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long advertId;
/*    */   public final AdvertData advertData;
/*    */   public final RoleData roleData;
/*    */   public final AdvertChart advertChart;
/*    */   public final FilterInfo filterInfo;
/*    */   
/*    */   public ReleaseAdvertArg(long roleId, long advertId, AdvertData advertData, RoleData roleData, AdvertChart advertChart, FilterInfo filterInfo)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.advertId = advertId;
/*    */     
/* 30 */     this.advertData = advertData;
/* 31 */     this.roleData = roleData;
/* 32 */     this.advertChart = advertChart;
/* 33 */     this.filterInfo = filterInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\ReleaseAdvertArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
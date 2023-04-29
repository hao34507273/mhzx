/*    */ package mzm.gsp.luckybag.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OpenLuckyBagArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int type;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int openNum;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public OpenLuckyBagArg(long roleid, int type, int openNum)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.type = type;
/* 27 */     this.openNum = openNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\event\OpenLuckyBagArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import jsonio.JsonStream;
/*    */ import mzm.gsp.addiction.pro.GameConfInfoRsp;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddictionCfgInfo
/*    */ {
/*    */   public GameConfInfoRsp rsp;
/*    */   
/*    */   public AddictionCfgInfo() {}
/*    */   
/*    */   public AddictionCfgInfo(GameConfInfoRsp rsp)
/*    */   {
/* 16 */     this.rsp = rsp;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 22 */     if (this.rsp == null)
/*    */     {
/* 24 */       return super.toString();
/*    */     }
/*    */     
/* 27 */     JsonStream js = new JsonStream();
/* 28 */     this.rsp.marshal(js);
/* 29 */     return js.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\AddictionCfgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
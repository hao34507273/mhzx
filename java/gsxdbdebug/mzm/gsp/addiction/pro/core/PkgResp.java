/*    */ package mzm.gsp.addiction.pro.core;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ public abstract class PkgResp<PkgBody extends JsonMarshal> implements JsonMarshal
/*    */ {
/*    */   public final CommRsp comm;
/*    */   public final PkgBody body;
/*    */   
/*    */   public PkgResp(CommRsp comm, PkgBody body)
/*    */   {
/* 13 */     this.comm = comm;
/* 14 */     this.body = body;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     JsonStream js = new JsonStream();
/* 21 */     marshal(js);
/* 22 */     return js.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\core\PkgResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
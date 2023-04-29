/*    */ package mzm.gsp.addiction.pro.core;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommRsp
/*    */   implements JsonMarshal
/*    */ {
/* 12 */   public int ret = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 17 */   public String err_msg = "ok";
/*    */   
/*    */ 
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 22 */     js.marshal("ret", Integer.valueOf(this.ret));
/* 23 */     js.marshal("err_msg", this.err_msg);
/* 24 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JsonMarshalException
/*    */   {
/* 30 */     this.ret = js.unmarshal_int("ret");
/* 31 */     this.err_msg = js.unmarshal_string("err_msg");
/* 32 */     return js;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\core\CommRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
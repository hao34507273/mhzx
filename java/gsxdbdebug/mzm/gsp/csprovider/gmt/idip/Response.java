/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Response
/*    */   implements JsonMarshal
/*    */ {
/* 12 */   public int retcode = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 17 */   public String msg = "ok";
/*    */   
/*    */ 
/*    */   public JsonMarshal data;
/*    */   
/*    */ 
/*    */ 
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 26 */     _js_.marshal("retcode", Integer.valueOf(this.retcode));
/* 27 */     _js_.marshal("msg", this.msg);
/* 28 */     if (this.data != null)
/*    */     {
/* 30 */       _js_.marshal("data", this.data);
/*    */     }
/* 32 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 37 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 43 */     JsonStream js = new JsonStream();
/* 44 */     marshal(js);
/* 45 */     return js.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
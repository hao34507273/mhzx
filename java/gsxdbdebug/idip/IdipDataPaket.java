/*    */ package idip;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
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
/*    */ public class IdipDataPaket
/*    */   implements JsonMarshal
/*    */ {
/*    */   public IdipHeader IdipHead;
/* 21 */   public String IdipBody = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 25 */     _js_.marshal("IdipHead", this.IdipHead);
/* 26 */     _js_.marshal("IdipBody", this.IdipBody);
/* 27 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 32 */     this.IdipHead = new IdipHeader();
/* 33 */     _js_.unmarshal("IdipHead", this.IdipHead);
/* 34 */     this.IdipBody = _js_.unmarshal_string("IdipBody");
/* 35 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IdipDataPaket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
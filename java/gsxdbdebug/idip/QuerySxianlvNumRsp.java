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
/*    */ public class QuerySxianlvNumRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public long XianLv = 0L;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 20 */     _js_.marshal("XianLv", Long.valueOf(this.XianLv));
/* 21 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 26 */     this.XianLv = _js_.unmarshal_long("XianLv");
/* 27 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QuerySxianlvNumRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
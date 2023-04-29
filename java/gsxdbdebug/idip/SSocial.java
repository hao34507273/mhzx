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
/*    */ public class SSocial
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public byte IsSworn = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public byte IsMarry = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public byte IsMaster = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 30 */     _js_.marshal("IsSworn", Byte.valueOf(this.IsSworn));
/* 31 */     _js_.marshal("IsMarry", Byte.valueOf(this.IsMarry));
/* 32 */     _js_.marshal("IsMaster", Byte.valueOf(this.IsMaster));
/* 33 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 38 */     this.IsSworn = _js_.unmarshal_byte("IsSworn");
/* 39 */     this.IsMarry = _js_.unmarshal_byte("IsMarry");
/* 40 */     this.IsMaster = _js_.unmarshal_byte("IsMaster");
/* 41 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\SSocial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
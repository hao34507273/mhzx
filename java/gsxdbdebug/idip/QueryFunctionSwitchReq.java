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
/*    */ public class QueryFunctionSwitchReq
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int AreaId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int Partition = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public byte PlatId = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 30 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 31 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 32 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 33 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 38 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 39 */     this.Partition = _js_.unmarshal_int("Partition");
/* 40 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 41 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryFunctionSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
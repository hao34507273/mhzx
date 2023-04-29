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
/*    */ public class ChannelSignLimitFunReq
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int AreaId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public byte PlatId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int Partition = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public String Channel = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public long Switch = 0L;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 40 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 41 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 42 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 43 */     _js_.marshal("Channel", this.Channel);
/* 44 */     _js_.marshal("Switch", Long.valueOf(this.Switch));
/* 45 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 50 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 51 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 52 */     this.Partition = _js_.unmarshal_int("Partition");
/* 53 */     this.Channel = _js_.unmarshal_string("Channel");
/* 54 */     this.Switch = _js_.unmarshal_long("Switch");
/* 55 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\ChannelSignLimitFunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
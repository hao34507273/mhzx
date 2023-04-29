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
/*    */ public class SysFunSwitchReq
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
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public long Switch = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public long moduleID = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public long FUNID = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public long parameter1 = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public long parameter2 = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public long parameter3 = 0L;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 60 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 61 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 62 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 63 */     _js_.marshal("Switch", Long.valueOf(this.Switch));
/* 64 */     _js_.marshal("moduleID", Long.valueOf(this.moduleID));
/* 65 */     _js_.marshal("FUNID", Long.valueOf(this.FUNID));
/* 66 */     _js_.marshal("parameter1", Long.valueOf(this.parameter1));
/* 67 */     _js_.marshal("parameter2", Long.valueOf(this.parameter2));
/* 68 */     _js_.marshal("parameter3", Long.valueOf(this.parameter3));
/* 69 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 74 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 75 */     this.Partition = _js_.unmarshal_int("Partition");
/* 76 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 77 */     this.Switch = _js_.unmarshal_long("Switch");
/* 78 */     this.moduleID = _js_.unmarshal_long("moduleID");
/* 79 */     this.FUNID = _js_.unmarshal_long("FUNID");
/* 80 */     this.parameter1 = _js_.unmarshal_long("parameter1");
/* 81 */     this.parameter2 = _js_.unmarshal_long("parameter2");
/* 82 */     this.parameter3 = _js_.unmarshal_long("parameter3");
/* 83 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\SysFunSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ public class IdipHeader
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int PacketLen = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int Cmdid = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int Seqid = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public String ServiceName = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public int SendTime = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public int Version = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public String Authenticate = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public int Result = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public String RetErrMsg = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 60 */     _js_.marshal("PacketLen", Integer.valueOf(this.PacketLen));
/* 61 */     _js_.marshal("Cmdid", Integer.valueOf(this.Cmdid));
/* 62 */     _js_.marshal("Seqid", Integer.valueOf(this.Seqid));
/* 63 */     _js_.marshal("ServiceName", this.ServiceName);
/* 64 */     _js_.marshal("SendTime", Integer.valueOf(this.SendTime));
/* 65 */     _js_.marshal("Version", Integer.valueOf(this.Version));
/* 66 */     _js_.marshal("Authenticate", this.Authenticate);
/* 67 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 68 */     _js_.marshal("RetErrMsg", this.RetErrMsg);
/* 69 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 74 */     this.PacketLen = _js_.unmarshal_int("PacketLen");
/* 75 */     this.Cmdid = _js_.unmarshal_int("Cmdid");
/* 76 */     this.Seqid = _js_.unmarshal_int("Seqid");
/* 77 */     this.ServiceName = _js_.unmarshal_string("ServiceName");
/* 78 */     this.SendTime = _js_.unmarshal_int("SendTime");
/* 79 */     this.Version = _js_.unmarshal_int("Version");
/* 80 */     this.Authenticate = _js_.unmarshal_string("Authenticate");
/* 81 */     this.Result = _js_.unmarshal_int("Result");
/* 82 */     this.RetErrMsg = _js_.unmarshal_string("RetErrMsg");
/* 83 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IdipHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
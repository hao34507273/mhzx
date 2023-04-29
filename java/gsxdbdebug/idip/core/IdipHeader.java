/*     */ package idip.core;
/*     */ 
/*     */ import jsonio.JsonMarshal;
/*     */ import jsonio.JsonMarshalException;
/*     */ import jsonio.JsonStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IdipHeader
/*     */   implements JsonMarshal
/*     */ {
/*  15 */   public int PacketLen = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  20 */   public int Cmdid = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  25 */   public int Seqid = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  30 */   public String ServiceName = "MHZX";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  35 */   public int SendTime = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  40 */   public int Version = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  45 */   public String Authenticate = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  52 */   public int Result = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  57 */   public String RetErrMsg = "ok";
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/*  61 */     _js_.marshal("PacketLen", Integer.valueOf(this.PacketLen));
/*  62 */     _js_.marshal("Cmdid", Integer.valueOf(this.Cmdid));
/*  63 */     _js_.marshal("Seqid", Integer.valueOf(this.Seqid));
/*  64 */     _js_.marshal("ServiceName", this.ServiceName);
/*  65 */     _js_.marshal("SendTime", Integer.valueOf(this.SendTime));
/*  66 */     _js_.marshal("Version", Integer.valueOf(this.Version));
/*  67 */     _js_.marshal("Authenticate", this.Authenticate);
/*  68 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/*  69 */     _js_.marshal("RetErrMsg", this.RetErrMsg);
/*  70 */     return _js_;
/*     */   }
/*     */   
/*     */ 
/*     */   public JsonStream unmarshal(JsonStream _js_)
/*     */     throws JsonMarshalException
/*     */   {
/*  77 */     this.Cmdid = _js_.unmarshal_int("Cmdid");
/*  78 */     this.Seqid = _js_.unmarshal_int("Seqid");
/*  79 */     this.ServiceName = _js_.unmarshal_string("ServiceName");
/*  80 */     this.SendTime = _js_.unmarshal_int("SendTime");
/*  81 */     this.Version = _js_.unmarshal_int("Version");
/*  82 */     this.Authenticate = _js_.unmarshal_string("Authenticate");
/*  83 */     this.Result = _js_.unmarshal_int("Result");
/*  84 */     this.RetErrMsg = _js_.unmarshal_string("RetErrMsg");
/*  85 */     return _js_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  91 */     StringBuffer sb = new StringBuffer();
/*  92 */     sb.append("{").append("\"PacketLen\":").append(this.PacketLen).append(",");
/*  93 */     sb.append("\"Cmdid\":").append(this.Cmdid).append(",");
/*  94 */     sb.append("\"Seqid\":").append(this.Seqid).append(",");
/*  95 */     sb.append("\"ServiceName\":\"").append(this.ServiceName).append("\",");
/*  96 */     sb.append("\"SendTime\":").append(this.SendTime).append(",");
/*  97 */     sb.append("\"Version\":").append(this.Version).append("\",");
/*  98 */     sb.append("\"Authenticate\":\"").append(this.Authenticate).append("\",");
/*  99 */     sb.append("\"Result\":").append(this.Result).append(",");
/* 100 */     sb.append("\"RetErrMsg\":\"").append(this.RetErrMsg).append("\"}");
/* 101 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\core\IdipHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
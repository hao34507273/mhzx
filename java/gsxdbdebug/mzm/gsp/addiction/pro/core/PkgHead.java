/*     */ package mzm.gsp.addiction.pro.core;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import jsonio.JsonMarshalException;
/*     */ import jsonio.JsonStream;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineInfoArgs;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PkgHead implements jsonio.JsonMarshal
/*     */ {
/*     */   public static PkgHead create(int msgType)
/*     */   {
/*  16 */     PkgHead header = new PkgHead();
/*  17 */     header.msg_type = msgType;
/*  18 */     header.area = GameServerInfoManager.getZoneId();
/*     */     
/*  20 */     header.plat_id = 1;
/*  21 */     header.appid = OnlineInfoArgs.getInstance().getQQAppid();
/*  22 */     return header;
/*     */   }
/*     */   
/*     */   public static PkgHead create(String userid, int msgType)
/*     */   {
/*  27 */     PkgHead header = new PkgHead();
/*  28 */     header.msg_type = msgType;
/*  29 */     header.area = CommonUtils.getZoneId(userid);
/*  30 */     String appid = Onlines.getInstance().findGameAppid(userid);
/*  31 */     if (appid == null)
/*     */     {
/*  33 */       GameServer.logger().error(String.format("[addiction]PkgHead.create@appid is null|userid=%s|msg_type=%d", new Object[] { userid, Integer.valueOf(msgType) }));
/*     */       
/*  35 */       return null;
/*     */     }
/*  37 */     header.appid = appid;
/*  38 */     header.plat_id = (Onlines.getInstance().findPlatid(userid) + 1);
/*  39 */     return header;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  45 */   public int seq_id = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  50 */   public int msg_type = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  55 */   public String version = "1.0";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  60 */   public String appid = "0";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  65 */   public int plat_id = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  70 */   public int area = 0;
/*     */   
/*     */ 
/*     */   public JsonStream marshal(JsonStream js)
/*     */   {
/*  75 */     js.marshal("seq_id", Integer.valueOf(this.seq_id));
/*  76 */     js.marshal("msg_type", Integer.valueOf(this.msg_type));
/*  77 */     js.marshal("version", this.version);
/*  78 */     js.marshal("appid", this.appid);
/*  79 */     js.marshal("plat_id", Integer.valueOf(this.plat_id));
/*  80 */     js.marshal("area", Integer.valueOf(this.area));
/*  81 */     return js;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_)
/*     */     throws JsonMarshalException
/*     */   {
/*  87 */     this.seq_id = _js_.unmarshal_int("seq_id");
/*  88 */     this.msg_type = _js_.unmarshal_int("msg_type");
/*  89 */     this.version = _js_.unmarshal_string("version");
/*  90 */     this.appid = _js_.unmarshal_string("appid");
/*  91 */     this.plat_id = _js_.unmarshal_int("plat_id");
/*  92 */     this.area = _js_.unmarshal_int("area");
/*  93 */     return _js_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  99 */     StringBuffer sb = new StringBuffer();
/* 100 */     sb.append("{").append("\"seq_id\":").append(this.seq_id).append(",");
/* 101 */     sb.append("\"msg_type\":").append(this.msg_type).append(",");
/* 102 */     sb.append("\"version\":\"").append(this.version).append("\",");
/* 103 */     sb.append("\"appid\":\"").append(this.appid).append("\",");
/* 104 */     sb.append("\"plat_id\":").append(this.plat_id).append(",");
/* 105 */     sb.append("\"area\":").append(this.area).append("}");
/* 106 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\core\PkgHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
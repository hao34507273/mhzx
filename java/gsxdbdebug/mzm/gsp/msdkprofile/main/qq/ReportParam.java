/*    */ package mzm.gsp.msdkprofile.main.qq;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ public class ReportParam implements JsonMarshal
/*    */ {
/*  9 */   public int type = 0;
/* 10 */   public String data = "";
/* 11 */   public String expires = "";
/* 12 */   public int bcover = 0;
/*    */   
/*    */ 
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 17 */     _js_.marshal("type", Integer.valueOf(this.type));
/* 18 */     _js_.marshal("data", this.data);
/* 19 */     _js_.marshal("expires", this.expires);
/* 20 */     _js_.marshal("bcover", Integer.valueOf(this.bcover));
/* 21 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_)
/*    */     throws JsonMarshalException
/*    */   {
/* 27 */     this.type = _js_.unmarshal_int("type");
/* 28 */     this.data = _js_.unmarshal_string("data");
/* 29 */     this.expires = _js_.unmarshal_string("expires");
/* 30 */     this.bcover = _js_.unmarshal_int("bcover");
/*    */     
/* 32 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\qq\ReportParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
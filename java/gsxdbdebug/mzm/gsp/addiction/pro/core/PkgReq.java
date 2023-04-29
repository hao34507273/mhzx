/*    */ package mzm.gsp.addiction.pro.core;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonStream;
/*    */ import org.json.JSONException;
/*    */ 
/*    */ 
/*    */ public class PkgReq<PkgBody extends JsonMarshal>
/*    */   implements JsonMarshal
/*    */ {
/*    */   public final PkgHead header;
/*    */   public final PkgBody body;
/*    */   
/*    */   public PkgReq(PkgHead header, PkgBody body)
/*    */   {
/* 16 */     this.header = header;
/* 17 */     this.body = body;
/*    */   }
/*    */   
/*    */   public int getMsgType()
/*    */   {
/* 22 */     return this.header.msg_type;
/*    */   }
/*    */   
/*    */ 
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 28 */     js.marshal("common_msg", this.header);
/* 29 */     js.marshal("body_info", this.body);
/* 30 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JSONException
/*    */   {
/* 36 */     js.unmarshal("common_msg", this.header);
/* 37 */     js.unmarshal("body_info", this.body);
/* 38 */     return js;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 44 */     JsonStream js = new JsonStream();
/* 45 */     marshal(js);
/* 46 */     return js.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\core\PkgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
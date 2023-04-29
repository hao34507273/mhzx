/*    */ package mzm.gsp.addiction.pro;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ public class RemindInfo
/*    */   implements JsonMarshal
/*    */ {
/*    */   public String account_id;
/*    */   public String character_id;
/*    */   public int report_type;
/*    */   public long report_time;
/*    */   
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 17 */     js.marshal("account_id", this.account_id);
/* 18 */     js.marshal("character_id", this.character_id);
/* 19 */     js.marshal("report_type", Integer.valueOf(this.report_type));
/* 20 */     js.marshal("report_time", Long.valueOf(this.report_time));
/* 21 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JsonMarshalException
/*    */   {
/* 27 */     this.account_id = js.unmarshal_string("account_id");
/* 28 */     this.character_id = js.unmarshal_string("character_id");
/* 29 */     this.report_type = js.unmarshal_int("report_type");
/* 30 */     this.report_time = js.unmarshal_long("report_time");
/* 31 */     return js;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\RemindInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
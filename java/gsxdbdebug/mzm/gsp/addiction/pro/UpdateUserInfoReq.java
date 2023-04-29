/*    */ package mzm.gsp.addiction.pro;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ public class UpdateUserInfoReq
/*    */   implements JsonMarshal
/*    */ {
/*    */   public String account_id;
/*    */   public String character_id;
/*    */   public int this_period_time;
/*    */   
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 16 */     js.marshal("account_id", this.account_id);
/* 17 */     js.marshal("character_id", this.character_id);
/* 18 */     js.marshal("this_period_time", Integer.valueOf(this.this_period_time));
/* 19 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JsonMarshalException
/*    */   {
/* 25 */     this.account_id = js.unmarshal_string("account_id");
/* 26 */     this.character_id = js.unmarshal_string("character_id");
/* 27 */     this.this_period_time = js.unmarshal_int("this_period_time");
/* 28 */     return js;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\UpdateUserInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
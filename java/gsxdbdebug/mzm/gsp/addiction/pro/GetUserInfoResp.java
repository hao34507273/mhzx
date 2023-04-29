/*    */ package mzm.gsp.addiction.pro;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ public class GetUserInfoResp implements JsonMarshal
/*    */ {
/*    */   public String account_id;
/*    */   public String character_id;
/*    */   public int is_adult;
/*    */   public int accumu_time;
/*    */   public int age;
/*    */   
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 18 */     js.marshal("account_id", this.account_id);
/* 19 */     js.marshal("character_id", this.character_id);
/* 20 */     js.marshal("is_adult", Integer.valueOf(this.is_adult));
/* 21 */     js.marshal("accumu_time", Integer.valueOf(this.accumu_time));
/* 22 */     js.marshal("age", Integer.valueOf(this.age));
/* 23 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JsonMarshalException
/*    */   {
/* 29 */     this.account_id = js.unmarshal_string("account_id");
/* 30 */     this.character_id = js.unmarshal_string("character_id");
/* 31 */     this.is_adult = js.unmarshal_int("is_adult");
/* 32 */     this.accumu_time = js.unmarshal_int("accumu_time");
/*    */     
/* 34 */     if (js.getJSONObject().has("age"))
/*    */     {
/* 36 */       this.age = js.unmarshal_int("age");
/*    */     }
/* 38 */     return js;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\GetUserInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
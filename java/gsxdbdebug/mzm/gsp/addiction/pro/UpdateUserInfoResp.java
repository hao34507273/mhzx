/*    */ package mzm.gsp.addiction.pro;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateUserInfoResp
/*    */   implements JsonMarshal
/*    */ {
/*    */   public String account_id;
/*    */   public String character_id;
/*    */   public int accumu_time;
/*    */   public int is_need_reminded;
/*    */   public int healthy_game_flag;
/*    */   public int force_exit_rest_time;
/*    */   public int curfew_end_time;
/*    */   public int ban_end_time;
/*    */   
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 24 */     js.marshal("account_id", this.account_id);
/* 25 */     js.marshal("character_id", this.character_id);
/* 26 */     js.marshal("accumu_time", Integer.valueOf(this.accumu_time));
/* 27 */     js.marshal("is_need_reminded", Integer.valueOf(this.is_need_reminded));
/* 28 */     js.marshal("healthy_game_flag", Integer.valueOf(this.healthy_game_flag));
/* 29 */     js.marshal("force_exit_rest_time", Integer.valueOf(this.force_exit_rest_time));
/* 30 */     js.marshal("curfew_end_time", Integer.valueOf(this.curfew_end_time));
/* 31 */     js.marshal("ban_end_time", Integer.valueOf(this.ban_end_time));
/* 32 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JsonMarshalException
/*    */   {
/* 38 */     this.account_id = js.unmarshal_string("account_id");
/* 39 */     this.character_id = js.unmarshal_string("character_id");
/* 40 */     this.accumu_time = js.unmarshal_int("accumu_time");
/*    */     
/* 42 */     JSONObject jsonObject = js.getJSONObject();
/* 43 */     if (jsonObject.has("is_need_reminded"))
/*    */     {
/* 45 */       this.is_need_reminded = js.unmarshal_int("is_need_reminded");
/*    */     }
/* 47 */     if (jsonObject.has("healthy_game_flag"))
/*    */     {
/* 49 */       this.healthy_game_flag = js.unmarshal_int("healthy_game_flag");
/*    */     }
/* 51 */     if (jsonObject.has("force_exit_rest_time"))
/*    */     {
/* 53 */       this.force_exit_rest_time = js.unmarshal_int("force_exit_rest_time");
/*    */     }
/* 55 */     if (jsonObject.has("curfew_end_time"))
/*    */     {
/* 57 */       this.curfew_end_time = js.unmarshal_int("curfew_end_time");
/*    */     }
/* 59 */     if (jsonObject.has("ban_end_time"))
/*    */     {
/* 61 */       this.ban_end_time = js.unmarshal_int("ban_end_time");
/*    */     }
/* 63 */     return js;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\UpdateUserInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
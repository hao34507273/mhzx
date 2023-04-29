/*    */ package mzm.gsp.addiction.pro;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ import org.json.JSONArray;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ public class ReportRemindBatchReq
/*    */   implements JsonMarshal
/*    */ {
/* 15 */   private List<RemindInfo> remind_info = new LinkedList();
/*    */   
/*    */   public void addRemindInfo(RemindInfo info)
/*    */   {
/* 19 */     this.remind_info.add(info);
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 25 */     JsonStream jsonStream = new JsonStream();
/* 26 */     return marshal(jsonStream).toString();
/*    */   }
/*    */   
/*    */ 
/*    */   public JsonStream marshal(JsonStream js)
/*    */   {
/* 32 */     JSONArray _ja_ = new JSONArray();
/* 33 */     for (RemindInfo _v_ : this.remind_info)
/*    */     {
/* 35 */       JsonStream _jsv_ = _v_.marshal(new JsonStream());
/* 36 */       _ja_.put(_jsv_.getJSONObject());
/*    */     }
/* 38 */     js.marshal("remind_info", _ja_);
/* 39 */     return js;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream js)
/*    */     throws JsonMarshalException
/*    */   {
/* 45 */     JSONArray jsonArray = js.unmarshal_json_array("remind_info");
/* 46 */     int len = jsonArray.length();
/* 47 */     for (int i = 0; i < len; i++)
/*    */     {
/* 49 */       JSONObject jsonObject = jsonArray.getJSONObject(i);
/* 50 */       JsonStream jsonStream = new JsonStream(jsonObject);
/* 51 */       RemindInfo info = new RemindInfo();
/* 52 */       info.unmarshal(jsonStream);
/* 53 */       this.remind_info.add(info);
/*    */     }
/* 55 */     return js;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\ReportRemindBatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
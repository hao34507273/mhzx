/*    */ package idip;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ import org.json.JSONArray;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryAllPrizeRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int MailList_count = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public ArrayList<SMailInfo1> MailList = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int TotalPageNo = 0;
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 30 */     _js_.marshal("MailList_count", Integer.valueOf(this.MailList_count));
/*    */     
/* 32 */     JSONArray _ja_ = new JSONArray();
/* 33 */     for (SMailInfo1 _v_ : this.MailList)
/*    */     {
/* 35 */       JsonStream _jsv_ = _v_.marshal(new JsonStream());
/* 36 */       _ja_.put(_jsv_.getJSONObject());
/*    */     }
/* 38 */     _js_.marshal("MailList", _ja_);
/*    */     
/* 40 */     _js_.marshal("TotalPageNo", Integer.valueOf(this.TotalPageNo));
/* 41 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 46 */     this.MailList_count = _js_.unmarshal_int("MailList_count");
/*    */     
/* 48 */     JSONArray _ja_ = _js_.unmarshal_json_array("MailList");
/* 49 */     int _jal_ = _ja_.length();
/* 50 */     for (int _i_ = 0; _i_ < _jal_; _i_++)
/*    */     {
/*    */ 
/* 53 */       JsonStream _jsv_ = new JsonStream(_ja_.getJSONObject(_i_));
/* 54 */       SMailInfo1 _v_ = new SMailInfo1();
/* 55 */       _v_.unmarshal(_jsv_);
/* 56 */       this.MailList.add(_v_);
/*    */     }
/*    */     
/* 59 */     this.TotalPageNo = _js_.unmarshal_int("TotalPageNo");
/* 60 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryAllPrizeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
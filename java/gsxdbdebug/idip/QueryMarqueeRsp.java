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
/*    */ public class QueryMarqueeRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int Result = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public String RetMsg = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int PageNo = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public int MarqueeList_count = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public ArrayList<MarqueeInfo> MarqueeList = new ArrayList();
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 40 */     _js_.marshal("Result", Integer.valueOf(this.Result));
/* 41 */     _js_.marshal("RetMsg", this.RetMsg);
/* 42 */     _js_.marshal("PageNo", Integer.valueOf(this.PageNo));
/* 43 */     _js_.marshal("MarqueeList_count", Integer.valueOf(this.MarqueeList_count));
/*    */     
/* 45 */     JSONArray _ja_ = new JSONArray();
/* 46 */     for (MarqueeInfo _v_ : this.MarqueeList)
/*    */     {
/* 48 */       JsonStream _jsv_ = _v_.marshal(new JsonStream());
/* 49 */       _ja_.put(_jsv_.getJSONObject());
/*    */     }
/* 51 */     _js_.marshal("MarqueeList", _ja_);
/*    */     
/* 53 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 58 */     this.Result = _js_.unmarshal_int("Result");
/* 59 */     this.RetMsg = _js_.unmarshal_string("RetMsg");
/* 60 */     this.PageNo = _js_.unmarshal_int("PageNo");
/* 61 */     this.MarqueeList_count = _js_.unmarshal_int("MarqueeList_count");
/*    */     
/* 63 */     JSONArray _ja_ = _js_.unmarshal_json_array("MarqueeList");
/* 64 */     int _jal_ = _ja_.length();
/* 65 */     for (int _i_ = 0; _i_ < _jal_; _i_++)
/*    */     {
/*    */ 
/* 68 */       JsonStream _jsv_ = new JsonStream(_ja_.getJSONObject(_i_));
/* 69 */       MarqueeInfo _v_ = new MarqueeInfo();
/* 70 */       _v_.unmarshal(_jsv_);
/* 71 */       this.MarqueeList.add(_v_);
/*    */     }
/*    */     
/* 74 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryMarqueeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
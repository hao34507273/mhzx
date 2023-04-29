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
/*    */ public class AqQueryUsrInfoRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int OpenidList_count = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public ArrayList<QUERY_USR_INFO_LIST> OpenidList = new ArrayList();
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 25 */     _js_.marshal("OpenidList_count", Integer.valueOf(this.OpenidList_count));
/*    */     
/* 27 */     JSONArray _ja_ = new JSONArray();
/* 28 */     for (QUERY_USR_INFO_LIST _v_ : this.OpenidList)
/*    */     {
/* 30 */       JsonStream _jsv_ = _v_.marshal(new JsonStream());
/* 31 */       _ja_.put(_jsv_.getJSONObject());
/*    */     }
/* 33 */     _js_.marshal("OpenidList", _ja_);
/*    */     
/* 35 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 40 */     this.OpenidList_count = _js_.unmarshal_int("OpenidList_count");
/*    */     
/* 42 */     JSONArray _ja_ = _js_.unmarshal_json_array("OpenidList");
/* 43 */     int _jal_ = _ja_.length();
/* 44 */     for (int _i_ = 0; _i_ < _jal_; _i_++)
/*    */     {
/*    */ 
/* 47 */       JsonStream _jsv_ = new JsonStream(_ja_.getJSONObject(_i_));
/* 48 */       QUERY_USR_INFO_LIST _v_ = new QUERY_USR_INFO_LIST();
/* 49 */       _v_.unmarshal(_jsv_);
/* 50 */       this.OpenidList.add(_v_);
/*    */     }
/*    */     
/* 53 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\AqQueryUsrInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ public class QueryGuildMemberInfoRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int TotalPageNo = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int MemberInfo_count = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public ArrayList<MemberInfo> MemberInfo = new ArrayList();
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 30 */     _js_.marshal("TotalPageNo", Integer.valueOf(this.TotalPageNo));
/* 31 */     _js_.marshal("MemberInfo_count", Integer.valueOf(this.MemberInfo_count));
/*    */     
/* 33 */     JSONArray _ja_ = new JSONArray();
/* 34 */     for (MemberInfo _v_ : this.MemberInfo)
/*    */     {
/* 36 */       JsonStream _jsv_ = _v_.marshal(new JsonStream());
/* 37 */       _ja_.put(_jsv_.getJSONObject());
/*    */     }
/* 39 */     _js_.marshal("MemberInfo", _ja_);
/*    */     
/* 41 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 46 */     this.TotalPageNo = _js_.unmarshal_int("TotalPageNo");
/* 47 */     this.MemberInfo_count = _js_.unmarshal_int("MemberInfo_count");
/*    */     
/* 49 */     JSONArray _ja_ = _js_.unmarshal_json_array("MemberInfo");
/* 50 */     int _jal_ = _ja_.length();
/* 51 */     for (int _i_ = 0; _i_ < _jal_; _i_++)
/*    */     {
/*    */ 
/* 54 */       JsonStream _jsv_ = new JsonStream(_ja_.getJSONObject(_i_));
/* 55 */       MemberInfo _v_ = new MemberInfo();
/* 56 */       _v_.unmarshal(_jsv_);
/* 57 */       this.MemberInfo.add(_v_);
/*    */     }
/*    */     
/* 60 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryGuildMemberInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
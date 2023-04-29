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
/*    */ public class QueryRoleSocialRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int Social_count = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public ArrayList<SSocial> Social = new ArrayList();
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 25 */     _js_.marshal("Social_count", Integer.valueOf(this.Social_count));
/*    */     
/* 27 */     JSONArray _ja_ = new JSONArray();
/* 28 */     for (SSocial _v_ : this.Social)
/*    */     {
/* 30 */       JsonStream _jsv_ = _v_.marshal(new JsonStream());
/* 31 */       _ja_.put(_jsv_.getJSONObject());
/*    */     }
/* 33 */     _js_.marshal("Social", _ja_);
/*    */     
/* 35 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 40 */     this.Social_count = _js_.unmarshal_int("Social_count");
/*    */     
/* 42 */     JSONArray _ja_ = _js_.unmarshal_json_array("Social");
/* 43 */     int _jal_ = _ja_.length();
/* 44 */     for (int _i_ = 0; _i_ < _jal_; _i_++)
/*    */     {
/*    */ 
/* 47 */       JsonStream _jsv_ = new JsonStream(_ja_.getJSONObject(_i_));
/* 48 */       SSocial _v_ = new SSocial();
/* 49 */       _v_.unmarshal(_jsv_);
/* 50 */       this.Social.add(_v_);
/*    */     }
/*    */     
/* 53 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryRoleSocialRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
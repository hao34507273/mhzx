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
/*    */ public class QueryRoleArchivementRsp
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int TotalArchivementPoint = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int ReachNum = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int ArchivementList_count = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public ArrayList<SArchiveInfo> ArchivementList = new ArrayList();
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 35 */     _js_.marshal("TotalArchivementPoint", Integer.valueOf(this.TotalArchivementPoint));
/* 36 */     _js_.marshal("ReachNum", Integer.valueOf(this.ReachNum));
/* 37 */     _js_.marshal("ArchivementList_count", Integer.valueOf(this.ArchivementList_count));
/*    */     
/* 39 */     JSONArray _ja_ = new JSONArray();
/* 40 */     for (SArchiveInfo _v_ : this.ArchivementList)
/*    */     {
/* 42 */       JsonStream _jsv_ = _v_.marshal(new JsonStream());
/* 43 */       _ja_.put(_jsv_.getJSONObject());
/*    */     }
/* 45 */     _js_.marshal("ArchivementList", _ja_);
/*    */     
/* 47 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 52 */     this.TotalArchivementPoint = _js_.unmarshal_int("TotalArchivementPoint");
/* 53 */     this.ReachNum = _js_.unmarshal_int("ReachNum");
/* 54 */     this.ArchivementList_count = _js_.unmarshal_int("ArchivementList_count");
/*    */     
/* 56 */     JSONArray _ja_ = _js_.unmarshal_json_array("ArchivementList");
/* 57 */     int _jal_ = _ja_.length();
/* 58 */     for (int _i_ = 0; _i_ < _jal_; _i_++)
/*    */     {
/*    */ 
/* 61 */       JsonStream _jsv_ = new JsonStream(_ja_.getJSONObject(_i_));
/* 62 */       SArchiveInfo _v_ = new SArchiveInfo();
/* 63 */       _v_.unmarshal(_jsv_);
/* 64 */       this.ArchivementList.add(_v_);
/*    */     }
/*    */     
/* 67 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryRoleArchivementRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
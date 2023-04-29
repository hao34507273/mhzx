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
/*    */ public class QueryRoleArchivementReq
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public int AreaId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public int Partition = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public byte PlatId = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public String OpenId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public String RoleId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public int ArchivementList_count = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public ArrayList<Integer> ArchivementList = new ArrayList();
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 50 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 51 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 52 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 53 */     _js_.marshal("OpenId", this.OpenId);
/* 54 */     _js_.marshal("RoleId", this.RoleId);
/* 55 */     _js_.marshal("ArchivementList_count", Integer.valueOf(this.ArchivementList_count));
/*    */     
/* 57 */     JSONArray _ja_ = new JSONArray();
/* 58 */     for (Integer _v_ : this.ArchivementList)
/*    */     {
/* 60 */       _ja_.put(_v_);
/*    */     }
/* 62 */     _js_.marshal("ArchivementList", _ja_);
/*    */     
/* 64 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 69 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 70 */     this.Partition = _js_.unmarshal_int("Partition");
/* 71 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 72 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 73 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 74 */     this.ArchivementList_count = _js_.unmarshal_int("ArchivementList_count");
/*    */     
/* 76 */     JSONArray _ja_ = _js_.unmarshal_json_array("ArchivementList");
/* 77 */     int _jal_ = _ja_.length();
/* 78 */     for (int _i_ = 0; _i_ < _jal_; _i_++)
/*    */     {
/*    */ 
/* 81 */       int _v_ = _ja_.getInt(_i_);
/* 82 */       this.ArchivementList.add(Integer.valueOf(_v_));
/*    */     }
/*    */     
/* 85 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryRoleArchivementReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
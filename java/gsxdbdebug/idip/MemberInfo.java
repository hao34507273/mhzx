/*    */ package idip;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonMarshalException;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MemberInfo
/*    */   implements JsonMarshal
/*    */ {
/* 16 */   public String RoleId = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   public String RoleName = "";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   public int Pos = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   public int Job = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   public int Level = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   public int Fight = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   public int Contribute = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   public int IsOnline = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   public String OpenId = "";
/*    */   
/*    */   public JsonStream marshal(JsonStream _js_)
/*    */   {
/* 60 */     _js_.marshal("RoleId", this.RoleId);
/* 61 */     _js_.marshal("RoleName", this.RoleName);
/* 62 */     _js_.marshal("Pos", Integer.valueOf(this.Pos));
/* 63 */     _js_.marshal("Job", Integer.valueOf(this.Job));
/* 64 */     _js_.marshal("Level", Integer.valueOf(this.Level));
/* 65 */     _js_.marshal("Fight", Integer.valueOf(this.Fight));
/* 66 */     _js_.marshal("Contribute", Integer.valueOf(this.Contribute));
/* 67 */     _js_.marshal("IsOnline", Integer.valueOf(this.IsOnline));
/* 68 */     _js_.marshal("OpenId", this.OpenId);
/* 69 */     return _js_;
/*    */   }
/*    */   
/*    */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*    */   {
/* 74 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 75 */     this.RoleName = _js_.unmarshal_string("RoleName");
/* 76 */     this.Pos = _js_.unmarshal_int("Pos");
/* 77 */     this.Job = _js_.unmarshal_int("Job");
/* 78 */     this.Level = _js_.unmarshal_int("Level");
/* 79 */     this.Fight = _js_.unmarshal_int("Fight");
/* 80 */     this.Contribute = _js_.unmarshal_int("Contribute");
/* 81 */     this.IsOnline = _js_.unmarshal_int("IsOnline");
/* 82 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 83 */     return _js_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\MemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
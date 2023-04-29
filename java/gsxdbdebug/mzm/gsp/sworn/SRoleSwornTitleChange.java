/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRoleSwornTitleChange
/*    */   extends __SRoleSwornTitleChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597783;
/*    */   public long swornid;
/*    */   public long roleid;
/*    */   public String title;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12597783;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRoleSwornTitleChange()
/*    */   {
/* 35 */     this.title = "";
/*    */   }
/*    */   
/*    */   public SRoleSwornTitleChange(long _swornid_, long _roleid_, String _title_) {
/* 39 */     this.swornid = _swornid_;
/* 40 */     this.roleid = _roleid_;
/* 41 */     this.title = _title_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.swornid);
/* 50 */     _os_.marshal(this.roleid);
/* 51 */     _os_.marshal(this.title, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.swornid = _os_.unmarshal_long();
/* 57 */     this.roleid = _os_.unmarshal_long();
/* 58 */     this.title = _os_.unmarshal_String("UTF-16LE");
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SRoleSwornTitleChange)) {
/* 68 */       SRoleSwornTitleChange _o_ = (SRoleSwornTitleChange)_o1_;
/* 69 */       if (this.swornid != _o_.swornid) return false;
/* 70 */       if (this.roleid != _o_.roleid) return false;
/* 71 */       if (!this.title.equals(_o_.title)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.swornid;
/* 80 */     _h_ += (int)this.roleid;
/* 81 */     _h_ += this.title.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.swornid).append(",");
/* 89 */     _sb_.append(this.roleid).append(",");
/* 90 */     _sb_.append("T").append(this.title.length()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SRoleSwornTitleChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
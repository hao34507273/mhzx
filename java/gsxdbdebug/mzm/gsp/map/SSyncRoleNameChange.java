/*    */ package mzm.gsp.map;
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
/*    */ public class SSyncRoleNameChange
/*    */   extends __SSyncRoleNameChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590873;
/*    */   public static final int TYPE_ROLE = 0;
/*    */   public static final int TYPE_PET = 1;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int nametype;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590873;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncRoleNameChange()
/*    */   {
/* 38 */     this.name = "";
/*    */   }
/*    */   
/*    */   public SSyncRoleNameChange(long _roleid_, String _name_, int _nametype_) {
/* 42 */     this.roleid = _roleid_;
/* 43 */     this.name = _name_;
/* 44 */     this.nametype = _nametype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.roleid);
/* 53 */     _os_.marshal(this.name, "UTF-16LE");
/* 54 */     _os_.marshal(this.nametype);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.roleid = _os_.unmarshal_long();
/* 60 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 61 */     this.nametype = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSyncRoleNameChange)) {
/* 71 */       SSyncRoleNameChange _o_ = (SSyncRoleNameChange)_o1_;
/* 72 */       if (this.roleid != _o_.roleid) return false;
/* 73 */       if (!this.name.equals(_o_.name)) return false;
/* 74 */       if (this.nametype != _o_.nametype) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += (int)this.roleid;
/* 83 */     _h_ += this.name.hashCode();
/* 84 */     _h_ += this.nametype;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.roleid).append(",");
/* 92 */     _sb_.append("T").append(this.name.length()).append(",");
/* 93 */     _sb_.append(this.nametype).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncRoleNameChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
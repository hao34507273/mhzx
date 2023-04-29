/*    */ package mzm.gsp.guide;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.guide.main.PSetGuidedState;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSendGuidedid
/*    */   extends __CSendGuidedid__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594949;
/*    */   public int guideid;
/*    */   public int param;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PSetGuidedState(roleId, this.guideid, this.param));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12594949;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSendGuidedid() {}
/*    */   
/*    */ 
/*    */   public CSendGuidedid(int _guideid_, int _param_)
/*    */   {
/* 40 */     this.guideid = _guideid_;
/* 41 */     this.param = _param_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.guideid);
/* 50 */     _os_.marshal(this.param);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.guideid = _os_.unmarshal_int();
/* 56 */     this.param = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CSendGuidedid)) {
/* 66 */       CSendGuidedid _o_ = (CSendGuidedid)_o1_;
/* 67 */       if (this.guideid != _o_.guideid) return false;
/* 68 */       if (this.param != _o_.param) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.guideid;
/* 77 */     _h_ += this.param;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.guideid).append(",");
/* 85 */     _sb_.append(this.param).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSendGuidedid _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.guideid - _o_.guideid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.param - _o_.param;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\CSendGuidedid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
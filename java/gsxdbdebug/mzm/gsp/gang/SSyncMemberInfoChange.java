/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncMemberInfoChange
/*    */   extends __SSyncMemberInfoChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589896;
/*    */   public MemberInfo memberinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589896;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncMemberInfoChange()
/*    */   {
/* 34 */     this.memberinfo = new MemberInfo();
/*    */   }
/*    */   
/*    */   public SSyncMemberInfoChange(MemberInfo _memberinfo_) {
/* 38 */     this.memberinfo = _memberinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     if (!this.memberinfo._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.memberinfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.memberinfo.unmarshal(_os_);
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SSyncMemberInfoChange)) {
/* 62 */       SSyncMemberInfoChange _o_ = (SSyncMemberInfoChange)_o1_;
/* 63 */       if (!this.memberinfo.equals(_o_.memberinfo)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.memberinfo.hashCode();
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.memberinfo).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncMemberInfoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
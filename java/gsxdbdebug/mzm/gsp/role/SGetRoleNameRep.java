/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
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
/*    */ public class SGetRoleNameRep
/*    */   extends __SGetRoleNameRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586037;
/*    */   public long checkedroleid;
/*    */   public Octets checkedrolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12586037;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetRoleNameRep()
/*    */   {
/* 34 */     this.checkedrolename = new Octets();
/*    */   }
/*    */   
/*    */   public SGetRoleNameRep(long _checkedroleid_, Octets _checkedrolename_) {
/* 38 */     this.checkedroleid = _checkedroleid_;
/* 39 */     this.checkedrolename = _checkedrolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.checkedroleid);
/* 48 */     _os_.marshal(this.checkedrolename);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.checkedroleid = _os_.unmarshal_long();
/* 54 */     this.checkedrolename = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SGetRoleNameRep)) {
/* 64 */       SGetRoleNameRep _o_ = (SGetRoleNameRep)_o1_;
/* 65 */       if (this.checkedroleid != _o_.checkedroleid) return false;
/* 66 */       if (!this.checkedrolename.equals(_o_.checkedrolename)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.checkedroleid;
/* 75 */     _h_ += this.checkedrolename.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.checkedroleid).append(",");
/* 83 */     _sb_.append("B").append(this.checkedrolename.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SGetRoleNameRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
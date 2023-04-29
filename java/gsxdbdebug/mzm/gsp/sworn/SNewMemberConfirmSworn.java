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
/*    */ 
/*    */ public class SNewMemberConfirmSworn
/*    */   extends __SNewMemberConfirmSworn__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597805;
/*    */   public String rolename;
/*    */   public sworninfo info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12597805;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNewMemberConfirmSworn()
/*    */   {
/* 34 */     this.rolename = "";
/* 35 */     this.info = new sworninfo();
/*    */   }
/*    */   
/*    */   public SNewMemberConfirmSworn(String _rolename_, sworninfo _info_) {
/* 39 */     this.rolename = _rolename_;
/* 40 */     this.info = _info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     if (!this.info._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 50 */     _os_.marshal(this.info);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 56 */     this.info.unmarshal(_os_);
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SNewMemberConfirmSworn)) {
/* 66 */       SNewMemberConfirmSworn _o_ = (SNewMemberConfirmSworn)_o1_;
/* 67 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 68 */       if (!this.info.equals(_o_.info)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.rolename.hashCode();
/* 77 */     _h_ += this.info.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 85 */     _sb_.append(this.info).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SNewMemberConfirmSworn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
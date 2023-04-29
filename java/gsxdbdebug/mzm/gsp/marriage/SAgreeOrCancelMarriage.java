/*    */ package mzm.gsp.marriage;
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
/*    */ public class SAgreeOrCancelMarriage
/*    */   extends __SAgreeOrCancelMarriage__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599813;
/*    */   public int operator;
/*    */   public long operator_roleid;
/*    */   public String rolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599813;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAgreeOrCancelMarriage()
/*    */   {
/* 35 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public SAgreeOrCancelMarriage(int _operator_, long _operator_roleid_, String _rolename_) {
/* 39 */     this.operator = _operator_;
/* 40 */     this.operator_roleid = _operator_roleid_;
/* 41 */     this.rolename = _rolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.operator);
/* 50 */     _os_.marshal(this.operator_roleid);
/* 51 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.operator = _os_.unmarshal_int();
/* 57 */     this.operator_roleid = _os_.unmarshal_long();
/* 58 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SAgreeOrCancelMarriage)) {
/* 68 */       SAgreeOrCancelMarriage _o_ = (SAgreeOrCancelMarriage)_o1_;
/* 69 */       if (this.operator != _o_.operator) return false;
/* 70 */       if (this.operator_roleid != _o_.operator_roleid) return false;
/* 71 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.operator;
/* 80 */     _h_ += (int)this.operator_roleid;
/* 81 */     _h_ += this.rolename.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.operator).append(",");
/* 89 */     _sb_.append(this.operator_roleid).append(",");
/* 90 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SAgreeOrCancelMarriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
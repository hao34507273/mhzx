/*    */ package mzm.gsp.competition;
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
/*    */ public class SSyncRoleCompetition
/*    */   extends __SSyncRoleCompetition__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598530;
/*    */   public int action_point;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598530;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncRoleCompetition()
/*    */   {
/* 33 */     this.action_point = 0;
/*    */   }
/*    */   
/*    */   public SSyncRoleCompetition(int _action_point_) {
/* 37 */     this.action_point = _action_point_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.action_point);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.action_point = _os_.unmarshal_int();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof SSyncRoleCompetition)) {
/* 60 */       SSyncRoleCompetition _o_ = (SSyncRoleCompetition)_o1_;
/* 61 */       if (this.action_point != _o_.action_point) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.action_point;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.action_point).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncRoleCompetition _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.action_point - _o_.action_point;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SSyncRoleCompetition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
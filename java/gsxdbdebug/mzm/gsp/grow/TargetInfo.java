/*    */ package mzm.gsp.grow;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.award.AwardInfoBean;
/*    */ 
/*    */ public class TargetInfo implements Marshal
/*    */ {
/*    */   public int targetid;
/*    */   public int targetstate;
/*    */   public int targetparam;
/*    */   public AwardInfoBean targetawardbean;
/*    */   
/*    */   public TargetInfo()
/*    */   {
/* 17 */     this.targetstate = 1;
/* 18 */     this.targetawardbean = new AwardInfoBean();
/*    */   }
/*    */   
/*    */   public TargetInfo(int _targetid_, int _targetstate_, int _targetparam_, AwardInfoBean _targetawardbean_) {
/* 22 */     this.targetid = _targetid_;
/* 23 */     this.targetstate = _targetstate_;
/* 24 */     this.targetparam = _targetparam_;
/* 25 */     this.targetawardbean = _targetawardbean_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.targetawardbean._validator_()) return false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.targetid);
/* 35 */     _os_.marshal(this.targetstate);
/* 36 */     _os_.marshal(this.targetparam);
/* 37 */     _os_.marshal(this.targetawardbean);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.targetid = _os_.unmarshal_int();
/* 43 */     this.targetstate = _os_.unmarshal_int();
/* 44 */     this.targetparam = _os_.unmarshal_int();
/* 45 */     this.targetawardbean.unmarshal(_os_);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof TargetInfo)) {
/* 52 */       TargetInfo _o_ = (TargetInfo)_o1_;
/* 53 */       if (this.targetid != _o_.targetid) return false;
/* 54 */       if (this.targetstate != _o_.targetstate) return false;
/* 55 */       if (this.targetparam != _o_.targetparam) return false;
/* 56 */       if (!this.targetawardbean.equals(_o_.targetawardbean)) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.targetid;
/* 65 */     _h_ += this.targetstate;
/* 66 */     _h_ += this.targetparam;
/* 67 */     _h_ += this.targetawardbean.hashCode();
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append(this.targetid).append(",");
/* 75 */     _sb_.append(this.targetstate).append(",");
/* 76 */     _sb_.append(this.targetparam).append(",");
/* 77 */     _sb_.append(this.targetawardbean).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\TargetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
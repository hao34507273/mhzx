/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AttackOtherBean implements Marshal
/*    */ {
/*    */   public int targetid;
/*    */   public AttackOtherBeanResult attackinnerbean;
/*    */   public InfluenceOther influenceothers;
/*    */   public Protect protect;
/*    */   
/*    */   public AttackOtherBean()
/*    */   {
/* 15 */     this.attackinnerbean = new AttackOtherBeanResult();
/* 16 */     this.influenceothers = new InfluenceOther();
/* 17 */     this.protect = new Protect();
/*    */   }
/*    */   
/*    */   public AttackOtherBean(int _targetid_, AttackOtherBeanResult _attackinnerbean_, InfluenceOther _influenceothers_, Protect _protect_) {
/* 21 */     this.targetid = _targetid_;
/* 22 */     this.attackinnerbean = _attackinnerbean_;
/* 23 */     this.influenceothers = _influenceothers_;
/* 24 */     this.protect = _protect_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     if (!this.attackinnerbean._validator_()) return false;
/* 29 */     if (!this.influenceothers._validator_()) return false;
/* 30 */     if (!this.protect._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.targetid);
/* 36 */     _os_.marshal(this.attackinnerbean);
/* 37 */     _os_.marshal(this.influenceothers);
/* 38 */     _os_.marshal(this.protect);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 43 */     this.targetid = _os_.unmarshal_int();
/* 44 */     this.attackinnerbean.unmarshal(_os_);
/* 45 */     this.influenceothers.unmarshal(_os_);
/* 46 */     this.protect.unmarshal(_os_);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof AttackOtherBean)) {
/* 53 */       AttackOtherBean _o_ = (AttackOtherBean)_o1_;
/* 54 */       if (this.targetid != _o_.targetid) return false;
/* 55 */       if (!this.attackinnerbean.equals(_o_.attackinnerbean)) return false;
/* 56 */       if (!this.influenceothers.equals(_o_.influenceothers)) return false;
/* 57 */       if (!this.protect.equals(_o_.protect)) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.targetid;
/* 66 */     _h_ += this.attackinnerbean.hashCode();
/* 67 */     _h_ += this.influenceothers.hashCode();
/* 68 */     _h_ += this.protect.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.targetid).append(",");
/* 76 */     _sb_.append(this.attackinnerbean).append(",");
/* 77 */     _sb_.append(this.influenceothers).append(",");
/* 78 */     _sb_.append(this.protect).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\AttackOtherBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
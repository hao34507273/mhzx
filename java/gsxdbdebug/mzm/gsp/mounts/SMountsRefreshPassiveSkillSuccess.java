/*    */ package mzm.gsp.mounts;
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
/*    */ public class SMountsRefreshPassiveSkillSuccess
/*    */   extends __SMountsRefreshPassiveSkillSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606211;
/*    */   public long mounts_id;
/*    */   public PassiveSkillInfo refresh_passive_skill_result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606211;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMountsRefreshPassiveSkillSuccess()
/*    */   {
/* 34 */     this.refresh_passive_skill_result = new PassiveSkillInfo();
/*    */   }
/*    */   
/*    */   public SMountsRefreshPassiveSkillSuccess(long _mounts_id_, PassiveSkillInfo _refresh_passive_skill_result_) {
/* 38 */     this.mounts_id = _mounts_id_;
/* 39 */     this.refresh_passive_skill_result = _refresh_passive_skill_result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.refresh_passive_skill_result._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.mounts_id);
/* 49 */     _os_.marshal(this.refresh_passive_skill_result);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.mounts_id = _os_.unmarshal_long();
/* 55 */     this.refresh_passive_skill_result.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SMountsRefreshPassiveSkillSuccess)) {
/* 65 */       SMountsRefreshPassiveSkillSuccess _o_ = (SMountsRefreshPassiveSkillSuccess)_o1_;
/* 66 */       if (this.mounts_id != _o_.mounts_id) return false;
/* 67 */       if (!this.refresh_passive_skill_result.equals(_o_.refresh_passive_skill_result)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.mounts_id;
/* 76 */     _h_ += this.refresh_passive_skill_result.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.mounts_id).append(",");
/* 84 */     _sb_.append(this.refresh_passive_skill_result).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMountsRefreshPassiveSkillSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.mounts_id - _o_.mounts_id);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.refresh_passive_skill_result.compareTo(_o_.refresh_passive_skill_result);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsRefreshPassiveSkillSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
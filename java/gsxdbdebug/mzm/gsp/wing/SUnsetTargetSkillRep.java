/*    */ package mzm.gsp.wing;
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
/*    */ public class SUnsetTargetSkillRep
/*    */   extends __SUnsetTargetSkillRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596544;
/*    */   public int cfg_id;
/*    */   public int index;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596544;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUnsetTargetSkillRep() {}
/*    */   
/*    */ 
/*    */   public SUnsetTargetSkillRep(int _cfg_id_, int _index_)
/*    */   {
/* 37 */     this.cfg_id = _cfg_id_;
/* 38 */     this.index = _index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.cfg_id);
/* 47 */     _os_.marshal(this.index);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.cfg_id = _os_.unmarshal_int();
/* 53 */     this.index = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SUnsetTargetSkillRep)) {
/* 63 */       SUnsetTargetSkillRep _o_ = (SUnsetTargetSkillRep)_o1_;
/* 64 */       if (this.cfg_id != _o_.cfg_id) return false;
/* 65 */       if (this.index != _o_.index) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.cfg_id;
/* 74 */     _h_ += this.index;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.cfg_id).append(",");
/* 82 */     _sb_.append(this.index).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUnsetTargetSkillRep _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.cfg_id - _o_.cfg_id;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.index - _o_.index;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SUnsetTargetSkillRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
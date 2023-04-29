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
/*    */ public class SReplaceSkillRes
/*    */   extends __SReplaceSkillRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596523;
/*    */   public int index;
/*    */   public int skillindex;
/*    */   public WingSkill skillresult;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596523;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SReplaceSkillRes()
/*    */   {
/* 33 */     this.skillresult = new WingSkill();
/*    */   }
/*    */   
/*    */   public SReplaceSkillRes(int _index_, int _skillindex_, WingSkill _skillresult_) {
/* 37 */     this.index = _index_;
/* 38 */     this.skillindex = _skillindex_;
/* 39 */     this.skillresult = _skillresult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.skillresult._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.index);
/* 49 */     _os_.marshal(this.skillindex);
/* 50 */     _os_.marshal(this.skillresult);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.index = _os_.unmarshal_int();
/* 56 */     this.skillindex = _os_.unmarshal_int();
/* 57 */     this.skillresult.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SReplaceSkillRes)) {
/* 67 */       SReplaceSkillRes _o_ = (SReplaceSkillRes)_o1_;
/* 68 */       if (this.index != _o_.index) return false;
/* 69 */       if (this.skillindex != _o_.skillindex) return false;
/* 70 */       if (!this.skillresult.equals(_o_.skillresult)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.index;
/* 79 */     _h_ += this.skillindex;
/* 80 */     _h_ += this.skillresult.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.index).append(",");
/* 88 */     _sb_.append(this.skillindex).append(",");
/* 89 */     _sb_.append(this.skillresult).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SReplaceSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
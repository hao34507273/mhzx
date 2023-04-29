/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SSyncApplicantList
/*    */   extends __SSyncApplicantList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588315;
/*    */   public ArrayList<TeamApplicant> applicants;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 12588315;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncApplicantList()
/*    */   {
/* 34 */     this.applicants = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSyncApplicantList(ArrayList<TeamApplicant> _applicants_) {
/* 38 */     this.applicants = _applicants_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     for (TeamApplicant _v_ : this.applicants)
/* 43 */       if (!_v_._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.applicants.size());
/* 49 */     for (TeamApplicant _v_ : this.applicants) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 57 */       TeamApplicant _v_ = new TeamApplicant();
/* 58 */       _v_.unmarshal(_os_);
/* 59 */       this.applicants.add(_v_);
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SSyncApplicantList)) {
/* 70 */       SSyncApplicantList _o_ = (SSyncApplicantList)_o1_;
/* 71 */       if (!this.applicants.equals(_o_.applicants)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.applicants.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.applicants).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SSyncApplicantList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
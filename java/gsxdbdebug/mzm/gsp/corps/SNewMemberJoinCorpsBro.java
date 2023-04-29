/*    */ package mzm.gsp.corps;
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
/*    */ public class SNewMemberJoinCorpsBro
/*    */   extends __SNewMemberJoinCorpsBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617481;
/*    */   public CorpsMemberSynInfo newmember;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617481;
/*    */   }
/*    */   
/*    */ 
/*    */   public SNewMemberJoinCorpsBro()
/*    */   {
/* 33 */     this.newmember = new CorpsMemberSynInfo();
/*    */   }
/*    */   
/*    */   public SNewMemberJoinCorpsBro(CorpsMemberSynInfo _newmember_) {
/* 37 */     this.newmember = _newmember_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.newmember._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.newmember);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.newmember.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SNewMemberJoinCorpsBro)) {
/* 61 */       SNewMemberJoinCorpsBro _o_ = (SNewMemberJoinCorpsBro)_o1_;
/* 62 */       if (!this.newmember.equals(_o_.newmember)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.newmember.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.newmember).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SNewMemberJoinCorpsBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
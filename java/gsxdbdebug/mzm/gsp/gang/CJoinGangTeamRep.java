/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PJoinGangTeamRep;
/*    */ 
/*    */ public class CJoinGangTeamRep
/*    */   extends __CJoinGangTeamRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589998;
/*    */   public static final int REPLY_AGREE = 0;
/*    */   public static final int REPLY_REFUSE = 1;
/*    */   public long applicantid;
/*    */   public int reply;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleid, new PJoinGangTeamRep(roleid, this.applicantid, this.reply));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12589998;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CJoinGangTeamRep() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CJoinGangTeamRep(long _applicantid_, int _reply_)
/*    */   {
/* 42 */     this.applicantid = _applicantid_;
/* 43 */     this.reply = _reply_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.applicantid);
/* 52 */     _os_.marshal(this.reply);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.applicantid = _os_.unmarshal_long();
/* 58 */     this.reply = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CJoinGangTeamRep)) {
/* 68 */       CJoinGangTeamRep _o_ = (CJoinGangTeamRep)_o1_;
/* 69 */       if (this.applicantid != _o_.applicantid) return false;
/* 70 */       if (this.reply != _o_.reply) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.applicantid;
/* 79 */     _h_ += this.reply;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.applicantid).append(",");
/* 87 */     _sb_.append(this.reply).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CJoinGangTeamRep _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.applicantid - _o_.applicantid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.reply - _o_.reply;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CJoinGangTeamRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
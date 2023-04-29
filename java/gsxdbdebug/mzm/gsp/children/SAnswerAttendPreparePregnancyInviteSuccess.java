/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SAnswerAttendPreparePregnancyInviteSuccess
/*     */   extends __SAnswerAttendPreparePregnancyInviteSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609347;
/*     */   public static final int AGREE = 1;
/*     */   public static final int REFUSE = 2;
/*     */   public int answer;
/*     */   public long inviterid;
/*     */   public long inviteeid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609347;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerAttendPreparePregnancyInviteSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnswerAttendPreparePregnancyInviteSuccess(int _answer_, long _inviterid_, long _inviteeid_)
/*     */   {
/*  41 */     this.answer = _answer_;
/*  42 */     this.inviterid = _inviterid_;
/*  43 */     this.inviteeid = _inviteeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.answer);
/*  52 */     _os_.marshal(this.inviterid);
/*  53 */     _os_.marshal(this.inviteeid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.answer = _os_.unmarshal_int();
/*  59 */     this.inviterid = _os_.unmarshal_long();
/*  60 */     this.inviteeid = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof SAnswerAttendPreparePregnancyInviteSuccess)) {
/*  70 */       SAnswerAttendPreparePregnancyInviteSuccess _o_ = (SAnswerAttendPreparePregnancyInviteSuccess)_o1_;
/*  71 */       if (this.answer != _o_.answer) return false;
/*  72 */       if (this.inviterid != _o_.inviterid) return false;
/*  73 */       if (this.inviteeid != _o_.inviteeid) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.answer;
/*  82 */     _h_ += (int)this.inviterid;
/*  83 */     _h_ += (int)this.inviteeid;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.answer).append(",");
/*  91 */     _sb_.append(this.inviterid).append(",");
/*  92 */     _sb_.append(this.inviteeid).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAnswerAttendPreparePregnancyInviteSuccess _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.answer - _o_.answer;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = Long.signum(this.inviterid - _o_.inviterid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.inviteeid - _o_.inviteeid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SAnswerAttendPreparePregnancyInviteSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
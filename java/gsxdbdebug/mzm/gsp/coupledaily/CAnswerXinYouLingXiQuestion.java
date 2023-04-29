/*     */ package mzm.gsp.coupledaily;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.coupledaily.main.PCAnswerXinYouLingXiQuestion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CAnswerXinYouLingXiQuestion
/*     */   extends __CAnswerXinYouLingXiQuestion__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602381;
/*     */   public int answer;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCAnswerXinYouLingXiQuestion(roleId, this.sessionid, this.answer));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12602381;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAnswerXinYouLingXiQuestion() {}
/*     */   
/*     */ 
/*     */   public CAnswerXinYouLingXiQuestion(int _answer_, long _sessionid_)
/*     */   {
/*  43 */     this.answer = _answer_;
/*  44 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.answer);
/*  53 */     _os_.marshal(this.sessionid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.answer = _os_.unmarshal_int();
/*  59 */     this.sessionid = _os_.unmarshal_long();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CAnswerXinYouLingXiQuestion)) {
/*  69 */       CAnswerXinYouLingXiQuestion _o_ = (CAnswerXinYouLingXiQuestion)_o1_;
/*  70 */       if (this.answer != _o_.answer) return false;
/*  71 */       if (this.sessionid != _o_.sessionid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.answer;
/*  80 */     _h_ += (int)this.sessionid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.answer).append(",");
/*  88 */     _sb_.append(this.sessionid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAnswerXinYouLingXiQuestion _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.answer - _o_.answer;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\CAnswerXinYouLingXiQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
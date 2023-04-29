/*     */ package mzm.gsp.question;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.question.main.PGangHelpAnswerReq;
/*     */ 
/*     */ public class CGangHelpAnswerReq
/*     */   extends __CGangHelpAnswerReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594698;
/*     */   public int questionid;
/*     */   public int pageindex;
/*     */   public long roleid;
/*     */   public String answerstring;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PGangHelpAnswerReq(roleId, this.questionid, this.pageindex, this.roleid, this.answerstring));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12594698;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGangHelpAnswerReq()
/*     */   {
/*  40 */     this.answerstring = "";
/*     */   }
/*     */   
/*     */   public CGangHelpAnswerReq(int _questionid_, int _pageindex_, long _roleid_, String _answerstring_) {
/*  44 */     this.questionid = _questionid_;
/*  45 */     this.pageindex = _pageindex_;
/*  46 */     this.roleid = _roleid_;
/*  47 */     this.answerstring = _answerstring_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.questionid);
/*  56 */     _os_.marshal(this.pageindex);
/*  57 */     _os_.marshal(this.roleid);
/*  58 */     _os_.marshal(this.answerstring, "UTF-16LE");
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.questionid = _os_.unmarshal_int();
/*  64 */     this.pageindex = _os_.unmarshal_int();
/*  65 */     this.roleid = _os_.unmarshal_long();
/*  66 */     this.answerstring = _os_.unmarshal_String("UTF-16LE");
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CGangHelpAnswerReq)) {
/*  76 */       CGangHelpAnswerReq _o_ = (CGangHelpAnswerReq)_o1_;
/*  77 */       if (this.questionid != _o_.questionid) return false;
/*  78 */       if (this.pageindex != _o_.pageindex) return false;
/*  79 */       if (this.roleid != _o_.roleid) return false;
/*  80 */       if (!this.answerstring.equals(_o_.answerstring)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.questionid;
/*  89 */     _h_ += this.pageindex;
/*  90 */     _h_ += (int)this.roleid;
/*  91 */     _h_ += this.answerstring.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.questionid).append(",");
/*  99 */     _sb_.append(this.pageindex).append(",");
/* 100 */     _sb_.append(this.roleid).append(",");
/* 101 */     _sb_.append("T").append(this.answerstring.length()).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CGangHelpAnswerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
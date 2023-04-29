/*     */ package mzm.gsp.memorycompetition;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.memorycompetition.main.PCMemoryCompetitionHelpAnswer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CMemoryCompetitionHelpAnswer
/*     */   extends __CMemoryCompetitionHelpAnswer__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613124;
/*     */   public long seek_help_role_id;
/*     */   public int answer_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCMemoryCompetitionHelpAnswer(roleId, this.seek_help_role_id, this.answer_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12613124;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CMemoryCompetitionHelpAnswer() {}
/*     */   
/*     */ 
/*     */   public CMemoryCompetitionHelpAnswer(long _seek_help_role_id_, int _answer_id_)
/*     */   {
/*  43 */     this.seek_help_role_id = _seek_help_role_id_;
/*  44 */     this.answer_id = _answer_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.seek_help_role_id);
/*  53 */     _os_.marshal(this.answer_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.seek_help_role_id = _os_.unmarshal_long();
/*  59 */     this.answer_id = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CMemoryCompetitionHelpAnswer)) {
/*  69 */       CMemoryCompetitionHelpAnswer _o_ = (CMemoryCompetitionHelpAnswer)_o1_;
/*  70 */       if (this.seek_help_role_id != _o_.seek_help_role_id) return false;
/*  71 */       if (this.answer_id != _o_.answer_id) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.seek_help_role_id;
/*  80 */     _h_ += this.answer_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.seek_help_role_id).append(",");
/*  88 */     _sb_.append(this.answer_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMemoryCompetitionHelpAnswer _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.seek_help_role_id - _o_.seek_help_role_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.answer_id - _o_.answer_id;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\CMemoryCompetitionHelpAnswer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
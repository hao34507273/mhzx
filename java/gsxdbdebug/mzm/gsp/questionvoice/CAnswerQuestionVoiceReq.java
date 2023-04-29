/*     */ package mzm.gsp.questionvoice;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.questionvoice.main.PCAnswerQuestionVoiceReq;
/*     */ 
/*     */ public class CAnswerQuestionVoiceReq
/*     */   extends __CAnswerQuestionVoiceReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620802;
/*     */   public int activity_id;
/*     */   public int npc_id;
/*     */   public int question_id;
/*     */   public int answer_index;
/*     */   public long session_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCAnswerQuestionVoiceReq(roleId, this.activity_id, this.npc_id, this.question_id, this.answer_index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12620802;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAnswerQuestionVoiceReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAnswerQuestionVoiceReq(int _activity_id_, int _npc_id_, int _question_id_, int _answer_index_, long _session_id_)
/*     */   {
/*  46 */     this.activity_id = _activity_id_;
/*  47 */     this.npc_id = _npc_id_;
/*  48 */     this.question_id = _question_id_;
/*  49 */     this.answer_index = _answer_index_;
/*  50 */     this.session_id = _session_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.activity_id);
/*  59 */     _os_.marshal(this.npc_id);
/*  60 */     _os_.marshal(this.question_id);
/*  61 */     _os_.marshal(this.answer_index);
/*  62 */     _os_.marshal(this.session_id);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.activity_id = _os_.unmarshal_int();
/*  68 */     this.npc_id = _os_.unmarshal_int();
/*  69 */     this.question_id = _os_.unmarshal_int();
/*  70 */     this.answer_index = _os_.unmarshal_int();
/*  71 */     this.session_id = _os_.unmarshal_long();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CAnswerQuestionVoiceReq)) {
/*  81 */       CAnswerQuestionVoiceReq _o_ = (CAnswerQuestionVoiceReq)_o1_;
/*  82 */       if (this.activity_id != _o_.activity_id) return false;
/*  83 */       if (this.npc_id != _o_.npc_id) return false;
/*  84 */       if (this.question_id != _o_.question_id) return false;
/*  85 */       if (this.answer_index != _o_.answer_index) return false;
/*  86 */       if (this.session_id != _o_.session_id) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.activity_id;
/*  95 */     _h_ += this.npc_id;
/*  96 */     _h_ += this.question_id;
/*  97 */     _h_ += this.answer_index;
/*  98 */     _h_ += (int)this.session_id;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.activity_id).append(",");
/* 106 */     _sb_.append(this.npc_id).append(",");
/* 107 */     _sb_.append(this.question_id).append(",");
/* 108 */     _sb_.append(this.answer_index).append(",");
/* 109 */     _sb_.append(this.session_id).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAnswerQuestionVoiceReq _o_) {
/* 115 */     if (_o_ == this) return 0;
/* 116 */     int _c_ = 0;
/* 117 */     _c_ = this.activity_id - _o_.activity_id;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.npc_id - _o_.npc_id;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.question_id - _o_.question_id;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.answer_index - _o_.answer_index;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = Long.signum(this.session_id - _o_.session_id);
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\CAnswerQuestionVoiceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
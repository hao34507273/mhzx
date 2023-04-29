/*     */ package mzm.gsp.bandstand;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.bandstand.main.PCBandstandAnswerReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CBandstandAnswerReq
/*     */   extends __CBandstandAnswerReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627977;
/*     */   public int music_id;
/*     */   public int fragment_index;
/*     */   public int answer_index;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCBandstandAnswerReq(roleId, this.music_id, this.fragment_index, this.answer_index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12627977;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBandstandAnswerReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBandstandAnswerReq(int _music_id_, int _fragment_index_, int _answer_index_)
/*     */   {
/*  43 */     this.music_id = _music_id_;
/*  44 */     this.fragment_index = _fragment_index_;
/*  45 */     this.answer_index = _answer_index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.music_id);
/*  54 */     _os_.marshal(this.fragment_index);
/*  55 */     _os_.marshal(this.answer_index);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.music_id = _os_.unmarshal_int();
/*  61 */     this.fragment_index = _os_.unmarshal_int();
/*  62 */     this.answer_index = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CBandstandAnswerReq)) {
/*  72 */       CBandstandAnswerReq _o_ = (CBandstandAnswerReq)_o1_;
/*  73 */       if (this.music_id != _o_.music_id) return false;
/*  74 */       if (this.fragment_index != _o_.fragment_index) return false;
/*  75 */       if (this.answer_index != _o_.answer_index) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.music_id;
/*  84 */     _h_ += this.fragment_index;
/*  85 */     _h_ += this.answer_index;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.music_id).append(",");
/*  93 */     _sb_.append(this.fragment_index).append(",");
/*  94 */     _sb_.append(this.answer_index).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBandstandAnswerReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.music_id - _o_.music_id;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.fragment_index - _o_.fragment_index;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.answer_index - _o_.answer_index;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\CBandstandAnswerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
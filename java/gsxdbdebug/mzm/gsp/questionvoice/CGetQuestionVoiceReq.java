/*     */ package mzm.gsp.questionvoice;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.questionvoice.main.PCGetQuestionVoiceReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGetQuestionVoiceReq
/*     */   extends __CGetQuestionVoiceReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620801;
/*     */   public int activity_id;
/*     */   public int npc_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  21 */     long roleId = Role.getRoleId(this);
/*  22 */     if (roleId < 0L)
/*     */     {
/*  24 */       return;
/*     */     }
/*  26 */     Role.addRoleProcedure(roleId, new PCGetQuestionVoiceReq(roleId, this.activity_id, this.npc_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12620801;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetQuestionVoiceReq() {}
/*     */   
/*     */ 
/*     */   public CGetQuestionVoiceReq(int _activity_id_, int _npc_id_)
/*     */   {
/*  44 */     this.activity_id = _activity_id_;
/*  45 */     this.npc_id = _npc_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activity_id);
/*  54 */     _os_.marshal(this.npc_id);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activity_id = _os_.unmarshal_int();
/*  60 */     this.npc_id = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CGetQuestionVoiceReq)) {
/*  70 */       CGetQuestionVoiceReq _o_ = (CGetQuestionVoiceReq)_o1_;
/*  71 */       if (this.activity_id != _o_.activity_id) return false;
/*  72 */       if (this.npc_id != _o_.npc_id) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.activity_id;
/*  81 */     _h_ += this.npc_id;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.activity_id).append(",");
/*  89 */     _sb_.append(this.npc_id).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetQuestionVoiceReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_id - _o_.activity_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.npc_id - _o_.npc_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\CGetQuestionVoiceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
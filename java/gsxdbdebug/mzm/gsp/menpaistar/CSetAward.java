/*     */ package mzm.gsp.menpaistar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.menpaistar.main.PCSetAward;
/*     */ 
/*     */ 
/*     */ public class CSetAward
/*     */   extends __CSetAward__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612354;
/*     */   public long client_yuanbao;
/*     */   public VoteAwardInfo vote_award_info;
/*     */   public int vote_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCSetAward(roleId, this.client_yuanbao, this.vote_award_info, this.vote_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12612354;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSetAward()
/*     */   {
/*  40 */     this.vote_award_info = new VoteAwardInfo();
/*     */   }
/*     */   
/*     */   public CSetAward(long _client_yuanbao_, VoteAwardInfo _vote_award_info_, int _vote_num_) {
/*  44 */     this.client_yuanbao = _client_yuanbao_;
/*  45 */     this.vote_award_info = _vote_award_info_;
/*  46 */     this.vote_num = _vote_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.vote_award_info._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.client_yuanbao);
/*  56 */     _os_.marshal(this.vote_award_info);
/*  57 */     _os_.marshal(this.vote_num);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.client_yuanbao = _os_.unmarshal_long();
/*  63 */     this.vote_award_info.unmarshal(_os_);
/*  64 */     this.vote_num = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CSetAward)) {
/*  74 */       CSetAward _o_ = (CSetAward)_o1_;
/*  75 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  76 */       if (!this.vote_award_info.equals(_o_.vote_award_info)) return false;
/*  77 */       if (this.vote_num != _o_.vote_num) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.client_yuanbao;
/*  86 */     _h_ += this.vote_award_info.hashCode();
/*  87 */     _h_ += this.vote_num;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.client_yuanbao).append(",");
/*  95 */     _sb_.append(this.vote_award_info).append(",");
/*  96 */     _sb_.append(this.vote_num).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSetAward _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.vote_award_info.compareTo(_o_.vote_award_info);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.vote_num - _o_.vote_num;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\CSetAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
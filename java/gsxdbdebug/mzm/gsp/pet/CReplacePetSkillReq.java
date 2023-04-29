/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PCReplacePetSkillReq;
/*     */ 
/*     */ 
/*     */ public class CReplacePetSkillReq
/*     */   extends __CReplacePetSkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590657;
/*     */   public long petid;
/*     */   public int iscostyuanbao;
/*     */   public long curyuanbao;
/*     */   public int costyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCReplacePetSkillReq(roleId, this.petid, this.iscostyuanbao, this.curyuanbao, this.costyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12590657;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReplacePetSkillReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReplacePetSkillReq(long _petid_, int _iscostyuanbao_, long _curyuanbao_, int _costyuanbao_)
/*     */   {
/*  44 */     this.petid = _petid_;
/*  45 */     this.iscostyuanbao = _iscostyuanbao_;
/*  46 */     this.curyuanbao = _curyuanbao_;
/*  47 */     this.costyuanbao = _costyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.petid);
/*  56 */     _os_.marshal(this.iscostyuanbao);
/*  57 */     _os_.marshal(this.curyuanbao);
/*  58 */     _os_.marshal(this.costyuanbao);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.petid = _os_.unmarshal_long();
/*  64 */     this.iscostyuanbao = _os_.unmarshal_int();
/*  65 */     this.curyuanbao = _os_.unmarshal_long();
/*  66 */     this.costyuanbao = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CReplacePetSkillReq)) {
/*  76 */       CReplacePetSkillReq _o_ = (CReplacePetSkillReq)_o1_;
/*  77 */       if (this.petid != _o_.petid) return false;
/*  78 */       if (this.iscostyuanbao != _o_.iscostyuanbao) return false;
/*  79 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  80 */       if (this.costyuanbao != _o_.costyuanbao) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.petid;
/*  89 */     _h_ += this.iscostyuanbao;
/*  90 */     _h_ += (int)this.curyuanbao;
/*  91 */     _h_ += this.costyuanbao;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.petid).append(",");
/*  99 */     _sb_.append(this.iscostyuanbao).append(",");
/* 100 */     _sb_.append(this.curyuanbao).append(",");
/* 101 */     _sb_.append(this.costyuanbao).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReplacePetSkillReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.iscostyuanbao - _o_.iscostyuanbao;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.costyuanbao - _o_.costyuanbao;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CReplacePetSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
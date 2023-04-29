/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PRemeberSkillReq;
/*     */ 
/*     */ public class CRemeberSkillReq
/*     */   extends __CRemeberSkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590602;
/*     */   public long petid;
/*     */   public int skillid;
/*     */   public int costtype;
/*     */   public long yuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PRemeberSkillReq(roleId, this.petid, this.skillid, this.yuanbaonum, this.costtype));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590602;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CRemeberSkillReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CRemeberSkillReq(long _petid_, int _skillid_, int _costtype_, long _yuanbaonum_)
/*     */   {
/*  43 */     this.petid = _petid_;
/*  44 */     this.skillid = _skillid_;
/*  45 */     this.costtype = _costtype_;
/*  46 */     this.yuanbaonum = _yuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.petid);
/*  55 */     _os_.marshal(this.skillid);
/*  56 */     _os_.marshal(this.costtype);
/*  57 */     _os_.marshal(this.yuanbaonum);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.petid = _os_.unmarshal_long();
/*  63 */     this.skillid = _os_.unmarshal_int();
/*  64 */     this.costtype = _os_.unmarshal_int();
/*  65 */     this.yuanbaonum = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CRemeberSkillReq)) {
/*  75 */       CRemeberSkillReq _o_ = (CRemeberSkillReq)_o1_;
/*  76 */       if (this.petid != _o_.petid) return false;
/*  77 */       if (this.skillid != _o_.skillid) return false;
/*  78 */       if (this.costtype != _o_.costtype) return false;
/*  79 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.petid;
/*  88 */     _h_ += this.skillid;
/*  89 */     _h_ += this.costtype;
/*  90 */     _h_ += (int)this.yuanbaonum;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.petid).append(",");
/*  98 */     _sb_.append(this.skillid).append(",");
/*  99 */     _sb_.append(this.costtype).append(",");
/* 100 */     _sb_.append(this.yuanbaonum).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CRemeberSkillReq _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.skillid - _o_.skillid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.costtype - _o_.costtype;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.yuanbaonum - _o_.yuanbaonum);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CRemeberSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
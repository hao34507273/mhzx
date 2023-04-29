/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCFightSkillOperReq;
/*     */ 
/*     */ public class CFightSkillOperReq
/*     */   extends __CFightSkillOperReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609403;
/*     */   public static final int USE = 1;
/*     */   public static final int UN_USE = 2;
/*     */   public long childrenid;
/*     */   public int skillid;
/*     */   public int use;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCFightSkillOperReq(roleid, this.childrenid, this.skillid, this.use));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12609403;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFightSkillOperReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFightSkillOperReq(long _childrenid_, int _skillid_, int _use_)
/*     */   {
/*  43 */     this.childrenid = _childrenid_;
/*  44 */     this.skillid = _skillid_;
/*  45 */     this.use = _use_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.childrenid);
/*  54 */     _os_.marshal(this.skillid);
/*  55 */     _os_.marshal(this.use);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.childrenid = _os_.unmarshal_long();
/*  61 */     this.skillid = _os_.unmarshal_int();
/*  62 */     this.use = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CFightSkillOperReq)) {
/*  72 */       CFightSkillOperReq _o_ = (CFightSkillOperReq)_o1_;
/*  73 */       if (this.childrenid != _o_.childrenid) return false;
/*  74 */       if (this.skillid != _o_.skillid) return false;
/*  75 */       if (this.use != _o_.use) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.childrenid;
/*  84 */     _h_ += this.skillid;
/*  85 */     _h_ += this.use;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.childrenid).append(",");
/*  93 */     _sb_.append(this.skillid).append(",");
/*  94 */     _sb_.append(this.use).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFightSkillOperReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.skillid - _o_.skillid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.use - _o_.use;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CFightSkillOperReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCStudyCommonSkillReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CStudyCommonSkillReq
/*     */   extends __CStudyCommonSkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609389;
/*     */   public long childrenid;
/*     */   public int itemkey;
/*     */   public int pos;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCStudyCommonSkillReq(roleid, this.childrenid, this.itemkey, this.pos));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12609389;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CStudyCommonSkillReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CStudyCommonSkillReq(long _childrenid_, int _itemkey_, int _pos_)
/*     */   {
/*  40 */     this.childrenid = _childrenid_;
/*  41 */     this.itemkey = _itemkey_;
/*  42 */     this.pos = _pos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.childrenid);
/*  51 */     _os_.marshal(this.itemkey);
/*  52 */     _os_.marshal(this.pos);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.childrenid = _os_.unmarshal_long();
/*  58 */     this.itemkey = _os_.unmarshal_int();
/*  59 */     this.pos = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CStudyCommonSkillReq)) {
/*  69 */       CStudyCommonSkillReq _o_ = (CStudyCommonSkillReq)_o1_;
/*  70 */       if (this.childrenid != _o_.childrenid) return false;
/*  71 */       if (this.itemkey != _o_.itemkey) return false;
/*  72 */       if (this.pos != _o_.pos) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.childrenid;
/*  81 */     _h_ += this.itemkey;
/*  82 */     _h_ += this.pos;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.childrenid).append(",");
/*  90 */     _sb_.append(this.itemkey).append(",");
/*  91 */     _sb_.append(this.pos).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CStudyCommonSkillReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.itemkey - _o_.itemkey;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.pos - _o_.pos;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CStudyCommonSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
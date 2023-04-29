/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCAddAptitudeReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CAddAptitudeRep
/*     */   extends __CAddAptitudeRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609373;
/*     */   public long childrenid;
/*     */   public int apttype;
/*     */   public int itemid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCAddAptitudeReq(roleid, this.childrenid, this.apttype, this.itemid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12609373;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAddAptitudeRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAddAptitudeRep(long _childrenid_, int _apttype_, int _itemid_)
/*     */   {
/*  40 */     this.childrenid = _childrenid_;
/*  41 */     this.apttype = _apttype_;
/*  42 */     this.itemid = _itemid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.childrenid);
/*  51 */     _os_.marshal(this.apttype);
/*  52 */     _os_.marshal(this.itemid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.childrenid = _os_.unmarshal_long();
/*  58 */     this.apttype = _os_.unmarshal_int();
/*  59 */     this.itemid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CAddAptitudeRep)) {
/*  69 */       CAddAptitudeRep _o_ = (CAddAptitudeRep)_o1_;
/*  70 */       if (this.childrenid != _o_.childrenid) return false;
/*  71 */       if (this.apttype != _o_.apttype) return false;
/*  72 */       if (this.itemid != _o_.itemid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.childrenid;
/*  81 */     _h_ += this.apttype;
/*  82 */     _h_ += this.itemid;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.childrenid).append(",");
/*  90 */     _sb_.append(this.apttype).append(",");
/*  91 */     _sb_.append(this.itemid).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAddAptitudeRep _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.apttype - _o_.apttype;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.itemid - _o_.itemid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CAddAptitudeRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
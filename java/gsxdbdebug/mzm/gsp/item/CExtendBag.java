/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PExtendBag;
/*     */ 
/*     */ 
/*     */ public class CExtendBag
/*     */   extends __CExtendBag__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584731;
/*     */   public int bagid;
/*     */   public int isuseyuanbao;
/*     */   public long curyuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*     */     
/*  21 */     if (this.bagid == 340600000) {
/*  22 */       Role.addRoleProcedure(roleid, new PExtendBag(roleid, this.bagid, this.curyuanbaonum, this.isuseyuanbao));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12584731;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExtendBag() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CExtendBag(int _bagid_, int _isuseyuanbao_, long _curyuanbaonum_)
/*     */   {
/*  42 */     this.bagid = _bagid_;
/*  43 */     this.isuseyuanbao = _isuseyuanbao_;
/*  44 */     this.curyuanbaonum = _curyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.bagid);
/*  53 */     _os_.marshal(this.isuseyuanbao);
/*  54 */     _os_.marshal(this.curyuanbaonum);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.bagid = _os_.unmarshal_int();
/*  60 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  61 */     this.curyuanbaonum = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CExtendBag)) {
/*  71 */       CExtendBag _o_ = (CExtendBag)_o1_;
/*  72 */       if (this.bagid != _o_.bagid) return false;
/*  73 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  74 */       if (this.curyuanbaonum != _o_.curyuanbaonum) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.bagid;
/*  83 */     _h_ += this.isuseyuanbao;
/*  84 */     _h_ += (int)this.curyuanbaonum;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.bagid).append(",");
/*  92 */     _sb_.append(this.isuseyuanbao).append(",");
/*  93 */     _sb_.append(this.curyuanbaonum).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExtendBag _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.bagid - _o_.bagid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.curyuanbaonum - _o_.curyuanbaonum);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CExtendBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
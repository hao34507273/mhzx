/*     */ package mzm.gsp.xiulian;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.xiulian.main.PUseXiuLianItemReq;
/*     */ 
/*     */ 
/*     */ public class CUseXiuLianItemReq
/*     */   extends __CUseXiuLianItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589573;
/*     */   public int itemkey;
/*     */   public int skillbagid;
/*     */   public int isuseall;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PUseXiuLianItemReq(roleId, this.itemkey, this.isuseall == 1, this.skillbagid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12589573;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CUseXiuLianItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CUseXiuLianItemReq(int _itemkey_, int _skillbagid_, int _isuseall_)
/*     */   {
/*  42 */     this.itemkey = _itemkey_;
/*  43 */     this.skillbagid = _skillbagid_;
/*  44 */     this.isuseall = _isuseall_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.itemkey);
/*  53 */     _os_.marshal(this.skillbagid);
/*  54 */     _os_.marshal(this.isuseall);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.itemkey = _os_.unmarshal_int();
/*  60 */     this.skillbagid = _os_.unmarshal_int();
/*  61 */     this.isuseall = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CUseXiuLianItemReq)) {
/*  71 */       CUseXiuLianItemReq _o_ = (CUseXiuLianItemReq)_o1_;
/*  72 */       if (this.itemkey != _o_.itemkey) return false;
/*  73 */       if (this.skillbagid != _o_.skillbagid) return false;
/*  74 */       if (this.isuseall != _o_.isuseall) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.itemkey;
/*  83 */     _h_ += this.skillbagid;
/*  84 */     _h_ += this.isuseall;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.itemkey).append(",");
/*  92 */     _sb_.append(this.skillbagid).append(",");
/*  93 */     _sb_.append(this.isuseall).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CUseXiuLianItemReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.itemkey - _o_.itemkey;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.skillbagid - _o_.skillbagid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.isuseall - _o_.isuseall;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\CUseXiuLianItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
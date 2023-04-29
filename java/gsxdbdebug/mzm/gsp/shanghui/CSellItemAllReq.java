/*     */ package mzm.gsp.shanghui;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.shanghui.main.PSellItemAllReq;
/*     */ 
/*     */ 
/*     */ public class CSellItemAllReq
/*     */   extends __CSellItemAllReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592651;
/*     */   public int bagid;
/*     */   public int itemkey;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PSellItemAllReq(roleId, this.bagid, this.itemkey, this.itemid, this.itemnum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12592651;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSellItemAllReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSellItemAllReq(int _bagid_, int _itemkey_, int _itemid_, int _itemnum_)
/*     */   {
/*  44 */     this.bagid = _bagid_;
/*  45 */     this.itemkey = _itemkey_;
/*  46 */     this.itemid = _itemid_;
/*  47 */     this.itemnum = _itemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.bagid);
/*  56 */     _os_.marshal(this.itemkey);
/*  57 */     _os_.marshal(this.itemid);
/*  58 */     _os_.marshal(this.itemnum);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.bagid = _os_.unmarshal_int();
/*  64 */     this.itemkey = _os_.unmarshal_int();
/*  65 */     this.itemid = _os_.unmarshal_int();
/*  66 */     this.itemnum = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CSellItemAllReq)) {
/*  76 */       CSellItemAllReq _o_ = (CSellItemAllReq)_o1_;
/*  77 */       if (this.bagid != _o_.bagid) return false;
/*  78 */       if (this.itemkey != _o_.itemkey) return false;
/*  79 */       if (this.itemid != _o_.itemid) return false;
/*  80 */       if (this.itemnum != _o_.itemnum) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.bagid;
/*  89 */     _h_ += this.itemkey;
/*  90 */     _h_ += this.itemid;
/*  91 */     _h_ += this.itemnum;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.bagid).append(",");
/*  99 */     _sb_.append(this.itemkey).append(",");
/* 100 */     _sb_.append(this.itemid).append(",");
/* 101 */     _sb_.append(this.itemnum).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSellItemAllReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.bagid - _o_.bagid;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.itemkey - _o_.itemkey;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.itemid - _o_.itemid;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.itemnum - _o_.itemnum;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\CSellItemAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
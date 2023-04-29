/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SUseGangFileItemRes
/*     */   extends __SUseGangFileItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584737;
/*     */   public long roleid;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   public int gangmoneynum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584737;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseGangFileItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseGangFileItemRes(long _roleid_, int _itemid_, int _itemnum_, int _gangmoneynum_)
/*     */   {
/*  37 */     this.roleid = _roleid_;
/*  38 */     this.itemid = _itemid_;
/*  39 */     this.itemnum = _itemnum_;
/*  40 */     this.gangmoneynum = _gangmoneynum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.roleid);
/*  49 */     _os_.marshal(this.itemid);
/*  50 */     _os_.marshal(this.itemnum);
/*  51 */     _os_.marshal(this.gangmoneynum);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.roleid = _os_.unmarshal_long();
/*  57 */     this.itemid = _os_.unmarshal_int();
/*  58 */     this.itemnum = _os_.unmarshal_int();
/*  59 */     this.gangmoneynum = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SUseGangFileItemRes)) {
/*  69 */       SUseGangFileItemRes _o_ = (SUseGangFileItemRes)_o1_;
/*  70 */       if (this.roleid != _o_.roleid) return false;
/*  71 */       if (this.itemid != _o_.itemid) return false;
/*  72 */       if (this.itemnum != _o_.itemnum) return false;
/*  73 */       if (this.gangmoneynum != _o_.gangmoneynum) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.roleid;
/*  82 */     _h_ += this.itemid;
/*  83 */     _h_ += this.itemnum;
/*  84 */     _h_ += this.gangmoneynum;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.roleid).append(",");
/*  92 */     _sb_.append(this.itemid).append(",");
/*  93 */     _sb_.append(this.itemnum).append(",");
/*  94 */     _sb_.append(this.gangmoneynum).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseGangFileItemRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.itemid - _o_.itemid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.itemnum - _o_.itemnum;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.gangmoneynum - _o_.gangmoneynum;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseGangFileItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
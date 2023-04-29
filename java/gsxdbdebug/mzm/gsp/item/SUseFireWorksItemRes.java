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
/*     */ 
/*     */ public class SUseFireWorksItemRes
/*     */   extends __SUseFireWorksItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584823;
/*     */   public long roleid;
/*     */   public int mapcfgid;
/*     */   public int x;
/*     */   public int y;
/*     */   public int itemcfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584823;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseFireWorksItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseFireWorksItemRes(long _roleid_, int _mapcfgid_, int _x_, int _y_, int _itemcfgid_)
/*     */   {
/*  40 */     this.roleid = _roleid_;
/*  41 */     this.mapcfgid = _mapcfgid_;
/*  42 */     this.x = _x_;
/*  43 */     this.y = _y_;
/*  44 */     this.itemcfgid = _itemcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.mapcfgid);
/*  54 */     _os_.marshal(this.x);
/*  55 */     _os_.marshal(this.y);
/*  56 */     _os_.marshal(this.itemcfgid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.roleid = _os_.unmarshal_long();
/*  62 */     this.mapcfgid = _os_.unmarshal_int();
/*  63 */     this.x = _os_.unmarshal_int();
/*  64 */     this.y = _os_.unmarshal_int();
/*  65 */     this.itemcfgid = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SUseFireWorksItemRes)) {
/*  75 */       SUseFireWorksItemRes _o_ = (SUseFireWorksItemRes)_o1_;
/*  76 */       if (this.roleid != _o_.roleid) return false;
/*  77 */       if (this.mapcfgid != _o_.mapcfgid) return false;
/*  78 */       if (this.x != _o_.x) return false;
/*  79 */       if (this.y != _o_.y) return false;
/*  80 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.roleid;
/*  89 */     _h_ += this.mapcfgid;
/*  90 */     _h_ += this.x;
/*  91 */     _h_ += this.y;
/*  92 */     _h_ += this.itemcfgid;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.roleid).append(",");
/* 100 */     _sb_.append(this.mapcfgid).append(",");
/* 101 */     _sb_.append(this.x).append(",");
/* 102 */     _sb_.append(this.y).append(",");
/* 103 */     _sb_.append(this.itemcfgid).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseFireWorksItemRes _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.mapcfgid - _o_.mapcfgid;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.x - _o_.x;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.y - _o_.y;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.itemcfgid - _o_.itemcfgid;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseFireWorksItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
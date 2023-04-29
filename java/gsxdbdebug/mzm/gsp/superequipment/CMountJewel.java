/*     */ package mzm.gsp.superequipment;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.superequipment.jewel.main.PCMountJewel;
/*     */ 
/*     */ public class CMountJewel
/*     */   extends __CMountJewel__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618770;
/*     */   public int bagid;
/*     */   public int grid;
/*     */   public int index;
/*     */   public int jewelcfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCMountJewel(roleId, this.bagid, this.grid, this.index, this.jewelcfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12618770;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CMountJewel() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CMountJewel(int _bagid_, int _grid_, int _index_, int _jewelcfgid_)
/*     */   {
/*  45 */     this.bagid = _bagid_;
/*  46 */     this.grid = _grid_;
/*  47 */     this.index = _index_;
/*  48 */     this.jewelcfgid = _jewelcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.bagid);
/*  57 */     _os_.marshal(this.grid);
/*  58 */     _os_.marshal(this.index);
/*  59 */     _os_.marshal(this.jewelcfgid);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.bagid = _os_.unmarshal_int();
/*  65 */     this.grid = _os_.unmarshal_int();
/*  66 */     this.index = _os_.unmarshal_int();
/*  67 */     this.jewelcfgid = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CMountJewel)) {
/*  77 */       CMountJewel _o_ = (CMountJewel)_o1_;
/*  78 */       if (this.bagid != _o_.bagid) return false;
/*  79 */       if (this.grid != _o_.grid) return false;
/*  80 */       if (this.index != _o_.index) return false;
/*  81 */       if (this.jewelcfgid != _o_.jewelcfgid) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.bagid;
/*  90 */     _h_ += this.grid;
/*  91 */     _h_ += this.index;
/*  92 */     _h_ += this.jewelcfgid;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.bagid).append(",");
/* 100 */     _sb_.append(this.grid).append(",");
/* 101 */     _sb_.append(this.index).append(",");
/* 102 */     _sb_.append(this.jewelcfgid).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMountJewel _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.bagid - _o_.bagid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.grid - _o_.grid;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.index - _o_.index;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.jewelcfgid - _o_.jewelcfgid;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CMountJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
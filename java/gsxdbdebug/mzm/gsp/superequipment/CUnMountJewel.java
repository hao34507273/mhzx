/*     */ package mzm.gsp.superequipment;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.superequipment.jewel.main.PCUnMountJewel;
/*     */ 
/*     */ 
/*     */ public class CUnMountJewel
/*     */   extends __CUnMountJewel__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618763;
/*     */   public int bagid;
/*     */   public int grid;
/*     */   public int index;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCUnMountJewel(roleId, this.bagid, this.grid, this.index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12618763;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CUnMountJewel() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CUnMountJewel(int _bagid_, int _grid_, int _index_)
/*     */   {
/*  43 */     this.bagid = _bagid_;
/*  44 */     this.grid = _grid_;
/*  45 */     this.index = _index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.bagid);
/*  54 */     _os_.marshal(this.grid);
/*  55 */     _os_.marshal(this.index);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.bagid = _os_.unmarshal_int();
/*  61 */     this.grid = _os_.unmarshal_int();
/*  62 */     this.index = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CUnMountJewel)) {
/*  72 */       CUnMountJewel _o_ = (CUnMountJewel)_o1_;
/*  73 */       if (this.bagid != _o_.bagid) return false;
/*  74 */       if (this.grid != _o_.grid) return false;
/*  75 */       if (this.index != _o_.index) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.bagid;
/*  84 */     _h_ += this.grid;
/*  85 */     _h_ += this.index;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.bagid).append(",");
/*  93 */     _sb_.append(this.grid).append(",");
/*  94 */     _sb_.append(this.index).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CUnMountJewel _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.bagid - _o_.bagid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.grid - _o_.grid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.index - _o_.index;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CUnMountJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.feisheng;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.feisheng.developitem.PCDevelopItemInDevelopItemActivity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CDevelopItemInDevelopItemActivityReq
/*     */   extends __CDevelopItemInDevelopItemActivityReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12614175;
/*     */   public int activity_cfg_id;
/*     */   public int grid;
/*     */   public int add_extra_value;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PCDevelopItemInDevelopItemActivity(roleid, this.activity_cfg_id, this.grid, this.add_extra_value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12614175;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CDevelopItemInDevelopItemActivityReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CDevelopItemInDevelopItemActivityReq(int _activity_cfg_id_, int _grid_, int _add_extra_value_)
/*     */   {
/*  42 */     this.activity_cfg_id = _activity_cfg_id_;
/*  43 */     this.grid = _grid_;
/*  44 */     this.add_extra_value = _add_extra_value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.marshal(this.grid);
/*  54 */     _os_.marshal(this.add_extra_value);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  60 */     this.grid = _os_.unmarshal_int();
/*  61 */     this.add_extra_value = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CDevelopItemInDevelopItemActivityReq)) {
/*  71 */       CDevelopItemInDevelopItemActivityReq _o_ = (CDevelopItemInDevelopItemActivityReq)_o1_;
/*  72 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  73 */       if (this.grid != _o_.grid) return false;
/*  74 */       if (this.add_extra_value != _o_.add_extra_value) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.activity_cfg_id;
/*  83 */     _h_ += this.grid;
/*  84 */     _h_ += this.add_extra_value;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.activity_cfg_id).append(",");
/*  92 */     _sb_.append(this.grid).append(",");
/*  93 */     _sb_.append(this.add_extra_value).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CDevelopItemInDevelopItemActivityReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.grid - _o_.grid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.add_extra_value - _o_.add_extra_value;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\CDevelopItemInDevelopItemActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
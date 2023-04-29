/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCMountsReplaceProtectPet;
/*     */ 
/*     */ 
/*     */ public class CMountsReplaceProtectPet
/*     */   extends __CMountsReplaceProtectPet__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606247;
/*     */   public int cell_id;
/*     */   public int protect_index;
/*     */   public long old_pet_id;
/*     */   public long now_pet_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCMountsReplaceProtectPet(roleId, this.cell_id, this.protect_index, this.old_pet_id, this.now_pet_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606247;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CMountsReplaceProtectPet() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CMountsReplaceProtectPet(int _cell_id_, int _protect_index_, long _old_pet_id_, long _now_pet_id_)
/*     */   {
/*  45 */     this.cell_id = _cell_id_;
/*  46 */     this.protect_index = _protect_index_;
/*  47 */     this.old_pet_id = _old_pet_id_;
/*  48 */     this.now_pet_id = _now_pet_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.cell_id);
/*  57 */     _os_.marshal(this.protect_index);
/*  58 */     _os_.marshal(this.old_pet_id);
/*  59 */     _os_.marshal(this.now_pet_id);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.cell_id = _os_.unmarshal_int();
/*  65 */     this.protect_index = _os_.unmarshal_int();
/*  66 */     this.old_pet_id = _os_.unmarshal_long();
/*  67 */     this.now_pet_id = _os_.unmarshal_long();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CMountsReplaceProtectPet)) {
/*  77 */       CMountsReplaceProtectPet _o_ = (CMountsReplaceProtectPet)_o1_;
/*  78 */       if (this.cell_id != _o_.cell_id) return false;
/*  79 */       if (this.protect_index != _o_.protect_index) return false;
/*  80 */       if (this.old_pet_id != _o_.old_pet_id) return false;
/*  81 */       if (this.now_pet_id != _o_.now_pet_id) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.cell_id;
/*  90 */     _h_ += this.protect_index;
/*  91 */     _h_ += (int)this.old_pet_id;
/*  92 */     _h_ += (int)this.now_pet_id;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.cell_id).append(",");
/* 100 */     _sb_.append(this.protect_index).append(",");
/* 101 */     _sb_.append(this.old_pet_id).append(",");
/* 102 */     _sb_.append(this.now_pet_id).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMountsReplaceProtectPet _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.cell_id - _o_.cell_id;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.protect_index - _o_.protect_index;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.old_pet_id - _o_.old_pet_id);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = Long.signum(this.now_pet_id - _o_.now_pet_id);
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CMountsReplaceProtectPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
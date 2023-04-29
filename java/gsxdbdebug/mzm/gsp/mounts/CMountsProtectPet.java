/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCMountsProtectPet;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CMountsProtectPet
/*     */   extends __CMountsProtectPet__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606227;
/*     */   public int cell_id;
/*     */   public int protect_index;
/*     */   public long pet_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCMountsProtectPet(roleId, this.cell_id, this.protect_index, this.pet_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606227;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CMountsProtectPet() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CMountsProtectPet(int _cell_id_, int _protect_index_, long _pet_id_)
/*     */   {
/*  44 */     this.cell_id = _cell_id_;
/*  45 */     this.protect_index = _protect_index_;
/*  46 */     this.pet_id = _pet_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.cell_id);
/*  55 */     _os_.marshal(this.protect_index);
/*  56 */     _os_.marshal(this.pet_id);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.cell_id = _os_.unmarshal_int();
/*  62 */     this.protect_index = _os_.unmarshal_int();
/*  63 */     this.pet_id = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CMountsProtectPet)) {
/*  73 */       CMountsProtectPet _o_ = (CMountsProtectPet)_o1_;
/*  74 */       if (this.cell_id != _o_.cell_id) return false;
/*  75 */       if (this.protect_index != _o_.protect_index) return false;
/*  76 */       if (this.pet_id != _o_.pet_id) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.cell_id;
/*  85 */     _h_ += this.protect_index;
/*  86 */     _h_ += (int)this.pet_id;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.cell_id).append(",");
/*  94 */     _sb_.append(this.protect_index).append(",");
/*  95 */     _sb_.append(this.pet_id).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMountsProtectPet _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.cell_id - _o_.cell_id;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.protect_index - _o_.protect_index;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CMountsProtectPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
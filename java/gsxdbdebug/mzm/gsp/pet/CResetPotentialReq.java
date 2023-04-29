/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PResetPetProp;
/*     */ 
/*     */ 
/*     */ public class CResetPotentialReq
/*     */   extends __CResetPotentialReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590626;
/*     */   public long petid;
/*     */   public int itemnum;
/*     */   public long yuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PResetPetProp(roleId, this.petid, this.itemnum, this.yuanbaonum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590626;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CResetPotentialReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CResetPotentialReq(long _petid_, int _itemnum_, long _yuanbaonum_)
/*     */   {
/*  42 */     this.petid = _petid_;
/*  43 */     this.itemnum = _itemnum_;
/*  44 */     this.yuanbaonum = _yuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.petid);
/*  53 */     _os_.marshal(this.itemnum);
/*  54 */     _os_.marshal(this.yuanbaonum);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.petid = _os_.unmarshal_long();
/*  60 */     this.itemnum = _os_.unmarshal_int();
/*  61 */     this.yuanbaonum = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CResetPotentialReq)) {
/*  71 */       CResetPotentialReq _o_ = (CResetPotentialReq)_o1_;
/*  72 */       if (this.petid != _o_.petid) return false;
/*  73 */       if (this.itemnum != _o_.itemnum) return false;
/*  74 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.petid;
/*  83 */     _h_ += this.itemnum;
/*  84 */     _h_ += (int)this.yuanbaonum;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.petid).append(",");
/*  92 */     _sb_.append(this.itemnum).append(",");
/*  93 */     _sb_.append(this.yuanbaonum).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CResetPotentialReq _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.itemnum - _o_.itemnum;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.yuanbaonum - _o_.yuanbaonum);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CResetPotentialReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
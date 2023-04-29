/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PPetFightImproveFormation;
/*     */ 
/*     */ 
/*     */ public class CPetFightImproveFormationReq
/*     */   extends __CPetFightImproveFormationReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590685;
/*     */   public int formation_id;
/*     */   public long item_uuid;
/*     */   public int use_all;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     Role.addRoleProcedure(roleId, new PPetFightImproveFormation(roleId, this.formation_id, this.item_uuid, this.use_all != 0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12590685;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CPetFightImproveFormationReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CPetFightImproveFormationReq(int _formation_id_, long _item_uuid_, int _use_all_)
/*     */   {
/*  40 */     this.formation_id = _formation_id_;
/*  41 */     this.item_uuid = _item_uuid_;
/*  42 */     this.use_all = _use_all_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.formation_id);
/*  51 */     _os_.marshal(this.item_uuid);
/*  52 */     _os_.marshal(this.use_all);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.formation_id = _os_.unmarshal_int();
/*  58 */     this.item_uuid = _os_.unmarshal_long();
/*  59 */     this.use_all = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CPetFightImproveFormationReq)) {
/*  69 */       CPetFightImproveFormationReq _o_ = (CPetFightImproveFormationReq)_o1_;
/*  70 */       if (this.formation_id != _o_.formation_id) return false;
/*  71 */       if (this.item_uuid != _o_.item_uuid) return false;
/*  72 */       if (this.use_all != _o_.use_all) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.formation_id;
/*  81 */     _h_ += (int)this.item_uuid;
/*  82 */     _h_ += this.use_all;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.formation_id).append(",");
/*  90 */     _sb_.append(this.item_uuid).append(",");
/*  91 */     _sb_.append(this.use_all).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPetFightImproveFormationReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.formation_id - _o_.formation_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.item_uuid - _o_.item_uuid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.use_all - _o_.use_all;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetFightImproveFormationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
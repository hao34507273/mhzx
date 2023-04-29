/*     */ package mzm.gsp.qingfu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.qingfu.main.PCGetGiftInfoReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGetGiftInfoReq
/*     */   extends __CGetGiftInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588840;
/*     */   public int activity_id;
/*     */   public int gift_bag_cfg_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCGetGiftInfoReq(roleId, this.activity_id, this.gift_bag_cfg_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12588840;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetGiftInfoReq() {}
/*     */   
/*     */ 
/*     */   public CGetGiftInfoReq(int _activity_id_, int _gift_bag_cfg_id_)
/*     */   {
/*  43 */     this.activity_id = _activity_id_;
/*  44 */     this.gift_bag_cfg_id = _gift_bag_cfg_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_id);
/*  53 */     _os_.marshal(this.gift_bag_cfg_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_id = _os_.unmarshal_int();
/*  59 */     this.gift_bag_cfg_id = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CGetGiftInfoReq)) {
/*  69 */       CGetGiftInfoReq _o_ = (CGetGiftInfoReq)_o1_;
/*  70 */       if (this.activity_id != _o_.activity_id) return false;
/*  71 */       if (this.gift_bag_cfg_id != _o_.gift_bag_cfg_id) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.activity_id;
/*  80 */     _h_ += this.gift_bag_cfg_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_id).append(",");
/*  88 */     _sb_.append(this.gift_bag_cfg_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetGiftInfoReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.activity_id - _o_.activity_id;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.gift_bag_cfg_id - _o_.gift_bag_cfg_id;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\CGetGiftInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
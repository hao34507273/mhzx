/*     */ package mzm.gsp.qingfu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.qingfu.main.PCGiftReq;
/*     */ 
/*     */ 
/*     */ public class CGiftReq
/*     */   extends __CGiftReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588842;
/*     */   public int activity_id;
/*     */   public int gift_bag_cfg_id;
/*     */   public long receiver_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCGiftReq(roleId, this.activity_id, this.gift_bag_cfg_id, this.receiver_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12588842;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGiftReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGiftReq(int _activity_id_, int _gift_bag_cfg_id_, long _receiver_id_)
/*     */   {
/*  44 */     this.activity_id = _activity_id_;
/*  45 */     this.gift_bag_cfg_id = _gift_bag_cfg_id_;
/*  46 */     this.receiver_id = _receiver_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_id);
/*  55 */     _os_.marshal(this.gift_bag_cfg_id);
/*  56 */     _os_.marshal(this.receiver_id);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_id = _os_.unmarshal_int();
/*  62 */     this.gift_bag_cfg_id = _os_.unmarshal_int();
/*  63 */     this.receiver_id = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CGiftReq)) {
/*  73 */       CGiftReq _o_ = (CGiftReq)_o1_;
/*  74 */       if (this.activity_id != _o_.activity_id) return false;
/*  75 */       if (this.gift_bag_cfg_id != _o_.gift_bag_cfg_id) return false;
/*  76 */       if (this.receiver_id != _o_.receiver_id) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.activity_id;
/*  85 */     _h_ += this.gift_bag_cfg_id;
/*  86 */     _h_ += (int)this.receiver_id;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_id).append(",");
/*  94 */     _sb_.append(this.gift_bag_cfg_id).append(",");
/*  95 */     _sb_.append(this.receiver_id).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGiftReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.activity_id - _o_.activity_id;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.gift_bag_cfg_id - _o_.gift_bag_cfg_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = Long.signum(this.receiver_id - _o_.receiver_id);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\CGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
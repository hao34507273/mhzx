/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mounts.main.PCExtendMountsTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CExtendMountsTime
/*     */   extends __CExtendMountsTime__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606238;
/*     */   public int extend_time_item_id;
/*     */   public int extend_time_item_id_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCExtendMountsTime(roleId, this.extend_time_item_id, this.extend_time_item_id_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12606238;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExtendMountsTime() {}
/*     */   
/*     */ 
/*     */   public CExtendMountsTime(int _extend_time_item_id_, int _extend_time_item_id_num_)
/*     */   {
/*  43 */     this.extend_time_item_id = _extend_time_item_id_;
/*  44 */     this.extend_time_item_id_num = _extend_time_item_id_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.extend_time_item_id);
/*  53 */     _os_.marshal(this.extend_time_item_id_num);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.extend_time_item_id = _os_.unmarshal_int();
/*  59 */     this.extend_time_item_id_num = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CExtendMountsTime)) {
/*  69 */       CExtendMountsTime _o_ = (CExtendMountsTime)_o1_;
/*  70 */       if (this.extend_time_item_id != _o_.extend_time_item_id) return false;
/*  71 */       if (this.extend_time_item_id_num != _o_.extend_time_item_id_num) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.extend_time_item_id;
/*  80 */     _h_ += this.extend_time_item_id_num;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.extend_time_item_id).append(",");
/*  88 */     _sb_.append(this.extend_time_item_id_num).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExtendMountsTime _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.extend_time_item_id - _o_.extend_time_item_id;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.extend_time_item_id_num - _o_.extend_time_item_id_num;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\CExtendMountsTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
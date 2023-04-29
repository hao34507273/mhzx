/*     */ package mzm.gsp.lifeskillactivity;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SCreateLifeSkillItemSuccess
/*     */   extends __SCreateLifeSkillItemSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12626690;
/*     */   public int activity_cfgid;
/*     */   public int item_id;
/*     */   public int item_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12626690;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SCreateLifeSkillItemSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SCreateLifeSkillItemSuccess(int _activity_cfgid_, int _item_id_, int _item_num_)
/*     */   {
/*  38 */     this.activity_cfgid = _activity_cfgid_;
/*  39 */     this.item_id = _item_id_;
/*  40 */     this.item_num = _item_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_cfgid);
/*  49 */     _os_.marshal(this.item_id);
/*  50 */     _os_.marshal(this.item_num);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfgid = _os_.unmarshal_int();
/*  56 */     this.item_id = _os_.unmarshal_int();
/*  57 */     this.item_num = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SCreateLifeSkillItemSuccess)) {
/*  67 */       SCreateLifeSkillItemSuccess _o_ = (SCreateLifeSkillItemSuccess)_o1_;
/*  68 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  69 */       if (this.item_id != _o_.item_id) return false;
/*  70 */       if (this.item_num != _o_.item_num) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activity_cfgid;
/*  79 */     _h_ += this.item_id;
/*  80 */     _h_ += this.item_num;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfgid).append(",");
/*  88 */     _sb_.append(this.item_id).append(",");
/*  89 */     _sb_.append(this.item_num).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCreateLifeSkillItemSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.item_id - _o_.item_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.item_num - _o_.item_num;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskillactivity\SCreateLifeSkillItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
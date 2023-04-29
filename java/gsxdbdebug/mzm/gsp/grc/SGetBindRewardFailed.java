/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ public class SGetBindRewardFailed
/*     */   extends __SGetBindRewardFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600379;
/*     */   public static final int ERROR_RECALL_VITALITY_EXPIRE = -1;
/*     */   public static final int ERROR_RECALL_BIND_REWARD = -2;
/*     */   public static final int ERROR_RECALL_VITALITY_NOT_ENOUGH = -3;
/*     */   public static final int ERROR_RECALL_FRIEND_VITALITY_NOT_ENOUGH = -4;
/*     */   public static final int ERROR_RECALL_VITALITY_TIME = -5;
/*     */   public static final int ERROR_RECALL_NOT_BIND = -6;
/*     */   public static final int ERROR_RECALL_NET = -7;
/*     */   public Octets open_id;
/*     */   public int bind_type;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600379;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   public SGetBindRewardFailed()
/*     */   {
/*  43 */     this.open_id = new Octets();
/*     */   }
/*     */   
/*     */   public SGetBindRewardFailed(Octets _open_id_, int _bind_type_, int _retcode_) {
/*  47 */     this.open_id = _open_id_;
/*  48 */     this.bind_type = _bind_type_;
/*  49 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.open_id);
/*  58 */     _os_.marshal(this.bind_type);
/*  59 */     _os_.marshal(this.retcode);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.open_id = _os_.unmarshal_Octets();
/*  65 */     this.bind_type = _os_.unmarshal_int();
/*  66 */     this.retcode = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SGetBindRewardFailed)) {
/*  76 */       SGetBindRewardFailed _o_ = (SGetBindRewardFailed)_o1_;
/*  77 */       if (!this.open_id.equals(_o_.open_id)) return false;
/*  78 */       if (this.bind_type != _o_.bind_type) return false;
/*  79 */       if (this.retcode != _o_.retcode) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.open_id.hashCode();
/*  88 */     _h_ += this.bind_type;
/*  89 */     _h_ += this.retcode;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append("B").append(this.open_id.size()).append(",");
/*  97 */     _sb_.append(this.bind_type).append(",");
/*  98 */     _sb_.append(this.retcode).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetBindRewardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
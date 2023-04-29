/*     */ package mzm.gsp.factionpve;
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
/*     */ public class SStartTimeBrd
/*     */   extends __SStartTimeBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613638;
/*     */   public long start_time;
/*     */   public long manager_id;
/*     */   public String manager_name;
/*     */   public String manager_duty;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613638;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartTimeBrd()
/*     */   {
/*  36 */     this.manager_name = "";
/*  37 */     this.manager_duty = "";
/*     */   }
/*     */   
/*     */   public SStartTimeBrd(long _start_time_, long _manager_id_, String _manager_name_, String _manager_duty_) {
/*  41 */     this.start_time = _start_time_;
/*  42 */     this.manager_id = _manager_id_;
/*  43 */     this.manager_name = _manager_name_;
/*  44 */     this.manager_duty = _manager_duty_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.start_time);
/*  53 */     _os_.marshal(this.manager_id);
/*  54 */     _os_.marshal(this.manager_name, "UTF-16LE");
/*  55 */     _os_.marshal(this.manager_duty, "UTF-16LE");
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.start_time = _os_.unmarshal_long();
/*  61 */     this.manager_id = _os_.unmarshal_long();
/*  62 */     this.manager_name = _os_.unmarshal_String("UTF-16LE");
/*  63 */     this.manager_duty = _os_.unmarshal_String("UTF-16LE");
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SStartTimeBrd)) {
/*  73 */       SStartTimeBrd _o_ = (SStartTimeBrd)_o1_;
/*  74 */       if (this.start_time != _o_.start_time) return false;
/*  75 */       if (this.manager_id != _o_.manager_id) return false;
/*  76 */       if (!this.manager_name.equals(_o_.manager_name)) return false;
/*  77 */       if (!this.manager_duty.equals(_o_.manager_duty)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.start_time;
/*  86 */     _h_ += (int)this.manager_id;
/*  87 */     _h_ += this.manager_name.hashCode();
/*  88 */     _h_ += this.manager_duty.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.start_time).append(",");
/*  96 */     _sb_.append(this.manager_id).append(",");
/*  97 */     _sb_.append("T").append(this.manager_name.length()).append(",");
/*  98 */     _sb_.append("T").append(this.manager_duty.length()).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SStartTimeBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
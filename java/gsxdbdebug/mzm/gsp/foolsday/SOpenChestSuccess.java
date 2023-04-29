/*     */ package mzm.gsp.foolsday;
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
/*     */ public class SOpenChestSuccess
/*     */   extends __SOpenChestSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612871;
/*     */   public int activity_cfg_id;
/*     */   public int grid;
/*     */   public long makerid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612871;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SOpenChestSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SOpenChestSuccess(int _activity_cfg_id_, int _grid_, long _makerid_)
/*     */   {
/*  38 */     this.activity_cfg_id = _activity_cfg_id_;
/*  39 */     this.grid = _grid_;
/*  40 */     this.makerid = _makerid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_cfg_id);
/*  49 */     _os_.marshal(this.grid);
/*  50 */     _os_.marshal(this.makerid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  56 */     this.grid = _os_.unmarshal_int();
/*  57 */     this.makerid = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SOpenChestSuccess)) {
/*  67 */       SOpenChestSuccess _o_ = (SOpenChestSuccess)_o1_;
/*  68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  69 */       if (this.grid != _o_.grid) return false;
/*  70 */       if (this.makerid != _o_.makerid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activity_cfg_id;
/*  79 */     _h_ += this.grid;
/*  80 */     _h_ += (int)this.makerid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfg_id).append(",");
/*  88 */     _sb_.append(this.grid).append(",");
/*  89 */     _sb_.append(this.makerid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SOpenChestSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.grid - _o_.grid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.makerid - _o_.makerid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\SOpenChestSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncMapEntityMove
/*     */   extends __SSyncMapEntityMove__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590956;
/*     */   public int entity_type;
/*     */   public long instanceid;
/*     */   public ArrayList<Location> keypointpath;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590956;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMapEntityMove()
/*     */   {
/*  35 */     this.entity_type = 0;
/*  36 */     this.keypointpath = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncMapEntityMove(int _entity_type_, long _instanceid_, ArrayList<Location> _keypointpath_) {
/*  40 */     this.entity_type = _entity_type_;
/*  41 */     this.instanceid = _instanceid_;
/*  42 */     this.keypointpath = _keypointpath_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Location _v_ : this.keypointpath)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.entity_type);
/*  53 */     _os_.marshal(this.instanceid);
/*  54 */     _os_.compact_uint32(this.keypointpath.size());
/*  55 */     for (Location _v_ : this.keypointpath) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.entity_type = _os_.unmarshal_int();
/*  63 */     this.instanceid = _os_.unmarshal_long();
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       Location _v_ = new Location();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.keypointpath.add(_v_);
/*     */     }
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SSyncMapEntityMove)) {
/*  78 */       SSyncMapEntityMove _o_ = (SSyncMapEntityMove)_o1_;
/*  79 */       if (this.entity_type != _o_.entity_type) return false;
/*  80 */       if (this.instanceid != _o_.instanceid) return false;
/*  81 */       if (!this.keypointpath.equals(_o_.keypointpath)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.entity_type;
/*  90 */     _h_ += (int)this.instanceid;
/*  91 */     _h_ += this.keypointpath.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.entity_type).append(",");
/*  99 */     _sb_.append(this.instanceid).append(",");
/* 100 */     _sb_.append(this.keypointpath).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncMapEntityMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
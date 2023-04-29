/*     */ package mzm.gsp.drawandguess;
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
/*     */ public class SNotifyAppendLineInfo
/*     */   extends __SNotifyAppendLineInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617228;
/*     */   public int line_id;
/*     */   public int action_id;
/*     */   public ArrayList<PointInfo> point_list;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617228;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyAppendLineInfo()
/*     */   {
/*  35 */     this.point_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SNotifyAppendLineInfo(int _line_id_, int _action_id_, ArrayList<PointInfo> _point_list_) {
/*  39 */     this.line_id = _line_id_;
/*  40 */     this.action_id = _action_id_;
/*  41 */     this.point_list = _point_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (PointInfo _v_ : this.point_list)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.line_id);
/*  52 */     _os_.marshal(this.action_id);
/*  53 */     _os_.compact_uint32(this.point_list.size());
/*  54 */     for (PointInfo _v_ : this.point_list) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.line_id = _os_.unmarshal_int();
/*  62 */     this.action_id = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       PointInfo _v_ = new PointInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.point_list.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SNotifyAppendLineInfo)) {
/*  77 */       SNotifyAppendLineInfo _o_ = (SNotifyAppendLineInfo)_o1_;
/*  78 */       if (this.line_id != _o_.line_id) return false;
/*  79 */       if (this.action_id != _o_.action_id) return false;
/*  80 */       if (!this.point_list.equals(_o_.point_list)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.line_id;
/*  89 */     _h_ += this.action_id;
/*  90 */     _h_ += this.point_list.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.line_id).append(",");
/*  98 */     _sb_.append(this.action_id).append(",");
/*  99 */     _sb_.append(this.point_list).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SNotifyAppendLineInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.active;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SynActiveDataRes
/*     */   extends __SynActiveDataRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12599555;
/*     */   public ArrayList<ActiveData> activedatas;
/*     */   public HashSet<Integer> award_active_index_id_set;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12599555;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SynActiveDataRes()
/*     */   {
/*  34 */     this.activedatas = new ArrayList();
/*  35 */     this.award_active_index_id_set = new HashSet();
/*     */   }
/*     */   
/*     */   public SynActiveDataRes(ArrayList<ActiveData> _activedatas_, HashSet<Integer> _award_active_index_id_set_) {
/*  39 */     this.activedatas = _activedatas_;
/*  40 */     this.award_active_index_id_set = _award_active_index_id_set_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (ActiveData _v_ : this.activedatas)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.compact_uint32(this.activedatas.size());
/*  51 */     for (ActiveData _v_ : this.activedatas) {
/*  52 */       _os_.marshal(_v_);
/*     */     }
/*  54 */     _os_.compact_uint32(this.award_active_index_id_set.size());
/*  55 */     for (Integer _v_ : this.award_active_index_id_set) {
/*  56 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  63 */       ActiveData _v_ = new ActiveData();
/*  64 */       _v_.unmarshal(_os_);
/*  65 */       this.activedatas.add(_v_);
/*     */     }
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  69 */       int _v_ = _os_.unmarshal_int();
/*  70 */       this.award_active_index_id_set.add(Integer.valueOf(_v_));
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SynActiveDataRes)) {
/*  81 */       SynActiveDataRes _o_ = (SynActiveDataRes)_o1_;
/*  82 */       if (!this.activedatas.equals(_o_.activedatas)) return false;
/*  83 */       if (!this.award_active_index_id_set.equals(_o_.award_active_index_id_set)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.activedatas.hashCode();
/*  92 */     _h_ += this.award_active_index_id_set.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.activedatas).append(",");
/* 100 */     _sb_.append(this.award_active_index_id_set).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\SynActiveDataRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
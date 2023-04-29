/*     */ package mzm.gsp.grc;
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
/*     */ public class SyncRecallLossInfo
/*     */   extends __SyncRecallLossInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600367;
/*     */   public ArrayList<RecallLossInfo> loss_infos;
/*     */   public int update_time;
/*     */   public int today_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600367;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SyncRecallLossInfo()
/*     */   {
/*  35 */     this.loss_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SyncRecallLossInfo(ArrayList<RecallLossInfo> _loss_infos_, int _update_time_, int _today_num_) {
/*  39 */     this.loss_infos = _loss_infos_;
/*  40 */     this.update_time = _update_time_;
/*  41 */     this.today_num = _today_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (RecallLossInfo _v_ : this.loss_infos)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.loss_infos.size());
/*  52 */     for (RecallLossInfo _v_ : this.loss_infos) {
/*  53 */       _os_.marshal(_v_);
/*     */     }
/*  55 */     _os_.marshal(this.update_time);
/*  56 */     _os_.marshal(this.today_num);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       RecallLossInfo _v_ = new RecallLossInfo();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.loss_infos.add(_v_);
/*     */     }
/*  66 */     this.update_time = _os_.unmarshal_int();
/*  67 */     this.today_num = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SyncRecallLossInfo)) {
/*  77 */       SyncRecallLossInfo _o_ = (SyncRecallLossInfo)_o1_;
/*  78 */       if (!this.loss_infos.equals(_o_.loss_infos)) return false;
/*  79 */       if (this.update_time != _o_.update_time) return false;
/*  80 */       if (this.today_num != _o_.today_num) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.loss_infos.hashCode();
/*  89 */     _h_ += this.update_time;
/*  90 */     _h_ += this.today_num;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.loss_infos).append(",");
/*  98 */     _sb_.append(this.update_time).append(",");
/*  99 */     _sb_.append(this.today_num).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SyncRecallLossInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
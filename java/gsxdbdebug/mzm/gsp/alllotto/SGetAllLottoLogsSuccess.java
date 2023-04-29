/*     */ package mzm.gsp.alllotto;
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
/*     */ public class SGetAllLottoLogsSuccess
/*     */   extends __SGetAllLottoLogsSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12626948;
/*     */   public int activity_cfg_id;
/*     */   public int num;
/*     */   public ArrayList<AllLottoLog> logs;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12626948;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetAllLottoLogsSuccess()
/*     */   {
/*  35 */     this.logs = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetAllLottoLogsSuccess(int _activity_cfg_id_, int _num_, ArrayList<AllLottoLog> _logs_) {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.num = _num_;
/*  41 */     this.logs = _logs_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (AllLottoLog _v_ : this.logs)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.activity_cfg_id);
/*  52 */     _os_.marshal(this.num);
/*  53 */     _os_.compact_uint32(this.logs.size());
/*  54 */     for (AllLottoLog _v_ : this.logs) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  62 */     this.num = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       AllLottoLog _v_ = new AllLottoLog();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.logs.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SGetAllLottoLogsSuccess)) {
/*  77 */       SGetAllLottoLogsSuccess _o_ = (SGetAllLottoLogsSuccess)_o1_;
/*  78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  79 */       if (this.num != _o_.num) return false;
/*  80 */       if (!this.logs.equals(_o_.logs)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activity_cfg_id;
/*  89 */     _h_ += this.num;
/*  90 */     _h_ += this.logs.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.activity_cfg_id).append(",");
/*  98 */     _sb_.append(this.num).append(",");
/*  99 */     _sb_.append(this.logs).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\SGetAllLottoLogsSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.worldgoal;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SCommitItemSuccess
/*     */   extends __SCommitItemSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594433;
/*     */   public int activity_cfg_id;
/*     */   public int commit_num;
/*     */   public HashMap<Integer, Integer> itemid2commit_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594433;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCommitItemSuccess()
/*     */   {
/*  35 */     this.itemid2commit_num = new HashMap();
/*     */   }
/*     */   
/*     */   public SCommitItemSuccess(int _activity_cfg_id_, int _commit_num_, HashMap<Integer, Integer> _itemid2commit_num_) {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.commit_num = _commit_num_;
/*  41 */     this.itemid2commit_num = _itemid2commit_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.activity_cfg_id);
/*  50 */     _os_.marshal(this.commit_num);
/*  51 */     _os_.compact_uint32(this.itemid2commit_num.size());
/*  52 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2commit_num.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  61 */     this.commit_num = _os_.unmarshal_int();
/*  62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  64 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  66 */       int _v_ = _os_.unmarshal_int();
/*  67 */       this.itemid2commit_num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SCommitItemSuccess)) {
/*  78 */       SCommitItemSuccess _o_ = (SCommitItemSuccess)_o1_;
/*  79 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  80 */       if (this.commit_num != _o_.commit_num) return false;
/*  81 */       if (!this.itemid2commit_num.equals(_o_.itemid2commit_num)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.commit_num;
/*  91 */     _h_ += this.itemid2commit_num.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.activity_cfg_id).append(",");
/*  99 */     _sb_.append(this.commit_num).append(",");
/* 100 */     _sb_.append(this.itemid2commit_num).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\SCommitItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
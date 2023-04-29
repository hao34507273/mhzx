/*     */ package mzm.gsp.drawcarnival;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
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
/*     */ public class SGetDrawInfoRsp
/*     */   extends __SGetDrawInfoRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12630025;
/*     */   public long award_pool_yuan_bao_count;
/*     */   public HashMap<Integer, FreePassInfo> pass_type_id2info;
/*     */   public AwardWinnerInfo last_winner_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12630025;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetDrawInfoRsp()
/*     */   {
/*  35 */     this.pass_type_id2info = new HashMap();
/*  36 */     this.last_winner_info = new AwardWinnerInfo();
/*     */   }
/*     */   
/*     */   public SGetDrawInfoRsp(long _award_pool_yuan_bao_count_, HashMap<Integer, FreePassInfo> _pass_type_id2info_, AwardWinnerInfo _last_winner_info_) {
/*  40 */     this.award_pool_yuan_bao_count = _award_pool_yuan_bao_count_;
/*  41 */     this.pass_type_id2info = _pass_type_id2info_;
/*  42 */     this.last_winner_info = _last_winner_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Map.Entry<Integer, FreePassInfo> _e_ : this.pass_type_id2info.entrySet()) {
/*  47 */       if (!((FreePassInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     if (!this.last_winner_info._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.award_pool_yuan_bao_count);
/*  55 */     _os_.compact_uint32(this.pass_type_id2info.size());
/*  56 */     for (Map.Entry<Integer, FreePassInfo> _e_ : this.pass_type_id2info.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  60 */     _os_.marshal(this.last_winner_info);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.award_pool_yuan_bao_count = _os_.unmarshal_long();
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*  69 */       FreePassInfo _v_ = new FreePassInfo();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.pass_type_id2info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  73 */     this.last_winner_info.unmarshal(_os_);
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SGetDrawInfoRsp)) {
/*  83 */       SGetDrawInfoRsp _o_ = (SGetDrawInfoRsp)_o1_;
/*  84 */       if (this.award_pool_yuan_bao_count != _o_.award_pool_yuan_bao_count) return false;
/*  85 */       if (!this.pass_type_id2info.equals(_o_.pass_type_id2info)) return false;
/*  86 */       if (!this.last_winner_info.equals(_o_.last_winner_info)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.award_pool_yuan_bao_count;
/*  95 */     _h_ += this.pass_type_id2info.hashCode();
/*  96 */     _h_ += this.last_winner_info.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.award_pool_yuan_bao_count).append(",");
/* 104 */     _sb_.append(this.pass_type_id2info).append(",");
/* 105 */     _sb_.append(this.last_winner_info).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\SGetDrawInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
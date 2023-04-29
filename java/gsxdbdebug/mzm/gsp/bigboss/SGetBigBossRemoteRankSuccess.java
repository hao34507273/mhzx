/*     */ package mzm.gsp.bigboss;
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
/*     */ public class SGetBigBossRemoteRankSuccess
/*     */   extends __SGetBigBossRemoteRankSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598029;
/*     */   public int occupation;
/*     */   public int startpos;
/*     */   public int num;
/*     */   public ArrayList<BigbossRankData> rank_list;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12598029;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetBigBossRemoteRankSuccess()
/*     */   {
/*  36 */     this.rank_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetBigBossRemoteRankSuccess(int _occupation_, int _startpos_, int _num_, ArrayList<BigbossRankData> _rank_list_) {
/*  40 */     this.occupation = _occupation_;
/*  41 */     this.startpos = _startpos_;
/*  42 */     this.num = _num_;
/*  43 */     this.rank_list = _rank_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (BigbossRankData _v_ : this.rank_list)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.occupation);
/*  54 */     _os_.marshal(this.startpos);
/*  55 */     _os_.marshal(this.num);
/*  56 */     _os_.compact_uint32(this.rank_list.size());
/*  57 */     for (BigbossRankData _v_ : this.rank_list) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.occupation = _os_.unmarshal_int();
/*  65 */     this.startpos = _os_.unmarshal_int();
/*  66 */     this.num = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       BigbossRankData _v_ = new BigbossRankData();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.rank_list.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetBigBossRemoteRankSuccess)) {
/*  81 */       SGetBigBossRemoteRankSuccess _o_ = (SGetBigBossRemoteRankSuccess)_o1_;
/*  82 */       if (this.occupation != _o_.occupation) return false;
/*  83 */       if (this.startpos != _o_.startpos) return false;
/*  84 */       if (this.num != _o_.num) return false;
/*  85 */       if (!this.rank_list.equals(_o_.rank_list)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.occupation;
/*  94 */     _h_ += this.startpos;
/*  95 */     _h_ += this.num;
/*  96 */     _h_ += this.rank_list.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.occupation).append(",");
/* 104 */     _sb_.append(this.startpos).append(",");
/* 105 */     _sb_.append(this.num).append(",");
/* 106 */     _sb_.append(this.rank_list).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\SGetBigBossRemoteRankSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
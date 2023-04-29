/*     */ package mzm.gsp.hula;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynMonsterListRes
/*     */   extends __SSynMonsterListRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12608783;
/*     */   public LinkedList<MonsterInfo> monsterlist;
/*     */   public int maxseq;
/*     */   public int turn;
/*     */   public int stage;
/*     */   public int point;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12608783;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynMonsterListRes()
/*     */   {
/*  35 */     this.monsterlist = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSynMonsterListRes(LinkedList<MonsterInfo> _monsterlist_, int _maxseq_, int _turn_, int _stage_, int _point_) {
/*  39 */     this.monsterlist = _monsterlist_;
/*  40 */     this.maxseq = _maxseq_;
/*  41 */     this.turn = _turn_;
/*  42 */     this.stage = _stage_;
/*  43 */     this.point = _point_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (MonsterInfo _v_ : this.monsterlist)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.compact_uint32(this.monsterlist.size());
/*  54 */     for (MonsterInfo _v_ : this.monsterlist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     _os_.marshal(this.maxseq);
/*  58 */     _os_.marshal(this.turn);
/*  59 */     _os_.marshal(this.stage);
/*  60 */     _os_.marshal(this.point);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       MonsterInfo _v_ = new MonsterInfo();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.monsterlist.add(_v_);
/*     */     }
/*  70 */     this.maxseq = _os_.unmarshal_int();
/*  71 */     this.turn = _os_.unmarshal_int();
/*  72 */     this.stage = _os_.unmarshal_int();
/*  73 */     this.point = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSynMonsterListRes)) {
/*  83 */       SSynMonsterListRes _o_ = (SSynMonsterListRes)_o1_;
/*  84 */       if (!this.monsterlist.equals(_o_.monsterlist)) return false;
/*  85 */       if (this.maxseq != _o_.maxseq) return false;
/*  86 */       if (this.turn != _o_.turn) return false;
/*  87 */       if (this.stage != _o_.stage) return false;
/*  88 */       if (this.point != _o_.point) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.monsterlist.hashCode();
/*  97 */     _h_ += this.maxseq;
/*  98 */     _h_ += this.turn;
/*  99 */     _h_ += this.stage;
/* 100 */     _h_ += this.point;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.monsterlist).append(",");
/* 108 */     _sb_.append(this.maxseq).append(",");
/* 109 */     _sb_.append(this.turn).append(",");
/* 110 */     _sb_.append(this.stage).append(",");
/* 111 */     _sb_.append(this.point).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\SSynMonsterListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
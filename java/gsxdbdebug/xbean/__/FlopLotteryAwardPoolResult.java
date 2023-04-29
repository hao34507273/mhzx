/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.floplottery.RewardItem;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class FlopLotteryAwardPoolResult extends XBean implements xbean.FlopLotteryAwardPoolResult
/*     */ {
/*     */   private int index;
/*     */   private ArrayList<RewardItem> resultlist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.index = 0;
/*  21 */     this.resultlist.clear();
/*     */   }
/*     */   
/*     */   FlopLotteryAwardPoolResult(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.resultlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public FlopLotteryAwardPoolResult()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FlopLotteryAwardPoolResult(FlopLotteryAwardPoolResult _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FlopLotteryAwardPoolResult(xbean.FlopLotteryAwardPoolResult _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  49 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  55 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  61 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  67 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlopLotteryAwardPoolResult copy()
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     return new FlopLotteryAwardPoolResult(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlopLotteryAwardPoolResult toData()
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FlopLotteryAwardPoolResult toBean()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     return new FlopLotteryAwardPoolResult(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlopLotteryAwardPoolResult toDataIf()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FlopLotteryAwardPoolResult toBeanIf()
/*     */   {
/* 105 */     _xdb_verify_unsafe_();
/* 106 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/* 113 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIndex()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     return this.index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.List<RewardItem> getResultlist()
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/* 129 */     return xdb.Logs.logList(new LogKey(this, "resultlist"), this.resultlist);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIndex(int _v_)
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/* 137 */     xdb.Logs.logIf(new LogKey(this, "index")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 141 */         new xdb.logs.LogInt(this, FlopLotteryAwardPoolResult.this.index)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 145 */             FlopLotteryAwardPoolResult.this.index = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 149 */     });
/* 150 */     this.index = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/* 157 */     FlopLotteryAwardPoolResult _o_ = null;
/* 158 */     if ((_o1_ instanceof FlopLotteryAwardPoolResult)) { _o_ = (FlopLotteryAwardPoolResult)_o1_;
/* 159 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 160 */       return false;
/* 161 */     if (this.index != _o_.index) return false;
/* 162 */     if (!this.resultlist.equals(_o_.resultlist)) return false;
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/* 170 */     int _h_ = 0;
/* 171 */     _h_ += this.index;
/* 172 */     _h_ += this.resultlist.hashCode();
/* 173 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     StringBuilder _sb_ = new StringBuilder();
/* 181 */     _sb_.append("(");
/* 182 */     _sb_.append(this.index);
/* 183 */     _sb_.append(",");
/* 184 */     _sb_.append(this.resultlist);
/* 185 */     _sb_.append(")");
/* 186 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 192 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 193 */     lb.add(new xdb.logs.ListenableChanged().setVarName("index"));
/* 194 */     lb.add(new xdb.logs.ListenableChanged().setVarName("resultlist"));
/* 195 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FlopLotteryAwardPoolResult {
/*     */     private Const() {}
/*     */     
/*     */     FlopLotteryAwardPoolResult nThis() {
/* 202 */       return FlopLotteryAwardPoolResult.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 208 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryAwardPoolResult copy()
/*     */     {
/* 214 */       return FlopLotteryAwardPoolResult.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryAwardPoolResult toData()
/*     */     {
/* 220 */       return FlopLotteryAwardPoolResult.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryAwardPoolResult toBean()
/*     */     {
/* 225 */       return FlopLotteryAwardPoolResult.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryAwardPoolResult toDataIf()
/*     */     {
/* 231 */       return FlopLotteryAwardPoolResult.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryAwardPoolResult toBeanIf()
/*     */     {
/* 236 */       return FlopLotteryAwardPoolResult.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIndex()
/*     */     {
/* 243 */       FlopLotteryAwardPoolResult.this._xdb_verify_unsafe_();
/* 244 */       return FlopLotteryAwardPoolResult.this.index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<RewardItem> getResultlist()
/*     */     {
/* 251 */       FlopLotteryAwardPoolResult.this._xdb_verify_unsafe_();
/* 252 */       return xdb.Consts.constList(FlopLotteryAwardPoolResult.this.resultlist);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIndex(int _v_)
/*     */     {
/* 259 */       FlopLotteryAwardPoolResult.this._xdb_verify_unsafe_();
/* 260 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 266 */       FlopLotteryAwardPoolResult.this._xdb_verify_unsafe_();
/* 267 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 273 */       FlopLotteryAwardPoolResult.this._xdb_verify_unsafe_();
/* 274 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 280 */       return FlopLotteryAwardPoolResult.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 286 */       return FlopLotteryAwardPoolResult.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 292 */       FlopLotteryAwardPoolResult.this._xdb_verify_unsafe_();
/* 293 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 299 */       return FlopLotteryAwardPoolResult.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 305 */       return FlopLotteryAwardPoolResult.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 311 */       FlopLotteryAwardPoolResult.this._xdb_verify_unsafe_();
/* 312 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 318 */       return FlopLotteryAwardPoolResult.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 324 */       return FlopLotteryAwardPoolResult.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 330 */       return FlopLotteryAwardPoolResult.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 336 */       return FlopLotteryAwardPoolResult.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 342 */       return FlopLotteryAwardPoolResult.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 348 */       return FlopLotteryAwardPoolResult.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 354 */       return FlopLotteryAwardPoolResult.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FlopLotteryAwardPoolResult
/*     */   {
/*     */     private int index;
/*     */     
/*     */     private ArrayList<RewardItem> resultlist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 373 */       this.resultlist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.FlopLotteryAwardPoolResult _o1_)
/*     */     {
/* 378 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 384 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 396 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 408 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryAwardPoolResult copy()
/*     */     {
/* 414 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryAwardPoolResult toData()
/*     */     {
/* 420 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryAwardPoolResult toBean()
/*     */     {
/* 425 */       return new FlopLotteryAwardPoolResult(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryAwardPoolResult toDataIf()
/*     */     {
/* 431 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryAwardPoolResult toBeanIf()
/*     */     {
/* 436 */       return new FlopLotteryAwardPoolResult(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 442 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 446 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 450 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 454 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 462 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 466 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIndex()
/*     */     {
/* 473 */       return this.index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<RewardItem> getResultlist()
/*     */     {
/* 480 */       return this.resultlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIndex(int _v_)
/*     */     {
/* 487 */       this.index = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 493 */       if (!(_o1_ instanceof Data)) return false;
/* 494 */       Data _o_ = (Data)_o1_;
/* 495 */       if (this.index != _o_.index) return false;
/* 496 */       if (!this.resultlist.equals(_o_.resultlist)) return false;
/* 497 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 503 */       int _h_ = 0;
/* 504 */       _h_ += this.index;
/* 505 */       _h_ += this.resultlist.hashCode();
/* 506 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 512 */       StringBuilder _sb_ = new StringBuilder();
/* 513 */       _sb_.append("(");
/* 514 */       _sb_.append(this.index);
/* 515 */       _sb_.append(",");
/* 516 */       _sb_.append(this.resultlist);
/* 517 */       _sb_.append(")");
/* 518 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FlopLotteryAwardPoolResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
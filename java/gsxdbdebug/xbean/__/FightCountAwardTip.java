/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class FightCountAwardTip extends XBean implements xbean.FightCountAwardTip
/*     */ {
/*     */   private AwardModel fightcountawardtip;
/*     */   private int count;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.fightcountawardtip = null;
/*  21 */     this.count = 0;
/*     */   }
/*     */   
/*     */   FightCountAwardTip(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.fightcountawardtip = null;
/*     */   }
/*     */   
/*     */   public FightCountAwardTip()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FightCountAwardTip(FightCountAwardTip _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FightCountAwardTip(xbean.FightCountAwardTip _o1_, XBean _xp_, String _vn_)
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
/*     */   public xbean.FightCountAwardTip copy()
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     return new FightCountAwardTip(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCountAwardTip toData()
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCountAwardTip toBean()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     return new FightCountAwardTip(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCountAwardTip toDataIf()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCountAwardTip toBeanIf()
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
/*     */   public AwardModel getFightcountawardtip()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     return this.fightcountawardtip;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/* 129 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFightcountawardtip(AwardModel _v_)
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/* 137 */     xdb.Logs.logIf(new LogKey(this, "fightcountawardtip")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 141 */         new xdb.logs.LogObject(this, FightCountAwardTip.this.fightcountawardtip)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 145 */             FightCountAwardTip.this.fightcountawardtip = ((AwardModel)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 149 */     });
/* 150 */     this.fightcountawardtip = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCount(int _v_)
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     xdb.Logs.logIf(new LogKey(this, "count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 162 */         new xdb.logs.LogInt(this, FightCountAwardTip.this.count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 166 */             FightCountAwardTip.this.count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 170 */     });
/* 171 */     this.count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     FightCountAwardTip _o_ = null;
/* 179 */     if ((_o1_ instanceof FightCountAwardTip)) { _o_ = (FightCountAwardTip)_o1_;
/* 180 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 181 */       return false;
/* 182 */     if (((null == this.fightcountawardtip) && (null != _o_.fightcountawardtip)) || ((null != this.fightcountawardtip) && (null == _o_.fightcountawardtip)) || ((null != this.fightcountawardtip) && (null != _o_.fightcountawardtip) && (!this.fightcountawardtip.equals(_o_.fightcountawardtip)))) return false;
/* 183 */     if (this.count != _o_.count) return false;
/* 184 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     int _h_ = 0;
/* 192 */     _h_ += (this.fightcountawardtip == null ? 0 : this.fightcountawardtip.hashCode());
/* 193 */     _h_ += this.count;
/* 194 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     StringBuilder _sb_ = new StringBuilder();
/* 202 */     _sb_.append("(");
/* 203 */     _sb_.append(this.fightcountawardtip);
/* 204 */     _sb_.append(",");
/* 205 */     _sb_.append(this.count);
/* 206 */     _sb_.append(")");
/* 207 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 213 */     ListenableBean lb = new ListenableBean();
/* 214 */     lb.add(new xdb.logs.ListenableChanged().setVarName("fightcountawardtip"));
/* 215 */     lb.add(new xdb.logs.ListenableChanged().setVarName("count"));
/* 216 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FightCountAwardTip {
/*     */     private Const() {}
/*     */     
/*     */     FightCountAwardTip nThis() {
/* 223 */       return FightCountAwardTip.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 229 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCountAwardTip copy()
/*     */     {
/* 235 */       return FightCountAwardTip.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCountAwardTip toData()
/*     */     {
/* 241 */       return FightCountAwardTip.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FightCountAwardTip toBean()
/*     */     {
/* 246 */       return FightCountAwardTip.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCountAwardTip toDataIf()
/*     */     {
/* 252 */       return FightCountAwardTip.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FightCountAwardTip toBeanIf()
/*     */     {
/* 257 */       return FightCountAwardTip.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public AwardModel getFightcountawardtip()
/*     */     {
/* 264 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 265 */       return FightCountAwardTip.this.fightcountawardtip;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 272 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 273 */       return FightCountAwardTip.this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightcountawardtip(AwardModel _v_)
/*     */     {
/* 280 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 281 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 288 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 289 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 295 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 296 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 302 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 303 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 309 */       return FightCountAwardTip.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 315 */       return FightCountAwardTip.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 321 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 322 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 328 */       return FightCountAwardTip.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 334 */       return FightCountAwardTip.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 340 */       FightCountAwardTip.this._xdb_verify_unsafe_();
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 347 */       return FightCountAwardTip.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 353 */       return FightCountAwardTip.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 359 */       return FightCountAwardTip.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 365 */       return FightCountAwardTip.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 371 */       return FightCountAwardTip.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 377 */       return FightCountAwardTip.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 383 */       return FightCountAwardTip.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FightCountAwardTip
/*     */   {
/*     */     private AwardModel fightcountawardtip;
/*     */     
/*     */     private int count;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 397 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 402 */       this.fightcountawardtip = null;
/*     */     }
/*     */     
/*     */     Data(xbean.FightCountAwardTip _o1_)
/*     */     {
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 425 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 437 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCountAwardTip copy()
/*     */     {
/* 443 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCountAwardTip toData()
/*     */     {
/* 449 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FightCountAwardTip toBean()
/*     */     {
/* 454 */       return new FightCountAwardTip(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCountAwardTip toDataIf()
/*     */     {
/* 460 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FightCountAwardTip toBeanIf()
/*     */     {
/* 465 */       return new FightCountAwardTip(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 491 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 495 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public AwardModel getFightcountawardtip()
/*     */     {
/* 502 */       return this.fightcountawardtip;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 509 */       return this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightcountawardtip(AwardModel _v_)
/*     */     {
/* 516 */       this.fightcountawardtip = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 523 */       this.count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 529 */       if (!(_o1_ instanceof Data)) return false;
/* 530 */       Data _o_ = (Data)_o1_;
/* 531 */       if (((null == this.fightcountawardtip) && (null != _o_.fightcountawardtip)) || ((null != this.fightcountawardtip) && (null == _o_.fightcountawardtip)) || ((null != this.fightcountawardtip) && (null != _o_.fightcountawardtip) && (!this.fightcountawardtip.equals(_o_.fightcountawardtip)))) return false;
/* 532 */       if (this.count != _o_.count) return false;
/* 533 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 539 */       int _h_ = 0;
/* 540 */       _h_ += (this.fightcountawardtip == null ? 0 : this.fightcountawardtip.hashCode());
/* 541 */       _h_ += this.count;
/* 542 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 548 */       StringBuilder _sb_ = new StringBuilder();
/* 549 */       _sb_.append("(");
/* 550 */       _sb_.append(this.fightcountawardtip);
/* 551 */       _sb_.append(",");
/* 552 */       _sb_.append(this.count);
/* 553 */       _sb_.append(")");
/* 554 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightCountAwardTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
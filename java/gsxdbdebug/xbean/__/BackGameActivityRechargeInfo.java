/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class BackGameActivityRechargeInfo extends XBean implements xbean.BackGameActivityRechargeInfo
/*     */ {
/*     */   private long initrechargecount;
/*     */   private long accumulaterechargecount;
/*     */   private HashMap<Integer, Integer> manekitokencfgid2count;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.initrechargecount = 0L;
/*  23 */     this.accumulaterechargecount = 0L;
/*  24 */     this.manekitokencfgid2count.clear();
/*     */   }
/*     */   
/*     */   BackGameActivityRechargeInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.manekitokencfgid2count = new HashMap();
/*     */   }
/*     */   
/*     */   public BackGameActivityRechargeInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public BackGameActivityRechargeInfo(BackGameActivityRechargeInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   BackGameActivityRechargeInfo(xbean.BackGameActivityRechargeInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof BackGameActivityRechargeInfo)) { assign((BackGameActivityRechargeInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(BackGameActivityRechargeInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.initrechargecount = _o_.initrechargecount;
/*  56 */     this.accumulaterechargecount = _o_.accumulaterechargecount;
/*  57 */     this.manekitokencfgid2count = new HashMap();
/*  58 */     for (Map.Entry<Integer, Integer> _e_ : _o_.manekitokencfgid2count.entrySet()) {
/*  59 */       this.manekitokencfgid2count.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  64 */     this.initrechargecount = _o_.initrechargecount;
/*  65 */     this.accumulaterechargecount = _o_.accumulaterechargecount;
/*  66 */     this.manekitokencfgid2count = new HashMap();
/*  67 */     for (Map.Entry<Integer, Integer> _e_ : _o_.manekitokencfgid2count.entrySet()) {
/*  68 */       this.manekitokencfgid2count.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.initrechargecount);
/*  76 */     _os_.marshal(this.accumulaterechargecount);
/*  77 */     _os_.compact_uint32(this.manekitokencfgid2count.size());
/*  78 */     for (Map.Entry<Integer, Integer> _e_ : this.manekitokencfgid2count.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  81 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.initrechargecount = _os_.unmarshal_long();
/*  91 */     this.accumulaterechargecount = _os_.unmarshal_long();
/*     */     
/*  93 */     int size = _os_.uncompact_uint32();
/*  94 */     if (size >= 12)
/*     */     {
/*  96 */       this.manekitokencfgid2count = new HashMap(size * 2);
/*     */     }
/*  98 */     for (; size > 0; size--)
/*     */     {
/* 100 */       int _k_ = 0;
/* 101 */       _k_ = _os_.unmarshal_int();
/* 102 */       int _v_ = 0;
/* 103 */       _v_ = _os_.unmarshal_int();
/* 104 */       this.manekitokencfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     _size_ += CodedOutputStream.computeInt64Size(1, this.initrechargecount);
/* 116 */     _size_ += CodedOutputStream.computeInt64Size(2, this.accumulaterechargecount);
/* 117 */     for (Map.Entry<Integer, Integer> _e_ : this.manekitokencfgid2count.entrySet())
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 120 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       _output_.writeInt64(1, this.initrechargecount);
/* 132 */       _output_.writeInt64(2, this.accumulaterechargecount);
/* 133 */       for (Map.Entry<Integer, Integer> _e_ : this.manekitokencfgid2count.entrySet())
/*     */       {
/* 135 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 136 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 143 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 152 */       boolean done = false;
/* 153 */       while (!done)
/*     */       {
/* 155 */         int tag = _input_.readTag();
/* 156 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 160 */           done = true;
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 165 */           this.initrechargecount = _input_.readInt64();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.accumulaterechargecount = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 175 */           int _k_ = 0;
/* 176 */           _k_ = _input_.readInt32();
/* 177 */           int readTag = _input_.readTag();
/* 178 */           if (24 != readTag)
/*     */           {
/* 180 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 182 */           int _v_ = 0;
/* 183 */           _v_ = _input_.readInt32();
/* 184 */           this.manekitokencfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BackGameActivityRechargeInfo copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new BackGameActivityRechargeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BackGameActivityRechargeInfo toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BackGameActivityRechargeInfo toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new BackGameActivityRechargeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BackGameActivityRechargeInfo toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BackGameActivityRechargeInfo toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getInitrechargecount()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.initrechargecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAccumulaterechargecount()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.accumulaterechargecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getManekitokencfgid2count()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return xdb.Logs.logMap(new LogKey(this, "manekitokencfgid2count"), this.manekitokencfgid2count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getManekitokencfgid2countAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     BackGameActivityRechargeInfo _o_ = this;
/* 280 */     Map<Integer, Integer> manekitokencfgid2count = new HashMap();
/* 281 */     for (Map.Entry<Integer, Integer> _e_ : _o_.manekitokencfgid2count.entrySet())
/* 282 */       manekitokencfgid2count.put(_e_.getKey(), _e_.getValue());
/* 283 */     return manekitokencfgid2count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInitrechargecount(long _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "initrechargecount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogLong(this, BackGameActivityRechargeInfo.this.initrechargecount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             BackGameActivityRechargeInfo.this.initrechargecount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.initrechargecount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccumulaterechargecount(long _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "accumulaterechargecount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogLong(this, BackGameActivityRechargeInfo.this.accumulaterechargecount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             BackGameActivityRechargeInfo.this.accumulaterechargecount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.accumulaterechargecount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     BackGameActivityRechargeInfo _o_ = null;
/* 333 */     if ((_o1_ instanceof BackGameActivityRechargeInfo)) { _o_ = (BackGameActivityRechargeInfo)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (this.initrechargecount != _o_.initrechargecount) return false;
/* 337 */     if (this.accumulaterechargecount != _o_.accumulaterechargecount) return false;
/* 338 */     if (!this.manekitokencfgid2count.equals(_o_.manekitokencfgid2count)) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ = (int)(_h_ + this.initrechargecount);
/* 348 */     _h_ = (int)(_h_ + this.accumulaterechargecount);
/* 349 */     _h_ += this.manekitokencfgid2count.hashCode();
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this.initrechargecount);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this.accumulaterechargecount);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.manekitokencfgid2count);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableChanged().setVarName("initrechargecount"));
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("accumulaterechargecount"));
/* 374 */     lb.add(new xdb.logs.ListenableMap().setVarName("manekitokencfgid2count"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.BackGameActivityRechargeInfo {
/*     */     private Const() {}
/*     */     
/*     */     BackGameActivityRechargeInfo nThis() {
/* 382 */       return BackGameActivityRechargeInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo copy()
/*     */     {
/* 394 */       return BackGameActivityRechargeInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo toData()
/*     */     {
/* 400 */       return BackGameActivityRechargeInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityRechargeInfo toBean()
/*     */     {
/* 405 */       return BackGameActivityRechargeInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo toDataIf()
/*     */     {
/* 411 */       return BackGameActivityRechargeInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityRechargeInfo toBeanIf()
/*     */     {
/* 416 */       return BackGameActivityRechargeInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInitrechargecount()
/*     */     {
/* 423 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 424 */       return BackGameActivityRechargeInfo.this.initrechargecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAccumulaterechargecount()
/*     */     {
/* 431 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 432 */       return BackGameActivityRechargeInfo.this.accumulaterechargecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getManekitokencfgid2count()
/*     */     {
/* 439 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 440 */       return xdb.Consts.constMap(BackGameActivityRechargeInfo.this.manekitokencfgid2count);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getManekitokencfgid2countAsData()
/*     */     {
/* 447 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/*     */       
/* 449 */       BackGameActivityRechargeInfo _o_ = BackGameActivityRechargeInfo.this;
/* 450 */       Map<Integer, Integer> manekitokencfgid2count = new HashMap();
/* 451 */       for (Map.Entry<Integer, Integer> _e_ : _o_.manekitokencfgid2count.entrySet())
/* 452 */         manekitokencfgid2count.put(_e_.getKey(), _e_.getValue());
/* 453 */       return manekitokencfgid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInitrechargecount(long _v_)
/*     */     {
/* 460 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAccumulaterechargecount(long _v_)
/*     */     {
/* 468 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return BackGameActivityRechargeInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return BackGameActivityRechargeInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return BackGameActivityRechargeInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return BackGameActivityRechargeInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       BackGameActivityRechargeInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return BackGameActivityRechargeInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return BackGameActivityRechargeInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return BackGameActivityRechargeInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return BackGameActivityRechargeInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return BackGameActivityRechargeInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return BackGameActivityRechargeInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return BackGameActivityRechargeInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.BackGameActivityRechargeInfo
/*     */   {
/*     */     private long initrechargecount;
/*     */     
/*     */     private long accumulaterechargecount;
/*     */     
/*     */     private HashMap<Integer, Integer> manekitokencfgid2count;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.manekitokencfgid2count = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.BackGameActivityRechargeInfo _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof BackGameActivityRechargeInfo)) { assign((BackGameActivityRechargeInfo)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof BackGameActivityRechargeInfo.Const)) assign(((BackGameActivityRechargeInfo.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(BackGameActivityRechargeInfo _o_) {
/* 597 */       this.initrechargecount = _o_.initrechargecount;
/* 598 */       this.accumulaterechargecount = _o_.accumulaterechargecount;
/* 599 */       this.manekitokencfgid2count = new HashMap();
/* 600 */       for (Map.Entry<Integer, Integer> _e_ : _o_.manekitokencfgid2count.entrySet()) {
/* 601 */         this.manekitokencfgid2count.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 606 */       this.initrechargecount = _o_.initrechargecount;
/* 607 */       this.accumulaterechargecount = _o_.accumulaterechargecount;
/* 608 */       this.manekitokencfgid2count = new HashMap();
/* 609 */       for (Map.Entry<Integer, Integer> _e_ : _o_.manekitokencfgid2count.entrySet()) {
/* 610 */         this.manekitokencfgid2count.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.initrechargecount);
/* 617 */       _os_.marshal(this.accumulaterechargecount);
/* 618 */       _os_.compact_uint32(this.manekitokencfgid2count.size());
/* 619 */       for (Map.Entry<Integer, Integer> _e_ : this.manekitokencfgid2count.entrySet())
/*     */       {
/* 621 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 622 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 630 */       this.initrechargecount = _os_.unmarshal_long();
/* 631 */       this.accumulaterechargecount = _os_.unmarshal_long();
/*     */       
/* 633 */       int size = _os_.uncompact_uint32();
/* 634 */       if (size >= 12)
/*     */       {
/* 636 */         this.manekitokencfgid2count = new HashMap(size * 2);
/*     */       }
/* 638 */       for (; size > 0; size--)
/*     */       {
/* 640 */         int _k_ = 0;
/* 641 */         _k_ = _os_.unmarshal_int();
/* 642 */         int _v_ = 0;
/* 643 */         _v_ = _os_.unmarshal_int();
/* 644 */         this.manekitokencfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       _size_ += CodedOutputStream.computeInt64Size(1, this.initrechargecount);
/* 655 */       _size_ += CodedOutputStream.computeInt64Size(2, this.accumulaterechargecount);
/* 656 */       for (Map.Entry<Integer, Integer> _e_ : this.manekitokencfgid2count.entrySet())
/*     */       {
/* 658 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 659 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         _output_.writeInt64(1, this.initrechargecount);
/* 670 */         _output_.writeInt64(2, this.accumulaterechargecount);
/* 671 */         for (Map.Entry<Integer, Integer> _e_ : this.manekitokencfgid2count.entrySet())
/*     */         {
/* 673 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 674 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             this.initrechargecount = _input_.readInt64();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             this.accumulaterechargecount = _input_.readInt64();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 712 */             int _k_ = 0;
/* 713 */             _k_ = _input_.readInt32();
/* 714 */             int readTag = _input_.readTag();
/* 715 */             if (24 != readTag)
/*     */             {
/* 717 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 719 */             int _v_ = 0;
/* 720 */             _v_ = _input_.readInt32();
/* 721 */             this.manekitokencfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityRechargeInfo toBean()
/*     */     {
/* 760 */       return new BackGameActivityRechargeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityRechargeInfo toBeanIf()
/*     */     {
/* 771 */       return new BackGameActivityRechargeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInitrechargecount()
/*     */     {
/* 808 */       return this.initrechargecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAccumulaterechargecount()
/*     */     {
/* 815 */       return this.accumulaterechargecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getManekitokencfgid2count()
/*     */     {
/* 822 */       return this.manekitokencfgid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getManekitokencfgid2countAsData()
/*     */     {
/* 829 */       return this.manekitokencfgid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInitrechargecount(long _v_)
/*     */     {
/* 836 */       this.initrechargecount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAccumulaterechargecount(long _v_)
/*     */     {
/* 843 */       this.accumulaterechargecount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (this.initrechargecount != _o_.initrechargecount) return false;
/* 852 */       if (this.accumulaterechargecount != _o_.accumulaterechargecount) return false;
/* 853 */       if (!this.manekitokencfgid2count.equals(_o_.manekitokencfgid2count)) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ = (int)(_h_ + this.initrechargecount);
/* 862 */       _h_ = (int)(_h_ + this.accumulaterechargecount);
/* 863 */       _h_ += this.manekitokencfgid2count.hashCode();
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this.initrechargecount);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this.accumulaterechargecount);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.manekitokencfgid2count);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BackGameActivityRechargeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */